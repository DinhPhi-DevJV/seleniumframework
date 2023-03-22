package javaBasic;

public class Topic_03_Compare {
	int number = 8;
	
	public static void main(String[] args) {
		int x =5; // 1 vùng nhớ cho biến x 
		int y = x; // 1 vùng nhớ cho biến y
		System.out.println("x =" +x);
		System.out.println("y =" +y);
		y =10; // cập nhật lại giá trị cho y còn x không được cập nhật
		System.out.println("x =" +x);
		System.out.println("y =" +y);	
		Topic_03_Compare firstVariablr = new Topic_03_Compare();
		Topic_03_Compare secondVariablr = firstVariablr;
		System.out.println("before =" + firstVariablr.number);
		System.out.println("before =" + secondVariablr.number);
		secondVariablr.number =15;
		System.out.println("after =" + firstVariablr.number);
		System.out.println("after =" + secondVariablr.number);
	}

}
