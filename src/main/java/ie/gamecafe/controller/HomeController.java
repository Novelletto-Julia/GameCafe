package ie.gamecafe.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ie.gamecafe.dao.AddressDAO;
import ie.gamecafe.dao.CustomerDAO;
import ie.gamecafe.dao.EircodeDAO;
import ie.gamecafe.dao.ItemDAO;
import ie.gamecafe.dao.SlotDAO;
import ie.gamecafe.model.Address;
import ie.gamecafe.model.Customer;
import ie.gamecafe.model.Eircode;
import ie.gamecafe.model.Item;
import ie.gamecafe.model.Register;
import ie.gamecafe.model.Slot;


@Controller
public class HomeController {

	@Autowired
	 private SlotDAO slotDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	 private ItemDAO itemDAO;
	@Autowired
	 private EircodeDAO eircodeDAO;
	@Autowired
	 private AddressDAO addressDAO;
	

	@RequestMapping(value = "/")
		public ModelAndView listOrderLine(ModelAndView model) throws IOException {
			List<Slot> list = slotDAO.list();
			model.addObject("listSlot", list);
			model.setViewName("index");
			return model;
		}

		@RequestMapping(value = "/aboutUs")
		public ModelAndView aboutUs(ModelAndView model) throws IOException {
			model.setViewName("about");
			return model;
		}

		// ------------------------------------------------------
		// REGISTER
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView newCustomer(ModelAndView model) {
			Register newCustomer = new Register();
			model.addObject("newCustomer", newCustomer);
			model.setViewName("register");
			return model;
		}

		@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
		public ModelAndView saveCustomer(@ModelAttribute Register register) {

			String firstName = register.getFirstName();
			String surname = register.getSurname();
			String email = register.getEmail();
			int phone = register.getPhone();
			String username = register.getUsername();
			String password = register.getPassword();
			Date birthDate = register.getBirthDate();
			String address = register.getAddress();
			String eircode = register.getEircode();

			int addressId = checkOrCreateNewAddress(address, eircode);


			int emailCheck = customerDAO.emailCheck(email);
			int usernameCheck = customerDAO.usernameCheck(username);
			int phoneCheck = customerDAO.phoneCheck(phone);

			if (!(addressId == 0) && (emailCheck == 0) && (usernameCheck == 0) && (phoneCheck == 0)) {

				Customer customer = new Customer(0, firstName, surname, email, phone, username, password, birthDate,
						addressId);
				customerDAO.saveOrUpdate(customer);
				return new ModelAndView("redirect:/customerLogin");
			}

			return new ModelAndView("redirect:/register");
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

			//-------------------------------------------------------------------
			//ITEMS MENU
			 @RequestMapping(value="/itemsMenu")
			 public ModelAndView listItem(ModelAndView model) throws IOException{
			     
				 List<Item> listItem = itemDAO.list();
				 List<Item> listFood = new ArrayList<Item>();
				 List<Item> listDrinks = new ArrayList<Item>();
				 List<Item> listGames = new ArrayList<Item>();
				 
			     for(int i=0; i< listItem.size(); i++) {
			    	 
			    	 if(listItem.get(i).getCategoryId() == 1) {
				    	listDrinks.add(listItem.get(i));
				    	
				     }else if(listItem.get(i).getCategoryId() == 3) {
				    	 listFood.add(listItem.get(i));
				    	 
				     }else if(listItem.get(i).getCategoryId() == 4) {
				    	 listGames.add(listItem.get(i));
				     }
			     }
			     
			     model.addObject("listDrinks", listDrinks);
			     model.addObject("listFood", listFood);
			     model.addObject("listGames", listGames);
			     model.setViewName("itemsMenu");
			     return model;
			     
			 }

			
			
	}
