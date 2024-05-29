package tests;

import persistence.EchipaRepository;
import service.EchipaService;
import models.*;
import service.MeciService;

import java.util.Scanner;

public class TestMeci {
    public static void main(String[] args) {
        EchipaService echipaService = new EchipaService();
        EchipaRepository echipaRepository = EchipaRepository.getInstance();
        MeciService meciService = new MeciService();

        Echipa echipa1 = echipaService.generareEchipa("FCSB");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nume Echipa: ");
        String nume = scanner.nextLine();

        Echipa echipa2 = echipaService.generareEchipa(nume);

        System.out.println("OVR Echipa1: " + echipaRepository.calculareOvrEchipa(echipa1) +"\nOVR Echipa2: "+ echipaRepository.calculareOvrEchipa(echipa2));

        Meci meci = new Meci(echipa1, echipa2);

        meciService.SimulareMeci(meci, false, true);
    }
}
