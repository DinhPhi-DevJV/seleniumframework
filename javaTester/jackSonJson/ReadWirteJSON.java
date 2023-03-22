package jackSonJson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadWirteJSON {
	public static void main(String[] args) {
		ReadWirteJSON readWirteJSON = new ReadWirteJSON();
		try {
			Students student = new Students();
			student.setAge(1);
			student.setName("asdadad");
			readWirteJSON.writeJSON(student);
			Students student1 = readWirteJSON.readJson();
			System.out.println(student1);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeJSON(Students student) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(""), student);
	}

	private Students readJson() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Students student = mapper.readValue(new File(""), Students.class);
		return student;
	}
}

class Students {
	private String name;
	private int age;

	public Students() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Student [ name :" + name + ", age:" + age + " ]";
	}
}
