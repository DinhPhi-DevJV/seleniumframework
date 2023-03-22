package javaBasic;

public class FormathString {
	public static void main(String[] args) {
		String name = SetName("Phi");
		System.out.println(name );
	}
	public static String SetName(String lastName) {
		String name = " NGUYEN DINH %s";
		String fullName = name.format(name, lastName);
		return fullName;
	}

}
