package javaOOP.abstraction;

import java.time.LocalDate;

public class GUI {
	LocalDate mylocal = LocalDate.now();
	public static void main(String[] args) {
		GUI gui = new GUI();
		System.out.println(gui.mylocal);
	}

}
