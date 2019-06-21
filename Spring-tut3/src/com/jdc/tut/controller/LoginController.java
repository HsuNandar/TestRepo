package com.jdc.tut.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jdc.tut.entity.User;
import com.jdc.tut.service.UserService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController implements Initializable{

    @FXML
    private TextField textfieldname;

    @FXML
    private PasswordField textfieldpassword;
    
    @FXML
    private Label notilabel;
    
    @Autowired
    private UserService service;
    
    private static User user;
    public static User getUser() {
    	return user;
    }

    @FXML
    void cancel() {
    	
    }

    @FXML
    void enter() throws IOException {
    	
    	try {
    	user=service.findByLogin(textfieldname.getText(),textfieldpassword.getText());
    	 MainController.showMain();
     	textfieldpassword.getScene().getWindow().hide();

    }catch(Exception e) {
    	notilabel.setText(e.getMessage());
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
