package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Air_Conditioning_Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Air_Conditioning_UnitRepo extends JpaRepository<Air_Conditioning_Unit, String>{
}
