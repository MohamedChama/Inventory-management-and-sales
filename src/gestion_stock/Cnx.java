
package gestion_stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;


import java.util.logging.Logger;
public class Cnx {        
    public Connection get_Connection()
    {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "hr", "ntic");
        } catch (Exception ex) {
            Logger.getLogger(Cnx.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
}
