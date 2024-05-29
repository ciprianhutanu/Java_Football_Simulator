package persistence;

import enums.PozitiiAparare;
import enums.PozitiiAtac;
import models.Aparator;
import models.Echipa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    private static AparatorRepository instance = null;

    private AparatorRepository() {}
    public static AparatorRepository getInstance() {
        if (instance == null) {
            instance = new AparatorRepository();
        }
        return instance;
    }

    @Override
    public Aparator get(int id) {
        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, A.viteza, A.pase, A.aparare, A.fizic, A.pozitie " +
                "FROM jucator J, aparator A " +
                "WHERE J.idJucator = A.idJucator " +
                "AND J.idJucator = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, id);

            ResultSet res = myStm.executeQuery();
            if (res.next()) {
                return new Aparator(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getInt(8),
                        res.getInt(9),
                        res.getInt(10),
                        PozitiiAparare.valueOf(res.getString(11)));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aparator> getAll() {
        List<Aparator> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, A.viteza, A.pase, A.aparare, A.fizic, A.pozitie " +
                "FROM jucator J, aparator A " +
                "WHERE J.idJucator = A.idJucator ";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Aparator(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getInt(8),
                        res.getInt(9),
                        res.getInt(10),
                        PozitiiAparare.valueOf(res.getString(11))));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aparator> getAllByTeamId(int idEchipa) {
        List<Aparator> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, A.viteza, A.pase, A.aparare, A.fizic, A.pozitie " +
                "FROM jucator J, aparator A " +
                "WHERE J.idJucator = A.idJucator " +
                "AND J.idEchipa = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, idEchipa);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Aparator(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getInt(8),
                        res.getInt(9),
                        res.getInt(10),
                        PozitiiAparare.valueOf(res.getString(11))));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public List<Aparator> generareAparatoriiAleatoriu(int idCounter, int idEchipa, int numJucatori, Set<Integer> numereTricou){
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
            Aparator aparator = new Aparator(idCounter, idEchipa, nume, prenume, numarTricou, varsta, viteza, pase, aparare, fizic, pozitie);
            aparatoriAleatoriu.add(aparator);
            idCounter++;
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
