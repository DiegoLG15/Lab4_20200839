package com.example.lab4_20200839.repository;

import com.example.lab4_20200839.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Integer> {
}
