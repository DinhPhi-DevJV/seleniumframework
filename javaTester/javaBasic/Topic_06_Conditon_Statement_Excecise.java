package javaBasic;

import java.util.Scanner;

public class Topic_06_Conditon_Statement_Excecise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập vào tham số");
		int inputNumber = sc.nextInt();
		if (inputNumber % 2 == 0) {
			System.out.println("bạn nhập số chẳn");
		} else {
			System.out.println("bạn nhập sô lẻ");
		}
		System.out.println("nhập vào tham số 1");
		int inputNumber1 = sc.nextInt();
		System.out.println("nhập vào tham số 2");
		int inputNumber2 = sc.nextInt();
		System.out.println("nhập vào tham số 3");
		int inputNumber3 = sc.nextInt();
		if (inputNumber1 > inputNumber2 && inputNumber1 > inputNumber3) {
			System.out.println(inputNumber1 + " là lớn nhất");
		} else if (inputNumber2 > inputNumber3) {
			System.out.println(inputNumber2 + " là lớn nhất");
		} else {
			System.out.println(inputNumber3 + "là lớn nhất");
		}
		sc.close();
		// --------------------------
		int age = 20;
		String access = (age < 10) ? "you can not access" : "wellcome to our system!";
		System.out.println(access);
	}

}
