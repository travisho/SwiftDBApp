package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Client_Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Client_EmailRepo extends JpaRepository<Client_Email, String>{
}
