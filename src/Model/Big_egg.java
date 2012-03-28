package Model;

public class Big_egg extends Eggs {
	public Big_egg(double posx, double posy) {
		super(posx, posy, _VITESSE_BIG_EGG, _WIDTH_BIG_EGG, _HEIGHT_BIG_EGG);
		_texture = "img/eggs/egg.png";
		_type = 11;
	}
}
