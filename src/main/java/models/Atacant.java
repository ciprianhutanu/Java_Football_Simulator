package models;

import enums.PozitiiAtac;

public class Atacant extends Jucator{
    private int viteza;
    private int sut;
    private int dribling;
    private int pase;
    private PozitiiAtac pozitie;

    public Atacant(String nume, String prenume, float inaltime, double greutate, int numarTricou, int varsta, int viteza, int sut, int dribling, int pase, PozitiiAtac pozitie) {
        super(nume, prenume, inaltime, greutate, numarTricou, varsta);
        this.viteza = viteza;
        this.sut = sut;
        this.dribling = dribling;
        this.pase = pase;
        this.pozitie = pozitie;
    }
}
