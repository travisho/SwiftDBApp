package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, String>{
}
