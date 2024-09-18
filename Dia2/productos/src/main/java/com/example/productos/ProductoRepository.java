package com.example.productos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {
    private final List<Producto> productos = new ArrayList<>();

    public List<Producto> listarProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto obtenerProductoPorId(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public void actualizarProducto(Producto producto) {
        Producto productoExistente = obtenerProductoPorId(producto.getId());
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
        }
    }
}
