import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class drawbmap {
	private BufferedImage img;
	public drawbmap(String name) throws IOException{
		img = ImageIO.read(new File(name));
	}
	public void draw(Graphics g){
		//g.drawImage(img, x, y, null);
		g.drawImage(img, 0, 0,800,800, null);
	}
}
