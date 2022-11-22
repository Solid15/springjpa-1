package be.abis.exercise.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@SequenceGenerator(name="courses_generator", sequenceName="courses_cid_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="courses_generator")
	@Column(name="cid")
    private int courseId;
	@Column(name="cstitle")
	private String shortTitle;
	@Column(name="cltitle")
	private String longTitle;
	@Column(name="cdur")
	private int numberOfDays;
	@Column(name="caprice")
	private double pricePerDay;
	
	public Course(){}


	public Course(String shortTitle, String longTitle, int numberOfDays, double pricePerDay) {
		this.shortTitle = shortTitle;
		this.longTitle = longTitle;
		this.numberOfDays = numberOfDays;
		this.pricePerDay = pricePerDay;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	public String getLongTitle() {
		return longTitle;
	}
	public void setLongTitle(String longTitle) {
		this.longTitle = longTitle;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	

	
}