import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
//This is extra function.I didn't make it useful yet.
public class Equipment {
       String name;
       String definition;
       int serialNumber;
       int atk;
       int def;
       int speed;
       boolean a;
       
       public Equipment(String name,int atk,int def,int speed,String definition,boolean a){
          this.name=name;
          this.atk=atk;
          this.def=def;
          this.speed=speed;
          this.definition=definition;
          a=true;
       }
       
       public void useEquipment(Player player,int i){
    	   if(a=false)
    	   {
    	   player.atk=player.atk-player.equips.get(i).atk;
           player.def=player.def-player.equips.get(i).def;
           player.speed=player.speed-player.equips.get(i).speed;
           a=true;
    	   }else{
    	  player.atk=player.atk+player.equips.get(i).atk;
          player.def=player.def+player.equips.get(i).def;
          player.speed=player.speed+player.equips.get(i).speed;
          a=false;
       }
       }
       
       public void equipmentParticular(Player player,int serialNumber){
           try{
                BufferedReader input;
                FileReader reader=null;
                reader = new FileReader("Equipment.txt");
                input=new BufferedReader(reader);
                for(int i=1;i<serialNumber;i++)
                	input.readLine();
                StringTokenizer intro = new StringTokenizer(input.readLine(),"/");
                intro.nextToken();
                name = intro.nextToken();
                atk = Integer.parseInt(intro.nextToken());
                def = Integer.parseInt(intro.nextToken());
                speed = Integer.parseInt(intro.nextToken());
                definition = intro.nextToken();
                Equipment e=new Equipment(name,atk,def,speed,definition,a);
                player.equips.add(e);
                //reader.close();
                input.close(); 
                 }catch (FileNotFoundException ex) {
                 }catch (IOException ex) {}
                 this.serialNumber = serialNumber ;
   }

}
