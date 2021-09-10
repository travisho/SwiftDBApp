package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Property_Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Property_InspectionRepo extends JpaRepository<Property_Inspection, String> {
}
