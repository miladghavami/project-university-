/**
 * name:Milad Ghavami
 * assignment: Midterm
 * date: 04/22/2023
 * This class represents an Action movie. An Action inherit from Movie.
 */
public class Action extends Movie{
    private int numberOfTheActionScene;
    /**
     * Construct an Action object with no parameter.
     */
    public Action(){
        super();
    }
    /**
     * Construct an Action object that has provided String title, int releaseDate, double rating, int numberOfTheScienceFictionScene.
     *
     * @param title the title to be given to this Action.
     * @param releaseDate the releaseDate to be given to this Action.
     * @param rating the rating to be given to this Action.
     * @param numberOfTheScienceFictionScene the numberOfTheScienceFictionScene to be given to this Action.
     */
    public Action(String title, int releaseDate, double rating, int numberOfTheScienceFictionScene){
        super(title, releaseDate, rating);
        this.numberOfTheActionScene = numberOfTheScienceFictionScene;
    }
    /**
     * Returns the number Of The action Scene of this Action.
     * @return the number Of The action Scene of this Action.
     */
    public int getNumberOfTheActionScene(){
        return numberOfTheActionScene;
    }
    /**
     * It returns true and give a good feedback of the movie
     *
     * @return It returns true and give a good feedback of the movie.
     */
    @Override
    public boolean goodFeedBack() {
        if (numberOfTheActionScene > 10){
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
     * Returns a string representation of this Action.
     * @return a string representation of this Action.
     */
    @Override
    public String toString(){
        String  str = "genre: "+ MovieGenres.action +", title: ("+ this.getTitle() + "), " + "release date: "
                + this.getReleaseDate() + ", rating: "+ this.getRating();
        return str;
    }
}

