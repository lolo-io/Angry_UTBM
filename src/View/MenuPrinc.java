package View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.Bouton;
import Model.Constantes;
import Model.Fenetre;
import Model.StateFen;

public class MenuPrinc extends ZoneAff implements Constantes {
	private static final long serialVersionUID = 2864905028652238985L;
	
	private Image img;

	private Bouton jouer = new Bouton("Commencer une partie", 300, 250, 200, 50);
	private Bouton exit = new Bouton("Quitter le jeu", 300, 350, 200, 50);
	private JLabel _title = new JLabel("AngryUTBM", SwingConstants.CENTER);
	
	public MenuPrinc () {
		super();
		
		try {
			setImg(ImageIO.read(new File("img/background/menu.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		_title.setBounds(240, 25, 310, 70);
		_title.setFont(new Font("Dialog", Font.BOLD, 50));
		add(_title);
		
		add(jouer);
		jouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fenetre.setState(StateFen.LevelLoad);
				Fenetre._fenster.updateMenu();
				if (_DEBUG) System.out.println("Bouton Jouer");
			}
		});
		add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fenetre._working = false;
				if (_DEBUG) System.out.println("Bouton Exit");
			}
		});
	}

	public void setImg(Image newImg) {
		img = newImg;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, Fenetre._fenster.getWidth(), Fenetre._fenster.getHeight(),null);
	}

	@Override
	public void actionESC() {
		
	}

	@Override
	public void actionSPACE() {
		
	}

	@Override
	public void actionENTER() {
		
	}
}