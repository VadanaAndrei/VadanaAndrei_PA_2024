/**
 * Clasa Solution care contine un obiect de tip Tour
 */
public class Solution
{
    private Tour t;

    /**
     * Constructorul pentru Solution care ii atribuie un tur
     * @param t Turul care ii este atribuit
     */
    public Solution(Tour t){this.t = t;}

    /**
     * Metoda care afiseaza solutia calculata in Tour
     */
    void printSolution()
    {
        t.allocateVehicles();
    }
}
