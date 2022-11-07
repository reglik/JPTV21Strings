/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Arrays;


public class Book implements Serializable{
    private String title;
    private Author[] authors;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }
    
    public void addAuthor(Author auhtor){
        Author[] newAuthors = Arrays.copyOf(authors, authors.length+1);
        newAuthors[newAuthors.length-1]=auhtor;
        this.authors = newAuthors;
    }
    
    public void removeAuthor(int numberOfAuthor){

        this.getAuthors()[numberOfAuthor-1]=null;

        Author[] newAuthors = new Author[this.getAuthors().length-1];

        int j = 0;
        for (Author author : this.getAuthors()) {
            if (author != null) {
                newAuthors[j] = author;
                j++;
            }
        }

        this.setAuthors(newAuthors);
    }
    @Override
    public String toString() {
        return "Book{" 
                + "title=" + title 
                + ", authors=" + Arrays.toString(authors) 
                + '}';
    }
    
}
