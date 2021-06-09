package com.jazz.restapidemo.model.data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_details")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String userEmail;
	private String userMob;
	private String userFname;
	private String userLname;
	private String userProfilePic;
	private String userWeight;
	private String userTeam;

	public Users() {
		super();
	}

	public Users(Long userId, String userEmail, String userMob, String userFname, String userLname,
			String userProfilePic, String userWeight, String userTeam) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userMob = userMob;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userProfilePic = userProfilePic;
		this.userWeight = userWeight;
		this.userTeam = userTeam;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserProfilePic() {
		return userProfilePic;
	}

	public void setUserProfilePic(String userProfilePic) {
		this.userProfilePic = userProfilePic;
	}

	public String getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(String userWeight) {
		this.userWeight = userWeight;
	}

	public String getUserTeam() {
		return userTeam;
	}

	public void setUserTeam(String userTeam) {
		this.userTeam = userTeam;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userEmail=" + userEmail + ", userMob=" + userMob + ", userFname="
				+ userFname + ", userLname=" + userLname + ", userProfilePic=" + userProfilePic + ", userWeight="
				+ userWeight + ", userTeam=" + userTeam + "]";
	}



}