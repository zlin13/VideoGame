import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Delayed;

import javax.imageio.ImageIO;
import javax.swing.*;

public class app extends JFrame{
	public Thread th;
	public drawarea dra;
	public Graphics g;
	public boolean batt1,batt2,batt3;
	//public static boolean[][] moveablemap;
	public app(String name) throws IOException{
		super(name);
		setSize(800,825);
		
		setResizable(false);
		Container c=getContentPane();
		dra=new drawarea();
		System.setProperty("sun.awt.noerasebackground","true");
		th = new Thread() {
			public void run() {
				while(true){
					try {
						sleep(5);
						if(!dra.gamestatus){
							if(dra.g!=null&&dra.bp!=null){
								dra.bigmap.draw(dra.gg);
								dra.bp.draw(dra.gg);
								dra.g.drawImage(dra.buffer, 0, 0, null);
								if(dra.bp.x>100&&dra.bp.y>100&&!batt1){
									dra.gamestatus=true;
									set("bat1.txt");
									batt1=true;
									dra.me.getbatt(dra.batt1);
									dra.bp.dx=dra.bp.dy=0;
								}
								if(dra.bp.x>300&&dra.bp.y>300&&!batt2){
									dra.gamestatus=true;
									set("bat2.txt");
									batt2=true;
									dra.me.getbatt(dra.batt1);
									dra.bp.dx=dra.bp.dy=0;
								}
							}
							//System.out.println(1);
						}else{
							if(dra.g!=null&&dra.pl!=null){
								dra.batt1.maps.draw(dra.gg);
								for(Player p : dra.batt1.arrplayer){
									p.draw(dra.gg);
								}
								for(Enemy en : dra.batt1.arrenemy){
									en.draw(dra.gg);
								}
								if(dra.selt!=null&&!dra.showrange){
									for(show s:dra.selt){
										s.draw(dra.gg);
									}
								}
								if(dra.seltf!=null){
									//dra.seltf.draw(dra.gg);
									dra.me.stateTf.setText("Name:"+dra.pgd.name+"\n"+"HP:"+dra.pgd.hp+"\n"+"Attack:"+dra.pgd.atk+"\n"+"Defence:"+dra.pgd.def);
									
								}
								if(dra.attrange!=null){
									for(show s:dra.attrange){
										s.draw(dra.gg);
									}
								}
								dra.g.drawImage(dra.buffer, 0, 0, null);
								
							}
							if(dra.batt1.arrenemy!=null){
								int c=0;
								for(Enemy en: dra.batt1.arrenemy){
									if(en.isDead()){
										c++;
									}
								}
								if(c==dra.batt1.arrenemy.size()){
									Textdialog text = new Textdialog("Player Win!!!");
									dra.me.stateTf.setText("");
									dra.gamestatus=false;
								}
							}
							if(dra.batt1.arrplayer!=null){
								int c=0;
								for(Player pl: dra.batt1.arrplayer){
									if(pl.hp<0){
										c++;
									}
								}
								if(c==dra.batt1.arrplayer.size()){
									Textdialog text = new Textdialog("You lose");
									System.exit(0);
								}
							}
							sleep(10);
							//System.out.println(2);
						}
						System.out.println("run");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				 }
			}
			};
		setVisible(true);
		c.add(dra);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void set(String path) throws IOException{
		
		
		dra.pl=new Player("zhangxi","hero.png",1,100,100,5,200,200,700);
		Character pl2=new Player("ysl","hero2.png",1,5,2,3,100,400,700);
		ArrayList<Player> arrp=new ArrayList<>();
		arrp.add((Player) dra.pl);
		arrp.add((Player) pl2);
		dra.batt1=setbat(arrp,path);
		for(Player p : dra.batt1.arrplayer){
			p.load(dra.batt1);
		}
		for(Enemy p : dra.batt1.arrenemy){
			p.load(dra.batt1);
		}
	}
	public battlest setbat(ArrayList<Player> arrp,String paths) throws IOException{
		File file=new File(paths);
		Scanner sc=new Scanner(file);
		ArrayList<Enemy> arre=new ArrayList<>();
		int n=Integer.parseInt(sc.next());
		for(int i=0;i<n;i++){
			String name=sc.next();
			int range=Integer.parseInt(sc.next());
			int atk=Integer.parseInt(sc.next());
			int def=Integer.parseInt(sc.next());
			int speed=Integer.parseInt(sc.next());
			int hp=Integer.parseInt(sc.next());
			String path=sc.next();
			int x=Integer.parseInt(sc.next());
			int y=Integer.parseInt(sc.next());
			int e=Integer.parseInt(sc.next());
			int it=Integer.parseInt(sc.next());
			Enemy emy=new Enemy( name,  range, atk, def, speed, hp, path, x, y,e,it);
			arre.add(emy);
		}
		boolean[][] batmap=new boolean[16][16];
		for(int i=0;i<16;i++){
			for(int j=0;j<16;j++){
				if(Integer.parseInt(sc.next())==1){
					batmap[j][i]=false;
				}else{
					batmap[j][i]=true;
				}
			}
		}
		String mapname=sc.next();
		battlest result=new battlest(mapname, batmap, arre, arrp);
		return result;
	}
	public void paint(Graphics gs){

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("WELCOME.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gs.drawImage(img, 0, 0,800,800, null);		
		th.start();
		
	}
	public static void main(String[] args) throws IOException{
		app a=new app("sd");
		
	}
}
