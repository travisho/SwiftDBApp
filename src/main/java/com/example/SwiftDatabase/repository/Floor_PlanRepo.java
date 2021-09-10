package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Floor_Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Floor_PlanRepo extends JpaRepository<Floor_Plan, String>{
}
