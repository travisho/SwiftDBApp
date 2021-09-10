package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepo extends JpaRepository<Questionnaire, String>{
}
