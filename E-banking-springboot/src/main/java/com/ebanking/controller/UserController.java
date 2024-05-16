package com.ebanking.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebanking.entities.Account;
import com.ebanking.entities.Customer;
import com.ebanking.entities.Transaction;
import com.ebanking.entities.User;
import com.ebanking.exception.ErrorMessage;
import com.ebanking.service.AccountService;
import com.ebanking.service.CustomerService;
import com.ebanking.service.TransactionService;
import com.ebanking.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final String MESSAGE = "Error Occured!!";

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	static Integer accountNumber = 1000000;
	
	String username;

	// this handler used for common data available to every handler
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		username = principal.getName();
		User user = this.userService.getUser(username);
		model.addAttribute("user", user);
	}

	// this handler for showing dash-board
	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {
		model.addAttribute("title", "User Dashboard");
		return "normal/user_dashboard";
	}

	// this handler for showing add customer form
	@GetMapping("/add-customer")
	public String openAddCustomerForm(Model model) {
		model.addAttribute("title", "Add Customer");
		model.addAttribute("customer", new Customer());
		return "normal/add_customer";
	}

	// this handler for adding customer Details
	@PostMapping("/process-customer")
	public String processData(@ModelAttribute("customer") Customer customer, BindingResult result, HttpSession session,
			Principal principal, Model model) {
		customer.setId(customerService.getId());
		customer.setCreditCard();
		List<Account> list = new ArrayList<>();
		Account account = new Account();
		account.setAccountType(customer.getAccountType());
		account.setAccountNumber(accountService.getAccountNumber());
		list.add(account);
		customer.setAccounts(list);

		if (customerService.add(customer) == null) {
			LOGGER.info("\n\n****Customer not added successfully****\n");
			throw new ErrorMessage(MESSAGE, "Customer not added successfully",username);
		} else {
			LOGGER.info("\n\n****Customer added successfully****\n");
			return "normal/customer_success";
		}
	}

	// this handler for showing customer page
	@GetMapping("/show-customer/{page}")
	public String showContacts(@PathVariable("page") Integer page, Model model, Principal principal) {
		model.addAttribute("title", "Show Customer");
		List<Customer> customer = this.customerService.getAllCustomer();
		if (customer.isEmpty()) {
			LOGGER.info("\n\n****No customer found****\n");
			throw new ErrorMessage(MESSAGE,"No customer found",username);
		} else {
			LOGGER.info("\n\n****Customer found successfully****\n");
			model.addAttribute("customer", customer);
			return "normal/show_customer";
		}
	}

	// this handler for showing update customer form
	@GetMapping("/update-customer/{id}")
	public String updateCustomer(@PathVariable("id") Integer id, Model model) {
		Customer customer = this.customerService.getCustomerById(id);
		model.addAttribute("title", "Update Contact");
		model.addAttribute("customer", customer);
		return "normal/update_customer";
	}

	// this handler for updating customer details
	@PostMapping("/update-customer-info")
	public String updateCustomerProcess(@ModelAttribute("customer") Customer customer, BindingResult result,
			Principal principal, Model model, HttpSession session) {
		customer.setCreditCard();
		if (this.customerService.update(customer) == null) {
			LOGGER.info("\n\n****Customer not updated successfully****\n");
			throw new ErrorMessage(MESSAGE, "Customer not updated successfully",username);
		} else {
			LOGGER.info("\n\n****Customer updated successfully****\n");
			return "normal/successfull_update_cust";
		}

	}

	// this handler for showing add account form
	@GetMapping("/add-account/{id}")
	public String addAccount(@PathVariable("id") Integer id, Model model) {
		Customer customer = this.customerService.getCustomerById(id);
		model.addAttribute("title", "Add Account");
		model.addAttribute("customer", customer);
		return "normal/add_account";
	}

	// this handler for adding account for customer
	@PostMapping("/process-account")
	public String processAddAccount(@ModelAttribute("customer") Customer customer, BindingResult result,
			HttpSession session, Model model) {
		Account account = new Account();
		account.setCustomer(customer);
		account.setAccountType(customer.getAccountType());
		account.setAccountNumber(accountService.getAccountNumber());
		account = this.accountService.add(account);
		if(account==null) {
			LOGGER.info("\n\n****Account not added successfully****\n");
			throw new ErrorMessage(MESSAGE, "Account not added successfully",username);
		}
		else {
			LOGGER.info("\n\n****Account added successfully****\n");
			model.addAttribute("account", account);
			return "normal/success_add_account";
		}
	}

	// this handler for showing transaction form
	@GetMapping("/view-transaction/{id}")
	public String viewTransaction(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("title", "view transaction");
		model.addAttribute("id", id);
		return "normal/view_transaction";
	}

	// this handler for showing transaction details for customer
	@PostMapping("/process-transaction")
	public String processTransaction(@RequestParam("id") int id, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, HttpSession session, Model model,Principal principal) throws ParseException {

		Date tDate = new SimpleDateFormat("yyy-MM-dd").parse(toDate);
		Date fDate = new SimpleDateFormat("yyy-MM-dd").parse(fromDate);
	
		if (fDate.compareTo(tDate) >= 0) {
			LOGGER.info("\n\n****From Date is not greater than To Date****\n");
			LOGGER.info("\n\n****From Date is not greater than To Date****\n");
			throw new ErrorMessage(MESSAGE, "From Date is not greater than To Date",username);
		}
		List<Transaction> allTransaction = this.transactionService.getAllTransactions();
		List<Transaction> list = new ArrayList<>();

		for (Transaction t : allTransaction) {
			Date date = new SimpleDateFormat("yyyy-MM-dd")
					.parse(new SimpleDateFormat("yyyy-MM-dd").format(t.getDate()));
			if (t.getCustomer().getId() == id && date.compareTo(fDate) >= 0 && date.compareTo(tDate) <= 0) {
				list.add(t);
			}
		}
		if (list.isEmpty()) {
			
			throw new ErrorMessage("Transaction", "No Transaction Found",username);
		}
		model.addAttribute("toDate", toDate);
		model.addAttribute("fromDate", fromDate);
		model.addAttribute("transaction", list);

		return "normal/print_transaction";
	}

}
