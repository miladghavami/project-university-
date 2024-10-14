/**
 * name:Milad Ghavami
 * assignment: Final
 * date: 04/20/2023
 * This class represents a Science fiction movie. An ScienceFiction inherit from Movie.
 */
public class ScienceFiction extends Movie{
    private int numberOfTheScienceFictionScene;
    /**
     * Construct an ScienceFiction object that has provided String title, int releaseDate, double rating, int numberOfTheScienceFictionScene.
     *
     * @param title the title to be given to this ScienceFiction.
     * @param releaseDate the releaseDate to be given to this ScienceFiction.
     * @param rating the rating to be given to this ScienceFiction.
     * @param numberOfTheScienceFictionScene the numberOfTheScienceFictionScene to be given to this ScienceFiction.
     */
    public ScienceFiction(String title,int releaseDate, double rating, int numberOfTheScienceFictionScene){
        super(title, releaseDate,rating);
        this.numberOfTheScienceFictionScene = numberOfTheScienceFictionScene;
    }
    /**
     * Returns the number Of The Science Fiction of this ScienceFiction.
     * @return the number Of The Science Fiction of this ScienceFiction.
     */
    public int getNumberOfTheScienceFictionScene(){
        return numberOfTheScienceFictionScene;
    }
    /**
     * It returns true and give a good feedback of the movie
     *
     * @return It returns true and give a good feedback of the movie.
     */
    @Override
    public boolean goodFeedBack() {
        if (numberOfTheScienceFictionScene > 15){
            return true;
        }
        return false;
    }
    /**
     * It returns true and give a good feedback of the movie if the move has good rating and good feed back.
     *
     * @return It returns true and give a good feedback of the movie.
     */
    @Override
    public boolean isGood(){
        if ((this.goodFeedBack()) && this.getRating() >= 7) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        String  str = "genre: "+ MovieGenres.scienceFiction +", title: ("+ this.getTitle() + "), " + "release date: "
                + this.getReleaseDate() + ", rating: "+ this.getRating();
        return str;
    }
}
