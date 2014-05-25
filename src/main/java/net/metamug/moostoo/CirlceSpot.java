/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.metamug.moostoo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import org.jnativehook.GlobalScreen;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseMotionListener;

/**
 *
 * @author Administrator
 */
public class CirlceSpot extends JDialog implements MouseListener, NativeMouseMotionListener {

    public static final Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
    int circleX, circleY;
    private final Image offscreen;
    private final Graphics bufferGraphics;
    final int SPOTWIDTH=70,SPOTHEIGHT=20;

    public CirlceSpot(Frame owner) {
        super(owner);
        
        setUndecorated(true);
        setBounds(0,0,SPOTWIDTH,SPOTHEIGHT);
        setVisible(true);
        //addMouseListener(this);
        GlobalScreen.getInstance().addNativeMouseMotionListener(this);
        //setOpacity(owner.getOpacity());
        offscreen = createImage(this.getWidth(), this.getHeight());
        // by doing this everything that is drawn by bufferGraphics 
        // will be written on the offscreen image. 
        bufferGraphics = offscreen.getGraphics();
        setAlwaysOnTop(true);
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CirlceSpot(null);
            }
        });
    }

    @Override
    public void paint(final Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //setSize(circleX, circleY);

        bufferGraphics.setFont(new Font("Verdana", Font.BOLD, 11));

        bufferGraphics.setColor(Color.ORANGE);
        bufferGraphics.fillRect(0, 0, SPOTWIDTH, SPOTHEIGHT);
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.drawString("(" + circleX + "," + circleY + ")", 3, 14);
        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//       circleX = circleY = 100;
//       repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        circleX = SPOTWIDTH;
        circleY = SPOTHEIGHT;

        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        circleX = circleY = 7;
        repaint();
    }

    @Override
    public void mouseMoved(NativeMouseEvent nme) {
        circleX = nme.getX();
        circleY = nme.getY();
        if (circleX < winSize.width / 2) {
            if (circleY > winSize.height / 2) {
                //Lower Left
                setLocation(circleX + SPOTWIDTH, circleY - 2*SPOTHEIGHT);
            }else{
                //Upper Left
                setLocation(circleX + SPOTWIDTH, circleY + 2*SPOTHEIGHT);
            }
        } else {
            if (circleY > winSize.height / 2) {
                //Lower Right
                setLocation(circleX - 2*SPOTWIDTH, circleY - 3*SPOTHEIGHT);
            }else{
                // Upper Right
                setLocation(circleX - 2*SPOTWIDTH, circleY + 3*SPOTHEIGHT);
            }
        }
        repaint();
    }
}
