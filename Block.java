import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Environment
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Vector speed;
    private double x = 0;
    private double y = 0;
    private int start =0;
    private int initX=0;
    private int initY=0;
    private int toX;
    private int toY;
    private int moveSpeed =1;
    private int angle =0;
    public Block(int width,int heigth,int initx,int inity,int toX,int toY,int moveSpeed,int angle){
        this.initX = initx;
        this.initY=inity;
        this.toX = toX;
        this.toY = toY;
        this.moveSpeed=moveSpeed;
        this.angle=angle;
        GreenfootImage image = new GreenfootImage(width,heigth);
        image.setTransparency(200);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,width,heigth);
        setImage(image);

    }

    public Block(int width,int heigth,int angle){
        this.angle=angle;
        GreenfootImage image = new GreenfootImage(width,heigth);
        image.setTransparency(200);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,width,heigth);
        turn(angle);
        setImage(image);
        
    }
    public Block(int width,int heigth){
        this.angle=angle;
        GreenfootImage image = new GreenfootImage(width,heigth);
        image.setTransparency(200);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,width,heigth);
        
        setImage(image);
        
    }

    public void init(){
        //initX =getX();
        //  initY =getY();
    }

    public Block(int width,int heigth,Vector speed){
        GreenfootImage image = new GreenfootImage(width,heigth);
        image.setTransparency(200);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,width,heigth);
        setImage(image);
        this.speed = speed;
    }

    public void act() 
    {
        // Add your action code here.
    }

    public void move( ) 
    {
        x = x + speed.getX();
        y = y + speed.getY();
        // wrap around the edge of world

        setLocation((int)x,(int)y);
    }

    public void moveX(){
        x=getX();
        y=getY();
        if(x<=initX-toX)
        {
            start=1;
        }
        else if(x>=initX+toX)
        {
            start=0;
        }
        if(start==0){
            this.speed =new Vector(-180,moveSpeed);

        }
        else if((start==1)){
            this.speed =new Vector(0,moveSpeed);

        }
        move();
    } public void moveY(){
        x=getX();
        y=getY();
        if(y<=initY-toY)
        {
            start=1;
        }
        else if(y>=initY+toY)
        {
            start=0;
        }
        if(start==0){
            this.speed =new Vector(-90,moveSpeed);

        }
        else if((start==1)){
            this.speed =new Vector(90,moveSpeed);

        }
        move();
    }
}
