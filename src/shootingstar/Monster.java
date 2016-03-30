package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */
public class Monster extends Actor{
	protected int sx;
	
	public Monster(Stage stage) {
		super(stage);
		setSpriteName("star1.png");
	}
	
	public void act() {
		x += sx;
		if (x < 0 || x > Stage.szer)
			sx = -sx;
	}
	
	public int getVx() { return sx; }
	public void setVx(int i) { sx = i; }
}
