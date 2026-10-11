package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddessUtility {

	public static void main(String[] args) {
		getFakeAddress();

	}

	public static AddressPOJO getFakeAddress() {
		Faker faker = new Faker(Locale.US);
		String company = faker.company().name();
		String address1 = faker.address().streetAddress();
		String address2 = faker.address().secondaryAddress();
		String city = faker.address().city();
		String state = faker.address().state();
		String zipCode = faker.numerify("#####");
		String homePhone = faker.phoneNumber().cellPhone();
		String mobilePhone = faker.phoneNumber().cellPhone();
		String otherInformation = faker.lorem().sentence();
		String addressAlias = "Office Address";
		AddressPOJO addressPOJO = new AddressPOJO(company, address1, address2, city, zipCode, homePhone,
				mobilePhone, otherInformation, addressAlias,state);
		return addressPOJO;

	}
}
