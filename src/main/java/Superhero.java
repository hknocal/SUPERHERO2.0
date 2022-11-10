public class Superhero {

    private String superheroName;
    private double superheroHeight;
    private String superheroPower;
    private String superheroWeakness;
    private boolean superheroHumanOrNot;


    //Konstruktør
    public Superhero(String superheroName, double superheroHeight, String superheroPower, String superheroWeakness, boolean superheroHumanOrNot) {
        this.superheroName = superheroName;
        this.superheroHeight = superheroHeight;
        this.superheroPower = superheroPower;
        this.superheroWeakness = superheroWeakness;
        this.superheroHumanOrNot = superheroHumanOrNot;
    }


    //get methods
    public String getSuperheroName() {
        return superheroName;
    }

    public double getSuperheroHeight() {
        return superheroHeight;
    }

    public String getSuperheroPower() {
        return superheroPower;
    }


    public String getSuperheroWeakness() {
        return superheroWeakness;
    }

    public boolean getSuperheroHumanOrNot() {
        return superheroHumanOrNot;
    }

    //set methods
    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public void setSuperheroHeight(double superheroHeight) {
        this.superheroHeight = superheroHeight;
    }

    public void setSuperheroPower(String superheroPower) {
        this.superheroPower = superheroPower;
    }

    public void setSuperheroWeakness(String superheroWeakness) {
        this.superheroWeakness = superheroWeakness;
    }

    Boolean setSuperheroHumanOrNot(Boolean superheroHumanOrNot) {
        this.superheroHumanOrNot = superheroHumanOrNot;
        return superheroHumanOrNot;
    }


    public String toString() {
        return "Superhero name: " + superheroName +
                " Superhero height: " + superheroHeight +
                " Superhero power(s): " + superheroPower +
                " Superhero weakness(s): " + superheroWeakness +
                " Superhero origin from planet earth: " + superheroHumanOrNot + "\n";

    }

    public String csvToString() {
        return superheroName + "," + superheroHeight + "," + superheroPower + "," + superheroWeakness + "," + superheroHumanOrNot;
    }

}