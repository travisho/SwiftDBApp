package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Discussion_Medium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Discussion_MediumRepo extends JpaRepository<Discussion_Medium, String>{
}
