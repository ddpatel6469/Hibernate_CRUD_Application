package com.marlabs.hql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EmployeeHQL")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "EMPNUMBER", length = 4)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int empNumber;
	@Column(name = "EMPNAME", length = 20, nullable = false)
	private String empName;
	@Column(name = "EMPSALARY", nullable = false)
	private double empSalary;
	@Column(name = "DEPTNO", length = 2, nullable = false)
	private int departmentNumber;

	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	@Override
	public String toString() {
		return "Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary
				+ ", departmentNumber=" + departmentNumber + "]";
	}

}
