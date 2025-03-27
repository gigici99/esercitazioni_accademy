package esercitazione.multimediale;

import esercitazione.exception.LuminositaException;

public class Immagine extends ElementoMultimediale implements Riproducibile{

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        if(luminosita<=0)
            throw new LuminositaException("Il valore della luminosità non può essere negativo");
        this.luminosita = luminosita;
    }

    //funzione per aumentare la luminosita
    public void aumentaLuminosita(int valore){
        luminosita = luminosita + valore;
        setLuminosita(luminosita);
    }

    //funzione per diminuire la luminosita
    public void diminuisciLuminosita(int valore){
        luminosita = luminosita - valore;
        setLuminosita(luminosita);
    }

    @Override
    public void play() {

    }

    //mostra
    @Override
    public void show() {
        System.out.println("Immagine in modalità show!");
        //recupero il titolo
        String titolo = getTitolo();

        //inizializzo variabile tipo string per gli "*"
        String asterisco = "";
        String carattereAsterisco = "*";

        //Recupero la luminosita
        luminosita = getLuminosita();


        for (int i = 0; i < luminosita; i++) {
            asterisco += carattereAsterisco;  // Concatenazione
        }

        System.out.println(titolo + asterisco);
    }

    public int getLuminosita() {
        return luminosita;
    }

    private void setLuminosita(int luminosita) {
        if (luminosita <= 0)
            throw new LuminositaException("La luminosità deve essere positiva.");
        this.luminosita = luminosita;
    }

    private int luminosita;
}
