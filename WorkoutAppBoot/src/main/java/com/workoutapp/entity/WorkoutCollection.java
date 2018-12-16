package com.workoutapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.engine.spi.CascadeStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="WORKOUT_COLLECTION")
public class WorkoutCollection implements Serializable
{
	@Id
	@Column(name="WORKOUT_ID")
	@GeneratedValue
	private int workoutId;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private WorkoutCategory workoutCategory;
	
	@Column(name="WORKOUT_NOTE")
	private String workoutNote;
	
	@Column(name="WORKOUT_TITLE")
	private String workoutTitle;
	
	@Column(name="CALORIES_BURN_PER_MIN")
	private float calBurnPerMin;
	
	@OneToMany(mappedBy="workout",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<WorkoutActive> activeWorkouts;
	
	@Transient
	private boolean disabled;


	public boolean isDisabled()
	{
		return disabled;
	}

	public void setDisabled(boolean disabled) 
	{
		this.disabled = disabled;
	}

	public List<WorkoutActive> getActiveWorkouts()
	{
		return activeWorkouts;
	}

	public void setActiveWorkouts(List<WorkoutActive> activeWorkouts) 
	{
		this.activeWorkouts = activeWorkouts;
	}

	public int getWorkoutId() 
	{
		return workoutId;
	}

	public void setWorkoutId(int workoutId) 
	{
		this.workoutId = workoutId;
	}

	public WorkoutCategory getWorkoutCategory() 
	{
		return workoutCategory;
	}

	public void setWorkoutCategory(WorkoutCategory workoutCategory) 
	{
		this.workoutCategory = workoutCategory;
	}

	public String getWorkoutNote()
	{
		return workoutNote;
	}

	public void setWorkoutNote(String workoutNote) 
	{
		this.workoutNote = workoutNote;
	}

	public String getWorkoutTitle()
	{
		return workoutTitle;
	}

	public void setWorkoutTitle(String workoutTitle)
	{
		this.workoutTitle = workoutTitle;
	}

	public float getCalBurnPerMin() 
	{
		return calBurnPerMin;
	}

	public void setCalBurnPerMin(float calBurnPerMin) 
	{
		this.calBurnPerMin = calBurnPerMin;
	}
	
	@Override
	public String toString() {
		return "WorkoutCollection [workoutId=" + workoutId + ", workoutCategory=" + workoutCategory + ", workoutNote="
				+ workoutNote + ", workoutTitle=" + workoutTitle + ", calBurnPerMin=" + calBurnPerMin
				+ "]";
	}
	
	
	
	
	

}
