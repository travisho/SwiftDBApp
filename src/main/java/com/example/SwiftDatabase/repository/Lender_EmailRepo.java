package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Lender_Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Lender_EmailRepo extends JpaRepository<Lender_Email, String>{
}
