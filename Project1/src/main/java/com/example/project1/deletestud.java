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

public class deletestud {
    public static void deletestd(){
        Stage stage = new Stage();

        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-Background-Color: aqua");
        Label label12 = new Label("Enter ID");
        gridpane.add(label12,0,4);
        TextField textfield = new TextField();
        gridpane.add(textfield,1,4);
        Button button11 = new Button("deleted");
        gridpane.add(button11,0,5);
       button11.setOnAction(event-> {

            String string2 = textfield.getText();
            Boolean status=false;
            String query = "delete from studentTable where ID='"+string2+"'";
            ConnectionDB connection1 = new ConnectionDB();
            Connection connection = connection1.conMethod();
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
        Scene scene = new Scene(gridpane,300,200);
        button11.setTextFill(Color.RED);
        stage.setScene(scene);
        stage.setTitle("deleted info");
        stage.show();

    }


}
