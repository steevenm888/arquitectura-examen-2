/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ec.examen.mysql.api;

import ec.edu.ec.examen.mysql.api.dto.ClienteRQ;
import ec.edu.ec.examen.mysql.exception.InsertException;
import ec.edu.ec.examen.mysql.exception.NotFoundException;
import ec.edu.ec.examen.mysql.model.Cliente;
import ec.edu.ec.examen.mysql.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author esteban
 */

@RestController
@RequestMapping("/api/cliente")
@Slf4j
public class ClienteController {
    private final ClienteService service;
    
    public ClienteController(ClienteService service) {
        this.service = service;
    }
    
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<Cliente> buscarPorCedula(@PathVariable String cedula) {
        try {
            log.info("Se encontro el cliente con cedula {}", cedula);
            return ResponseEntity.ok(this.service.buscarPorCedula(cedula));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/crear")
    public ResponseEntity crearProducto(@RequestBody ClienteRQ cliente) {
        try {
            this.service.crearCliente(Cliente.builder()
                                             .cedula(cliente.getCedula())
                                             .nombre(cliente.getNombre())
                                             .direccion(cliente.getDireccion())
                                             .telefono(cliente.getTelefono())
                                             .correo(cliente.getCorre()).build());
            log.info("Se creo el cliente con exito");
            return ResponseEntity.ok().build();
        } catch (InsertException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
