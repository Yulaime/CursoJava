package com.example.cursojava.domain.repository;

import com.example.cursojava.domain.dto.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    // Métodos adicionales personalizados si es necesario
}