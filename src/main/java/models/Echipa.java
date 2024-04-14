package models;

import java.util.List;

public class Echipa {
    private String numeEchipa;
    private String abreviereEchipa;
    private int puncte, victorii, egaluri, infrangeri, golaveraj;
    private Jucator[] listaJucatori;

    public Echipa(String numeEchipa, Jucator[] listaJucatori) {
        this.numeEchipa = numeEchipa;
        this.abreviereEchipa = numeEchipa.substring(0,Math.min(3,numeEchipa.length())).toUpperCase();
        this.puncte = 0;
        this.victorii = 0;
        this.egaluri = 0;
        this.infrangeri = 0;
        this.golaveraj = 0;
        this.listaJucatori = listaJucatori;
    }

    public int getPuncte() {
        return puncte;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public int getVictorii() {
        return victorii;
    }

    public void setVictorii(int victorii) {
        this.victorii = victorii;
    }

    public int getEgaluri() {
        return egaluri;
    }

    public void setEgaluri(int egaluri) {
        this.egaluri = egaluri;
    }

    public int getInfrangeri() {
        return infrangeri;
    }

    public void setInfrangeri(int infrangeri) {
        this.infrangeri = infrangeri;
    }

    public int getGolaveraj() {
        return golaveraj;
    }

    public void setGolaveraj(int golaveraj) {
        this.golaveraj = golaveraj;
    }

    public Jucator[] getListaJucatori() {
        return listaJucatori;
    }

    public void setListaJucatori(Jucator[] listaJucatori) {
        this.listaJucatori = listaJucatori;
    }

    public String getAbreviereEchipa() {
        return abreviereEchipa;
    }
}