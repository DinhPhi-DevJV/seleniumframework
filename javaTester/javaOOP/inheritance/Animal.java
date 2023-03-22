package javaOOP.inheritance;

public class Animal {
	String loaiDongVat;

	public Animal() {
		System.out.println("Parents 's constructor");
	}

	public Animal(String loaiDongVat) {
		this.loaiDongVat = loaiDongVat;
	}
	protected void show() {
		System.out.println(loaiDongVat);
	}
}
