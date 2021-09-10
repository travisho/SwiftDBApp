package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Property_Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Property_StyleRepo extends JpaRepository<Property_Style, String>{
}
