package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */
public class Monster extends Actor{
	protected int vx;
	
	public Monster(Stage stage) {
		super(stage);
		setSpriteName("star1.png");
	}
	
	public void act() {
		x+=vx;
		if (x < 0 || x > Stage.szer)
			vx = -vx;
	}
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i; }
}
