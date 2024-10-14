import java.util.ArrayList;
import java.util.List;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * A MovieStore class that implements the MovieStoreSubject interface.
 */
// This is the main object that holds the state and is responsible for notifying observers when its state changes.
// It maintains a list of observers and provides methods to add, remove, and notify them.

public class MovieStore implements MovieStoreSubject {
    private List<UserObserver> userObservers;
    private Movie movie;
    /**
     * Constructor for the MovieStore class. Initializes the userObservers list as an empty ArrayList.
     */
    public MovieStore() {
        userObservers = new ArrayList<>();
    }
    /**
     * Adds a user observer to the userObservers list.
     *
     * @param observer the UserObserver to be added
     */
    @Override
    public void addUserObserver(UserObserver observer) {
        userObservers.add(observer);
    }
    /**
     * Removes a user observer from the userObservers list.
     *
     * @param observer the UserObserver to be removed
     */
    @Override
    public void removeUserObserver(UserObserver observer) {
        userObservers.remove(observer);
    }
    /**
     * Notifies all user observers in the userObservers list about the new movie release.
     */
    @Override
    public void notifyUserObservers() {
        for (UserObserver observer : userObservers) {
            observer.movieUpdate(movie);
        }
    }
    /**
     * notifies all user observers about it.
     *
     * @param movie the new Movie object representing the current movie release.
     */
    public void newMovieRelease(Movie movie) {
        this.movie = movie;
        notifyUserObservers();
    }
}