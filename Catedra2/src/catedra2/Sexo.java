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
public class Sexo {

    //public int id;
    public String sexo;

    //Connection connect;
    ConexionMySQL mysql = new ConexionMySQL();
    Connection cn = mysql.Conectar();

    public Sexo(String sexo) {
        this.sexo = sexo;
    }

    public Sexo() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void cargarS(JComboBox<Sexo> cbx_sexo) {

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String sSQL = "SELECT * FROM sexo ;";

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(sSQL);

            for (int i = 0; i <= 1; i++) {
                if (i == 0) {
                    int a = 0;
                    String b = "", s = "Seleccione Sexo";
                    cbx_sexo.addItem(
                            new Sexo(
                                 s
                            )
                    );
                } else {
                    while (rs.next()) {
                        cbx_sexo.addItem(
                                new Sexo(
                                        rs.getString("sexo")
                                )
                        );
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Sexo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {

        return sexo;
    }

}
