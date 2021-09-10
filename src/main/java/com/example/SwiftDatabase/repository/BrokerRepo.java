package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepo extends JpaRepository<Broker, String>{
}
