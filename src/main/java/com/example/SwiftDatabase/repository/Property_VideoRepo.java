package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Property_Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Property_VideoRepo extends JpaRepository<Property_Video, String>{
}
