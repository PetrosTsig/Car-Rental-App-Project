import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustRegController {
    
        private Stage stage;
        private Scene scene;
        private Parent root;
    
        /*------------- Code that is responsible for the switch between the scenes ----------------*/
    
        // Switch to the scene that user can see all the listed cars
        @FXML
        void SwitchToCarList(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("CarCatalog.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }
    
        // Switch to the main scene of the application
        @FXML
        void SwitchToMain(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }
    
        // Switch to the scene that user can see all the registered customer
        @FXML
        void SwitchToCustCat(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("CustomerList.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }
    
        // Switch to the scene that user can see all the reservations
        @FXML
        void SwitchToResList(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("ReservationList.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }
    
        /*--------------------------------------------------------------------------------------------------------------- */

         // Button that saves the data of the new customer
    @FXML
    void RegisterCust(ActionEvent event) {

        String output;
        String SQL = "INSERT INTO customers(name,surname,phone,email) values('" + name.getText() + "','"
                + surname.getText() + "','" + phone.getText() + "','" + email.getText() + "')";// SQL Query
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/carrentals";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            java.sql.Statement sqlSt = dbConnect.createStatement();
            int result = sqlSt.executeUpdate(SQL);// result holds the output from the SQL
            if (result > 0) {
                output = " Registered succesful ! ";
                Title.setText(output);
            } else {
                output = "Something went wrong";
                Title.setText(output);
            }
            sqlSt.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL ERROR " + ex.getMessage());
            output = "Something went wrong";
            Title.setText(output);
        }

    }

    /*----------------------------------------------------------------------------------------------------------------------- */

    @FXML
    private Label Title;

    // variables

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TextField surname;
    
}
