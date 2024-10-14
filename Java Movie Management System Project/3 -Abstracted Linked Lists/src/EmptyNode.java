import java.util.*;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 *
 * The EmptyNode class represents an empty object for the MovieStoreList interface.
 */
// this class indicates the last node in the link list
public class EmptyNode implements MovieStoreList {
    /**
     * Returns null as there is no next node in an empty list.
     * @return null
     */
    @Override
    public MovieStoreList getNextNode(){
        return null;
    }
    /**
     * Returns an empty string as there is no movie title.
     * @return an empty string
     */
    @Override
    public String getTitle(){
        return "";
    }
    /**
     * Returns 0 as there is no release year.
     * @return 0
     */
    @Override
    public int getReleaseYear() {
        return 0;
    }
    /**
     * Returns MovieGenres.unknown as there is no movie genre.
     * @return MovieGenres.unknown
     */
    @Override
    public MovieGenres getGenre() {
        return MovieGenres.unknown ;
    }
    /**
     * Returns 0 as there is no movie rating.
     * @return 0
     */
    @Override
    public float getRating() {
        return 0;
    }
    /**
     * Returns 0 as there is no movie count.
     * @return 0
     */
    @Override
    public int getNumberOfMovies(){// recursive method
        return 0;
    }
    /**
     * Returns an empty string as there is no toString representation.
     * @return an empty string
     */
    @Override
    public String toString() {// recursive method
        return "";
    }
    /**
     * Returns 0 as there is no number of theaters.
     * @return 0
     */
    @Override
    public int getNumberOfTHeater(){// recursive method
        return 0;
    }
    /**
     * Returns an empty HashSet as there are no movies with the specified genre.
     * @param genre the genre to filter by
     * @return an empty HashSet
     */
    @Override
    public Set<MovieNode> getGenreByFilter(MovieGenres genre) { // recursive method
        return new HashSet<>();
    }

}
