package com.ui.pojo;

public class AddressPOJO {
private String company;
private String address1;
private String address2;
private String city;
private String zipCode;
private String homePhone;
private String mobilePhone;
private String otherInformation;
private String addressAlias;
private String state;


public AddressPOJO(String company, String address1, String address2, String city, String zipCode,
		String homePhone, String mobilePhone, String otherInformation, String addressAlias,String state) {
	super();
	this.company = company;
	this.address1 = address1;
	this.address2 = address2;
	this.city = city;
	this.zipCode = zipCode;
	this.homePhone = homePhone;
	this.mobilePhone = mobilePhone;
	this.otherInformation = otherInformation;
	this.addressAlias = addressAlias;
	this.state = state;

}
public String getCompany() {
	return company;
}
public String getAddress1() {
	return address1;
}
public String getAddress2() {
	return address2;
}
public String getCity() {
	return city;
}
public String getState() {
	return state;
}
public String getZipCode() {
	return zipCode;
}
public String getHomePhone() {
	return homePhone;
}
public String getMobilePhone() {
	return mobilePhone;
}
public String getOtherInformation() {
	return otherInformation;
}
public String getAddressAlias() {
	return addressAlias;
}
@Override
public String toString() {
	return "AddressPOJO [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
			+ ",zipCode=" + zipCode + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone
			+ ", otherInformation=" + otherInformation + ", addressAlias=" + addressAlias + ",state=" + state + "]";
}

}
