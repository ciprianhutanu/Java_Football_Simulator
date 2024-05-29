package models;

public abstract class Jucator {
    private int idJucator;
    private int idEchipa;
    private String nume, prenume;
    private int numarTricou, varsta;

    public Jucator() {}

    public Jucator(int idJucator, int idEchipa, String nume, String prenume, int numarTricou, int varsta) {
        this.idJucator = idJucator;
        this.idEchipa = idEchipa;
        this.nume = nume;
        this.prenume = prenume;
        this.numarTricou = numarTricou;
        this.varsta = varsta;
    }

    public Jucator(Jucator other) {
        this.idJucator = other.idJucator;
        this.idEchipa = other.idEchipa;
        this.nume = other.nume;
        this.prenume = other.prenume;
        this.numarTricou = other.numarTricou;
        this.varsta = other.varsta;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }


    public void setNumarTricou(int numarTricou) {
        this.numarTricou = numarTricou;
    }

    public String getNume() {
        return this.nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public int getNumarTricou() {return this.numarTricou;}
    public abstract double getOvr();

    public int getIdJucator() {
        return idJucator;
    }

    public void setIdJucator(int idJucator) {
        this.idJucator = idJucator;
    }

    public int getIdEchipa() {
        return idEchipa;
    }

    public void setIdEchipa(int idEchipa) {
        this.idEchipa = idEchipa;
    }

    @Override
    public String toString() {
        return this.numarTricou + "|" + this.nume + " " + this.prenume;
    }
}
