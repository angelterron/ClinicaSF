/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author agustkd96
 */
public class Consultas extends Conexion{
    
    public boolean autenticacion(String Usuario,String Contraseña){
        PreparedStatement pst=null;
        ResultSet rs=null;
        
        try {
            String consulta="select * from usuarios where nombre_usuario= ? and contrasenia=? and Status=1";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, Usuario);
            pst.setString(2, Contraseña);
            rs=pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error"+e);
        }finally{
            try {
                 if(getConexion()!=null)
                    getConexion().close();
                 if(pst!=null)
                     pst.close();
                 if(rs!=null)
                     rs.close();
            } catch (Exception e) {
                System.err.println("Error "+e);
            }
        }
        
        return false;
    }
    
    public boolean registrar(String usuario, String contraseña, int Tipo_Usuario, int Status ){
        PreparedStatement pst = null;
        
        try {
            getConexion().setAutoCommit(false);
            String query="insert into usuarios (nombre_usuario,contrasenia,idEmpleado,idTipo_Usuario,Status, Descripcion) values (?,?,2,?,?,NULL)";
            pst=getConexion().prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            pst.setInt(3, Tipo_Usuario);
            pst.setInt(4, Status);
            
            if(pst.executeUpdate()==1){
                getConexion().commit();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error "+e);
        }finally{
            try {
                 if(getConexion()!=null)
                    getConexion().close();
                 if(pst!=null)
                     pst.close();
            } catch (Exception e) {
                System.err.println("Error "+e);
            }
        }

        return false;
    }
    
    public String getNombreTipo_Empleado(String userID){
        PreparedStatement pst=null;
        ResultSet rs=null;
        String result=null;
     try {
            String consulta="select * from usuarios,Tipo_Usuario where Usuarios.idTipo_Usuario=Tipo_Usuario.idTipo_Usuario and idUsuarios=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, userID);
            rs=pst.executeQuery();
            if(rs.absolute(1)){
                result = ""+rs.getString("NombreTipo_Usuario");
                return result;
            }
        } catch (Exception e) {
            System.err.println("Error"+e);
        }finally{
            try {
                 if(getConexion()!=null)
                    getConexion().close();
                 if(pst!=null)
                     pst.close();
                 if(rs!=null)
                     rs.close();
            } catch (Exception e) {
                System.err.println("Error "+e);
            }
        }
        
        return result;
    }
    

    
    public String getIDyTipo(String usuario){
        PreparedStatement pst=null;
        ResultSet rs=null;
        String resultid=null;
        String resultfin=null;
        try {
            String consulta="select * from usuarios where nombre_usuario= ? and Status=1";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs=pst.executeQuery();
            
            if(rs.absolute(1)){
                resultid = ""+rs.getInt("idUsuarios");
                resultfin=getNombreTipo_Empleado(resultid);
                return resultfin;
            }
        } catch (Exception e) {
            System.err.println("Error"+e);
        }finally{
            try {
                 if(getConexion()!=null)
                    getConexion().close();
                 if(pst!=null)
                     pst.close();
                 if(rs!=null)
                     rs.close();
            } catch (Exception e) {
                System.err.println("Error "+e);
            }
        }
        
        return resultfin;
    }
    
    public String getIDTipo_Empleado(String usuario){
        PreparedStatement pst=null;
        ResultSet rs=null;
        
        String resultfin=null;
        try {
            String consulta="select * from usuarios where nombre_usuario= ? and Status=1";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            
            rs=pst.executeQuery();
            if(rs.absolute(1)){
                resultfin = ""+rs.getInt("idUsuarios");
                return resultfin;
            }
        } catch (Exception e) {
            System.err.println("Error"+e);
        }finally{
            try {
                 if(getConexion()!=null)
                    getConexion().close();
                 if(pst!=null)
                     pst.close();
                 if(rs!=null)
                     rs.close();
            } catch (Exception e) {
                System.err.println("Error "+e);
            }
        }
        
        return resultfin;
    }
    
}
