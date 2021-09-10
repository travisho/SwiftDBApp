package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Heating_Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Heating_UnitRepo extends JpaRepository<Heating_Unit, String>{
}
