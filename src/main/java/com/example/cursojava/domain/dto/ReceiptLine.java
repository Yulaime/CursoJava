package com.example.cursojava.domain.dto;

import com.example.cursojava.persintence.entity.Cliente;

import javax.persistence.*;

@Entity
@Table(name = "receipt_lines")
public class ReceiptLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private Long lineId;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "client_id") //
    private Cliente cliente; //

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "product_id")
    private Long productId;

    public ReceiptLine() {
    }

    public ReceiptLine(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
