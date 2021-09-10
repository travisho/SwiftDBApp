package com.example.SwiftDatabase.repository;

import com.example.SwiftDatabase.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, String>{
}
