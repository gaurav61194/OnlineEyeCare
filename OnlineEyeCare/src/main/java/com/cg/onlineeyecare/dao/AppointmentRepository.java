package com.cg.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineeyecare.entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}

