/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;
import java.util.List;
import model.*;
/**
 *
 * @author Lab Informatika
 */
public interface dataimplement {
    public void insert(datagym p);
    public void update(datagym p);
    public void delete(String nama);
    public List<datagym>getAll();
}
