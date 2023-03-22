package com.notcommerce.data;

import java.io.File;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

public class UserDataMapper {

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/UserData.json"),UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAddress")
	private String emailAddress;

	@JsonProperty("password")
	private String passWord;

	@JsonProperty("date")
	private String date;

	@JsonProperty("moth")
	private String moth;

	@JsonProperty("year")
	private String year;

	
	  @JsonProperty("login") Login login;
	  
	  public static class Login {
	  
	  @JsonProperty("username") String userName;
	  
	  @JsonProperty("passWord") String passWord; }
	  
	  public String getuserName() { return login.userName; }
	  
	  public String getpassWord() { return login.passWord; }
	 
	
	
	  @JsonProperty("subjects") private List<Subject> subjects;
	  
	  public List<Subject> getSubject(){ return subjects; }
	  
	  public static class Subject {
	  
	  @JsonProperty("name") private String name;
	  
	  @JsonProperty("name") private float point;
	  
	  public String getName() { return name; }
	  
	  public float getPoint() { return point; }
	  
	  }
	 

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassWord() {
		return passWord;
	}

	public String getDate() {
		return date;
	}

	public String getMoth() {
		return moth;
	}

	public String getYear() {
		return year;
	}

}
