/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Author;
import entity.Book;
import java.util.Scanner;


public class BookManager {
    private Scanner scanner;

    public BookManager() {
        this.scanner = new Scanner(System.in);
    }
    
    public Book createBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Введите число авторов книги: ");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        book.setAuthors(createAuthors(countAuthorsInBook));
        return book;
    }

    private Author[] createAuthors(int countAuthorsInBook) {
        Author[] authors = new Author[countAuthorsInBook];
        for (int i = 0; i < countAuthorsInBook; i++) {
            Author author = new Author();
            System.out.print("Имя автора "+(i+1)+": ");
            author.setFirstname(scanner.nextLine());
            System.out.print("Фамилия автора "+(i+1)+": ");
            author.setLastname(scanner.nextLine());
            authors[i] = author;
        }
        return authors;
    }
    
    public void printListBooks(Book[] books){
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.printf(i+1+". Book{title = %s%n",book.getTitle());
            System.out.print("\tAuthors = [\n");
            for (int j = 0; j < book.getAuthors().length; j++) {
                Author author = book.getAuthors()[j];
                System.out.printf("\t\t%s %s%n"
                        ,author.getFirstname(),author.getLastname());
            }
            System.out.println("\t]");
        }
        System.out.println("   }");
    }

    public Book[] changeBook(Book[] books) {
        System.out.println("Список книг: ");
        this.printListBooks(books);
        System.out.print("Выберите номер книги для редактирования: ");
        int numBookForEdit = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Авторов у книги "+books[numBookForEdit - 1].getAuthors().length);
        System.out.println("Изменить количество авторов? (y/n)");
        String edit = scanner.nextLine();
        if(edit.equals("y")){
            System.out.print("Введите новое количество авторов: ");
            int newCountAuthorsInBook = scanner.nextInt();
            scanner.nextLine();
       
            if(newCountAuthorsInBook < books[numBookForEdit - 1].getAuthors().length){
              
                int deltaAuthors = books[numBookForEdit - 1].getAuthors().length - newCountAuthorsInBook;
                for (int n = 0; n < deltaAuthors; n++) {
                    
                    books[numBookForEdit - 1] = deleteAuthorBook(books[numBookForEdit - 1]);
                }
            }else{
                for (int i = 0; i < newCountAuthorsInBook; i++) {
                    if(i >= books[numBookForEdit - 1].getAuthors().length){
                        Author newAuthor = new Author();
                        System.out.print("Введите имя автора "+(i+1)+": ");
                        newAuthor.setFirstname(scanner.nextLine());
                        System.out.print("Введите фамилию атора "+(i+1)+": ");
                        newAuthor.setLastname(scanner.nextLine());
                        books[numBookForEdit - 1].addAuthor(newAuthor);
                    }else if(i < books[numBookForEdit - 1].getAuthors().length){
                        System.out.println(i+1+"-й автор: "
                            +books[numBookForEdit - 1].getAuthors()[i].getFirstname()+" "+
                                   books[numBookForEdit - 1].getAuthors()[i].getLastname());
                        System.out.print("Изменить имя автора? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите новое имя атора: ");
                            books[numBookForEdit - 1].getAuthors()[i].setFirstname(scanner.nextLine());
                        }    
                        System.out.print("Изменить фамилию автора? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите новую фамилию атора: ");
                            books[numBookForEdit - 1].getAuthors()[i].setLastname(scanner.nextLine());
                        }    
                    }
                }
            }
        }
        return books;
    }

    private Book changeBookName(Book book) {
        System.out.print("Название книги: ");
        System.out.println(book.getTitle());
        System.out.print("Изменить название книги? (y/n)");
        String edit = scanner.nextLine();
        System.out.println();
        if(edit.equals("y")){
            System.out.print("Введите новое название книги: ");
            book.setTitle(scanner.nextLine());
        }
        return book;
    }

    private Book deleteAuthorBook(Book book) {
        for (int i = 0; i < book.getAuthors().length; i++) {
            System.out.println(
                    i+1+". "+book.getAuthors()[i].getFirstname()+" "+
                            book.getAuthors()[i].getLastname());
        }
        System.out.println("Какого автора удалить? ");
        int numDeleteAuthor = scanner.nextInt();
        scanner.nextLine();
        book.removeAuthor(numDeleteAuthor);
        return book;
    }

      
    
}