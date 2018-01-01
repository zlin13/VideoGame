import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class drawarea extends JPanel{
	public int x,y;
	public int speed=5;
	public drawmap bigmap;
	public drawplayer bp;                    //bigmapplayer
	public Graphics g,gg;
	public boolean gamestart;
	public Character pl,enmy;
	public battlest batt1;
	public boolean gamestatus;
	public Image buffer;
	public int click=0;
	public Player pgd=null;
	//public show selt;
	public showframe seltf;
	public boolean sta,showrange;
	public ArrayList<show> attrange,selt;
	public Enemy tmpen;
	public menu me;
	public drawarea(){
		setFocusable(true);
		me=new menu();
		me.menubar();
		//this.g=g;
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int clk=e.getButton();
				if(!gamestart){
						try {
							gamestart=true;
							buffer=createImage(800, 800);
							gg=buffer.getGraphics();
							g =getGraphics();
							bigmap=new drawmap("mainmap.txt");
							bp=new drawplayer("hero.png", 100, 50,bigmap.movebale);
							bigmap.draw(gg);
							bp.draw(gg);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					gamestart=true;
				}else{
					if(gamestatus){
							if(click==0){
								for(Player pg:batt1.arrplayer){
									if(pg.posix/50==e.getX()/50&&pg.posiy/50==e.getY()/50){
										if(clk==MouseEvent.BUTTON1&&batt1.round&&pg.speed!=0){
											pgd=pg;
											click=1;
											try {
												selt=pgd.getMoveRange();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
										if(clk==MouseEvent.BUTTON3){
											seltf=new showframe(pg);
											//me.stateTf.setText("Name:"+pg.name+"\n"+"HP:"+pg.hp+"\n"+"Attack:"+pg.atk+"\n"+"Defence:"+pg.def);
											if(sta){
												seltf=null;
											}
											sta=!sta;
										}
									}
								}
							}else if(click==1&&batt1.round&&attrange==null&&selt!=null){
								for(show s:selt){
									if(e.getX()/50*50==s.x&&e.getY()/50*50==s.y){
										if(pgd!=null){
											pgd.setX(e.getX());
											pgd.setY(e.getY());
											selt=null;
										}
										click=0;
									}
								}
							}
							if(pgd!=null&&batt1.round&&pgd.attack&&!pgd.attacked){
								for(Enemy en:batt1.arrenemy){
									if(en.posix/50==e.getX()/50&&en.posiy/50==e.getY()/50){
										tmpen=en;
									}
								}
								if(tmpen!=null&&pgd.attabkable(tmpen.posix, tmpen.posiy)){
									try {
										pgd.attack(tmpen);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									tmpen=null;
									showrange=false;
									pgd.attack=false;
									pgd.attacked=true;
									attrange=null;
								}
							}
					}else{
						
					}
				}
			}
			
		});
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyCode());
				//System.out.println("sdfsd");
				if(gamestatus){
					if(pgd!=null&&!pgd.attacked&&batt1.round){
						//;
						//if(key==KeyEvent.VK_A)
						//System.out.println("atttt "+e.getKeyText(e.getKeyCode()));
						if(e.getKeyChar()=='a'&&!pgd.attack){
							pgd.attack=true;
							showrange=true;
							try {
								attrange=pgd.getAtkRange();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//attrange=new ArrayList<>();
							System.out.println("atttt");
						}else{
							showrange=false;
							pgd.attack=false;
							attrange=null;
						}
					}
					if(e.getKeyChar()=='r'){
						batt1.round=false;
						Textdialog text = new Textdialog("Enemy Turn!");
						for(Enemy enm: batt1.arrenemy)
						{
							enm.start();
						}
						
					}
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyCode());
				//System.out.println("sdfsd");
				if(!gamestatus&&bp!=null){
					bp.setX(0);
					bp.setY(0);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyCode());
				//System.out.println("sdfsd");
				if(!gamestatus&&bp!=null){
					int key=e.getKeyCode();
					if(key == KeyEvent.VK_UP){
						System.out.println("up");
					//y-=speed;
						bp.setY(-1);
					}
					if(key == KeyEvent.VK_DOWN){
						System.out.println("down");
					//y+=speed;
						bp.setY(1);
					}
					if(key == KeyEvent.VK_LEFT){
						System.out.println("left");
					//x-=speed;
						bp.setX(-1);
					}
					if(key == KeyEvent.VK_RIGHT){
						System.out.println("right");
					//x+=speed;
						bp.setX(1);
					}
				}
				//a.draw(g, x, y);
			}
		});
	}
}
