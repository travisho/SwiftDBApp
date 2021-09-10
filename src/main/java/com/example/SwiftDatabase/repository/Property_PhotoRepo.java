package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Property_Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Property_PhotoRepo extends JpaRepository<Property_Photo, String>{
}
