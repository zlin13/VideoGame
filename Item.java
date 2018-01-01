package rpgproject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
//This is an extra function. I didn't add it yet.

public class Item {

    String name ;
    String definition;
    int hp;
    int mp;
    int serialNumber;
    int number;
    public Item(){
        
    }
    public Item(String name,int hp,int mp,String definition,int number){
        this.name=name;
        this.hp=hp;
        this.mp=mp;
        this.definition=definition;
        this.number=number;
     }
  
    public void getItem(Player player,int serialNumber){
           try{
        	 
                BufferedReader input;
                FileReader reader=null;
                reader = new FileReader("Item.txt");
                input=new BufferedReader(reader);
                for(int i=1;i<serialNumber;i++)
                	input.readLine();
                StringTokenizer intro = new StringTokenizer(input.readLine(),"/");
                intro.nextToken();
                name = intro.nextToken();
                hp = Integer.parseInt(intro.nextToken());
                mp = Integer.parseInt(intro.nextToken());
                number += Integer.parseInt(intro.nextToken());
                definition = intro.nextToken();
                Item it=new Item(name,hp,mp,definition,number);
                player.collection.add(it);
                //reader.close();
                input.close(); 
                 }catch (FileNotFoundException ex) {
                 }catch (IOException ex) {}
           this.serialNumber = serialNumber ;
     
   }
    
    public void useItem(Player player,int i){
        if(player.hp<=0){
   //       new Textdialog("You can't use items as you already die");        
            return;
        }
        player.collection.get(i).number=player.collection.get(i).number-1;
        player.hp += player.collection.get(i).hp;
        if(player.hpp < player.hp)
        	player.hp = player.hpp;
        player.mp += player.collection.get(i).mp;
        if(player.mpp < player.mp)
        	player.mp = player.mpp;
        if(player.hp < 0)
        	player.hp = 0;
        if(player.mp < 0)
        	player.mp = 0;
    }
   
       
}
    
    
    
    


