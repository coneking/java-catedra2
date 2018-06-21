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
 * @author Coneking
 */
public class Comunas {

    //public int id;
    public String nombre;

    public Comunas(String nombre) {
        this.nombre = nombre;
    }

    public Comunas() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void cargarCm(JComboBox<Comunas> cbx_comuna) {

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        

        try {
            String sSQL = "SELECT * FROM comuna ;";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(sSQL);

            for (int i = 0; i <= 1; i++) {
                if (i == 0) {
                    int a = 0;
                    String b = "", c = "Seleccionar Comuna";
                    cbx_comuna.addItem(new Comunas(
                                 c
                            )
                    );
                } else {
                    while (rs.next()) {
                        cbx_comuna.addItem(new Comunas(
                                        rs.getString("comuna")
                                )
                        );
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Comunas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {

        return nombre;
    }

}
