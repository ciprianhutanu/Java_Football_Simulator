package models;

public class Portar extends Jucator{
    private int ovr; // Overall rating

    public Portar(int idJucator, int idEchipa, String nume, String prenume, int numarTricou, int varsta, int ovr) {
        super(idJucator, idEchipa, nume, prenume, numarTricou, varsta);
        this.ovr = ovr;
    }
    public double getOvr() {
        return ovr;
    }
    @Override
    public String toString() {
        return super.toString() + " PORTAR " + this.ovr;
    }
}
