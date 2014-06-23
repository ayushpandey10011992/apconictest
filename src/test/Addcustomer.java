/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
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
import javafx.stage.Modality;
import javafx.scene.layout.VBoxBuilder;




public class Addcustomer extends Application {
    private static final Logger logger = Logger.getLogger(Addcustomer.class.getName());
    //declarations of string variable
    String name;
        String email;
        String phone;
        String address;
        String city;
        String state;
        String pincode;
        String country;
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Customer Record Management");
        //gridpane setup
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        //scene dimensions setup
        Scene scene=new Scene(grid,600,500);
        primaryStage.setScene(scene);
        //development for UI addcustomer module
        Text scenetitle = new Text("Add Personal Details");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label lblname = new Label("Customer Name");
        grid.add(lblname, 0, 1);
        
        Label lblemail=new Label("EMail");
        grid.add(lblemail,0,2);
        
        Label lblphone=new Label("Phone");
        grid.add(lblphone,0,3);
        
        Label lbladdress=new Label("Address");
        grid.add(lbladdress,0,4);
        
        Label lblcity=new Label("City");
        grid.add(lblcity,0,5);
        
        Label lblstate=new Label("State");
        grid.add(lblstate,0,6);
        
        Label lblpincode=new Label("Pin Code");
        grid.add(lblpincode,0,7);
        
        Label lblcountry=new Label("Country");
        grid.add(lblcountry,0,8);
        
        TextField txtname=new TextField();
        grid.add(txtname,1,1);
        
        TextField txtemail=new TextField();
        grid.add(txtemail,1,2);
        
        TextField txtphone=new TextField();
        grid.add(txtphone,1,3);
        
        TextField txtaddress=new TextField();
        grid.add(txtaddress,1,4);
        
        TextField txtcity=new TextField();
        grid.add(txtcity,1,5);
        
        TextField txtstate=new TextField();
        grid.add(txtstate,1,6);
        
        TextField txtpincode=new TextField();
        grid.add(txtpincode,1,7);
        
        TextField txtcountry=new TextField();
        grid.add(txtcountry,1,8);
        
        
        Button btnsubmit=new Button("Submit");
        grid.add(btnsubmit,2,9);
        
        Button btnback=new Button("Back");
        grid.add(btnback,0,9);
        
        
        //use of style sheets for styling by integrating CSS file
        scene.getStylesheets().add
 (Test.class.getResource("Test.css").toExternalForm());
        
        primaryStage.show();
        //event handler
        btnback.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage= new Stage();
      Test t = new Test();
      t.start(stage);
            }
        });
        
        //event handler
         btnsubmit.setOnAction(new EventHandler<ActionEvent>() {
              @Override public void handle(ActionEvent event) {
              Addcustomer();
              
              
  
  //getting from textboxes
        String name=txtname.getText();
        String email=txtemail.getText();
        String phone=txtphone.getText().toString();
        String address=txtaddress.getText();
        String city=txtcity.getText();
        String state=txtstate.getText();
        String pincode=txtpincode.getText().toString();
        String country=txtcountry.getText();
     
        if(name.equals("") && email.equals ("")&& phone.equals("") && address.equals("") && city.equals("") && state.equals("") && pincode.equals("") && country.equals("") )
        {
           JOptionPane.showMessageDialog(null, "Enter Specific Details");
        }
        
        txtname.setText("");
        txtemail.setText("");
        txtphone.setText("");
        txtaddress.setText("");
        txtcity.setText("");
        txtstate.setText("");
        txtpincode.setText("");
        txtcountry.setText("");
        
    
 
              }});
    }
    //declaration of database
    private void Addcustomer(){
    try (Connection con = getConnection()) {
      if (!schemaExists(con)) {
        createSchema(con);}
        populateDatabase(con);
      
      
    } catch (SQLException | ClassNotFoundException ex) {
      logger.log(Level.SEVERE, null, ex);
    }
   
  }//registering or loading h2 database driver
         private Connection getConnection() throws ClassNotFoundException, SQLException {
    logger.info("Getting a database connection");
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:~/customer", "sa", "");
  }
         //database creation(h2 embedded)
         private void createSchema(Connection con) throws SQLException {
    logger.info("Creating schema");
    Statement st = con.createStatement();
    String table = "create table customer(id integer, name varchar(64),email varchar(64),phone varchar(60),address varchar(90),city varchar(20),state varchar(20),pincode varchar(20),country varchar(20))";
    st.executeUpdate(table);
    logger.info("Created schema");
  }
         //entering values in database
         private void populateDatabase(Connection con) throws SQLException {
    logger.info("Populating database");      
    Statement st = con.createStatement();      
     {
      st.executeUpdate("insert into customer values(1,'" +name+ "','"+email+"','"+phone+"','"+address+"','"+city+"','"+state+"','"+pincode+"','"+country+"')");
    }
    logger.info("Populated database");
  }
        
        //checking whether schema exists or not 
         private boolean schemaExists(Connection con) {
    logger.info("Checking for Schema existence");      
    try {
      Statement st = con.createStatement();      
      st.executeQuery("select count(*) from customer");
      logger.info("Schema exists");      
    } catch (SQLException ex) {
      logger.info("Existing DB not found will create a new one");
      return false;
    }
    
    return true;
  }
        
    }
