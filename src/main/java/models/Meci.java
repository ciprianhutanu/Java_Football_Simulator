package models;

public class Meci {
    private Echipa echipaAcasa;
    private Echipa echipaDeplasare;
    public Meci(Echipa echipaAcasa, Echipa echipaDeplasare) {
        this.echipaAcasa = echipaAcasa;
        this.echipaDeplasare = echipaDeplasare;
    }

    public Echipa getEchipaAcasa() {
        return echipaAcasa;
    }

    public void setEchipaAcasa(Echipa echipaAcasa) {
        this.echipaAcasa = echipaAcasa;
    }

    public Echipa getEchipaDeplasare() {
        return echipaDeplasare;
    }

    public void setEchipaDeplasare(Echipa echipaDeplasare) {
        this.echipaDeplasare = echipaDeplasare;
    }
}
