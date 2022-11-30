package fr.icom.info.m1.balleauprisonnier_mvn;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * Classe gerant le terrain de jeu.
 * 
 */
public class Field extends Canvas{
	
	/** Joueurs */
	Player [] equipe1 = new Player[3]; /*Nombre de joueurs d'une équipe dans la partie*/
	Player [] equipe2 = new Player[3]; /*Nombre de joueurs d'une équipe dans la partie*/
	/** Couleurs possibles */
	String[] colorMap = new String[] {"blue", "green", "orange", "purple", "yellow"};
	/** Tableau traçant les evenements */
    ArrayList<String> input = new ArrayList<String>();
    

    final GraphicsContext gc;
    final int width;
    final int height;
    
    /**
     * Canvas dans lequel on va dessiner le jeu.
     * 
     * @param scene Scene principale du jeu a laquelle on va ajouter notre Canvas
     * @param w largeur du canvas
     * @param h hauteur du canvas
     */
	public Field(Scene scene, int w, int h){
		super(w, h); 
		width = w;
		height = h;
		
		/** permet de capturer le focus et donc les evenements clavier et souris */
		this.setFocusTraversable(true);
		
        gc = this.getGraphicsContext2D();
        
        /** On initialise le terrain de jeu */
        
        // Initialisation de l'équipe1
        // Boucle qui créer 3 personnages dans l'équipe 1
        for (int i = 0,n=4; i < 3; i++, n--){
        	equipe1[i] = new Player(gc, colorMap[i], w/n, h-50, "bottom");
        	equipe1[i].display();
	    }

        // Initialisation de l'équipe2
        // Boucle qui créer 3 personnages dans l'équipe 2
        for (int i = 0,n=4; i < 3; i++, n--){
        	equipe2[i] = new Player(gc, colorMap[i], w/n, 20, "top");
        	equipe2[i].display();
	    }
    	


	    /** 
	     * Event Listener du clavier 
	     * quand une touche est pressee on la rajoute a la liste d'input
	     *   
	     */
	    this.setOnKeyPressed(
	    		new EventHandler<KeyEvent>(){
	    	        public void handle(KeyEvent e){
	    	            String code = e.getCode().toString();
	    	            // only add once... prevent duplicates
	    	            if ( !input.contains(code) )
	    	                input.add( code );
	    	        }
	    	    });

	    /** 
	     * Event Listener du clavier 
	     * quand une touche est relachee on l'enleve de la liste d'input
	     *   
	     */
	    this.setOnKeyReleased(
	    	    new EventHandler<KeyEvent>(){
	    	        public void handle(KeyEvent e){
	    	            String code = e.getCode().toString();
	    	            input.remove( code );
	    	        }
	    	    });
	    
	    /** 
	     * 
	     * Boucle principale du jeu
	     * 
	     * handle() est appelee a chaque rafraichissement de frame
	     * soit environ 60 fois par seconde.
	     * 
	     */
	    new AnimationTimer(){
	        public void handle(long currentNanoTime){	 
	            // On nettoie le canvas a chaque frame
	            gc.setFill( Color.LIGHTGRAY);
	            gc.fillRect(0, 0, width, height);
	        	
	            // Deplacement et affichage des joueurs
	            
	            // Pour les joueurs contrôlés par la personne, un seul joueur est contrôlé par un humain
	        	//Equipe 1
	            for (int i=0;i<1;i++){
	        		if (input.contains("LEFT")){
	        			equipe1[i].moveLeft();
	        		} 
	        		if (input.contains("RIGHT")){
	        			equipe1[i].moveRight();	        			
	        		}
					if (input.contains("ENTER")){
	        			equipe1[i].shoot();
					}
	        		if (input.contains("UP")){
	        			equipe1[i].turnLeft();
	        		} 
	        		if (input.contains("DOWN")){
	        			equipe1[i].turnRight();	        			
	        		}
	        		
	        		equipe1[i].display();
	    	    }
	            //Equipe 2
	            for (int i=0;i<1;i++){
	        		if (input.contains("Q")){
	        			equipe2[i].moveLeft();
	        		} 
	        		if (input.contains("D")){
	        			equipe2[i].moveRight();	        			
	        		}
	        		if (input.contains("Z")){
	        			equipe2[i].turnLeft();
	        		} 
	        		if (input.contains("S")){
	        			equipe2[i].turnRight();	        			
	        		}
	        		if (input.contains("SPACE")){
	        			equipe2[i].shoot();
					}

	        		equipe2[i].display();
	    	    }
	        	
	        	// Pour les joueurs contrôlés par le pc
	            /*
	        	equipe1[2].moveLeft();
	        	equipe1[2].display();
	        		*/
	        	
	    	}
	     }.start(); // On lance la boucle de rafraichissement 
	     
	}

	public Player[] getEquipe1() {
		return equipe1;
	}
	
	public Player[] getEquipe2() {
		return equipe2;
	}
	
}
