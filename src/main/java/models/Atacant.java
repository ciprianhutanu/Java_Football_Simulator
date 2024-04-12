package models;

import enums.PozitiiAtac;

public class Atacant extends Jucator{
    private int viteza, sut, dribling, pase;
    private double ovr;
    private PozitiiAtac pozitie;

    public Atacant(String nume, String prenume, int numarTricou, int varsta, int viteza, int sut, int dribling, int pase, PozitiiAtac pozitie) {
        super(nume, prenume, numarTricou, varsta);
        this.viteza = viteza;
        this.sut = sut;
        this.dribling = dribling;
        this.pase = pase;
        this.pozitie = pozitie;

        this.ovr = (double) (viteza + pase + sut + dribling) / 4;
    }

    public double getOvr() {
        return ovr;
    }
    @Override
    public String toString() {
        return super.toString() + " --- " + this.ovr;
    }
}
