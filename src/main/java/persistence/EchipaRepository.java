package persistence;

import models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EchipaRepository implements GenericRepository<Echipa>{
    private final AtacantRepository atacantRepo = new AtacantRepository();
    private final MijlocasRepository mijlocasRepo = new MijlocasRepository();
    private final AparatorRepository aparatorRepo = new AparatorRepository();
    private final PortarRepository portarRepo = new PortarRepository();

    @Override
    public Echipa get(int id) {
        String query = ""+
            "SELECT * " +
            "FROM echipa " +
            "WHERE id = ? ";

        try{
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            myStm.setInt(1, id);

            ResultSet res = myStm.executeQuery();
            if(res.next()){
                int idEchipa = res.getInt(1);

                Jucator[] jucatori = new Jucator[11];

                Atacant[] atacanti = atacantRepo.getAllByTeamId(idEchipa).toArray(new Atacant[0]);
                Mijlocas[] mijlocasi = mijlocasRepo.getAllByTeamId(idEchipa).toArray(new Mijlocas[0]);
                Aparator[] aparatori = aparatorRepo.getAllByTeamId(idEchipa).toArray(new Aparator[0]);
                Portar[] portari = portarRepo.getAllByTeamId(idEchipa).toArray(new Portar[0]);

                System.arraycopy(portari, 0, jucatori, 0 ,portari.length);
                System.arraycopy(aparatori, 0, jucatori, 1, aparatori.length);
                System.arraycopy(mijlocasi, 0, jucatori, 5, mijlocasi.length);
                System.arraycopy(atacanti, 0, jucatori, 8, atacanti.length);

                return new Echipa(
                        res.getInt(1),
                        res.getString(2),
                        jucatori
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Echipa> getAll() {
        List<Echipa> result = new ArrayList<>();

        String query = ""+
                "SELECT * " +
                "FROM echipa ";

        try{
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            ResultSet res = myStm.executeQuery();
            while(res.next()){
                int idEchipa = res.getInt(1);

                Jucator[] jucatori = new Jucator[11];

                Atacant[] atacanti = atacantRepo.getAllByTeamId(idEchipa).toArray(new Atacant[0]);
                Mijlocas[] mijlocasi = mijlocasRepo.getAllByTeamId(idEchipa).toArray(new Mijlocas[0]);
                Aparator[] aparatori = aparatorRepo.getAllByTeamId(idEchipa).toArray(new Aparator[0]);
                Portar[] portari = portarRepo.getAllByTeamId(idEchipa).toArray(new Portar[0]);

                System.arraycopy(portari, 0, jucatori, 0 ,portari.length);
                System.arraycopy(aparatori, 0, jucatori, 1, aparatori.length);
                System.arraycopy(mijlocasi, 0, jucatori, 5, mijlocasi.length);
                System.arraycopy(atacanti, 0, jucatori, 8, atacanti.length);

                result.add( new Echipa(
                        res.getInt(1),
                        res.getString(2),
                        jucatori
                ));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void calcularePuncte(Echipa entity, char rezultat, int diferentaGoluri){
        if(rezultat == 'V'){
            int victorii = entity.getVictorii();
            int puncte = entity.getPuncte();
            int golaveraj = entity.getGolaveraj();

            victorii++;
            entity.setVictorii(victorii);

            puncte += 3;
            entity.setPuncte(puncte);

            golaveraj += diferentaGoluri;
            entity.setGolaveraj(golaveraj);
        }
        else if(rezultat == 'E'){
            int egaluri = entity.getEgaluri();
            int puncte = entity.getPuncte();

            egaluri++;
            entity.setEgaluri(egaluri);

            puncte += 1;
            entity.setPuncte(puncte);
        }
        else{
            int infrageri = entity.getInfrangeri();
            int golaveraj = entity.getGolaveraj();

            infrageri++;
            entity.setInfrangeri(infrageri);

            golaveraj += diferentaGoluri;
            entity.setGolaveraj(golaveraj);
        }
    }
    public double calculareOvrEchipa(Echipa entity){
        double ovr = 0.0;
        int numarJucatori = entity.getListaJucatori().length;

        for(Jucator jucator : entity.getListaJucatori()){
            ovr += jucator.getOvr();
        }

        ovr = ovr/numarJucatori;
        return ovr;
    }
}
