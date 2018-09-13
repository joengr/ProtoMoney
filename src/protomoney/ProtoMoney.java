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
       metedb("2018-06-24", "BoA Checking", "Dos Mas", "Para mas pagos apropiados", -25.63);
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
    
    public static void metedb (String fecs, String cues, String clts, String descs, Double cats){
        String tabla = "PM_REGISTRO";
        String fecha = fecs;
        String cuenta = cues;
        String cliente = clts;
        String desc = descs;
        Double cnts = cats;
        Integer sigue = 1;
      //String campo = pasa; no se necesitan los nombres de los campos

    //aqui va la secuencia para definir el Statement e insertar en la tabla
    try {
        Statement StatObj2 = protoConnObj.createStatement();
        ResultSet protoResObj = StatObj2.executeQuery("select * from app.pm_registro");
        while (protoResObj.next()) {
               sigue ++; 
               }
        String pone = String.format("insert into %s values (%s,\'%s\',\'%s\',\'%s\',\'%s\',%s,3654.51)", //Formato de una variable string para meter los datos string en variables
                                    tabla, sigue, fecha, cuenta, cliente, desc, cnts);
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
        System.out.println("fecha:\t\t" +"cuenta:\t\t\t" +"cliente:\t\t"+"descripcion:\t\t" +"cantidad:\t\t"+"saldo:");
        System.out.println("===============================================================================================================================");
        while (protoResObj.next()) {
            for (int i=2;i<8;i++){
               System.out.print(protoResObj.getString(i)+ "\t"); 
            }
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
