package backend.corsaCavalli;

import java.util.ArrayList;

public class Pista extends Thread{
    private Cavallo primo, secondo, terzo, quarto, quinto;
    Thread primoT, secondoT, terzoT, quartoT, quintoT;

    public Pista(){
        primo = new Cavallo();
        secondo = new Cavallo();
        terzo = new Cavallo();
        quarto = new Cavallo();
        quinto = new Cavallo();

        primoT = new Thread(primo);
        secondoT = new Thread(secondo);
        terzoT = new Thread(terzo);
        quartoT = new Thread(quarto);
        quintoT = new Thread(quinto);
    }

    public void run(){

        setPriority(MAX_PRIORITY);

        while(primoT.isAlive() && secondoT.isAlive() && terzoT.isAlive() && quartoT.isAlive() && quintoT.isAlive()){}

        System.out.println("Cavallo");

        if(primoT.isAlive() == false){
            try {
                wait(1000);
            } catch (Exception e) {}

            System.out.println(primoT.getId());
        }
        else if(secondoT.isAlive() == false){
            try {
                wait(1000);
            } catch (Exception e) {}

            System.out.println(secondoT.getId());
        }
        else if(terzoT.isAlive() == false){
            try {
                wait(1000);
            } catch (Exception e) {}

            System.out.println(terzoT.getId());
        }
        else if(quartoT.isAlive() == false){
            try {
                wait(1000);
            } catch (Exception e) {}

            System.out.println(quartoT.getId());
        }
        else if(quintoT.isAlive() == false){
            try {
                wait(1000);
            } catch (Exception e) {}

            System.out.println(quintoT.getId());
        }
    }

    public ArrayList<Cavallo> getCavallo(){
        ArrayList<Cavallo> cav = new ArrayList<>();
        cav.add(primo);
        cav.add(secondo);
        cav.add(terzo);
        cav.add(quarto);
        cav.add(quinto);
        return cav;
    }
}
