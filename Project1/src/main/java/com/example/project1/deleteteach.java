package com.example.project1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteteach {
    public static void deletech(){
        GridPane gridpane= new GridPane();
        gridpane.setStyle("-fx-Background-Color: chocolate");
        Label label13 = new Label("Enter ID");
        gridpane.add(label13,0,4);
        TextField textfield = new TextField();
        gridpane.add(textfield,1,4);
        Button button11 = new Button("deleted");
        gridpane.add(button11,0,5);
        button11.setOnAction(event-> {

            String string3 = textfield.getText();
            Boolean status=false;
            String query = "delete from TeacherTable where ID='"+string3+"'";
            ConnectionDB connection2 = new ConnectionDB();
            Connection connection = connection2.conMethod();
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try{
                status=statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } );
        Stage stage = new Stage();
        button11.setStyle("-fx-Background-Color: red");
        Scene scene = new Scene(gridpane,400,300);
        stage.show();
        stage.setScene(scene);
    }
}
