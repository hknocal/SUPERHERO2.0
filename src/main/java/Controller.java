import java.util.ArrayList;

public class Controller {

    Database database = new Database();

    FileHandler filehandler = new FileHandler();

    public void addHeroToDatabase(String heroName, double heroHeight, String heroPower, String heroWeakness, boolean heroHumanOrNot) {
        database.addHeroToDatabase(heroName, heroHeight, heroPower, heroWeakness, heroHumanOrNot);
    }

    public ArrayList<Superhero> showDatabase() {
        return getHeroList();
    }



    public ArrayList<Superhero> getHeroList(){
        return database.getHeroList();
    }


    public void removeSuperhero(int number) {
        database.heroList.remove(number);
    }

    public ArrayList<Superhero> searchByName(String searchName) {
        return database.searchByName(searchName);
    }


    public ArrayList<Superhero> searchByHeight(double searchHeight) {
        return database.searchByHeight(searchHeight);
    }

    public ArrayList<Superhero> searchByPower(String searchPower) {
        return database.searchByPower(searchPower);
    }

    public ArrayList<Superhero> searchByWeakness(String searchWeakness) {
        return database.searchByWeakness(searchWeakness);
    }

    public ArrayList<Superhero> searchByOrigin(boolean searchOrginBoolean) {
        return database.searchByOrigin(searchOrginBoolean);
    }

    public ArrayList<Superhero> searchByParameters() {
        return database.heroList;
    }


    public void loadDB() {
        database.setHeroList(filehandler.loadDB());
    }

    public void printDB() {
        database.printDB();
    }

    public void saveToDB() {
        filehandler.saveToDB(database.getHeroList());
    }
}
