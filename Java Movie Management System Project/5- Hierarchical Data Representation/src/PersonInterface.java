/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/21/2023
 */
public interface PersonInterface {
    /**
     * Returns the person's age.
     *
     * @return the person's age
     */
    int getAge();
    /**
     * Returns the person's name.
     *
     * @return the person's name
     */
    String getName();
    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    String toString();
    /**
     * Returns the person's gender as a Gender enumeration.
     *
     * @return the person's gender
     */
    Gender getGender();
}
