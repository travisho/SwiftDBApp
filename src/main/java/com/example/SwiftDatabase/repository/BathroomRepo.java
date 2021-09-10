package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Bathroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BathroomRepo extends JpaRepository<Bathroom, String>{
}
