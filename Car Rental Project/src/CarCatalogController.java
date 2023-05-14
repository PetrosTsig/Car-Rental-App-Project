import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CarCatalogController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private javafx.scene.control.TextArea TextArea;

    @FXML
    private TextField searchbar;

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

     /*-------------------------- Deletes a car that the user has typed ----------------------------------*/
     @FXML
     void DeleteCar(ActionEvent event) {
 
         String output;
         String SQL = "DELETE FROM cars WHERE plate = '" + searchbar.getText() + "'";// SQL Query
         try {
             Class.forName("com.mysql.jdbc.Driver");
             String dbURL = "jdbc:mysql://localhost:3306/carrentals";
             Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
             java.sql.Statement sqlSt = dbConnect.createStatement();
             int result = sqlSt.executeUpdate(SQL);// result holds the output from the SQL
             if (result > 0) {
                 output = " Car deleted ! ";
                 TextArea.setText(output);
             } else {
                 output = "Something went wrong";
                 TextArea.setText(output);
 
             }
             sqlSt.close();
 
         } catch (ClassNotFoundException ex) {
 
             Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Class not found, check the JAR");
         } catch (SQLException ex) {
             Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("SQL ERROR " + ex.getMessage());
         }
 
     }
 
     /*-------------------------------------------------------------------------------------------------------------*/

       /*------------ Diplayes from the database the details of a car that the users search ---------------*/
    @FXML
    void SearchCarList(ActionEvent event) {

        java.sql.Statement sqlSt;// runs sql
        String output;
        ResultSet result; // holds the output from SQL
        String SQL = "SELECT * FROM cars where plate = '" + searchbar.getText() + "'";// SQL Query
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/carrentals";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();
            result = sqlSt.executeQuery(SQL);// result holds the output from the SQL
            while (result.next() != false) {
                output = " Brand: " + result.getString("brand") + " Model: " + result.getString("model")
                        + " Licence plate: " + result.getString("plate") + " Color: " + result.getString("color");
                TextArea.setText(output);
            }
            sqlSt.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL ERROR " + ex.getMessage());
        }

    }

    /*----------------------------------------------------------------------------------------------------------------------------------*/

    /*-------------------------- Update a reservation that the user has typed ----------------------------------*/
    @FXML
    void UpdateRes(ActionEvent event) {
        String output;
        String SQL = "Update cars SET " + searchbar.getText() + "";// SQL Query
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/carrentals";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            java.sql.Statement sqlSt = dbConnect.createStatement();
            int result = sqlSt.executeUpdate(SQL);// result holds the output from the SQL
            if (result > 0) {
                output = " Cars updated ! ";
                TextArea.setText(output);
            } else {
                output = "Something went wrong";
                TextArea.setText(output);

            }
            sqlSt.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL ERROR " + ex.getMessage());
        }

    }

    /*-----------------------------------------------------------------------------------------------------------*/
    
}
