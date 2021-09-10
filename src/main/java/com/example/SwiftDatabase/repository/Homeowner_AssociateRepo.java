package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Homeowner_Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Homeowner_AssociateRepo extends JpaRepository<Homeowner_Associate, String>{
}
