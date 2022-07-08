package com.cg.onlineeyecare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineeyecare.entity.Appointment;
import com.cg.onlineeyecare.entity.Doctor;
import com.cg.onlineeyecare.entity.Patient;
import com.cg.onlineeyecare.exceptions.ResourceNotFoundException;
@SpringBootTest
class AppointmentServiceTest {
	@Autowired
	private AppointmentService appointmentservice;
	@Test
	void bookApointmentTest()
	{
		Appointment tempAppointment=new Appointment(5,3000,2022-07-10,)
		//Here we are checking the above appointment is added or not
		assertEquals(9406,appointmentservice.bookAppointment(tempAppointment).getAppointmentId());
	}
	@Test
	void viewAllAppointmentsTest()
	{
		//it checks if the first appointmentid of first appointment in the list is equal to 1 or not
		assertEquals(1,appointmentservice.viewAllAppointments().get(0).getAppointmentId());
	}
	@Test
	void viewAppointmentById() throws ResourceNotFoundException
	{
		assertEquals(1,appointmentservice.viewAppointment(1).getAppointmentId());
	}
	@Test
	void viewAppointmentsByDate()
	{
		LocalDate tempdate=LocalDate.now();
		assertEquals(LocalDate.now(),appointmentservice.viewAppointments(tempdate).get(0).getDateOfAppointment());
	}
	@Test
	void updateAppointmentTest() throws ResourceNotFoundException {
		//here the consultation fee is update to 5000.25
		Appointment TestAppointment=new Appointment(9406,LocalDate.now(),LocalTime.now(),5000.25,new Doctor(1,"abc","10",848675437,"abc@mail","abc","abc","gydg", null),new Patient(1,"abg",45,74764665,"abg@mqail",LocalDate.now(),"abg","abg","hyd"));
		assertEquals(5000.25,appointmentservice.updateAppointment(TestAppointment).getConsultationFee());
	}
	


}
