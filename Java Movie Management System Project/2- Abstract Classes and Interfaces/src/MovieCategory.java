import java.util.ArrayList;
import java.util.List;
/**
 * name:Milad Ghavami
 * assignment: Midterm
 * date: 04/22/2023
 * This class represents a ListOfTheMovie.
 */
public class MovieCategory {
    private List<Movie> movieList;
    /**
     * Constructs a new MovieCategory object with an empty list of movies.
     */
    public MovieCategory() {
        this.movieList = new ArrayList<>();
    }
    /**
     * Adds a movie to the list of movies in this category.
     * @param m1 the movie to be added.
     */
    public void add(Movie m1){
        movieList.add(m1);
    }
    /**
     * Checks whether this category has any movies.
     * @return true if the category has no movies, false otherwise.
     */
    public boolean isEmpty(){
        return movieList.isEmpty();
    }
    /**
     * Gets the movie at the specified index in this category's list of movies.
     * @param i the index of the movie .
     * @return the movie at the specified index.
     */
    public Movie getIndexMovie(int i){
        return movieList.get(i);
    }
    /**
     * Gets the number of movies in this category.
     * @return the number of movies.
     */
    public int getSize(){
        return movieList.size();
    }
    /**
     * Calculates the average rating of all the movies in the list.
     * @return the average rating.
     */
    public double getAverageRating(){
        double sum = 0;
        for(Movie movie : movieList){
            sum += movie.getRating();
        }
        return sum/getSize();
    }
    /**
     * Gets the highest rated movie in this category.
     * @return the highest rated movie.
     */
    public Movie getHighestRated(){
        var highRatingMovie = movieList.get(0);
        for(Movie movie : movieList){
            if(movie.getRating() > highRatingMovie.getRating()){
                highRatingMovie = movie;
            }
        }
        return highRatingMovie;
    }
    /**
     * Prints the details of all the good movies in this category.
     */
    public void PrintGood() {
        for (Movie movie : movieList) {
            if (movie.isGood()) {
                System.out.println(movie);
            }
        }
    }
}
