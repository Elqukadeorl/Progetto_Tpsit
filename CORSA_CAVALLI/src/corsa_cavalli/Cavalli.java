package corsa_cavalli;

/**
 *
 * @author Adriano Qukaj
 */
public class Cavalli implements Runnable{
    GUICavalli c;
    GCavalli campo;
    int velocita;
    Thread t;
    int cambio; //cambio di velocità
    int posizione; //posizione
    /**
     * 
     * @param c contiene la posizione di partenza e il numero della corsia
     * @param cam contiene il Thread dove sono presenti le immagini dei cavalli e contiene il campo
     */
    public Cavalli(GUICavalli c, GCavalli cam) {
		this.c = c;
                campo=cam;
                cambio = 0;
                velocita = 2;
                t = new Thread(this);
		t.start();
		posizione=0;
	}
    /**
     * metodo che permette lo spostamento dei cavalli
     */
    @Override
    public void run() {
        int dimImmagine=80;
        int dimPista=1120;
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