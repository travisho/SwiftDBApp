package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Property_Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Property_SurveyRepo extends JpaRepository<Property_Survey, String>{
}
