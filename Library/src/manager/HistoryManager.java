/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Book;
import entity.History;
import entity.Reader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class HistoryManager {
    private final Scanner scanner = new Scanner(System.in);
    
    
    public History takeOnBook(Book[] books,Reader[] readers){
        History history = new History();

        System.out.println("Список читателей: ");
        ReaderManager readerManager = new ReaderManager();
        readerManager.printListReaders(readers);
        System.out.print("Выберите номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Список книг: ");
        BookManager bookManager = new BookManager();
        bookManager.printListBooks(books);
        System.out.print("Выберите номер книги из списка: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        
        history.setBook(books[numberBook - 1]);
        history.setReader(readers[numberReader - 1]);
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }

    public void printListTakeOnBooks(History[] histories){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < histories.length; i++) {
            if(histories[i].getReturnBook() == null && histories[i].getTakeOnBook() != null){
                try {
                    System.out.printf("%d. %s. Выдана: %s. Книгу читает: %s %s%n"
                        ,i+1
                        ,histories[i].getBook().getTitle()
                        ,sdf.format(histories[i].getTakeOnBook())
                        ,histories[i].getReader().getFirstname()
                        ,histories[i].getReader().getLastname()
                    );
                } catch (Exception e) {
                    System.out.println("Неправильный формат даты!");
                    return;
                }
                
            }
        }
    }
    public History[] returnBook(History[] histories){

        System.out.println("Список выданных книг:");
        this.printListTakeOnBooks(histories);
        System.out.print("Выберите номер книги для возврата: ");
        int numberToReturnBook = scanner.nextInt(); scanner.nextLine();
        histories[numberToReturnBook - 1].setReturnBook(new GregorianCalendar().getTime());
        return histories;
    }
    
}
