import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block_dynamic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block_dynamic extends Block
{
    /**
     * Act - do whatever the Block_dynamic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public Block_dynamic(int width,int heigth,int X,int Y,int toX,int toY,int speed,int angle){
       
        super(width,heigth,X,Y,toX,toY,speed,angle);
       
        init();
        
    }
    public void act() 
    {
        // Add your action code here.
        move();
    }    
}
