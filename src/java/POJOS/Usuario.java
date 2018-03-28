/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author Valka
 */
public class Usuario {
    private int idUsuarios;
    private String nombre_usuario;
    private String contrasenia;
    private TipoUsuario ObjTipo_Usuario;
    private int Status;
    private String Descripcion;

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoUsuario getObjTipo_Usuario() {
        return ObjTipo_Usuario;
    }

    public void setObjTipo_Usuario(TipoUsuario ObjTipo_Usuario) {
        this.ObjTipo_Usuario = ObjTipo_Usuario;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
