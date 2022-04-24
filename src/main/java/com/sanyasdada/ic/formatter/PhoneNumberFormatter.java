package com.sanyasdada.ic.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.sanyasdad.ic.dto.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {

		System.out.println("inside the print method  of  the formatter method");

		return phone.getCountryCode() + "-" + phone.getUserNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		System.out.println("Inside the print method of the PhoneNumberFormatter");
		Phone phone = new Phone();
		String[] phoneNumberArray = completePhoneNumber.split("-");
		// whether the number consists of -
		int index = completePhoneNumber.indexOf('-');
		boolean ok = completePhoneNumber.startsWith("-");
		if (index == -1 || ok) {

			// if the '-' is not found, the add 91 as the default country code

			phone.setCountryCode("977");
			if (completePhoneNumber.startsWith("-")) {
				phone.setUserNumber(phoneNumberArray[1]);
			} else {
				phone.setUserNumber(phoneNumberArray[0]);
			}

		} else {

			// Extract the countryCode and set it to the phone class countryCodeProperty

			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);

		}

		// split the string received from the user

		return phone;
	}

}
