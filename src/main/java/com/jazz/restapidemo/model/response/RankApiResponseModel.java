package com.jazz.restapidemo.model.response;
public class RankApiResponseModel {

	private String teamName;
	private Integer teamMembersCount;
	private Integer totalSteps;
	private String teamProfilePic;

	public RankApiResponseModel() {
		super();
	}

	public RankApiResponseModel(String teamName, Integer teamMembersCount, Integer totalSteps, String teamProfilePic) {
		super();
		this.teamName = teamName;
		this.teamMembersCount = teamMembersCount;
		this.totalSteps = totalSteps;
		this.teamProfilePic = teamProfilePic;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamMembersCount() {
		return teamMembersCount;
	}

	public void setTeamMembersCount(Integer teamMembersCount) {
		this.teamMembersCount = teamMembersCount;
	}

	public Integer getTotalSteps() {
		return totalSteps;
	}

	public void setTotalSteps(Integer totalSteps) {
		this.totalSteps = totalSteps;
	}

	public String getTeamProfilePic() {
		return teamProfilePic;
	}

	public void setTeamProfilePic(String teamProfilePic) {
		this.teamProfilePic = teamProfilePic;
	}

	@Override
	public String toString() {
		return "RankApiResponseModel [teamName=" + teamName + ", teamMembersCount=" + teamMembersCount + ", totalSteps="
				+ totalSteps + ", teamProfilePic=" + teamProfilePic + "]";
	}

}