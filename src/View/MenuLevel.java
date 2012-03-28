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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Controller.BoutonChargement;
import Controller.Keyboard;
import Model.Constantes;
import Model.Fenetre;
import Model.StateFen;


public class MenuLevel extends ZoneAff implements Constantes {
	private static final long serialVersionUID = -3449213442064345585L;
	private String path = "levels/";
	private Image img;
	private Keyboard _keyListener;
	
	private JLabel _title = new JLabel("Choix du niveau", SwingConstants.CENTER);
	
	public MenuLevel () {
		super();
		
		int i;
		int posx;
		int posy;
		int index;
		
		try {
			setImg(ImageIO.read(new File("img/background/menu.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		_title.setBounds(200, 25, 390, 70);
		_title.setFont(new Font("Arial", Font.BOLD, 45));
		add(_title);
		
		setLayout(null);
		
		String [] listefichiers;
		File repertoire = new File(path);

		listefichiers = repertoire.list();
		
		for (i = 0; i < listefichiers.length; ++i){
			final int lvl = i + 1;
			
			
			index = listefichiers[i].indexOf(".");
			String temp = listefichiers[i].substring(index);
			listefichiers[i] = listefichiers[i].replaceAll(temp, "");
			File entree = new File(listefichiers[i]);
			
			posx = i % 4;
			posy = i / 4;
			
			if (_DEBUG) System.out.println("Tour de boucle " + lvl + " name : " + entree.getName());
			
			if ((i + 1) <= Fenetre._level.getMaxLvl()) {
				BoutonChargement temp1 = new BoutonChargement("Niveau " + (i + 1), 160 + posx * 130, 120 + posy * 70, 100, 50, Fenetre._level.loadHighScore(lvl));
				temp1.setOpaque(true);
				if (_DEBUG) System.out.println("Detection du niveau " + lvl);
				if (Fenetre._level.saveExist(lvl)) {
					temp1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int choix = JOptionPane.showConfirmDialog(null, "Il existe une sauvegarde de ce niveau. Voulez-vous la charger ?", "Sauvegarde existante", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION);
						
						if (choix == JOptionPane.OK_OPTION) {
							Fenetre._level.loadSave(lvl);
							Fenetre.setState(StateFen.Level);
							if (_DEBUG) System.out.println("Debut du level sauvegarde " + lvl);
						} else {
							Fenetre._level.loadLevel(lvl);
							Fenetre._level.deleteSave(lvl);
							Fenetre.setState(StateFen.Level);
							if (_DEBUG) System.out.println("Debut du level " + lvl);
						}
					}
				});
				} else {
					temp1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Fenetre._level.loadLevel(lvl);
							Fenetre.setState(StateFen.Level);
							if (_DEBUG) System.out.println("Debut du level " + lvl);
						}
					});
				}
				temp1.setVisible(true);
				add(temp1);
			}
		}
		
		_keyListener = new Keyboard(this);
		addKeyListener(_keyListener);
	}

	public void setImg(Image newImg) {
		img = newImg;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, Fenetre._fenster.getWidth(), Fenetre._fenster.getHeight(), null);
		
	}
	
	@Override
	public void actionESC() {
		Fenetre.setState(StateFen.MenuPrinc);
		Fenetre._fenster.updateMenu();
	}

	@Override
	public void actionSPACE() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionENTER() {
		// TODO Auto-generated method stub

	}

}
