package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Szamani on 6/26/2015.
 */
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Stick Hero");

        Stage stage = new Stage();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        Scene scene1 = new Scene(vBox);
        stage.setScene(scene1);
        stage.setWidth(380);
        stage.setHeight(150);
        stage.setResizable(false);
        stage.setTitle("Welcome");
        stage.show();
        Label label = new Label("Name:                            ");
        TextField textField = new TextField();
        Button button = new Button("OK");
        hBox.getChildren().addAll(label, textField);
        vBox.getChildren().addAll(hBox, new Separator(), button);

        button.setOnAction(e -> {
            if (textField.getText() != null) {
                stage.close();
                e.consume();
                primaryStage.show();
                primaryStage.setOnCloseRequest(event -> System.exit(0));
                new StickHero(scene, group, textField.getText());
            }
        });
    }
}
