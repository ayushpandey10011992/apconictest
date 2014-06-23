/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.event.*;

/**
 *
 * @author FluXXx
 */
public class Test extends Application {
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Customer Record Management");
        //gridpane setup
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        //scene dimension setup
        Scene scene=new Scene(grid,600,500);
        primaryStage.setScene(scene);
        //UI components integrated here
        Text t=new Text("Customer Record Management");
        t.setId("welcome-text");
        t.setTextAlignment(TextAlignment.LEFT);
        grid.add(t, 0, 0, 2, 1);
        
        
        
        Button btnadd=new Button("Add Customer");
        Button btnsearch=new Button("Search Customer");
        grid.add(btnadd,1,2);
        grid.add(btnsearch,1,4);
        
        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        //use of style sheets for styling the UI
        scene.getStylesheets().add(Test.class.getResource("Test.css").toExternalForm());
        
        primaryStage.show();
        //event handler
        btnadd.setOnAction((ActionEvent e) -> {
            Stage stage= new Stage();
            Addcustomer add= new Addcustomer();
            add.start(stage);
            
        });
        //event handler
        btnsearch.setOnAction((ActionEvent e) -> {
            Stage stage= new Stage();
            Search s= new Search();
            s.start(stage);
            
            
        });
        
        
    }
   
    
    public static void main(String[] args) {
        launch(args);
    }
    
}