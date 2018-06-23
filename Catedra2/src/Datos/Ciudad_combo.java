/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Base_Datos.ConexionMySQL;
import catedra2.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author sconejer
 */
public class Ciudad_combo {
    public void listar_ciudad(JComboBox box, int id){
        DefaultComboBoxModel value;
        ConexionMySQL conec = new ConexionMySQL();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        
        try{
            con = conec.Conectar();
            ps = con.prepareStatement("SELECT * FROM ciudad where id_region = ? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            box.setModel(value);
            
            value.addElement(new Ciudad(0, "Seleccione Ciudad"));
            while(rs.next()){
                value.addElement(new Ciudad(rs.getInt(1),rs.getString(2)));
                
            }
        }catch(Exception ex){
        }finally{
            try{
                ps.close();
                rs.close();
            }catch(Exception ex){
            }
        }
    }
    
}
