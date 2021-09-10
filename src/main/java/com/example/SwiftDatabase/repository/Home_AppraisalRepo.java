package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Home_Appraisal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Home_AppraisalRepo extends JpaRepository<Home_Appraisal, String>{
}
