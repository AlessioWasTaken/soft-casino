package backend.corsaCavalli;

import java.util.ArrayList;

public class Pista extends Thread{
    private Cavallo primo, secondo, terzo, quarto, quinto;
    Thread primoT, secondoT, terzoT, quartoT, quintoT;
    String Winner;
    boolean Alive=true;

    public Pista(){
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
    }

    public void run(){
        primoT.start();
        secondoT.start();
        terzoT.start();
        quartoT.start();
        quintoT.start();
        setPriority(MAX_PRIORITY);

        while(primoT.isAlive() && secondoT.isAlive() && terzoT.isAlive() && quartoT.isAlive() && quintoT.isAlive()){}

        System.out.println("Cavallo");

        if(primoT.isAlive() == false && Alive==true){
            try {
                wait(1000);
            } catch (Exception e) {}

            Winner=primoT.getName();
            Alive=false;
        }
        else if(secondoT.isAlive() == false && Alive==true){
            try {
                wait(1000);
            } catch (Exception e) {}

            Winner=secondoT.getName();
            Alive=false;
        }
        else if(terzoT.isAlive() == false){
            try {
                wait(1000);
            } catch (Exception e) {}

            Winner=terzoT.getName();
            Alive=false;
        }
        else if(quartoT.isAlive() == false && Alive==true){
            try {
                wait(1000);
            } catch (Exception e) {}

            Winner=quartoT.getName();
            Alive=false;
        }
        else if(quintoT.isAlive() == false && Alive==true){
            try {
                wait(1000);
            } catch (Exception e) {}

            Winner=quintoT.getName();
            Alive=false;
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
