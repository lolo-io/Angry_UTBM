package Model;

public class Pigeon extends Birds {

	public Pigeon(double posx, double posy) {
		super(posx, posy,_VITESSE_BIRD_PIGEON, _WIDTH_BIRD_PIGEON, _HEIGHT_BIRD_PIGEON, _FLIGHT_TIME_BIRD_PIGEON, _STAT_TIME_BIRD_PIGEON, _EGGS_PIGEON, 0, false);

		setTextures();
		_type = 7;
	}

	public Pigeon(int posx, int posy, int egg, double flight, double stat, double takeoff, boolean moving) {
		super(posx, posy,_VITESSE_BIRD_COLIBRI, _WIDTH_BIRD_COLIBRI, _HEIGHT_BIRD_COLIBRI, flight, stat, egg, takeoff, moving);
		
		setTextures();
		_type = 7;
	}
	
	private void setTextures() {
		_liste_texture.add("img/birds/iago1Droite.png");
		_liste_texture.add("img/birds/iago2Droite.png");
		_liste_texture.add("img/birds/iago3Droite.png");
		_liste_texture.add("img/birds/iago4Droite.png");
		_liste_texture.add("img/birds/iago5Droite.png");
		_liste_texture.add("img/birds/iago6Droite.png");
		_liste_texture.add("img/birds/iago7Droite.png");
		
		_liste_texture_back.add("img/birds/iago1Gauche.png");
		_liste_texture_back.add("img/birds/iago2Gauche.png");
		_liste_texture_back.add("img/birds/iago3Gauche.png");
		_liste_texture_back.add("img/birds/iago4Gauche.png");
		_liste_texture_back.add("img/birds/iago5Gauche.png");
		_liste_texture_back.add("img/birds/iago6Gauche.png");
		_liste_texture_back.add("img/birds/iago7Gauche.png");
		
		_liste_destructing.add("img/explosion/explode1white.png");
		_liste_destructing.add("img/explosion/explode2white.png");
		_liste_destructing.add("img/explosion/explode3white.png");
		_liste_destructing.add("img/explosion/explode4white.png");
		_liste_destructing.add("img/explosion/explode5white.png");
		_liste_destructing.add("img/explosion/explode6white.png");
		
		_texture = "img/birds/iago1Droite.png";
	}
	
	@Override
	public Eggs lay_egg() {
		super.lay_egg();
		--_egg_left;
		return new Big_egg(getPosX(), getPosY());
	}
}
