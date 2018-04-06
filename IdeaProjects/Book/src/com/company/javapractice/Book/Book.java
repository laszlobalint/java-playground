package com.company.javapractice.Book;

public class Book {
    protected String title;
    protected String author;
    protected String publisher;
    protected int publishDate;

    public Book(String title, String author, String publisher, int publishDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    public Book() {
        this.title = "Objektumorientált Tervezés és Programozás";
        this.author = "Angster Erzsébet";
        this.publisher = "Kiskapu";
        this.publishDate = 2001;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "The book's " +
                "title is " + title + '\'' +
                ", it was written by " + author + '\'' +
                ", was published by " + publisher + '\'' +
                " in " + publishDate +
                ". ";
    }
}
