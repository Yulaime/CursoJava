package com.example.cursojava.domain.repository;

import com.example.cursojava.domain.Purchase;

import java.util.*;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
