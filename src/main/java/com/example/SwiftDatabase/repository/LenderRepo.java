package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Lender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderRepo extends JpaRepository<Lender, String>{

}
