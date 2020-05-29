package corsa_cavalli;

import java.util.Scanner;

/**
 *
 * @author Adriano Qukaj
 */
public class CORSA_CAVALLI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cavalliGara = 0;
        do{
            System.out.println("inserisci il numero di cavalli che vuoi far gareggiare");
            Scanner input = new Scanner(System.in);
            cavalliGara = input.nextInt();
            if(cavalliGara < 2 || cavalliGara > 10){
                System.out.println("puoi al massimo inserire 10 cavalli e minimo 2");
            }
        }while(cavalliGara < 2 || cavalliGara > 10);
        Scanner input = new Scanner(System.in);
        GCavalli g = new GCavalli(cavalliGara);
    } 
}
