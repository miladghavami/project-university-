import java.io.FileWriter;
import java.io.IOException;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/22/2023
 */
// theme: We can imagine a movie store where we can create a list of movies using the MVC design,
// and if we want to add or remove a movie, we type its name and genre.

// A Model-View-Controller(MVC) application consists of three main components: Model, View, and Controller.
public class Main {
    public static void main(String[] args) throws IOException {
        var movieStore = new MovieStoreModel();
        var movieList = movieStore.getMovies();
        var movieStoreView = new MovieStoreView();
        var libraryController = new MovieStoreViewController(movieStore, movieStoreView);
        libraryController.run();
        // open a FileWriter
        FileWriter writer = new FileWriter("note.txt");
        // write a movie.
        writer.write(movieList.toString());
        // close the FileWriter
        writer.close();
    }
}