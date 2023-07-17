package easyAutomate.data;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserDetails")
public class UserDetails {

	public String orgName;
	public String dob;
	public String phoneNumber;
	public String designation;

	// Getters and setters

	public String getorgName() {
		return orgName;
	}

	public void setorgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}