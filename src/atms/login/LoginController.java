/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atms.login;

import static atms.MainController.dbConnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nickb
 */
public class LoginController {

    @FXML
    private TextField studentID;

    @FXML
    private PasswordField stdPassword;

    @FXML
    private Button loginButton;

    @FXML
    void loginATMS(ActionEvent event) throws SQLException {
        final String stdName1 = studentID.getText().toString();
        final String password1 = stdPassword.getText().toString();
        
        try{
            Connection conn = dbConnect();
        Statement st = conn.createStatement();
        String statement = "SELECT * FROM atms_javafx.users Where username = '"+stdName1+"' AND password = '"+password1+"' ";
          ResultSet rs = st.executeQuery(statement); //step four
          System.out.println(rs);
          // Students usersdashboard = new Students();
          if(rs.next()){                   
        Parent part = FXMLLoader.load(getClass().getResource("/atms/students/StudentDashboard.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
//Alert a = new Alert(Alert.AlertType.INFORMATION);
//                    a.setContentText("You are successfully logged in!");
//                    a.show(); 
                    
                }else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("Invalid User Name or Password");
                    a.show(); 
                }
          conn.close();
        
                    
        }
        
        catch(Exception ee){System.out.println(ee);System.out.println("Connection error");} 
     
        
        }
      //DATABASE CONNECTION
    public static Connection dbConnect(){
        
        String url = "jdbc:mysql://localhost:3306/atms_javafx";
        String username = "root";
        String password = "";
        
        //load drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        
        //database connection
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
        

    }
