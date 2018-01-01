import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class showframe extends JPanel {
	  public Player player;
		public showframe(Player p){
		  this.player=p;
		}
		public void draw(Graphics g){
			g.setColor(Color.BLACK);
			Font f=new Font("Default",Font.PLAIN,28);
			//Font ff=new F
			g.setFont(f);
			g.drawString("HP:"+player.hp, player.posix+50, player.posiy+20);
			g.drawString("Name:"+player.name, player.posix+50, player.posiy+40);
			g.drawString("Attack:"+player.atk, player.posix+50, player.posiy+60);
			g.drawString("Defence:"+player.def, player.posix+50, player.posiy+80);
		}
	}
