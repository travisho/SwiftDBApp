package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Client_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Client_StatusRepo extends JpaRepository<Client_Status, String>{
}
