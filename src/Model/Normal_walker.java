package Model;


public class Normal_walker extends Walkers {
	public Normal_walker (double x, double y) {
		super(x, y, _VITESSE_NORMAL_WALKER, _WIDTH_NORMAL_WALKER, _HEIGHT_NORMAL_WALKER);

		_type = 3;
		setTextures();
	}

	public Normal_walker(double posx, double posy, boolean switched) {
		super(posx, posy, _VITESSE_NORMAL_WALKER, _WIDTH_NORMAL_WALKER, _HEIGHT_NORMAL_WALKER);
		
		_arriere = switched;
		_type = 3;
		
		setTextures();
	}
	
	private void setTextures() {
		_liste_texture.add("img/walkers/MarioDroite1.png");
		_liste_texture.add("img/walkers/MarioDroite2.png");
		_liste_texture.add("img/walkers/MarioDroite3.png");
		_liste_texture.add("img/walkers/MarioDroite4.png");
		_liste_texture.add("img/walkers/MarioDroite1.png");
		_liste_texture.add("img/walkers/MarioDroite5.png");
		_liste_texture.add("img/walkers/MarioDroite6.png");
		_liste_texture.add("img/walkers/MarioDroite7.png");
		
		_liste_texture_back.add("img/walkers/MarioGauche1.png");
		_liste_texture_back.add("img/walkers/MarioGauche2.png");
		_liste_texture_back.add("img/walkers/MarioGauche3.png");
		_liste_texture_back.add("img/walkers/MarioGauche4.png");
		_liste_texture_back.add("img/walkers/MarioGauche1.png");
		_liste_texture_back.add("img/walkers/MarioGauche5.png");
		_liste_texture_back.add("img/walkers/MarioGauche6.png");
		_liste_texture_back.add("img/walkers/MarioGauche7.png");
		
		_texture = "img/walkers/MarioDroite1.png";
	}
}
