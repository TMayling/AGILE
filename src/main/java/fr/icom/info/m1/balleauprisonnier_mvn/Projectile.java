/*package fr.icom.info.m1.balleauprisonnier_mvn;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Projectile {
	
	GraphicsContext graphicsContext;
	double x;       	// position horizontale du ballon
	final double y;		// position verticale du ballon
	double vitesse;		// vitesse du ballon
	double angle; 		// angle du joueur au moment du tir
	double step;    	// pas d'un joueur
	String position;
	  
	 // On une image globale du ballon 
	Image Balle;
	Sprite sprite;
	ImageView BallePosition;
	
	void display(){
		graphicsContext.save(); // saves the current state on stack, including the current transform
	    rotate(graphicsContext, angle=Math.toRadians(angle), x + BallePosition.getWidth() / 2, y + directionArrow.getHeight() / 2);
		graphicsContext.drawImage(BallePosition, x, y);
		graphicsContext.restore(); // back to original state (before rotation)
	  }
	
	void AffichageBalle(GraphicsContext gc){
		Balle = new Image("assets/ball.png");
		Balle.display();
	}
	
}
*/