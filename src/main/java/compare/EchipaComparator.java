package compare;

import models.Echipa;

import java.util.Comparator;

public class EchipaComparator implements Comparator<Echipa> {

    @Override
    public int compare(Echipa o1, Echipa o2) {
        if(Integer.compare(o1.getPuncte(), o2.getPuncte()) != 0){
            return -Integer.compare(o1.getPuncte(), o2.getPuncte());
        }
        else
            return -Integer.compare(o1.getGolaveraj(), o2.getGolaveraj());
    }
}
