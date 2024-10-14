import java.util.ArrayList;
/**
 * A class representing a movie store that maintains a list of movies.
 * It provides methods to add, remove, and search for movies based on their titles and genres.
 */
// this class is model because the business logic and data of the application are represented.
public class MovieStoreModel implements MovieStoreModelInterface{
    private ArrayList<Movie> movie;
    /**
     * Constructor for the MovieStore class. Initializes the movie list.
     */
    public MovieStoreModel() {
        movie = new ArrayList<>();
    }
    /**
     * Adds a movie to the store.
     *
     * @param m The Movie object to be added to the store.
     */
    @Override
    public void addMovie(Movie m) {
        this.movie.add(m);
    }
    /**
     * Removes a movie from the store based on its index.
     *
     * @param index The 1-based index of the movie to be removed from the store.
     */
    @Override
    public void removeMovie(int index) {
        movie.remove(index - 1);
    }
    /**
     * Searches for movies in the store by their title and prints them.
     *
     * @param title A string representing the title to search for.
     */
    @Override
    public void searchMoviesByTitle(String title) {
        movie.stream().filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(m -> System.out.println(m));
    }
    /**
     * Searches for movies in the store by their genre and prints them.
     *
     * @param genres A string representing the genre to search for.
     */
    @Override
    public void  searchMoviesByGenre(String genres) {
        movie.stream().filter(m -> m.getGenre().toLowerCase().contains(genres.toLowerCase()))
                .forEach(m -> System.out.println(m));
    }
    /**
     * Returns the list of movies in the store.
     *
     * @return An ArrayList of Movie objects representing the movies in the store.
     */
    @Override
    public ArrayList<Movie> getMovies() {
        return movie;
    }
}
