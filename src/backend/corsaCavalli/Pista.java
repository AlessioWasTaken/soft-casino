package backend.corsaCavalli;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This class used to create a logic
 */
public class Pista extends Thread {
    private final Cavallo primo;
    private final Cavallo secondo;
    private final Cavallo terzo;
    private final Cavallo quarto;
    private final Cavallo quinto;
    private final Thread primoT;
    private final Thread secondoT;
    private final Thread terzoT;
    private final Thread quartoT;
    private final Thread quintoT;
    private String Winner;
    private boolean Alive = true;

    /**
     * This constructor prepares horse and creates thread for any horse
     */
    public Pista() {
        primo = new Cavallo();
        secondo = new Cavallo();
        terzo = new Cavallo();
        quarto = new Cavallo();
        quinto = new Cavallo();

        primoT = new Thread(primo, "1");
        secondoT = new Thread(secondo, "2");
        terzoT = new Thread(terzo, "3");
        quartoT = new Thread(quarto, "4");
        quintoT = new Thread(quinto, "5");

        primoT.setPriority(6);
        secondoT.setPriority(6);
        terzoT.setPriority(6);
        quartoT.setPriority(6);
        quintoT.setPriority(6);
    }

    /**
     * This is a method run for thread to use to playing a game
     */
    public void run() {
        primoT.start();
        secondoT.start();
        terzoT.start();
        quartoT.start();
        quintoT.start();
        setPriority(MAX_PRIORITY);

        while (Stream.of(primoT, secondoT, terzoT, quartoT, quintoT).allMatch(Thread::isAlive)) {

        }

        if (!primoT.isAlive() && Alive) {
            try {
                wait(1000);
            } catch (Exception ignored) {
            }

            Winner = primoT.getName();
            Alive = false;
        } else if (!secondoT.isAlive() && Alive) {
            try {
                wait(1000);
            } catch (Exception ignored) {
            }

            Winner = secondoT.getName();
            Alive = false;
        } else if (!terzoT.isAlive()) {
            try {
                wait(1000);
            } catch (Exception ignored) {
            }

            Winner = terzoT.getName();
            Alive = false;
        } else if (!quartoT.isAlive() && Alive) {
            try {
                wait(1000);
            } catch (Exception ignored) {
            }

            Winner = quartoT.getName();
            Alive = false;
        } else if (!quintoT.isAlive() && Alive) {
            try {
                wait(1000);
            } catch (Exception ignored) {
            }

            Winner = quintoT.getName();
            Alive = false;
        }
    }

    public ArrayList<Cavallo> getCavallo() {
        ArrayList<Cavallo> cav = new ArrayList<>();
        cav.add(primo);
        cav.add(secondo);
        cav.add(terzo);
        cav.add(quarto);
        cav.add(quinto);
        return cav;
    }

    public String Win() {
        return Winner;
    }
}
