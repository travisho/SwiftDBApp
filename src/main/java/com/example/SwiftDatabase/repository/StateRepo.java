package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<State, String>{
}
