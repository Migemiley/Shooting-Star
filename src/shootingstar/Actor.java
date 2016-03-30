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
	
	public Actor (Stage stage) {
		this.stage = stage;
		spriteCache = stage.getSpriteCache();
	}
	
	public void paint (Graphics2D grafika) {
		grafika.drawImage( spriteCache.getSprite(spriteName), x, y, stage );
	}
	
	public int getX() { return x; }
	public void setX(int i) { x = i; }
	
	public int getY() { return y; }
	public void setY(int i) { y = i; }
	
	public String getSpriteName() { return spriteName; }
	
	public void setSpriteName(String string) {
		spriteName = string;
		BufferedImage image = spriteCache.getSprite(spriteName);
		wys = image.getHeight();
		szer = image.getWidth();
	}
	
	public int getHeight() { return wys; }
	public int getWidth() { return szer; }
	public void setHeight(int i) {wys = i; }
	public void setWidth(int i) { szer = i; }
	
	public void act() { }
	
}
