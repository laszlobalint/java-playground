package com.company.javapractice.Book;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int publishDate;

    Book(String title, String author, String publisher, int publishDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    Book() {
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
