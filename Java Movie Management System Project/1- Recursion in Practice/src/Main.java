// theme: Let's suppose we have a movie store where we would like to create a linked list of movies and perform several tasks,
// such as adding and removing.
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * Represents a  linked list that holds Movie objects.
 */
// A recursion is a programming concept that calls itself to solve problems.
// this project has two classes and one Enum class.
public class Main {
    public static void main(String[] args) {
        var linklist = new LinkList();
        var m1 = new Movie(MovieGenres.action, "Demon Slayer the Movie: Mugen Train",2020, 8);
        var m2 = new Movie(MovieGenres.action, "All Quiet on the Western Front",2022, 7);
        var m3 = new Movie(MovieGenres.action, "Top Gun: Maverick",2022, 8);

        var m4 = new Movie(MovieGenres.drama, "No Time to Die",2021, 7);
        var m5 = new Movie(MovieGenres.drama, " F9: The Fast Saga",2020, 5);
        var m6 = new Movie(MovieGenres.drama, "Marcel the Shell with Shoes On",2021, 7);

        linklist.addFirst(m1);
        linklist.addFirst(m2);
        linklist.addFirst(m3);
        linklist.addLast(m4);
        linklist.addLast(m5);
        linklist.addLast(m6);
        System.out.println(linklist.size());
        linklist.print();
    }
}