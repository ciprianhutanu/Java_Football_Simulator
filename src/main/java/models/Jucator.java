package models;

public class Jucator {
    private String nume, prenume;
    private int numarTricou, numarGoluri, numarCGalbene, varsta, numarCRosii;
    private boolean cartonasRosu;

    public Jucator() {}

    public Jucator(String nume, String prenume, int numarTricou, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.numarTricou = numarTricou;
        this.varsta = varsta;
        this.numarGoluri = 0;
        this.numarCGalbene = 0;
        this.numarCRosii = 0;
        this.cartonasRosu = false;
    }

    public Jucator(Jucator other) {
        this.nume = other.nume;
        this.prenume = other.prenume;
        this.numarTricou = other.numarTricou;
        this.numarGoluri = other.numarGoluri;
        this.numarCGalbene = other.numarCGalbene;
        this.varsta = other.varsta;
        this.numarCRosii = other.numarCRosii;
        this.cartonasRosu = other.cartonasRosu;
    }

    public void douaGalbene() {
        this.numarCGalbene++;
        if (this.numarCGalbene == 2) {
            this.numarCRosii++;
            this.cartonasRosu = true;
            this.numarCGalbene = 0;
        }
    }

    public void cresteCGalbene() {
        this.numarCGalbene++;
    }

    public void cresteCRosii() {
        this.numarCRosii++;
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


    public void setCartonasRosu(boolean cartonasRosu) {
        this.cartonasRosu = cartonasRosu;
    }

    public String getNume() {
        return this.nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public boolean getCartonasRosu() {
        return this.cartonasRosu;
    }
    public int getNumarTricou() {return this.numarTricou;}

    @Override
    public String toString() {
        return this.numarTricou + "|" + this.nume + " " + this.prenume;
    }
}
