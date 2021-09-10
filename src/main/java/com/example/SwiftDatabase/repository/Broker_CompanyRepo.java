package com.example.SwiftDatabase.repository;
import com.example.SwiftDatabase.model.Broker_Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Broker_CompanyRepo extends JpaRepository<Broker_Company, String>{
}
