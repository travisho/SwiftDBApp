package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Broker_Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Broker_EmailRepo extends JpaRepository<Broker_Email, String>{
}
