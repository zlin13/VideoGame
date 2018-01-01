import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class drawmap {
	private BufferedImage img;
	public boolean[][] movebale;
	public drawmap(String name) throws IOException{
		File file=new File(name);
		Scanner sc=new Scanner(file);
		movebale=new boolean[16][16];
		img = ImageIO.read(new File(sc.next()));
		for(int i=0;i<16;i++){
			for(int j=0;j<16;j++){
				if(Integer.parseInt(sc.next())==1){
					movebale[j][i]=false;
				}else{
					movebale[j][i]=true;
				}
			}
		}
		
	}
	public void draw(Graphics g){
		//g.drawImage(img, x, y, null);
		g.drawImage(img, 0, 0,800,800, null);
	}
}
