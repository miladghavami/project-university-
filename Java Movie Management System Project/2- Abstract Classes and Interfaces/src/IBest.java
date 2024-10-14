/**
 * name:Milad Ghavami
 * assignment: Final
 * date: 04/20/2023
 * The interface defines  abstract methods for a variety of movie types.
 */
// The interface provides two abstract methods, and the abstract class Movie implements them.
// I'm defining this abstract method in the interface instead of the abstract class so if I need it later,
// can add another abstract class that implements it.
public interface IBest {
    /**
     * It returns true and give a good feedback of the movie
     *
     * @return It returns true and give a good feedback of the movie.
     */
    boolean isGood();
    /**
     * It returns true and give a good feedback of the movie if the move has good rating and good feed back.
     *
     * @return It returns true and give a good feedback of the movie.
     */
    boolean goodFeedBack();
}
