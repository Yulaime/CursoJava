package com.example.cursojava.persintence.entity;

import javax.persistence.*;
import java.util.List;

// La entidad Categoria representa una categoría en la base de datos
@Entity
@Table(name = "categorias")
public class Categoria {

    // El ID de la categoría. Es la clave primaria en la base de datos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    // La descripción de la categoría
    private String descripcion;

    // El estado de la categoría. True si está activa, false si no.
    private Boolean estado;

    // Los productos que pertenecen a esta categoría
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    // Getter para idCategoria
    public Integer getIdCategoria() {
        return idCategoria;
    }

    // Setter para idCategoria
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    // Getter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    // Setter para descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter para estado
    public Boolean getEstado() {
        return estado;
    }

    // Setter para estado
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    // Getter para productos
    public List<Producto> getProductos() {
        return productos;
    }

    // Setter para productos
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
