package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import Controller.Keyboard;
import Model.Birds;
import Model.Constantes;
import Model.Eggs;
import Model.Fenetre;
import Model.ItemDisplay;
import Model.StateFen;
import Model.Walkers;

public class Affichage extends ZoneAff implements Constantes {
	/**
	* Obligatoire mais des recherches à faire pour savoir pk
	*/
	private static final long serialVersionUID = 1L;
	private Keyboard _keyListener;
	private Birds _currentBird;
	private int _score;
	private int _highscore;
	
	public Affichage() {
		super();
		
		_keyListener = new Keyboard(this);
		addKeyListener(_keyListener);
	}

	public void paintComponent(Graphics g) {	
		for(int i = 0; i < Fenetre._list_static_items.size(); i++) {
			try {
				ItemDisplay stock = Fenetre._list_static_items.get(i);
				Image img = ImageIO.read(new File(stock._texture));
				g.drawImage(img, stock.getPosX(), stock.getPosY(), stock.getWidth(), stock.getHeight(), this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		synchronized(Fenetre._list_birds) {
			for(int i = 0; i < Fenetre._list_birds.size(); i++) {
				try {
					Birds stock = Fenetre._list_birds.get(i);
					if (!stock.isDestructed()) {
						Image img = ImageIO.read(new File(stock._texture));
						g.drawImage(img, stock.getPosX(), stock.getPosY(), stock.getWidth(), stock.getHeight(), this);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		synchronized(Fenetre._list_walkers) {
			for(int i = 0; i < Fenetre._list_walkers.size(); i++){
				try {
					Walkers stock = Fenetre._list_walkers.get(i);
					if (!stock.isDestructed()) {
						Image img = ImageIO.read(new File(stock._texture));
						g.drawImage(img, stock.getPosX(), stock.getPosY(), stock.getWidth(), stock.getHeight(), this);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		synchronized(Fenetre._list_egg) {
			for(int i = 0; i < Fenetre._list_egg.size(); i++){
				try {
					Eggs stock = Fenetre._list_egg.get(i);
					if (!stock.isDestructed()) {
						Image img = ImageIO.read(new File(stock._texture));
						g.drawImage(img, stock.getPosX(), stock.getPosY(), stock.getWidth(), stock.getHeight(), this);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		_score = Fenetre._score.getCurrent();
		_highscore = Fenetre._score.getHigh();
		
		if (_score > _highscore) {
			g.setColor(new Color(255, 0, 0));
		} else {
			g.setColor(new Color(255, 255, 255));
		}
		g.setFont(new Font("Comic sans ms", Font.BOLD, 20));
		g.drawString("Score : " + _score, 50, 50);
		g.setColor(new Color(255, 255, 255));
		g.drawString("HighScore : " + _highscore, 50, 70);
		g.setColor(Color.white);
		g.drawString("Niveau " + Fenetre._level.getLvl(), (getWidth() / 2 - g.getFontMetrics().stringWidth("Niveau " + Fenetre._level.getLvl()) / 2), 40);
	}
	
	public void changeBird (Birds newBird) {
		_currentBird = newBird;
	}
	
	@Override
	public void actionESC() {
		if (_DEBUG) System.out.println("Press ESC from Level");
		Fenetre.setState(StateFen.MenuPause);
	}
	
	@Override
	public void actionSPACE() {
		if (Fenetre._state == StateFen.Level){ 
			if (Fenetre._list_birds.size() != 0) { // Test s'il existe un oiseau
				if(_currentBird.getStationnaire()|| _currentBird.getTakeOff()== 0){	
					if (_currentBird.getMoving()) {
						if (_DEBUG) System.out.println("Vol Stationnaire.");
					} else {
						if (_DEBUG) System.out.println("Mise en mouvement.");
					}
					
					_currentBird.setMoving(!_currentBird.getMoving());
				}
				else if (!_currentBird.getStationnaire()){
					if (_DEBUG) System.out.println("Vol Stationnaire interdit pour cet oiseau.");
				}
			}
		}
	}
	
	@Override
	public void actionENTER() {
		if (Fenetre._state == StateFen.Level && _currentBird.getTakeOff() != 0 && !_currentBird.isDestructing()){
			// Test s'il existe un oiseau et s'il existe demande a l'oiseau de lacher un oeuf
			if (Fenetre._list_birds.size() != 0 && _currentBird.getEggLeft() > 0) {
				Fenetre._list_egg.add(_currentBird.lay_egg());
			}
		}
	}
	
}