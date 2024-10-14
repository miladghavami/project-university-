/**
 * name:Milad Ghavami
 * assignment: final
 * date: 04/22/2023
 * This class represents a Drama movie. A Drama inherit from Movie and implements Inter.
 */
public class Drama extends Movie{
    private int numberOfTheDramaScene;
    /**
     * Construct a Drama object that has provided String title, int releaseDate, double rating, int numberOfTheScienceFictionScene.
     *
     * @param title the title to be given to this Drama.
     * @param releaseDate the releaseDate to be given to this Drama.
     * @param rating the rating to be given to this Drama.
     * @param numberOfTheScienceFictionScene the numberOfTheScienceFictionScene to be given to this Drama.
     */
    public Drama(String title, int releaseDate, double rating, int numberOfTheScienceFictionScene){
        super(title, releaseDate, rating);
        this.numberOfTheDramaScene = numberOfTheScienceFictionScene;
    }
    /**
     * Returns the number of the drama scene of this Drama.
     * @return the number of the drama scene of this Drama.
     */
    public int getTheNumberOfTheDramaScene(){
        return numberOfTheDramaScene;
    }
    /**
     * It returns true and give a good feedback of the movie
     *
     * @return It returns true and give a good feedback of the movie.
     */
    @Override
    public boolean goodFeedBack() {
        if (numberOfTheDramaScene > 10){
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
    /**
     * Returns a string representation of this Drama.
     * @return a string representation of this Drama.
     */
    @Override
    public String toString() {
        String  str = "genre: "+ MovieGenres.drama +", title: ("+ this.getTitle() + "), " + "release date: "
                + this.getReleaseDate() + ", rating: "+ this.getRating();
        return str;
    }
}

