package com.example.SwiftDatabase.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SwiftDatabase.model.Home_Builder;
@Repository
public interface Home_BuilderRepo extends JpaRepository<Home_Builder, String>{
}
