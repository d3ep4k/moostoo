/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.metamug.moostoo;

import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author mishrado
 */
public class ScriptGenerator {

    public ScriptGenerator(ScriptEditor scriptEditor, String code) {
            Document d=  scriptEditor.getEditorDoc();
        try {
        generate();
            d.insertString(d.getLength(), "\n\nvoid recordedCode(){\n"+code+"\n}", null);
//        super(parent);
//        this.parent = parent;
//        this.code = code;
//
//        JTextArea tx = new JTextArea();
//        tx.setText(code);
//        add(new JScrollPane(tx));
//        setSize(tx.getPreferredScrollableViewportSize());
//        setVisible(true);
        } catch (BadLocationException ex) {
            Logger.getLogger(ScriptGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Frame parent;
    String code;

    public void generate() {
        try {
            Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\tempScript"));
           String prev=null, current=null;
            if(scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
                prev = current = (scanner.nextLine());
            }
            StringBuilder newCode = new StringBuilder();
            while (scanner.hasNextLine()) {
                prev = current;
                System.out.println(prev);
                current = scanner.nextLine();
                if (prev.substring(prev.indexOf("("))
                        .equals(
                        current
                        .substring(prev.indexOf("(")))) {
                    newCode.append("$.click" + current.substring(prev.indexOf("(")));
                } else {
                    newCode.append(prev);
                    prev = current;
                    current = scanner.nextLine();
                    if (prev.substring(prev.indexOf("("))
                            .equals(
                            current
                            .substring(prev.indexOf("(")))) {
                        newCode.append("$.click" + current.substring(prev.indexOf("(")));
                    }
                }
            }
    //        newCode.append(current);
    //        code = newCode.toString();
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScriptGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
