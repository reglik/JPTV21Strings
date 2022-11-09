/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.Reader;
import java.util.Scanner;


public class ReaderManager {
    private final Scanner scanner = new Scanner(System.in);
    public Reader createReader(){
        Reader reader = new Reader();
        System.out.print("Имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Фамилия читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Телефон читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }

    public void printListReaders(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            Reader reader = readers[i];
            System.out.printf(i+1+".%s %s %s%n"
                    ,reader.getFirstname()
                    ,reader.getLastname()
                    ,reader.getPhone()
            );
        }
    }
}