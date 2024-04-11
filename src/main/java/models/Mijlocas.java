package models;

import enums.PozitiiMijloc;

public class Mijlocas extends Jucator{
    private int viteza;
    private int sut;
    private int dribling;
    private int pase;
    private int aparare;
    private PozitiiMijloc pozitie;

    public Mijlocas(String nume, String prenume, float inaltime, double greutate, int numarTricou, int varsta, int viteza, int sut, int dribling, int pase, int aparare, PozitiiMijloc pozitie) {
        super(nume, prenume, inaltime, greutate, numarTricou, varsta);
        this.viteza = viteza;
        this.sut = sut;
        this.dribling = dribling;
        this.pase = pase;
        this.aparare = aparare;
        this.pozitie = pozitie;
    }
}
