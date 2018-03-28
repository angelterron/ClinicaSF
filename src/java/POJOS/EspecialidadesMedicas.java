/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author agustkd96
 */
public class EspecialidadesMedicas {
    private int idEsp_Medicas;
    private String NombreEsp_Medica;
    private int Status;
    private String Descripcion;

    public int getIdEsp_Medicas() {
        return idEsp_Medicas;
    }

    public void setIdEsp_Medicas(int idEsp_Medicas) {
        this.idEsp_Medicas = idEsp_Medicas;
    }

    public String getNombreEsp_Medica() {
        return NombreEsp_Medica;
    }

    public void setNombreEsp_Medica(String NombreEsp_Medica) {
        this.NombreEsp_Medica = NombreEsp_Medica;
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
