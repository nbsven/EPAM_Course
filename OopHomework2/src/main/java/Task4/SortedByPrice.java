package Task4;

import Task2.Stationary;

import java.util.Comparator;

public class SortedByPrice implements Comparator<Stationary> {
    @Override
    public int compare(Stationary stationary1,Stationary stationary2){
        if(stationary1.getPrice() > stationary2.getPrice()){
            return 1;
        }
        if(stationary1.getPrice().intValue()==stationary2.getPrice().intValue()){
            return 0;
        }
        return -1;
    }
}
