import java.util.List;
import java.util.Set;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 *
 * Represents a single movie node in a linked list that stores movies.
 * Implements the MovieStoreList interface.
 */
public class MovieNode implements MovieStoreList {
    private String title;
    private int releaseYear;
    private MovieGenres genre;
    private MovieStoreList nextNode;
    private float rating;
    /**
     * Constructs a MovieNode with the given parameters.
     *
     * @param title       the title of the movie
     * @param releaseYear the release year of the movie
     * @param genre       the genre of the movie
     * @param rating      the rating of the movie
     * @param nextNode    the next node in the list
     */
    public MovieNode(String title, int releaseYear, MovieGenres genre, float rating, MovieStoreList nextNode ){
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
        this.nextNode = nextNode;
    }
    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list
     */
    @Override
    public MovieStoreList getNextNode(){
        return nextNode;
    }
    /**
     * Returns the title of the movie.
     *
     * @return the title of the movie
     */
    @Override
    public String getTitle(){
        return title;
    }
    /**
     * Returns the release year of the movie.
     *
     * @return the release year of the movie
     */
    @Override
    public int getReleaseYear() {
        return releaseYear;
    }
    /**
     * Returns the genre of the movie.
     *
     * @return the genre of the movie
     */
    @Override
    public MovieGenres getGenre() {
        return genre;
    }
    /**
     * Returns the rating of the movie.
     *
     * @return the rating of the movie
     */
    @Override
    public float getRating() {
        return rating;
    }
    /**
     * Returns the number of movies in the list.
     *
     * @return the number of movies in the list
     */
    @Override
    public int getNumberOfMovies(){
        return 1 + nextNode.getNumberOfMovies();
    }
    /**
     * Filters movies by genre and returns a set of MovieNode objects.
     *
     * @param genre the genre to filter by
     * @return a set of MovieNode objects with the specified genre
     */
    @Override
    public Set<MovieNode> getGenreByFilter(MovieGenres genre) {
        Set<MovieNode> result = nextNode.getGenreByFilter(genre);
        if (this.genre == genre) {
            result.add(this);
        }
        return result;
    }
    /**
     * Returns the number of theaters.
     *
     * @return the number of theaters.
     */
    @Override
    public int getNumberOfTHeater(){
        return 0 + nextNode.getNumberOfTHeater();
    }
    /**
     * Returns a string representation of the MovieNode object.
     *
     * @return a string representation of the MovieNode object
     */
    @Override
    public String toString() {
        String  str = "Movie's genre: "+ getGenre() +", title: ("+ this.getTitle() + "), release date: "
                + this.getReleaseYear() + ", rating: "+ this.getRating() +".\n" + nextNode.toString();
        return str;
    }
}
