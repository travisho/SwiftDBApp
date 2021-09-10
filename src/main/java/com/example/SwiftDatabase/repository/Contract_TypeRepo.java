package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Contract_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contract_TypeRepo extends JpaRepository<Contract_Type, String>{
}
