import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class BattleMap {
	final static int PLAIN=0;										//predefine all kind of cell
	final static int MOUNTION=1;
	final static int FOREST=2;
	final static int RIVER=3;
	private Cell[][] Map;											
	public class Cell{
		public int x,y;
		public int type;
		Cell(int x,int y,int type){
			this.x=x;
			this.y=y;
			this.type=type;
		}
		public String getType(){
			switch(type){
			case 0:
				return "PLAIN";
			case 1:
				return "MOUNTION";
			case 2:
				return "FOREST";
			case 3:
				return "RIVER";
			default:
				return "UNKNOWN";
			}
		}
	}
	public BattleMap(String MapPath) throws FileNotFoundException{
		File mapfile=new File(MapPath);                            // load map file
		Scanner sc=new Scanner(mapfile);					       // use scanner to read mapfile 
		/* load map */
		
		
	}
	public boolean accessAble(int x,int y){
		/*test weather the cell is accessAble*/
		return true;												// if access return true;
	}
	public int moveCost(Cell nextMoveClee){
		int cost = 0;
		return cost;
	}
	public void draw(){
		
	}
	public void displayMoveArea(){							//to display which area the player can move
		
	}
	public boolean changeCell(int type){							// this function is used to change a cell 
		return true;
	}
	public boolean refreshCell(int x,int y){
		return true;
	}
}
