package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Nearby_Recreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Nearby_RecreationRepo extends JpaRepository<Nearby_Recreation, String>{
}
