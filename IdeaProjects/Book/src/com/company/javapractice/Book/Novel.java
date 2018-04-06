package com.company.javapractice.Book;

public class Novel extends Book {
    String style;
    public static int counterNovel = 0;

    public Novel(String title, String author, String publisher, int publishDate, String style) {
        super(title, author, publisher, publishDate);
        this.style = style;
        counterNovel++;
    }

    public Novel() {
        super();
        style = "youth";
        counterNovel++;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "This is a novel which was written in " + style + " style. " +
        super.toString();
    }
}
