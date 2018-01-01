import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class show {
	private BufferedImage img;
	int x;
	int y;
	public show(String name,int x,int y) throws IOException{
		 img = ImageIO.read(new File(name));
		 this.x=x;
		 this.y=y;
	}
	public void draw(Graphics g){
		g.drawImage(img, x, y,50,50, null);
	}
}
