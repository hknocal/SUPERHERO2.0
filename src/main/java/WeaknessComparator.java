import java.util.Comparator;

public class WeaknessComparator implements Comparator<Superhero> {
    @Override
    public int compare (Superhero o1, Superhero o2) {
        return o1.getSuperheroWeakness().compareTo(o2.getSuperheroWeakness());
    }

}