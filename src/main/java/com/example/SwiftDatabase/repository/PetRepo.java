package com.example.SwiftDatabase.repository;


import com.example.SwiftDatabase.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends JpaRepository<Pet, String> {
}
