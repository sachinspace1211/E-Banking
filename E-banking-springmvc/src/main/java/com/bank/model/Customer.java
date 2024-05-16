package com.bank.model;

public class Customer {

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

	public Customer() {

	}

	public Customer(String firstName, String lastName, int age, String gender, String city, String occupation,
			String email, String contact, long annualIncome, String creditCard, String accountType) {
		super();
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
	}

	public Customer(int id, String firstName, String lastName, int age, String gender, String city, String occupation,
			String email, String contact, long annualIncome, String creditCard, String accountType) {
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

	public void setCreditCard() {
		if (annualIncome > 1000000)
			this.creditCard = "Visa Infinite";
		else if (annualIncome > 800000 && annualIncome <= 1000000)
			this.creditCard = "Visa Platinum";
		else if (annualIncome > 500000 && annualIncome <= 800000)
			this.creditCard = "Visa Gold";
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", city=" + city + ", occupation=" + occupation + ", email=" + email
				+ ", contact=" + contact + ", annualIncome=" + annualIncome + ", creditCard=" + creditCard
				+ ", accountType=" + accountType + "]";
	}
}
