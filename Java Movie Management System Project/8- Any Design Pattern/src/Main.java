/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// theme: Imagine that we want to create a program for a movie shop that would alert users when a new movie is released.
// Observer Patterns define a one-to-many dependency between objects so that when one object (the subject) changes state,
// all its dependents (observers) are notified and updated.

// The pattern I want to discuss is the observer pattern.
// Observer Patterns define a one-to-many dependency between objects so that when one object (the subject) changes state,
// all its dependents (observers) are notified and updated.
public class Main {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        var m1 = new Movie(MovieGenres.action, "Demon Slayer the Movie: Mugen Train",2020, 8);
        var m2 = new Movie(MovieGenres.action, "All Quiet on the Western Front",2022, 7);
        var m3 = new Movie(MovieGenres.drama, "No Time to Die",2021, 7);

        User user1 = new User("jack", movieStore);
        User user2 = new User("tomas", movieStore);

        movieStore.newMovieRelease(m1);
        System.out.println("");
        movieStore.newMovieRelease(m2);
        System.out.println("");
        movieStore.newMovieRelease(m3);

        movieStore.removeUserObserver(user2);
    }
}