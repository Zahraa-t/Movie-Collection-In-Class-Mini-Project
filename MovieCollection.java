import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> movieCollection;
    private Scanner scanner;

    public MovieCollection() {
        movieCollection = new ArrayList<>();
        scanner = new Scanner(System.in);
        start();
    }

    public void start() {
        readData();
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";

        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scanner.nextLine();
            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    private void readData() {
        try {
            File myFile = new File("src/movies_data.csv");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] split = data.split(",");
                String title = split[0];
                String cast = split[1];
                String director = split[2];
                String overview = split[3];
                int runtime = Integer.parseInt(split[4]);
                double userRating = Double.parseDouble(split[5]);
                Movie movie = new Movie(title, cast, director, overview, runtime, userRating);
                movieCollection.add(movie);
            }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void insertionSort(ArrayList<String> words) {
        for (int i = 1; i < words.size(); i++) {
            String store = words.get(i);
            int index = i;
            while (index > 0 && store.compareTo(words.get(index-1)) < 0) {
                words.set(index, words.get(index-1));
                index--;
            }
            words.set(index, store);
        }
    }

    private void searchTitles() {
        ArrayList<String> titles = new ArrayList<>();
        System.out.print("Enter title search: ");
        String target = scanner.nextLine().toLowerCase();
        for (Movie movi : movieCollection) {
            if (movi.getTitle().toLowerCase().indexOf(target) != -1) {
                titles.add(movi.getTitle());
            }
        }
        insertionSort(titles);

        if (titles.size() > 0) {
            int x = 1;
            for (int j = 0; j < titles.size(); j++) {
                System.out.println(x + ". " + titles.get(j));
                x++;
            }

            System.out.print("Enter the number of the movie you want to learn more about: ");
            int answer = scanner.nextInt();
            System.out.println();
            for (Movie mo : movieCollection) {
                if (titles.get(answer-1).equals(mo.getTitle())) {
                    System.out.println(mo);
                }
            }
        } else {
            System.out.println("No movie titles match your search.");
        }
    }

    private void searchCast() {
        ArrayList<String> cast = new ArrayList<>();
        System.out.print("Enter name: ");
        String target = scanner.nextLine().toLowerCase();
        for (Movie movie1 : movieCollection) {
            String actors = movie1.getCast();
            String[] split = actors.split("\\|");
            String actor = split[0];
            String actor2 = split[1];
            String actor3 = split[2];
            String actor4 = split[3];
            String actor5 = split[4];

            if (actor.toLowerCase().contains(target) && cast.indexOf(actor) == -1) {
                cast.add(actor);
            }
            if (actor2.toLowerCase().contains(target) && cast.indexOf(actor) == -1) {
                cast.add(actor2;
            }
            if (actor3.toLowerCase().contains(target) && cast.indexOf(actor) == -1) {
                cast.add(actor3);
            }
            if (actor4.toLowerCase().contains(target) && cast.indexOf(actor) == -1) {
                cast.add(actor4);
            }
            if (actor5.toLowerCase().contains(target) && cast.indexOf(actor) == -1) {
                cast.add(actor5);
            }
        }

        insertionSort(cast);
    }
}
