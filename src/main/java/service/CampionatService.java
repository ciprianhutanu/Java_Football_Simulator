package service;

import compare.EchipaComparator;
import models.Campionat;
import models.Echipa;
import models.Meci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampionatService {
    private EchipaService echipaService = new EchipaService();
    private MeciService meciService = new MeciService();
    private List<List<Meci>> etape = new ArrayList<>();

    private static final int numarEchipe = 8;
    private int numarEtapa = 0;

    public Campionat generareLigaInteractiva(String denumire, Echipa echipaDeUrmarit){
        List<Echipa> echipe = echipaService.generareEchipe(numarEchipe - 1);
        echipe.add(0, echipaDeUrmarit);

        Campionat campionat = new Campionat(denumire, echipe.toArray(new Echipa[0]));

        etape = generareEtape(echipe);

        return campionat;
    }

    public List<List<Meci>> generareEtape(List<Echipa> echipe){
        List<List<Meci>> etapeGenerate = new ArrayList<>();

        int numEtape = numarEchipe - 1;

        for(int numarEtapa = 0; numarEtapa < numEtape; numarEtapa++){
            List<Meci> meciuriEtapa = new ArrayList<>();
            for(int i = 0; i < numarEchipe / 2; i++){
                meciuriEtapa.add(new Meci(echipe.get(i), echipe.get(numarEchipe - 1 - i)));
            }
            etapeGenerate.add(meciuriEtapa);

            Echipa ultimaEchipa = echipe.remove(numarEchipe - 1);
            echipe.add(1, ultimaEchipa);
        }

        return etapeGenerate;
    }

    public void simulareEtapa(boolean sariLaRezultat){
        if(numarEtapa == numarEchipe - 1){
            System.out.println("Campionat terminat!");
            return;
        }
        meciService.SimulareMeci(etape.get(numarEtapa).get(0),sariLaRezultat,true);

        System.out.println("\nRestul meciurilor din etapa: ");

        for(int i = 1; i < numarEchipe / 2; i++){
            meciService.SimulareMeci(etape.get(numarEtapa).get(i),true,false);
        }
        numarEtapa++;
    }

    public void afisareClasament(Campionat campionat){
        Echipa [] echipe = campionat.getEchipe();

        Arrays.sort(echipe, new EchipaComparator());

        System.out.println(campionat.getDenumire());
        System.out.println("Nume |\tP\t|\tV\t|\tE\t|\tI\t|\tGD");

        for(Echipa echipa:echipe){
            System.out.println(echipa.getAbreviereEchipa()+"\t \t"+echipa.getPuncte()+"\t \t"+echipa.getVictorii()+"\t \t"+echipa.getEgaluri()
                    +"\t \t"+echipa.getInfrangeri()+"\t \t"+echipa.getGolaveraj());
        }
    }
}
