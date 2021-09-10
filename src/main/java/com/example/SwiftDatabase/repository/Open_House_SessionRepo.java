package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Open_House_Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Open_House_SessionRepo extends JpaRepository<Open_House_Session, String>{
}
