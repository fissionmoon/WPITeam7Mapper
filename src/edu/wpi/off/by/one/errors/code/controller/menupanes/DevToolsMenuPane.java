package edu.wpi.off.by.one.errors.code.controller.menupanes;

import java.io.File;
import java.io.IOException;

import edu.wpi.off.by.one.errors.code.controller.ControllerSingleton;
import edu.wpi.off.by.one.errors.code.controller.MapRootPane;
import edu.wpi.off.by.one.errors.code.controller.menupanes.devtoolspanes.EdgeDevToolPane;
import edu.wpi.off.by.one.errors.code.controller.menupanes.devtoolspanes.MapDevToolPane;
import edu.wpi.off.by.one.errors.code.controller.menupanes.devtoolspanes.NodeDevToolPane;
import edu.wpi.off.by.one.errors.code.controller.menupanes.devtoolspanes.PathDevToolPane;
import edu.wpi.off.by.one.errors.code.model.Display;
import edu.wpi.off.by.one.errors.code.model.FileIO;
import edu.wpi.off.by.one.errors.code.model.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Created by jules on 11/28/2015.
 */
public class DevToolsMenuPane extends BorderPane {
	
	@FXML RadioButton mapPaneRadioButton;
	@FXML MapDevToolPane mapDevToolPane;
	@FXML NodeDevToolPane nodeDevToolPane;
	@FXML EdgeDevToolPane edgeDevToolPane;
	//@FXML Button loadNewImageButton;
	//@FXML Button loadNewMapButton;
	//@FXML Button appendMapButton;
	@FXML Button saveCurrentMapButton;
	

    public DevToolsMenuPane(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/wpi/off/by/one/errors/code/view/menupanes/DevToolsMenuPane.fxml"));

        loader.setRoot(this);
        loader.setController(this);
        
        try{
            loader.load();
            
        }catch(IOException excpt){
            throw new RuntimeException(excpt);
        }
        setListeners();
        this.getStylesheets().add(getClass().getResource("/edu/wpi/off/by/one/errors/code/resources/stylesheets/menupanes/DevToolsPaneStyleSheet.css").toExternalForm());

    }
    
    private void setListeners(){
    	this.visibleProperty().addListener(change -> {
    		MapRootPane maproot = ControllerSingleton.getInstance().getMapRootPane();
            if(maproot != null){
            	maproot.isEditMode = this.isVisible() ? true : false;
        		maproot.render();
        		mapDevToolPane.updateMapList(maproot.getDisplay().getMaps());
            }
    	});
    	/*
    	this.loadNewImageButton.setOnAction(e -> {
    		MapRootPane maproot = ControllerSingleton.getInstance().getMapRootPane();
            
    		Display display = maproot.getDisplay();
        	FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Map File");
            fileChooser.getExtensionFilters().addAll(
                                                     new ExtensionFilter("Image Files", "*.png"),
                                                     new ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileChooser.showOpenDialog(ControllerSingleton.getInstance().getMainPane().getWindow());
            if (selectedFile != null) {
                String inpath = selectedFile.getName();
                //System.out.println(inpath);
                Map newmap = new Map();
                newmap.setImgUrl(inpath);
                newmap.setScale(0.5f);
                display.addMap(newmap);
                //display.setMap(newmap);
                maproot.render();
                //mainPane.getMapRootPane().updateDisplay(display, "NEW");
                //mapView.setImage(new Image("/edu/wpi/off/by/one/errors/code/resources/" + inpath));
                //window.display(selectedFile);
                mapDevToolPane.updateMapList(maproot.getDisplay().getMaps());
                //mapDevToolPane.setMap(newdisp.getMap());
                ControllerSingleton.getInstance().getMenuPane().getSearchMenuPane().updateMapList(maproot.getDisplay().getMaps());

            }
    	});*/
    	/*
    	this.loadNewMapButton.setOnAction(e -> {
    		Display newdisp = null;
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Map File");
            fileChooser.getExtensionFilters().addAll(
                                                     new ExtensionFilter("Text Files", "*.txt"),
                                                     new ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileChooser.showOpenDialog(mainPane.getWindow());
            if (selectedFile != null) {
                String inpath = selectedFile.getPath();
                //System.out.println(inpath);
                newdisp = FileIO.load(inpath, null);
                //mainPane.getMapRootPane().updateDisplay(newdisp, "NEW");
                mapDevToolPane.setMap(newdisp.getMaps().get(0));
            }
    	});
    	*/
    	/*
    	// TODO Append new map onto current map on a separate pane layer
    	this.appendMapButton.setOnAction(e -> {
    		MapRootPane maproot = ControllerSingleton.getInstance().getMapRootPane();
            Display newdisp = maproot.getDisplay();
    		
       
    		FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Map File");
            fileChooser.getExtensionFilters().addAll(
                                                     new ExtensionFilter("Text Files", "*.txt"),
                                                     new ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileChooser.showOpenDialog(ControllerSingleton.getInstance().getMainPane().getWindow());
            if (selectedFile != null) {
                String inpath = selectedFile.getPath();
                newdisp = FileIO.load(inpath, newdisp);
                maproot.updateDisplay(newdisp, "APPEND");
                mapDevToolPane.updateMapList(maproot.getDisplay().getMaps());
                //mapDevToolPane.setMap(newdisp.getMap());
                ControllerSingleton.getInstance().getMenuPane().getSearchMenuPane().updateMapList(maproot.getDisplay().getMaps());
            }
    	});
    	*/
    	this.saveCurrentMapButton.setOnAction(e -> {
    		MapRootPane maproot = ControllerSingleton.getInstance().getMapRootPane();
            FileIO.save(maproot.getFilePath(), maproot.getDisplay());
    	});
    }
    public NodeDevToolPane getNodeDevToolPane() { return nodeDevToolPane; }
    public EdgeDevToolPane getEdgeDevToolPane() { return edgeDevToolPane; }
    public MapDevToolPane getMapDevToolPane() { return mapDevToolPane; }
}
