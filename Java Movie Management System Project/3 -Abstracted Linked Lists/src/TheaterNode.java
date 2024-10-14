import java.util.Set;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 *
 * Represents a single theater node in a linked list that stores theater. Implements the MovieStoreList interface.
 */
public class TheaterNode implements MovieStoreList{
    private String title;
    private int releaseYear;
    private TheaterGenres genre;
    private MovieStoreList nextNode;
    private float rating;
    /**
     * Constructs a TheaterNode with the given parameters.
     *
     * @param title       the title of the movie
     * @param releaseYear the release year of the movie
     * @param genre       the genre of the movie
     * @param rating      the rating of the movie
     * @param nextNode    the next node in the list
     */
    public TheaterNode(String title, int releaseYear, TheaterGenres genre, float rating, MovieStoreList nextNode ){
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
        this.nextNode = nextNode;
    }
    /**
     * Returns the title of the movie.
     *
     * @return the title of the movie
     */
    @Override
    public String getTitle() {
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
     * Returns the genre of the theater.
     *
     * @return the genre of the theater.
     */
    @Override
    public TheaterGenres getGenre() {
        return genre;
    }
    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list
     */
    @Override
    public MovieStoreList getNextNode() {
        return nextNode;
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
    public int getNumberOfTHeater(){
        return 1 + nextNode.getNumberOfTHeater();
    }
    /**
     * Returns the number of movies in the list.
     *
     * @return the number of movies in the list
     */
    @Override
    public int getNumberOfMovies(){
        return 0 + nextNode.getNumberOfMovies();
    }
    /**
     * Returns a string representation of the TheaterNode object.
     *
     * @return a string representation of the TheaterNode object
     */
    @Override
    public String toString() {
        String  str = "Theater's genre: "+ getGenre() +", title: ("+ this.getTitle() + "), release date: "
                + this.getReleaseYear() + ", rating: "+ this.getRating() +".\n" + nextNode.toString();
        return str;
    }
    /**
     * Filters movies by genre and returns a set of TheaterNode objects.
     *
     * @param genre the genre to filter by.
     * @return a set of TheaterNode objects with the specified genre.
     */
    @Override
    public Set<MovieNode> getGenreByFilter(MovieGenres genre) {
        return null;
    }
}
