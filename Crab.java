import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
/**
 * This class defines a crab. Crabs live on the beach. 
 * They like to eat sand worms, but must beware of lobsters. 
 */
public class Crab extends Animal
{   
    /**
     * constructor initializes state (data) for a new crab object
     */
    private final Color BLACK =new Color(0,0,0);
    private final Color WHITE =new Color(255,255,255);
    private final Color RED =new Color(255,0,0);
    private final Color GREEN =new Color(0,255,0);
    private final Color BLUE =new Color(0,0,255);
    Color c =new Color(40,40,40);
    private GreenfootImage image1 = new GreenfootImage("actor2.png");
    private GreenfootImage image2 = new GreenfootImage("actor2.png");
    private GreenfootImage background1 = new GreenfootImage("maze27.jpg");
    private GreenfootImage background2 = new GreenfootImage("maze27.jpg");
    private int speed = 3;
    private int mouseOfSetX = 0;
    private int mouseOfSetY = 0;
    public Crab( ) 
    {
        // nothing to do yet.

        setImage(image1);
    }

    /**
     * act method provides the main behavior for a crab.
     */
    public void act()
    {
        // add crab behavior here, such as move( )
Edge();
        item();
        moveWithMouse();
        moveWithKeyboard();
        

    }

    public void moveWithMouse(){
        if (Greenfoot.getMouseInfo() ==null) return;
        int x =Greenfoot.getMouseInfo().getX()-mouseOfSetX;
        int y =Greenfoot.getMouseInfo().getY()-mouseOfSetY;
        //if(x==turn)
        turnTowards(x,y); 
        move(speed);
        //((CrabWorld)getWorld()).moveBackground(getX(),getY());

    }

    public void item(){
        int value = 8;
        int xMin =this.getX()-value;
        int yMin =this.getY()-value;
        int xMax =this.getX()+value;
        int yMax =this.getY()+value;
        
        if (xMin < 0 || xMax >= getWorld().getWidth()-2||
        yMin<0||yMax >= getWorld().getHeight()-2
        )
        {return;}
        if(getWorld().getColorAt(xMax,yMax).equals(BLACK)||
        getWorld().getColorAt(xMin,yMin).equals(BLACK)||
        getWorld().getColorAt(xMin,yMax).equals(BLACK)||
        getWorld().getColorAt(xMax,yMin).equals(BLACK)

        ){

            setLocation(50,50);
        }
        if(getWorld().getColorAt(xMax,yMax).equals(RED)||
        getWorld().getColorAt(xMin,yMin).equals(RED)||
        getWorld().getColorAt(xMin,yMax).equals(RED)||
        getWorld().getColorAt(xMax,yMin).equals(RED)

        ){

            speed=1;
        }
        if(getWorld().getColorAt(xMax,yMax).equals(BLUE)||
        getWorld().getColorAt(xMin,yMin).equals(BLUE)||
        getWorld().getColorAt(xMin,yMax).equals(BLUE)||
        getWorld().getColorAt(xMax,yMin).equals(BLUE)

        ){
            //getWorld().addObject(new End(), 400, 300) ;
            //getWorld().stopped();
            getWorld().setBackground("maze27.jpg");
        }
        if(getWorld().getColorAt(xMax,yMax).equals(GREEN)||
        getWorld().getColorAt(xMin,yMin).equals(GREEN)||
        getWorld().getColorAt(xMin,yMax).equals(GREEN)||
        getWorld().getColorAt(xMax,yMin).equals(GREEN)

        ){

            speed=10;
        }
    }


    private void moveWithKeyboard(){
        String key = Greenfoot.getKey();
        int x = this.getX();
        int y =this.getY();

        //System.out.print(i.getColorAt(getX(),getY()));
        System.out.println(getWorld().getColorAt(getX(),getY()));

        if (key ==null) return;
        if (Greenfoot.isKeyDown("w")){
            // move forward
            turn(-90);
            //setRotation(90);
            move(speed);
            turn(90);

        }
        else if(Greenfoot.isKeyDown("s")){

            //setRotation(270);
            turn(-90);
            move(-speed);
            turn(90);

        }
        else if(Greenfoot.isKeyDown("a")){
            turn(-10);

        }
        else if(Greenfoot.isKeyDown("d")){
            turn(10);

        } 
        animation();

    }

    private void Edge(){
        if(atWorldEdge()){
            turn(Greenfoot.getRandomNumber( 360 ));
        }

    }

    private void animation(){
        if(getImage()==image1){
            setImage(image2);
        }
        else{
            setImage(image1);
        }
    }
}

