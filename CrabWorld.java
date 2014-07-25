import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage
import java.util.Date;
import java.util.Random; // another random number generator

/**
 * A world where crabs and other animals live.
 * Some are friendly and some are not.
 * @author your name
 */
public class CrabWorld extends World
{

    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x460 cells, where every cell is just 1 pixel.
     */
    int x = 0;
    int y = 0;
    private GreenfootImage background = (new GreenfootImage("maze27.jpg"));
    private String[] imageName = {"test.png","test2.png"};
    private int indexOfImage=0;
    long initTime =new Date().getTime();
    long time =0;
    public CrabWorld() 
    {
        super(800, 600, 1,false);

        //addObject(new Lv1(), 400, 300 );
        addObject(new Crab(), 400,  400);
        init();
    }

    public void setTime(){

        if(initTime !=new Date().getTime()/1000){
            time++;
        }
    }

    public void moveBackground(int cX, int cY)
    {
        x = x +cX;
        y = y +cY;
        getBackground().drawImage(background,x, y);
    }

    /**
     * add an actor to the world at a random location.
     * @param actor is the object to add to the world
     */

    public void addObject( Actor actor ) {
        int x = Greenfoot.getRandomNumber( getWidth() ); // a random x value between 0 and width of world
        int y = Greenfoot.getRandomNumber( getHeight() ); // a random y value between 0 and height of world
        // now add the actor to world at location x, y
        addObject( actor, x, y );
    }

    public void act(){
        /*
        setTime();
        if(time%10==(new Date().getTime()/1000)%10){
            if(indexOfImage==imageName.length){
                indexOfImage=0;
            }
            else{
                getBackground().drawImage(new GreenfootImage(imageName[indexOfImage]),x, y);
                indexOfImage++;
            }
        }*/
    }

    public void init(){

        /*  w   h   x   y*/
        addObject( new   Timer(), 780, 580 );                       
        initTime = new Date().getTime()/1000;
        getBackground().drawImage(background,x, y);

        /*addObject( new   Block_static(200,200), 300, 400 );
        addObject( new   Block_dynamic(100,100, 300, 400,50,1,1), 300, 400 );
         */
    }
}