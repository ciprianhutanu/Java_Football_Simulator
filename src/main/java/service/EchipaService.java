package service;

import config.Audit;
import models.*;
import persistence.*;

import java.util.*;

public class EchipaService {
    private Audit audit = Audit.getInstance();
    private AtacantRepository atacantRepo = AtacantRepository.getInstance();
    private MijlocasRepository mijlocasRepo = MijlocasRepository.getInstance();
    private AparatorRepository aparatorRepo = AparatorRepository.getInstance();
    private PortarRepository portarRepo = PortarRepository.getInstance();
    private EchipaRepository echipaRepo = EchipaRepository.getInstance();
    private Random random = new Random();

    public Echipa generareEchipa(String nume){
        Jucator[] jucatori = generareJucatori(10);

        Echipa echipaNoua = new Echipa(10, nume, jucatori);

        audit.write("Generare Echipa", "Utilizatorul si-a generat echipa.");
        return echipaNoua;

    }

    public Jucator[] generareJucatori(int idEchipa){
        int countIdJucatori = 100;
        Jucator[] jucatori = new Jucator[11];

        Set<Integer> numereTricouri = new HashSet<>();

        Atacant[] atacanti = atacantRepo.generareAtacantiAleatoriu(countIdJucatori, idEchipa, 3, numereTricouri).toArray(new Atacant[0]);
        Mijlocas[] mijlocasi = mijlocasRepo.generareMijlocasiAleatoriu(countIdJucatori, idEchipa, 3, numereTricouri).toArray(new Mijlocas[0]);
        Aparator[] aparatori = aparatorRepo.generareAparatoriiAleatoriu(countIdJucatori, idEchipa, 4, numereTricouri).toArray(new Aparator[0]);
        Portar[] portari = portarRepo.generarePortariAleatoriu(countIdJucatori, idEchipa, 1, numereTricouri).toArray(new Portar[0]);

        System.arraycopy(portari, 0, jucatori, 0 ,portari.length);
        System.arraycopy(aparatori, 0, jucatori, 1, aparatori.length);
        System.arraycopy(mijlocasi, 0, jucatori, 5, mijlocasi.length);
        System.arraycopy(atacanti, 0, jucatori, 8, atacanti.length);

        return jucatori;
    }
    public void afisareEchipa(Echipa echipa){
        System.out.println(echipa.getNumeEchipa() + " <> OVR: " + Math.round(echipaRepo.calculareOvrEchipa(echipa)));
        for(Jucator jucator : echipa.getListaJucatori()){
            System.out.println(jucator.toString());
        }
    }
}
