package javaException;

public class TryCatchException {
	public static void main(String[] args) {
		int number = 10;
		try {

			number = number / 0;
			System.out.println(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(number);

	}

}
