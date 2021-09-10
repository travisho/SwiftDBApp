package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Utility_Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Utility_BillRepo extends JpaRepository<Utility_Bill, String> {
}
