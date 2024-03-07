package com.empresa.Venta.productos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Cantidad")
    private int cantidad;

    /*@Column(name = "Id_Cliente")
    private int id_cliente;

    @Column(name = "Id_Producto")
    private int id_producto;*/


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "Id_Cliente",
            referencedColumnName = "Id"
    )
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "Id_Producto",
            referencedColumnName = "Id"
    )
    private Producto producto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta(){}
    public Venta(Integer id, Date fecha, int cantidad, Cliente cliente, Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.producto = producto;
    }
}

