/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protomoney;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author JoEnGr
 */
public class Test extends Application {
        static Registro tablas = new Registro();
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Desplegar Tabla");
        //Font bigger = new Font(30); Estas tres lineas son de prueba para el tamano de la fuente y el texto del boton
        //btn.setFont(bigger);
        //btn.setText("Say 'Desplegar Tabla'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                //tablas.despDB();
                tabloide();
            }
        });
        


        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 800, 250);
        primaryStage.setTitle("ProtoMoney v0.10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void tabloide(Stage segunda){
        TableView table = new TableView();
        table.setEditable(true);
        
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");  
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        //emailCol.setVisible(false);
        StackPane dos = new StackPane();
        dos.getChildren().add(table);
        Scene duo = new Scene(dos, 800, 250);
        segunda.setTitle("ProtoMoney v0.10");
        segunda.setScene(duo);
        segunda.show();
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
