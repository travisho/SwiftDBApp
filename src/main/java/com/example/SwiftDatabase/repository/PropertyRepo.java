package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<Property, String>{
}
