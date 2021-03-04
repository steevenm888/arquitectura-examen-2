/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ec.examen.mysql.service;

import ec.edu.ec.examen.mysql.exception.InsertException;
import ec.edu.ec.examen.mysql.exception.NotFoundException;
import ec.edu.ec.examen.mysql.model.Cliente;
import ec.edu.ec.examen.mysql.repository.ClienteRepository;
import java.time.chrono.IsoEra;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author esteban
 */

@Service
@Slf4j
public class ClienteService {
    private final ClienteRepository clienteRepository;
    
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    
    public Cliente buscarPorCedula(String cedula) throws NotFoundException {
        Optional<Cliente> cliente = this.clienteRepository.findByCedula(cedula);
        if(cliente.isPresent()) {
            return cliente.get();
        } else {
            log.error("No se pudo encontrar al cliente con cedula {}", cedula);
            throw new NotFoundException("No se pudo encontrar un cliente con cedula: "+cedula);
        }
    }
    
    public void crearCliente(Cliente cliente) throws InsertException {
        Cliente clienteGuardado = this.clienteRepository.save(cliente);
        if(clienteGuardado == null) {
            log.error("No se pudo crear al cliente");
            throw new InsertException("cliente", "No se pudo guardar el cliente");
        }
    }
}
