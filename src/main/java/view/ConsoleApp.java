package view;

import models.Campionat;
import models.Echipa;
import service.CampionatService;
import service.EchipaService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleApp {
    private Scanner scanner = new Scanner(System.in);
    private Echipa echipa;
    private Campionat campionat;
    private CampionatService campionatService = new CampionatService();
    private EchipaService echipaService = new EchipaService();

    public static void main(String[] args) {
        ConsoleApp aplicatie = new ConsoleApp();
        aplicatie.meniuStart();
    }
    private void meniuStart(){
        System.out.println("______          _   _           _ _   _____ _                 _       _             ");
        System.out.println("|  ___|        | | | |         | | | /  ___(_)               | |     | |            ");
        System.out.println("| |_ ___   ___ | |_| |__   __ _| | | \\ `--. _ _ __ ___  _   _| | __ _| |_ ___  _ __ ");
        System.out.println("|  _/ _ \\ / _ \\| __| '_ \\ / _` | | |  `--. \\ | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|");
        System.out.println("| || (_) | (_) | |_| |_) | (_| | | | /\\__/ / | | | | | | |_| | | (_| | || (_) | |   ");
        System.out.println("\\_| \\___/ \\___/ \\__|_.__/ \\__,_|_|_| \\____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   ");

        System.out.println("\t\t\t\t\t\t--Apasa ENTER pentru a incepe--");

        scanner.nextLine();

        creareEchipa();
    }

    private void creareEchipa(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }

        System.out.print("Introduceti un nume pentru echipa dumneavoastra: ");

        String nume = scanner.nextLine();
        while(nume == null){
            System.out.print("Numele trebuie sa contina macar un caracter! Incercati din nou: ");
        }

        echipa = echipaService.generareEchipa(nume);
        campionat = campionatService.generareLigaInteractiva("Liga 1",echipa);

        meniuPrincipal();
    }

    private void meniuPrincipal(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
        echipaService.afisareEchipa(echipa);
        System.out.println("Optiuni:");
        System.out.println("1.Simulare etapa urmatoare.");
        System.out.println("2.Afisare clasament.");
        System.out.println("3.Iesire.");

        int optiune = optiuniMeniuPrincipal();

        for(int i = 0; i < 10; i++){
            System.out.println();
        }

        executaMeniuPrincipal(optiune);

        meniuPrincipal();
    }

    private int optiuniMeniuPrincipal(){
        int optiune = scanner.nextInt();
        if(optiune >= 1 && optiune <= 3){
            return optiune;
        }
        System.out.print("Optiune invalida! Reincercati: ");
        return optiuniMeniuPrincipal();
    }

    private void executaMeniuPrincipal(int optiune){
        switch (optiune){
            case 1:
                campionatService.simulareEtapa(false);
                System.out.println("\nIntroduceti orice tasta pentru a reveni la meniul principal!");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 2:
                campionatService.afisareClasament(campionat);
                System.out.println("\nApasati introduceti orice tasta pentru a reveni la meniul principal!");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 3:
                System.exit(0);
        }
    }
}
