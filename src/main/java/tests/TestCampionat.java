package tests;

import models.Campionat;
import models.Echipa;
import service.CampionatService;
import service.EchipaService;

import java.util.Scanner;

public class TestCampionat {
    public static void main(String[] args) {
        EchipaService echipaService = new EchipaService();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nume Echipa: ");
        String nume = scanner.nextLine();

        Echipa echipa = echipaService.generareEchipa(nume);

        CampionatService campionatService = new CampionatService();

        Campionat campionat = campionatService.generareLigaInteractiva("Liga 1", echipa);

        campionatService.simulareEtapa(false);

        campionatService.afisareClasament(campionat);
    }
}
