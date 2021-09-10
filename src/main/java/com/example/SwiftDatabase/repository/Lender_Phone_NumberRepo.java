package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Lender_Phone_Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Lender_Phone_NumberRepo extends JpaRepository<Lender_Phone_Number, String>{
}
