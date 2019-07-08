package model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;



public class RiderTest {

	private Monture monture;
	private Direction directiontest = Direction.NORD;
	
	private Grille grille;
	 /**
	 * Set up the test configuration.
	 * 
	 * @throws Exception
	 * 			Signals that an exception has occurred
	 */
	@Before
	public void setUp() throws Exception {
		monture = new Monture(100, 200, Color.red, directiontest, grille);
		}
	/**
	 * Test pour tourner à droite
	 */
	@Test
	public void testTurnRight() {
		monture.turnRight();
		assertEquals(Direction.EST,monture.direction);
	}

	/**
	 * Test pour tourner à gauche
	 */
	
	@Test
	public void testTurnLeft() {
		monture.turnLeft();
		assertEquals(Direction.OUEST,monture.direction);
	}
}
