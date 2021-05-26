package com.company.javapractice.Book;

public class SchoolBook extends Book {
    public String subject;

    public SchoolBook(String title, String author, String publisher, int publishDate, String subject) {
        super(title, author, publisher, publishDate);
        this.subject = subject;
    }

    public SchoolBook() {
        super();
        subject = "Programozás 1";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "This is a school book from " + subject + " subject. " +
                super.toString();
    }
}
