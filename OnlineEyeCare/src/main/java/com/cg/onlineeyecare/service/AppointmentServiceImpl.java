package com.cg.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineeyecare.dao.AppointmentRepository;
import com.cg.onlineeyecare.entity.Appointment;
import com.cg.onlineeyecare.exceptions.ResourceNotFoundException;


@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	AppointmentRepository appointmentRepo;

	@Override
	public Appointment bookAppointment(Appointment appointment) {
		
		
		return appointmentRepo.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) throws ResourceNotFoundException {
		
		Optional<Appointment> result=appointmentRepo.findById(appointment.getAppointmentId());
		if(result.isPresent())
		{
			return appointmentRepo.save(appointment);
		}
		else
		{
			throw new ResourceNotFoundException("Appointment Id is not present in database");
		}
	}

	@Override
	public String cancelAppointment(int appointmentId) throws ResourceNotFoundException {
		
		Optional<Appointment> result=appointmentRepo.findById(appointmentId);
		if(result.isPresent())
		{
			appointmentRepo.deleteById(appointmentId);
			return "Appointment Cancled";
		}
		else
		{
			throw new ResourceNotFoundException("Appointment is not present with this Id");
		}
		
	}

	@Override
	public Appointment viewAppointment(int appointmentId) throws ResourceNotFoundException {
		
		Optional<Appointment> result=appointmentRepo.findById(appointmentId);
		if(result.isPresent())
		{
			appointmentRepo.findById(appointmentId);
			return result.get();
		}
		else
		{
			throw new ResourceNotFoundException("Appointment is not present with given Id");
		}
	}

	@Override
	public List<Appointment> viewAllAppointments() {
		
		return appointmentRepo.findAll();
	}

	@Override
	public List<Appointment> viewAppointments(LocalDate date) {
	
		return appointmentRepo.findAll().stream().filter(app->(date.compareTo(app.getDateOfAppointment())==0)).collect(Collectors.toList());
	}

	@Override
	public Appointment bookAppointment(AppointmentService tempAppointment) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
