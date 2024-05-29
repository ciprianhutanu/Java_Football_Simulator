package persistence;

import enums.PozitiiAparare;
import enums.PozitiiAtac;
import models.Aparator;
import models.Atacant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public Atacant get(int id) {
        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, A.viteza, A.sut, A.dribling, A.pase, A.pozitie " +
                "FROM jucator J, atacant A " +
                "WHERE J.idJucator = A.idJucator " +
                "AND J.idJucator = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, id);

            ResultSet res = myStm.executeQuery();
            if (res.next()) {
                return new Atacant(
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
                        PozitiiAtac.valueOf(res.getString(11)));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Atacant> getAll() {
        List<Atacant> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, A.viteza, A.sut, A.dribling, A.pase, A.pozitie " +
                "FROM jucator J, atacant A " +
                "WHERE J.idJucator = A.idJucator ";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Atacant(
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
                        PozitiiAtac.valueOf(res.getString(11))));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Atacant> getAllByTeamId(int idEchipa) {
        List<Atacant> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, A.viteza, A.sut, A.dribling, A.pase, A.pozitie " +
                "FROM jucator J, atacant A " +
                "WHERE J.idJucator = A.idJucator " +
                "AND J.idEchipa = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, idEchipa);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Atacant(
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
                        PozitiiAtac.valueOf(res.getString(11))));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Atacant> generareAtacantiAleatoriu(int idCounter, int idEchipa, int numJucatori, Set<Integer> numereTricou){
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
            Atacant atacant = new Atacant(idCounter, idEchipa, nume, prenume, numarTricou, varsta, viteza, sut, dribling, pase, pozitie);
            atacantiAleatoriu.add(atacant);
            idCounter++;
        }
        return atacantiAleatoriu;
    }

    private int generareNumarTricou(Set<Integer> numereTricou){
        int numarTricou;
        do{
            numarTricou = random.nextInt(100) + 1;
        }while(numereTricou.contains(numarTricou));
        numereTricou.add(numarTricou);
        return numarTricou;
    }
}
