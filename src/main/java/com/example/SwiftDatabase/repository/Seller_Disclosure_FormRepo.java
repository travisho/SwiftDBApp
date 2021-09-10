package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Seller_Disclosure_Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Seller_Disclosure_FormRepo extends JpaRepository<Seller_Disclosure_Form, String> {
}
