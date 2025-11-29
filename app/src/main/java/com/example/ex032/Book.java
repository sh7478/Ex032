package com.example.ex032;

public class Book extends LibraryItem implements Searchable, Displayable{
    private String author;
    private int numOfPages;

    public Book(int yearPublished, String title, String author, int numOfPages) {
        super(yearPublished, title);
        this.author = author;
        this.numOfPages = numOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    @Override
    public void displayFullDetails() {
        System.out.println(toString());
    }

    @Override
    public double calculateLateFee(int daysPastDue) {
        return 0.5 * daysPastDue;
    }

    @Override
    public boolean matches(String query) {
        if(this.getTitle().contains(query) || this.author.contains(query))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Book{" +
                "author='" + author + '\'' +
                ", numOfPages=" + numOfPages +
                '}';
    }
}
