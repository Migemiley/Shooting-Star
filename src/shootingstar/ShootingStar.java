package shootingstar;
/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */

// Dodanie odpowiednich bibliotek
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.HashMap;

public class ShootingStar extends Canvas {
	// Dodanie globalnych zmiennych dotyczących szerokości i wysokości okna aplikacji
	public static final int szer = 800;
	public static final int wys = 600;
	public HashMap sprites;
	public int pX, pY;
	
	// Konstruktor ShootingStar(), w którym zostaje zainicjowane okno aplikacji
	public ShootingStar(){
		pX = szer/2;
		pY = wys/2;
		sprites = new HashMap();
		
		JFrame okno = new JFrame("Shooting Star");
		JPanel panel = (JPanel)okno.getContentPane();
		setBounds(0,0,szer,wys);
		panel.setPreferredSize(new Dimension(szer,wys));
		panel.setLayout(null);
		panel.add(this);
		okno.setBounds(0,0,szer,wys);
		okno.setVisible(true);
		
		okno.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	// Metoda odpowiadająca za wczytywanie grafik
	public BufferedImage loadImage(String wczyt){
		URL url = null;
		try {
			url = getClass().getClassLoader().getResource(wczyt);
			return ImageIO.read(url);
		} catch (Exception e){
			System.out.println(wczyt + " " + url);
			System.out.println("Blad - "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	public BufferedImage getSprite(String wczyt){
		BufferedImage img = (BufferedImage)sprites.get(wczyt);
		if (img == null){
			img = loadImage("img/"+wczyt);
			sprites.put(wczyt, img);
		}
		return img;
	}
	
	// Metoda odpowiadająca za rysowanie
	@Override
	public void paint(Graphics grafika){
		grafika.drawImage(getSprite("star1.png"), pX, pY, this);
	}
	
	public void updateWorld() {
		pX = (int) (Math.random()*szer);
		pY = (int) (Math.random()*wys);
	}
	
	public void game() {
		while (isVisible()) {
			updateWorld();
			paint(getGraphics());
		}
	}
	
	public static void main(String[] args) {
		ShootingStar inv = new ShootingStar();
		inv.game();
	}
}
