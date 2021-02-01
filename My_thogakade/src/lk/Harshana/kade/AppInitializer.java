package lk.Harshana.kade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.boot.model.naming.ImplicitPrimaryKeyJoinColumnNameSource;
import org.hibernate.mapping.PrimaryKey;

import java.applet.Applet;

public class AppInitializer extends Application{
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =FXMLLoader.load(this.getClass().getResource("view/CustomerFrom.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer Frome");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
