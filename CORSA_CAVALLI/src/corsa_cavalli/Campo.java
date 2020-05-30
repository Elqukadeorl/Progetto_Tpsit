package corsa_cavalli;
import javax.swing.*;
import java.awt.*;

/**
 *
 *@author Adriano Qukaj
 * classe che crea il campo
 */
class Campo extends JPanel{
    
    /**
     *
     * @param g Variabile utilizzata per creare il campo con le varie corsie
     */
    @Override
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(0, 0, 1140, 700);
        g.setColor(Color.white);
        g.fillRect(0, 70, 1140, 10);
        g.fillRect(0, 140, 1140, 10);
        g.fillRect(0, 210, 1140, 10);
        g.fillRect(0, 280, 1140, 10);
        g.fillRect(0, 350, 1140, 10);
        g.fillRect(0, 420, 1140, 10);
        g.fillRect(0, 490, 1140, 10);
        g.fillRect(0, 560, 1140, 10);
        g.fillRect(0, 630, 1140, 10);
        g.fillRect(1100, 0, 5, 700);
        g.fillRect(1110, 0, 5, 700);
        g.fillRect(1120, 0, 5, 700);
    }
}
