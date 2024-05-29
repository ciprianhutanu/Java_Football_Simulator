package persistence;

import models.Portar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private static PortarRepository instance;

    private PortarRepository() {}
    public static PortarRepository getInstance() {
        if (instance == null) {
            instance = new PortarRepository();
        }
        return instance;
    }

    public Portar get(int id) {
        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, P.ovr " +
                "FROM jucator J, portar P " +
                "WHERE J.idJucator = P.idJucator " +
                "AND J.idJucator = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, id);

            ResultSet res = myStm.executeQuery();
            if (res.next()) {
                return new Portar(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Portar> getAll() {
        List<Portar> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, P.ovr " +
                "FROM jucator J, portar P " +
                "WHERE J.idJucator = P.idJucator ";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Portar(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7)));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Portar> getAllByTeamId(int idEchipa) {
        List<Portar> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, P.ovr " +
                "FROM jucator J, portar P " +
                "WHERE J.idJucator = P.idJucator " +
                "AND J.idEchipa = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, idEchipa);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Portar(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(7)));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Portar> generarePortariAleatoriu(int idCounter, int idEchipa, int numJucatori, Set<Integer> numereTricou){
        List<Portar> portariAleatoriu = new ArrayList<>();
        for(int i = 0; i < numJucatori; i++){
            String nume = NUME[random.nextInt(NUME.length)];
            String prenume = PRENUME[random.nextInt(PRENUME.length)];
            int numarTricou = generareNumarTricou(numereTricou);
            int varsta = random.nextInt(25) + 16;
            int ovr = random.nextInt(80) + 19;
            Portar portar = new Portar(idCounter, idEchipa, nume, prenume, numarTricou, varsta, ovr);
            portariAleatoriu.add(portar);
            idCounter++;
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
