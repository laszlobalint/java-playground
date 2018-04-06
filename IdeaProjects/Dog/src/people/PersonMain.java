package people;

import com.company.javapractice.dog.AgeComparator;
import com.company.javapractice.dog.IdComparator;
import com.company.javapractice.dog.NameComparator;
import com.company.javapractice.dog.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        List <Person> people = new ArrayList <Person>();
        people.add(new Person(1, "Thomas", 55, 5));
        people.add(new Person(2, "Peter", 20, 8));
        people.add(new Person(3, "Jessica", 45, 0));
        people.add(new Person(4, "Paulina", 11, 1));
        Collections.sort(people);
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println();
        System.out.println("Sort by age:\n");
        Collections.sort(people, new AgeComparator());
        for (Person person : people) {
            System.out.println("Name: " + person.getName() + "; Age: " + person.getAge());
        }

        System.out.println();
        System.out.println("Sort by name:\n");
        Collections.sort(people, new NameComparator());
        for (Person person : people) {
            System.out.println("Name: " + person.getName() + "; Age: " + person.getAge());
        }

        System.out.println();
        System.out.println("Sort by ID:\n");
        Collections.sort(people, new IdComparator());
        for (Person person : people) {
            System.out.println("ID: " + person.getId() + "; Name: " + person.getName() + "; Age: " + person.getAge());
        }
    }
}
