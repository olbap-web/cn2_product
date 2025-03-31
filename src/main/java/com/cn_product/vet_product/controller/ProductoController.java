package com.cn_product.vet_product.controller;

import com.cn_product.vet_product.model.Producto;
import com.cn_product.vet_product.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("producto")
@CrossOrigin(origins = "*") 
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> getProductos() {
        return ResponseEntity.ok(productoService.getProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        Optional<Producto> producto = productoService.getProductoById(id);
        return producto.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.addProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable int id, @RequestBody Producto nuevoProducto) {
        boolean updated = productoService.updateProducto(id, nuevoProducto);
        return updated ? ResponseEntity.ok("Producto actualizado correctamente") 
                       : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable int id) {
        boolean deleted = productoService.deleteProducto(id);
        return deleted ? ResponseEntity.ok("Producto eliminado correctamente") 
                       : ResponseEntity.notFound().build();
    }
}
