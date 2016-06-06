/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */
public class EBullet extends Actor {
	protected static final int BULLET_SPEED = 3;

	public EBullet(Stage stage) {
		super(stage);
		setSpriteNames(new String[] { "red1.png"});
		setFrameSpeed(10);
	}

	public void act() {
		super.act();
		y += BULLET_SPEED;
		if (y > Stage.WYSOKOSC_GRY)
			remove();
	}
	
	public void collision(Actor a) {
		if (a instanceof Player) {
			remove();
		}
	}
}