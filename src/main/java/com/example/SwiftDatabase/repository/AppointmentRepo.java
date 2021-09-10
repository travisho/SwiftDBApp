package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, String>{
}
