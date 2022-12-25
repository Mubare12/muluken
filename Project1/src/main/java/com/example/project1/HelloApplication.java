package com.example.project1;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        Label label = new Label("College Management System");
        label.setFont(new Font("italic",25));
        label.setLayoutX(35);
        label.setLayoutY(35);
        Group group1 = new Group();
        Button button1 = new Button("Student Information");
        button1.setFont(new Font("italic",20));
        button1.setLayoutX(85);
        button1.setLayoutY(130);
        button1.setOnAction(e ->student.stud());
        Button button2 = new Button("Teacher Information");
        button2.setFont(new Font("italic",20));
        button2.setLayoutX(85);
        button2.setLayoutY(200);
        button2.setOnAction(e -> Teacher.tech());
        group1.getChildren().addAll(label,button1,button2);
        Scene scene1 = new Scene(group1,500,400);
        scene1.setFill(Color.BISQUE);
        primarystage.setScene(scene1);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}