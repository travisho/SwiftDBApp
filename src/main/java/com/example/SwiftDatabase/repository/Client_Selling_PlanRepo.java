package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Client_Selling_Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Client_Selling_PlanRepo extends JpaRepository<Client_Selling_Plan, String>{
}
