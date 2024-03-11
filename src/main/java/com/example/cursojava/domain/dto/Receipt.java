package com.example.cursojava.domain.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Long receiptId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt")
    private List<ReceiptLine> lines;

    @Column(name = "client_id")
    private String clientId;

    public Receipt() {

    }

    // Getters y setters

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<ReceiptLine> getLines() {
        return lines;
    }

    public void setLines(List<ReceiptLine> lines) {
        this.lines = lines;
    }
}
