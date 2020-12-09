package com.jump.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jump.model.Doctor;
import com.jump.service.DoctorService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;


	@PostMapping
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor)
	{
		Doctor result = doctorService.addDoctor(doctor);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getDoctorId()).toUri();
		
		return ResponseEntity.created(location).body(result);
	}

	@GetMapping
	public Iterable<Doctor> getDoctors()
	{
		List<Doctor> doctors = doctorService.getDoctors();

		return doctors;
	}

	@GetMapping(value = "/{doctorId}")
	public Doctor getDoctorByIdd(@PathVariable Integer doctorId) 
	{
		Doctor doctor = doctorService.getDoctor(doctorId);
		return doctor;
	}

	@PutMapping(value = "/{doctorId}")
	public Doctor updateDoctor(@PathVariable Integer doctorId, @RequestBody Doctor doctor) 
	{
		Doctor result = doctorService.updateDoctor(doctor);
		return result;
	}

	@DeleteMapping(value = "/{doctorId}")
	public ResponseEntity<?> deleteDoctor(@PathVariable Integer doctorId)
	{
		doctorService.deleteDoctor(doctorId);
		return ResponseEntity.noContent().build();
	}

}