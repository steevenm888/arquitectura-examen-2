/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ec.examen.mysql.api.dto;

import lombok.Data;

/**
 *
 * @author esteban
 */

@Data
public class ClienteRQ {
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String corre;
}
