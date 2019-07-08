package model;
/**
 * <h1>Class Monture</h1>
 * 
 * 
 * @version 1.0
 */
import java.awt.Color;
import java.util.ArrayList;

public class Monture extends Elements implements IMonture , IElements{
	protected Direction direction;
	public ArrayList<IElements> particles = new ArrayList<IElements>();
	boolean alive = true;
	public Grille grille;

	
/**
 * Constructor
 * @param x,y,color,direction,grille
 * 
 * 	
 */
public Monture(int x, int y, Color color , Direction direction,Grille grille) {
		super(x, y, color);
		this.direction=direction;
		this.grille=grille;
		// TODO Auto-generated constructor stub
	}



/**
 * @see model.IMonture#move()
 */
public void move() {
	this.particles.add(0, new Particles(this.x, this.y, this.color));
	switch(this.direction) {
	case EST: this.x=x+1;
		break;
	case NORD: this.y=y-1;
		break;
	case OUEST: this.x=x-1;
		break;
	case SUD: this.y=y+1;
		break;
	default:
		break;
	}
	
	grille.checkColision(this);
	this.setChanged();
	this.notifyObservers();
	
	
}



/**
 * @see model.IMonture#isAlive()
 */
public boolean isAlive() {
	return alive;
}


/**
 * set rider alive status
 */
public void setAlive(boolean alive) {
	this.alive = alive;
}


/**
 * @see model.IMonture#getParticles()
 */

@Override
public ArrayList<IElements> getParticles() {
	// TODO Auto-generated method stub
	return particles;
}
/**
 * @see model.IMonture#turnRight()
 */
@Override
public void turnRight() {
	switch(this.direction) {
	case NORD: direction = Direction.EST;break;
	case EST: direction = Direction.SUD;break;
	case SUD: direction = Direction.OUEST;break;
	case OUEST: direction = Direction.NORD;break;
	}
	
}
/**
 * @see model.IMonture#turnLeft()
 */
@Override
public void turnLeft() {
		switch(this.direction) {
		case NORD: direction = Direction.OUEST;break;
		case EST: direction = Direction.NORD;break;
		case SUD: direction = Direction.EST;break;
		case OUEST: direction = Direction.SUD;break;
		}
	
}


	


	
	

	
}
