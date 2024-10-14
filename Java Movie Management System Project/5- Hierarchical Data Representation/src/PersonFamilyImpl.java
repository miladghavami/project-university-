import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/21/2023
 * The PersonFamilyImpl class represents a family tree of Person objects. It implements the PersonFamilyInterface.
 */
public class PersonFamilyImpl implements PersonFamilyInterface{
    private TreeNode<Person> root;
    /**
     * Constructor that initializes the family tree with the root Person.
     *
     * @param name   the name of the root person as a String
     * @param age    the age of the root person as an integer
     * @param gender the gender of the root person as a Gender enumeration
     */
    public PersonFamilyImpl(String name, int age, Gender gender) {
        root = new LeafNode<>(new Person(name, age, gender));
    }
    /**
     * Adds a new person to the family tree as a child of the specified father.
     *
     * @param name the name of the new person as a String
     * @param age  the age of the new person as an integer
     * @param gender the gender of the new person as a Gender enumeration
     * @param fathersName the name of the father in the family tree as a String
     */
    public void addPerson(String name, int age, Gender gender, String fathersName) {
        Person person = new Person(name,age, gender);
        TreeNode<Person> newNode = new LeafNode<>(person);
        root = root.addChild(e->e.getName().equals(fathersName),newNode);
    }
    /**
     * Adds a new TreeNode of type Person to the family tree as a child of the specified father.
     *
     * @param e the TreeNode of type Person to be added to the family tree
     * @param fathersName the name of the father in the family tree as a String
     */
    public void addPerson(TreeNode<Person> e, String fathersName) {
        root = root.addChild(m->m.getName().equals(fathersName),e);
    }
    /**
     * Returns the total number of persons in the family tree.
     *
     * @return the size of the family tree as an integer
     */
    public int getSize() {
        return root.map(e-> 1).reduce(0,(a,b)->a+b);
    }
    /**
     * Returns the number of persons in the family tree that satisfy the given predicate.
     *
     * @param pred a predicate to filter the persons in the family tree
     * @return the number of persons that satisfy the given predicate as an integer
     */
    public int getSize(Predicate<Person> pred) {
        return root.map(e-> {
            if (pred.test(e)) { //condition to be counted
                return 1;
            } else {
                return 0;
            }
        }).reduce(0,(a,b)->a+b);
    }
    /**
     * Returns the number of persons in the family tree with the specified gender.
     *
     * @param gender the gender of the persons to count as a Gender enumeration
     * @return the number of persons with the specified gender.
     */
    public int getSizeByGender(Gender gender) {
        return root.map(e-> {
            if (e.getGender() == gender) { //condition to be counted
                return 1;
            } else {
                return 0;
            }
        }).reduce(0,(a,b)->a+b);
    }
    /**
     * Returns a list of names of all persons in the family tree.
     *
     * @return a list of names of all persons.
     */
    public List<String> allPersons() {
        return root.map(e->e.getName()).toList();
    }
    /**
     * Returns a list of names of persons in the family tree that satisfy the given predicate.
     *
     * @param predicate a predicate to filter the persons in the family tree
     * @return a list of names of persons that satisfy the given predicate.
     */
    public List<String> allPersons(Predicate<Person> predicate) {
        return root.toList(predicate).stream().map(e->e.getName()).collect(Collectors.toList());
    }
    /**
     * Prints the family tree structure.
     */
    public void printPersons() {
        root.print();
    }
    /**
     * Returns the oldest person in the family tree.
     *
     * @return the oldest person as a Person object
     */
    // I use 0 because I want to use this age in the family that no one is under.
    public Person getOldestPerson() {
        return root.reduce(new Person("", 0, Gender.man), (a, b) -> {
            if (a.getAge() > b.getAge()) {
                return a;
            } else {
                return b;
            }
        });
    }
    /**
     * Returns the youngest person in the family tree.
     *
     * @return the youngest person as a Person object
     */
    // I use 200 because I want to use this age in the family that no one is above.
    public Person getYoungestPerson() {
        return root.reduce(new Person("", 200, Gender.man), (a, b) -> {
            if (a.getAge() < b.getAge()) { // if A's age in the list is less than B's age, return a. otherwise return b.
                return a;
            } else {
                return b;
            }
        });
    }
    /**
     * Calculates the average age of all persons.
     *
     * @return the average age as a double
     */
    public double getAverageAge() {
        List<Person> persons = root.toList();
        int totalAge = persons.stream().mapToInt(m -> m.getAge()).sum();
        double averageAge = totalAge / (double) persons.size();
        return averageAge;
    }
}
