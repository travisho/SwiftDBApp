package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Lender_Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Lender_CompanyRepo extends JpaRepository<Lender_Company, String>{
}
