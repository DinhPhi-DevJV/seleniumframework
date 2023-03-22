package javaOOP.inheritance;

public class Dog extends Animal {

	String ten;

	public Dog() {

		System.out.println("Child 's constructor");
	}

	public Dog(String ten) {
		super("nani");
		this.ten = ten;

	}

	public void show() {
		super.show();
		System.out.println(ten);
	}

	public static void main(String[] args) {
		Dog dog = new Dog("cho");
		dog.show();
		System.out.println(dog.hashCode()+dog.toString());
	}
}
