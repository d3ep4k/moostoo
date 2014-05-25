/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.metamug.moostoo;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTextArea;

/**
 *
 * @author mishrado
 */
public class ScriptRecorder extends FileWriter {
    StringBuilder code;
    public ScriptRecorder(String fileName) throws IOException {
        super(fileName);
        code = new StringBuilder();
    }

    public void mousePress(int x, int y, int button) {
        try {
            if (button == 1) {
                write("    $.press(" + x + "," + y + "," + "$.Button1" + ");\n");
            } else if (button == 2) {
                write("    $.press(" + x + "," + y + "," + "$.Button2" + ");\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(ScriptRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mouseRelease(int x, int y, int button) {
        try {
            if (button == 1) {
                write("    $.release(" + x + "," + y + "," + "$.Button1" + ");\n");
            } else if (button == 2) {
                write("    $.release(" + x + "," + y + "," + "$.Button2" + ");\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(ScriptRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mouseMove(int x, int y) {
        try {
            write("    $.move(" + x + "," + y + ");\n");
            
        } catch (IOException ex) {
            Logger.getLogger(ScriptRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void keyRelease(int keyCode) {
         try {
            write("    $.release(" + keyCode + ");\n");
            
        } catch (IOException ex) {
            Logger.getLogger(ScriptRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void keyPress(int keyCode) {
          try {
            write("    $.press(" + keyCode + ");\n");
            
        } catch (IOException ex) {
            Logger.getLogger(ScriptRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void write(String text) throws IOException{
        super.write(text);
        code.append(text);
    }
    
    String getScript(){
        return code.toString(); 
        
    }
    
    
    void viewScript(){
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter("C:\\scriptFile.txt");
//            fw.write(code.toString());
//            
//        } catch (IOException ex) {
//            Logger.getLogger(ScriptRecorder.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                fw.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ScriptRecorder.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
        
       
    }
}
