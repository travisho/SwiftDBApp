package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.New_Home_Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface New_Home_QuestionnaireRepo extends JpaRepository<New_Home_Questionnaire, String>{
}
