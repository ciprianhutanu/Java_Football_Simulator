package org.example;

import enums.PozitiiAtac;
import models.Atacant;
import models.Jucator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Jucator [] jucatori = new Jucator[2];
        Atacant a = new Atacant("Test","test",10,18,90,90,90,90, PozitiiAtac.VARF);
        jucatori[0] = new Atacant("Test","test",10,18,90,90,90,90, PozitiiAtac.VARF);

        System.out.println((jucatori[0]).toString());
    }
}