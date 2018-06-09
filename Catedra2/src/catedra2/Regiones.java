/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catedra2;

import Base_Datos.ConexionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author pabloleon
 */
public class Regiones {
     public int id;
    public String nombre, num_r;

    //Connection connect;
     ConexionMySQL mysql = new ConexionMySQL();
     Connection cn = mysql.Conectar();


    public Regiones(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Regiones() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum_r() {
        return num_r;
    }

    public void setNum_r(Integer id) {
        this.num_r = num_r;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void cargarR(JComboBox<Regiones> cbx_region){
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "SELECT * FROM region ;";
        
        try
        {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(sSQL); 


            for (int i=0; i<=1; i++){
                if (i == 0){
                    int a = 0; String b ="", c ="Seleccionar Región";
                    cbx_region.addItem(
                        new Regiones(
                            a,
                            c
                        )
                    );
                }
                else{
                while(rs.next()){
                    cbx_region.addItem(
                            new Regiones(
                                rs.getInt("id_region"),
                                rs.getString("region_ordinal")+" - "+ rs.getString("region")
                            )
                    );
                }
            }
        }

    } catch (Exception ex) {
        Logger.getLogger(Regiones.class.getName()).log(Level.SEVERE, null, ex);
    }

}


@Override
public String toString(){

    return nombre;
}
}