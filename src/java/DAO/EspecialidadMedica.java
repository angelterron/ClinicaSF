/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Consultas;
import POJOS.EspecialidadesMedicas;
import java.util.ArrayList;

/**
 *
 * @author agustkd96
 */
public class EspecialidadMedica {
    public ArrayList <EspecialidadesMedicas> obtenerEspecialidades(){
        Consultas consulta = new Consultas();
        return consulta.getEspecialidades();
    }
}
