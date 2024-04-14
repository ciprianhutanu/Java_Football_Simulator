package persistence;

import enums.PozitiiMijloc;
import models.Mijlocas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
        
    }

    @Override
    public void delete(Mijlocas entity) {
        if(entity != null){
            jucatori.remove(entity);
        }
    }

    public List<Mijlocas> generareMijlocasiAleatoriu(int numJucatori, Set<Integer> numereTricou){
        List<Mijlocas> mijlocasiAleatoriu = new ArrayList<>();
        for(int i = 0; i < numJucatori; i++){
            String nume = NUME[random.nextInt(NUME.length)];
            String prenume = PRENUME[random.nextInt(PRENUME.length)];
            int numarTricou = generareNumarTricou(numereTricou);
            int varsta = random.nextInt(25) + 16;
            int viteza = random.nextInt(80) + 19;
            int sut = random.nextInt(80) + 19;
            int dribling = random.nextInt(80) + 19;
            int pase = random.nextInt(80) + 19;
            int aparare = random.nextInt(80) + 19;
            PozitiiMijloc pozitie = POZITII[random.nextInt(POZITII.length)];
            Mijlocas mijlocas = new Mijlocas(nume, prenume, numarTricou, varsta, viteza, sut, dribling, pase, aparare, pozitie);
            mijlocasiAleatoriu.add(mijlocas);
        }
        return mijlocasiAleatoriu;
    }

    private int generareNumarTricou(Set<Integer> numereTricou){
        int numarTricou;
        do{
            numarTricou = random.nextInt(100) + 1;
        }while(numereTricou.contains(numarTricou));
        return numarTricou;
    }
}
