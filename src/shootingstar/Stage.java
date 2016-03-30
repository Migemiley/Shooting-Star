package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */

import java.awt.image.ImageObserver;

public interface Stage extends ImageObserver {
	public static final int szer = 800;
	public static final int wys = 600;
	public static final int szyb = 60;
	public SpriteCache getSpriteCache();
}
