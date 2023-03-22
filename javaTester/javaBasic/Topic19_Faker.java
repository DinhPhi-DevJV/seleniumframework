package javaBasic;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic19_Faker {
	public static void main(String[] args) {
		Faker faker = new Faker();
		faker.business().creditCardType();	
	}

}
