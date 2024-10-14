/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/21/2023
 * The Person class represents an individual person with their name, age, and gender. It implements the PersonInterface.
 */
public class Person implements PersonInterface{
    private int age;
    private String name;
    private Gender gender;
    /**
     * Constructor that takes no argument.
     */
    public Person(){
        this.age = 0;
        this.name = "unKnown";
        this.gender= Gender.man;
    }
    /**
     * Constructor that takes the person's name, age, and gender as arguments.
     *
     * @param name the name of the person as a String
     * @param age the age of the person as an integer
     * @param gender the gender of the person as a Gender enumeration
     */
    public Person(String name, int age, Gender gender){
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
    /**
     * Returns the person's age.
     *
     * @return the person's age
     */
    public int getAge(){
        return age;
    }
    /**
     * Returns the person's name.
     *
     * @return the person's name
     */
    public String getName(){
        return name;
    }
    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    public String toString() {
        String  str = "name: "+ getName() +", age: " + getAge() + ", gender: " + getGender();
        return str;
    }
    /**
     * Returns the person's gender as a Gender enumeration.
     *
     * @return the person's gender
     */
    public Gender getGender() {
        return gender;
    }
}
