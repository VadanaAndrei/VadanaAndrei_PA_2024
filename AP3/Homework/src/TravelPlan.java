import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TravelPlan
{
    private List<Trip> trips;

    public TravelPlan(Trip ... newTrip)
    {
        trips = new ArrayList<>();
        for(Trip t : newTrip)
            trips.add(t);
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for(Trip t : trips)
            for(Atraction a : t.getAtractions())
            {
                List<LocalDate> keyList = new ArrayList<>(a.availability.keySet());
                int index = (int) (Math.random() * keyList.size());
                LocalDate dateToCheck = keyList.get(index);
                if((dateToCheck.isEqual(t.getTime().getFirst()) || dateToCheck.isAfter(t.getTime().getFirst()))
                        && (dateToCheck.isEqual(t.getTime().getSecond()) || dateToCheck.isBefore(t.getTime().getSecond())))
                    res.append(a.getName()).append(" will be visited on ").append(keyList.get(index)).append('\n');
                else
                    res.append(a.getName()).append(" will not be visited").append('\n');
            }
        return res.toString();
    }
}
