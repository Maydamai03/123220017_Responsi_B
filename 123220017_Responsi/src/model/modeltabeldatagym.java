/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabeldatagym extends AbstractTableModel{

    List<datagym> dp;
    public modeltabeldatagym(List<datagym>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Penyewa";
            case 1:
                return "Nama Alat";
            case 2:
                return "No_Telepon";
            case 3:
                return "Waktu Sewa";
            case 4:
                return "Biaya Sewa";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getNama();
            case 1:
                return dp.get(row).getAlat();
            case 2:
                return dp.get(row).getTelepon();
            case 3:
                return dp.get(row).getSewa();
            case 4:
                return dp.get(row).getTotalbiaya();
            default:
                return null;
        }
    }
    
}
