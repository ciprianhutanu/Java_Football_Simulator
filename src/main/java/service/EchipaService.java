package service;

import models.*;
import persistence.AparatorRepository;
import persistence.AtacantRepository;
import persistence.MijlocasRepository;
import persistence.PortarRepository;

import java.util.*;

public class EchipaService {
    private AtacantRepository atacantRepo = new AtacantRepository();
    private MijlocasRepository mijlocasRepo = new MijlocasRepository();
    private AparatorRepository aparatorRepo = new AparatorRepository();
    private PortarRepository portarRepo = new PortarRepository();

    public Echipa generareEchipa(String nume){
        Jucator[] jucatori = generareJucatori();

        Echipa echipaNoua = new Echipa(nume, jucatori);

        return echipaNoua;

    }

    public Jucator[] generareJucatori(){
        Jucator[] jucatori = new Jucator[11];

        Set<Integer> numereTricouri = new HashSet<>();

        Atacant[] atacanti = atacantRepo.generareAtacantiAleatoriu(3,numereTricouri).toArray(new Atacant[0]);
        Mijlocas[] mijlocasi = mijlocasRepo.generareMijlocasiAleatoriu(3,numereTricouri).toArray(new Mijlocas[0]);
        Aparator[] aparatori = aparatorRepo.generareAparatoriiAleatoriu(4,numereTricouri).toArray(new Aparator[0]);
        Portar[] portari = portarRepo.generarePortariAleatoriu(1,numereTricouri).toArray(new Portar[0]);

        System.arraycopy(portari, 0, jucatori, 0 ,portari.length);
        System.arraycopy(aparatori, 0, jucatori, 1, aparatori.length);
        System.arraycopy(mijlocasi, 0, jucatori, 5, mijlocasi.length);
        System.arraycopy(atacanti, 0, jucatori, 8, atacanti.length);

        return jucatori;
    }
}
