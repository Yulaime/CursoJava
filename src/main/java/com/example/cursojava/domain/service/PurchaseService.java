package com.example.cursojava.domain.service;

import com.example.cursojava.domain.Purchase;
import com.example.cursojava.domain.PurchaseItem;
import com.example.cursojava.domain.dto.Receipt;
import com.example.cursojava.domain.dto.ReceiptLine;
import com.example.cursojava.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cursojava.domain.repository.ReceiptRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    public Purchase createPurchaseFromRequest(Receipt receipt) {
        // Verificar si el Receipt es nulo o si no tiene líneas
        if (receipt == null || receipt.getLines() == null) {
            return null;
        }

        // Crear un nuevo Purchase
        Purchase purchase = new Purchase();
        List<PurchaseItem> purchaseItems = new ArrayList<>();

        // Iterar sobre las líneas del Receipt y crear PurchaseItems
        for (ReceiptLine line : receipt.getLines()) {
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setQuantity(line.getQuantity());
            purchaseItem.setProductId(Math.toIntExact(line.getProductId()));
            purchaseItems.add(purchaseItem);
        }

        // Asignar la lista de PurchaseItems al Purchase
        purchase.setItems(purchaseItems);

        // Guardar el Purchase en la base de datos
        return purchaseRepository.save(purchase);
    }

    public Receipt saveReceiptFromRequest(Receipt receipt) {
        // Verificar si el Receipt es nulo o si no tiene líneas
        if (receipt == null || receipt.getLines() == null) {
            return null;
        }

        // Guardar el recibo en la base de datos
        return receiptRepository.save(receipt);
    }
}
