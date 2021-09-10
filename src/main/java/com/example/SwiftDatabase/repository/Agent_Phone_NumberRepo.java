package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Agent_Phone_Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Agent_Phone_NumberRepo extends JpaRepository<Agent_Phone_Number, String>{
}
