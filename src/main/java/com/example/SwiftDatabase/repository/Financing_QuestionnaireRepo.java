package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Financing_Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Financing_QuestionnaireRepo extends JpaRepository<Financing_Questionnaire, String> {
}
