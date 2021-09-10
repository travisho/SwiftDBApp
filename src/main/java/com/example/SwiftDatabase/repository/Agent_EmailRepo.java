package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Agent_Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Agent_EmailRepo extends JpaRepository<Agent_Email, String>{
}
