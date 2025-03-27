import esercitazione.multimediale.Audio;
import esercitazione.multimediale.ElementoMultimediale;
import esercitazione.multimediale.Immagine;
import esercitazione.multimediale.Video;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Inserisci file multimediali.");
        Scanner scan = new Scanner(System.in);
        ElementoMultimediale[] elementoMultimediale = new ElementoMultimediale[3];

        //inizio for per inserire file
        for(int i = 0; i<elementoMultimediale.length; i++){
            System.out.println("Scegli quale tipo di file vuoi inserire: 1.Video; 2.Immagine; 3.Audio.");
            int choice = scan.nextInt();

            switch (choice){
                //inserimento video
                case 1: {
                    System.out.println("Hai scelto di inserire un Video.");
                    System.out.println("Inserisci il titolo: ");
                    String titolo = scan.next();
                    System.out.println("Inserisci durata: ");
                    int durata = scan.nextInt();
                    System.out.println("Inserisci volume: ");
                    int volume = scan.nextInt();
                    System.out.println("Inserisci luminosita: ");
                    int luminosita = scan.nextInt();
                    elementoMultimediale[i] = new Video(titolo, durata, volume, luminosita);
                    break;
                }
                //inserimento immagine
                case 2: {
                    System.out.println("Hai scelto di inserire un Immagine.");
                    System.out.println("Inserisci il titolo: ");
                    String titolo = scan.next();
                    System.out.println("Inserisci luminosita: ");
                    int luminosita = scan.nextInt();
                    elementoMultimediale[i] = new Immagine(titolo, luminosita);
                    break;
                }
                //inserimento audio
                case 3: {
                    System.out.println("Hai scelto di inserire un Audio.");
                    System.out.println("Inserisci il titolo: ");
                    String titolo = scan.next();
                    System.out.println("Inserisci durata: ");
                    int durata = scan.nextInt();
                    System.out.println("Inserisci volume: ");
                    int volume = scan.nextInt();
                    elementoMultimediale[i] = new Audio(titolo, durata, volume);
                    break;
                }
                default: {
                    System.out.println("Inserisci un numero da 1 a 3");
                    break;
                }

            }
        }

        //mostra tutti gli elementi inseriti
        for(ElementoMultimediale el : elementoMultimediale) {
            if (el instanceof Video || el instanceof Audio)
                el.play();
            else
                el.show();
        }

        //ciclo infinito per mostrare agli utenti e decidere le scelte
        while (true) {
            System.out.println("Scegli quale file vuoi vedere: 1, 2, 3, 4, 5.\n0 per terminare");
            int choice = scan.nextInt();

            if (choice == 0) {
                System.out.println("E' stato un piacere!");
                return;
            } else {
                System.out.println("Hai scelto il file multimediale n: " + choice);
                //modifica il video
                if (elementoMultimediale[choice - 1] instanceof Video) {
                    System.out.println("Hai scelto un file video. 1.aumentare il volume\n2.diminuire il volume\n3.aumentare luminosita\n4.diminuire luminosita");
                    int choiceOption = scan.nextInt();
                    int value;
                    switch (choiceOption) {
                        //alza il volume
                        case 1: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Video) elementoMultimediale[choice - 1]).alzaVolume(value);
                            break;
                        }
                        //abbassa il volume
                        case 2: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Video) elementoMultimediale[choice - 1]).abbassaVolume(value);
                            break;
                        }
                        //aumenta la luminosita
                        case 3: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Video) elementoMultimediale[choice - 1]).aumentaLuminosita(value);
                            break;
                        }
                        //abbassa luminosita
                        case 4: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Video) elementoMultimediale[choice - 1]).diminuisciLuminosita(value);
                            break;
                        }
                        default:
                            break;
                    }
                    // scelta di un immagine
                } else if (elementoMultimediale[choice - 1] instanceof Immagine) {
                    System.out.println("Hai scelto un file Immagine. 1.aumentare luminosita\n2.diminuire luminosita");
                    int choiceOption = scan.nextInt();
                    int value;
                    switch (choiceOption) {
                        //aumenta luminosita
                        case 1: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Immagine) elementoMultimediale[choice - 1]).aumentaLuminosita(value);
                            break;
                        }
                        //diminuisci luminosita
                        case 2: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Immagine) elementoMultimediale[choice - 1]).diminuisciLuminosita(value);
                            break;
                        }
                        default:
                            break;
                    }
                    //inserisce audio
                } else if (elementoMultimediale[choice - 1] instanceof Audio) {
                    System.out.println("Hai scelto un file Audio. 1.aumentare volume\n2.diminuire volume");
                    int choiceOption = scan.nextInt();
                    int value;
                    switch (choiceOption) {
                        //alza il volume
                        case 1: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Audio) elementoMultimediale[choice - 1]).alzaVolume(value);
                            break;
                        }
                        //abbassa il volume
                        case 2: {
                            System.out.println("Di quanto?");
                            value = scan.nextInt();
                            ((Audio) elementoMultimediale[choice - 1]).abbassaVolume(value);
                            break;
                        }
                        default:
                            break;
                    }
                }
            }
        }
    }
}