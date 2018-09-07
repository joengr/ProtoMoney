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
import java.sql.ResultSetMetaData;
//import org.apache.derby.jdbc.EmbeddedDriver; Driver para la base de datos incluida

public class ProtoMoney {
    /**
     * @param args the command line arguments
     */
    private static String dbnombre = "jdbc:derby:ProtoMoney; create = true; user= apps; password= apps";
    private static Connection protoConnObj = null; //Allows to connect to DB
    private static Statement protoStatObj=null; //Allows to run SQL procedures
    private static ResultSet protoResObj=null; //Stores the SQL procedures data
    
    public static void main(String[] args) {
       // Solo nombrando los procedimientos, todos estan definidos abajo
        createConnection();
       // insertTabla();
       // DespliegaTabla();
       // termina();
    }    
    //Crea una conexion a la base de datos usando los argumentos abajo    
    private static void createConnection()
    {
    try{
        protoConnObj = DriverManager.getConnection(dbnombre);
        //protoConnObj = DriverManager.getConnection("jdbc:derby://localhost:1527/proto2; create = true; user= apps; password= apps");
    }
    catch (SQLException e){
    e.printStackTrace();
    }
    }
    }
