package persistence;

import enums.PozitiiAtac;
import models.Atacant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AtacantRepository implements GenericRepository<Atacant> {
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

    private static final PozitiiAtac[] POZITII = PozitiiAtac.values();

    private Random random = new Random();

    private List<Atacant> jucatori = new ArrayList<>();
    @Override
    public void add(Atacant entity) {
        jucatori.add(entity);
    }

    @Override
    public Atacant get(int id) {
        for (Atacant jucator : jucatori) {
            if (jucator.getNumarTricou() == id) {
                return jucator;
            }
        }
        return null;
    }

    @Override
    public void update(Atacant entity) {

    }

    @Override
    public void delete(Atacant entity) {
        if(entity != null){
            jucatori.remove(entity);
        }
    }

    public List<Atacant> generareAtacantiAleatoriu(int numJucatori, Set<Integer> numereTricou){
        List<Atacant> atacantiAleatoriu = new ArrayList<>();
        for(int i = 0; i < numJucatori; i++){
            String nume = NUME[random.nextInt(NUME.length)];
            String prenume = PRENUME[random.nextInt(PRENUME.length)];
            int numarTricou = generareNumarTricou(numereTricou);
            int varsta = random.nextInt(25) + 16;
            int viteza = random.nextInt(80) + 19;
            int sut = random.nextInt(80) + 19;
            int dribling = random.nextInt(80) + 19;
            int pase = random.nextInt(80) + 19;
            PozitiiAtac pozitie = POZITII[random.nextInt(POZITII.length)];
            Atacant atacant = new Atacant(nume, prenume, numarTricou, varsta, viteza, sut, dribling, pase, pozitie);
            atacantiAleatoriu.add(atacant);
        }
        return atacantiAleatoriu;
    }

    private int generareNumarTricou(Set<Integer> numereTricou){
        int numarTricou;
        do{
            numarTricou = random.nextInt(100) + 1;
        }while(numereTricou.contains(numarTricou));
        return numarTricou;
    }
}
