import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File heroCSV = new File("src/herolist.csv");

    public void saveToDB(ArrayList <Superhero> heroList) {
        FileWriter writer;
        try {
            writer = new FileWriter(heroCSV);
            for (Superhero s : heroList) {
                writer.write(s.csvToString());
                writer.write("\n");
            }
            writer.close();
            if(heroList.isEmpty()){
                System.out.println("No hero(s) was saved to DB.");
            }
            if(!heroList.isEmpty()){
                System.out.println(heroList.size() + " heroes was saved to DB.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Superhero> loadDB() {
        ArrayList<Superhero> listOfHeroes = new ArrayList<>();
        try {
            Scanner sc = new Scanner(heroCSV);
            while(sc.hasNextLine()) {
                String[] Strings = sc.nextLine().split(",");
                Superhero s = new Superhero(
                        Strings[0],
                        Double.parseDouble(Strings [1]),
                        Strings[2],
                        Strings[3],
                        Boolean.parseBoolean(Strings [4])
                );
                listOfHeroes.add(s);
            }
            sc.close();
            if (listOfHeroes.isEmpty()) {
                System.out.println("No heroes was found in the file.");
            }
            return listOfHeroes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
