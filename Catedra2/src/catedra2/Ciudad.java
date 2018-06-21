/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catedra2;

/**
 *
 * @author sconejer
 */
public class Ciudad {
    private int id_ciudad;
    private String ciudad;
    private int id_region;
    
    public Ciudad(){}
    
    public Ciudad(int id, String nombre){
        this.id_ciudad = id;
        this.ciudad = nombre;
    }

    /**
     * @return the id_ciudad
     */
    public int getId_ciudad() {
        return id_ciudad;
    }

    /**
     * @param id_ciudad the id_ciudad to set
     */
    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the id_region
     */
    public int getId_region() {
        return id_region;
    }

    /**
     * @param id_region the id_region to set
     */
    public void setId_region(int id_region) {
        this.id_region = id_region;
    }
    
    public String toString (){
        return this.ciudad;
    }
}
