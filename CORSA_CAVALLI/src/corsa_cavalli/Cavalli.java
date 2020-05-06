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
    Cavalli c;
    GCavalli campo;
    Thread t = new Thread(this);
    int posizione; //posizione
    public Cavalli(Cavalli c, GCavalli cam) {
		campo=cam;
		t.start();
		posizione=0;
	}
    public void run() {
        int dimImmagine=500;
        int dimPista=500;
            while((c.getCoordx()+dimImmagine)<dimPista) {
                c.setCoordx(c.getCoordx());
                campo.repaint();
                }
            posizione = campo.getPosizione();
        }
    private int getCoordx() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void setCoordx(int coord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
