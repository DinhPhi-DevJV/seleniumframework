package javaBasic;

import java.io.File;

import org.testng.annotations.Test;

import commons.GlobalConstants;

public class Toppic_11_Array {
	@Test
	public void TC_01() {
		String[] fielNames = { "Csharp.jpg", "Java.jpg", "Python.jpg" };
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (int t = 0; t < fielNames.length; t++) {
			fullFileName = fullFileName + filePath+fielNames[t]+"\n";
		}
		fullFileName = fullFileName.trim();
		System.out.println( fullFileName);

	}
}
