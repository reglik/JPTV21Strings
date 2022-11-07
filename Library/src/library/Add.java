/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;
import manager.BookManager;
import manager.DataManager;
import manager.HistoryManager;
import manager.ReaderManager;


public class Add {
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    private final DataManager dataManager;

    public Add() {
        dataManager = new DataManager();
        this.books = dataManager.loadBooks();
        this.readers = new Reader[0];
        this.histories = new History[0];
        //testAddBook();
        testAddReader();
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
       
    }
    
    public void run(){
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Закрыть приложение");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список книг");
            System.out.println("6. Редактирование книги");
            System.out.println("7. Список читателей");
            System.out.println("8. Список выданных книг");
            System.out.print("Выберите номер задачи: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            System.out.println("____________________");
            switch (task) {
                case 0:
                    repeat = false;
                    System.out.println("Задача 0. Закрыть приложение");
                    break;
                case 1:
                    System.out.println("Задача 1. Добавить книгу");
                    this.books = Arrays.copyOf(this.books, this.books.length+1);
                    this.books[this.books.length-1] = bookManager.createBook();
                    //Сохранение массива с новой книгой в файл
                    dataManager.saveBooks(this.books);
                    break;
                case 2:
                    System.out.println("Задача 2. Добавить читателя");
                    this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
                    this.readers[this.readers.length-1] = readerManager.createReader();
                    //Сохранение массива с новым читателем в файл
                    break;
                case 3:
                    System.out.println("Задача 3. Выдать книгу");
                    this.histories = Arrays.copyOf(this.histories, this.histories.length + 1);
                    this.histories[this.histories.length - 1] = historyManager.takeOnBook(books, readers);
                    //Сохранение массива с новой историей в файл
                    break;
                case 4:
                    System.out.println("Задача 4. Вернуть книгу");
                    histories = historyManager.returnBook(histories);
                    //Сохранение массива с измененной историей в файл
                    break;
                case 5:
                    System.out.println("Задача 5. Список книг");
                    bookManager.printListBooks(books);
                    break;
                case 6:
                    System.out.println("Задача 6. Редактирование книги");
                    books = bookManager.changeBook(books);
                    break;
                case 7:
                    System.out.println("Задача 7. Список читателей");
                    readerManager.printListReaders(readers);
                    break;    
                case 8:
                    System.out.println("Задача 8. Список выданных книг");
                    historyManager.printListTakeOnBooks(this.histories);
                    break;    
                default:
                    System.out.println("Выберите задачу из списка");
            }
            System.out.println("=======---------========");
        }while(repeat);
        System.out.println("Пока, ребята!");
    }

    private void testAddBook() {
        
        Book book = new Book();
        book.setTitle("Book for editing");
        Author author = new Author();
        author.setFirstname("firstname");
        author.setLastname("lastname");
        Author[] bookAuthors = new Author[1];
        bookAuthors[0] = author;
        book.setAuthors(bookAuthors);
        this.books = Arrays.copyOf(this.books, this.books.length+1);
        this.books[this.books.length-1] = book;
    }
    private void testAddReader(){
        
        Reader reader = new Reader("Ivan","Ivanov","54566556");
//        reader.setFirstname("Ivan");
//        reader.setLastname("Ivanov");
        this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
        this.readers[this.readers.length-1] = reader;
    }
}
