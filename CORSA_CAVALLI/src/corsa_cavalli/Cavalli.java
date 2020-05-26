/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsa_cavalli;

/**
 *
 * @author Agron Qukaj
 */
public class Cavalli implements Runnable{
    GUICavalli c;
    GCavalli campo;
    int velocita;
    Thread t;
    int cambio; //cambio di velocità
    int posizione; //posizione
    public Cavalli(GUICavalli c, GCavalli cam) {
		this.c = c;
                campo=cam;
                cambio = 0;
                velocita = 2;
                t = new Thread(this);
		t.start();
		posizione=0;
	}
    @Override
    public void run() {
        int dimImmagine=50;
        int dimPista=960;
            while((c.getCordinatax()+dimImmagine)<dimPista) {
                if ((cambio % 10) == 0)
                    velocita = (int)(Math.random()*4 + 1);
                c.setCordinatax(c.getCordinatax()+ velocita);
                cambio++;
                try{ 
                    Thread.sleep(75);
                }
                catch(Exception e){}
                campo.repaint();
                }
            posizione = campo.getPosizione();
            campo.arrivi();
        }
}