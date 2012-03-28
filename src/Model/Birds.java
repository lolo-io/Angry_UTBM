package Model;

abstract public class Birds extends MovingItems {

	protected double _flight_time = 0;
	protected double _stat_time = 0;
	protected int _egg_left = 0;
	protected double _takeoff = 0;
	protected boolean _bouge = false;
	protected boolean _arriere = false;
	private boolean _stationnary = true;

	
	public Birds(double x, double y,int vitesse, int width, int height, double flight_time, double stat_time, int egg_left, double takeoff, boolean bouge) {
		super(x,y,vitesse,width,height);
		_flight_time = flight_time * 1000;
		_stat_time = stat_time * 1000;
		_egg_left = egg_left;
		_takeoff = takeoff;
		_solid = true;
		setMoving(bouge);
	}
	
	private void take_off () {
		moveX(_vitesse / 200 * _REFRESH_POS / 5);
		moveY(-1.2 * _REFRESH_POS / 5);
		_takeoff += 1.0 * _REFRESH_POS / 5;
	}
	
	private void land () {
		moveX(_vitesse / 200 * _REFRESH_POS / 5);
		moveY(1.2 * _REFRESH_POS / 5);
	}

	private void land_back() {
		moveX(-_vitesse / 200 * _REFRESH_POS / 5);
		moveY(1.2 * _REFRESH_POS / 5);
	}
	
	public void move() {
		if (!_destructing && !_arriere) {
			if (_takeoff < 60 && getMoving()) {
				take_off();
			} else if (_flight_time <= 0) {
				land();
			} else if (getMoving()) {
				moveX(_vitesse / 200 * _REFRESH_POS / 5);
			}
		} else if (!_destructing && _arriere) {
			if (_flight_time <= 0) {
				land_back();
			} else if (getMoving()) {
				moveX(-_vitesse / 200 * _REFRESH_POS / 5);
			}
		}
		
		if (Fenetre._fenster.outScreen(this) && !_arriere) {
			_statutTexture = 0;
			_arriere =! _arriere;
		} else if (Fenetre._fenster.outScreen(this) && _arriere) {
			_statutTexture = 0;
			_arriere =! _arriere;
		}
		
		if (_takeoff > 0) {
			_flight_time -= _REFRESH_POS;
		}
		
		if (!getMoving() && _takeoff > 0) {
			_stat_time -= _REFRESH_POS;
		}
		
		if (_takeoff > 0) updateTexture((int)Math.ceil(_vitesse / 10));
		if (_stat_time <= 0 && _takeoff > 0) setMoving(true);
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
	
	
	/* Largue un oeuf
	* @param void
	* @return Eggs
	*/
	public Eggs lay_egg() {
		if (_DEBUG) System.out.println("Lacher oeuf.");
		return null;
	}
	
	/* Retourne true si l'oiseau est en train de bouger
	* @param void
	* @return boolean
	*/
	public boolean getMoving() {
		return _bouge;
	}
	
	/* Donne une nouvelle valeur à la variable _bouge
	* @param boolean newVal
	* @return void
	*/
	public void setMoving(boolean newVal) {
		_bouge = newVal;
	}

	public int getEggLeft() {
		return _egg_left;
	}

	public double getFlightTime() {
		return _flight_time / 1000;
	}

	public double getStatTime() {
		return _stat_time / 1000;
	}

	public double getTakeOff() {
		return _takeoff;
	}
	
	@Override
	public void demol() {
		if (!_destructing) {
			_destructing = true;
			_statutTexture = 0;
		} else {
			updateTexture(18);
			if(_statutTexture >= _liste_destructing.size()) {
				_destructed = true;
			}
		}
	}

	public boolean getStationnaire() {
		return _stationnary;
	}

	public void setStationnaire(boolean stationnaire) {
		this._stationnary = stationnaire;
	}
}
