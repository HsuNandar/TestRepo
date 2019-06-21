package com.jdc.tut.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jdc.tut.entity.User;
import com.jdc.tut.entity.User.Role;
import com.jdc.tut.service.UserService;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

@Controller
public class UserController implements Initializable{

    @FXML
    private TextField username;

    @FXML
    private TextField login;

    @FXML
    private ComboBox<Role> combouser;

    @FXML
    private PasswordField pfuser;

    @FXML
    private PasswordField pfconfirm;

    @FXML
    private Label message;

    @FXML
    private TableView<User> tbviewuser;

    @FXML
    private TableColumn<User, Integer> numCol;
    
    @Autowired
    private UserService service;

    @FXML
    void delete() {

    }

    @FXML
    void save() {

    	try {
    		User user=new User();
    		user.setName(username.getText());
    		user.setLoginId(login.getText());
    		user.setRole(combouser.getSelectionModel().getSelectedItem());
    		user.setPassword(pfuser.getText());
    		
    		String mess=service.save(user,pfconfirm.getText());
    		message.setText(mess);
    		loadView();
    		
    	}catch(Exception ex) {
    		message.setText(ex.getMessage());
    	}
    }

    private void loadView() {
    	tbviewuser.getItems().clear();
		tbviewuser.getItems().addAll(service.findAll());
		
	}

	@FXML
    void search() {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combouser.getItems().addAll(Role.values());
		loadView();
		
		/* Row Number auto Generate */
		numCol.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Integer>(tbviewuser.getItems()
				.indexOf(column.getValue())+1));
		
		
	}

}
