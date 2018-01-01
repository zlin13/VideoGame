import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Character {
    /*
     * Below are the basic elements of a character including player and enemy.
     */
    // The position of the character
    int  posix;
    int posiy;


    //Define the common Characteristics of the characters
    String name;
    BufferedImage img;
    int status; //the statue of the character : normal-0 / numb-1 / rest-2 /...
    int range; // the monsters' available attack range
    int atk; //the monsters' attack value
    int def;
    int speed; //how fast the character move on the map
    int hp;
    int mp;
    int exp; //accumulate experiences
    //Skill skill;
    //Equip equip;


    public Character(){

    }       
/*
* 	we need to add some initial values of a player which need to be discussed later.
*
*
*/
    public Character(String name,int range,int atk,int def,int speed, int hp,String path,int x,int y) throws IOException{   //  this constructor is used for enemy
        this.name = name;
        this.range = range;
        this.atk = atk;
        this.def = def;
        this.speed = speed;
        this.hp = hp;
        File tmp=new File(path);
        img= ImageIO.read(tmp);
        posix = x;
        posiy = y;
    }

    public void setX(int a){};
    public void setY(int a){};
    
    //Get the current position of the Character
    public int[] getCurrentPostion(){
        return new int[]{posix,posiy};
    }


    //Check the status of the character
    public void cheakStatus(){
        if(hp<=0)
            status = -1;//The character is dead
        else if(hp<20)
            status = 0;//The character is on the edge of death and can use a cure if he or she has it
        else
            status = 1;//Health
    }
    public abstract void draw(Graphics g)throws IOException ;
}
