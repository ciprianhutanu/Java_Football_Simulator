package models;

public class Portar extends Jucator{
    private int ovr; // Overall rating

    public Portar(String nume, String prenume, float inaltime, double greutate, int numarTricou, int varsta, int ovr) {
        super(nume, prenume, inaltime, greutate, numarTricou, varsta);
        this.ovr = ovr;
    }
}
