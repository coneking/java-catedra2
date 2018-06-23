/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Base_Datos.ConexionMySQL;
import catedra2.Region;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author sconejer
 */
public class Region_combo {

    public void listar_region(JComboBox box) {
        DefaultComboBoxModel value;
        ConexionMySQL conec = new ConexionMySQL();
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = conec.Conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select * from region");
            value = new DefaultComboBoxModel();
            box.setModel(value);

            value.addElement(new Region(0, "Seleccione Región"));

            while (rs.next()) {
                value.addElement(new Region(rs.getInt(1), rs.getString(2)));

            }

        } catch (Exception ex) {
        } finally {
            try {
                st.close();
                rs.close();
            } catch (Exception ex) {
            }
        }
    }
}
