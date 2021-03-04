/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ec.examen.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author esteban
 */

@Data
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @Column(name = "cedula", length = 10)
    private String cedula;
    
    @Column(name = "nombre", length = 100)
    private String nombre;
    
    @Column(name = "direccion", length = 100)
    private String direccion;
    
    @Column(name = "telefono", length = 16)
    private String telefono;
    
    @Column(name = "correo", length = 100)
    private String correo;
    
}
