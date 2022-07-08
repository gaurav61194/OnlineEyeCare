
package com.cg.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineeyecare.entity.Appointment;
import com.cg.onlineeyecare.exceptions.ResourceNotFoundException;

public interface AppointmentService {
	
	Appointment bookAppointment(AppointmentService tempAppointment);
	
	Appointment updateAppointment(Appointment appointment) throws ResourceNotFoundException;
	
	String cancelAppointment(int appointmentId) throws  ResourceNotFoundException, Throwable;

	Appointment viewAppointment(int appointmentId) throws  ResourceNotFoundException;

	List<Appointment> viewAllAppointments();

	List<Appointment> viewAppointments(LocalDate date);

	Appointment bookAppointment(Appointment appointment);

	

	
}
