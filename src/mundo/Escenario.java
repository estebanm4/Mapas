/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package mundo;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Escenario extends JPanel implements ActionListener {

    private int xrefC = 10;
    private int yrefC = 400;
    private int xrefO = 10;
    private int yrefO = 400;
    private int imagen = 0;
    private int animx;
    private int animy;
    private final int DELAY = 50;
    private Timer timer;
    
    
    public Escenario(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(this.DELAY, this);
        timer.start();
    }
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
       
    Image mapa = loadImage("fondo_mapa2_final.png");
        g.drawImage(mapa, 0, 0, 1280, 720, 0, 0, 640, 527, this);
    }

    //r1 = new Rectangle(xrefC, yrefC, WIDTH, imagen);

    @Override
    public void actionPerformed(ActionEvent e) {
        this.xrefC += 5;
        this.xrefO -= 5;
        this.animx += 1;
        
        if(this.imagen == 6){
            this.imagen = 0;
        } else{
            this.imagen ++;
        }
        
        
        repaint();
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    } 
    
    private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased (KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE){
                System.out.println("VK_SPACE");
            }
        }
    @Override
        public void keyPressed (KeyEvent e){
         //   ovalo.keyPressed(e);
        }
    
    
    }
}
