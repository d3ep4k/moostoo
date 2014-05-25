/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.metamug.moostoo;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author mishrado
 */
public class WatchDog {
    Robot robot;
    File imageDir;
    public WatchDog(String imageDirName){
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(WatchDog.class.getName()).log(Level.SEVERE, null, ex);
        }
        File imageDir = new File(imageDirName);
        if(imageDir.isDirectory()){
            this.imageDir = imageDir;
        }
    }
    
//    BufferedImage getCheckPointImage(int x, int y, long timestamp){
//        return createScreenCapture(new Rectangle(x,y,16,16));
//    }
    
    boolean setCheckPointImage(int x, int y, long timestamp){
        try {
            ImageIO.write(getGrayScale(
                                robot.createScreenCapture(
                                        new Rectangle(x-8,y-8,16,16))),
                    "png",
                    new File(imageDir.getAbsolutePath()
                    +"\\"
                    +Long.toString(timestamp)
                    +".png"));
            System.out.println("Image Written");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(WatchDog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public BufferedImage getGrayScale(BufferedImage inputImage){
        BufferedImage img = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = img.getGraphics();
        g.drawImage(inputImage, 0, 0, null);
        g.dispose();
        return img;
    }
    
    public boolean match(BufferedImage one, BufferedImage two){
        
        return false;  
    }
    
    void hello(){
        System.out.println("Image Written");
    }
}
