package com.example.demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    protected void handleLogin(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("admin") && password.equals("admin")){
            openChooseDatabse();
        }else {
            System.out.println("Login failed");
        }
    }

    private void openChooseDatabse(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/ChooseDatabase.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Chọn cơ sở dữ liệu");
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage)usernameField.getScene().getWindow();
            currentStage.close();
        }catch (Exception e){
            e.printStackTrace();
            showAlert("Không thể mở giao diện chính!", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
