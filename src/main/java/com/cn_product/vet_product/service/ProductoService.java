package com.cn_product.vet_product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cn_product.vet_product.model.Producto;

@Service
public class ProductoService {

    
  private final List<Producto> productos = new ArrayList<>();
    
    public ProductoService() {
        productos.add(new Producto(1, "Alimento para perros", 10000));
        productos.add(new Producto(2, "Juguete para gatos", 5000));
        productos.add(new Producto(3, "Collar antipulgas", 8000));
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    
    public Optional<Producto> getProductoById(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst();
    }
    
    public Producto addProducto(Producto producto) {
        productos.add(producto);
        return producto;
    }
    
    public boolean updateProducto(int id, Producto nuevoProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                productos.set(i, nuevoProducto);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
}