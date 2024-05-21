/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdata.datagymDAO;
import DAOimplement.dataimplement;
import model.*;
import view.frameUtama;


public class datagymcontroller {
    frameUtama frame;
    dataimplement impldatagym;
    List<datagym> dp;
    
    public datagymcontroller(frameUtama frame){
        this.frame = frame;
        impldatagym = new datagymDAO();
        dp = impldatagym.getAll();
        
    }
    public void isitabel(){
        dp = impldatagym.getAll();
        modeltabeldatagym mp = new modeltabeldatagym(dp);
        frame.getTabeldatagym().setModel(mp);
    }
    
     public void insert(){
    datagym dp = new datagym();
    dp.setNama(frame.getJTxtNama().getText());
    dp.setAlat(frame.getJTxtAlat().getText());
    dp.setTelepon(frame.getJTxtTelepon().getText());
    
    Integer sewa = Integer.parseInt(frame.getJTxtSewa().getText());
    dp.setSewa(sewa);
   
    
    impldatagym.insert(dp);
}
     public void update(){
    datagym dp = new datagym();
    dp.setNama(frame.getJTxtNama().getText());
    dp.setAlat(frame.getJTxtAlat().getText());
    dp.setTelepon(frame.getJTxtTelepon().getText());
    Integer sewa = Integer.parseInt(frame.getJTxtSewa().getText());
    dp.setSewa(sewa);
    Integer totalbiaya = sewa*50000;
    dp.setTotalbiaya(totalbiaya);
    
    impldatagym.update(dp);
    
}
     public void delete() {
    
    String nama = frame.getJTxtNama().getText();
    impldatagym.delete(nama);
    
    isitabel();
}
}