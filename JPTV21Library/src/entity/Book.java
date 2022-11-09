/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Melnikov
 */
public class Book implements Serializable{
    private String title;
    private Author[] authors;
    private int qusntity;
    private int count;

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
        //обнуляем указанного автора (по индексу)
        this.getAuthors()[numberOfAuthor-1]=null;
        //создаем массив с количеством элементов на 1 меньше
        Author[] newAuthors = new Author[this.getAuthors().length-1];
        // в цикле копируем элементы в новый массив не учитывая обнуленную ячейку
        int j = 0;
        for (Author author : this.getAuthors()) {
            if (author != null) {
                newAuthors[j] = author;
                j++;
            }
        }
        //копируем ссылку на новый массив в книгу
        this.setAuthors(newAuthors);
    }
    @Override
    public String toString() {
        return "Book{" 
                + "title=" + title 
                + ", authors=" + Arrays.toString(authors) 
                + ", quantity="+ qusntity
                + ", count=" + count
                + '}';
    }

    public int getQusntity() {
        return qusntity;
    }

    public void setQusntity(int qusntity) {
        this.qusntity = qusntity;
        this.count = qusntity;
    }

    public int getCount() {
        return count;
    }

    public  void setCount(int count) {
        this.count = count;
    }
    public boolean countPluss(){
        if(count < qusntity){
            count++;
            return true;
        }
        return false;
    }
    public boolean countMinuss(){
        if(count > 0){
            count--;
            return true;
        }
        return false;
    }

    public void quantityPluss(int number) {
        qusntity += number;
        count += number;
    }

    public void quantityMinus(int number) {
        qusntity -= number;
    }
    
}
