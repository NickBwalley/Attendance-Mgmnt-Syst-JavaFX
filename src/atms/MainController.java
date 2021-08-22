package atms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    void getLoginPage(ActionEvent event) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("/atms/login/login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
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
    public void registerStudent(ActionEvent event) throws SQLException {
        final String stdName1 = studentName.getText().toString();
        final String stdID1 = studentID.getText().toString();
        final String stdEmail1 = studentEmail.getText().toString();
        final String stdPassword1 = password.getText().toString();
        
        Connection conn = dbConnect();
        Statement st = conn.createStatement();
        String query = "INSERT INTO users(username, user_id, email, role_id, password) VALUES('"+stdName1+"', '"
                +stdID1+"', '"+stdEmail1+"', '"+1+"', '"+stdPassword1+"')";
        st.executeUpdate(query);
        // System.out.println(name + " successfully registered!");
        conn.close();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(stdName1+ " successfully registered!");
        a.show();
        conn.close();
                
    }
    
    
    

}
