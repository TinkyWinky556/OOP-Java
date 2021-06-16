/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporary;

import java.lang.String;
 
// Import JDBC Classes.
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EDWARD
 */
public class Temporary {

    /**
     ** Demo : Fetch A Whole MySQL Table !
     ** @param args
     */
    public static void main(String[] args) throws SQLException {
        String myUrl = "jdbc:mysql://localhost:3306/COMPANY";
        String userName = "root";
        String passWord = "12345";
        
        String myQuery = "select * from employee";
        String userData;
        
        try {
            // Load MySQL_JDBC Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create Connection.
            Connection con = DriverManager.getConnection(myUrl, userName, passWord);
            
            // Create Statement.
            Statement st = con.createStatement();
            
            // Execute Query.
            ResultSet res = st.executeQuery(myQuery);
            
            // Fetch The Whole Table.
            while(res.next()){
                userData = res.getString(1) + " : " + res.getString(2) + " : " + res.getString(3) + " : " + res.getString(4) + " : " + res.getString(5) + " : " + res.getString(6) + " : " + res.getString(7) + " : " + res.getString(8);
                System.out.println(userData);
            }
            
            st.close();
            con.close();
            
        } 
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Temporary.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException sql_err){
            System.out.println(sql_err.getMessage());
        }

        
    }
    
}
