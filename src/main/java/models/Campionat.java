package models;

public class Campionat {
    private String denumire;
    private Echipa [] echipe;

    public Campionat(String denumire, Echipa[] echipe) {
        this.denumire = denumire;
        this.echipe = echipe;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Echipa[] getEchipe() {
        return echipe;
    }

    public void setEchipe(Echipa[] echipe) {
        this.echipe = echipe;
    }
}
