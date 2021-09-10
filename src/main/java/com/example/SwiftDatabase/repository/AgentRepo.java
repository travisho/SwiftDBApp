package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<Agent, String>{
}
