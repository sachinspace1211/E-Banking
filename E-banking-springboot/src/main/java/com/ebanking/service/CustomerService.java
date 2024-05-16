package com.ebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ebanking.entities.Customer;
import com.ebanking.repository.CustomerRepository;

@Component
@Service("customerService")
public class CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public Customer add(Customer customer) {
		return customerRepository.save(customer);
    }
	
	public Customer update(Customer customer) {
		
		Optional<Customer> optional = this.customerRepository.findById(customer.getId());
		
			Customer newCustomer = optional.get();
			
			newCustomer.setFirstName(customer.getFirstName());
			newCustomer.setLastName(customer.getLastName());
			newCustomer.setAge(customer.getAge());
			newCustomer.setCity(customer.getCity());
			newCustomer.setAccountType(customer.getAccountType());
			newCustomer.setAccounts(customer.getAccounts());
			newCustomer.setAnnualIncome(customer.getAnnualIncome());
			newCustomer.setContact(customer.getContact());
			newCustomer.setGender(customer.getGender());
			newCustomer.setEmail(customer.getEmail());
			newCustomer.setOccupation(customer.getOccupation());
			newCustomer.setCreditCard();
			
			return this.customerRepository.save(newCustomer);	
    }
	
	public List<Customer> getAllCustomer(){
		return this.customerRepository.findAll();
	}

	public Customer getCustomerById(Integer id) {
		return this.customerRepository.findById(id).get();
	}
	
	public Integer getId() {
	    Integer maxId = this.customerRepository.max();
	    if( maxId==null)
	    	return 1000;
		return maxId+1;
	}
}
