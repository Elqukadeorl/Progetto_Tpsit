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
public class GCavalli extends JFrame{
    int posizione;
    GUICavalli[] partecipanti;
    Cavalli[] threadpartecipanti;
    Campo corsia;
	
	public GCavalli() { //costruttore
		super("Gara di cavalli");
		setSize(1000, 700); //grandezza della finestra
                setLocation(15, 45);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		corsia = new Campo();
		partecipanti = new GUICavalli[5];
		threadpartecipanti = new Cavalli[5];
                posizione = 1;
                
		int partenza = 20; //posizione di partenza
		for (int i=0; i<5; i++) { //inizio corsa
			partecipanti[i] = new GUICavalli(partenza,  i + 1);
			threadpartecipanti[i] = new Cavalli(partecipanti[i], this);
                        partenza = partenza + 100;
		}
		this.add(corsia); //aggiungo la corsia
                setVisible(true);
	}
        
        public synchronized int getPosizione() { //ritorna la posizione
            return posizione++;
        }
	
	public synchronized void arrivi() {
		boolean arrivato = true; // variabile per segnare se il thread è arrivato
		for (int x=0; x<5; x++) {
			if (threadpartecipanti[x].posizione == 0) { //controlla se il thread è arrivato
				arrivato = false;		
                        }
		}
                if(arrivato){
                    visualizzaClassifica();
                }
	}
        public void visualizzaClassifica(){
            JLabel[] arrivi;
            arrivi = new JLabel[5];
            JFrame classifica = new JFrame("Classifica");
            classifica.setSize(500, 500);
            classifica.setLocation(280, 180);
            classifica.setBackground(Color.BLUE);
            classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
            classifica.getContentPane().setLayout(new GridLayout(5,1));
            for(int x = 1; x < 6; x++){
                for(int i = 0; i < 5; i++){
                    if(threadpartecipanti[i].posizione == x){
                        arrivi[i] = new JLabel (x + " classificato. Il cavallo nella corsia numero "+ (i+1));
                        arrivi[i].setFont(new Font("Arial", Font.ITALIC, 18));
                        arrivi[i].setForeground(Color.BLUE);
                        classifica.getContentPane().add(arrivi[i]);
                    }
                }
            }
            classifica.setVisible(true);
        }
}
