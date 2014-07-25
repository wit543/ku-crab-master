import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import java.util.Date;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image;
    long initTime =new Date().getTime();
    long time =0;
    public void act() 
    {
        // Add your action code here.
        drawText();
    }    
    public String setTime(){
        
        if(initTime !=new Date().getTime()){
            time++;
        }
        System.out.println(new Date().getTime()/1000);
    	return String.valueOf(time);
    }
    public void drawText(){
        
        image = new GreenfootImage(setTime(),16,Color.RED,Color.BLUE);
        setImage(image);
    }
}

