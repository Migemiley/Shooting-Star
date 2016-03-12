package shootingstar;
/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ShootingStar extends Canvas {
	public static final int szer = 800;
	public static final int wys = 600;
	
	public ShootingStar(){
		JFrame okno = new JFrame("Shooting Star");
		JPanel panel = (JPanel)okno.getContentPane();
		setBounds(0,0,szer,wys);
		panel.setPreferredSize(new Dimension(szer,wys));
		panel.setLayout(null);
		panel.add(this);
		okno.setBounds(0,0,szer,wys);
		okno.setVisible(true);
		
		okno.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public void paint(Graphics grafika){
		grafika.setColor (Color.blue);
		grafika.fillRect(szer/2, wys/3, 100, 200);
	}
	
	public static void main(String[] args) {
		ShootingStar inv = new ShootingStar();
	}
	
}
