package com.jump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jump.exception.DoctorNotFound;
import com.jump.model.Doctor;
import com.jump.repository.DoctorRepository;

@Service
public class DoctorService 
{
	@Autowired
	DoctorRepository doctorRepository;
	
	public Doctor addDoctor(Doctor doctor)
	{
		return doctorRepository.save(doctor);
	}
	
	public Doctor updateDoctor(Doctor doctor)
	{
		getDoctor(doctor.getDoctorId());
		return doctorRepository.save(doctor);
	}

	public List<Doctor> getDoctors()
	{
		return doctorRepository.findAll();
	}

	public Doctor getDoctor(Integer id) 
	{
		return doctorRepository.findById(id).orElseThrow(DoctorNotFound::new);
	}

	public void deleteDoctor(Integer id) 
	{
		getDoctor(id);
		doctorRepository.deleteById(id);
	}
}
