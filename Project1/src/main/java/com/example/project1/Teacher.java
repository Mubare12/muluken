package com.example.project1;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Teacher {


    public static void tech() {
         Stage stage = new Stage();
         stage.setTitle("college management system");
         GridPane gd = new GridPane();
         gd.setHgap(10);
         gd.setVgap(10);
        gd.setStyle("-fx-background-color: pink");
        Label label5 = new Label("Teacher Information");
        gd.add(label5,1,1);
        label5.setFont(new Font("italic",20));
        Label label6 = new Label("Full Name");
        gd.add(label6,0,2);
        TextField f4 = new TextField();
        gd.add(f4,1,2);
        Label label7 = new Label("ID");
        gd.add(label7,0,3);
        TextField fd5 = new TextField();
        gd.add(fd5,1,3);
        Label label8 = new Label("Email");
        gd.add(label8,0,4);
        TextField fd6 = new TextField();
        gd.add(fd6,1,4);
        Label label9 = new Label("Phone no");
        gd.add(label9,0,5);
        TextField fd7 = new TextField();
        gd.add(fd7,1,5);
        Button button3 =new Button("Add");
        gd.add(button3,0,7);
        Button button4 =new Button("Delete");
        gd.add(button4,1,7);
        Label label10 = new Label("Courses");
        TextField textField1 = new TextField();
        gd.add(textField1,1,6);
        gd.add(label10,0,6);

        button3.setOnAction(e->{

            String Fullname,ID,Phoneno,Email,Courses;
            Fullname=f4.getText();
            ID = fd5.getText();
            Phoneno=fd6.getText();
            Email=fd7.getText();
            Courses=textField1.getText();




            try{
                String query = "insert into TeacherTable(Fullname,ID,Phoneno,Email,Courses) " +"values('"+Fullname+"','"+ID+"','"+Phoneno+"','"+Email+"','"+Courses+"')";
                ConnectionDB con2=new ConnectionDB();
                Connection connection=con2.conMethod();
                Statement statement=connection.createStatement();
                Boolean status = statement.execute(query);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                if(!status){
                    alert.setContentText("Inserted");
                    alert.showAndWait();
                }
                else{
                    alert.setContentText("not inserted");
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });

        button3.setStyle("-fx-border-color: green");
        button4.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        Scene sc = new Scene(gd,500,400);
        //sc.setFill(Color.DEEPPINK);
        button4.setOnAction(e->deleteteach.deletech());
        stage.setScene(sc);
        stage.show();
    }
}