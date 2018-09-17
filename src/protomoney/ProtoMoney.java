/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protomoney;

import java.sql.*;
import java.util.Scanner;
import org.apache.derby.jdbc.EmbeddedDriver;

public class ProtoMoney {
    /**
     * @param args the command line arguments
     */
    private static String dbnombre = "jdbc:derby:Protoss; create = true; user= app; password= app";
    private static Connection protoConnObj = null; //Allows to connect to DB
    private static Statement StatObj=null; //Allows to run SQL procedures
    private static ResultSet protoResObj=null; //Stores the SQL procedures data
    private static boolean salida = true;
    private Integer opcion;
    static Registro tablas = new Registro(); //clase que contiene los procedimientos de la tabla REGISTRO
    
    public static void main(String[] args) {
    // Solo nombrando los procedimientos, todos estan definidos abajo
       createConnection();
       while (salida){
       llamaopcion();
       }
    } 
    
    private static void llamaopcion(){
    Scanner reader = new Scanner(System.in);     //Nueva instancia de la clase Scanner
                
    System.out.println("Seleccione la opcion a utilizar ");
    System.out.println("===============================");
    System.out.println("Nueva entrada:       1");
    System.out.println("Consultar valores:   2");
    System.out.println("Salir del sistema:   3");
    System.out.print("Seleccion: ");    
    int n = reader.nextInt();  //Esta es la linea para leer lo que el usuario teclea
    switch (n){
        case 1:
            tablas.insertaDB("BoA Cheques","2017-10-16", "Laura Gatus Diego", "Gastos en ShopRite y Trader Joes", -33.59, "SBT");
            break;
        case 2:
            tablas.despDB();
            break;
        case 3:
            salida=false;
            termina();
            break;            
        default:
            System.out.println("Numero no valido");
            salida = true;
            break;
    }
    
    }
     
    private static void createConnection(){       //Crea una conexion a la base de datos usando los argumentos abajo   
    try{
        protoConnObj = DriverManager.getConnection(dbnombre);
        }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    }
    
    private static void termina(){ //Da de baja la base de datos y el servicio
    try{
        protoConnObj = DriverManager.getConnection("jdbc:derby:Protoss;shutdown=true");
        }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    }
    
    }
