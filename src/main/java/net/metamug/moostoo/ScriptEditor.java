package net.metamug.moostoo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;
import jsyntaxpane.DefaultSyntaxKit;
import net.metamug.moostoo.CirlceSpot;
import net.metamug.moostoo.ScriptWriter;

/**
 *
 * @author mishrado
 */
public class ScriptEditor extends javax.swing.JFrame {

    StringBuilder script = new StringBuilder();
    private File scriptFile;
    private Process scriptProcess;
    private CirlceSpot map;
    private final JFileChooser fileChooser;
    //private final TitleBar bar;

    /**
     * Creates new form ScriptEditor
     */
    public ScriptEditor() {
        setTitle("Scripty ");
        //setUndecorated(true);
        DefaultSyntaxKit.initKit();

        initComponents();
        //getRootPane().setBorder(new EtchedBorder(3,Color.GRAY,Color.BLACK));
        //getRootPane().setBackground(Color.WHITE);
        getContentPane().setBackground(new Color(0x777777));//.setBackground(new Color(0x777777));
        jPanel2.setBackground(new Color(0x777777));
        //setOpacity(0.74f);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\SysImage\\media-playback-start.png"));
        //scriptEditor.setContentType("text/html");
        //titleBar.setLayout(new BorderLayout());
        setSize(500, 500);
        setLocationRelativeTo(null);
        //bar = new TitleBar(this);
        //build.setEnabled(false);

        fileChooser = new JFileChooser(System.getProperty("user.dir"));
        //titleBar.add(bar);
        //titleBar.setSize(bar.getSize());
        //add(bar);
        //bar.setBounds(0,0,getWidth(), bar.getHeight());
        remove(titleBar);
        scriptEditor.setText("/*****Script*****/\nvoid main()\n{\n\n\n}");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        titleBar = new javax.swing.JPanel();
        toolBar = new GradientPanel(0x666666);
        jPanel2 = new javax.swing.JPanel();
        build = new javax.swing.JButton();
        run = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        mapButton = new javax.swing.JToggleButton();
        scriptEditorPanel = new javax.swing.JPanel();
        scriptEditor = new javax.swing.JEditorPane();
        editorScrollPane = new javax.swing.JScrollPane(scriptEditor);
        statusBarPanel = new GradientPanel(0x666666);
        bottomPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton4.setText("Record");
        jButton4.setToolTipText("");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleBar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 1, 4, 1));
        jPanel2.setOpaque(false);

        build.setText("build");
        build.setBorderPainted(false);
        build.setFocusPainted(false);
        build.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildActionPerformed(evt);
            }
        });

        run.setText("run");
        run.setBorderPainted(false);
        run.setEnabled(false);
        run.setFocusPainted(false);
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        openButton.setText("open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        stop.setText("stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        mapButton.setText("Map");
        mapButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mapButtonStateChanged(evt);
            }
        });
        mapButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mapButtonItemStateChanged(evt);
            }
        });
        mapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(build, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(run)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stop)
                    .addComponent(mapButton)
                    .addComponent(run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(build, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout toolBarLayout = new javax.swing.GroupLayout(toolBar);
        toolBar.setLayout(toolBarLayout);
        toolBarLayout.setHorizontalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        toolBarLayout.setVerticalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scriptEditorPanel.setBackground(new java.awt.Color(255, 255, 255));

        editorScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        editorScrollPane.setBorder(null);

        scriptEditor.setContentType("text/java"); // NOI18N
        scriptEditor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        scriptEditor.setForeground(new java.awt.Color(0, 51, 153));
        scriptEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                scriptEditorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                scriptEditorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                scriptEditorKeyTyped(evt);
            }
        });
        //editorScrollPane.setViewportView(scriptEditor);

        javax.swing.GroupLayout scriptEditorPanelLayout = new javax.swing.GroupLayout(scriptEditorPanel);
        scriptEditorPanel.setLayout(scriptEditorPanelLayout);
        scriptEditorPanelLayout.setHorizontalGroup(
            scriptEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editorScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        scriptEditorPanelLayout.setVerticalGroup(
            scriptEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editorScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        bottomPanel.setBackground(new java.awt.Color(102, 102, 102));
        bottomPanel.setOpaque(false);

        statusLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addComponent(statusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(statusLabel))
        );

        javax.swing.GroupLayout statusBarPanelLayout = new javax.swing.GroupLayout(statusBarPanel);
        statusBarPanel.setLayout(statusBarPanelLayout);
        statusBarPanelLayout.setHorizontalGroup(
            statusBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        statusBarPanelLayout.setVerticalGroup(
            statusBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scriptEditorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scriptEditorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(statusBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildActionPerformed
        //System.out.println("\""+scriptFile.getAbsolutePath()+"\"");
        try {
            //new Compiler(scriptFile.getAbsolutePath());
            //new Compiler("C:\\Documents and Settings\\mishrado\\My Documents\\NetBeansProjects\\Autometa\\code.java");
            //boolean compile = new Executor(Sniffer.getInstance()).compile(scriptFile.getAbsolutePath());
            //new Compiler("C:\\j\\HelloWorld.java");
            save();
//            Process p1 = Runtime.getRuntime().exec("javac"
//                    + " -sourcepath \"" + scriptFile.getParent() + "\""
//                    + " -cp \"" + System.getProperty("user.dir") + "\\usr" + "\""
//                    + " \"" + scriptFile.getAbsolutePath() + "\"");
            Process p = Runtime.getRuntime().exec("javac"
                    + " -sourcepath \"" + System.getProperty("user.dir") + "\""
                    + " -cp \"" + System.getProperty("user.dir") + "\\usr" + "\""
                    + " \"" + "Action.java" + "\"");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            //ScriptWriter.cleanUp();
            String errorousOutput = "";
            String error = br.readLine();
            if (error == null) {
                statusLabel.setText("Built Successful.");
                run.setEnabled(true);
            } else {
                do {
                    errorousOutput += error + "\n";
                } while ((error = br.readLine()) != null);
                ScriptWriter.errorMessage(errorousOutput);
            }

            // System.out.println(System.getProperty("user.dir") + error);
            // System.out.println(br1.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ScriptEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buildActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed

        //buildActionPerformed(evt);
        //scriptRun.run();
        new Executor().execute();
    }//GEN-LAST:event_runActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed

        int returnVal = fileChooser.showOpenDialog(openButton);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            scriptFile = fileChooser.getSelectedFile();
            getScript(scriptFile);
            scriptEditor.setText(script.toString());
            build.setEnabled(true);

        } else {
            System.out.println("Open command cancelled by user.");
        }

       // bar.setExtendedTitle("AutoMotion -" + scriptFile.getName());
    }//GEN-LAST:event_openButtonActionPerformed

    private void scriptEditorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scriptEditorKeyTyped
//        format(script);
//        script = scriptEditor.getText();
//        run.setEnabled(false);
////        if (scriptFile != null) {
//        save.setEnabled(true);
//        } else {
//            //open a new file
//            scriptFile = new File(System.getProperty("user.dir") + "/Action.java");
//        }
//        
//        if(evt.getKeyChar() == KeyEvent.VK_PERIOD){
//            System.out.println("ook");
//            new ContextMenu(scriptEditor);
//            
//        }
    }//GEN-LAST:event_scriptEditorKeyTyped

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        scriptProcess.destroy();
    }//GEN-LAST:event_stopActionPerformed

    private void mapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapButtonActionPerformed
    }//GEN-LAST:event_mapButtonActionPerformed

    private void mapButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mapButtonStateChanged
    }//GEN-LAST:event_mapButtonStateChanged

    private void mapButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mapButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            map = new CirlceSpot(this);
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            map.setVisible(false);
        }
    }//GEN-LAST:event_mapButtonItemStateChanged

    private void scriptEditorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scriptEditorKeyReleased
//        //format(script);
//        script = scriptEditor.getText();
//        run.setEnabled(false);
//        save.setEnabled(true);
    }//GEN-LAST:event_scriptEditorKeyReleased

    private void scriptEditorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scriptEditorKeyPressed
//        if (evt.getKeyChar() == '$') {
//            new SwingWorker<Object, Object>() {
//                @Override
//                protected Object doInBackground() throws Exception {
//                    ContextMenu contextMenu;
//
//                  
//                        contextMenu = new ContextMenu();
//                        contextMenu.show(scriptEditor, 0, 0);
//                        while (contextMenu.selectedItemString == null);
//                        String text = scriptEditor.getText();
//                        if (text != null) {
//                            scriptEditor.setText(
//                                    text.substring(0, text.length()-1)
//                                    + contextMenu.selectedItemString);
//                        } else {
//                            scriptEditor.setText("" + contextMenu.selectedItemString);
//                        }
//                        contextMenu.selectedItemString = null;
//                  
//                    return null;
//                }
//            }.execute();
//
//        }
    }//GEN-LAST:event_scriptEditorKeyPressed

    public void getScript(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            script.delete(0, script.length());
            while ((line = reader.readLine()) != null) {
                script.append(line + "\n");
            }
            //System.out.println(script);
//            Pattern pattern;
//            pattern = Pattern.compile("public static void main\\(String args\\[\\]\\)\\{init\\(\\);(.*)\\}.*public void keyPressed",
//                    Pattern.DOTALL);
//            Matcher matcher = pattern.matcher(script);
//            if (matcher.find()) {
//                System.out.println(matcher.group(1));
//                script = (matcher.group(1));

            scriptEditor.setText(script.toString());
//            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScriptEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScriptEditor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ScriptEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void save() {
        script.setLength(0);
        script.append(scriptEditor.getText());
        ScriptWriter.println(script.toString());
        if (scriptFile != null) {
            ScriptWriter.println(scriptFile, script.toString());
        } else {
            int returnVal = fileChooser.showSaveDialog(openButton);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                scriptFile = fileChooser.getSelectedFile();
                ScriptWriter.println(scriptFile, script.toString());
            } else {
                System.out.println("Save command cancelled by user.");
            }
        }
    }

    public void format(String script) {
        //script.replace("$", "<font color='red'>$</font>");
        //StyleConstants.setForeground(header, Color.GREEN);
        //doc.set(script.indexOf("$"), 1,  header, true);
    }

    class Executor extends SwingWorker<String, Void> {

        @Override
        protected String doInBackground() {
            run.setEnabled(false);
            try {
                statusLabel.setText("Running...");
                //String classFile = scriptFile.getName().substring(0, scriptFile.getName().indexOf("."));

                //System.out.println(classFile);
                //EventQueue.invokeLater(this);
//                scriptProcess = Runtime.getRuntime().exec("java"
//                        + " -cp \"" + scriptFile.getParent() + ";"
//                        + System.getProperty("user.dir") + "\\usr" + "\" "
//                        + classFile);

                scriptProcess = Runtime.getRuntime().exec("java"
                        + " -cp \"" + System.getProperty("user.dir") + ";"
                        + System.getProperty("user.dir") + "\\usr" + "\" "
                        + "Action");

                BufferedReader br = new BufferedReader(new InputStreamReader(scriptProcess.getErrorStream()));
                BufferedReader br1 = new BufferedReader(new InputStreamReader(scriptProcess.getInputStream()));
                System.out.println(br.readLine());
                System.out.println(br1.readLine());

            } catch (IOException ex) {
                Logger.getLogger(ScriptEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
            //statusLabel.setText("Finished Running.");
            return "Finished Running.";
        }

        @Override
        protected void done() {
            try {
                System.out.println("done!!");
                statusLabel.setText(get());
            } catch (InterruptedException | ExecutionException ignore) {
            }
        }
    };
    
    public void setText(String text){
        scriptEditor.setText(text);
    }
    
    public Document getEditorDoc(){
        return scriptEditor.getDocument();
    }

    // An inner class to check whether mouse events are the popup trigger
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton build;
    private javax.swing.JScrollPane editorScrollPane;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton mapButton;
    private javax.swing.JButton openButton;
    private javax.swing.JButton run;
    private javax.swing.JEditorPane scriptEditor;
    private javax.swing.JPanel scriptEditorPanel;
    private javax.swing.JPanel statusBarPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton stop;
    private javax.swing.JPanel titleBar;
    private javax.swing.JPanel toolBar;
    // End of variables declaration//GEN-END:variables
}