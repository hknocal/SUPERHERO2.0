import java.util.Comparator;

public class HumanOrNotComparatorFalse implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Boolean.compare(o1.getSuperheroHumanOrNot() == false,o2.getSuperheroHumanOrNot() == true);
    }
}
