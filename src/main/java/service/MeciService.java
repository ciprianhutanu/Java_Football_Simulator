package service;

import config.Audit;
import models.*;
import persistence.EchipaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MeciService {
    private Audit audit = Audit.getInstance();
    private EchipaRepository echipaRepo = EchipaRepository.getInstance();
    private Random random = new Random();

    public void SimulareMeci(Meci meci, boolean sariLaRezultat, boolean cuAfisare){
        Echipa echipa1 = meci.getEchipaAcasa();
        Echipa echipa2 = meci.getEchipaDeplasare();

        int scorEchipa1 = 0;
        int scorEchipa2 = 0;
        int probGolEchipa1, probGolEchipa2;

        double ovrEchipa1 = echipaRepo.calculareOvrEchipa(echipa1);
        double ovrEchipa2 = echipaRepo.calculareOvrEchipa(echipa2);

        if(ovrEchipa1 > ovrEchipa2){
            probGolEchipa1 = (int)((ovrEchipa1 - ovrEchipa2) / 5) + 2;
            probGolEchipa2 = 1;
        }
        else{
            probGolEchipa1 = 1;
            probGolEchipa2 = (int)((ovrEchipa2 - ovrEchipa1) / 5) + 2;
        }
        if(cuAfisare){
            System.out.println(echipa1.getAbreviereEchipa() + "        -        " + echipa2.getAbreviereEchipa());
            System.out.println("-----------------------");
        }


        for(int minut = 0; minut <= 90; minut++){
            if(!sariLaRezultat){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignored){

                }
            }
            int eveniment = random.nextInt(100);
            if(eveniment <= 1){
                if(probGolEchipa1 == 1){
                    Jucator marcator = selectareMarcator(echipa1);
                    scorEchipa1++;

                    if(cuAfisare) {
                        System.out.println(minut + "' GOL [" + scorEchipa1 + "] - " + scorEchipa2 + " -> " + marcator.getNume());
                    }

                }
                else{
                    Jucator marcator = selectareMarcator(echipa2);
                    scorEchipa2++;

                    if(cuAfisare){
                        System.out.println(minut + "' GOL " + scorEchipa1 + " - [" + scorEchipa2 + "]" + " -> " + marcator.getNume());
                    }

                }
            }
            else if(eveniment <= Math.max(probGolEchipa1, probGolEchipa2)){
                if (probGolEchipa1 == Math.max(probGolEchipa1, probGolEchipa2)){
                    Jucator marcator = selectareMarcator(echipa1);
                    scorEchipa1++;

                    if(cuAfisare) {
                        System.out.println(minut + "' GOL [" + scorEchipa1 + "] - " + scorEchipa2 + " -> " + marcator.getNume());
                    }

                }
                else{
                    Jucator marcator = selectareMarcator(echipa2);
                    scorEchipa2++;

                    if(cuAfisare){
                        System.out.println(minut + "' GOL " + scorEchipa1 + " - [" + scorEchipa2 + "]" + " -> " + marcator.getNume());
                    }

                }
            }
        }

        if(cuAfisare){
            System.out.println("-----------------------");
        }

        System.out.println("Scor final: " + echipa1.getNumeEchipa() + " " + scorEchipa1 + " - " + scorEchipa2 + " " + echipa2.getNumeEchipa());

        if(scorEchipa1 > scorEchipa2){
            echipaRepo.calcularePuncte(echipa1,'V',scorEchipa1 - scorEchipa2);
            echipaRepo.calcularePuncte(echipa2,'I', scorEchipa2 - scorEchipa1);
        }else if(scorEchipa2 > scorEchipa1){
            echipaRepo.calcularePuncte(echipa1,'I',scorEchipa1 - scorEchipa2);
            echipaRepo.calcularePuncte(echipa2,'V', scorEchipa2 - scorEchipa1);
        }else{
            echipaRepo.calcularePuncte(echipa1,'E',0);
            echipaRepo.calcularePuncte(echipa2,'E', 0);
        }

        audit.write("Meci simulat", echipa1.getNumeEchipa() + " " + scorEchipa1 + " - " + scorEchipa2 + " " + echipa2.getNumeEchipa());
    }

    public Jucator selectareMarcator(Echipa echipa){
        List<Jucator> potentialiMarcatori = new ArrayList<>();
        while(potentialiMarcatori.isEmpty()){
            for(Jucator jucator : echipa.getListaJucatori()){
                if(random.nextInt(100) < getProbabilitateGolJucator(jucator)){
                    potentialiMarcatori.add(jucator);
                }
            }
        }
        return potentialiMarcatori.get(random.nextInt(potentialiMarcatori.size()));
    }

    public int getProbabilitateGolJucator(Jucator jucator){
        if(jucator instanceof Atacant){
            return 2 * (int)jucator.getOvr();
        }
        if(jucator instanceof Mijlocas){
            return (int)(jucator.getOvr()/2);
        }
        if (jucator instanceof Aparator){
            return (int)(jucator.getOvr()/4);
        }
        return 1;
    }

}
