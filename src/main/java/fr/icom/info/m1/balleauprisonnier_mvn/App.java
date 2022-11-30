package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.application.Application; /*classe abstraite permettant de créer une application, une fenetre*/
import javafx.scene.Group; /*Permet de créer des conteneur*/
import javafx.scene.Scene; /* fenetre qui engloge les éléments */
import javafx.stage.Stage; /* fenetre qui englobe la scene */

/**
 * Classe principale de l'application 
 * s'appuie sur javafx pour le rendu
 */
public class App extends Application 
{
	
	/**
	 * En javafx start() lance l'application
	 *
	 * On cree le SceneGraph de l'application ici
	 * @see http://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm
	 * 
	 */
	@Override
	public void start(Stage stage) throws Exception 
	{
		// Nom de la fenetre
        stage.setTitle("BalleAuPrisonnier");

        Group root = new Group();
        Scene scene = new Scene( root );

        // On cree le terrain de jeu et on l'ajoute a la racine de la scene
        Field gameField = new Field(scene, 600, 600 );
        root.getChildren().add( gameField );
        
        for (int i = 0; i < 3; i++) 
	    {root.getChildren().add(gameField.getEquipe1()[i].sprite);
	    } // Afficher les images de joueurs
        
        for (int i = 0; i < 3; i++) 
	    {root.getChildren().add(gameField.getEquipe2()[i].sprite);
	    }
		

        // On ajoute la scene a la fenetre et on affiche
        stage.setScene( scene );
        stage.show();
	}
	
    public static void main(String[] args) 
    {
        //System.out.println( "Hello World!" );
    	Application.launch(args);
    }
}
