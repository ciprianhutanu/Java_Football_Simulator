package models;

import enums.PozitiiAparare;

public class Aparator extends Jucator{
    private int viteza, pase, aparare, fizic;
    private double ovr;
    private PozitiiAparare pozitie;

    public Aparator(String nume, String prenume, int numarTricou, int varsta, int viteza, int pase, int aparare, int fizic, PozitiiAparare pozitie) {
        super(nume, prenume, numarTricou, varsta);
        this.viteza = viteza;
        this.pase = pase;
        this.aparare = aparare;
        this.fizic = fizic;
        this.pozitie = pozitie;

        this.ovr = (double) (viteza + pase + aparare + fizic) / 4;
    }
    public double getOvr() {
        return ovr;
    }
    @Override
    public String toString() {
        return super.toString() + " --- " + this.ovr;
    }
}
