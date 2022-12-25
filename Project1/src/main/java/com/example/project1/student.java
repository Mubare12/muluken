package com.example.project1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.nio.charset.StandardCharsets;
import java.security.cert.Extension;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class student {
    static String string1= null;
    private static Extension studentTable;
    private static String query;


    public static void stud() {

Stage st1 = new Stage();
st1.setTitle("college management system");
        GridPane gd1 = new GridPane();
        gd1.setHgap(10);
        gd1.setVgap(10);
        Label label1 = new Label("Full Name");
        gd1.add(label1,0,1);
        TextField fd = new TextField();
        gd1.add(fd,1,1);
        Label label2 = new Label("ID");
        gd1.add(label2,0,2);
        TextField fd1 = new TextField();
        gd1.add(fd1,1,2);
        Label label3 = new Label("Email");
        gd1.add(label3,0,3);
        TextField fd2 = new TextField();
        gd1.add(fd2,1,3);
        Label label4 = new Label("Phone no");
        gd1.add(label4,0,4);
        TextField fd3 = new TextField();
        gd1.add(fd3,1,4);
            Button button3 =new Button("Add");
            gd1.add(button3,0,7);
            Button button4 =new Button("Delete");
            gd1.add(button4,1,7);
            Button button5 =new Button("Canel");
            gd1.add(button5,2,7);
            Label label11 = new Label("choose the department");
            label11.setFont(new Font("areal",18));
        gd1.add(label11,6,1);
            CheckBox ck1;
        CheckBox ck2;
        CheckBox ck3;
        CheckBox ck4;
        ck1 = new CheckBox("Computer Science");
        gd1.add(ck1,6,2);
            ck2  =  new CheckBox("software engineer");
        gd1.add(ck2,6,3);
            ck3 = new CheckBox("information system");
        gd1.add(ck3,6,4);
            ck4 = new CheckBox("information technology");
        gd1.add(ck4,6,5);
        gd1.setStyle("-fx-background-color: aquamarine");
       ck1=ck1;
        ck2=ck2;
        ck3=ck3;
        ck4=ck4;

        button3.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                               public void handle(ActionEvent actionEvent) {
                                   ConnectionDB CONDB=new ConnectionDB();
                                    CONDB.conMethod();
                               }
                            }
        );


        CheckBox finalCk = ck2;
        CheckBox finalCk1 = ck3;
        CheckBox finalCk2 = ck4;
        CheckBox finalCk3 = ck1;
        button3.setOnAction(e->{


            String Fullname,ID,Phoneno,Email;
            Fullname=fd.getText();
            ID = fd1.getText();
            Phoneno=fd2.getText();
            Email=fd3.getText();

           if(finalCk3.isSelected()){
                string1 = finalCk3.getText();}
            else if(finalCk.isSelected()){
                string1= finalCk.getText();}
            else if(finalCk1.isSelected()){
                string1= finalCk1.getText();}
            else if(finalCk2.isSelected()){
                string1= finalCk2.getText();}
            else{
                System.out.println(0);}
            try{
                String query = "insert into studentTable(Fullname,ID,Phoneno,Email,Depart) " +"values('"+Fullname+"','"+ID+"','"+Phoneno+"','"+Email+"','"+string1+"')";
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

        button5.setOnAction(event->{

            System.exit(0);
        });
        button4.setOnAction(e ->deletestud.deletestd());
        Scene sc = new Scene(gd1,500,400);
        button3.setStyle("-fx-border-color: green");
        button4.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        button5.setStyle("-fx-border-color: black");
        st1.setScene(sc);
        st1.show();
    }
}