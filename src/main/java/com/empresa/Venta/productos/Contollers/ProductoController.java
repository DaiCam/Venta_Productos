package com.empresa.Venta.productos.Contollers;

import com.empresa.Venta.productos.Services.ProductoService;
import com.empresa.Venta.productos.model.Producto;
import com.empresa.Venta.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoService productoService;

    @GetMapping("/getProductos")
    public List<Producto> getAllProductos(){return productoRepository.findAll();}

    @GetMapping("/getProducto/{id}")
    public Optional<Producto> getProductoById(@PathVariable Integer id){
        return productoRepository.findById(id);
    }

    @PostMapping("/agregarProducto")
    public Producto agregarProducto(@RequestBody Producto agregarProduct){
        return productoRepository.save(agregarProduct);
    }

    @PutMapping("/modificarProducto/{id}")
    public Producto modificarProducto(@PathVariable Integer id, @RequestBody Producto producModificado){
        producModificado.setId(id);

        return productoRepository.save(producModificado);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<Producto> eliminarProd(@PathVariable Integer id){
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
