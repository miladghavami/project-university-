import java.util.List;
import java.util.Set;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 *
 * Interface representing a list of movies with various methods.
 * @param <T> The type of movie genre.
 */
public interface MovieStoreList<T> {
    /**
     * Returns the next node in the list.
     * @return the next node in the list.
     */
    MovieStoreList getNextNode();
    /**
     * Returns the title of the movie.
     * @return the title of the movie.
     */
    String getTitle();
    /**
     * Returns the release year of the movie.
     * @return the release year of the movie.
     */
    int getReleaseYear();
    /**
     * Returns the genre of the movie.
     * @return the genre of the movie.
     */
    T getGenre();
    /**
     * Returns the rating of the movie.
     * @return the rating of the movie.
     */
    float getRating();
    /**
     * Returns the number of movies in the list.
     * @return the number of movies in the list
     */
    int getNumberOfMovies();
    /**
     * Returns the number of theaters.
     * @return the number of theaters.
     */
    int getNumberOfTHeater();
    /**
     * Returns a string representation of the MovieStoreList object.
     * @return a string representation of the MovieStoreList object.
     */
    String toString();
    /**
     * Filters movies by genre and returns a set of MovieNode objects.
     *
     * @param genre the genre to filter by
     * @return a set of MovieNode objects with the specified genre
     */
    Set<MovieGenres> getGenreByFilter(MovieGenres genre);
}
