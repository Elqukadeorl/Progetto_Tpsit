package corsa_cavalli;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author Agron Qukaj
 * Classe che assegna l'immagine del cavallo ad ogni thread
 * 
 */
class GUICavalli extends JPanel{
        int cordinatax;
        int cordinatay;
        Image img;
        /**
         * 
         * @param y posizione di partenza
         * @param x numero del cavallo
         */
        public GUICavalli(int y, int x){
            cordinatax = 0;
            cordinatay = y;
            setSize(80, 90);
            Toolkit tk = Toolkit.getDefaultToolkit();
            MediaTracker mt = new MediaTracker(this);
           try { 
             switch(x)
        {
            //tutti i cavalli sono diversi
            //posiziono ogni cavallo nella sua posizione
            case 1: {
                
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));  
            break;
            }
            case 2: {
               
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));
            break;
            }
            case 3: {
              
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));
            break;
            }
            case 4: {
              
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));
            break;
            }
            case 5: {
               
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg")); 
            break;
            }
            case 6: {
               
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));
            break;
            }
            case 7: {
               
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));   
            break;
            }
            case 8: {
               
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg")); 
            break;
            }
            case 9: {
              
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));    
            break;
            }
            case 10: {
               
            img = ImageIO.read(getClass().getResource("cavallo/cavalli.jpg"));
            break;
            }
        }
            mt.addImage(img, 0);
                try {
                    mt.waitForID(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUICavalli.class.getName()).log(Level.SEVERE, null, ex);
                }
           } catch (IOException ex) {
                    Logger.getLogger(GUICavalli.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        /**
         * 
         * @param a per settare la cordinata
         */
        public void setCordinatax(int a){
                cordinatax = a;
            }
        /**
         * 
         * @return la cordinata
         */
        public int getCordinatax(){
                return cordinatax;
            }
        /**
         *
         * @param g per disegnare il corridore  
         */
        @Override
        public void paint(Graphics g){
           g.drawImage(img, cordinatax, cordinatay , null);
        }
}
