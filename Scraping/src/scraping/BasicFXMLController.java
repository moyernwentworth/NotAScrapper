package scraping;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class BasicFXMLController {

     Stage stage;
     Parent root;

     @FXML
     private TextField catagory;
     @FXML
     private TextField size;
     @FXML
     private TextField keyword;
     @FXML
     private TextField date;
     @FXML
     private TextField color;
     @FXML
     private Button save;
     @FXML
     private ImageView shop;
     @FXML
     private Button submit;
     @FXML
     private TextField selected;
     @FXML
     private ImageView createNew;
     @FXML
     private ImageView home;
     @FXML
     private ImageView settings;
     @FXML
     private ImageView todo;
     @FXML
     private ImageView done;
     WebView browser = new WebView();
     WebEngine webEngine = browser.getEngine();

    
    @FXML
    public String getCat() throws IOException{
    	return catagory.getText();
    	
    }
    

    @FXML
    public String getSize() throws IOException{
    	return size.getText();
    }


    @FXML
    public String getkeyword() throws IOException{
    	return keyword.getText();
    }
    
    @FXML
    public String getdate() throws IOException{
    	return date.getText();
    }   
    @FXML
    public String getColor()  throws IOException{
    	return color.getText();
    }
    
    
    
    @FXML
    //this creates a file and saves the info to that file
    // ---------- not working -------------------
    //TODO
    void handleSave(MouseEvent event) throws Exception{
    	try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename.txt"), "utf-8"))) {
    		writer.write("hi");
    		writer.close();
    	}
    }
    @FXML
    //this ones another scene in seperate window so that the user can see what products
    //they are attempting to purchase
    // ---------- not working -----------------
    //TODO
    void handleShop(MouseEvent event) throws Exception{
  		if(event.getSource()==shop){
  			Stage stager = new Stage();  
 			root = FXMLLoader.load(getClass().getResource("shop.fxml"));  
 			Scene scene = new Scene(root); //instantiates new scene
 	  		stager.setScene(scene);         //sets the scene to the stage
 	  		stager.setX(10);
 	  		stager.setY(50);
 	  		stager.show();   
 	     
 		}	
  		               //displays it
    }
    @FXML
    //this will send the chosen info form the gui to the variables
    //and sends the formatted chosen to the text area for the user to confirm
    //----------- not working -----------------
    //TODO
    void handleSubmit(MouseEvent event) throws Exception{
    	if(event.getSource()==submit){
    		FindUrl url = new FindUrl();
    		System.out.print(url.FindUrl(getCat(), getkeyword(), getColor()));
    	}
    }
    @FXML
    //this sets the scene to the new bot page from keywords
    //----------- working---------------
    void handleNew(MouseEvent event) throws Exception{
  		if(event.getSource()==createNew){
  			 stage = (Stage) createNew.getScene().getWindow();  
  			 root = FXMLLoader.load(getClass().getResource("new.fxml")); 
  		}
  		Scene scene = new Scene(root); //instantiates new scene
  		stage.setScene(scene);         //sets the scene to the stage
  		stage.show();                  //displays it
    }
    @FXML
    //this sends the user to the home scene
    //----------- working -------------
    void handleHome(MouseEvent event) throws Exception{
  		if(event.getSource()==home){
  			 stage = (Stage) home.getScene().getWindow();  
  			 root = FXMLLoader.load(getClass().getResource("Home.fxml")); 
  		}
  		Scene scene = new Scene(root); //instantiates new scene
  		stage.setScene(scene);         //sets the scene to the stage
  		stage.show();                  //displays it
    }
    @FXML
    //this sends the user to the settings scene
    //----------- working -------------
    void handleSettings(MouseEvent event) throws Exception{
  		if(event.getSource()==settings){
  			 stage = (Stage) settings.getScene().getWindow();  
  			 root = FXMLLoader.load(getClass().getResource("settings.fxml")); 
  		}
  		Scene scene = new Scene(root); //instantiates new scene
  		stage.setScene(scene);         //sets the scene to the stage
  		stage.show();                  //displays it
    }
    @FXML
    //this sends the user to the todo scene
    //----------- working -------------
    void handleToDo(MouseEvent event) throws Exception{
  		if(event.getSource()==todo){
  			 stage = (Stage) todo.getScene().getWindow();  
  			 root = FXMLLoader.load(getClass().getResource("todo.fxml")); 
  		}
  		Scene scene = new Scene(root); //instantiates new scene
  		stage.setScene(scene);         //sets the scene to the stage
  		stage.show();                  //displays it
    }
    @FXML
    //this sends the user to the done scene
    //----------- working -------------
    void handleDone(MouseEvent event) throws Exception{
  		if(event.getSource()==done){
  			 stage = (Stage) done.getScene().getWindow();  
  			 root = FXMLLoader.load(getClass().getResource("done.fxml")); 
  		}
  		Scene scene = new Scene(root); //instantiates new scene
  		stage.setScene(scene);         //sets the scene to the stage
  		stage.show();                  //displays it
    }
  }
 
 /*/   @FXML
*    void handleSettings(MouseEvent event) throws Exception {
*
*		if(event.getSource()==settingsBack){
*            stage = (Stage) settingsBack.getScene().getWindow();  //grabs the current stage (by looking at the window that the button belongs to
*            root = FXMLLoader.load(getClass().getResource("Accelerate.fxml")); //loads the other scene fxml
*       
*       }
*        else if(event.getSource()==settings){ //this one wont work yet just because the name profile is used as filler no items on profile gui
*           stage = (Stage) settings.getScene().getWindow();  //grabs the current stage (by looking at the window that the button belongs to
*           root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
*        }
*	   Scene scene = new Scene(root); //instantiates new scene
*       stage.setScene(scene);         //sets the scene to the stage
*       stage.show();                  //displays it
*      
*}
*/   
    




