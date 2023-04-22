package com.example.lab4_20200839.repository;

import com.example.lab4_20200839.entity.Reserva;
import com.example.lab4_20200839.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
