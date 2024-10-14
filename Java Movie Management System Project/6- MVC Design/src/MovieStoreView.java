import java.util.ArrayList;
import java.util.Scanner;
/**
 * A class representing the user interface for a movie store application.
 * This class handles user interactions, such as reading input, displaying movies, and presenting menu options.
 */
// This class is responsible for viewing. The view displays data from the Model to the user.
// This class handles user interactions, such as reading input, displaying movies, and presenting menu options.
public class MovieStoreView {
    private Scanner scanner;
    /**
     * Constructor for the MovieStoreView class. Initializes the scanner object.
     */
    public MovieStoreView() {
        scanner = new Scanner(System.in); // The Scanner class is used to read input
    }
    /**
     * Reads a line of text from the user input and returns it as a string.
     *
     * @return A string representing the user input.
     */
    public String getUserInput() {
        return scanner.nextLine();
    }
    /**
     * Displays a list of movies.
     *
     * @param movie An ArrayList of Movie objects representing the movies to display.
     */
    public void displayMovies(ArrayList<Movie> movie) {
        int index = 1;
        for (Movie movie1 : movie) {
            System.out.println(index +"- "+ movie1);
            index++;
        }
    }
    /**
     * Displays the available menu options to the user.
     */
    public void displayMenu() {
        System.out.println("\nPlease choose an action:");
        System.out.println("1. Add movie");
        System.out.println("2. Remove movie");
        System.out.println("3. Search movie by title");
        System.out.println("4. Search movie by genre");
        System.out.println("5. Exit");
    }
    /**
     * Prompts the user to enter a movie title and returns it as a string.
     *
     * @return A string representing the movie title entered by the user.
     */
    public String askForMovieTitle() {
        System.out.print("Enter the movie title: ");
        String title = getUserInput();
        return title;
    }
    /**
     * Prompts the user to enter a movie genre and returns it as a string.
     *
     * @return A string representing the movie genre entered by the user.
     */
    public String askForMovieGenre() {
        System.out.print("Enter the genre: ");
        String genre = getUserInput();
        return genre;
    }
    /**
     * Prompts the user to enter a movie index and returns it as an integer.
     *
     * @return An integer representing the movie index entered by the user.
     */
    public int askForMovieIndex() {
        System.out.print("Enter the movie number: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        return index;
    }
}
