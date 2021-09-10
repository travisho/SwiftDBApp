package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Broker_Phone_Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Broker_Phone_NumberRepo extends JpaRepository<Broker_Phone_Number, String>{
}
