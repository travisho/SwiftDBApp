package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Property_Flyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Property_FlyerRepo extends JpaRepository<Property_Flyer, String>{
}
