package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */
import java.awt.event.KeyEvent;

public class Player extends Actor {
	protected static final int PLAYER_SPEED = 5;
	protected int vx;
	protected int vy;
	private boolean up, down, left, right;
	public static final int MAX_HP = 250;
	public static final int MAX_BOMBS = 25, MAX_MISSLE = 7;
	public static int score;
	private int hp;
	private int clusterBombs, missle;
	public int ExhaustedBullet = 0, ExhaustedBomb = 0, ExhaustedMissle = 0;

	public Player(Stage stage) {
		super(stage);
		setSpriteNames(new String[] { "kstar.png" });
		clusterBombs = MAX_BOMBS;
		missle = MAX_MISSLE;
		hp = MAX_HP;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int i) {
		score = i;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int i) {
		hp = i;
	}
	
	public void addScore(int i) {
		score += i;
	}

	public void addHp(int i) {
		if (hp > -1 * i) {
			hp += i;
		} else {
			hp = 0;
		}
	}
	
	public int getClusterBombs() {
		return clusterBombs;
	}
	
	public int getMissle() {    
		return missle;          
	}  

	public void act() {
		super.act();
		x += vx;
		y += vy;
		if (x < 0)
			x = 0;
		if (x > Stage.SZEROKOSC - getWidth())
			x = Stage.SZEROKOSC - getWidth();
		if (y < 0)
			y = 0;
		if (y > Stage.WYSOKOSC_GRY - getHeight())
			y = Stage.WYSOKOSC_GRY - getHeight();
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int i) {
		vx = i;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int i) {
		vy = i;
	}

	protected void updateSpeed() {
		vx = 0;
		vy = 0;
		if (down)
			vy = PLAYER_SPEED;
		if (up)
			vy = -PLAYER_SPEED;
		if (left)
			vx = -PLAYER_SPEED;
		if (right)
			vx = PLAYER_SPEED;
	}
	
	public void fire() {
		Bullet b = new Bullet(stage);
		b.setX(x + (getWidth() / 2 - b.getWidth() / 2));
		b.setY(y - b.getHeight());
		stage.addActor(b);
	}
	
	public void fireCluster() {
		if (clusterBombs == 0)
			return;

		clusterBombs--;
		stage.addActor(new Bomb(stage, Bomb.UP_LEFT, x + getWidth() / 2, y
				+ getHeight() / 2));
		stage.addActor(new Bomb(stage, Bomb.UP, x + getWidth() / 2, y
				+ getHeight() / 2));
		stage.addActor(new Bomb(stage, Bomb.UP_RIGHT, x + getWidth() / 2, y
				+ getHeight() / 2));
		
	}
	
	public void fireMissle() {
		if (missle == 0)
			return;
		missle--;
		Missle m = new Missle(stage);
		m.setX(x + (getWidth() / 2 - m.getWidth() / 2));
		m.setY(y - m.getHeight());
		stage.addActor(m);
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_SPACE:
			ExhaustedBullet = 0;
			break;
		case KeyEvent.VK_B:
			ExhaustedBomb = 0;
			break;
			case KeyEvent.VK_M:
			ExhaustedMissle = 0;
			break;
		}
		updateSpeed();
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_SPACE:
			if (ExhaustedBullet == 0) {
				fire();
			}
			ExhaustedBullet = 1;
			break;
		case KeyEvent.VK_B:
			if (ExhaustedBomb == 0) {
				fireCluster();
			}
			ExhaustedBomb = 1;
			break;
			case KeyEvent.VK_M:
			if (ExhaustedMissle == 0) {
				fireMissle();
			}
			ExhaustedMissle = 1;
			break;
		}
		updateSpeed();
	}
	
	public void collision(Actor a) {
		if (a instanceof Monster) {
			addHp(-40);
		}
		if (a instanceof EBullet) {
			addHp(-10);
		}
		if (getHp() <= 0) 
		{ 
			stage.gameLose();
		}
	}
}