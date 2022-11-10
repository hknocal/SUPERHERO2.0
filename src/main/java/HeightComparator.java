import java.util.Comparator;

public class HeightComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Double.compare(o1.getSuperheroHeight(),o2.getSuperheroHeight());
    }
}
