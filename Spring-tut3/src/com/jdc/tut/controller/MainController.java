package com.jdc.tut.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.jdc.tut.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

@Controller
public class MainController implements Initializable{

	 @FXML
	    private HBox header;

	    @FXML
	    private StackPane content;
	    
    private static Stage stage;
    
    public static void showMain(){
    	
    	try {
    	FXMLLoader loader=new FXMLLoader(MainController.class.getResource("view/Main.fxml"));
    	loader.setControllerFactory(Main::getController);
        stage=new Stage();
    	stage.setScene(new Scene(loader.load()));
    	stage.show();
    }catch(IOException e){
    	e.printStackTrace();
    }
    	
    }
   public void loadView(String viewName) {
    	
		try {
			FXMLLoader loader = new FXMLLoader(MainController.class.getResource("view/" + viewName + ".fxml"));
			loader.setControllerFactory(Main::getController);

			content.getChildren().clear();

			content.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
