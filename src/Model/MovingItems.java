package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


abstract public class MovingItems extends ItemDisplay {

	protected List<String> _liste_texture = new LinkedList<String>();
	protected List<String> _liste_destructing = new LinkedList<String>();
	protected ArrayList<String> _liste_texture_back = new ArrayList<String>();
	protected int _statutTexture = 0;
	protected double _vitesse;
	protected double _timer = 0 ;
	protected boolean _destructed = false;
	protected boolean _destructing = false;
	protected int destructing_time = 0;
	
	public MovingItems(double x, double y, int vitesse, int width, int height) {
		super(x, y, width, height);	
		_vitesse = vitesse;
		_solid = true;
	}
	
	public void moveX(double x) {
		_x += x;
		_r.setLocation(getPosX(), getPosY());
	}
	
	public void moveY(double y) {
		_y += y;
		_r.setLocation(getPosX(), getPosY());
	}
	
	public boolean isDestructed () {
		return _destructed;	
	}
	
	/* Retourne true si l'oiseau est en train d'etre detruit
	* @param void
	* @return boolean
	*/
	public boolean isDestructing() {
		return _destructing;
	}

	//Returns true if the item collides with a static item
	public boolean collide_static() {
		for(int i = 0; i < Fenetre._list_static_items.size(); i++) {
			//Ici on verifie que le rectangle de l'objet dans lequel on est collide avec un des objets de la liste static
			if (Fenetre._list_static_items.get(i).getSolid() && _r.intersects(Fenetre._list_static_items.get(i).getRect())) {
				return true;
			}
		}
		
		return false;
	}
	
	//Returns true if the item collides with a moving item
	public boolean collide_dynamic() {
		for(int i = 0; i < Fenetre._list_walkers.size(); i++) {
			//Ici on verifie que le rectangle de l'objet dans lequel on est collide avec un des objets de la liste static
			if (Fenetre._list_walkers.get(i).getSolid() && _r.intersects(Fenetre._list_walkers.get(i).getRect())) {
				Fenetre._list_walkers.get(i).demol();
				return true;
			}
		}
		
		return false;
	}
	
	abstract public void demol();
}
