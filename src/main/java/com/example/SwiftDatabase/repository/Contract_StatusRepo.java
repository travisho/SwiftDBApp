package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Contract_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contract_StatusRepo extends JpaRepository<Contract_Status, String>{
}
