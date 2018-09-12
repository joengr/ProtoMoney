/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protomoney;

import java.sql.*;
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
       //creaTabla();
       insertTabla();
       despliegaTabla();
       //termina();
    } 
    
    //Crea una conexion a la base de datos usando los argumentos abajo    
    private static void createConnection(){
    try{
        protoConnObj = DriverManager.getConnection(dbnombre);
        }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    }
    
    private static void creaTabla(){ //Procedimiento para crear una tabla embebida en la DB definida
        String tablas = "CREATE TABLE uno(dos char(3))"; //Definicion de la tabla y su estructura
    try 
        {
        protoConnObj = DriverManager.getConnection(dbnombre); //Asignacion de la conexion a la base de datos en dbnombre
        Statement StatObj3 = protoConnObj.createStatement(); //Asignacion de estatuto hacia la conexion a la DB
        StatObj3.execute(tablas); // Ejecucion del estatuto segun la variable 'tablas' definida arriba
        }
    catch (SQLException e)
        {
        e.printStackTrace();
        }
    }
    
    
    //Crea una secuencia de comandos para insertar en una tabla    
    private static void insertTabla(){
        String tabla = "PM_REGISTRO";
        String fecha = "2018-09-01";
        String cuenta = "Santander Cheques";
        String cliente = "Jonas 2";
        String desc = "Pago de tarjeta";
        String pone = String.format("insert into %s values (4,\'%s\',\'%s\',\'%s\',\'%s\',-299,3654.51)", //Formato de una variable string para meter los datos string en variables
                                    tabla, fecha, cuenta, cliente, desc);
      //String campo = pasa; no se necesitan los nombres de los campos

    //aqui va la secuencia para definir el Statement e insertar en la tabla
    try {
        Statement StatObj2 = protoConnObj.createStatement();
        StatObj2.execute(pone);
        StatObj2.close();
        }
    catch (SQLException e)
        {
        e.printStackTrace();
        }
    }
    
    private static void despliegaTabla(){ //Imprime en pantalla los valores de la tabla registro
        //String miras = String.format("insert into %s values (\'%s\')", tabla, Nombre);
    try{
        Statement StatObj2 = protoConnObj.createStatement();
        ResultSet protoResObj = StatObj2.executeQuery("select * from app.pm_registro");
        
        while (protoResObj.next()) {
            //System.out.println("id:\t" + protoResObj.getString(1));
            System.out.println("fecha:\t" + protoResObj.getString(2));
            System.out.println("cuenta:\t" + protoResObj.getString(3));
            System.out.println("cliente:\t" + protoResObj.getString(4));
            System.out.println("descripcion:\t" + protoResObj.getString(5));
            System.out.println("cantidad:\t" + protoResObj.getString(6));
            System.out.println("ROW5:\t" + protoResObj.getString(7));
            System.out.println();
        }
        
        StatObj2.close();
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
