package edu.wpi.off.by.one.errors.code.application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MarkerDisplay extends ImageView{
	public enum Marker{
		START, END, PIRATE;
	}
	public double x, y, z;
	boolean isOnNode = false;
	static String resourceDir = "/edu/wpi/off/by/one/errors/code/resources/";
	static String startImg = resourceDir + "marker.png";
	static String endImg = resourceDir + "endnode.png";
	static String pirate_endImg = resourceDir + "pirate_endnode.png";
	
	public MarkerDisplay(double x, double y, double z, Marker m){
		if (m == Marker.START) setImage(new Image(startImg));
		else if (m == Marker.END) setImage(new Image(pirate_endImg));
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public MarkerDisplay(double x, double y, double z, Marker m, Marker options){
		if(options == Marker.PIRATE){
			if (m == Marker.START) setImage(new Image(startImg));
			else if (m == Marker.END) setImage(new Image(pirate_endImg));
		}
		else{
			if (m == Marker.START) setImage(new Image(startImg));
			else if (m == Marker.END) setImage(new Image(endImg));
		}
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
