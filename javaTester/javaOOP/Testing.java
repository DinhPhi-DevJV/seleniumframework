package javaOOP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testing {
	public static void main(String[] args) {
		Toppic_06_Getter_Setter toppic = new Toppic_06_Getter_Setter();
		toppic.personName = "atomation";
		toppic.personAge = -0;
		WebDriver driver = new FirefoxDriver();
	
	}

}
