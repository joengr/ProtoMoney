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
    
    public static void main(String[] args) {
    // Solo nombrando los procedimientos, todos estan definidos abajo
       createConnection();
       while (salida){
       llamaopcion();
       //termina();
       }
    } 
    
    private static void llamaopcion(){
    Scanner reader = new Scanner(System.in);     //Nueva instancia de la clase Scanner
                
    System.out.println("Seleccione la opcion a utilizar ");
    System.out.println("===============================");
    System.out.println("Nueva entrada:       1");
    System.out.println("Consultar valores:   2");
    System.out.print("Seleccion: ");    
    int n = reader.nextInt();  //Esta es la linea para leer lo que el usuario teclea
   // System.out.print("leido: ");
    switch (n){
        case 1:
            metedb("Santander Cheques","2018-08-19", "Jose Rodriguez", "Sueldo del 22 de Agosto", 4087.53, "SBT");
            salida = false;
            break;
        case 2:
            despliegaTabla();
            salida = false;
            break;
        default:
            System.out.println("Numero no valido");
            salida = true;
            break;
    }
    
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
    
    public static void metedb (String cues, String fecs, String clts, String descs, Double cats, String SubC){
        String tabla = "PM_REGISTRY";
        String cuenta = cues;
        String fecha = fecs;
        String cliente = clts;
        String desc = descs;
        Double cnts = cats;
        String catego = SubC;

      //String campo = pasa; no se necesitan los nombres de los campos

    //aqui va la secuencia para definir el Statement e insertar en la tabla
    try {
        Statement StatObj2 = protoConnObj.createStatement();
        //ResultSet protoResObj = StatObj2.executeQuery("select * from app.pm_registry"); no se necesita, estaba solo para leer e insertar al final
        String pone = String.format("insert into %s values (\'%s\',\'%s\',\'%s\',\'%s\',%s,\'%s\')", //Formato de una variable string para meter los datos string en variables
                                    tabla, cuenta, fecha, cliente, desc, cnts, catego);
        StatObj2.execute(pone);
        StatObj2.close();
        }
    catch (SQLException e)
        {
        e.printStackTrace();
        }
    }
    
    private static void despliegaTabla(){ //Imprime en pantalla los valores de la tabla registro
        //String miras = String.format("insert into %s values (\'%s\')", tabla, Nombre); bien naco el miras
    try{
        Statement StatObj2 = protoConnObj.createStatement();
        ResultSet protoResObj = StatObj2.executeQuery("select * from app.test");
        System.out.println("cuenta:\t\t" +"fecha:\t\t\t" +"cliente:\t\t"+"descripcion:\t\t" +"cantidad:\t\t"+"categoria: \t\t"+"subcategoria: ");
        System.out.println("==================================================================================================================================================");
        while (protoResObj.next()) {
            for (int i=1;i<8;i++){
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
