import java.time.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String args[])
    {
        //Doua LinkedHashMap-uri, cate una pentru fiecare Trip(fiecare atractie a trip-ului primeste o mapa care reprezinta orarul acelor atractii)
        //Fiecare LinkedHashMap are drept cheie un LocalDate si drept valoare o clasa Pair care contine doua variabile de tip LocalTime
        Map<LocalDate, Pair<LocalTime, LocalTime>> map1 = new LinkedHashMap<>();
        map1.put(LocalDate.of(2024,3,18), new Pair<>(LocalTime.of(8, 0), LocalTime.of(17, 0)));
        map1.put(LocalDate.of(2024,3,19), new Pair<>(LocalTime.of(7, 0), LocalTime.of(16, 0)));
        map1.put(LocalDate.of(2024,3,20), new Pair<>(LocalTime.of(9, 0), LocalTime.of(12, 0)));
        map1.put(LocalDate.of(2024,3,21), new Pair<>(LocalTime.of(12, 0), LocalTime.of(20, 0)));
        map1.put(LocalDate.of(2024,3,22), new Pair<>(LocalTime.of(6, 0), LocalTime.of(12, 0)));
        map1.put(LocalDate.of(2024,3,23), new Pair<>(LocalTime.of(14, 0), LocalTime.of(18, 0)));
        map1.put(LocalDate.of(2024,3,24), new Pair<>(LocalTime.of(10, 0), LocalTime.of(14, 0)));

        Map<LocalDate, Pair<LocalTime, LocalTime>> map2 = new LinkedHashMap<>();
        map2.put(LocalDate.of(2024,4,1), new Pair<>(LocalTime.of(8, 0), LocalTime.of(17, 0)));
        map2.put(LocalDate.of(2024,4,2), new Pair<>(LocalTime.of(7, 0), LocalTime.of(16, 0)));
        map2.put(LocalDate.of(2024,4,3), new Pair<>(LocalTime.of(9, 0), LocalTime.of(12, 0)));
        map2.put(LocalDate.of(2024,4,4), new Pair<>(LocalTime.of(12, 0), LocalTime.of(20, 0)));
        map2.put(LocalDate.of(2024,4,5), new Pair<>(LocalTime.of(6, 0), LocalTime.of(12, 0)));
        map2.put(LocalDate.of(2024,4,6), new Pair<>(LocalTime.of(14, 0), LocalTime.of(18, 0)));
        map2.put(LocalDate.of(2024,4,7), new Pair<>(LocalTime.of(10, 0), LocalTime.of(14, 0)));

        Church church1 = new Church("Trinity Church",map1);
        Concert concert1 = new Concert("Yeat",map1, 500);
        Statue statue1 = new Statue("Statue of Liberty", map1);

        Church church2 = new Church("Church of the Blessed Sacrament", map2);
        Concert concert2 = new Concert("SosMula", map2, 399.9);
        Statue statue2 = new Statue("Christ the Redeemer", map2);

        //System.out.println(concert1);
        //System.out.println(church1);
        Trip t1 = new Trip("New York",new Pair<>(LocalDate.of(2024,3,17), LocalDate.of(2024,3,22)), church1, concert1, statue1);
        Trip t2 = new Trip("Rio de Janeiro",new Pair<>(LocalDate.of(2024,4,1), LocalDate.of(2024,4,4)), church2, concert2);
        //System.out.println(t1);
        //t1.printVisitableNotPayable();

        TravelPlan travel = new TravelPlan(t1,t2);
        System.out.println(travel);
    }
}
