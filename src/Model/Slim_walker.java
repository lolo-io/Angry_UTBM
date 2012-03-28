package Model;


public class Slim_walker extends Walkers {
	public Slim_walker (double x, double y) {
		super(x, y, _VITESSE_SLIM_WALKER, _WIDTH_SLIM_WALKER, _HEIGHT_SLIM_WALKER);

		_type = 4;
		setTextures();
	}

	public Slim_walker(double posx, double posy, boolean switched) {
		super(posx, posy, _VITESSE_SLIM_WALKER, _WIDTH_SLIM_WALKER, _HEIGHT_SLIM_WALKER);
		
		_arriere = switched;
		_type = 4;
		
		setTextures();
	}
	
	private void setTextures() {
		_liste_texture.add("img/walkers/LuigiDroite1.png");
		_liste_texture.add("img/walkers/LuigiDroite2.png");
		_liste_texture.add("img/walkers/LuigiDroite3.png");
		_liste_texture.add("img/walkers/LuigiDroite4.png");
		_liste_texture.add("img/walkers/LuigiDroite1.png");
		_liste_texture.add("img/walkers/LuigiDroite5.png");
		_liste_texture.add("img/walkers/LuigiDroite6.png");
		_liste_texture.add("img/walkers/LuigiDroite7.png");
		
		_liste_texture_back.add("img/walkers/LuigiGauche1.png");
		_liste_texture_back.add("img/walkers/LuigiGauche2.png");
		_liste_texture_back.add("img/walkers/LuigiGauche3.png");
		_liste_texture_back.add("img/walkers/LuigiGauche4.png");
		_liste_texture_back.add("img/walkers/LuigiGauche1.png");
		_liste_texture_back.add("img/walkers/LuigiGauche5.png");
		_liste_texture_back.add("img/walkers/LuigiGauche6.png");
		_liste_texture_back.add("img/walkers/LuigiGauche7.png");
		
		_texture = "img/walkers/LuigiDroite1.png";
	}
}