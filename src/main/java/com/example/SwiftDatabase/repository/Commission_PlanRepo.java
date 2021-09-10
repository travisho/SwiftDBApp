package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Commission_Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Commission_PlanRepo extends JpaRepository<Commission_Plan, String>{
}
