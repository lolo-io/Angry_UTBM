package Model;


public class Small_egg extends Eggs implements Constantes {
	public Small_egg(int x, int y) {
		super(x,y,_WIDTH_SMALL_EGG,_VITESSE_SMALL_EGG, _HEIGHT_SMALL_EGG);
		_texture = "img/eggs/egg.png";
		_type = 9;
	}
}
