/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scripty;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Administrator
 */
public class TitleBar extends JComponent {

    JLabel logo;
    private Point initialClick;
    private boolean maximized = false;
    public static final Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    ImageIcon INACTIVE_BUTTON = new ImageIcon(
            Toolkit.getDefaultToolkit().createImage(
            "C:\\SysImage\\button-inactive.png"));
    ImageIcon MIN_FOCUS_BUTTON = new ImageIcon(
            Toolkit.getDefaultToolkit().createImage(
            "C:\\SysImage\\button-min-focus.png"));
    ImageIcon MIN_NORMAL_BUTTON = new ImageIcon(
            Toolkit.getDefaultToolkit().createImage(
            "C:\\SysImage\\button-min.png"));
    ImageIcon MAX_FOCUS_BUTTON = new ImageIcon(
            Toolkit.getDefaultToolkit().createImage(
            "C:\\SysImage\\button-max-focus.png"));
    ImageIcon MAX_NORMAL_BUTTON = new ImageIcon(
            Toolkit.getDefaultToolkit().createImage(
            "C:\\SysImage\\button-max.png"));
    ImageIcon CLOSE_FOCUS_BUTTON = new ImageIcon(
            Toolkit.getDefaultToolkit().createImage(
            "C:\\SysImage\\button-close-focus.png"));
    ImageIcon CLOSE_NORMAL_BUTTON = new ImageIcon(
            Toolkit.getDefaultToolkit().createImage(
            "C:\\SysImage\\button-close.png"));
    private final JFrame parentFrame;
    private final JLabel title ;
    private String extendedTitle;

    public TitleBar(final JFrame parent) {

        this.parentFrame = parent;
        GroupLayout grouplayout = new GroupLayout(this);
        GridBagLayout gridLayout = new GridBagLayout();
        setLayout(new BorderLayout(100, 15));
        //parent.setUndecorated(true);
        extendedTitle = parent.getTitle();
        //setBorder(BorderFactory.createEmptyBorder());
        final JLabel minimize = new JLabel(MIN_NORMAL_BUTTON);

        minimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.setExtendedState(JFrame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                minimize.setIcon(MIN_FOCUS_BUTTON);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimize.setIcon(MIN_NORMAL_BUTTON);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                minimize.setIcon(MIN_NORMAL_BUTTON);
            }

            public void mouseReleased(MouseEvent e) {
                minimize.setIcon(MIN_FOCUS_BUTTON);
            }
        });

        final JLabel maximize = new JLabel(MAX_NORMAL_BUTTON);

        maximize.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                resize(parent);
            }

            public void mouseEntered(MouseEvent e) {
                maximize.setIcon(MAX_FOCUS_BUTTON);

            }

            public void mouseExited(MouseEvent e) {
                maximize.setIcon(MAX_NORMAL_BUTTON);
            }

            public void mousePressed(MouseEvent e) {
                maximize.setIcon(MAX_NORMAL_BUTTON);
            }

            public void mouseReleased(MouseEvent e) {
                maximize.setIcon(MAX_FOCUS_BUTTON);
            }
        });

        final JLabel close = new JLabel(CLOSE_NORMAL_BUTTON);

        close.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                close.setIcon(CLOSE_FOCUS_BUTTON);

            }

            public void mouseExited(MouseEvent e) {
                close.setIcon(CLOSE_NORMAL_BUTTON);
            }

            public void mousePressed(MouseEvent e) {
                close.setIcon(CLOSE_NORMAL_BUTTON);
            }

            public void mouseReleased(MouseEvent e) {
                close.setIcon(CLOSE_FOCUS_BUTTON);
            }

            public void mouseClicked(MouseEvent e) {
                System.exit(0);

            }
        });



        JPanel tools = new JPanel(new GridBagLayout());
        setLogo("C:\\SysImage\\media-playback-start.png");
        tools.add(logo);
        title = new JLabel(parent.getTitle());
        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Verdana", Font.PLAIN, 14));
        tools.add(title);
        tools.setOpaque(false);
        //tools.setBorder(new EmptyBorder(0, 10, 0, 20));
        add(tools, BorderLayout.WEST);

        JPanel states = new JPanel(new GridLayout(1, 3));
        states.setOpaque(false);
        states.add(minimize);
        states.add(maximize);
        states.add(close);
        add(states, BorderLayout.EAST);
        TitledBorder border = new TitledBorder(BorderFactory.createEmptyBorder(),
                parent.getTitle(),
                WIDTH, 4,
                new Font("Lucida Sans Unicode", Font.PLAIN, 14),
                Color.DARK_GRAY);
        //setBorder(BorderFactory.createTitledBorder(parent.getTitle()));
        //setBorder(border);


        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // get location of Window
                int thisX = parent.getLocation().x;
                int thisY = parent.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                parent.setLocation(X, Y);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    resize(parentFrame);
                }
            }
        });

    }

    public void setLogo(String path) {
        ImageIcon icon = new ImageIcon(path);
        logo = new JLabel(icon);
        logo.setBorder(new EmptyBorder(2, 6, 2, 6));
        logo.setSize(icon.getIconWidth() - 50, logo.getHeight());
    }

    public void setExtendedTitle(String titleText) {
       extendedTitle = (titleText);
       if(maximized)
           title.setText(titleText);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(0xABCDCE);//getBackground(); //Color.WHITE;ABCDCE
        Color color2 = color1.darker();
        Graphics2D g2d = (Graphics2D) g;
        // Paint a gradient from top to bottom
        GradientPaint gp = new GradientPaint(
                0, 0, color1,
                0, h, color2);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        //g.fillRoundRect(0, 0, w, h, 6, 6);
        setOpaque(false);
    }

//       void mouseClicked(MouseEvent me) {
//        if (me.getClickCount() == 2) {
//                resize(parentFrame);
//            }
//        }
    public void resize(JFrame parent) {
        if (maximized) {
            //ChatBox.this.setExtendedState(JFrame.NORMAL);
            parent.setBounds(winSize.width - 500,
                    winSize.height - 500,
                    470, 470);
           
            title.setText(parent.getTitle());
            maximized = false;
        } else {
            parent.setBounds(0, 0, winSize.width, winSize.height);
            maximized = true;
             title.setText(extendedTitle);
        }
    }
}
