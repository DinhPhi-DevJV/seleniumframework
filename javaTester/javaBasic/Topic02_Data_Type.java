package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic02_Data_Type {
	// Prinmative type/ value type : kiểu dữ liệu nguyên thủy. -> không có bất kì funtion nào
	byte bNumber;
	short sNumber;
	int iNumber;
	long lNumber;
	float fNumber;
	double dNumber;
	char cCharacter;
	boolean bBoolean;
	//----------------------------------------------
	
	// priferentce type : kiểu dữ liệu tham chiếu. -> nó có các funtion < cách lưu trữ dữ liệu khác nhau>
	// String
	String address = " ho chi minh";
	// Array : kiểu dữ liệu được định nghĩa trước size.chứa tập hợp nhiều dữ liệu
	// cùng kiểu.
	String[] studen = { address, "hanoi", "danang" };
	Integer[] studentNumber = { 12, 15, 10, 20 };
	// Class
	Topic02_Data_Type topic = new Topic02_Data_Type();
	// Interface
	WebDriver driver;
	// Object
	Object object;
	// Colection
	// List/Set//Queue/Map
	List<WebElement> homePageLinks=  driver.findElements(By.xpath(""));
	// list lưu trùng.
	Set<String> allWindows = driver.getWindowHandles();
	// set không lưu trùng
	List<String>  productName = new ArrayList<String>();	
	
	//-------------------------------------------------------
	
	
	// gán dữ liệu cũng sử dụng được
	// có giá trị mặc định khi khai báo
	/*
	 * static int number; String address = " ho chi minh";
	 * 
	 * public static void main(String[] args) { // Local variable phải được khởi tạo
	 * giá trị. //main cung la 1 function. khi chay gọi hàm main trước. int
	 * studentNumber = 0; Topic02_Data_Type topic = new Topic02_Data_Type();
	 * System.out.println(number); System.out.println(studentNumber);
	 * System.out.println(topic.address); }
	 */
}
