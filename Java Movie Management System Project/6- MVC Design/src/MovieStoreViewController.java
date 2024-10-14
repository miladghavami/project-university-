/**
 * A class representing the controller for a movie store application.
 * This class connects the MovieStore and the MovieStoreView, allowing them to interact with each other.
 */
// this class representing the controller for a movie store application.
// This class connects the MovieStore and the MovieStoreView, allowing them to interact with each other.
public class MovieStoreViewController implements MovieStoreViewControllerInterface {
    private MovieStoreModel movieStore;
    private MovieStoreView movieStoreView;
    /**
     * Constructor for the MovieStoreViewController class. Initializes the movieStore and movieStoreView objects.
     *
     * @param movieStore     The MovieStore object representing the model.
     * @param movieStoreView The MovieStoreView object representing the view.
     */
    public MovieStoreViewController(MovieStoreModel movieStore, MovieStoreView movieStoreView) {
        this.movieStore = movieStore;
        this.movieStoreView = movieStoreView;
    }
    /**
     * Displays the list of movies, the menu, and handles user input.
     */
    @Override
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("list of movies:");
            movieStoreView.displayMovies(movieStore.getMovies());
            movieStoreView.displayMenu();
            String input = movieStoreView.getUserInput();
            switch (input) {
                case "1":
                    // Add movie
                    addMovie();
                    break;
                case "2":
                    // Remove book
                    removeMovie();
                    break;
                case "3":
                    // Search books by title
                    SearchMovieTitle();
                    break;
                case "4":
                    // Search books by genre
                    SearchMovieGenre();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    // we have some private methods because I want to handle better user input,
    // and the reason they are private is that they do not need to be accessed outside the class.
    /**
     * Prompts the user to enter movie details and adds a new movie to the store.
     */
    private void addMovie() {
        String title = movieStoreView.askForMovieTitle();
        String genre = movieStoreView.askForMovieGenre();
        var m = new Movie(genre, title);
        movieStore.addMovie(m);
    }
    /**
     * Prompts the user to enter a movie index and removes the movie from the store.
     */
    private void removeMovie() {
        int movieIndex = movieStoreView.askForMovieIndex();
        movieStore.removeMovie(movieIndex);
    }
    /**
     * Prompts the user to enter a movie title, searches for movies with that title.
     */
    private void SearchMovieTitle(){
        String title = movieStoreView.askForMovieTitle();
        System.out.println("we found these movies: ");
        movieStore.searchMoviesByTitle(title);
        System.out.println("\n");
    }
    /**
     * Prompts the user to enter a movie genre, searches for movies of that genre, and displays the results.
     */
    private void SearchMovieGenre(){
        String genre = movieStoreView.askForMovieGenre();
        System.out.println("we found these movies: ");
        movieStore.searchMoviesByGenre(genre);
        System.out.println("\n");
    }
}
