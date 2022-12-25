package com.example.project1;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;

public class ConnectionDB {
        private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
        private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
        private static final String USERNAME = "JA20221";
        private static final String PASSWORD = "123";
        Connection connection = null;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        public Connection conMethod() {
            try {

                Class.forName(DRIVER);
                connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
                if(connection!=null)
                    alert.setContentText("connected");
                    // alert.setResult(ButtonType.CLOSE);
                else
                    alert.setContentText("not connected");

            } catch (Exception e) {


                alert.setContentText(e.toString());
            }
            alert.showAndWait();

            return connection;
        }
    }

