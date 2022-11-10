import java.util.*;

public class UserInterface {

    Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();

    public void createUI() {
        //LOAD DB
        controller.loadDB();

        while (true) {
            System.out.println("""
                    Please type the number of which option you wanna use:
                    1. create superhero(es).
                    2. Manuel search.
                    3. Show database of heroes.
                    4. Remove superhero.
                    5. Search for superhero using parameter.
                    6. Edit superhero.
                    7. Search for superhero using two parameters.
                    8. Save 
                    9. Exit
                    """);
            switch (readInt()) {
                case 1:
                    addHeroToDatabase();
                    break;
                case 2:
                    searchForHero();
                    break;
                case 3:
                    controller.printDB();
                    break;
                case 4:
                    removeSuperhero();
                    break;
                case 5:
                    databaseSortCriteria();
                    break;
                case 6:
                    editSuperheroes();
                    break;
                case 7:
                    sortByTwoCriteria();
                    break;
                case 8:
                    controller.saveToDB();
                    break;
                case 9:
                    System.out.println("Closing database");
                    System.exit(0);
                default:
                    System.out.println("Could not handle input. Please type again");
                    break;
            }
        }
    }

    private void databaseSortCriteria() {

        System.out.println("""
                Please type a number and press ENTER to indicate which option you wanna sort the database by.
                1. Sort by name.
                2. Sort by height.
                3. Sort by powers.
                4. Sort by weakness.             
                """);

        switch (readInt()) {
            case 1:
                System.out.println("Sorted by name");
                ArrayList<Superhero> sortedByName = controller.database.heroList;
                Comparator<Superhero> nameComparator = new NameComparator();
                Collections.sort(sortedByName, nameComparator);
                for (Superhero s: sortedByName){
                    System.out.println(s.toString());
                }
                break;
            case 2:
                System.out.println("Sorted by height");
                ArrayList<Superhero> sortedByHeight = controller.database.heroList;
                Comparator<Superhero> heightComparator = new HeightComparator();
                Collections.sort(sortedByHeight, heightComparator);
                for (Superhero s: sortedByHeight) {
                    System.out.println(s.toString());
                }
                break;
            case 3:
                System.out.println("Sorted by power(s)");
                ArrayList<Superhero> sortedByPower = controller.database.heroList;
                Comparator<Superhero> powerComparator = new PowerComparator();
                Collections.sort(sortedByPower, powerComparator);
                for (Superhero s: sortedByPower){
                    System.out.println(s.toString());
                }
                break;
            case 4:
                System.out.println("Sorted by weakness(ess)");
                ArrayList<Superhero> sortedByWeakness = controller.database.heroList;
                Comparator<Superhero> weaknessComparator = new WeaknessComparator();
                Collections.sort(sortedByWeakness, weaknessComparator);
                for (Superhero s : sortedByWeakness){
                    System.out.println(s.toString());
                }
                break;
            default:
                System.out.println("Wrong input, please enter one of the correct number");
                break;
        }
    }

    public void sortByTwoCriteria() {

        Comparator<Superhero> comparatorOne = null;
        Comparator<Superhero> comparatorTwo = null;

        System.out.println("""
                Enter first criteria, then press ENTER.                 
                1. Name.
                2. Height.
                3. Power(s).
                4. Weakness(ess)
                """);

        switch (readInt()) {
            case 1:
                comparatorOne = new NameComparator();
                break;
            case 2:
                comparatorOne = new HeightComparator();
                break;
            case 3:
                comparatorOne = new PowerComparator();
                break;
            case 4:
                comparatorOne = new WeaknessComparator();
                break;
        }

        if (comparatorOne != null) {

            System.out.println("Enter second criteria and press ENTER.");

            switch (readInt()) {
                case 1:
                    comparatorTwo = new NameComparator();
                    break;
                case 2:
                    comparatorTwo = new HeightComparator();
                    break;
                case 3:
                    comparatorTwo = new PowerComparator();
                    break;
                case 4:
                    comparatorTwo = new WeaknessComparator();
                    break;

            }
        }


        if (comparatorOne != null && comparatorTwo != null) {
            Collections.sort(controller.database.getHeroList(), comparatorOne.thenComparing(comparatorTwo));
        }

        if (comparatorOne != null) {
            Collections.sort(controller.database.getHeroList(), comparatorOne);
        }
        for (Superhero s : controller.database.getHeroList()) {
            System.out.println(s.toString());
        }
    }

    public void addHeroToDatabase() {

        try {
            System.out.println(" ");
            System.out.println("Time to create a new hero.\nFirst off, please type the name of the hero and press ENTER: ");
            String heroName = sc.nextLine();
            System.out.println("You have chosen the name of the new hero to be: " + heroName);
            System.out.println(" ");

            System.out.println("Please enter the height of the hero: \nPlease comma (,) to seperate priods and press ENTER");
            double heroHeight = readDouble();
            System.out.println("You have chosen height to be: " + heroHeight);
            System.out.println(" ");

            sc.nextLine();

            System.out.println("Please enter the power(s) of the hero. \nIf the hero has more than one power, use comma (,) or period (.) to seperate them. ");
            String heroPower = sc.nextLine();
            System.out.println("You have chosen power(s) to be: " + heroPower);
            System.out.println(" ");


            System.out.println("Please enter the weakness(es) of the hero. \nIf the hero has more than one weakness(es), use comma (,) or period (.) to seperate them. ");
            String heroWeakness = sc.nextLine();
            System.out.println("You have chosen weakness(es) to be: " + heroWeakness);
            System.out.println(" ");


            System.out.println("Write if the superhero origin is from planet earth. \nPlease write 1 if he/she is from earth and press ENTER. \nPlease write 2 if he/she is not from planet earth and press ENTER");
            boolean heroHumanOrNot = true;
            switch (readInt()) {
                case 1:
                    heroHumanOrNot = true;
                    System.out.println("You have declared the superheros origin as: 'from planet earth");
                    System.out.println(" ");
                    break;
                case 2:
                    heroHumanOrNot = false;
                    System.out.println("You have declared the superheroes origin as: not from planet earth");
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Wrong input. Origin og the new hero has been sat to: From planet earth\nPlease use 'Edit superheroes' if you wish to change it.");
                    System.out.println(" ");
                    break;
            }

            controller.addHeroToDatabase(heroName, heroHeight, heroPower, heroWeakness, heroHumanOrNot);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void searchForHero() {

        System.out.println("Please type the option you wanna use, by typing its correspondign number and press ENTER");
        System.out.println("\n1 search using name " +
                "\n2 search using height " +
                "\n3 search using power(s)" +
                "\n4 search using weakness(es)" +
                "\n5 search using origin.");
        switch (readInt()) {
            case 1:
                System.out.println("Type the name of the hero you wanna search for: ");
                String searchName = sc.nextLine();
                ArrayList<Superhero> searchResultName = controller.searchByName(searchName);

                Collections.sort(searchResultName, Comparator.comparing(Superhero::getSuperheroName));
                System.out.println("Your search on " + searchName + " gave these results");
                System.out.println(searchResultName);
                break;
            case 2:
                System.out.println("Type the height of the hero you wanna search for: ");
                double searchHeight = readDouble();
                ArrayList<Superhero> searchResultHeight = controller.searchByHeight(searchHeight);

                Collections.sort(searchResultHeight, Comparator.comparing(Superhero::getSuperheroHeight));
                System.out.println("Your search on " + searchHeight + " gave these results");
                System.out.println(searchResultHeight);
                break;
            case 3:
                System.out.println("Type the power(s) of the hero you wanna search for: ");
                String searchPower = sc.nextLine();
                ArrayList<Superhero> searchResultPower = controller.searchByPower(searchPower);

                Collections.sort(searchResultPower, Comparator.comparing(Superhero::getSuperheroPower));
                System.out.println("Your search on " + searchPower + " gave these results");
                System.out.println(searchResultPower);
                break;
            case 4:
                System.out.println("Type the weakness(es) of the hero you wanna search for:\nSeperate each power using comma (,)");
                String searchWeakness = sc.nextLine();
                ArrayList<Superhero> searchWithParameters = controller.searchByWeakness(searchWeakness);

                Collections.sort(searchWithParameters, Comparator.comparing(Superhero::getSuperheroWeakness));
                System.out.println("Your search on " + searchWeakness + " gave these results");
                System.out.println(searchWithParameters);
                break;
            case 5:
                System.out.println("Type one of the parameters and press ENTER: \n1. Origin FROM earth. \n2. Origin NOT from earth ");
                int searchOrigin = readInt();
                boolean searchOrginBoolean = false;
                if (searchOrigin == 1) {
                    searchOrginBoolean = true;
                    ArrayList<Superhero> searchResultOrgin = controller.searchByOrigin(searchOrginBoolean);
                    Collections.sort(searchResultOrgin, Comparator.comparing(Superhero::getSuperheroHumanOrNot));
                    System.out.println(searchResultOrgin);
                } else if (searchOrigin == 2) {
                    searchOrginBoolean = false;
                    ArrayList<Superhero> searchResultOrgin = controller.searchByOrigin(searchOrginBoolean);
                    Collections.sort(searchResultOrgin, Comparator.comparing(Superhero::getSuperheroHumanOrNot));
                    System.out.println(searchResultOrgin);
                } else {
                    System.out.println("Invalid input. Not entered 1 or 2. Returning to menu.");
                }
                break;
            case 6:
                System.out.println("Please enter the first parameter you want \nEnter number and press ENTER to select first parameter");
                break;
            default:
                System.out.println("Wrong input. Origin og the new hero has been sat to: From planet earth\nPlease use 'Edit superheroes' if you wish to change it.");
                break;
        }
    }

    public void editSuperheroes() {
        try {
            System.out.println("Enter the number of which superhero you wanna edit: ");
            for (int i = 0; i < controller.getHeroList().size(); i++) {
                System.out.println(i + 1 + ":" + controller.getHeroList().get(i));
            }
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            sc.nextLine();

            Superhero editSuperhero = controller.getHeroList().get(number - 1);
            System.out.println("Adjusting following superhero " + editSuperhero);


            System.out.println("Edit data and press ENTER. If you do not wish to edit any data press ENTER");
            System.out.println("Currently editing superhero name: " + editSuperhero.getSuperheroName());
            String superheroNewName = sc.nextLine();
            if (!superheroNewName.isEmpty())
                editSuperhero.setSuperheroName(superheroNewName);

            System.out.println("Edit data and press ENTER. If you do not wish to edit data enter 0 and press ENTER");
            System.out.println("Currently editing superhero height: " + editSuperhero.getSuperheroHeight());
            double superheroNewHeight = readDouble();
            if (superheroNewHeight > 0) {
                editSuperhero.setSuperheroHeight(superheroNewHeight);
            } else if (superheroNewHeight == 0) {
                System.out.println("No changes made to height");
            }


            System.out.println("Edit data and press ENTER. If you do not wish to edit any data press ENTER");
            System.out.println("Currently editing superhero powers: " + editSuperhero.getSuperheroPower());
            String superheroNewPower = sc.nextLine();
            if (!superheroNewPower.trim().isEmpty())
                editSuperhero.setSuperheroPower(superheroNewPower);

            System.out.println("Edit data and press ENTER. If you do not wish to edit any data press ENTER");
            System.out.println("Currently editing superhero weakness(s): " + editSuperhero.getSuperheroWeakness());
            String superheroNewWeakness = sc.nextLine();
            if (!superheroNewWeakness.trim().isEmpty())
                editSuperhero.setSuperheroWeakness(superheroNewWeakness);

            System.out.println("Edit data and press ENTER. If you do not wish to edit any data press ENTER");
            System.out.println("Currently editing superhero origin. \nPress 1 and press ENTER if origin is from earth. \nPress 2 and ENTER if origin is not from earth.\nPress 3 and ENTER if you do not wish to change origin.");
            int superheroNewOrigin = readInt();
            if (superheroNewOrigin == 1) {
                editSuperhero.setSuperheroHumanOrNot(true);
            } else if (superheroNewOrigin == 2) {
                editSuperhero.setSuperheroHumanOrNot(false);
            } else if (superheroNewOrigin == 3) {
                System.out.println("No changes to origin");
            } else {
                System.out.println("Not a valid option. No changes to origin..");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No hero with corresponding number to edit.\nReturning to main menu");
        }
    }

    public void removeSuperhero() {
        try {
            for (int i = 0; i < controller.getHeroList().size(); i++) {
                System.out.println(i + ":" + controller.showDatabase().get(i));
            }
            System.out.println("Enter the number of which superhero you wanna remove: ");
            int number = readInt();

            controller.removeSuperhero(number);

            System.out.println();

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No hero with associated number exist\n Returning to main menu.");
        }
    }


    private double readDouble() {

        boolean validateHeight = true;
        double height = 0;

        do {
            try {

                height = sc.nextDouble();
                validateHeight = false;


            } catch (Exception e) {
                System.out.println("Input is not viable\nPlease only enter whole numbers and seperate priods with comma (,)");
                sc.nextLine();
            }
        }
        while (validateHeight);
        return height;
    }

    private int readInt() {

        boolean validateInt = true;
        int integer = 0;

        do {
            try {

                integer = sc.nextInt();
                validateInt = false;
                sc.nextLine();


            } catch (Exception e) {
                System.out.println("Input is not viable \nPlease only enter whole numbers.");
                sc.nextLine();
            }
        }
        while (validateInt);
        return integer;
    }


}