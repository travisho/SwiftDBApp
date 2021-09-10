package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Client_Phone_Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Client_Phone_NumberRepo extends JpaRepository<Client_Phone_Number, String>{
}
