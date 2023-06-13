package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class LPModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	private String course;
	private String mentor;
	private float courseprice;
	private float courserating;
	private String countryimg;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	public float getCourseprice() {
		return courseprice;
	}
	public void setCourseprice(float courseprice) {
		this.courseprice = courseprice;
	}
	public float getCourserating() {
		return courserating;
	}
	public void setCourserating(float courserating) {
		this.courserating = courserating;
	}
	public String getCountryimg() {
		return countryimg;
	}
	public void setCountryimg(String countryimg) {
		this.countryimg = countryimg;
	}
}

