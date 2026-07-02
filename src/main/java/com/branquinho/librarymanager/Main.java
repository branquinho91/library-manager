package com.branquinho.librarymanager;

import java.util.List;
import java.util.Scanner;

import com.branquinho.librarymanager.model.Book;
import com.branquinho.librarymanager.service.BookService;

public class Main {
    public static void main(String[] args)  {
        BookService service = new BookService();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        String userInput;

        while (running) {
            printMenu();

            userInput = sc.nextLine();
            
            try {
                switch (userInput) {
                    case "1":
                        registerBook(sc, service);
                        break;
                    case "2":
                        listBooks(service);
                        break;
                    case "3":
                        borrowBook(sc, service);
                        break;
                    case "4":
                        returnBook(sc, service);
                        break;
                    case "5":
                        removeBook(sc, service);
                        break;
                    case "0":
                        System.out.println("Exiting program...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: invalid number.");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== Library Manager =====");
        System.out.println("1 - Register book");
        System.out.println("2 - List books");
        System.out.println("3 - Borrow book");
        System.out.println("4 - Return book");
        System.out.println("5 - Remove book");
        System.out.println("0 - Exit");
        System.out.println();
        System.out.print("Choose an option: ");
    }

    private static void registerBook(Scanner sc, BookService service) {
        System.out.print("Enter book title: ");
        String bookTitle = sc.nextLine();

        System.out.print("Enter book author: ");
        String bookAuthor = sc.nextLine();

        System.out.print("Enter book genre: ");
        String bookGenre = sc.nextLine();

        System.out.print("Enter book page count: ");
        int bookPageCount = Integer.parseInt(sc.nextLine());

        System.out.print("Enter book publication year: ");
        int bookPublicationYear = Integer.parseInt(sc.nextLine());

        Book book = new Book(bookTitle, bookAuthor, bookGenre, bookPageCount, bookPublicationYear);
        service.registerBook(book);

        System.out.println("Book registered successfully!");
        System.out.println();
    }

    private static void listBooks(BookService service) {
        List<Book> books = service.listBooks();

        if (books.isEmpty()) {
            System.out.println("No books found!");
            System.out.println();
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println();
    }

    private static void borrowBook(Scanner sc, BookService service) {
        System.out.print("Enter book ID to borrow: ");
        Long borrowId = Long.parseLong(sc.nextLine());
        service.borrowBook(borrowId);
        System.out.println("Book borrowed successfully!");
        System.out.println();
    }

    private static void returnBook(Scanner sc, BookService service) {
        System.out.print("Enter book ID to return: ");
        Long returnId = Long.parseLong(sc.nextLine());
        service.returnBook(returnId);
        System.out.println("Book returned successfully!");
        System.out.println();
    }

    private static void removeBook(Scanner sc, BookService service) {
        System.out.print("Enter book ID to remove: ");
        Long removeId = Long.parseLong(sc.nextLine());
        service.removeBook(removeId);
        System.out.println("Book removed successfully!");
        System.out.println();
    }
}
