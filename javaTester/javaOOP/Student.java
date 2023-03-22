package javaOOP;

public class Student extends Person {
	@Override
	public void eat() {
		super.eat();
	}

	public static void main(String[] args) {
		Student st = new Student();
		st.eat();
	}
}
