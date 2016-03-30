package shootingstar;

/**
 *
 * @author Agnieszka Makowska https://github.com/Migemiley
 */

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class SpriteCache {
	public HashMap sprites;
	
	public SpriteCache() {
		sprites = new HashMap();
	}
	
	private BufferedImage loadImage(String sciez) {
		URL url = null;
		try {
			url = getClass().getClassLoader().getResource(sciez);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("Przy otwieraniu " + sciez + " jako " + url);
			System.out.println("Blad - "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	public BufferedImage getSprite(String sciez){
		BufferedImage img = (BufferedImage)sprites.get(sciez);
		if (img == null){
			img = loadImage("img/"+sciez);
			sprites.put(sciez, img);
		}
		return img;
	}
	
}
