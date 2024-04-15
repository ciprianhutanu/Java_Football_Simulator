package models;

public class Portar extends Jucator{
    private int ovr; // Overall rating

    public Portar(String nume, String prenume, int numarTricou, int varsta, int ovr) {
        super(nume, prenume, numarTricou, varsta);
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
