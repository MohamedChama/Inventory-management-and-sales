package gestion_stock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Commande {
    private int Id_commande;
    private String type_paiment;
    private int id_client;
    private int total;

    public Commande(int Id_commande,String type_paiment, int id_client, int total) {
        this.Id_commande = Id_commande;
        this.type_paiment=type_paiment;
        this.id_client = id_client;
        this.total = total;
    }

    public String getType_paiment() {
        return type_paiment;
    }

    public void setType_paiment(String type_paiment) {
        this.type_paiment = type_paiment;
    }

    public int getId_commande() {
        return Id_commande;
    }

    public void setId_commande(int Id_commande) {
        this.Id_commande = Id_commande;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getTotal() {
        return total;
    }

    public Commande() {
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public int max_id_commande(){
        try {
            Connection cn=new Cnx().get_Connection();
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select max(id_commande) from commandes");
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public void ajou_commande(Commande c)
    {
        try {
            Connection cn=new Cnx().get_Connection();
            Statement st=cn.createStatement();
            st.executeUpdate("insert into commandes values("+c.max_id_commande()+",'"+c.getType_paiment()+"',"+c.getId_client()+","+c.getTotal()+")");
            
        } catch (Exception ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
