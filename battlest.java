import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class battlest {
	public ArrayList<Enemy> arrenemy;
	public ArrayList<Player> arrplayer;
	public drawbmap maps;
	public boolean[][] batmap;
	public boolean round;
	public battlest(String mapname,boolean[][] batmap,ArrayList<Enemy> arrenemy,ArrayList<Player> arrplayer) throws IOException{
		round=true;
		maps=new drawbmap(mapname);
		this.batmap=batmap;
		this.arrenemy=arrenemy;
		this.arrplayer=arrplayer;
	}
	public void Judge(){
		if(arrenemy.size()<=0)
			System.out.println("player win");
		if(arrplayer.size()<=0)
			System.out.println("You lose");
	}
}
