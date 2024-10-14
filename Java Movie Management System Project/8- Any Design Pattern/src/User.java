/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * A User class that implements the UserObserver interface.
 */
// A User class that represents a user who is also an observer in the Observer design pattern.
// Implements the UserObserver interface and receives notifications about new movie releases from the MovieStore class.
public class User implements UserObserver {
    private String name;
    private Movie movie;
    private MovieStoreSubject movieStore;
    /**
     * Constructor for the User class. adds the user as an observer to the movie store.
     *
     * @param name the user's name
     * @param movieStore the MovieStoreSubject object representing the movie store.
     */
    public User(String name, MovieStoreSubject movieStore){
        this.name = name;
        this.movieStore = movieStore;
        movieStore.addUserObserver(this);
    }
    /**
     * Updates the user's movie with the new movie release.
     *
     * @param movie the new Movie object representing the current movie release
     */
    @Override
    public void movieUpdate(Movie movie) {
        this.movie = movie;
        displayNewRelease();
    }
    /**
     * Displays the new movie release by printing a message.
     */
    public void displayNewRelease() {
        System.out.println(name + " got notified: New movie released - " + movie);
    }
}