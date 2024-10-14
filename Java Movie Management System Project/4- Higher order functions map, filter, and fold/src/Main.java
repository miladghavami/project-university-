/**
 *  name:Milad Ghavami
 *  assignment: final project
 *  date: 04/19/2023
 */
// theme: Imagine a movie store where we'd like to create a list of movies with special features
// (finding max rate movie or sort movies by release date) using higher-order functions.

// Functional programming uses higher-order functions like map, filter, and fold.
// Data can be transformed and manipulated in a concise and expressive way with these functions.
public class Main {
    public static void main(String[] args) {
        var movieList = new HigherOrderFunctions();
        var m1 = new Movie(MovieGenres.action, "Demon Slayer the Movie: Mugen Train",2020, 8);
        var m2 = new Movie(MovieGenres.action, "All Quiet on the Western Front",2022, 7);
        var m3 = new Movie(MovieGenres.action, "Top Gun: Maverick",2022, 8.5);

        var m4 = new Movie(MovieGenres.drama, "No Time to Die",2021, 7);
        var m5 = new Movie(MovieGenres.drama, "F9: The Fast Saga",2020, 5);
        var m6 = new Movie(MovieGenres.drama, "Marcel the Shell with Shoes On",2021, 7);
        movieList.getMovies().add(m1);
        movieList.getMovies().add(m2);
        movieList.getMovies().add(m3);
        movieList.getMovies().add(m4);
        movieList.getMovies().add(m5);
        movieList.getMovies().add(m6);

        System.out.println("the number of movies:" + movieList.count());

        System.out.println("\nthe movie's rate:");
        movieList.printRatingMovie();

        System.out.println("\nthe movie's title:");
        movieList.printTitleMovie();

        System.out.println("\nthe movie's release date:");
        movieList.printReleaseDateMovie();

        System.out.println("\nthe sort movie base on release date:");
        movieList.sortReleaseDate();

        System.out.println("\nthe movie with high max rate: " + movieList.maxRating());

        System.out.println("\nthe list of movies");
        var toList = movieList.toList();
        System.out.println(toList);

        System.out.println("\nprint the list of good movie:");
        movieList.printIsGoodMovie();

        System.out.println("\nprint the list of action movie:");
        System.out.println(movieList.getSizeByGenres(MovieGenres.action));

    }
}