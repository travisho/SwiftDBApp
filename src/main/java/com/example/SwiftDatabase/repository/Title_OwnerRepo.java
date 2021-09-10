package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Title_Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Title_OwnerRepo extends JpaRepository<Title_Owner, String>{
}
