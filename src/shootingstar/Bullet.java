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
public class Bullet extends Actor {
	protected static final int BULLET_SPEED = 10;

	public Bullet(Stage stage) {
		super(stage);
		setSpriteNames(new String[] { "red.png" });
	}

	public void act() {
		super.act();
		y -= BULLET_SPEED;
		if (y < 0)
			remove();
	}

	public void collision(Actor a) {
		if (a instanceof Monster) {
			remove();
		}
	}
}