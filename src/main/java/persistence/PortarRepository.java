package persistence;

import models.Portar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

    public List<Portar> generarePortariAleatoriu(int numJucatori, Set<Integer> numereTricou){
        List<Portar> portariAleatoriu = new ArrayList<>();
        for(int i = 0; i < numJucatori; i++){
            String nume = NUME[random.nextInt(NUME.length)];
            String prenume = PRENUME[random.nextInt(PRENUME.length)];
            int numarTricou = generareNumarTricou(numereTricou);
            int varsta = random.nextInt(25) + 16;
            int ovr = random.nextInt(80) + 19;
            Portar portar = new Portar(nume, prenume, numarTricou, varsta, ovr);
            portariAleatoriu.add(portar);
        }
        return portariAleatoriu;
    }

    private int generareNumarTricou(Set<Integer> numereTricou){
        int numarTricou;
        do{
            numarTricou = random.nextInt(100) + 1;
        }while(numereTricou.contains(numarTricou));
        return numarTricou;
    }
}
