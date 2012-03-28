package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controller.Bouton;
import Controller.Keyboard;
import Model.Constantes;
import Model.Fenetre;
import Model.StateFen;

public class MenuPause extends ZoneAff implements Constantes {
	private static final long serialVersionUID = 1913382158330314915L;
	
	private Image img;
	private Keyboard _keyListener;
	private Bouton _reprendre = new Bouton("Reprendre", 150, 300, 200, 50);
	private Bouton _reload = new Bouton("Recommencer", 450, 300, 200, 50);
	private Bouton _save = new Bouton("Sauvegarder", 150, 370, 200, 50);
	private Bouton _quit = new Bouton("Retour au Menu", 450, 370, 200, 50);

	private JLabel _title = new JLabel("Pause", SwingConstants.CENTER);
	private JLabel _highScore = new JLabel("Highscore", SwingConstants.CENTER);
	private JLabel _highScoreInt = new JLabel("", SwingConstants.RIGHT);
	private JLabel _currentScore = new JLabel("Score courant", SwingConstants.CENTER);
	private JLabel _currentScoreInt = new JLabel("", SwingConstants.RIGHT);

	private JPanel _high = new JPanel();
	private JPanel _current = new JPanel();
	
	public MenuPause () {
		super();
		
		try {
			setImg(ImageIO.read(new File("img/background/menu.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		_title.setBounds(310, 25, 155, 50);
		_title.setFont(new Font("Dialog", Font.BOLD, 50));
		add(_title);
		
		_highScore.setSize(200, 45);
		_highScore.setFont(new Font("Dialog", Font.BOLD, 40));
		_high.add(_highScore);
		
		_highScoreInt.setSize(150, 35);
		_highScoreInt.setFont(new Font("Dialog", Font.BOLD, 30));
		_high.add(_highScoreInt);
		
		_high.setBorder(BorderFactory.createLineBorder(new Color(12, 26, 35), 3));
		_high.setOpaque(true);
		_high.setBackground(new Color(9, 88, 144));
		_high.setVisible(true);
		_high.setLayout(new FlowLayout());
		_high.setBounds(140, 120, 220, 120);
		add(_high);
		
		_currentScore.setSize(280, 45);
		_currentScore.setFont(new Font("Dialog", Font.BOLD, 40));
		_current.add(_currentScore);
		
		_currentScoreInt.setSize(150, 35);
		_currentScoreInt.setFont(new Font("Dialog", Font.BOLD, 30));
		_current.add(_currentScoreInt);
		
		_current.setBorder(BorderFactory.createLineBorder(new Color(12, 26, 35), 3));
		_current.setOpaque(true);
		_current.setBackground(new Color(9, 88, 144));
		_current.setVisible(true);
		_current.setLayout(new FlowLayout());
		_current.setBounds(400, 120, 290, 120);
		add(_current);
        
		add(_reprendre);
		_reprendre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fenetre.setState(StateFen.Level);
				if (_DEBUG) System.out.println("Bouton Reprendre");
			}
		});
		
		add(_save);
		_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Fenetre._level.savelevel()) {
					Fenetre.setState(StateFen.MenuPrinc);
					Fenetre._fenster.updateMenu();
				} else {
					if (_DEBUG) System.out.println("Echec de la sauvegarde du level");
				}
				if (_DEBUG) System.out.println("Bouton Save");
			}
		});

		add(_reload);
		_reload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fenetre._level.reloadLvl();
				Fenetre.setState(StateFen.Level);
			}
		});
		
		add(_quit);
		_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Fenetre._level.saveExist(Fenetre._level.getLvl())) {
					int choix = JOptionPane.showConfirmDialog(null, "Vous n'avez pas sauvegarder la partie en cours, voulez-vous la sauvegarder ?", "Sauvegarde du level", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION);
					
					if (choix == JOptionPane.OK_OPTION) {
						Fenetre._level.savelevel();
						if (_DEBUG) System.out.println("Sauvegarde du level");
					}
				}
				Fenetre.setState(StateFen.MenuPrinc);
				Fenetre._fenster.updateMenu();
			}
		});
		
		_keyListener = new Keyboard(this);
		addKeyListener(_keyListener);
	}

	public void setImg(Image newImg) {
		img = newImg;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, Fenetre._fenster.getWidth(), Fenetre._fenster.getHeight(),null);
	}

	public void updateScore() {
		_highScoreInt.setText(String.valueOf(Fenetre._score.getHigh()));
		_currentScoreInt.setText(String.valueOf(Fenetre._score.getCurrent()));
	}

	@Override
	public void actionESC() {
		if (_DEBUG) System.out.println("Press ESC from Pause");
		Fenetre.setState(StateFen.Level);
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
