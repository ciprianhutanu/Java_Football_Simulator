package persistence;

import enums.PozitiiAtac;
import enums.PozitiiMijloc;
import models.Atacant;
import models.Mijlocas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Mijlocas get(int id) {
        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, M.viteza, M.sut, M.dribling, M.pase, M.aparare, M.pozitie " +
                "FROM jucator J, mijlocas M " +
                "WHERE J.idJucator = M.idJucator " +
                "AND J.idJucator = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, id);

            ResultSet res = myStm.executeQuery();
            if (res.next()) {
                return new Mijlocas(
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
                        res.getInt(11),
                        PozitiiMijloc.valueOf(res.getString(12)));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Mijlocas> getAll() {
        List<Mijlocas> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, M.viteza, M.sut, M.dribling, M.pase, M.aparare, M.pozitie " +
                "FROM jucator J, mijlocas M " +
                "WHERE J.idJucator = M.idJucator ";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Mijlocas(
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
                        res.getInt(11),
                        PozitiiMijloc.valueOf(res.getString(12))));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mijlocas> getAllByTeamId(int idEchipa) {
        List<Mijlocas> result = new ArrayList<>();

        String query = "" +
                "SELECT J.idJucator, J.idEchipa, J.nume, J.prenume, J.numarTricou, J.varsta, M.viteza, M.sut, M.dribling, M.pase, M.aparare, M.pozitie " +
                "FROM jucator J, mijlocas M " +
                "WHERE J.idJucator = M.idJucator " +
                "AND J.idEchipa = ?";
        try {
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, idEchipa);

            ResultSet res = myStm.executeQuery();
            while (res.next()) {
                result.add(new Mijlocas(
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
                        res.getInt(11),
                        PozitiiMijloc.valueOf(res.getString(12))));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mijlocas> generareMijlocasiAleatoriu(int idCounter, int idEchipa, int numJucatori, Set<Integer> numereTricou){
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
            Mijlocas mijlocas = new Mijlocas(idCounter, idEchipa, nume, prenume, numarTricou, varsta, viteza, sut, dribling, pase, aparare, pozitie);
            mijlocasiAleatoriu.add(mijlocas);
            idCounter++;
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
