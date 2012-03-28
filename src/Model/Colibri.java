package Model;


public class Colibri extends Birds {
	/* Cree un oiseau de type Colibri
	* @param float x
	* @param float y
	* @return void
	*/
	public Colibri(double x, double y) {
		super(x, y,_VITESSE_BIRD_COLIBRI, _WIDTH_BIRD_COLIBRI, _HEIGHT_BIRD_COLIBRI, _FLIGHT_TIME_BIRD_COLIBRI, _STAT_TIME_BIRD_COLIBRI, _EGGS_COLIBRI, 0, false);
		
		setTextures();
		_type = 6;
	}
	
	public Colibri(double posx, double posy, int egg, double flight, double stat, double takeoff, boolean moving) {
		super(posx, posy,_VITESSE_BIRD_COLIBRI, _WIDTH_BIRD_COLIBRI, _HEIGHT_BIRD_COLIBRI, flight, stat, egg, takeoff, moving);
		
		setTextures();
		_type = 6;
	}
	
	private void setTextures() {
		_liste_texture.add("img/birds/squaks1Droite.png");
		_liste_texture.add("img/birds/squaks2Droite.png");
		_liste_texture.add("img/birds/squaks3Droite.png");
		_liste_texture.add("img/birds/squaks4Droite.png");
		_liste_texture.add("img/birds/squaks5Droite.png");
		_liste_texture.add("img/birds/squaks6Droite.png");
		_liste_texture.add("img/birds/squaks7Droite.png");
		_liste_texture.add("img/birds/squaks8Droite.png");
		_liste_texture.add("img/birds/squaks7Droite.png");
		_liste_texture.add("img/birds/squaks6Droite.png");
		_liste_texture.add("img/birds/squaks5Droite.png");
		_liste_texture.add("img/birds/squaks4Droite.png");
		_liste_texture.add("img/birds/squaks3Droite.png");
		_liste_texture.add("img/birds/squaks2Droite.png");
		
		_liste_texture_back.add("img/birds/squaks1Gauche.png");
		_liste_texture_back.add("img/birds/squaks2Gauche.png");
		_liste_texture_back.add("img/birds/squaks3Gauche.png");
		_liste_texture_back.add("img/birds/squaks4Gauche.png");
		_liste_texture_back.add("img/birds/squaks5Gauche.png");
		_liste_texture_back.add("img/birds/squaks6Gauche.png");
		_liste_texture_back.add("img/birds/squaks7Gauche.png");
		_liste_texture_back.add("img/birds/squaks8Gauche.png");
		_liste_texture_back.add("img/birds/squaks7Gauche.png");
		_liste_texture_back.add("img/birds/squaks6Gauche.png");
		_liste_texture_back.add("img/birds/squaks5Gauche.png");
		_liste_texture_back.add("img/birds/squaks4Gauche.png");
		_liste_texture_back.add("img/birds/squaks3Gauche.png");
		_liste_texture_back.add("img/birds/squaks2Gauche.png");
		
		_liste_destructing.add("img/explosion/explode1white.png");
		_liste_destructing.add("img/explosion/explode2white.png");
		_liste_destructing.add("img/explosion/explode3white.png");
		_liste_destructing.add("img/explosion/explode4white.png");
		_liste_destructing.add("img/explosion/explode5white.png");
		_liste_destructing.add("img/explosion/explode6white.png");
		
		_texture = "img/birds/squaks1Droite.png";
	}

	@Override
	public Eggs lay_egg() {
		super.lay_egg();
		--_egg_left;
		return new Small_egg(getPosX(), getPosY());
	}
}
