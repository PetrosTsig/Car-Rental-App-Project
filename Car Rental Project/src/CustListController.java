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


public class CustListController {
    
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

         /*--------------------- Deletes a customer that the user has typed-------------------------------------- */
    @FXML
    void DeleteCust(ActionEvent event) {

        String output;
        String SQL = "DELETE FROM customers WHERE surname = '" + searchbar.getText() + "'";// SQL Query
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/carrentals";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            java.sql.Statement sqlSt = dbConnect.createStatement();
            int result = sqlSt.executeUpdate(SQL);// result holds the output from the SQL
            if (result > 0) {
                output = " User deleted ! ";
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

    /*---------------------------------------------------------------------------------------------------------- */

     /*------------ Diplayes from the database the details of a customer that the users search ---------------*/

     @FXML
     private javafx.scene.control.TextArea TextArea;
 
     @FXML
     private TextField searchbar;
 
     @FXML
     void searchCustlist(ActionEvent event) {
 
         java.sql.Statement sqlSt;// runs sql
         String output;
         ResultSet result; // holds the output from SQL
         String SQL = "SELECT * FROM customers where surname = '" + searchbar.getText() + "'";// SQL Query
         try {
             Class.forName("com.mysql.jdbc.Driver");
             String dbURL = "jdbc:mysql://localhost:3306/carrentals";
             Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
             sqlSt = dbConnect.createStatement();
             result = sqlSt.executeQuery(SQL);// result holds the output from the SQL
             while (result.next() != false) {
                 output = " name: " + result.getString("name") + " surname: " + result.getString("surname")
                         + " phone number: " + result.getString("phone") + " email: " + result.getString("email");
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
 
     /*------------------------------------------------------------------------------------------------------------------------------------------------*/

      /*-------------------------- Update a reservation that the user has typed ----------------------------------*/
    @FXML
    void UpdateRes(ActionEvent event) {
        String output;
        String SQL = "Update customers SET " + searchbar.getText() + "";// SQL Query
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/carrentals";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            java.sql.Statement sqlSt = dbConnect.createStatement();
            int result = sqlSt.executeUpdate(SQL);// result holds the output from the SQL
            if (result > 0) {
                output = " Customer updated ! ";
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
