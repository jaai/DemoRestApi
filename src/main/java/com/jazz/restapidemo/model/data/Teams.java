package com.jazz.restapidemo.model.data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_teams")

public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	private String teamName;
	private String teamProfilePic;
	
	public Teams() {
		super();
	}

	public Teams(Long teamId, String teamName, String teamProfilePic) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamProfilePic = teamProfilePic;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamProfilePic() {
		return teamProfilePic;
	}

	public void setTeamProfilePic(String teamProfilePic) {
		this.teamProfilePic = teamProfilePic;
	}

	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", teamName=" + teamName + ", teamProfilePic=" + teamProfilePic + "]";
	}

	
	
	
}