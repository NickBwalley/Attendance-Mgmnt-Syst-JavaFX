package atms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField studentName;

    @FXML
    private PasswordField password;

    @FXML
    private TextField studentID;

    @FXML
    private TextField studentEmail;
    
    @FXML
    private Button registerButton;


    @FXML
    void getLoginPage(ActionEvent event) {
        // Main m = new Main();
        // m.changeScene(fxml: "Main.fxml");

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
    
    @FXML
    public void runMe(ActionEvent event) {
//        System.out.println("This is just a dummy text!");
//          Alert a = new Alert(Alert.AlertType.WARNING);
//          a.setContentText("Invalid User Name or Password");
//          a.show();
//        Connection conn = dbConnect();
//        Statement st = conn.createStatement();
//        String query = "INSERT INTO users(username, user_id, email, role_id, password) VALUES('"+studentName+"', '"
//                +studentID+"', '"+studentEmail+"', '"+1+"', '"+password+"')";
//        st.executeUpdate(query);
//        // System.out.println(name + " successfully registered!");
//        conn.close();
        System.out.println("We Are Legion!");
        registerButton.setText("Stop Touching me!");
    }
    
    
    

}
