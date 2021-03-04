/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ec.examen.mysql.repository;

import ec.edu.ec.examen.mysql.model.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esteban
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
    Optional<Cliente> findByCedula(String cedula);
}
