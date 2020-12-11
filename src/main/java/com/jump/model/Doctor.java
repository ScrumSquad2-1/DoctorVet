package com.jump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="DOCTOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DOCTORID")
	private Integer doctorId;
	
	@Column(name="DOCTORNAME")
	private String doctorName;
	
	@Column(name="DOCTORNUMBER", columnDefinition="BIGINT(20)")
	private Long doctorNumber;
	
	@Column(name="DOCTOREXPERIENCE")
	private Integer doctorExperience;
	
	public Integer getDoctorId()
	{
		return doctorId;
	}

	public void setDoctorId(Integer doctorId)
	{
		this.doctorId = doctorId;
	}

	public String getDoctorName()
	{
		return doctorName;
	}

	public void setDoctorName(String doctorName) 
	{
		this.doctorName = doctorName;
	}

	public Long getDoctorNumber()
	{
		return doctorNumber;
	}

	public void setDoctorNumber(Long doctorNumber) 
	{
		this.doctorNumber = doctorNumber;
	}
	
	public Integer getDoctorExperience()
	{
		return doctorExperience;
	}

	public void setDoctorExperience(Integer doctorExperience) 
	{
		this.doctorExperience = doctorExperience;
	}

	@Override
	public String toString() 
	{
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorNumber=" + doctorNumber + ", doctorExperience=" + doctorExperience + "]";
	}
}