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
public class Bomb extends Actor {
	public static final int UP_LEFT = 0;
	public static final int UP = 1;
	public static final int UP_RIGHT = 2;


	protected static final int BOMB_SPEED = 5;
	protected int vx;
	protected int vy;

	public Bomb(Stage stage, int heading, int x, int y) {
		super(stage);
		this.x = x;
		this.y = y;
		String sprite = "";
		switch (heading) {
		case UP_LEFT:
			vx = -BOMB_SPEED;
			vy = -BOMB_SPEED;
			sprite = "hyper.png";
			break;
		case UP:
			vx = 0;
			vy = -BOMB_SPEED;
			sprite = "hyper.png";
			break;
		case UP_RIGHT:
			vx = BOMB_SPEED;
			vy = -BOMB_SPEED;
			sprite = "hyper.png";
			break;
		}
		setSpriteNames(new String[] { sprite });
	}

	public void act() {
		super.act();
		y += vy;
		x += vx;
		if (y < 0 || y > Stage.WYSOKOSC || x < 0 || x > Stage.SZEROKOSC)
			remove();
	}

	public void collision(Actor a) {
		if (a instanceof Monster) {
			remove();
		}
	}
}