package persistence;

import models.Echipa;
import models.Jucator;

import java.util.List;

public class EchipaRepository implements GenericRepository<Echipa>{
    private List<Echipa> echipe;
    @Override
    public void add(Echipa entity) {

    }

    @Override
    public Echipa get(int id) {
        return null;
    }

    @Override
    public void update(Echipa entity) {

    }

    @Override
    public void delete(Echipa entity) {

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
