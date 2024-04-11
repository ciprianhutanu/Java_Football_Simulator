package models;

public class Echipa {
    private String numeEchipa;
    private String abreviereEchipa;
    private String orasEchipa;
    private int numarTitulari, puncte, victorii, egaluri, infrangeri, golaveraj;
    private Jucator[] listaTitulari;

    public Echipa() {
    }

    public Echipa(String numeEchipa, String abreviereEchipa, String orasEchipa, int numarTitulari, int puncte, int victorii, int egaluri, int infrangeri, int golaveraj, Jucator[] listaTitulari) {
        this.numeEchipa = numeEchipa;
        this.abreviereEchipa = abreviereEchipa;
        this.orasEchipa = orasEchipa;
        this.numarTitulari = numarTitulari;
        this.listaTitulari = listaTitulari;
        this.puncte = puncte;
        this.victorii = victorii;
        this.egaluri = egaluri;
        this.infrangeri = infrangeri;
        this.golaveraj = golaveraj;
    }

    public Echipa(Echipa other) {
        this.numeEchipa = other.numeEchipa;
        this.abreviereEchipa = other.abreviereEchipa;
        this.orasEchipa = other.orasEchipa;
        this.numarTitulari = other.numarTitulari;
        this.puncte = other.puncte;
        this.victorii = other.victorii;
        this.egaluri = other.egaluri;
        this.infrangeri = other.infrangeri;
        this.golaveraj = other.golaveraj;
        this.listaTitulari = other.listaTitulari.clone();
    }

    public void calculPuncte() {
        this.puncte = this.egaluri + 3 * this.victorii;
    }

    public void cresteVictorii() {
        this.victorii++;
    }

    public void cresteInfrangeri() {
        this.infrangeri++;
    }

    public void cresteEgaluri() {
        this.egaluri++;
    }

    public void cresteGolaveraj(int x) {
        this.golaveraj += x;
    }

    public int getNrJucatori() {
        return this.numarTitulari;
    }

    public int getNrPuncte() {
        return this.puncte;
    }

    public int getGolaveraj() {
        return this.golaveraj;
    }

    public Jucator[] getListaTitulari() {
        return this.listaTitulari;
    }

    public String getAbreviere() {
        return this.abreviereEchipa;
    }

    public String getNumeEchipa() {
        return this.numeEchipa;
    }
}
