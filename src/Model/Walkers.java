package Model;

abstract public class Walkers extends MovingItems{
	protected boolean _arriere = false;
	
	public Walkers(double x, double y, int vitesse, int width, int height) {
		super(x,y,vitesse, width, height);
		_solid = true;
	}

	public void move(){
		int RandomWalk;
		if (!_arriere){
			moveX(_vitesse / 200 * _REFRESH_POS / 5);
		} else {
			moveX(-_vitesse / 200 * _REFRESH_POS / 5);
		}
		
		RandomWalk = (int) (Math.random() * 3000);
		
		if (RandomWalk < 3) {
			switchArriereState();
		}
		
		updateTexture((int)Math.ceil(1.0 * (_liste_texture.size() + 5) / _vitesse * 80));
	}
	
	private void updateTexture(int limit) {
		_timer += 1.0 * _REFRESH_POS / 5;
		
		if (_timer > limit) {
			++_statutTexture;
			
			if (!isDestructing()) {
				if (_arriere) {
					if(_statutTexture >= _liste_texture_back.size()) {
						_statutTexture = 0;
					}
					_texture = _liste_texture_back.get(_statutTexture);
				} else {
					if(_statutTexture >= _liste_texture.size()) {
						_statutTexture = 0;
					}
					_texture = _liste_texture.get(_statutTexture);
				}
			} else {
				if(_statutTexture < _liste_destructing.size()) {
					_texture = _liste_destructing.get(_statutTexture);
				}
			}
			
			_timer = 0;
		}
	}

	public void switchArriereState(){
		_arriere = !_arriere;
		_statutTexture = 0;
		
		if (_arriere) {
			_texture = _liste_texture_back.get(0);
		} else {
			_texture = _liste_texture.get(0);
		}
	}
	
	public boolean getSwitched() {
		return _arriere;
	}

	@Override
	public void demol() {
		_destructed = true;
	}
}
