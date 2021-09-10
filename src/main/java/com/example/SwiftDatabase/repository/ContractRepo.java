package com.example.SwiftDatabase.repository;


import com.example.SwiftDatabase.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepo extends JpaRepository<Contract, String>{
}