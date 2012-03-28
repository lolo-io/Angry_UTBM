package Model;


public class Obstacle extends ItemDisplay {
	public Obstacle () {
		_type = 1;
	}
	
	public Obstacle (int x, int y, String texture, int width, int height) {
		super (x, y, width, height);
		_solid = true;
		_type = 1;
		_texture = texture;
	}
}
