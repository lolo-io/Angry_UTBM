package Model;

public class Moineau extends Birds {
	public Moineau(int posx, int posy) {
		super(posx, posy, _VITESSE_BIRD_MOINEAU, _WIDTH_BIRD_MOINEAU, _HEIGHT_BIRD_MOINEAU, _FLIGHT_TIME_BIRD_MOINEAU, _STAT_TIME_BIRD_MOINEAU, _EGGS_MOINEAU, 0, false);
		this.setStationnaire(false);
		setTextures();
		_type = 8;
	}

	public Moineau(double posx, double posy, int egg, double flight, double stat, double takeoff, boolean moving) {
		super(posx, posy, _VITESSE_BIRD_MOINEAU, _WIDTH_BIRD_MOINEAU, _HEIGHT_BIRD_MOINEAU, flight, stat, egg, takeoff, moving);
		this.setStationnaire(false);
		setTextures();
		_type = 8;
	}

	private void setTextures() {
		_liste_texture.add("img/birds/zazou1Droite.png");
		_liste_texture.add("img/birds/zazou2Droite.png");
		_liste_texture.add("img/birds/zazou3Droite.png");
		_liste_texture.add("img/birds/zazou4Droite.png");
		_liste_texture.add("img/birds/zazou5Droite.png");
		_liste_texture.add("img/birds/zazou6Droite.png");
		_liste_texture.add("img/birds/zazou7Droite.png");
		_liste_texture.add("img/birds/zazou8Droite.png");
		_liste_texture.add("img/birds/zazou9Droite.png");
		_liste_texture.add("img/birds/zazou10Droite.png");
		
		_liste_texture_back.add("img/birds/zazou1Gauche.png");
		_liste_texture_back.add("img/birds/zazou2Gauche.png");
		_liste_texture_back.add("img/birds/zazou3Gauche.png");
		_liste_texture_back.add("img/birds/zazou4Gauche.png");
		_liste_texture_back.add("img/birds/zazou5Gauche.png");
		_liste_texture_back.add("img/birds/zazou6Gauche.png");
		_liste_texture_back.add("img/birds/zazou7Gauche.png");
		_liste_texture_back.add("img/birds/zazou8Gauche.png");
		_liste_texture_back.add("img/birds/zazou9Gauche.png");
		_liste_texture_back.add("img/birds/zazou10Gauche.png");
		
		_liste_destructing.add("img/explosion/explode1white.png");
		_liste_destructing.add("img/explosion/explode2white.png");
		_liste_destructing.add("img/explosion/explode3white.png");
		_liste_destructing.add("img/explosion/explode4white.png");
		_liste_destructing.add("img/explosion/explode5white.png");
		_liste_destructing.add("img/explosion/explode6white.png");
		
		_texture = "img/birds/zazou1Droite.png";
	}

	@Override
	public Eggs lay_egg() {
		super.lay_egg();
		--_egg_left;
		return new Normal_egg(getPosX(), getPosY());
	}
}
