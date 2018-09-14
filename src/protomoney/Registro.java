/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protomoney;

/**
 *
 * @author JoEnGr
 */

import java.sql.*;
import java.util.Scanner;
import org.apache.derby.jdbc.EmbeddedDriver;

public class Registro {
    private static String db = "jdbc:derby:Protoss; create = true; user= app; password= app";
    private static Connection ConnObj = null; //Allows to connect to DB
    private static Statement StatObj1=null; //Allows to run SQL procedures
    private static ResultSet ResObj=null; //Stores the SQL procedures data

    public static void insertaDB (String cues, String fecs, String clts, String descs, Double cats, String SubC){
        String cuenta = cues;
        String fecha = fecs;
        String cliente = clts;
        String desc = descs;
        Double cnts = cats;
        String catego = SubC;

    //aqui va la secuencia para definir el Statement e insertar en la tabla
    try {
        ConnObj = DriverManager.getConnection(db);
        Statement StatObj1 = ConnObj.createStatement();
        String pone = String.format("insert into PM_REGISTRY values (\'%s\',\'%s\',\'%s\',\'%s\',%s,\'%s\')", //Formato de una variable string para meter los datos string en variables
                                    cuenta, fecha, cliente, desc, cnts, catego);
        StatObj1.execute(pone);
        StatObj1.close();
        }
    catch (SQLException e)
        {
        e.printStackTrace();
        }
    }
    
    public static void despDB(){ //Imprime en pantalla los valores de la tabla registro
    try{
        ConnObj = DriverManager.getConnection(db);        
        Statement StatObj1 = ConnObj.createStatement();
        ResultSet ResObj = StatObj1.executeQuery("select * from app.test");
        System.out.println("cuenta:\t\t" +"fecha:\t\t\t" +"cliente:\t\t"+"descripcion:\t\t" +"cantidad:\t\t"+"categoria: \t\t"+"subcategoria: ");
        System.out.println("==================================================================================================================================================");
        while (ResObj.next()) {
            for (int i=1;i<8;i++){
               System.out.print(ResObj.getString(i)+ "\t"); 
            }
            System.out.println();
        }
        StatObj1.close();
        }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    }    
}
