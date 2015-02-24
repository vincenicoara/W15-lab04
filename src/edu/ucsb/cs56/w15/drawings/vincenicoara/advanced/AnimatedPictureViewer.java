package edu.ucsb.cs56.w15.drawings.vincenicoara.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private FaceWithFancyMustache face = new FaceWithFancyMustache(100, 100, 100, 17, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int eyeR = 18;
    private int arcH = 100;
    private int lMustache = 45;
    private int rMustache =  155; 
    //private int xMustache = 100;
    //private int yMustache = 100; 
    //private double mouthYCoordinate = (100 + 100/3);
    //private Double mustacheLine = new Double (x-(100/2) - x/20, mouthYCoordinate - 100/15
    //          , x+(100/2) + x/20, mouthYCoordinate - 100/15);

    
    private int dx = 5;
    private int dEyeR = 1; 

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Ipod
          g2.setColor(Color.RED);
          FaceWithFancyMustache test = new FaceWithFancyMustache(x, y, 100, eyeR, arcH, lMustache, rMustache);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          //double leftPoint = x-(100/2) - x/20;
          //double rightPoint = x+(100/2) - x/20;
          //double distance = leftPoint - rightPoint;
          int upperLimit = 20;
          int lowerLimit = 5;
          boolean signalA = true;
          boolean signalB = true;
          boolean signalLeft = true;
          boolean signalRight = true;

          while (true) {
            // Bounce off the walls

            if (x >= 400) { 
              dx = -5;              
            }
            if (x <= 50) {
              dx = 5;
            }
            if (signalA){
              eyeR++;
            } else {
              eyeR--;
            }
            if (signalB){
              arcH -= 1;
            } else {
              arcH += 1;
            }
            if (signalLeft){
              lMustache -= 5;
            } else {
              lMustache =+ 5;
            }
            if (signalRight){
              rMustache += 5;
            } else {
              rMustache -= 5;
            }
            if (arcH == 80) signalB = false;
            if (arcH == 100) signalB = true;
            if (eyeR == upperLimit) signalA = false;
            if (eyeR == lowerLimit) signalA = true;
            if (lMustache == 4) signalLeft = false;
            if (rMustache == 196) signalRight = false;
          
            
            x += dx;  
            eyeR = eyeR;  
            arcH = arcH;            
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
