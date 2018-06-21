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
public class Comuna {
    private int id_comuna;
    private String comuna;
    private int id_ciudad;
    
    public Comuna(){}
    public Comuna(int id, String nombre){
        this.id_comuna = id;
        this.comuna = nombre;

    }

    /**
     * @return the id_comuna
     */
    public int getId_comuna() {
        return id_comuna;
    }

    /**
     * @param id_comuna the id_comuna to set
     */
    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    /**
     * @return the comuna
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * @param comuna the comuna to set
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
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
    public String toString(){
        return this.comuna;
    }
}
