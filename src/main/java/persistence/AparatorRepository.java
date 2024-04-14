package persistence;

import enums.PozitiiAparare;
import enums.PozitiiAtac;
import models.Aparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AparatorRepository implements GenericRepository<Aparator>{
    private static final String[] NUME = {
            "Popescu", "Ionescu", "Pop", "Dumitru", "Stoica",
            "Balan", "Gheorghe", "Radu", "Neagu", "Constantin",
            "Dinu", "Mihalache", "Florea", "Iacob", "Florescu",
            "Dumitrache", "Voicu", "Toma", "Tudose", "Badea" };
    private static final String[] PRENUME = {
            "Mihai", "Ion", "Vasile", "Victor", "Alexandru",
            "Cristian", "Gabriel", "Adrian", "Dumitru", "Mircea",
            "George", "Florin", "Costel", "Daniel", "Valentin",
            "Adrian", "Emil", "Gheorghe", "Marian", "Nicolae",
            "Razvan", "Eugen", "Cornel", "Ciprian", "Tudor", "Stefan",
            "Andrei", "Viorel", "Ionut", "Sebastian" };

    private static final PozitiiAparare[] POZITII = PozitiiAparare.values();

    private Random random = new Random();

    private List<Aparator> jucatori = new ArrayList<>();
    @Override
    public void add(Aparator entity) {
        jucatori.add(entity);
    }

    @Override
    public Aparator get(int id) {
        for (Aparator jucator : jucatori) {
            if (jucator.getNumarTricou() == id) {
                return jucator;
            }
        }
        return null;
    }

    @Override
    public void update(Aparator entity) {

    }

    @Override
    public void delete(Aparator entity) {
        if(entity != null){
            jucatori.remove(entity);
        }
    }

    public List<Aparator> generareAparatoriiAleatoriu(int numJucatori, Set<Integer> numereTricou){
        List<Aparator> aparatoriAleatoriu = new ArrayList<>();
        for(int i = 0; i < numJucatori; i++){
            String nume = NUME[random.nextInt(NUME.length)];
            String prenume = PRENUME[random.nextInt(PRENUME.length)];
            int numarTricou = generareNumarTricou(numereTricou);
            int varsta = random.nextInt(25) + 16;
            int viteza = random.nextInt(80) + 19;
            int pase = random.nextInt(80) + 19;
            int aparare = random.nextInt(80) + 19;
            int fizic = random.nextInt(80) + 19;
            PozitiiAparare pozitie = POZITII[random.nextInt(POZITII.length)];
            Aparator aparator = new Aparator(nume, prenume, numarTricou, varsta, viteza, pase, aparare, fizic, pozitie);
            aparatoriAleatoriu.add(aparator);
        }
        return aparatoriAleatoriu;
    }

    private int generareNumarTricou(Set<Integer> numereTricou){
        int numarTricou;
        do{
            numarTricou = random.nextInt(100) + 1;
        }while(numereTricou.contains(numarTricou));
        return numarTricou;
    }
}
