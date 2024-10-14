/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// This is an interface that defines the update method, which all concrete observers need to implement.
public interface UserObserver {
    /**
     * Updates the user's movie with the new movie release.
     *
     * @param movie the new Movie object representing the current movie release
     */
    void movieUpdate(Movie movie);
}
