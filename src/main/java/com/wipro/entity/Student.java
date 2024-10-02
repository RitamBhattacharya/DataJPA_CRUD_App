package com.wipro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	Integer sno;
	String sname;
	String saddr;
	Double marks;
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", saddr=" + saddr + ", marks=" + marks + "]";
	}
	
	
}
