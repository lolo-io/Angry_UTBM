package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.Keyboard;
import Model.Fenetre;
import Model.StateFen;

public class MenuHigh extends ZoneAff {
	private static final long serialVersionUID = -8417133885786590651L;

	private Keyboard _keyListener;
	private JLabel _title = new JLabel("Credits", SwingConstants.CENTER);
	private JLabel _codeP1 = new JLabel("Barthelemy", SwingConstants.CENTER);
	private JLabel _codeN1 = new JLabel("LAURANS", SwingConstants.CENTER);
	private JLabel _codeP2 = new JLabel("Valentin", SwingConstants.CENTER);
	private JLabel _codeN2 = new JLabel("DESCHAINTRE", SwingConstants.CENTER);
	private JLabel _codeP3 = new JLabel("Benjamin", SwingConstants.CENTER);
	private JLabel _codeN3 = new JLabel("MARCH", SwingConstants.CENTER);
	private JLabel _codeP4 = new JLabel("Loic", SwingConstants.CENTER);
	private JLabel _codeN4 = new JLabel("TEYSSIER", SwingConstants.CENTER);
	
	public MenuHigh() {
		super();
		
		setBackground(Color.BLACK);
	
		_title.setBounds(300, 25, 175, 50);
		_title.setFont(new Font("Dialog", Font.BOLD, 50));
		_title.setForeground(Color.white);
		add(_title);
	
		_codeP1.setBounds(130, 180, 230, 45);
		_codeP1.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeP1.setForeground(Color.white);
		add(_codeP1);
		
		_codeN1.setBounds(405, 180, 280, 45);
		_codeN1.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeN1.setForeground(Color.white);
		add(_codeN1);
	
		_codeP2.setBounds(125, 240, 240, 45);
		_codeP2.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeP2.setForeground(Color.white);
		add(_codeP2);
		
		_codeN2.setBounds(395, 240, 300, 45);
		_codeN2.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeN2.setForeground(Color.white);
		add(_codeN2);
	
		_codeP3.setBounds(145, 300, 200, 45);
		_codeP3.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeP3.setForeground(Color.white);
		add(_codeP3);
		
		_codeN3.setBounds(405, 300, 280, 45);
		_codeN3.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeN3.setForeground(Color.white);
		add(_codeN3);
	
		_codeP4.setBounds(145, 360, 200, 45);
		_codeP4.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeP4.setForeground(Color.white);
		add(_codeP4);
		
		_codeN4.setBounds(405, 360, 280, 45);
		_codeN4.setFont(new Font("Dialog", Font.BOLD, 40));
		_codeN4.setForeground(Color.white);
		add(_codeN4);
		
		_keyListener = new Keyboard(this);
		addKeyListener(_keyListener);
	}
	@Override
	public void actionESC() {
		Fenetre._state = StateFen.MenuPrinc;
		Fenetre._fenster.updateMenu();
	}

	@Override
	public void actionSPACE() {
		
	}

	@Override
	public void actionENTER() {
		
	}
	
}
