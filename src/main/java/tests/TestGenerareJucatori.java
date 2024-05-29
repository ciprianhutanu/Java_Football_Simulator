package tests;

import models.Atacant;
import models.Jucator;
import persistence.AtacantRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestGenerareJucatori {
    public static void main(String[] args) {
        AtacantRepository _repo = new AtacantRepository();
        Set<Integer> numarTricou = new HashSet<>();
        List<Atacant> jucatori = _repo.generareAtacantiAleatoriu(1100, 10, 10,numarTricou);
        Jucator[] arr = jucatori.toArray(new Atacant[0]);
        for(int i = 0; i< jucatori.size(); i++){
            System.out.println(arr[i].toString());
        }
    }
}
