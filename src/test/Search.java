
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




public class Search extends Application {
    private static final Logger logger = Logger.getLogger(Search.class.getName());
    //declarations of UI variables
    TextField txtname,txtemail,txtno;
    

    @Override
    public void start(Stage primaryStage){
            primaryStage.setTitle("Search Customers");
            
            //gridpane declaration
            GridPane grid=new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25,25,25,25));
        //scene declaration
            Scene scene=new Scene(grid,600,500);
            primaryStage.setScene(scene);
            
            //UI development
            Text scenetitle = new Text("Enter Details");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label lblname=new Label("Enter Name");
        grid.add(lblname,0,1);
        
        TextField txtname=new TextField();
        grid.add(txtname,1,1);
        
        Label lblemail=new Label("Enter Email");
        grid.add(lblemail,0,2);
        
        TextField txtemail=new TextField();
        grid.add(txtemail,1,2);
        
        Label lblno=new Label("Enter Phone No.");
        grid.add(lblno,0,3);
        
        TextField txtno=new TextField();
        grid.add(txtno,1,3);
        
        Button btnsearch=new Button("Search");
        grid.add(btnsearch,1,4);
        
        Text title = new Text("Results");
        title.setId("welcome-text");
        grid.add(title,0, 5);
        
        //use of style sheets for styling through a CSS file
        scene.getStylesheets().add
 (Test.class.getResource("Test.css").toExternalForm());
        
        primaryStage.show();
        
        //evebt handler
        btnsearch.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                  Search();
                
                  
                    
                    
                }
            });
        


}
    //database declaration(H2 embedded)
     private void Search(){
    try (Connection con = getConnection()) {
      if (schemaExists(con)) {
        searchschema(con);
      }
      
    } catch (SQLException | ClassNotFoundException ex) {
      logger.log(Level.SEVERE, null, ex);
    }
   
  }
     //registering or loading h2 embedded database
     private Connection getConnection() throws ClassNotFoundException, SQLException {
    logger.info("Getting a database connection");
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:~/customer", "sa", "");
  }
     //cheking whether the schema exist or not
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
      //searching in database
      private void searchschema(Connection con) throws SQLException {
    logger.info("Searching database");
    String  name=txtname.getText();
                String  email=txtemail.getText();
                String  phone=txtno.getText();
    
    Statement st = con.createStatement();   
        int rst=st.executeUpdate("Select * from Customer where name='"+ name +"' and email='"+email+"'and phone='"+phone+"'");
    
     
      
    
    logger.info("Searched database");
  }
      
      
    
}