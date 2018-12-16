package com.workoutapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="WORKOUT_CATEGORY")
public class WorkoutCategory implements Serializable
{
	@Id
	@Column(name="CATEGORY_ID")
	@GeneratedValue
	private int categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@OneToMany(mappedBy="workoutCategory",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<WorkoutCollection> workoutCollection;
	
	@Transient
	private int buttonDisabled;
	
	

	public int getButtonDisabled() {
		return buttonDisabled;
	}

	public void setButtonDisabled(int buttonDisabled) {
		this.buttonDisabled = buttonDisabled;
	}

	public List<WorkoutCollection> getWorkoutCollection() 
	{
		return workoutCollection;
	}

	public void setWorkoutCollection(List<WorkoutCollection> workoutCollection)
	{
		this.workoutCollection = workoutCollection;
	}

	public int getCategoryId() 
	{
		return categoryId;
	}

	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}

	public String getCategoryName() 
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	
	public WorkoutCategory()
	{
		
	}

	@Override
	public String toString()
	{
		return "WorkoutCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
	
	
	

}
