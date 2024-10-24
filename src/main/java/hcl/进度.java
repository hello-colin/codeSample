package hcl;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class 进度 {


    public static void clear() throws AWTException
    {
        Robot r = new Robot();
        r.mousePress(InputEvent.BUTTON3_MASK);       // 按下鼠标右键
        r.mouseRelease(InputEvent.BUTTON3_MASK);    // 释放鼠标右键
        r.keyPress(KeyEvent.VK_CONTROL);             // 按下Ctrl键
        r.keyPress(KeyEvent.VK_R);                    // 按下R键
        r.keyRelease(KeyEvent.VK_R);                  // 释放R键
        r.keyRelease(KeyEvent.VK_CONTROL);            // 释放Ctrl键
        r.delay(100);
    }

    public static void main(String[] args) throws InterruptedException, AWTException {

//        for(int i=0;i<10;i++){
//            Thread.sleep(1000);
//            System.out.print('\r');
//            System.out.print(i);
//            System.out.print('%');
//        }


        String s1=
                "                       ******************                     \n\r" +
                "                   **************************                 \n\r" +
                "                  ****************************                \n\r" +
                "                   **************************                 \n\r" +
                "                     **********************                   \n\r" +
                "                        ****************                      \n\r" +
                "                             ******                           ";

        String s2=
                "                      *******      *******                    \n\r" +
                "                   ************  ************                 \n\r" +
                "                  ****************************                \n\r" +
                "                   **************************                 \n\r" +
                "                     **********************                   \n\r" +
                "                        ****************                      \n\r" +
                "                             ******                           ";
        System.out.println("\033[47;31m\033[5m");
        for(int i=0;i<100;i++){
            System.out.print(s1);
            Thread.sleep(1000);
            System.out.print("\033[H\033[2J"); // 某些终端支持此ANSI转义序列来清屏
            System.out.print(s2);
            System.out.print("\033[H\033[2J"); // 某些终端支持此ANSI转义序列来清屏
            System.out.print("\t");
        }

    }
}
