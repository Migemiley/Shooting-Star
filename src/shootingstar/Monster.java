package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */
public class Monster extends Actor{
	protected int sx;
	
	public Monster(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"star1.png","star2.png"});
		setFrameSpeed(25);
	}
	
	public void act() {
		super.act();
		x += sx;
		if (x < 0 || x > Stage.szer)
			sx = -sx;
	}
	
	public int getVx() { return sx; }
	public void setVx(int i) { sx = i; }
}
