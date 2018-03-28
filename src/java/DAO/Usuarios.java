/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Usuario;
import java.util.ArrayList;
import Controlador.Consultas;

/**
 *
 * @author Valka
 */
public class Usuarios {
    public ArrayList<Usuario> obtenerUsuarios(){
        Consultas consulta = new Consultas();
        return consulta.getUsuarios();
    }
    
    public boolean AltaUsuario(String idUser){
        
        Consultas consulta= new Consultas();
        return consulta.ActivarUsuario(idUser);
    }
    
    public boolean BajaUsuario(String idUser){
        
        Consultas consulta= new Consultas();
        return consulta.BajaUsuario(idUser);
    }
}
