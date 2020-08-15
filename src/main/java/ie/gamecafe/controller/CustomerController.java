package ie.gamecafe.controller;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ie.gamecafe.dao.BookingDAO;
import ie.gamecafe.dao.CustomerDAO;
import ie.gamecafe.dao.PlacedOrderDAO;
import ie.gamecafe.dao.SlotDAO;
import ie.gamecafe.dao.TableDAO;
import ie.gamecafe.model.Booking;
import ie.gamecafe.model.BookingInformation;
import ie.gamecafe.model.Customer;
import ie.gamecafe.model.NewBooking;
import ie.gamecafe.model.Slot;
import ie.gamecafe.model.Table;

@Controller
public class CustomerController {

	@Autowired
	private SlotDAO slotDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private TableDAO tableDAO;
	@Autowired
	private BookingDAO bookingDAO;
	@Autowired
	private PlacedOrderDAO placedOrderDAO;

	// ------------------------------------------------------
	// Customer Login

	@RequestMapping(value = "/customerLogin")
	public ModelAndView customerLogin(ModelAndView model) throws IOException {
		Customer customerLogin = new Customer();
		model.addObject("customerLogin", customerLogin);
		model.setViewName("customerLogin");
		return model;
	}

	@RequestMapping(value = "/loginCustomer", method = RequestMethod.POST)
	public ModelAndView loginCustomer(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int existCustomer = customerDAO.althentication(username, password);

		if (existCustomer == 1) {
			// grant access
			Customer customer = new Customer();
			customer.setId(customerDAO.getCustomerId(username, password));
			int customerId = customer.getId();
			return new ModelAndView("redirect:/customerBookingInformation?id=" + customerId);

		} else {

			return new ModelAndView("redirect:/customerLogin");
		}

	}

	// --------------------------------------------------------
	// Booking

	@RequestMapping(value = "/newBooking", method = RequestMethod.GET)
	public ModelAndView newBooking(HttpServletRequest request) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView();
		NewBooking newBooking = new NewBooking();
		newBooking.setCustomerId(id);
		model.addObject("customerId", newBooking.getCustomerId());
		model.addObject("newBooking", newBooking);
		model.setViewName("newBooking");
		return model;
	}

	// This method will create the specific booking for the costumer
	@RequestMapping(value = "/createBooking", method = RequestMethod.POST)
	public ModelAndView createBooking(@ModelAttribute NewBooking newBooking) {

		int numPeople = newBooking.getNumPeople();
		String date = newBooking.getDate();
		String dayPeriod = newBooking.getDayPeriod();
		String foodService = newBooking.getFoodService();
		int customerId = newBooking.getCustomerId();

		boolean isOpen;

		// The cafe is closed on mondays, check if the date chosen is not monday
		isOpen = gameCafeIsOpen(date);
		if (isOpen == true) {

			// Check tables available for the number of people available
			List<Integer> allTableId = allTableId(numPeople);

			// If there are tables for the number required
			if (allTableId.size() > 0) {

				int avaliabilityCheck = avaliabilityCheck(date, dayPeriod, allTableId);
				// There is no booking for that date, period and table

				if (avaliabilityCheck > 0) {
					// Save new booking
					double bookingFee = 5.00;
					int bookingId = saveNewBooking(bookingFee, foodService, customerId);

					// Save new Slot
					saveNewSlot(date, dayPeriod, avaliabilityCheck, bookingId);

					Customer customer = new Customer();
					customer.setId(customerId);
					return new ModelAndView("redirect:/customerBookingInformation?id=" + customerId);

				} else {
					// not available, pls try again(handle that)
					return new ModelAndView("redirect:/newBooking?id=" + customerId);
				}
			} else {
				// handle there are no table available for that number of people
				return new ModelAndView("redirect:/newBooking?id=" + customerId);
			}
		} else {
			// handle cafe is closed
			return new ModelAndView("redirect:/newBooking?id=" + customerId);
		}
	}

	// Check if the cafe is open or not.
	// Based on code of @Author Nancy Den from TutorialsPoint (Reference:
	// https://www.tutorialspoint.com/how-to-check-whether-the-given-date-represents-weekend-in-java)
	public boolean gameCafeIsOpen(String slotDate) {

		boolean isOpen = true;

		// @Author mkyong (Reference:
		// https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/)
		LocalDate localDate = LocalDate.parse(slotDate);

		DayOfWeek day = DayOfWeek.of(localDate.get(ChronoField.DAY_OF_WEEK));

		switch (day) {

		case MONDAY:
			isOpen = false;
			return isOpen;

		default:
			return isOpen;
		}

	}

	// Return all tables id (in a array) for tables with the capacity (number of
	// people) requested by the customer
	public List<Integer> allTableId(int numPeople) {

		List<Integer> allTableId = new ArrayList<Integer>();
		List<Table> table = tableDAO.list();
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getNumPeople() == numPeople) {
				allTableId.add(table.get(i).getId());
			}
		}

		return allTableId;
	}

	// Check if the day and period is available for booking
	public int avaliabilityCheck(String date, String dayPeriod, List<Integer> tableId) {

		for (int i = 0; i < tableId.size(); i++) {

			int existBooking = slotDAO.althentication(date, dayPeriod, tableId.get(i));

			if (existBooking == 0) {
				return tableId.get(i);
			}
		}
		return 0;
	}

	// Creating a new Booking
	public int saveNewBooking(double bookingFee, String foodService, int customerId) {

		Booking createNewBooking = new Booking(0, bookingFee, foodService, customerId);

		bookingDAO.saveOrUpdate(createNewBooking);
		int newBookingId = bookingDAO.lastBookingId();

		return newBookingId;
	}

	// Creating a new Slot
	public void saveNewSlot(String date, String dayPeriod, int tableId, int bookingId) {

		Slot newSlot = new Slot(date, dayPeriod, tableId, bookingId);

		slotDAO.saveOrUpdate(newSlot);

	}

	// Delete Booking
	@RequestMapping(value = "/deleteBooking", method = RequestMethod.GET)
	public ModelAndView deletePlacedOrder(HttpServletRequest request) {
		int bookingId = Integer.parseInt(request.getParameter("id"));
		int customerId = Integer.parseInt(request.getParameter("customerId"));

		// if the customer has no order open
		int existOrder = placedOrderDAO.noOrderCheck(bookingId);
		if (existOrder == 0) {
			slotDAO.deleteAll(bookingId);
			bookingDAO.delete(bookingId);
			return new ModelAndView("redirect:/customerBookingInformation?id=" + customerId);
		} else {

			return new ModelAndView("redirect:/customerBookingInformation?id=" + customerId);
		}

	}
	// -------------------------------------------------------------------
	// CUSTOMER BOOKING INFORMATION

	@RequestMapping(value = "/customerBookingInformation", method = RequestMethod.GET)
	public ModelAndView customerAllBookings(HttpServletRequest request) throws IOException {

		int customerId = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView();
		BookingInformation customer = new BookingInformation();
		customer.setCustomerId(customerId);
		String name = customerDAO.getCustomerName(customerId);
		customer.setCustomerName(name);

		List<BookingInformation> customerAllBookings = bookingDAO.customerAllBookings(customerId);

		for (int i = 0; i < customerAllBookings.size(); i++) {

			if (customerAllBookings.get(i).getPeriod().contains("A")) {
				customerAllBookings.get(i).setPeriod("Afternoon");
			} else if (customerAllBookings.get(i).getPeriod().contains("N")) {
				customerAllBookings.get(i).setPeriod("Night");
			}

		}
		model.addObject("customerId", customer.getCustomerId());
		model.addObject("customerName", customer.getCustomerName());
		model.addObject("customerAllBookings", customerAllBookings);
		model.setViewName("customerBookingInformation");
		return model;

	}

}
