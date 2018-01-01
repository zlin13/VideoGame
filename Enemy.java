import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Enemy extends Character {
	public int speed;
	public int showtime;
	boolean fr;
	battlest battle;
	Player pl;
	int save;
	int num;
	int itemnum;
	boolean atked = false;
	boolean over = false;
	int equipnum;
	Image imgrun ;
	public Enemy(String name, int range,int atk,int def,int speed,int hp,String path,int x,int y,int itemnum,int equipnum) throws IOException{
		super(name,range,atk,def,speed,hp,path,x,y);
		save = range;
		fr = true;
		this.itemnum = itemnum;
		this.equipnum = equipnum;
		showtime=1000000;
		File f1 = new File("frame-blue.png");
		imgrun = ImageIO.read(f1);
	}

	//  enemy move on the map
	public void Move() throws IOException{
		
		int dist = 1200;
		pl=battle.arrplayer.get(0);
		for(Player p:battle.arrplayer){
			int temp = (int) Math.sqrt((p.posix-posix)*(p.posix-posix)+(p.posiy-posiy)*(p.posiy-posiy));
			if(temp<dist){
				dist = temp;
				pl = p;
			}
		}
		if(  (posix-50==pl.posix&&(posiy>=pl.posiy-50&&posiy<=pl.posiy+50))   ||  (posix+50==pl.posix&&(posiy>=pl.posiy-50&&posiy<=pl.posiy+50))  
				||  (posix==pl.posix&&(posiy==pl.posiy-50 ||posiy==pl.posiy+50)))
			return;
		System.out.println(pl.posix+"  "+pl.posiy);
		System.out.println(posix+" "+posiy);
		if(Math.abs(posix-pl.posix)>=Math.abs(posiy-pl.posiy)){
			if(posix>pl.posix){
				if(posix/50-1>=0&&battle.batmap[posix/50-1][posiy/50])
					posix-=50;
				else {
					if(posiy/50-1>=0&&posiy>pl.posiy&&battle.batmap[posix/50][posiy/50-1])
						posiy-=50;
					else if(posiy/50+1<16&&battle.batmap[posix/50][posiy/50+1])
						posiy+=50;
					else if(posiy/50-1>=0&&battle.batmap[posix/50][posiy/50-1])
						posiy-=50;
					else{
						range=0;
						battle.batmap[posix/50][posiy/50]=false;
						return;
					}

				}
			}

			else if(posix/50+1<16&&battle.batmap[posix/50+1][posiy/50])
				posix+=50;
		}
		else{
			if(posiy>pl.posiy){
				if(posiy/50-1>=0&&battle.batmap[posix/50][posiy/50-1])
					posiy-=50;
				else{
					if(posix/50-1>=0&&posix>pl.posix&&battle.batmap[posix/50-1][posiy/50])
						posix-=50;
					else if(posix/50+1<16&&battle.batmap[posix/50+1][posiy/50])
						posix+=50;
					else if(posix/50-1>=0&&battle.batmap[posix/50-1][posiy/50])
						posix-=50;
					else{
						range=0;
						battle.batmap[posix/50][posiy/50]=false;
						return;
					}

				}
			}
			else if(battle.batmap[posix/50][posiy/50+1]&&posiy/50+1<16)
				posiy+=50;
		}

	}
	public void load(battlest battle){
		this.battle =  battle;
	}
	public void attack(Graphics g) throws IOException{// check if it is enable to fight
		if((int) Math.abs(posix-pl.posix)<=50&&(int) Math.abs(posiy-pl.posiy)<=50&&range!=0){
			if(!atked){
			if(atk<=pl.def){
				pl.hp--;
				atked = true;
			}
			else
				pl.hp-=atk-pl.def;
				atked = true;
			}
			
			battle.batmap[posix/50][posiy/50] = false;
			if(showtime!=0){
			g.drawImage(imgrun, posix, posiy, 50, 50, null);
			g.drawImage(img, posix, posiy, 50, 50, null);
			atk(g);
			showtime--;
			}
			if(showtime==0){
				range=0;
				showtime=1000;
			}
			
		}
	}
	public void start(){
			range = save;
			atked = !atked;

	}
	public void atk(Graphics g) throws IOException{
		File f = new File("atk.png");
		Image atk = ImageIO.read(f);
//		for(int i=0;i<100000;i++){
			g.drawImage(atk, pl.posix,pl.posiy,50,50, null);
		}
	public boolean isDead(){
		if(hp<=0)
			return true;
		return false;
	}
	/*
	 * 
	 */
	public void draw(Graphics g) throws IOException{
		if(isDead()){
			range=0;
			if(posix>0&&posiy>0)
			battle.batmap[posix/50][posiy/50] = true;
			posix=-1000;posiy=-1000;
			return;
		}
		
		if(!battle.round&&fr){
			g.drawImage(img, posix, posiy, 50, 50, null);
			fr = false;
			return;
		}
		
	
		else if(battle.round){
			if(hp>0)
				g.drawImage(img, posix, posiy, 50, 50, null);
			return;
		}
		


		else if(!battle.round&&!fr){
			if(over){
						battle.round = !battle.round;
					for(Player p:battle.arrplayer)
						p.start();
						over = false;
						Textdialog text = new Textdialog("Players Turn!");
						return;
			}
				if(battle.arrenemy.indexOf(this)!=0){
					
					for(Enemy e:battle.arrenemy){
						if(e.equals(this))
							num=battle.arrenemy.indexOf(e)-1;
						}
					
						if(range==0||battle.arrenemy.get(num).range!=0){
							g.drawImage(img, posix, posiy, 50, 50, null);
							battle.batmap[posix/50][posiy/50] = false;
							speed = 20;
							return;
						}
				}
				else if(range==0&&battle.arrenemy.indexOf(this)==0){
					g.drawImage(img,posix,posiy,50,50,null);
					battle.batmap[posix/50][posiy/50] = false;
					return;
				}
			if(range>0){
				if(speed<=0){
				battle.batmap[posix/50][posiy/50] = true;
				Move();
				range--;
				speed = 20;
				}
				speed--;
				g.drawImage(imgrun, posix,posiy, 50, 50, null);
				g.drawImage(img, posix, posiy, 50, 50, null);
			}
			if(pl!=null){
				attack(g);
			}
			
			for(Enemy e:battle.arrenemy){
					if(e.range!=0)
						return;
					if(battle.arrenemy.get(battle.arrenemy.size()-1).equals(e)&&e.range==0){
						over = true;
						return;
					}
			}

		}
		
	}
}

