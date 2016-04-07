package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */

import javax.swing.JFrame;
import java.io.FileNotFoundException;

public class ShootingStar extends JFrame{

	public ShootingStar() throws FileNotFoundException{
		super("Shooting Star");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		ShootingStar2 ShootingStar2 = new ShootingStar2();
		add(ShootingStar2);
		setVisible(true);
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		new ShootingStar();
		ShootingStar2.timer.start();
	}
}