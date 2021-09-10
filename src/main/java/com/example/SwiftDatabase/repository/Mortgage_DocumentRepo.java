package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Mortgage_Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mortgage_DocumentRepo extends JpaRepository<Mortgage_Document, String>{
}
