package com.example.cursojava.web.controller;

import com.example.cursojava.domain.Purchase;
import com.example.cursojava.domain.dto.Receipt;
import com.example.cursojava.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        List<Purchase> purchases = purchaseService.getAll();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        Purchase savedPurchase = purchaseService.save(purchase);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    @PostMapping("/receipts")
    public ResponseEntity<Receipt> createReceipt(@RequestBody Receipt receipt) {
        System.out.println("Cliente recibido: " + receipt.getClientId());
        if (receipt.getClientId() != null) {

            Receipt savedReceipt = purchaseService.saveReceipt(receipt);
            return new ResponseEntity<>(savedReceipt, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}



