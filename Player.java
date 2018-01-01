public class Player extends Character{
    final int mpp = 1000;//the maximum mp
    final int hpp = 1000;//the maximum hp
    protected int[] step;
    public ArrayList<Item> collection;
    public ArrayList<Skill> skills;
    public ArrayList<Equipment> equips;
    private battlest battle;
	protected boolean attack;
	protected boolean attacked;
    protected boolean hasAttacked;
    public BufferedImage atkimg;
    public int ax,ay;
    public int speeded;
    public int atktime;
    //Initialize the Player
    public Player(String name,String path, int range,int atk,int def,int speed,int hp,int x,int y)throws IOException{
       // super(name, range, x, y);
        super( name, range,atk,def,speed, hp,path, x, y);
        step = new int[2];
        step[0]=x;
        step[1]=y;
        speeded=speed;
        skills = new ArrayList<>();
        collection = new ArrayList<>();
        equips = new ArrayList<>();
    }
    public void start(){
    	speed=speeded;
    	attack=false;
    	attacked=false;
    }

    final public int getMmp(){
        return mpp;
    }
    final public int getHpp(){
        return hpp;
    }

    public int getHp(){
        return super.hp;
    }
    public void setHp(int h){
        super.hp += h;
    }
    public int getSpeed(){
        return super.speed;
    }
    public void setSpeed(int s){
        super.speed +=s;
    }
    public int getAtk(){
        return super.atk;
    }
    public void setAtk(int a){
        super.atk +=a;
    }
    public int getDef(){
        return super.def;
    }
    public void setDef(int d){
        super.def +=d;
    }
    public void setX(int dx){
    	step[0]=dx;
    }
    public void setY(int dy){
    	step[1]=dy;
    }

    //get Equiptment
    public void Equipment(Equipment e){
        equips.add(e);
    }
    //operation of the skills
    public void getSkills(Skill skill){
        skills.add(skill);
    }
    public boolean throwSkills(int i){
        if(skills.remove(i)!= null)
            return true;
        return false;
    }
    //operation of the item
    public void getItem(Item item){
        collection.add(item);
    }
    public boolean throwItem(int i){
        if(collection.remove(i)!=null)
            return true;
        return false;
    }
    public void load(battlest battle){
    	this.battle=battle;
    }
    //Normal
    public boolean ismoveable(int x,int y){
		if(battle.batmap[x/50][y/50])
			return true;
		return false;
	}
    protected void move(int x, int y){
    	if(ismoveable(x, y)){
    		battle.batmap[posix/50][posiy/50]=true;
            posix = (x/50)*50;
            posiy = (y/50)*50;
            battle.batmap[posix/50][posiy/50]=false;
    	}
    }

    public void attack(Enemy e) throws IOException{
    	if(atk-e.def<0){
    		e.hp-=2;
    	}else{
    		e.hp = e.hp-(atk - e.def);
    	}
    	File tmp=new File("frame-red.png");
        atkimg= ImageIO.read(tmp);
        ax=e.posix;
        ay=e.posiy;
        atktime=50;
    }

    public boolean attabkable(int x, int y){
        if(x == posix && y == posiy)
            return false;
        if(Math.abs(posix-x)<=50 && Math.abs(y-posiy)<=50)
            return true;
        return false;
    }

    //Get the attack range
    public ArrayList<show> getAtkRange()throws Exception{
        int x = posix;
        int y = posiy;
        ArrayList<show> range = new ArrayList<show>();
        range.add(new show("frame-blue.png",x-50,y-50));
        range.add(new show("frame-blue.png",x-50,y));
        range.add(new show("frame-blue.png",x-50,y+50));
        range.add(new show("frame-blue.png",x,y-50));
        range.add(new show("frame-blue.png",x,y+50));
        range.add(new show("frame-blue.png",x+50,y-50));
        range.add(new show("frame-blue.png",x+50,y+50));
        range.add(new show("frame-blue.png",x+50,y));
        return range;
    }

    public ArrayList<show> getMoveRange() throws IOException{
    	int x = posix;
        int y = posiy;
        ArrayList<show> range = new ArrayList<show>();
        for(int i = Math.max(0,x-speed*50); i<=Math.min(750,x+speed*50); i+=50){
            for(int j = Math.max(0,y-speed*50); j<=Math.min(750,y+speed*50);j+=50){
                if(i == x && j == y)
                    continue;
               if(ismoveable(i,j))
                range.add(new show("frame-yellow.png",i,j));
            }
        }
        speed=0;
        return range;
    }
    public void draw(Graphics g)throws IOException{
    	if(hp<0){
    		posix=-2000;
    		posiy=-2000;
    		return;
    	}
        move(step[0],step[1]);
        if(atktime>0){
        	g.drawImage(atkimg, ax,ay,50,50,null);
        	atktime--;
        }
        g.drawImage(super.img, super.posix,super.posiy, 50,50,null);
    }
}

