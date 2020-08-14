package ie.gamecafe.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ie.gamecafe.dao.AddressDAO;
import ie.gamecafe.dao.BookingDAO;
import ie.gamecafe.dao.CustomerDAO;
import ie.gamecafe.dao.EircodeDAO;
import ie.gamecafe.dao.OrderLineDAO;
import ie.gamecafe.dao.PlacedOrderDAO;
import ie.gamecafe.dao.StaffDAO;
import ie.gamecafe.model.Address;
import ie.gamecafe.model.Bill;
import ie.gamecafe.model.BookingInformation;
import ie.gamecafe.model.Eircode;
import ie.gamecafe.model.NewStaff;
import ie.gamecafe.model.OrderLine;
import ie.gamecafe.model.PlacedOrder;
import ie.gamecafe.model.Staff;

@Controller
public class StaffController {

	@Autowired
	private StaffDAO staffDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private BookingDAO bookingDAO;
	@Autowired
	 private PlacedOrderDAO placedOrderDAO;
	@Autowired
	 private OrderLineDAO orderLineDAO;
	@Autowired
	 private AddressDAO addressDAO;
	@Autowired
	 private EircodeDAO eircodeDAO;
	
		// ------------------------------------------------------
		// Staff Login

		@RequestMapping(value = "/staffLogin")
		public ModelAndView staffLogin(ModelAndView model) throws IOException {
			Staff staffLogin = new Staff();
			model.addObject("staffLogin", staffLogin);
			model.setViewName("staffLogin");
			return model;
		}

		@RequestMapping(value = "/loginStaff", method = RequestMethod.POST)
		public ModelAndView loginStaff(HttpServletRequest request) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			int existStaff = staffDAO.althentication(username, password);

			if (existStaff == 1) {
				// grant access
				Staff staff = new Staff();
				staff.setId(staffDAO.getStaffId(username, password));
				int staffId = staff.getId();
				return new ModelAndView("redirect:/staffBookingInformation?id=" + staffId);

			} else {

				return new ModelAndView("redirect:/staffLogin");
			}

		}

		// ------------------------------------------------------
		// ORDER

		@RequestMapping(value = "/orders", method = RequestMethod.GET)
		public ModelAndView listCategory(ModelAndView model, HttpServletRequest request) throws IOException {
			int staffId = Integer.parseInt(request.getParameter("id"));
			Staff staff = new Staff();
			staff.setId(staffId);
			List<PlacedOrder> listPlacedOrder = placedOrderDAO.list();
			model.addObject("staffId", staff.getId());
			model.addObject("listPlacedOrder", listPlacedOrder);
			model.setViewName("orders");
			return model;

		}

		@RequestMapping(value = "/newOrder", method = RequestMethod.GET)
		public ModelAndView newPlacedOrder(HttpServletRequest request) throws IOException {

			int staffId = Integer.parseInt(request.getParameter("id"));
			ModelAndView model = new ModelAndView();
			Staff staff = new Staff();
			staff.setId(staffId);
			
			PlacedOrder newPlacedOrder = new PlacedOrder();
			newPlacedOrder.setStaffId(staffId);
			
			model.addObject("staffId", staff.getId());
			model.addObject("placedOrder", newPlacedOrder);
			model.setViewName("newOrder");
			return model;
		}

		@RequestMapping(value = "/savePlacedOrder", method = RequestMethod.POST)
		public ModelAndView savePlacedOrder(@ModelAttribute PlacedOrder placedOrder) {
			placedOrderDAO.saveOrUpdate(placedOrder);
			int newOrderId = placedOrderDAO.lastOrderId();

			return new ModelAndView("redirect:/addNewItem?id=" + newOrderId + "&staffId=" + placedOrder.getStaffId());
		}

		@RequestMapping(value = "/deletePlacedOrder", method = RequestMethod.GET)
		public ModelAndView deletePlacedOrder(HttpServletRequest request) {
			int placedOrderId = Integer.parseInt(request.getParameter("id"));
			int staffId = Integer.parseInt(request.getParameter("staffId"));
			orderLineDAO.deleteAll(placedOrderId);
			placedOrderDAO.delete(placedOrderId);
			return new ModelAndView("redirect:/orders?id=" + staffId);
		}
		// ------------------------------------------------------------------------
		// Ordem Items

		@RequestMapping(value = "/viewItems", method = RequestMethod.GET)
		public ModelAndView viewItems(HttpServletRequest request) throws IOException {

			int id = Integer.parseInt(request.getParameter("id"));
			int staffId = Integer.parseInt(request.getParameter("staffId"));
			
			ModelAndView model = new ModelAndView();
			OrderLine orderLine = new OrderLine();
			orderLine.setOrderId(id);
			Staff staff= new Staff();
			staff.setId(staffId);
			
			int orderId = orderLine.getOrderId();

			List<Bill> viewItems = orderLineDAO.printBill(orderId);

			model.addObject("staffId", staff.getId());
			model.addObject("viewItems", viewItems);
			model.addObject("orderLine", orderLine);
			model.setViewName("viewItems");
			return model;
		}

		@RequestMapping(value = "/addNewItem", method = RequestMethod.GET)
		public ModelAndView newOrderLine(HttpServletRequest request) throws IOException {

			int id = Integer.parseInt(request.getParameter("id"));
			int staffId = Integer.parseInt(request.getParameter("staffId"));
			ModelAndView model = new ModelAndView();
			
			Staff staff= new Staff();
			staff.setId(staffId);
			OrderLine newOrderLine = new OrderLine();
			newOrderLine.setStaffId(staffId);
			
			newOrderLine.setOrderId(id);
			model.addObject("staffId", staff.getId());
			model.addObject("orderLine", newOrderLine);
			model.setViewName("addNewItem");
			return model;
		}

		@RequestMapping(value = "/saveOrderLine", method = RequestMethod.POST)
		public ModelAndView saveOrderLine(@ModelAttribute OrderLine orderLine) {
			orderLineDAO.saveOrUpdate(orderLine);
			int staffId = orderLine.getStaffId();

			return new ModelAndView("redirect:/orders?id=" + staffId);

		}

		@RequestMapping(value = "/deleteOrderLine", method = RequestMethod.GET)
		public ModelAndView deleteOrderLine(HttpServletRequest request) {

			int orderId = Integer.parseInt(request.getParameter("orderId"));
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int staffId = placedOrderDAO.staffId(orderId);

			orderLineDAO.delete(orderId, itemId);
			return new ModelAndView("redirect:/orders?id=" + staffId);
		}

		@RequestMapping(value = "/editOrderLine", method = RequestMethod.GET)
		public ModelAndView editOrderLine(HttpServletRequest request) {

			int orderId = Integer.parseInt(request.getParameter("orderId"));
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int staffId = Integer.parseInt(request.getParameter("staffId"));
			
			Staff staff= new Staff();
			staff.setId(staffId);
			OrderLine orderLine = orderLineDAO.get(orderId, itemId);
			
			ModelAndView model = new ModelAndView("addNewItem");
			model.addObject("staffId", staff.getId());
			model.addObject("orderLine", orderLine);

			return model;

		}

		// -------------------------------------------------------------------
		// PRINT BILL
		@RequestMapping(value = "/printBill", method = RequestMethod.GET)
		public ModelAndView printBill(HttpServletRequest request) throws IOException {

			int orderId = Integer.parseInt(request.getParameter("id"));
			int staffId = Integer.parseInt(request.getParameter("staffId"));
			
			Staff staff= new Staff();
			staff.setId(staffId);
			
			ModelAndView model = new ModelAndView();
			List<Bill> printBill = orderLineDAO.printBill(orderId);
			double totalPrice = 0;
			int quantity = 0;
			double price = 0;

			for (int i = 0; i < printBill.size(); i++) {

				quantity = printBill.get(i).getQuantity();
				price = printBill.get(i).getPrice();

				totalPrice += quantity * price;
			}

			totalPrice += 5.00;

			model.addObject("printBill", printBill);
			model.addObject("totalPrice", totalPrice);
			model.addObject("staffId", staff.getId());

			return model;
		}

		// -------------------------------------------------------------------
		// Staff List

		@RequestMapping(value = "/staffList", method = RequestMethod.GET)
		public ModelAndView list(HttpServletRequest request) throws IOException {

			int staffId = Integer.parseInt(request.getParameter("id"));
			Staff staff = new Staff();
			staff.setId(staffId);
			ModelAndView model = new ModelAndView();
			
			// Grant access to Admin (id = 1)
			if (staff.getId() == 1) {

				List<Staff> listStaff = staffDAO.list();
				model.addObject("staffId", staffId);
				model.addObject("listStaff", listStaff);
				model.setViewName("staffDetails");
				return model;

			} else {
				return new ModelAndView("redirect:/staffBookingInformation?id=" + staffId);
			}

		}


		@RequestMapping(value = "/newStaff", method = RequestMethod.GET)
		public ModelAndView newStaff(HttpServletRequest request) throws IOException {
			int staffId = Integer.parseInt(request.getParameter("staffId"));
			Staff staff = new Staff();
			staff.setId(staffId);
			
			ModelAndView model = new ModelAndView();
			
			Staff newStaff = new Staff();
			
			model.addObject("staffId", staff.getId());
			model.addObject("staff", newStaff);
			model.setViewName("staffForm");
			return model;
		}

		@RequestMapping(value = "/saveStaff", method = RequestMethod.POST)
		public ModelAndView saveCustomer(@ModelAttribute NewStaff newStaff) {

			String firstName = newStaff.getFirstName();
			String surname = newStaff.getSurname();
			String email = newStaff.getEmail();
			int phone = newStaff.getPhone();
			String username = newStaff.getUsername();
			String password = newStaff.getPassword();
			String jobTitle = newStaff.getJobTitle();
			Date birthDate = newStaff.getBirthDate();
			Date hireDate = newStaff.getHireDate();
			String address = newStaff.getAddress();
			String eircode = newStaff.getEircode();

			//for now is known that admin staff is 1. In the future this code is expected to be improved to pass the id from the url
			int staffId = 1;
			
			int addressId = checkOrCreateNewAddress(address, eircode);


			int emailCheck = customerDAO.emailCheck(email);
			int usernameCheck = customerDAO.usernameCheck(username);
			int phoneCheck = customerDAO.phoneCheck(phone);

			if (!(addressId == 0) && (emailCheck == 0) && (usernameCheck == 0) && (phoneCheck == 0)) {

				Staff staff = new Staff(0, firstName, surname, email, phone, jobTitle, username, password, birthDate, hireDate,
						addressId);

				staffDAO.saveOrUpdate(staff);
				return new ModelAndView("redirect:/staffList?id=" + staffId);
			}

			return new ModelAndView("redirect:/staffBookingInformation?id=" + staffId);
		}
		
		public int checkOrCreateNewAddress(String address, String eircode) {

			int eircodeId;
			int addressId;
			int newAddressId;
			int eircodeExist = eircodeDAO.checkForExistentEircode(eircode);
			int addressExist = addressDAO.checkForExistentAddress(address);


			if (eircodeExist == 0 && addressExist == 0) {
				Eircode newEircode = new Eircode(0, eircode);
				eircodeDAO.saveOrUpdate(newEircode);
				eircodeId = eircodeDAO.getEircodeId(eircode);

				Address newAddress = new Address(0, address, eircodeId);
				addressDAO.saveOrUpdate(newAddress);
				addressId = addressDAO.getAddressId(address);

				return addressId;
			}

			else if (eircodeExist == 1 && addressExist == 1) {
				eircodeId = eircodeDAO.getEircodeId(eircode);
				addressId = addressDAO.getAddressId(address);
				int existBoth = addressDAO.checkForAddressIdAndEircodeId(addressId, eircodeId);

				if (existBoth == 1) {
					newAddressId = addressDAO.getNewAddressId(address, eircodeId);
					return newAddressId;
				} else if (existBoth == 0) {

					return 0;
				}
			}
			return 0;
		}


		@RequestMapping(value = "/deleteStaff", method = RequestMethod.GET)
		public ModelAndView deleteStaff(HttpServletRequest request) {
			int staffId = Integer.parseInt(request.getParameter("id"));
			staffDAO.delete(staffId);
			return new ModelAndView("redirect:/staffList");
		}

		@RequestMapping(value = "/editStaff", method = RequestMethod.GET)
		public ModelAndView editStaff(HttpServletRequest request) {
			int staffId = Integer.parseInt(request.getParameter("id"));
			Staff staff = staffDAO.get(staffId);
			ModelAndView model = new ModelAndView("staffForm");
			model.addObject("staff", staff);

			return model;
		}

		// -------------------------------------------------------------------
		// STAFF BOOKING INFORMATION

		@RequestMapping(value = "/staffBookingInformation", method = RequestMethod.GET)
		public ModelAndView staffAllBookings(HttpServletRequest request) throws IOException {

			int staffId = Integer.parseInt(request.getParameter("id"));
			Staff staff = new Staff();
			staff.setId(staffId);
			ModelAndView model = new ModelAndView();

			List<BookingInformation> viewAllBookings = bookingDAO.viewAllBookings();

			for (int i = 0; i < viewAllBookings.size(); i++) {

				int id = viewAllBookings.get(i).getCustomerId();
				String name = customerDAO.getCustomerName(id);
				viewAllBookings.get(i).setCustomerName(name);

				if (viewAllBookings.get(i).getPeriod().contains("A")) {
					viewAllBookings.get(i).setPeriod("Afternoon");
				} else if (viewAllBookings.get(i).getPeriod().contains("N")) {
					viewAllBookings.get(i).setPeriod("Night");
				}

			}

			model.addObject("staffId", staff.getId());
			model.addObject("viewAllBookings", viewAllBookings);
			model.setViewName("staffBookingInformation");
			return model;

		}

	}
