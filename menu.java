import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class menu extends JFrame {
		Player player;
		JTextArea stateTf;
		public battlest batt1;
    /**
     * when use mouse to click on player
     * JTextArea will append the state of this player
     */
	public menu(){
		
	}
	public menu(Player player){
		this.player=player;
	}
	public void getbatt(battlest batt1){
		this.batt1=batt1;
	}
    public void menubar() {

        JFrame jFrame = new JFrame("Battle Menu");
        stateTf = new JTextArea(5,15);
        Font f=new Font("Default", Font.BOLD, 30);
        stateTf.setFont(f);
        JPanel menuPanel = new JPanel();
        JPanel statePanel = new JPanel();
        stateTf.setEditable(false);

        JButton attack = new JButton("ATTACK");
        JButton skill = new JButton("SKILL");
        JButton item = new JButton("ITEM");
        JButton equipment = new JButton("EQUIPMENT");
        JButton save= new JButton("SAVE");
        JButton wait = new JButton("WAIT"); // Stop this turn directly

        statePanel.add(stateTf);
        menuPanel.setLayout(new GridLayout(3, 2));

        menuPanel.add(attack);
        menuPanel.add(skill);
        menuPanel.add(item);
        menuPanel.add(equipment);
        menuPanel.add(save);
        menuPanel.add(wait);

        jFrame.add(statePanel, BorderLayout.WEST);
        jFrame.add(menuPanel, BorderLayout.EAST);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);


        attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("ATTACK")) {
                	
                }
            }
        });

        skill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("SKILL")) {

                }
            }
        });

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("ITEM")) {
                	 JFrame attackFrame = new JFrame("Please Choose item");
                     JPanel attackPanel = new JPanel(new GridLayout(2,3));
                     JButton itemButton1 = new JButton(player.collection.get(0).name+player.collection.get(0).number);
                     JButton itemButton2 = new JButton(player.collection.get(1).name+player.collection.get(1).number);
                     JButton itemButton3 = new JButton(player.collection.get(2).name+player.collection.get(2).number);
                     JButton itemButton4 = new JButton(player.collection.get(3).name+player.collection.get(3).number);
                     JButton itemButton5 = new JButton(player.collection.get(4).name+player.collection.get(4).number);
                     JButton itemButton6 = new JButton(player.collection.get(5).name+player.collection.get(5).number);
                     JButton itemButton7 = new JButton(player.collection.get(6).name+player.collection.get(6).number);
                     attackPanel.add(itemButton1);
                     attackPanel.add(itemButton2);
                     attackPanel.add(itemButton3);
                     attackPanel.add(itemButton4);
                     attackPanel.add(itemButton5);
                     attackPanel.add(itemButton6);
                     attackPanel.add(itemButton7);

                     attackFrame.add(attackPanel);
                     attackFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                     attackFrame.pack();
                     attackFrame.setVisible(true);
                     itemButton1.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {

                             stateTf.append("HP+10 MP+10" + "\n");
                             attackFrame.dispose();
                         }
                     });
                     itemButton2.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {

                             stateTf.append("HP+10 MP+10" + "\n");
                             attackFrame.dispose();
                         }
                     });
                     itemButton3.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {

                             stateTf.append("HP+10 MP+10" + "\n");
                             attackFrame.dispose();
                         }
                     });
                     itemButton4.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {

                             stateTf.append("HP+10 MP+10" + "\n");
                             attackFrame.dispose();
                         }
                     });
                     itemButton5.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             stateTf.append("HP+10 MP+10" + "\n");
                             attackFrame.dispose();
                         }
                     });
                     itemButton6.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             stateTf.append("HP+10 MP+10" + "\n");
                             attackFrame.dispose();
                         }
                     });
                     itemButton7.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             stateTf.append("HP+10 MP+10" + "\n");
                             attackFrame.dispose();
                         }
                     });
                    
                }
            }
        });
        equipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("ITEM")) {
                	 JFrame attackFrame = new JFrame("Please Choose item");
                     JPanel attackPanel = new JPanel(new GridLayout(2,3));
                     JButton itemButton1 = new JButton(player.equips.get(0).name+player.collection.get(0).number);
                     JButton itemButton2 = new JButton(player.equips.get(1).name+player.collection.get(1).number);
                     JButton itemButton3 = new JButton(player.equips.get(2).name+player.collection.get(2).number);
                     JButton itemButton4 = new JButton(player.equips.get(3).name+player.collection.get(3).number);
                     JButton itemButton5 = new JButton(player.equips.get(4).name+player.collection.get(4).number);
                     JButton itemButton6 = new JButton(player.equips.get(5).name+player.collection.get(5).number);
                     JButton itemButton7 = new JButton(player.equips.get(6).name+player.collection.get(6).number);
                     attackPanel.add(itemButton1);
                     attackPanel.add(itemButton2);
                     attackPanel.add(itemButton3);
                     attackPanel.add(itemButton4);
                     attackPanel.add(itemButton5);
                     attackPanel.add(itemButton6);
                     attackPanel.add(itemButton7);
                     
                     attackFrame.add(attackPanel);
                     attackFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                     attackFrame.pack();
                     attackFrame.setVisible(true);
                }
            }
        });
        wait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("WAIT")) {
  
                	batt1.round=false;
					Textdialog text = new Textdialog("Enemy Turn!");
					for(Enemy enm: batt1.arrenemy)
					{
						enm.start();
					}
                }
            }
        });
    }


//    public static void main(String[] args) {
//        //new menu().menubar();
//    }
}
