package Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;


public class Bouton extends JButton implements MouseListener {
	private static final long serialVersionUID = 1L;
	protected Image _img;
	protected String _name;
	
	public Bouton(String name, int X, int Y, int width, int height) {
		super(name);
		_name = name;
		
		//setBackground(Color.WHITE);
		setBounds(X,Y,width,height);
		addMouseListener(this);
		setOpaque(true);
		setBorder(null);
		
		try {
			setImg(ImageIO.read(new File("img/button/button.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		try {
			setImg(ImageIO.read(new File("img/button/button.focus.png")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		try {
			setImg(ImageIO.read(new File("img/button/button.png")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		try {
			setImg(ImageIO.read(new File("img/button/button.png")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void setImg(Image img) {
		this._img = img;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(_img, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.drawString(_name, (getWidth() / 2 - g.getFontMetrics().stringWidth(_name) / 2), (getHeight() / 2) + 5);
	}

}
