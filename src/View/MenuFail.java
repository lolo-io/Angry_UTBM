/**
 * 
 */
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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controller.Bouton;
import Model.Constantes;
import Model.Fenetre;
import Model.StateFen;

/**
 * @author Boko
 *
 */
public class MenuFail extends ZoneAff implements Constantes {
	private static final long serialVersionUID = -2353393896889703030L;
	
	private Image img;
	
	private Bouton _choose = new Bouton("Choisir Niveau", 150, 370, 200, 50);
	private Bouton _reload = new Bouton("Recommencer", 300, 300, 200, 50);
	private Bouton _quit = new Bouton("Quitter", 450, 370, 200, 50);

	private JLabel _title = new JLabel("Perdu", SwingConstants.CENTER);
	private JLabel _highScore = new JLabel("Highscore", SwingConstants.CENTER);
	private JLabel _highScoreInt = new JLabel("", SwingConstants.RIGHT);
	private JLabel _currentScore = new JLabel("Score courant", SwingConstants.CENTER);
	private JLabel _currentScoreInt = new JLabel("", SwingConstants.RIGHT);

	private JPanel _high = new JPanel();
	private JPanel _current = new JPanel();
	
	public MenuFail () {
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
		
		add(_choose);
		_choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fenetre.setState(StateFen.LevelLoad);
				Fenetre._fenster.updateMenu();
				
				if (_DEBUG) System.out.println("Bouton Choisir Niveau");
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
				Fenetre.setState(StateFen.MenuPrinc);
				Fenetre._fenster.updateMenu();
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
		// TODO Auto-generated method stub

	}

	public void updateScore() {
		_highScoreInt.setText(String.valueOf(Fenetre._score.getHigh()));
		_currentScoreInt.setText(String.valueOf(Fenetre._score.getCurrent()));
	}

}
