package tests;

import persistence.EchipaRepository;
import service.EchipaService;
import models.*;
import service.MeciService;

import java.util.Scanner;

public class TestMeci {
    public static void main(String[] args) {
        EchipaService echipaService = new EchipaService();
        MeciService meciService = new MeciService();

        Echipa echipa1 = echipaService.generareEchipa("FCSB");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nume Echipa: ");
        String nume = scanner.nextLine();

        Echipa echipa2 = echipaService.generareEchipa(nume);
        Meci meci = new Meci(echipa1, echipa2);

        meciService.SimulareMeci(meci, false);
    }
}