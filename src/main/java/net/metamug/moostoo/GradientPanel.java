package net.metamug.moostoo;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class GradientPanel extends JPanel{

    public GradientPanel(Color firstColor, Color secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }

    public GradientPanel(int firstColor) {
        this.firstColor = new Color(firstColor);
    }
    Color firstColor,secondColor;
     @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        //firstColor = new Color(0xABCDCE);//getBackground(); //Color.WHITE;ABCDCE
        secondColor = firstColor.darker();
        Graphics2D g2d = (Graphics2D) g;
        // Paint a gradient from top to bottom
        GradientPaint gp = new GradientPaint(
                0, 0, firstColor,
                0, h, secondColor);
        // Paint a gradient from left to right
        GradientPaint gpLR = new GradientPaint(
                w, h, firstColor,
                0, 0, secondColor);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        //g.fillRoundRect(0, 0, w, h, 6, 6);
        setOpaque(false);
    }
}
