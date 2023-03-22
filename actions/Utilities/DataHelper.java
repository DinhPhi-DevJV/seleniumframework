package Utilities;

import com.github.javafaker.Faker;

public class DataHelper {
	//US

	private Faker faker = new Faker();

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	public String getFirstName() {
		return faker.name().firstName();
	}
	public String getLastName() {
		return faker.name().lastName();
	}
	public String getEamilAddress() {
		return faker.internet().emailAddress();
	}
	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	public String getCityName() {
		return faker.address().cityName();
	}
	public String getPassword() {
		return faker.internet().password(8,12,true,true);
	}
	
}
