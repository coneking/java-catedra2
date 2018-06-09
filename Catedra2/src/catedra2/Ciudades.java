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
public class Ciudades {

    //public int id;
    public String nombre;

    //Connection connect;
    ConexionMySQL mysql = new ConexionMySQL();
    Connection cn = mysql.Conectar();

    public Ciudades(String nombre) {
        this.nombre = nombre;
    }

    public Ciudades() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void cargarC(JComboBox<Ciudades> cbx_ciudad) {

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "SELECT * FROM ciudad ;";

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(sSQL);

            for (int i = 0; i <= 1; i++) {
                if (i == 0) {
                    int a = 0;
                    String b = "", c = "Seleccionar Ciudad";
                    cbx_ciudad.addItem(
                            new Ciudades(
                                 c
                            )
                    );
                } else {
                    while (rs.next()) {
                        cbx_ciudad.addItem(
                                new Ciudades(
                                        rs.getString("ciudad")
                                )
                        );
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Ciudades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {

        return nombre;
    }

}
