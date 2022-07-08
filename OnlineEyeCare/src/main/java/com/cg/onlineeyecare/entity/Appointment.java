package com.cg.onlineeyecare.entity;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {
	@Id
	@NotEmpty(message="Id is required")
	private Integer appointmentId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfAppointment;
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern="hh:mm:ss a")
	LocalTime timeOfAppointment;
	Double consultationFee;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="doctor_Id")
	Doctor doctor_Id;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="patient_Id")
	@JsonIgnore
	Patient patient_Id;
	
	public Appointment() {
		super();
	}

	public Appointment(Integer appointmentId, LocalDate dateOfAppointment, LocalTime timeOfAppointment,
			Double consultationFee, Doctor doctor_Id, Patient patient_Id) {
		super();
		this.appointmentId = appointmentId;
		this.dateOfAppointment = dateOfAppointment;
		this.timeOfAppointment = timeOfAppointment;
		this.consultationFee = consultationFee;
		this.doctor_Id = doctor_Id;
		this.patient_Id = patient_Id;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public LocalTime getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(LocalTime timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public Double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public Doctor getDoctor_Id() {
		return doctor_Id;
	}

	public void setDoctor_Id(Doctor doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public Patient getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(Patient patient_Id) {
		this.patient_Id = patient_Id;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment=" + dateOfAppointment
				+ ", timeOfAppointment=" + timeOfAppointment + ", consultationFee=" + consultationFee + ", doctor_Id="
				+ doctor_Id + ", patient_Id=" + patient_Id + "]";
	}

	public void setDateOfAppointment(String string) {
		
	}

	public void setTimeOfAppointment(String string) {
		
	}
}