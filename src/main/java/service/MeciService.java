package service;

import models.*;
import persistence.EchipaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MeciService {
    private EchipaRepository echipaRepo = new EchipaRepository();
    private Random random = new Random();
    public void SimulareMeci(Meci meci, boolean sariLaRezultat){
        Echipa echipa1 = meci.getEchipaAcasa();
        Echipa echipa2 = meci.getEchipaDeplasare();

        int scorEchipa1 = 0;
        int scorEchipa2 = 0;
        int probGolEchipa1, probGolEchipa2;

        double ovrEchipa1 = echipaRepo.calculareOvrEchipa(echipa1);
        double ovrEchipa2 = echipaRepo.calculareOvrEchipa(echipa2);

        if(ovrEchipa1 > ovrEchipa2){
            probGolEchipa1 = (int)((ovrEchipa1 - ovrEchipa2) / 10) + 4;
            probGolEchipa2 = 2;
        }
        else{
            probGolEchipa1 = 2;
            probGolEchipa2 = (int)((ovrEchipa2 - ovrEchipa1) / 10) + 4;
        }

        System.out.println(echipa1.getAbreviereEchipa() + "\t-\t" + echipa2.getAbreviereEchipa());
        System.out.println("-----------------------");

        for(int minut = 0; minut <= 90; minut++){
            if(!sariLaRezultat){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignored){

                }
            }
            int eveniment = random.nextInt(100);
            if(eveniment <= 2){
                if(probGolEchipa1 == 2){
                    Jucator marcator = selectareMarcator(echipa1);
                    scorEchipa1++;
                    System.out.println(minut + "' GOL [" + scorEchipa1 + "] - " + scorEchipa2 + " -> " + marcator.getNume());
                }
                else{
                    Jucator marcator = selectareMarcator(echipa2);
                    scorEchipa2++;
                    System.out.println(minut + "' GOL " + scorEchipa1 + " - [" + scorEchipa2 + "]" + " -> " + marcator.getNume());
                }
            }
            else if(eveniment < Math.max(probGolEchipa1, probGolEchipa2)){
                if (probGolEchipa1 == Math.max(probGolEchipa1, probGolEchipa2)){
                    Jucator marcator = selectareMarcator(echipa1);
                    scorEchipa1++;
                    System.out.println(minut + "' GOL [" + scorEchipa1 + "] - " + scorEchipa2 + " -> " + marcator.getNume());
                }
                else{
                    Jucator marcator = selectareMarcator(echipa2);
                    scorEchipa2++;
                    System.out.println(minut + "' GOL " + scorEchipa1 + " - [" + scorEchipa2 + "]" + " -> " + marcator.getNume());
                }
            }
        }

        System.out.println("-----------------------");
        System.out.println("Scor final: " + echipa1.getAbreviereEchipa() + " " + scorEchipa1 + " - " + scorEchipa2 + " " + echipa2.getAbreviereEchipa());
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
