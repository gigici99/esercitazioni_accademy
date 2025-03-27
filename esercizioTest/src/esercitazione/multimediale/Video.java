package esercitazione.multimediale;

import esercitazione.exception.LuminositaException;
import esercitazione.exception.VolumeException;

public class Video extends ElementoMultimediale implements Riproducibile{

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata);
        if (volume <= 0)
            throw new VolumeException("Il volume deve essere un valore positivo.");
        this.volume = volume;
        if (luminosita <= 0)
            throw new LuminositaException("La luminosità deve essere positiva.");
        this.luminosita = luminosita;
    }

    //funzione per aumentare volume
    public void alzaVolume(int valore){
        volume = volume + valore;
        setVolume(volume);
    }

    //funzione per diminuire il volume
    public void abbassaVolume(int valore){
        volume = volume - valore;
        setVolume(volume);
    }

    //funzione per aumentare la luminosita
    public void aumentaLuminosita(int valore){
        luminosita = luminosita + valore;
        setLuminosita(luminosita);
    }

    //funzione per diminuire luminosita
    public void diminuisciLuminosita(int valore){
        luminosita = luminosita - valore;
        setLuminosita(luminosita);
    }

    //avvia il video
    @Override
    public void play() {
        System.out.println("Video in modalità play!");
        //recupero il titolo
        String titolo = getTitolo();
        //inizializzo una variabile tipo string per i punti "!"
        String puntoEsclamativo = "";
        String caratterePunto = "!";

        //inizializzo variabile tipo string per gli "*"
        String asterisco = "";
        String carattereAsterisco = "*";

        //Recupera il volume.
        volume = getVolume();
        //Recupero la luminosita
        luminosita = getLuminosita();

        for (int i = 0; i < volume; i++) {
            puntoEsclamativo += caratterePunto;  // Concatenazione
        }

        for (int i = 0; i < luminosita; i++) {
            asterisco += carattereAsterisco;  // Concatenazione
        }

        for(int i=0; i<getDurata(); i++)
            System.out.println(titolo + puntoEsclamativo + asterisco);
    }

    @Override
    public void show() {
    }

    public int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        if(volume <= 0)
            throw new VolumeException("Il volume deve avere un valore positivo");
        this.volume = volume;
    }

    public int getLuminosita() {
        return luminosita;
    }

    private void setLuminosita(int luminosita) {
        if (luminosita <= 0)
            throw new LuminositaException("La luminosità deve essere positiva.");
        this.luminosita = luminosita;
    }

    private int volume;
    private int luminosita;
}
