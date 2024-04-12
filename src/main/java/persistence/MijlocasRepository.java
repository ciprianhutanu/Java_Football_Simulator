package persistence;

import enums.PozitiiMijloc;
import models.Mijlocas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MijlocasRepository implements GenericRepository<Mijlocas>{
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

    private static final PozitiiMijloc[] POZITII = PozitiiMijloc.values();

    private Random random = new Random();

    private List<Mijlocas> jucatori = new ArrayList<>();
    @Override
    public void add(Mijlocas entity) {
        jucatori.add(entity);
    }

    @Override
    public Mijlocas get(int id) {
        for (Mijlocas jucator : jucatori) {
            if (jucator.getNumarTricou() == id) {
                return jucator;
            }
        }
        return null;
    }

    @Override
    public void update(Mijlocas entity) {
        if(entity != null){
            jucatori.remove(entity);
        }
    }

    @Override
    public void delete(Mijlocas entity) {

    }
}
