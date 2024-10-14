import java.util.Set;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 *
 * The MovieListImpl class provides a simple implementation of a movie and theater list.
 * This class uses the MovieStoreList interface and its implementations (EmptyNode, MovieNode, TheaterNode) to manage the list.
 */
public class MovieListImpl {
    MovieStoreList head;
    /**
     * Constructs an empty MovieListImpl instance.
     */
    public MovieListImpl(){
        head = new EmptyNode();
    }
    /**
     * Adds a movie to the list.
     *
     * @param title  the movie's title
     * @param releaseYear the movie's release year
     * @param rating the movie's rating
     * @param genre  the movie's genre
     */
    public void addMovie(String title, int releaseYear, float rating, MovieGenres genre){
        head = new MovieNode(title, releaseYear, genre, rating, head);
    }
    /**
     * Adds a theater to the list.
     *
     * @param title   the theater's title
     * @param releaseYear the theater's release year
     * @param rating  the theater's rating
     * @param genre   the theater's genre
     */
    public void addTheater(String title, int releaseYear, float rating, TheaterGenres genre){
        head = new TheaterNode(title, releaseYear, genre, rating, head);
    }
    /**
     * Returns the number of movies in the list.
     *
     * @return the number of movies
     */
    public int getNumberOfMovies() { // recursive method
        return head.getNumberOfMovies(); // Head checks all the nodes in MovieStoreList and performs them .
    }
    /**
     * Returns the number of theaters in the list.
     *
     * @return the number of theaters
     */
    public int getNumberOfTHeater(){ // recursive method
        return head.getNumberOfTHeater();
    }
    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() { // recursive method
        return head.toString();
    }
    /**
     * Returns a set of MovieNode instances that match the specified genre.
     *
     * @param genre the genre to filter by
     * @return a set of MovieNode instances with the specified genre
     */
    public Set<MovieNode> getGenreByFilter(MovieGenres genre) { // recursive method
        return head.getGenreByFilter(genre);
    }















}
