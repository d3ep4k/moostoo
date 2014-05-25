package net.metamug.moostoo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Administrator
 */
public class ContextMenu extends JPopupMenu {//implements PopupMenuListener {

    private Component parentPanel;
    String selectedItemString = null;

    public ContextMenu(final JEditorPane editorPane) {
        //this.parentPanel = parentPanel;
        //this.selectedItemString = selectedItemString;

        ActionListener menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ContextMenu.this.selectedItemString = event.getActionCommand();

//                System.out.println("Popup menu item ["
//                        + selectedItemString + "] was pressed.");
                setVisible(false);
                editorPane.getCaretPosition();
                try {
                    editorPane.getDocument().remove(editorPane.getCaretPosition()-2, editorPane.getCaretPosition()+1);
                    editorPane.getDocument().insertString(editorPane.getCaretPosition(),
                            getSelectedMethod(),
                            null);
                } catch (BadLocationException ex) {
                    Logger.getLogger(ContextMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        JMenuItem item;

        for (Method method : $$.class.getDeclaredMethods()) {
            String methodName = method.toGenericString();
            this.add(item =
                    new JMenuItem(methodName));
            item.setHorizontalTextPosition(JMenuItem.RIGHT);
            item.addActionListener(menuListener);
            //this.addSeparator();
        }

        this.setLabel("Justification");
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        //this.addPopupMenuListener(this);
        setVisible(true);

    }

    public String getSelectedMethod() {
        return selectedItemString.substring(selectedItemString.indexOf("$") + 1);
    }
//    
//    @Override
//    public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {
//        
//    }
//
//    @Override
//    public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) {
//      
//    }
//
//    @Override
//    public void popupMenuCanceled(PopupMenuEvent pme) {
//       
//    }
}
