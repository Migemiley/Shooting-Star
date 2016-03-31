package shootingstar;
/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */

// Dodanie odpowiednich bibliotek
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class ShootingStar extends Canvas implements Stage {
	public long usedTime;
	public BufferStrategy strat;
	private SpriteCache spriteCache;
	private ArrayList actors;
	
	// Konstruktor ShootingStar(), w którym zostaje zainicjowane okno aplikacji
	public ShootingStar(){
		spriteCache = new SpriteCache();
		JFrame okno = new JFrame("Shooting Star");
		JPanel panel = (JPanel)okno.getContentPane();
		setBounds(0,0,Stage.szer,Stage.wys);
		panel.setPreferredSize(new Dimension(Stage.szer,Stage.wys));
		panel.setLayout(null);
		panel.add(this);
		okno.setBounds(0,0,Stage.szer,Stage.wys);
		okno.setVisible(true);
		
		okno.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		okno.setResizable(false);
		createBufferStrategy(2);
		strat = getBufferStrategy();
		requestFocus();
	}
	
	public void initWorld() {
		actors = new ArrayList();
		for (int i = 0; i < 10; i++){
			Monster m = new Monster(this);
			m.setX( (int)(Math.random()*Stage.szer) );
			m.setY( i*20 );
			m.setVx( (int)(Math.random()*3)+1 );
			actors.add(m);
		}
	}
	
	// Metoda odpowiadająca za rysowanie

	public void paintWorld(){
		Graphics2D grafika = (Graphics2D)strat.getDrawGraphics();
		grafika.setColor(Color.DARK_GRAY);
		grafika.fillRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < actors.size(); i++) {
			Actor m = (Actor)actors.get(i);
			m.paint(grafika);
		}
		grafika.setColor(Color.white);
		if (usedTime > 0)
			grafika.drawString(String.valueOf(1000/usedTime)+" fps",0,Stage.wys-50);
		else grafika.drawString("-- fps",0,Stage.wys-50);
		strat.show();
	}
	
	public void updateWorld() {
		for (int i = 0; i < actors.size(); i++) {
			Actor m = (Actor)actors.get(i);
			m.act();
		}
	}
	
	public SpriteCache getSpriteCache() {
		return spriteCache;
	}
	
	public void game() {
		usedTime = 1000;
		initWorld();
		while (isVisible()) {
			long startTime = System.currentTimeMillis();
			updateWorld();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;
			try {
				Thread.sleep(Stage.szyb);
			} catch (InterruptedException e) {}
			}
	}
	
	
	public static void main(String[] args) {
		ShootingStar inv = new ShootingStar();
		inv.game();
	}
}
