package com.example.lab4_20200839.repository;

import com.example.lab4_20200839.entity.Reserva;
import com.example.lab4_20200839.entity.User;
import com.example.lab4_20200839.entity.Vuelo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO pasajes.reserva (fecha_reserva, precio_total, estado_pago, user_iduser, vuelo_idvuelo) VALUES (CURRENT_TIMESTAMP,?1,'procesado',?2,?3)")
    void nuevaReserva(BigDecimal precio, Integer idUser, Integer idVuelo);
}
