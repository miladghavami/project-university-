/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/22/2023
 * Represents a movie class and has release title, and genre as attribute.
 */
public class Movie {
    private String title;
    private String genre;
    /**
     * Constructs a new Movie object with no input.
     */
    public Movie(){
        this.title = "unKnown";
        this.genre = "unKnown";
    }
    /**
     * Constructs a new Movie object with title.
     *
     * @param title  The title of the movie.
     */
    public Movie(String title){

        this.title = title;
        this.genre = "unKnown";
    }
    /**
     * Constructs a new Movie object with genre, title.
     *
     * @param genre   The genre of the movie.
     * @param title   The title of the movie.
     */
    public Movie(String genre, String title){
        this.genre = genre;
        this.title = title;
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
    public String getGenre(){
        return genre;
    }
    /**
     * Returns a string representation of a movie object.
     *
     * @return A string representation of a movie object.
     */
    @Override
    public String toString() {
        String  str = "genre: "+ getGenre() +", title: "+ this.getTitle();
        return str;
    }
}

