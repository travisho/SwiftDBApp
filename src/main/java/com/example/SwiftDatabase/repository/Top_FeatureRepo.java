package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Top_Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Top_FeatureRepo extends JpaRepository<Top_Feature, String>{
}
