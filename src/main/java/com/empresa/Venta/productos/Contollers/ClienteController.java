package com.empresa.Venta.productos.Contollers;

import com.empresa.Venta.productos.Services.ClienteService;
import com.empresa.Venta.productos.dto.ClienteDto;
import com.empresa.Venta.productos.model.Cliente;
import com.empresa.Venta.productos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/getClientes")
    public List<Cliente> getAllClientes(){return clienteRepository.findAll();}

    @GetMapping("/clientes/{Id}")
    public Optional<Cliente> getClientesById(@PathVariable(value = "Id") Integer id) {
        return clienteRepository.findById(id);
    }

    @PostMapping("/agregarCliente")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {

        return clienteRepository.save(cliente);
    }


    /*@PutMapping("/modificarCliente/{id}")
    public Cliente modificarClientee(@RequestBody Cliente cliente) {
        Cliente clienteModificado = cliente;

        return clienteModificado;
    }*/

    /*@PutMapping("/modificarCliente/{id}")
    public ResponseEntity<Cliente> modificarClientee(@PathVariable Integer id, @RequestBody Cliente clienteModificado) {
        clienteModificado.setId(id);

        clienteRepository.save(clienteModificado);

        return ResponseEntity.ok(clienteModificado);
    }*/

    @PutMapping("/modificarCliente/{id}")
    public Cliente modificarCliente(@PathVariable Integer id, @RequestBody Cliente clienteModificado) {
        clienteModificado.setId(id);

        return clienteRepository.save(clienteModificado);
    }

    /*@PutMapping("/incidents")
    public ResponseEntity<Incidence> update(@RequestBody DeriveDto derive) {
        Incidence incidence = incidenceService.update(derive);
        return ResponseEntity.ok(incidence);
    }*/

    /*funciona pero no devuelve nada, solo borra de la base de datos
    @DeleteMapping("/borrarCliente/{id}")
    public void borrarCliente(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }*/

    @DeleteMapping("/borrarCliente/{id}")
    public ResponseEntity<Void> borrarCliente(@PathVariable Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build(); // Retorna 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 no se encontro el cliente
        }
    }
}




