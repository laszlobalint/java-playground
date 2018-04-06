package com.company.javapractice.Bookshelf;

import java.util.ArrayList;
import com.company.javapractice.Book.Book;
import com.company.javapractice.Book.Novel;
import com.company.javapractice.Book.SchoolBook;

public class Bookshelf {

    static ArrayList<Book> books = new ArrayList <Book>();

    public static void main(String[] args) {
        putOnShelf(args, books);

        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        System.out.println("The number of novels on the shelf: " + Novel.counterNovel);
    }

    public static void putOnShelf (String[] args, ArrayList<Book> books) {

        String[] parameters;

        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("SchoolBook")) {
                if(i == (args.length - 1)) {
                    SchoolBook sb = new SchoolBook();
                    books.add(sb);
                    break;
                }

                parameters = args[i + 1].split(",");
                if(parameters.length == 5) {
                    SchoolBook sb = new SchoolBook(parameters[0].replace("_", " "), parameters[1].replace("_", " "), parameters[2].replace("_", " "), Integer.parseInt(parameters[3]), parameters[4].replace("_", " "));
                    books.add(sb);
                    i++;
                } else {
                    SchoolBook sb = new SchoolBook();
                    books.add(sb);
                }

            } else if ((args[i].equals("Novel"))) {
                if(i == (args.length - 1)) {
                    Novel no = new Novel();
                    books.add(no);
                    break;
                }

                parameters = args[i + 1].split(",");
                if (parameters.length == 5) {
                    Novel no = new Novel(parameters[0].replace("_", " "), parameters[1].replace("_", " "), parameters[2].replace("_", " "), Integer.parseInt(parameters[3]), parameters[4].replace("_", " "));
                    books.add(no);
                    i++;
                } else {
                    Novel no = new Novel();
                    books.add(no);
                }
            }
        }
    }
}
