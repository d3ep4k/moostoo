import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author Deepak Mishra
 * @version 1.0
 */
public class $$ extends Robot implements ClipboardOwner {

    String clipboardContent;
    private final int SEPERATION_DELAY = 50;
    public final int A = KeyEvent.VK_A;
    public final int B = KeyEvent.VK_B;
    public final int C = KeyEvent.VK_C;
    public final int D = KeyEvent.VK_D;
    public final int E = KeyEvent.VK_E;
    public final int F = KeyEvent.VK_F;
    public final int G = KeyEvent.VK_G;
    public final int H = KeyEvent.VK_H;
    public final int I = KeyEvent.VK_I;
    public final int J = KeyEvent.VK_J;
    public final int K = KeyEvent.VK_K;
    public final int L = KeyEvent.VK_L;
    public final int M = KeyEvent.VK_M;
    public final int N = KeyEvent.VK_N;
    public final int O = KeyEvent.VK_O;
    public final int P = KeyEvent.VK_P;
    public final int Q = KeyEvent.VK_Q;
    public final int R = KeyEvent.VK_R;
    public final int S = KeyEvent.VK_S;
    public final int T = KeyEvent.VK_T;
    public final int U = KeyEvent.VK_U;
    public final int V = KeyEvent.VK_V;
    public final int W = KeyEvent.VK_W;
    public final int X = KeyEvent.VK_X;
    public final int Y = KeyEvent.VK_Y;
    public final int Z = KeyEvent.VK_Z;
    public final int N0 = KeyEvent.VK_0;
    public final int N1 = KeyEvent.VK_1;
    public final int N2 = KeyEvent.VK_2;
    public final int N3 = KeyEvent.VK_3;
    public final int N4 = KeyEvent.VK_4;
    public final int N5 = KeyEvent.VK_5;
    public final int N7 = KeyEvent.VK_7;
    public final int N8 = KeyEvent.VK_8;
    public final int N9 = KeyEvent.VK_9;
    public final int MINUS = KeyEvent.VK_MINUS;
    public final int EQUALS = KeyEvent.VK_EQUALS;
    public final int TAB = KeyEvent.VK_TAB;
    public final int ENTER = KeyEvent.VK_ENTER;
    public final int OPEN_BRACKET = KeyEvent.VK_OPEN_BRACKET;
    public final int CLOSE_BRACKET = KeyEvent.VK_CLOSE_BRACKET;
    public final int BACK_SLASH = KeyEvent.VK_BACK_SLASH;
    public final int SEMICOLON = KeyEvent.VK_SEMICOLON;
    public final int QUOTE = KeyEvent.VK_QUOTE;
    public final int BACK_QUOTE = KeyEvent.VK_BACK_QUOTE;
    public final int COMMA = KeyEvent.VK_COMMA;
    public final int PERIOD = KeyEvent.VK_PERIOD;
    public final int SLASH = KeyEvent.VK_SLASH;
    public final int SPACE = KeyEvent.VK_SPACE;
    public final int CONTROL = KeyEvent.VK_CONTROL;
    public final int INSERT = KeyEvent.VK_INSERT;
    public final int DELETE = KeyEvent.VK_DELETE;
    public final int ALT = KeyEvent.VK_ALT;
    public final int SHIFT = KeyEvent.VK_SHIFT;
    public final int UP = KeyEvent.VK_UP;
    public final int DOWN = KeyEvent.VK_DOWN;
    public final int LEFT = KeyEvent.VK_LEFT;
    public final int RIGHT = KeyEvent.VK_RIGHT;
    static final int Button1 = InputEvent.BUTTON1_MASK;
    static final int Button2 = InputEvent.BUTTON3_MASK;

    /**
     *
     * @throws AWTException
     */
    public $$() throws AWTException {
        setAutoWaitForIdle(true);
        clipboardContent = "";
    }

    /**
     * *************************** Mouse Functions
     * ********************************************************
     */
    public void move(final int x, final int y) {
        delay(SEPERATION_DELAY);
        mouseMove(x, y);
    }

    /**
     *
     * @param x
     * @param y
     * @param mouseButton
     */
    public void press(final int x, final int y, final int mouseButton) {
        move(x, y);
        delay(SEPERATION_DELAY);
        mousePress(mouseButton);
    }

    /**
     *
     * @param x, y, mouseButton
     */
    public void release(final int x, final int y, final int mouseButton) {
        move(x, y);
        delay(SEPERATION_DELAY);
        mouseRelease(mouseButton);
    }

    /**
     * Add the set of points through which the drag needs to be performed.
     *
     * @param points
     */
    public void drag(final Point points[]) {
        delay(SEPERATION_DELAY);
        press(points[0].x, points[0].y, InputEvent.BUTTON1_MASK);
        for (Point p : points) {
            move(p.x, p.y);
        }
        release(points[points.length - 1].x, points[points.length - 1].y, InputEvent.BUTTON1_MASK);
    }

    /**
     *
     * @param point
     * @param button
     */
    public void click(final int x, final int y, final int mouseButton) {
        move(x, y);
        delay(SEPERATION_DELAY);
        mousePress(mouseButton);
        delay(SEPERATION_DELAY);
        mouseRelease(mouseButton);
    }

    public void click(final int x, final int y) {
        move(x, y);
        delay(SEPERATION_DELAY);
        mousePress(Button1);
        delay(SEPERATION_DELAY);
        mouseRelease(Button1);
    }

    /**
     * ***************************************** Key Functions
     * ***********************************************************
     */
    /**
     * Depends Upon JNativeHook. Key Input from JNativeHook mapped to KeyEvent
     * inputs
     *
     * @param keyCode
     */
    public void press(final int keyCode) {
        delay(SEPERATION_DELAY);
        keyPress(keyCode);
    }

    /**
     *
     * @param keyCode
     */
    public void release(final int keyCode) {
        delay(SEPERATION_DELAY);
        keyRelease(keyCode);
    }

    /**
     *
     * @param keyCode
     */
    public void type(final int keyCode) {
        press(keyCode);
        release(keyCode);
    }

    /**
     *
     * @param firstKey
     * @param secondKey
     */
    public void type(final int firstKey, final int secondKey) {

        press(firstKey);

        press(secondKey);
        release(secondKey);

        release(firstKey);
    }

    /**
     *
     * @param firstKey
     * @param secondKey
     * @param thirdKey
     */
    public void type(final int firstKey, final int secondKey, final int thirdKey) {

        press(firstKey);
        press(secondKey);

        press(thirdKey);
        release(thirdKey);

        keyRelease(secondKey);
        keyRelease(firstKey);
    }

    /**
     *
     * @param character
     */
    public void type(final char character) {
        switch (character) {
            case 'a':
                type(KeyEvent.VK_A);
                break;
            case 'b':
                type(KeyEvent.VK_B);
                break;
            case 'c':
                type(KeyEvent.VK_C);
                break;
            case 'd':
                type(KeyEvent.VK_D);
                break;
            case 'e':
                type(KeyEvent.VK_E);
                break;
            case 'f':
                type(KeyEvent.VK_F);
                break;
            case 'g':
                type(KeyEvent.VK_G);
                break;
            case 'h':
                type(KeyEvent.VK_H);
                break;
            case 'i':
                type(KeyEvent.VK_I);
                break;
            case 'j':
                type(KeyEvent.VK_J);
                break;
            case 'k':
                type(KeyEvent.VK_K);
                break;
            case 'l':
                type(KeyEvent.VK_L);
                break;
            case 'm':
                type(KeyEvent.VK_M);
                break;
            case 'n':
                type(KeyEvent.VK_N);
                break;
            case 'o':
                type(KeyEvent.VK_O);
                break;
            case 'p':
                type(KeyEvent.VK_P);
                break;
            case 'q':
                type(KeyEvent.VK_Q);
                break;
            case 'r':
                type(KeyEvent.VK_R);
                break;
            case 's':
                type(KeyEvent.VK_S);
                break;
            case 't':
                type(KeyEvent.VK_T);
                break;
            case 'u':
                type(KeyEvent.VK_U);
                break;
            case 'v':
                type(KeyEvent.VK_V);
                break;
            case 'w':
                type(KeyEvent.VK_W);
                break;
            case 'x':
                type(KeyEvent.VK_X);
                break;
            case 'y':
                type(KeyEvent.VK_Y);
                break;
            case 'z':
                type(KeyEvent.VK_Z);
                break;
            case 'A':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_A);
                break;
            case 'B':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
                break;
            case 'C':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_C);
                break;
            case 'D':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_D);
                break;
            case 'E':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_E);
                break;
            case 'F':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_F);
                break;
            case 'G':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_G);
                break;
            case 'H':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_H);
                break;
            case 'I':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_I);
                break;
            case 'J':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_J);
                break;
            case 'K':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_K);
                break;
            case 'L':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_L);
                break;
            case 'M':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_M);
                break;
            case 'N':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_N);
                break;
            case 'O':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_O);
                break;
            case 'P':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_P);
                break;
            case 'Q':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_Q);
                break;
            case 'R':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_R);
                break;
            case 'S':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_S);
                break;
            case 'T':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_T);
                break;
            case 'U':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_U);
                break;
            case 'V':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_V);
                break;
            case 'W':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_W);
                break;
            case 'X':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_X);
                break;
            case 'Y':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
                break;
            case 'Z':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_Z);
                break;
            case '`':
                type(KeyEvent.VK_BACK_QUOTE);
                break;
            case '0':
                type(KeyEvent.VK_0);
                break;
            case '1':
                type(KeyEvent.VK_1);
                break;
            case '2':
                type(KeyEvent.VK_2);
                break;
            case '3':
                type(KeyEvent.VK_3);
                break;
            case '4':
                type(KeyEvent.VK_4);
                break;
            case '5':
                type(KeyEvent.VK_5);
                break;
            case '6':
                type(KeyEvent.VK_6);
                break;
            case '7':
                type(KeyEvent.VK_7);
                break;
            case '8':
                type(KeyEvent.VK_8);
                break;
            case '9':
                type(KeyEvent.VK_9);
                break;
            case '-':
                type(KeyEvent.VK_MINUS);
                break;
            case '=':
                type(KeyEvent.VK_EQUALS);
                break;
            case '~':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE);
                break;
            case '!':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_1);
                break;
            case '@':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_2);
                break;
            case '#':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_3);
                break;
            case '$':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_4);
                break;
            case '%':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_5);
                break;
            case '^':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_6);
                break;
            case '&':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_7);
                break;
            case '*':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_8);
                break;
            case '(':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_9);
                break;
            case ')':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_0);
                break;
            case '_':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS);
                break;
            case '+':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_EQUALS);
                break;
            case '\t':
                type(KeyEvent.VK_TAB);
                break;
            case '\n':
                type(KeyEvent.VK_ENTER);
                break;
            case '[':
                type(KeyEvent.VK_OPEN_BRACKET);
                break;
            case ']':
                type(KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '\\':
                type(KeyEvent.VK_BACK_SLASH);
                break;
            case '{':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET);
                break;
            case '}':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '|':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH);
                break;
            case ';':
                type(KeyEvent.VK_SEMICOLON);
                break;
            case ':':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON);
                break;
            case '\'':
                type(KeyEvent.VK_QUOTE);
                break;
            case '"':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_QUOTE);
                break;
            case ',':
                type(KeyEvent.VK_COMMA);
                break;
            case '<':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA);
                break;
            case '.':
                type(KeyEvent.VK_PERIOD);
                break;
            case '>':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD);
                break;
            case '/':
                type(KeyEvent.VK_SLASH);
                break;
            case '?':
                type(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH);
                break;
            case ' ':
                type(KeyEvent.VK_SPACE);
                break;
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

    /**
     *
     * @param text
     */
    public void type(final String text) {
        int i = 0;
        while (i < text.length()) {
            type(text.charAt(i));
            i++;
        }
    }

    public void tab(int num) {
        while (num-- > 0) {
            type(KeyEvent.VK_TAB);
        }
    }

    public void ctrl(final int keyCode) {
        press(KeyEvent.VK_CONTROL);

        press(keyCode);
        release(keyCode);

        release(KeyEvent.VK_CONTROL);
    }

    public void alt(final int keyCode) {
        press(KeyEvent.VK_ALT);

        press(keyCode);
        release(keyCode);

        release(KeyEvent.VK_ALT);
    }

    public void shift(final int keyCode) {
        press(KeyEvent.VK_SHIFT);

        press(keyCode);
        release(keyCode);

        release(KeyEvent.VK_SHIFT);
    }

    public void enter() {
        type(KeyEvent.VK_ENTER);
    }

    /**
     *
     * @param nativeKeyCode
     * @return
     */
//    public static int getKey(int nativeKeyCode) {
//        switch (nativeKeyCode) {
//            case NativeKeyEvent.VK_A:
//                return (KeyEvent.VK_A);
//
//            case NativeKeyEvent.VK_B:
//                return (KeyEvent.VK_B);
//
//            case NativeKeyEvent.VK_C:
//                return (KeyEvent.VK_C);
//
//            case NativeKeyEvent.VK_D:
//                return (KeyEvent.VK_D);
//
//            case NativeKeyEvent.VK_E:
//                return (KeyEvent.VK_E);
//
//            case NativeKeyEvent.VK_F:
//                return (KeyEvent.VK_F);
//
//            case NativeKeyEvent.VK_G:
//                return (KeyEvent.VK_G);
//
//            case NativeKeyEvent.VK_H:
//                return (KeyEvent.VK_H);
//
//            case NativeKeyEvent.VK_I:
//                return (KeyEvent.VK_I);
//
//            case NativeKeyEvent.VK_J:
//                return (KeyEvent.VK_J);
//
//            case NativeKeyEvent.VK_K:
//                return (KeyEvent.VK_K);
//
//            case NativeKeyEvent.VK_L:
//                return (KeyEvent.VK_L);
//
//            case NativeKeyEvent.VK_M:
//                return (KeyEvent.VK_M);
//
//            case NativeKeyEvent.VK_N:
//                return (KeyEvent.VK_N);
//
//            case NativeKeyEvent.VK_O:
//                return (KeyEvent.VK_O);
//
//            case NativeKeyEvent.VK_P:
//                return (KeyEvent.VK_P);
//
//            case NativeKeyEvent.VK_Q:
//                return (KeyEvent.VK_Q);
//
//            case NativeKeyEvent.VK_R:
//                return (KeyEvent.VK_R);
//
//            case NativeKeyEvent.VK_S:
//                return (KeyEvent.VK_S);
//
//            case NativeKeyEvent.VK_T:
//                return (KeyEvent.VK_T);
//
//            case NativeKeyEvent.VK_U:
//                return (KeyEvent.VK_U);
//
//            case NativeKeyEvent.VK_V:
//                return (KeyEvent.VK_V);
//
//            case NativeKeyEvent.VK_W:
//                return (KeyEvent.VK_W);
//
//            case NativeKeyEvent.VK_X:
//                return (KeyEvent.VK_X);
//
//            case NativeKeyEvent.VK_Y:
//                return (KeyEvent.VK_Y);
//
//            case NativeKeyEvent.VK_Z:
//                return (KeyEvent.VK_Z);
//
//            case NativeKeyEvent.VK_BACK_QUOTE:
//                return (KeyEvent.VK_BACK_QUOTE);
//
//            case NativeKeyEvent.VK_0:
//                return (KeyEvent.VK_0);
//
//            case NativeKeyEvent.VK_1:
//                return (KeyEvent.VK_1);
//
//            case NativeKeyEvent.VK_2:
//                return (KeyEvent.VK_2);
//
//            case NativeKeyEvent.VK_3:
//                return (KeyEvent.VK_3);
//
//            case NativeKeyEvent.VK_4:
//                return (KeyEvent.VK_4);
//
//            case NativeKeyEvent.VK_5:
//                return (KeyEvent.VK_5);
//
//            case NativeKeyEvent.VK_6:
//                return (KeyEvent.VK_6);
//
//            case NativeKeyEvent.VK_7:
//                return (KeyEvent.VK_7);
//
//            case NativeKeyEvent.VK_8:
//                return (KeyEvent.VK_8);
//
//            case NativeKeyEvent.VK_9:
//                return (KeyEvent.VK_9);
//
//            case NativeKeyEvent.VK_MINUS:
//                return (KeyEvent.VK_MINUS);
//
//            case NativeKeyEvent.VK_EQUALS:
//                return (KeyEvent.VK_EQUALS);
//
//            case NativeKeyEvent.VK_TAB:
//                return (KeyEvent.VK_TAB);
//
//            case NativeKeyEvent.VK_ENTER:
//                return (KeyEvent.VK_ENTER);
//
//            case NativeKeyEvent.VK_OPEN_BRACKET:
//                return (KeyEvent.VK_OPEN_BRACKET);
//
//            case NativeKeyEvent.VK_CLOSE_BRACKET:
//                return (KeyEvent.VK_CLOSE_BRACKET);
//
//            case NativeKeyEvent.VK_BACK_SLASH:
//                return (KeyEvent.VK_BACK_SLASH);
//
//            case NativeKeyEvent.VK_SEMICOLON:
//                return (KeyEvent.VK_SEMICOLON);
//
//            case NativeKeyEvent.VK_QUOTE:
//                return (KeyEvent.VK_QUOTE);
//
//            case NativeKeyEvent.VK_COMMA:
//                return (KeyEvent.VK_COMMA);
//
//            case NativeKeyEvent.VK_PERIOD:
//                return (KeyEvent.VK_PERIOD);
//
//            case NativeKeyEvent.VK_SLASH:
//                return (KeyEvent.VK_SLASH);
//
//            case NativeKeyEvent.VK_SPACE:
//                return (KeyEvent.VK_SPACE);
//
//
//            case NativeKeyEvent.VK_CONTROL:
//                return (KeyEvent.VK_CONTROL);
//
//            case NativeKeyEvent.VK_ALT:
//                return (KeyEvent.VK_ALT);
//
//            case NativeKeyEvent.VK_SHIFT:
//                return (KeyEvent.VK_SHIFT);
//
//            default:
//                throw new IllegalArgumentException("Cannot type character " + nativeKeyCode);
//        }
//    }
    private String setClipboardContents(String aString) {
        StringSelection stringSelection = new StringSelection(aString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
        return aString;
    }

    public void copy(String text) {
        clipboardContent = setClipboardContents(text);
    }

    public void paste(String text) {
        copy(text);
        ctrl(this.V);
    }

    public void paste() {
        ctrl(this.V);
    }

    /**
     *
     * @param loop
     */
    public void loop(Loopable loop) {
        try {
            Scanner scanner;
            scanner = new Scanner(new File("C:\\data.txt"));
            while (scanner.hasNext()) {
                loop.loopCode(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger($$.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loop(Loopable loop, String path) {
        try {
            Scanner scanner;
            scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                loop.loopCode(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger($$.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loop(Loopable loop, File file) {
        try {
            Scanner scanner;
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                loop.loopCode(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger($$.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void takeSnap() {
        try {
            BufferedImage image = super.createScreenCapture(new Rectangle(0,
                    0,
                    Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height));
            ImageIO.write(image, "png", new File("C:\\SysImage\\nigga.png"));
        } catch (IOException ex) {
            Logger.getLogger($$.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param region stores the snapshot of the specified region
     */
    public void takeSnap(Rectangle region) {
        try {
            BufferedImage image = super.createScreenCapture(region);
            ImageIO.write(image, "png", new File("C:\\SysImage\\nigga.png"));
        } catch (IOException ex) {
            Logger.getLogger($$.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void lostOwnership(Clipboard clpbrd, Transferable t) {
    }
}

/*
 * 
 * Create code for looping
 */
interface Loopable{
    public void loopCode(String nextLine);
}