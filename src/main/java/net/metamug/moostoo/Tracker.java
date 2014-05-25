/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.metamug.moostoo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author mishrado
 */
public class Tracker {
    private static TrayIcon trayIcon;
    public static boolean visualize ;
    Sniffer sniffer;
    public  Tracker(Sniffer sniffer)  {   
        this.sniffer = sniffer;
    }
    
    
    
    public  void getSystemTray(){
             //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        trayIcon =
                new TrayIcon(Toolkit.getDefaultToolkit().getImage("C:\\SysImage\\White_Mouse.png"));//createImage("images\\mouse3.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();
       
        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("Replay");
        CheckboxMenuItem look = new CheckboxMenuItem("Visualize");
        //CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
        Menu displayMenu = new Menu("Display");
        //MenuItem errorItem = new MenuItem("Error");
        //MenuItem warningItem = new MenuItem("Warning");
        //MenuItem infoItem = new MenuItem("Info");
        //MenuItem noneItem = new MenuItem("None");
        MenuItem exitItem = new MenuItem("Exit");
       
        //Add components to popup menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(look);
       // popup.add(cb2);
        popup.addSeparator();
        popup.add(displayMenu);
        //displayMenu.add(errorItem);
        //displayMenu.add(warningItem);
        //displayMenu.add(infoItem);
        //displayMenu.add(noneItem);
        popup.add(exitItem);
       
        trayIcon.setPopupMenu(popup);
        trayIcon.setToolTip("Moostoo");
        trayIcon.setImageAutoSize(true);
       
       
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
             
        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // sniffer.recording = !sniffer.recording;
               // if(sniffer.recording)
                //   sniffer.addNativeHook();
               //else
               //     sniffer.removeNativeHook();
                
                //trayIcon.setImage(Toolkit.getDefaultToolkit().getImage("images\\option_in_2.png"));
            }
        });
        
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tracker.this.restartSniffing(sniffer);
                sniffer.replaying = true;
            }
        });
        
        look.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int cb1Id = e.getStateChange();
                if (cb1Id == ItemEvent.SELECTED){
                    visualize = (true);
                    System.out.println("able to see");
                } else {
                    visualize = false;
                    System.out.println("unable to see");
                }
            }
        });
        
     /*    
        cb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int cb1Id = e.getStateChange();
                if (cb1Id == ItemEvent.SELECTED){
                    trayIcon.setImageAutoSize(true);
                } else {
                    trayIcon.setImageAutoSize(false);
                }
            }
        });
        
        cb2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int cb2Id = e.getStateChange();
                if (cb2Id == ItemEvent.SELECTED){
                    trayIcon.setToolTip("Sun TrayIcon");
                } else {
                    trayIcon.setToolTip(null);
                }
            }
        });
        */
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem)e.getSource();
                //TrayIcon.MessageType type = null;
                System.out.println(item.getLabel());
                if ("Error".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.ERROR;
                    trayIcon.displayMessage("Recording",
                            "Started Sniffing...", TrayIcon.MessageType.WARNING);
                    
                    
                } else if ("Warning".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.WARNING;
                    trayIcon.displayMessage("Finished Recording",
                            "Stopped Sniffing.", TrayIcon.MessageType.INFO);
                    
                } else if ("Info".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.INFO;
                    trayIcon.displayMessage("Running",
                            "Total Run Time ", TrayIcon.MessageType.INFO);
                    
                } else if ("None".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.NONE;
                    trayIcon.displayMessage("Finished Running",
                            "Total Time Taken", TrayIcon.MessageType.INFO);
                }else if ("None".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.NONE;
                    trayIcon.displayMessage("Aborted",
                            "Process Aborted at.", TrayIcon.MessageType.ERROR);
                }else if ("None".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.NONE;
                    trayIcon.displayMessage("Step Failed",
                            "Could not verify step.", TrayIcon.MessageType.ERROR);
                }
                
                
            }
        };
    /*    
        errorItem.addActionListener(listener);
        warningItem.addActionListener(listener);
        infoItem.addActionListener(listener);
        noneItem.addActionListener(listener);
      */  
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = Tracker.class.getResource(path);
        
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
   /* public static void main(String args[]){
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // Turn off metal's use of bold fonts 
        
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tracker("Moostoo").getSystemTray();
            }
        });
        
    }
*/
    public static void addTrayMessage(String caption, String message,  TrayIcon.MessageType type){
        trayIcon.displayMessage(caption,
                            message, type);
    }
    
    public  void restartSniffing(Sniffer sniffer){
      
        sniffer.pauseRecording = false;
        sniffer.recording = true;
        sniffer.addNativeHook();
    }
    
    public void resume(){
        sniffer.pauseReplay = false;
        sniffer.replaying = true;
    }
    
    public static void setIcon(String file){
        trayIcon.setImage(Toolkit.getDefaultToolkit().getImage("images\\"+file));
    }
    
}