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
public class TipoUsuario {
    private int idTipo_Usuario;
    private String NombreTipo_Usuario;
    private int Status;
    private String Descripcion;

    public int getIdTipo_Usuario() {
        return idTipo_Usuario;
    }

    public void setIdTipo_Usuario(int idTipo_Usuario) {
        this.idTipo_Usuario = idTipo_Usuario;
    }

    public String getNombreTipo_Usuario() {
        return NombreTipo_Usuario;
    }

    public void setNombreTipo_Usuario(String NombreTipo_Usuario) {
        this.NombreTipo_Usuario = NombreTipo_Usuario;
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
