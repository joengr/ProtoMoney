/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protomoney;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSetMetaData;
import org.apache.derby.jdbc.EmbeddedDriver;

public class ProtoMoney {
    /**
     * @param args the command line arguments
     */
    private static String dbnombre = "jdbc:derby:Protoss; create = true; user= app; password= app";
    private static Connection protoConnObj = null; //Allows to connect to DB
    private static Statement StatObj=null; //Allows to run SQL procedures
    private static ResultSet protoResObj=null; //Stores the SQL procedures data
    
    public static void main(String[] args) {
       // Solo nombrando los procedimientos, todos estan definidos abajo
       createConnection();
       creaTabla();
       //insertTabla();
       // DespliegaTabla();
       // termina();
    } 
    
    //Crea una conexion a la base de datos usando los argumentos abajo    
    private static void createConnection(){
    try{
        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        protoConnObj = DriverManager.getConnection(dbnombre);
        }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    }
    
    //Crea una tabla llamada PM_ACC_TYPE
    private static void creaTabla(){
    String tabla = "CREATE TABLE pm_acc_type (\n"
                + " codigo char(3) NOT NULL, \n"
                + " descrip char(30)\n"
                + ")";

    //aqui va la secuencia para definir el Statement y crear la tabla
    try 
        {
        protoConnObj = DriverManager.getConnection(dbnombre);
        Statement StatObj3 = protoConnObj.createStatement();
        StatObj3.execute(tabla);
        }
    catch (SQLException e)
        {
        e.printStackTrace();
        }
    }
    
    
    //Crea una secuencia de comandos para insertar en una tabla    
    private static void insertTabla(){
        String tabla = "PM_ACC_TYPE";
        String Nombre = "DE2";
        String tipo = "Debito con chequera";
    //aqui va la secuencia para definir el Statement e insertar en la tabla
    try {
        Statement StatObj2 = protoConnObj.createStatement();
        StatObj2.execute("insert into " + tabla + " values ('" + Nombre + "', '" + tipo + "')");
        StatObj2.close();
        }
    catch (SQLException e)
        {
        e.printStackTrace();
        }
    }
    
    }
