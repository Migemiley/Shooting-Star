package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Actor {
	protected int x, y;
	protected int szer, wys;
	protected String spriteName;
	protected Stage stage;
	protected SpriteCache spriteCache;
	protected int currentFrame;
	protected String[] spriteNames;
	protected int frameSpeed;
	protected int t;
	
	public Actor (Stage stage) {
		this.stage = stage;
		spriteCache = stage.getSpriteCache();
		currentFrame = 0;
		frameSpeed = 1;
		t = 0;
	}
	
	public void paint (Graphics2D grafika) {
		grafika.drawImage( spriteCache.getSprite(spriteName), x, y, stage );
	}
	
	public int getX() { return x; }
	public void setX(int i) { x = i; }
	
	public int getY() { return y; }
	public void setY(int i) { y = i; }
	
	public String getSpriteName() { return spriteName; }
	
	public void setSpriteNames(String[] names) {
		spriteNames = names;
		wys = 0;
		szer = 0;
		for (int i = 0; i < names.length; i++ ) {
			BufferedImage image = spriteCache.getSprite(spriteNames[i]);
			wys = Math.max(wys,image.getHeight());
			wys = Math.max(szer,image.getWidth());
		}
	}
	
	public int getHeight() { return wys; }
	public int getWidth() { return szer; }
	public void setHeight(int i) {wys = i; }
	public void setWidth(int i) { szer = i; }
	
	public int getFrameSpeed() {return frameSpeed; }
	public void setFrameSpeed(int i) {frameSpeed = i; }
	
	public void act() {
		t++;
		if (t % frameSpeed == 0){
			t=0;
			currentFrame = (currentFrame + 1) % spriteNames.length;
		}
	}
}
