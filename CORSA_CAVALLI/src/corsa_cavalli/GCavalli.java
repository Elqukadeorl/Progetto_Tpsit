package corsa_cavalli;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Adriano Qukaj
 */
public class GCavalli extends JFrame{
    int posizione;
    GUICavalli[] partecipanti;
    Cavalli[] threadpartecipanti;
    Campo corsia;
    Graphics offscreen;           
    Image buffer_virtuale;
	/**
         * 
         * Il costruttore definisce la dimensione della pista e crea 10 cavalli e li assegna alla loro corsia
         */
	public GCavalli() { //costruttore
		super("Gara di cavalli");
		setSize(1100, 750); //grandezza della finestra
                setLocation(15, 45);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		corsia = new Campo();
		partecipanti = new GUICavalli[10];
		threadpartecipanti = new Cavalli[10];
                posizione = 1;
                /**
                 * @param partenza rappresenta la posizione di partenza e viene incrementata per inserire i cavalli nei loro posti di partenza
                 */
		int partenza = 20; //posizione di partenza
		for (int i=0; i<10; i++) { //inizio corsa
			partecipanti[i] = new GUICavalli(partenza,  i + 1);
			threadpartecipanti[i] = new Cavalli(partecipanti[i], this);
                        partenza= partenza + 70;
		}
		this.add(corsia); //aggiungo la corsia
                setVisible(true);
	}
        /**
         * metodo che ritorna la posizione
         * @return la posizione del cavallo
         */
        public synchronized int getPosizione() { //ritorna la posizione
            return posizione++;
        }
	/**
         * metodo per verificare che il Thread sia arrivato
         */
	public synchronized void arrivi() {
		boolean arrivato = true; // variabile per segnare se il thread è arrivato
		for (int x=0; x<10; x++) {
			if (threadpartecipanti[x].posizione == 0) { //controlla se il thread è arrivato
				arrivato = false;		
                        }
		}
                if(arrivato){
                    visualizzaClassifica();
                }
	}
        /**
         * metodo che visualizza la Classifica
         */
        public void visualizzaClassifica(){
            JLabel[] arrivi;
            arrivi = new JLabel[10];
            JFrame classifica = new JFrame("Classifica");
            classifica.setSize(500, 500);
            classifica.setLocation(280, 180);
            classifica.setBackground(Color.BLUE);
            classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
            classifica.getContentPane().setLayout(new GridLayout(5,1));
            for(int x = 1; x < 11; x++){
                for(int i = 0; i < 10; i++){
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
    @Override
        public void update(Graphics g)
    {
        paint(g);
    }

    /**
     *
     * @param g per migliorare l'immagine quando si sposta
     */
    @Override
    public void paint(Graphics g){
       if(partecipanti != null)
        {
            Graphics2D screen = (Graphics2D)g;
            buffer_virtuale = createImage(1140,740);
            offscreen = buffer_virtuale.getGraphics();
            Dimension d = getSize();
            corsia.paint(offscreen);
            for(int i=0; i<10; i++)
            {
                partecipanti[i].paint(offscreen);
            }
            screen.drawImage(buffer_virtuale, 0, 25, this);
            offscreen.dispose();
        }
    }
}
