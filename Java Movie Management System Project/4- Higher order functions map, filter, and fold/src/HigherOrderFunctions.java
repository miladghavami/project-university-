import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 *  name:Milad Ghavami
 *  assignment: final project
 *  date: 04/19/2023
 *  The HigherOrderFunctions class provides methods to store a list of Movie objects.
 */

// We create a list of movies and stream them using the stream function.
// After that, we can implement Higher order functions map, filter, and fold in this list.
public class HigherOrderFunctions {
    private List<Movie> movies;
    /**
     * Constructor for the HigherOrderFunctions class. Initializes an empty list of Movie objects.
     */
    public HigherOrderFunctions (){
        this.movies =new ArrayList<>();
    }
    /**
     * Getter for the list of movies.
     *
     * @return List of Movie objects
     */
    public List<Movie> getMovies(){
        return movies;
    }
    /**
     * Returns the total number of movies in the list.
     *
     * @return The count of movies
     */
    // reducer: count: the number of object in the list.
    public long count(){
        return movies.stream().count();
    }
    /**
     * Prints the titles of movies with a rating greater than 7.5.
     */
    // filter: The filter operation selects elements from a collection that satisfy a condition (predicate).
    // filter(predicate)
    // forEach: print the every object in the list
    // stream: A stream is a sequence of elements that can be processed in parallel.
    // Once you have a stream, you can apply various operations on it.
    public void printIsGoodMovie(){
        movies.stream().filter(m -> m.getRating() > 7.5).forEach(m -> System.out.println(m.getTitle()));
    }
    /**
     * Prints the titles of all movies in the list.
     */
    // map: transforms each element in a collection by applying a function
    // map(Function)
    public void printTitleMovie(){
        movies.stream().map(movie -> movie.getTitle()).forEach(name -> System.out.println(name));
    }
    /**
     * Prints the titles of all movies in the list.
     */
    //map
    public void printReleaseDateMovie(){
        movies.stream().map(movie -> movie.getReleaseDate()).forEach(R -> System.out.println(R));
    }
    /**
     * Prints the ratings of all movies in the list.
     */
    //map
    public void printRatingMovie(){
        movies.stream().map(movie -> movie.getRating()).forEach(R -> System.out.println(R));
    }
    /**
     * Prints the titles of movies sorted by release date.
     */
    // sort: it is a stream method  that returns a sorted view of the stream elements.
    // Comparator.comparing(): it is a method in Java that creates a comparator based on a given function.
    public void sortReleaseDate(){
        movies.stream().sorted(Comparator.comparing(movie -> movie.getReleaseDate())).forEach(m -> System.out.println(((Movie) m).getTitle()));
    }
    /**
     * Returns the movie with the highest rating in the list.
     *
     * @return The Movie object with the highest rating
     */
    // max(): is a stream method  that returns the maximum element of the stream.
    public Movie maxRating(){
        return movies.stream().max(Comparator.comparing(m -> m.getRating())).get();
    }
    /**
     * Returns the list of movies as a new List object.
     *
     * @return The list of Movie objects
     */
    public Object toList(){
        return movies.stream().collect(Collectors.toList());
    }
    /**
     * Returns the count of movies in the list with a specified genre.
     *
     * @param genres The genre to filter the movies by
     * @return The count of movies with the specified genre
     */
    //fold(reduce): Folding or reducing elements into a single value is done by applying a function repeatedly.
    public int getSizeByGenres(MovieGenres genres) {
        return movies.stream().map(e-> {
            if (e.getGenre() == genres) { //condition to be counted
                return 1;
            } else {
                return 0;
            }
        }).reduce(0,(a,b)->a+b);
    }
}
