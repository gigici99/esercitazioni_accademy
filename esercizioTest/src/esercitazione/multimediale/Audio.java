package esercitazione.multimediale;

import esercitazione.exception.VolumeException;

public class Audio extends ElementoMultimediale implements Riproducibile{

    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata);

        if (volume <= 0)
            throw new VolumeException("Il volume deve essere un valore positivo.");
        this.volume = volume;
    }

    //funzione per aumentare volume
    public void alzaVolume(int valore){
        volume = volume + valore;
        setVolume(volume);
    }

    //funzione per abbassa volume
    public void abbassaVolume(int valore){
        volume = volume - valore;
        setVolume(volume);
    }

    //avvia
    @Override
    public void play() {
        System.out.println("Audio in modalità play!");
        //recupero il titolo
        String titolo = getTitolo();
        //inizializzo una variabile tipo string per i punti "!"
        String puntoEsclamativo = "";
        String carattere = "!";
        //Recupera il volume.
        volume = getVolume();

        for (int i = 0; i < volume; i++) {
            puntoEsclamativo += carattere;  // Concatenazione
        }

        for(int i=0; i<getDurata(); i++)
            System.out.println(titolo + puntoEsclamativo);
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

    //deve essere sempre positivo
    private int volume;
}
