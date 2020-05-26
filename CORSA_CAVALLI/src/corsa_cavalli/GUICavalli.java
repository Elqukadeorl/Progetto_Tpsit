/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsa_cavalli;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Agron Qukaj
 */
class GUICavalli extends JPanel{
        int cordinatax;
        int cordinatay;
        Image img;
        public GUICavalli(int y, int x){
            cordinatax = 0;
            cordinatay = y;
            setSize(80, 90);
            Toolkit tk = Toolkit.getDefaultToolkit();
            switch (x){
                case 1: {img = tk.getImage("cavalli.JPG");}
                case 2: {img = tk.getImage("cavalli.JPG");}
                case 3: {img = tk.getImage("cavalli.JPG");}
                case 4: {img = tk.getImage("cavalli.JPG");}
                case 5: {img = tk.getImage("cavalli.JPG");}
                case 6: {img = tk.getImage("cavalli.JPG");}
            }
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(img, 1);      
        }
        public void setCordinatax(int a){
                cordinatax = a;
            }
        public int getCordinatax(){
                return cordinatax;
            }
}
