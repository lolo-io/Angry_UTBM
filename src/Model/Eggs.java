package Model;


abstract public class Eggs extends MovingItems {
	public Eggs(double x, double y, int vitesse, int width, int height) {
		super(x, y, vitesse, width, height);
	}
	
	public void move() {
		moveY(_vitesse / 10 * _REFRESH_POS / 5);
	}
	
	public void demol() {
		_destructed = true;
	}
}
