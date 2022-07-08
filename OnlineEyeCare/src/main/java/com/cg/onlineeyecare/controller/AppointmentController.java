package com.cg.onlineeyecare.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyecare.entity.Appointment;
import com.cg.onlineeyecare.service.AppointmentService;

@RestController
@RequestMapping("/v1")
public class AppointmentController {
	@Autowired
	AppointmentService appointmentRepo;

	@PostMapping("/bookappointment")
	public Appointment bookAppointment(@Valid @RequestBody Appointment appointment) {
		return appointmentRepo.bookAppointment(appointment);
	}
	
	@PutMapping("/updateappointment/{id}")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws Throwable {
		return appointmentRepo.updateAppointment(appointment);
	}

	@DeleteMapping("/cancelappointment/{id}")
	public String cancelAppointment(@PathVariable int id) throws Throwable {
		return appointmentRepo.cancelAppointment(id);
	}
	
	@GetMapping("/viewallappointments")
	public List<Appointment> listallappointments() {
		return appointmentRepo.viewAllAppointments();
	}
	 
	@GetMapping("/viewappointment/{id}")
	public Appointment viewAppointment(@PathVariable int id) throws Throwable {
		return appointmentRepo.viewAppointment(id);
	}
	
	@GetMapping("/viewallappointmentbydate")
	public List<Appointment> listallappointments(@RequestParam(value="date")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate date) {
		return appointmentRepo.viewAppointments(date);
	}

}


