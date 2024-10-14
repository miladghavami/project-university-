/**
 * name:Milad Ghavami
 * assignment: Midterm
 * date: 04/22/2023
 */
// theme: Consider a movie store where we would like to create a list of movies with different genres
// and detect the best movie based on user feedback.

// Abstract classes cannot be instantiated directly, meaning that they cannot be created as objects.
// The abstract class can be inherited by other classes and implemented by them.
// Methods can be abstract or non-abstract in abstract classes.
public class Main {
    public static void main(String[] args) {
        //movie
        var a1 = new Action("Demon Slayer the Movie: Mugen Train",2020, 8.2, 6);
        var a2 = new Action("All Quiet on the Western Front",2022, 7.8, 12);
        var a3 = new Action("Top Gun: Maverick",2022, 8.4, 12);

        var s1 = new ScienceFiction("Zack Snyder's Justice League",2021, 8, 12);
        var s2 = new ScienceFiction("The Peacemakers",2020, 7.2, 6);
        var s3 = new ScienceFiction("A Hard Problem",2021, 8.6, 12);

        var d1 = new Drama("No Time to Die",2021, 7.3, 12);
        var d2 = new Drama(" F9: The Fast Saga",2020, 5.9, 6);
        var d3 = new Drama("Marcel the Shell with Shoes On",2021, 7.8, 12);

        var movieList = new MovieCategory();
        movieList.add(a1);
        movieList.add(a2);
        movieList.add(a3);

        movieList.add(s1);
        movieList.add(s2);
        movieList.add(s3);

        movieList.add(d1);
        movieList.add(d2);
        movieList.add(d3);

        System.out.println("highest movie: " + movieList.getHighestRated());
        System.out.println("average rating of movie: " + movieList.getAverageRating());
        System.out.println("good movie: ");
        movieList.PrintGood();

        //theater
        System.out.println();

    }
}