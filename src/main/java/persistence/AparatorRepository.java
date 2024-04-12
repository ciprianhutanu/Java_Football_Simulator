package persistence;

import enums.PozitiiAparare;
import models.Aparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
}
