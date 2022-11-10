import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {

    ArrayList<Superhero> heroList = new ArrayList<>();

    public Database (){
    }

    public void addHeroToDatabase(String heroName, double heroHeight, String heroPower, String heroWeakness, boolean heroHumanOrNot) {
        heroList.add(new Superhero(heroName, heroHeight, heroPower, heroWeakness, heroHumanOrNot));
    }


    public ArrayList<Superhero> getHeroList() {
        return heroList;
    }

    public void setHeroList(ArrayList <Superhero> heroList) {
        this.heroList = heroList;
    }

    public ArrayList<Superhero> getSearchList() {
        ArrayList<Superhero> searchList = new ArrayList<>();
        Collections.sort(searchList, Comparator.comparing(Superhero::getSuperheroName));
        return searchList;
    }


    public ArrayList<Superhero> searchByName(String searchName) {
        ArrayList<Superhero> searchList = new ArrayList<>();
        for (Superhero nameSearch : heroList) {
            if (nameSearch.getSuperheroName().toLowerCase().contains(searchName.toLowerCase())) {
                searchList.add(nameSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Superhero> searchByHeight(double searchHeight) {
        ArrayList<Superhero> searchList = new ArrayList<>();
        for (Superhero heightSearch : heroList) {
            if (heightSearch.getSuperheroHeight() == searchHeight) {
                searchList.add(heightSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Superhero> searchByPower(String searchPower) {
        ArrayList<Superhero> searchList = new ArrayList<>();
        for (Superhero powerSearch : heroList) {
            if (powerSearch.getSuperheroPower().toLowerCase().contains(searchPower.toLowerCase())) {
                searchList.add(powerSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Superhero> searchByWeakness(String searchWeakness) {
        ArrayList<Superhero> searchList = new ArrayList<>();
        for (Superhero weaknessSearch : heroList) {
            if (weaknessSearch.getSuperheroWeakness().toLowerCase().contains(searchWeakness.toLowerCase())) {
                searchList.add(weaknessSearch);
            }
        }
        return searchList;
    }

    public ArrayList<Superhero> searchByOrigin(boolean searchOrginBoolean) {
        ArrayList<Superhero> searchList = new ArrayList<>();
        for (Superhero originSearch : heroList) {
            if (originSearch.getSuperheroHumanOrNot() == searchOrginBoolean)  {
                searchList.add(originSearch);
            }
        }
        return searchList;
    }


    public ArrayList<Superhero> sortedByRwoCriteria(){
        return heroList;
    }

    public void printDB() {
        System.out.println("The following heroes was found:");
        for (Superhero s : heroList) {
            System.out.println(s);
        }
    }

}




