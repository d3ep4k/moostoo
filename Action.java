import java.util.*;
import java.io.*;
import java.awt.*;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
public class Action implements NativeKeyListener{
    private static $$ $;
    private static final  Action A = new Action();
    private Action(){
        try {$ = new $$();
        GlobalScreen.getInstance().addNativeKeyListener(this);
        }catch(java.awt.AWTException e){}}
    
    public static void main(String args[]){$.delay(2000);
            A.main();
            System.exit(0);
        
    }
/*****Script*****/
void main()
{
       recordedCode();

}

void recordedCode(){
    $.press(27,767,$.Button1);
    $.release(27,767,$.Button1);
    $.press(416,499,$.Button1);
    $.release(416,499,$.Button1);
    $.press(1144,108,$.Button1);
    $.release(1144,108,$.Button1);

}

public void keyPressed(NativeKeyEvent nke) {    
    if (nke.getKeyCode() == NativeKeyEvent.VK_F8) {     
        System.out.println("Process Aborted due to Interrupt.");
        System.exit(0);
     }  
   
}public void keyReleased(NativeKeyEvent nke) {}}
