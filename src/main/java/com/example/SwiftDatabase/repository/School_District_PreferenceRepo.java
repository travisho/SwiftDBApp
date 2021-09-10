package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.School_District_Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface School_District_PreferenceRepo extends JpaRepository<School_District_Preference, String>{
}
