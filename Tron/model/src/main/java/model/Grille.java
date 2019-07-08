package model;
/**
 * <h1>The Grille Class</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */


import java.awt.Color;

import DAO.Datamanager;



public class Grille implements IGrille{
	
	
	private IMonture rider1;
	private IMonture rider2;
	private int width = 600;
	private int height = 400;
	private int nbCelsHeight=40;
	private int nbCelsWidth=60;
	private ITemps temps;
	private Datamanager db = new Datamanager();

	
	

	/**
	 * Constructeur
	 * Met en place 2 riders sur la grille
	 */
	public Grille () {
		this.rider1= new Monture(2,2,Color.yellow,Direction.EST,this);
		this.rider2= new Monture(30,30,Color.green,Direction.OUEST,this);
		this.temps= new temps();
		temps.start();
	}
	
	/**
	 * Vérifie les colision du rider
	 * Vérifie si le rider est dans les colision
	 * @param monture
	 * @return boolean colision
	 * 
	 */
	public boolean checkColision(Monture monture) {
		if(monture.getX()>this.nbCelsWidth || monture.getX()<=0 || monture.getY()<=0 || monture.getY()>this.nbCelsHeight) {monture.setAlive(false); return true;} 
		
		for (IElements particle : rider1.getParticles()) {
			if(monture.getX() == particle.getX() && monture.getY() == particle.getY()) {monture.setAlive(false);return true;}
		}
		
		for (IElements particle : rider2.getParticles()) {
			if(monture.getX() == particle.getX() && monture.getY() == particle.getY()) {monture.setAlive(false);return true;}
	
	}
		return false;
	
}
	/**
	 * @see model.IGrille#getRider1()
	 */
	@Override
	public IMonture getRider1() {
		return rider1;
	}

	/**
	 * Set rider 1
	 */
	public void setRider1(Monture rider1) {
		this.rider1 = rider1;
	}
	/**
	 * @see model.IGrille#getRider2()
	 */
	@Override
	public IMonture getRider2() {
		return rider2;
	}

	/**
	 * Set rider 2
	 */
	public void setRider2(Monture rider2) {
		this.rider2 = rider2;
	}
	/**
	 * @see model.IGrille#getWidth()
	 */
	@Override
	public int getWidth() {
		return width;
	}

	/**
	 * Set la largeur
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @see model.IGrille#getHeight()
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * set la hauteur en pixel
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @see model.IGrille#getNbCelsHeight()
	 */
	@Override
	public int getNbCelsHeight() {
		return nbCelsHeight;
	}


	public void setNbCelsHeight(int nbCelsHeight) {
		this.nbCelsHeight = nbCelsHeight;
	}
	/**
	 * @see model.IGrille#getNbCelsWidth()
	 */
	@Override
	public int getNbCelsWidth() {
		return nbCelsWidth;
	}


	public void setNbCelsWidth(int nbCelsWidth) {
		this.nbCelsWidth = nbCelsWidth;
	}
	@Override
	public ITemps getTimer() {
		return temps;
	}
	@Override
	public void save() {
		
		if(rider1.isAlive()) {
			db.save(2, (int) temps.getTime());}
		else {
			db.save(1, (int) temps.getTime());}
		}
		

}

	
	
	
	
	
	
	
	
	
	
	

