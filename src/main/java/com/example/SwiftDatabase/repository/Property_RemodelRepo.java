package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Property_Remodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Property_RemodelRepo extends JpaRepository<Property_Remodel, String>{
}
