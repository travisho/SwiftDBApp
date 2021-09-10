package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepo extends JpaRepository<Discussion, String>{
}
