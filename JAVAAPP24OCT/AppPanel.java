import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.*;

import javax.swing.*;


public class AppPanel extends JPanel {
    BufferedImage bufferImage;
    Timer timer;
    int xAxis= 0;
    int yAxis= 0;
    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.GREEN);
        showBg();
        loopPaint();
        keyboardControl();
        setFocusable(true);
    }

    void showBg() {
        try {
            bufferImage = ImageIO.read(AppPanel.class.getResource("bg.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bufferImage, xAxis,yAxis,50,50, null);

    }


    void loopPaint(){
      timer = new Timer(50, (abcd)->{
        
       repaint();
      });  
      timer.start();
    }

    void keyboardControl(){
        System.out.println("KEYBOARD CALLED");
         addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("KEY PRESS CALLED");
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    xAxis = xAxis + 5;
                }


                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }
            
        });
    }
}
