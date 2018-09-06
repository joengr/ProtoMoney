/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protomoney;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.derby.jdbc.EmbeddedDriver;

/**
 *
 * @author jrodrig1
 */
public class ProtoMoney {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here, veremos que hacemos con este codigo
    Connection protoConnObj = null; //Allows to connect to DB
    Statement protoStatObj=null; //Allows to run SQL procedures
    ResultSet protoResObj=null; //Stores the SQL procedures data
    try{
        protoConnObj = DriverManager.getConnection("jdbc:derby://localhost:1527:proto2", "apps", "apps");
        
    }
    catch (SQLException e){
    e.printStackTrace();
    }
    
    }
    
}
