package com.ebanking.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "customer")
@Component
public class Customer {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;

	private String lastName;

	private int age;

	private String gender;

	private String city;

	private String occupation;

	private String email;

	private String contact;

	private long annualIncome;

	private String creditCard;

	private String accountType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Account> accounts = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Transaction> transaction = new ArrayList<>();

	public Customer() {
		super();

	}

	public Customer(int id, String firstName, String lastName, int age, String gender, String city, String occupation,
			String email, String contact, long annualIncome, String creditCard, String accountType,
			List<Account> accounts, List<Transaction> transaction) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.occupation = occupation;
		this.email = email;
		this.contact = contact;
		this.annualIncome = annualIncome;
		this.creditCard = creditCard;
		this.accountType = accountType;
		this.accounts = accounts;
		this.transaction = transaction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountType, accounts, age, annualIncome, city, contact, creditCard, email, firstName,
				gender, id, lastName, occupation, transaction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accountType, other.accountType) && Objects.equals(accounts, other.accounts)
				&& age == other.age && annualIncome == other.annualIncome && Objects.equals(city, other.city)
				&& Objects.equals(contact, other.contact) && Objects.equals(creditCard, other.creditCard)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(occupation, other.occupation) && Objects.equals(transaction, other.transaction);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
		accounts.forEach(entity -> entity.setCustomer(this));
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public void setCreditCard() {
		if (annualIncome > 1000000)
			this.creditCard = "Visa Infinite";
		else if (annualIncome > 800000 && annualIncome <= 1000000)
			this.creditCard = "Visa Platinum";
		else if (annualIncome > 500000 && annualIncome <= 800000)
			this.creditCard = "Visa Gold";
		else
			this.creditCard = "NA";
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", city=" + city + ", occupation=" + occupation + ", email=" + email
				+ ", contact=" + contact + ", annualIncome=" + annualIncome + ", creditCard=" + creditCard
				+ ", accountType=" + accountType + ", accounts=" + accounts + ", transaction=" + transaction + "]";
	}

}
