package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepo extends JpaRepository<Garage, String>{
}
