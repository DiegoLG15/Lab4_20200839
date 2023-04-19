package com.example.lab4_20200839.repository;


import com.example.lab4_20200839.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "SELECT * FROM pasajes.user where email = ?1 and password = ?2;")
    List<User> actualizarHabitacion(String email, String password);
}
