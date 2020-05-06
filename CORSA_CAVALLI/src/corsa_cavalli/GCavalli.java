/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsa_cavalli;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Agron Qukaj
 */
public class GCavalli extends JFrame{
    int posizione=1;
	GUICavalli[] partecipanti;
	Cavalli[] threadpartecipanti;
	Campo corsia;
	
	public GCavalli() { //costruttore
		super("Gara di equitazione");
		setSize(500, 500); //grandezza della finestra
		corsia = new Campo();
		partecipanti = new GUICavalli[5];
		threadpartecipanti = new Cavalli[5];
                
		int partenza = 20; //posizione di partenza
		/*for (int i=0; i<5; i++) { //inizio corsa
			partecipanti[i] = new GUICavalli(partenza,  i + 1);
			threadpartecipanti[i] = new Cavalli(partecipanti[i], this);		
		}
		this.add(corsia); //aggiungo la corsia
		setVisible(true);*/
	}
        
        public synchronized int getPosizione() { //ritorna la posizione
            return posizione;
        }
	
	public synchronized void arrivi() {
		boolean arrivato = true; // variabile per segnare se il thread è arrivato
		for (int x=0; x<5; x++) {
			if (threadpartecipanti[x].posizione == 0) { //controlla se il thread è arrivato
				arrivato = false;
			}
		}
	}
        public static void main(String[] a) {
		GCavalli g = new GCavalli();
	}

    private void add(Campo corsia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
