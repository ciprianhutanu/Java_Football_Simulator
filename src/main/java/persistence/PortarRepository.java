package persistence;

import models.Portar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PortarRepository implements GenericRepository<Portar> {
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

    private Random random = new Random();

    private List<Portar> jucatori = new ArrayList<>();
    @Override
    public void add(Portar entity) {
        jucatori.add(entity);
    }

    @Override
    public Portar get(int id) {
        for (Portar jucator : jucatori) {
            if (jucator.getNumarTricou() == id) {
                return jucator;
            }
        }
        return null;
    }

    @Override
    public void update(Portar entity) {

    }

    @Override
    public void delete(Portar entity) {
        if(entity != null){
            jucatori.remove(entity);
        }
    }
}
