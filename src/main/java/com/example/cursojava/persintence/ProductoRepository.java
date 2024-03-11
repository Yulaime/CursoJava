package com.example.cursojava.persintence;

import com.example.cursojava.domain.Product;
import com.example.cursojava.persintence.crud.ProductoCrudRepository;
import com.example.cursojava.persintence.entity.Producto;
import com.example.cursojava.persintence.mapper.ProductMapper;
import com.example.cursojava.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Esta clase implementa la interfaz ProductRepository y se encarga de la persistencia de los productos
@Repository
public class ProductoRepository implements ProductRepository {

    // Inyección de dependencias de Spring para el repositorio y el mapeador
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    // Método para obtener todos los productos
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    // Método para obtener los productos por categoría
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    // Método para obtener los productos escasos
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    // Método para obtener un producto por su ID
     @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    // Método para guardar un producto
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    // Método para eliminar un producto por su ID
     @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
	}
	
