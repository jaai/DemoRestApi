package com.jazz.restapidemo.model.data;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_step_counts")
public class StepCountData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userEmail;
	private String userTeam;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date;
	private Integer stepCount;
	private String distance;
	private String caloriesCount;
	private String durationCount;

	public StepCountData() {
		super();
	}

	public StepCountData(Long id, String userEmail, String userTeam, Date date, Integer stepCount, String distance,
			String caloriesCount, String durationCount) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.userTeam = userTeam;
		this.date = date;
		this.stepCount = stepCount;
		this.distance = distance;
		this.caloriesCount = caloriesCount;
		this.durationCount = durationCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTeam() {
		return userTeam;
	}

	public void setUserTeam(String userTeam) {
		this.userTeam = userTeam;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStepCount() {
		return stepCount;
	}

	public void setStepCount(Integer stepCount) {
		this.stepCount = stepCount;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getCaloriesCount() {
		return caloriesCount;
	}

	public void setCaloriesCount(String caloriesCount) {
		this.caloriesCount = caloriesCount;
	}

	public String getDurationCount() {
		return durationCount;
	}

	public void setDurationCount(String durationCount) {
		this.durationCount = durationCount;
	}

	@Override
	public String toString() {
		return "StepCountData [id=" + id + ", userEmail=" + userEmail + ", userTeam=" + userTeam + ", date=" + date
				+ ", stepCount=" + stepCount + ", distance=" + distance + ", caloriesCount=" + caloriesCount
				+ ", durationCount=" + durationCount + "]";
	}

	



}