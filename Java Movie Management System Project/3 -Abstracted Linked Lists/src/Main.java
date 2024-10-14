import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// theme: Assume we are creating a movie and theater store where we would like to create a list of movies and
// theaters based on genre and detect the number of movies and theaters.

// Abstracted linked lists are linear collections of elements that point to each other.
// Let's first discuss how an abstract linked list works.
// Every node is read in the linked list (if the first node is a movie or theater,
// it goes after being read, and if there's no movie or theater node in the next node, the empty node is read).
public class Main {
    public static void main(String[] args) {
        var movieListImp = new MovieListImpl();
        movieListImp.addMovie("Demon Slayer the Movie: Mugen Train",2020, 8,MovieGenres.action);
        movieListImp.addMovie("All Quiet on the Western Front",2022, 7,MovieGenres.action);
        movieListImp.addMovie("Top Gun: Maverick",2022, 8,MovieGenres.action);

        movieListImp.addMovie("No Time to Die",2021, 7,MovieGenres.drama);
        movieListImp.addMovie(" F9: The Fast Saga",2020, 5,MovieGenres.drama);
        movieListImp.addMovie("Marcel the Shell with Shoes On",2021, 7,MovieGenres.drama);

        System.out.println(movieListImp.toString());
        System.out.println("number of movies: " + movieListImp.getNumberOfMovies());
        System.out.println("\n");

        var actionMovies = movieListImp.getGenreByFilter(MovieGenres.action);
        Set<MovieNode> set = new HashSet<MovieNode>(actionMovies);
        System.out.println("Action movies:");
        System.out.println(set);

        movieListImp.addTheater("The Hollywood Improv, Los Angeles",2021, 9,TheaterGenres.comedy);
        movieListImp.addTheater("The Comedy Cellar, New York",2022, 8,TheaterGenres.comedy);
        movieListImp.addTheater("Comedy Works, Denver",2020, 7,TheaterGenres.comedy);

        movieListImp.addTheater("The Phantom of the Opera",2021, 6,TheaterGenres.play);
        movieListImp.addTheater("Wicked",2021, 9,TheaterGenres.play);
        movieListImp.addTheater("milad song",2018, 8,TheaterGenres.play);

        System.out.println(movieListImp.toString());
        System.out.println("number of theaters: " + movieListImp.getNumberOfTHeater());
        System.out.println("\n");
    }
}