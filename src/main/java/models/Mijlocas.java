package models;

import enums.PozitiiMijloc;

public class Mijlocas extends Jucator{
    private int viteza, sut, dribling, pase, aparare;
    private double ovr;
    private PozitiiMijloc pozitie;

    public Mijlocas(int idJucator, int idEchipa, String nume, String prenume, int numarTricou, int varsta, int viteza, int sut, int dribling, int pase, int aparare, PozitiiMijloc pozitie) {
        super(idJucator, idEchipa, nume, prenume, numarTricou, varsta);
        this.viteza = viteza;
        this.sut = sut;
        this.dribling = dribling;
        this.pase = pase;
        this.aparare = aparare;
        this.pozitie = pozitie;
        this.ovr = (double) (viteza + pase + aparare + sut + dribling) / 5;
    }
    public double getOvr() {
        return ovr;
    }
    @Override
    public String toString() {
        return super.toString() + " " + this.pozitie + " " + this.ovr;
    }
}
