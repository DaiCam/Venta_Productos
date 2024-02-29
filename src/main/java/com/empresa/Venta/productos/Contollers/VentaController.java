package com.empresa.Venta.productos.Contollers;

import com.empresa.Venta.productos.Services.ProductoService;
import com.empresa.Venta.productos.Services.VentaService;
import com.empresa.Venta.productos.model.Venta;
import com.empresa.Venta.productos.repository.ProductoRepository;
import com.empresa.Venta.productos.repository.VentaRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
public class VentaController {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private VentaService ventaService;
    @Autowired
    private VentaRepository ventaRepository;

    @PostMapping("/agregarVenta")
    public Venta agregarVenta(@RequestBody Venta venta){
        return ventaRepository.save(venta);
    }




}
