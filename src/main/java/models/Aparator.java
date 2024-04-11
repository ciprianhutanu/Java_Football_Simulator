package models;

import enums.PozitiiAparare;

public class Aparator extends Jucator{
    private int viteza;
    private int pase;
    private int aparare;
    private int fizic;
    private PozitiiAparare pozitie;

    public Aparator(String nume, String prenume, float inaltime, double greutate, int numarTricou, int varsta, int viteza, int pase, int aparare, int fizic, PozitiiAparare pozitie) {
        super(nume, prenume, inaltime, greutate, numarTricou, varsta);
        this.viteza = viteza;
        this.pase = pase;
        this.aparare = aparare;
        this.fizic = fizic;
        this.pozitie = pozitie;
    }
}
