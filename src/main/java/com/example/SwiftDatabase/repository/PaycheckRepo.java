package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Paycheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaycheckRepo extends JpaRepository<Paycheck, String> {
}
