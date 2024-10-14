import java.util.List;
import java.util.function.Predicate;

/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/21/2023
 */
public interface PersonFamilyInterface {
    /**
     * Adds a new person to the family tree as a child of the specified father.
     *
     * @param name the name of the new person as a String
     * @param age  the age of the new person as an integer
     * @param gender the gender of the new person as a Gender enumeration
     * @param fathersName the name of the father in the family tree as a String
     */
    public void addPerson(String name, int age, Gender gender, String fathersName);
    /**
     * Adds a new TreeNode of type Person to the family tree as a child of the specified father.
     *
     * @param e the TreeNode of type Person to be added to the family tree
     * @param fathersName the name of the father in the family tree as a String
     */
    public void addPerson(TreeNode<Person> e, String fathersName);
    /**
     * Returns the total number of persons in the family tree.
     *
     * @return the size of the family tree as an integer
     */
    public int getSize();
    /**
     * Returns the number of persons in the family tree that satisfy the given predicate.
     *
     * @param pred a predicate to filter the persons in the family tree
     * @return the number of persons that satisfy the given predicate as an integer
     */
    public int getSize(Predicate<Person> pred);
    /**
     * Returns the number of persons in the family tree with the specified gender.
     *
     * @param gender the gender of the persons to count as a Gender enumeration
     * @return the number of persons with the specified gender.
     */
    public int getSizeByGender(Gender gender);
    /**
     * Returns a list of names of all persons in the family tree.
     *
     * @return a list of names of all persons.
     */
    public List<String> allPersons();
    /**
     * Returns a list of names of persons in the family tree that satisfy the given predicate.
     *
     * @param predicate a predicate to filter the persons in the family tree
     * @return a list of names of persons that satisfy the given predicate.
     */
    public List<String> allPersons(Predicate<Person> predicate);
    /**
     * Prints the family tree structure.
     */
    public void printPersons();
    /**
     * Returns the oldest person in the family tree.
     *
     * @return the oldest person as a Person object
     */
    Person getOldestPerson();
    /**
     * Returns the youngest person in the family tree.
     *
     * @return the youngest person as a Person object
     */
    Person getYoungestPerson();
    /**
     * Calculates the average age of all persons.
     *
     * @return the average age as a double
     */
    double getAverageAge();
}
