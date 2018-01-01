import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class drawplayer {
	public int dx,dy, x, y;
	private BufferedImage img;
	public boolean[][] move;
	public drawplayer(String name,int x,int y,boolean[][] move) throws IOException{
		 img = ImageIO.read(new File(name));
		 this.x=x;
		 this.y=y;
		 this.move=move;
	}
	public void draw(Graphics g){
		if(ismoveable())
			move();
		g.drawImage(img, x, y, 50, 50, null);
	}
	public void move(){
		x+=dx;
		y+=dy;
	}
	public boolean ismoveable(){
		if(x+dx>0&&y+dy>0&&x+dx+50<800&&y+dy+50<800&&move[(x+dy)/50][(y+dy)/50])
			return true;
		return false;
	}
	public void setX(int dx){
		this.dx=dx;
	}
	public void setY(int dy){
		this.dy=dy;
	}
}
