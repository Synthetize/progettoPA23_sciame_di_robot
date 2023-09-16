package it.unicam.cs.followme.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

import static javafx.application.Application.launch;


public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            System.out.println(getClass().getClassLoader().getResource("App.fxml"));
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("App.fxml")));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Configurations");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
