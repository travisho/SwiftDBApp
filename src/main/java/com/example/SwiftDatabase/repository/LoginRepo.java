package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login, String>{
}
