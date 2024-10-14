/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// subject interface
public interface MovieStoreSubject {
    /**
     * Adds a user observer to the userObservers list.
     *
     * @param observer the UserObserver to be added.
     */
    void addUserObserver(UserObserver observer);
    /**
     * Removes a user observer from the userObservers list.
     *
     * @param observer the UserObserver to be removed.
     */
    void removeUserObserver(UserObserver observer);
    /**
     * Notifies all user observers in the userObservers list about the new movie release.
     */
    void notifyUserObservers();
}
