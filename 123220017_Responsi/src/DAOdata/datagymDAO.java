/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdata;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplement.dataimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lab Informatika
 */
public class datagymDAO implements dataimplement {
    
    Connection connection;
    final String select = "SELECT * FROM datagym";
    final String insert = "INSERT INTO `datagym`(`nama`, `alat`, `telepon`, `sewa`, `totalbiaya`) VALUES (?,?,?,?,?)";
    final String update = "UPDATE datagym SET alat=?, telepon=?, sewa=?, totalbiaya=? WHERE nama=?";
    final String delete = "DELETE FROM datagym WHERE nama=?";

    
    public datagymDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datagym p) {
        PreparedStatement statement = null;
    try{
        Integer totalbiaya = p.getSewa()* 50000;
//                if(p.getSewa()<=2){
//                    Integer totalbiaya = p.getSewa()* 50000;
//                }else{
//                    Integer totalbiaya = p.getSewa()* 25000;
//                }

        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, p.getNama());
        statement.setString(2, p.getAlat());
        statement.setString(3, p.getTelepon());
        statement.setInt(4, p.getSewa());
        statement.setInt(5, totalbiaya); 
        statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
        while(rs.next()){
            p.setNama(rs.getString(1));
        }
    }catch(SQLException ex){
        ex.printStackTrace();
    }finally{
        try{
            statement.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    }

    @Override
    public void update(datagym p) {
         PreparedStatement statement = null;
    try {
        statement = connection.prepareStatement(update);
        Integer totalbiaya = p.getSewa()* 50000;
//        if(p.getSewa()<=2){
//            Integer totalbiaya = p.getSewa()* 50000;
//        }else{
//            Integer totalbiaya = p.getSewa()* 25000;
//        }
//        Info Rumus ^_^        
        
        statement.setString(1, p.getAlat());
        statement.setString(2, p.getTelepon());
        statement.setInt(3, p.getSewa());
        statement.setInt(4, totalbiaya);
        statement.setString(5, p.getNama()); 
        
        statement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }

    @Override
    public void delete(String nama) {
        PreparedStatement statement = null;
    try {
        
        statement = connection.prepareStatement(delete);
        
        statement.setString(1, nama);
        
        statement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }

    @Override
    public List<datagym> getAll() {
        List<datagym> dp = null;
        try{
            dp = new ArrayList<datagym>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datagym gym = new datagym();
                gym.setNama(rs.getString("nama"));
                gym.setAlat(rs.getString("alat"));
                gym.setTelepon(rs.getString("telepon"));
                gym.setSewa(rs.getInt("sewa"));
                gym.setTotalbiaya(rs.getInt("totalbiaya"));
                dp.add(gym);
                
            }
            
        }catch(SQLException ex){
            Logger.getLogger(datagymDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return dp;
    }

    }
    

