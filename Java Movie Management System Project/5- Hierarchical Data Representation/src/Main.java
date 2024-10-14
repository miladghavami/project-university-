/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/21/2023
 */
// theme: Imagine a family with a long history.
// Their goal is to create a family tree program that lets them easily find out
// how many people are in the family and who's the oldest or youngest.

// Tree-like hierarchical data representations organize and structure data
// in a way that lets each item (node) have one parent and multiple children.

// A node with children is called an internal node or a group node.
// A node without children is called a leaf node.
public class Main {
    public static void main(String[] args) {
        var m1 = new Person("milad", 40, Gender.man );
        var m2 = new Person("masoud", 60, Gender.man);
        var m3 = new Person("tannaz", 32, Gender.woman);
        var m4 = new Person("darya", 28, Gender.woman);
        var m5 = new Person("golsa", 28, Gender.woman);
        var m6 = new Person("amir", 5, Gender.man);
        var m7 = new Person("akram", 6, Gender.woman);
        var m8 = new Person("majid", 7, Gender.man);
        var m9 = new Person("alex", 8, Gender.man);

        var persnFamilyImpl = new PersonFamilyImpl("mehran",90, Gender.man);

        persnFamilyImpl.addPerson(new LeafNode(m1), "mehran");
        persnFamilyImpl.addPerson(new LeafNode(m2), "mehran");
        persnFamilyImpl.addPerson(new LeafNode(m3), m2.getName());
        persnFamilyImpl.addPerson(new LeafNode(m4), m2.getName());
        persnFamilyImpl.addPerson(new LeafNode(m5), m2.getName());
        persnFamilyImpl.addPerson(new LeafNode(m6), m4.getName());
        persnFamilyImpl.addPerson(new LeafNode(m7), m4.getName());
        persnFamilyImpl.addPerson(new LeafNode(m8), m5.getName());
        persnFamilyImpl.addPerson(new LeafNode(m9), m5.getName());

        persnFamilyImpl.printPersons();


        System.out.println("\nthe number of persons:");
        System.out.println(persnFamilyImpl.getSize());

        System.out.println("\na string of all person names that you can then print as output:");
        System.out.println(persnFamilyImpl.allPersons());

        System.out.println("\n2- the number of persons who are 28 years old:");
        System.out.println(persnFamilyImpl.getSize(m->m.getAge() == 28));

        System.out.println("\n2- the number of women's:");
        System.out.println(persnFamilyImpl.getSizeByGender(Gender.woman));

        System.out.println("\n2- the number of man's:");
        System.out.println(persnFamilyImpl.getSizeByGender(Gender.man));

        Person oldestPerson = persnFamilyImpl.getOldestPerson();
        System.out.println("\nThe oldest person in the family:");
        System.out.println(oldestPerson);

        Person youngestPerson = persnFamilyImpl.getYoungestPerson();
        System.out.println("\nThe youngest person in the family:");
        System.out.println(youngestPerson);

        double averageAge = persnFamilyImpl.getAverageAge();
        System.out.println("\nThe average age of persons in the family:");
        System.out.println(averageAge);
    }
}