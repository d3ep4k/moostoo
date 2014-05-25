/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.metamug.moostoo;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.SwingWorker;

import org.jnativehook.GlobalScreen;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;

/**
 *
 * @author mishrado
 */
public final class Sniffer implements NativeKeyListener, NativeMouseListener, NativeMouseMotionListener {

    boolean replaying, pauseRecording, pauseReplay, recording;
    Tracker tracker;
    long startTime;
    ScriptRecorder recorder;
    WatchDog watchDog;
    ScriptEditor editor;
long thinkTime;
    public Sniffer(ScriptEditor editor) {

        tracker = new Tracker(this);
        tracker.getSystemTray();
        watchDog = new WatchDog("C:\\Codex");
        this.editor = editor;
          addNativeHook();
    }

    public void addNativeHook() {
        //Add Listeners
        GlobalScreen.getInstance().addNativeKeyListener(this);
        GlobalScreen.getInstance().addNativeMouseListener(this);
        GlobalScreen.getInstance().addNativeMouseMotionListener(this);
    }

    public void removeNativeHook() {
        GlobalScreen.getInstance().removeNativeKeyListener(this);
        GlobalScreen.getInstance().removeNativeMouseListener(this);
        GlobalScreen.getInstance().removeNativeMouseMotionListener(this);
    }

    @Override
    public void keyPressed(NativeKeyEvent nke) {
        // Save Recording
        if (nke.getKeyCode() == NativeKeyEvent.VK_F12) {
        }
        //Load Recording
        if (nke.getKeyCode() == NativeKeyEvent.VK_F10) {
        }
        //Replay Recording
//        if (nke.getKeyCode() == NativeKeyEvent.VK_F9) {
//
//            replaying = !replaying;
//            if (replaying) {
//                System.out.println("Running..m>");
//                Tracker.addTrayMessage("Running",
//                        "Total Run Time ", TrayIcon.MessageType.INFO);
//
//            } else {
//                System.out.println("Obstructed. :( ");
//                long millis = System.currentTimeMillis() - startTime;
//                Tracker.addTrayMessage("Aborted ",
//                        "Time Elapsed: " + String.format("%d m, %d s",
//                        TimeUnit.MILLISECONDS.toMinutes(millis),
//                        TimeUnit.MILLISECONDS.toSeconds(millis)
//                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))), TrayIcon.MessageType.WARNING);
//            }
//
//        }
        //Record
        if (nke.getKeyCode() == NativeKeyEvent.VK_F8) {
            thinkTime = 0;
           activateRecorder();
        }

        //Pause
        if (nke.getKeyCode() == NativeKeyEvent.VK_PAUSE) {
//            if (recording) {
//                pauseRecording = true;
//            }
//            if (replaying) {
//                pauseReplay = true;
//            }
            
            recording = !recording;

            if (recording == false) {
                Tracker.addTrayMessage("Paused", "Info related to Pause", TrayIcon.MessageType.INFO);
                //removeNativeHook();
            }else{
                Tracker.addTrayMessage("Resumed Recording", "Info related to Pause", TrayIcon.MessageType.INFO);
            }
        }

        if (recording) {

            int KEY_CODE = nke.getKeyCode();

            if (KEY_CODE != NativeKeyEvent.VK_F8) {
                recorder.keyPress(KEY_CODE);
            }
        }


    }

    @Override
    public void keyReleased(NativeKeyEvent nke) {
        if (recording == true) {

            int KEY_CODE = nke.getKeyCode();

            if (KEY_CODE != NativeKeyEvent.VK_F8) {
                recorder.keyRelease(KEY_CODE);
            }
        }
    }

    @Override
    public void mousePressed(NativeMouseEvent nme) {

        if (recording == true) {
            Point p = new Point(nme.getX(), nme.getY());
            System.out.println(nme.getButton() + " Mouse Pressed at:" + p);
            //long now = System.currentTimeMillis();
            recorder.mousePress(nme.getX(), nme.getY(), nme.getButton());
            //hacker.writeScreenShot("snaps/" + now + ".png", new Rectangle(p.x - 16, p.y - 16, 16, 16));
            watchDog.setCheckPointImage(nme.getX(), nme.getY(), System.currentTimeMillis());
            watchDog.hello();
        }
    }

    @Override
    public void mouseReleased(NativeMouseEvent nme) {

        if (recording == true) {
            //Point p = new Point(nme.getX(), nme.getY());
            //System.out.println(nme.getButton() + " Mouse Released at:" + p);
            //long now = System.currentTimeMillis();
            recorder.mouseRelease(nme.getX(), nme.getY(), nme.getButton());
        }
    }

    @Override
    public void mouseMoved(NativeMouseEvent nme) {
        if (recording == true) {
            //  Point p = new Point(nme.getX(), nme.getY());
            //   System.out.println(nme.getButton() + " Mouse Moved at:" + p);
//            long now = System.currentTimeMillis();
            //writer.mouseMove(nme.getX(), nme.getY());
        }
    }
    
    private void activateRecorder(){
         recording = !recording;
            replaying = false;
            if (recording) {
                
                //System.out.println("Started Sniffing...");
                Tracker.addTrayMessage("Recording", "Started Sniffing...", TrayIcon.MessageType.WARNING);
                //Tracker.setIcon("C:\\SysImage\\button-close-focus.png");
                try {
                    recorder = new ScriptRecorder(System.getProperty("user.dir") + "\\tempScript");
                } catch (IOException ex) {
                    Logger.getLogger(Sniffer.class.getName()).log(Level.SEVERE, null, ex);
                }


            } else {
                //System.out.println("Stopped Sniffing);
                
                try {
                    recorder.close();
                    Tracker.addTrayMessage("Recorded", "Stopped Sniffinng", TrayIcon.MessageType.WARNING);
                    //long millis = ((eventMap.lastKey() - eventMap.firstKey()));
                    //long millis = ((eventMap.lastKey() - eventMap.firstKey()));
                } catch (IOException ex) {
                    Logger.getLogger(Sniffer.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                    //writer.close();
                    //                Tracker.addTrayMessage("Recorded.", "Stopped Sniffing.\n Total Time: " + String.format("%d m, %d s",
                    //                        TimeUnit.MILLISECONDS.toMinutes(millis),
                    //                        TimeUnit.MILLISECONDS.toSeconds(millis)
                    //                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))), TrayIcon.MessageType.INFO);
                    //    
                  
                
                final String code = recorder.getScript();
                //System.out.println(code);
             //   editor.getScript(new File(System.getProperty("user.dir") + "\\tempScript")); 
//                new SwingWorker<Object, Object>(){@
//
//                    @Override
//                    protected Object doInBackground() throws Exception {
//                     
//                        return null;
//                    }
//                    
//                }.execute();
               
                     //editor.setText(code); 
                     //   editor.revalidate();  
                new ScriptGenerator(editor, code);
                        //.generate();
            }
    }
}
