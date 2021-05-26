package PoemReadandSort;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("\nSorted by using tree set: ");
	    PoemReadSort.readPoemTreeSetWay("./poem.txt");

        System.out.println();

        System.out.println("\nSorted by using compare to (English): ");
	    PoemReadSort.readPoemLexicographically("./poem.txt");

        System.out.println();

        System.out.println("\nSorted by using compare to (Hungarian): ");
        PoemReadSort.readPoemLexicographically("./hymn.txt");

        System.out.println();

        // Best practice sorting:
        System.out.println("\nSorted by using Collator (Hungarian): ");
        PoemReadSort.sortLocaleHun("./hymn.txt");

    }
}
