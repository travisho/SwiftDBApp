package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Nearby_Businesses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Nearby_BusinessesRepo extends JpaRepository<Nearby_Businesses, String>{
}
