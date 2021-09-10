package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Property_Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Property_FinanceRepo extends JpaRepository<Property_Finance, String>{
}
