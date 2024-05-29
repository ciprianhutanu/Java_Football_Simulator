package tests;

import models.Echipa;
import persistence.EchipaRepository;

import java.util.List;

public class TestEchipaRepo {
    public static void main(String[] args) {
        EchipaRepository e = new EchipaRepository();

        List<Echipa> list = e.getAll();

        for(Echipa echipa : list){
            System.out.println(echipa.getNumeEchipa());
        }
    }
}
