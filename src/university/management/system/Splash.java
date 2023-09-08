package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1050, 700, Image.SCALE_FAST);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true);

        Thread t = new Thread(this);
        t.start();

        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            setLocation(600 - ((i + x) /2 +100), 350 - (i / 2)-55);
            setSize(i + 3 * x, i + x / 2);
            try {
                Thread.sleep(5);
            }catch (Exception e){}
        }
    }

    public static void main(String[] args) {
        new Splash();

    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            //setVisible(false);
            dispose();

            // Next Frame
            new Login();
        } catch (Exception e) {

        }
    }
}
