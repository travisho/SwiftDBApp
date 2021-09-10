package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.HOA_Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HOA_EmailRepo extends JpaRepository<HOA_Email, String>{
}
