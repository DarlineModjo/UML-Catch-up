package model;
/**
 * <h1>The  Model class</h1>
 * 
 * 
 * @version 1.0
 */
public class Model implements IModel{
	private IGrille grille;
	/**
	 * 
	 *
	 * @see model.IModel#getGrid()
	 */
	public IGrille getGrid() {
		return grille;
	}
	/**
	 * 
	 * @see model.IModel#setGrid(model.IGrille)
	 */
	public void setGrid(IGrille grille) {
		this.grille = grille;
	}

	
	
	
}
