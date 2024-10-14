/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/20/2023
 * Represents a movie class and has release date, rating, title, and genre as attribute.
 */
abstract class Movie implements IBest {
    private int releaseDate;
    private double rating;
    private String title;
    private MovieGenres genre;
    /**
     * Constructs a new Movie object with no input.
     */
    public Movie(){
        this.releaseDate = 0;
        this.rating = 0;
        this.title = "unKnown";
        this.genre = MovieGenres.unKnown;
    }
    /**
     * Constructs a new Movie object with title, release date, and rating.
     *
     * @param title  The title of the movie.
     * @param releaseDate The release date of the movie.
     * @param rating  The rating of the movie.
     */
    public Movie(String title, int releaseDate, double rating){
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.title = title;
        this.genre = MovieGenres.unKnown;
    }
    /**
     * Constructs a new Movie object with genre, title, release date, and rating.
     *
     * @param genre   The genre of the movie.
     * @param title   The title of the movie.
     * @param releaseDate The release date of the movie.
     * @param rating   The rating of the movie.
     */
    public Movie(MovieGenres genre, String title, int releaseDate, double rating){
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.title = title;
    }
    /**
     * Returns the release date of the movie.
     *
     * @return The release date of the movie.
     */
    public int getReleaseDate(){
        return releaseDate;
    }
    /**
     * Returns the rating of the movie.
     *
     * @return The rating of the movie.
     */
    public double getRating(){
        return rating;
    }
    /**
     * Returns the title of the movie.
     *
     * @return The title of the movie.
     */

    public String getTitle(){
        return title;
    }
    /**
     * Returns the genre of the movie.
     *
     * @return The genre of the movie.
     */
    public MovieGenres getGenre(){
        return genre;
    }
    /**
     * Returns a string representation of a movie object.
     *
     * @return A string representation of a movie object.
     */
    @Override
    public String toString() {
        String  str = "genre: "+ getGenre() +", title: ("+ this.getTitle() + "), release date: "
                + this.getReleaseDate() + ", rating: "+ this.getRating();
        return str;
    }
}
