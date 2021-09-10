package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepo extends JpaRepository<Appliance, String>{
}
