package com.example.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.listarProductos();
    }

    public void agregarProducto(Producto producto) {
        productoRepository.agregarProducto(producto);
    }

    public Producto obtenerProductoPorId(int id) {
        return productoRepository.obtenerProductoPorId(id);
    }

    public void eliminarProducto(int id) {
        productoRepository.eliminarProducto(id);
    }

    public void actualizarProducto(Producto producto) {
        productoRepository.actualizarProducto(producto);
    }
}
