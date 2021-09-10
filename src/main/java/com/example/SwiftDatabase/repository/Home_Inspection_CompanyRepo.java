package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Home_Inspection_Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Home_Inspection_CompanyRepo extends JpaRepository<Home_Inspection_Company, String>{
}
