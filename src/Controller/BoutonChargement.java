package Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BoutonChargement extends Bouton {
	private static final long serialVersionUID = 1L;
	private int _highscore;
	private Image _star;

	public BoutonChargement(String name, int X, int Y, int width, int height, int high) {
		super(name, X, Y, width, height);

		_highscore = high;
		
		try {
			_star = ImageIO.read(new File("img/button/star.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(_img, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.drawString(_name, (getWidth() / 2 - g.getFontMetrics().stringWidth(_name) / 2), 20);
		g.drawString(String.valueOf(_highscore), (getWidth() - g.getFontMetrics().stringWidth(String.valueOf(_highscore)) - 5), 40);
		g.drawImage(_star, 5, getHeight() - 25, 20, 18, null);
	}
}
