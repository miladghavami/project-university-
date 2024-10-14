import java.util.ArrayList;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/22/2023
 */
public interface MovieStoreModelInterface {
    /**
     * Adds a movie to the store.
     *
     * @param m The Movie object to be added to the store.
     */
    void addMovie(Movie m);
    /**
     * Removes a movie from the store based on its index.
     *
     * @param index The 1-based index of the movie to be removed from the store.
     */
    void removeMovie(int index);
    /**
     * Searches for movies in the store by their title and prints them.
     *
     * @param title A string representing the title to search for.
     */
    void searchMoviesByTitle(String title);
    /**
     * Searches for movies in the store by their genre and prints them.
     *
     * @param genres A string representing the genre to search for.
     */
    void  searchMoviesByGenre(String genres);
    /**
     * Returns the list of movies in the store.
     *
     * @return An ArrayList of Movie objects representing the movies in the store.
     */
    ArrayList<Movie> getMovies();
}
