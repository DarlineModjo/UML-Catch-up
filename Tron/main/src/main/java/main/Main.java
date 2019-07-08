package main;
/**
 * <h1>The  Main Class</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */
import controller.GameControler;
import controller.IController;
import model.Grille;
import model.IModel;
import model.Model;
import view.Frame;
import view.IView;

public abstract class Main {

    public static void main(final String[] args) {
    	// on charge le model
    	final IModel model = new Model();
    	//on set la grille
    	model.setGrid(new Grille());
    	//on charge la cue avec la model
    	final IView view = new Frame(model);	
    	//et on charge le controler
    	IController game = new GameControler(model, view);
    	//on lance le jeu
    	game.play();
    	
    }

}
