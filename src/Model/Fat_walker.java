package Model;


public class Fat_walker extends Walkers{
	public Fat_walker (int x, int y) {
		super(x, y, _VITESSE_FAT_WALKER, _WIDTH_FAT_WALKER, _HEIGHT_FAT_WALKER);

		_type = 5;
		setTextures();
	}

	public Fat_walker(int posx, int posy, boolean switched) {
		super(posx, posy, _VITESSE_FAT_WALKER, _WIDTH_FAT_WALKER, _HEIGHT_FAT_WALKER);
		
		_arriere = switched;
		_type = 5;
		
		setTextures();
	}

	private void setTextures() {
		_liste_texture.add("img/walkers/WarioDroite1.png");
		_liste_texture.add("img/walkers/WarioDroite2.png");
		_liste_texture.add("img/walkers/WarioDroite3.png");
		_liste_texture.add("img/walkers/WarioDroite4.png");
		_liste_texture.add("img/walkers/WarioDroite5.png");
		_liste_texture.add("img/walkers/WarioDroite6.png");

		_liste_texture_back.add("img/walkers/WarioGauche1.png");
		_liste_texture_back.add("img/walkers/WarioGauche2.png");
		_liste_texture_back.add("img/walkers/WarioGauche3.png");
		_liste_texture_back.add("img/walkers/WarioGauche4.png");
		_liste_texture_back.add("img/walkers/WarioGauche5.png");
		_liste_texture_back.add("img/walkers/WarioGauche6.png");
		
		_texture = "img/walkers/WarioDroite1.png";
	}

	@Override
	public void demol() {
		_destructed = true;
	}
}
