package com.jazz.restapidemo.model.response;

import com.jazz.restapidemo.model.data.StepCountData;
import com.jazz.restapidemo.model.data.Users;

public class StepCountsByUserEmailResponseModel {

	private String goal;
	private Users user;
	private StepCountData prevCount;

	public StepCountsByUserEmailResponseModel() {
		super();
	}

	public StepCountsByUserEmailResponseModel(String goal, Users user, StepCountData prevCount) {
		super();
		this.goal = goal;
		this.user = user;
		this.prevCount = prevCount;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public StepCountData getPrevCount() {
		return prevCount;
	}

	public void setPrevCount(StepCountData prevCount) {
		this.prevCount = prevCount;
	}


}