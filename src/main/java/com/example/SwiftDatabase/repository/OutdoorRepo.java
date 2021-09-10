package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Outdoor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutdoorRepo extends JpaRepository<Outdoor, String>{
}
