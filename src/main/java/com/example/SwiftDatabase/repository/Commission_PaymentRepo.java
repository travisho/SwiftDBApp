package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Commission_Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Commission_PaymentRepo extends JpaRepository<Commission_Payment,String> {
}
