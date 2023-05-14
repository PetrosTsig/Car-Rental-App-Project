import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    /*------------- Code that is responsible for the switch between the scenes ----------------*/

    // Switch to the scene that the user can list cars
    @FXML
    void SwitchToCar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ListCar.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

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

    // Switch to the scene that user can register a new customer
    @FXML
    void SwitchToCust(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustRegister.fxml"));
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

    // Switch to the scene that user can create a new reservations
    @FXML
    void SwitchToRes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ReservationScene.fxml"));
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
}