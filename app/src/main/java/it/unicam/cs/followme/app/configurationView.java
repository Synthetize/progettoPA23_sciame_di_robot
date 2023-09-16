package it.unicam.cs.followme.app;

import it.unicam.cs.followme.list.Model.Coordinates;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class configurationView {
    @FXML
    public Button program_button;
    @FXML
    public Button env_button;
    @FXML
    public Button add_Robot;
    @FXML
    public TextField text_Box_1;
    @FXML
    public TextField text_Box_2;
    @FXML
    public Button random_Button;
    @FXML
    public TextArea robotTextArea;
    @FXML
    public Button loadSettinga;


    private File programFile;
    private File envFile;
    private final ArrayList<Coordinates> robotCoordinates = new ArrayList<>();
    @FXML
    public void loadProgram(ActionEvent actionEvent) {
        programFile = fileChooser(actionEvent);
    }
    @FXML
    public void loadEnvironment(ActionEvent actionEvent) {
        envFile = fileChooser(actionEvent);
    }
    @FXML
    public void addRobot(ActionEvent actionEvent) {
        if(!(text_Box_1.getText().isEmpty()) && !(text_Box_2.getText().isEmpty())){
                    robotCoordinates.add(new Coordinates(Double.parseDouble(text_Box_1.getText()), Double.parseDouble(text_Box_2.getText())));
                    robotTextArea.setText(robotTextArea.getText() +"\n Robot added: "+ text_Box_1.getText() + " " + text_Box_2.getText());
        } else{
            robotTextArea.setText("Invalid input");
        }
    }
    @FXML
    public void generateCoordinates(ActionEvent actionEvent) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double randomX = Math.random()*10;
        double randomY = Math.random()*10;
        robotCoordinates.add(new Coordinates(randomX, randomY));
        robotTextArea.setText(robotTextArea.getText() +"\n Robot added: "+ formatter.format(randomX) + " " + formatter.format(randomY));
    }

    private File fileChooser(ActionEvent actionEvent) {
        final FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void loadSettings(ActionEvent actionEvent) {
        try {
            FXMLLoader loader =  new FXMLLoader(getClass().getClassLoader().getResource("Environment.fxml"));
            Parent root = loader.load();
            simulationAreaView viewController = loader.getController();
            //envFile = new File("C:\\Users\\leona\\Desktop\\progettoPA_Sciame_di_Robot\\configurations\\environment_test.txt");
            //programFile = new File("C:\\Users\\leona\\Desktop\\progettoPA_Sciame_di_Robot\\configurations\\adas.txt");
            viewController.initialize(envFile, programFile, robotCoordinates);

            Stage stage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
