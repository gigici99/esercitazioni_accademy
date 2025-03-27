package esercitazione.multimediale;

public abstract class ElementoMultimediale implements Riproducibile{
    public ElementoMultimediale(String titolo){
        this.titolo = titolo;
    }

    public ElementoMultimediale(String titolo, int durata){
        this.titolo = titolo;
        this.durata = durata;
    }

    //default
    public void play(){
        System.out.println("Riproduci un elemento multimediale: 1.Video; 2.Audio;");
    }

    //default
    public void show(){
        System.out.println("Mostra un'immagine.");
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    private String titolo;
    private int durata;
}
