package com.example.exportdatatoexcel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EmployeeDetails")
public class Employee {

	@Id
	@Column(name="employeeId")
	private int employeeId;
	
	@Column(name="employeeFirstName")
	private String employeeFirstName;
	
	@Column(name="employeeLastName")
	private String employeeLastName;
	
	@Column(name="employeeAge")
	private int employeeAge;
	
	@Column(name="employeeSalary")
	private Long employeeSalary;
	
	@Column(name="employeeAddress")
	private String employeeAddress;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="employeeExperienceInMonths")
	private int employeeExperienceInMonths;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public Long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalaray(Long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getEmployeeExperienceInMonths() {
		return employeeExperienceInMonths;
	}

	public void setEmployeeExperienceInMonths(int employeeExperienceInMonths) {
		this.employeeExperienceInMonths = employeeExperienceInMonths;
	}
	
}
