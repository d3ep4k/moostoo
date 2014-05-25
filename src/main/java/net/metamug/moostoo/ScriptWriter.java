/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.metamug.moostoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author mishrado
 */
public class ScriptWriter {

    JEditorPane editor;

    public ScriptWriter(JEditorPane editor) {
        this.editor = editor;
    }

    public static void log(String log) {
        System.out.println(log);
    }

    public static void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void cleanUp() {
        File actionFile = new File(System.getProperty("user.dir") + "/Action.java");
        actionFile.delete();
    }

    public static void println(String script) {
        FileWriter out = null;
        try {

            out = new FileWriter(System.getProperty("user.dir") + "/Action.java");

            /**
             * *****Generated Code *************
             */
            out.write("import java.util.*;");
            out.write("import java.io.*;");
            out.write("import java.awt.*;");
            out.write("import org.jnativehook.GlobalScreen;");
            out.write("import org.jnativehook.keyboard.NativeKeyEvent;\n");
            out.write("import org.jnativehook.keyboard.NativeKeyListener;\n");
            out.write("public class Action implements NativeKeyListener{");
            out.write("private static $$ $;\n");
            out.write("private static final  Action A = new Action();\n");
            out.write("private Action(){try {$ = new $$();\n"
                    + "GlobalScreen.getInstance().addNativeKeyListener(this);\n"
                    + "}catch(java.awt.AWTException e){}}");

            //out.write("private static void init(){ A = new Action();}");
            out.write("public static void main(String args[]){");
            out.write("$.delay(2000);\n");
            out.write("A.main();");
            out.write("\nSystem.exit(0);}\n");
            out.write(script);
            out.write("\npublic void keyPressed(NativeKeyEvent nke) {"
                    + "     if (nke.getKeyCode() == NativeKeyEvent.VK_F8) {"
                    + "         System.out.println(\"Process Aborted due to Interrupt.\");\n"
                    + "         System.exit(0);\n"
                    + "     }"
                    + "  }");
            out.write("public void keyReleased(NativeKeyEvent nke) {}");
            out.write("}");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScriptWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScriptWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ScriptWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void println(File file, String script) {
        FileWriter fw = null;
        try {

            fw = new FileWriter(file);
            fw.write(script);
            System.out.println("Script Saved.");
        } catch (IOException ex) {
            Logger.getLogger(ScriptWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ScriptWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
