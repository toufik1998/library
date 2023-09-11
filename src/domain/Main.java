package domain;

import repository.*;
import services.CopyService;
import services.MemberService;
import services.BookService;
import services.ReservationService;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        DbConnection dbConnection = new DbConnection();

        BookRepository bookRepository = new BookRepository(dbConnection);
        BookService bookService = new BookService(bookRepository);

        MemberRepository memberRepository = new MemberRepository(dbConnection);
        MemberService memberService = new MemberService(memberRepository);

        ReservationRepository reservationRepository = new ReservationRepository(dbConnection);
        ReservationService reservationService = new ReservationService(reservationRepository);

        CopyRepository copyRepository = new CopyRepository(dbConnection);
        CopyService copyService = new CopyService(copyRepository);

        Scanner scanner = new Scanner(System.in);


        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           Library Management            ║");
        System.out.println("║═════════════════════════════════════════║");
        System.out.println("║ 1. ║ Add a new book                     ║");
        System.out.println("║ 2. ║ Update a book                      ║");
        System.out.println("║ 3. ║ Delete a book                      ║");
        System.out.println("║ 4. ║ Display all 'available' books      ║");
        System.out.println("║ 5. ║ Display all 'borrowed' books       ║");
        System.out.println("║ 6. ║ Search for a book                  ║");
        System.out.println("║ 7. ║ Borrow a book                      ║");
        System.out.println("║ 8. ║ Return a book                      ║");
        System.out.println("║ 9. ║ Statistics                         ║");
        System.out.println("║ 0. ║ Exit the program                   ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println("Enter your choice: ");

        try {
            int choiceNumber = scanner.nextInt();
            scanner.nextLine();

            switch (choiceNumber) {
                case 1:
                    addNewBook(scanner, bookService);
                    break;
                case 2:
                    updateBook(scanner, bookService);
                    break;
                case 3:
                    deleteBook(scanner, bookService);
                    break;
                case 4:
                    displayAvailableBooks(bookService);
                    break;
                case 5:
                    displayBorrowedBooks(bookService);
                    break;
                case 6:
                    searchBook(scanner, bookService);
                    break;
                case 7:
                    borrowBook(scanner, bookService, memberService, reservationService, copyService);
                    break;
                case 8:
                    returnBook(scanner, bookService, memberService, reservationService, copyService);
                    break;
                case 9:
                    showStatistics(copyRepository);
                    break;
                case 0:
                    System.out.println("Exited the program successfully.");
                    return;
                default:
                    System.out.println("You entered an invalid input");
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void addNewBook(Scanner scanner, BookService bookService) throws SQLException{

        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();

        System.out.println("Enter the ISBN of the book:");
        String ISBN = scanner.nextLine();

        System.out.println("Enter the ID of the author:");
        int author_id = scanner.nextInt();

        System.out.println("Enter the quantity of the book:");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Title: " + title);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Quantity: " + quantity);
        System.out.println("Author's id: " + author_id);
        scanner.close();

        Book newBook = new Book(title, author_id, ISBN, quantity);
        bookService.addBook(newBook);
    }

    private static void updateBook(Scanner scanner, BookService bookService) throws SQLException{
        System.out.println("Enter the ISBN of the book to update :");
        String isbn = scanner.nextLine();

        if(bookService.isBookExists(isbn)){
            System.out.println("Enter the new title of the book:");
            String title = scanner.nextLine();

            System.out.println("Enter the new ID of the author:");
            int authorId = scanner.nextInt();

            System.out.println("Enter the new quantity of the book:");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Book updateBook = new Book(title, authorId, isbn, quantity);

            bookService.updateBook(isbn, updateBook);

            System.out.println("Book has been updated successfully!");
        }else {
            System.out.println("book doesnt exist");
        }
    }
    private static void deleteBook(Scanner scanner, BookService bookService) throws SQLException{
        System.out.println("Enter the ISBN of the book");
        String isbn = scanner.nextLine();

        if(bookService.isBookExists(isbn)){
            bookService.deleteBook(isbn);
            System.out.println("book deleted successfully!");
        }else {
            System.out.println("Book doesn't exist");
        }
    }
    private static void displayAvailableBooks(BookService bookService) throws SQLException {
        List<Book> availableBooks = bookService.getAllAvailableBooks();

        if(availableBooks.isEmpty()){
            System.out.println("No available books found.");
        }else {
            for(Book book : availableBooks){
                System.out.println("Title : " + book.getTitle());
                System.out.println("Author id : " + book.getAuthor());
                System.out.println("ISBN : " + book.getIsbn());
                System.out.println("Quantity : " + book.getQuantity());
                System.out.println("+++++++++++++++++++++++++++++");
            }
        }
    }
    private static void displayBorrowedBooks(BookService bookService) throws SQLException {
        System.out.println("Display all borrowed books");
    }
    private static void searchBook(Scanner scanner, BookService bookService) throws SQLException{
        System.out.println("Do you want to search by title or author :");
        System.out.println("1-Search by title");
        System.out.println("2-Search by author");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();
        if(searchChoice == 1){
            System.out.println("Enter the title of the book you want to search for");
            String title = scanner.nextLine();
            scanner.close();

            List<Book> foundedBooks = bookService.searchBook(title);

            if(foundedBooks.isEmpty()){
                System.out.println("No books found.");
            }else {
                for(Book book : foundedBooks){
                    System.out.println("Title :" + book.getTitle());
                    System.out.println("Author ID :" + book.getAuthor());
                    System.out.println("ISBN :" + book.getIsbn());
                    System.out.println("Quantity :" + book.getQuantity());
                    System.out.println("+++++++++++++++++++++++++++++");
                }
            }
        }else {
            System.out.println("You want to search by author");
        }

    }
    private static void borrowBook(Scanner scanner, BookService bookService, MemberService memberService, ReservationService reservationService, CopyService copyService ) throws SQLException{
        System.out.println("Enter the ISBN of the book you want to borrow :");
        String isbn = scanner.nextLine();

        if(bookService.isBookExists(isbn)){
            System.out.println("Enter your member number :");
            int memberNumber = scanner.nextInt();
            scanner.nextLine();
            if(memberService.isMemberExists(memberNumber)){
                int memberId = memberService.getMemberId(memberNumber);
                int copyId = copyService.getAvailableCopyId(isbn);
                java.sql.Date borrowingDate = null;
                java.sql.Date returnDate = null;

                System.out.println("memberid :" + memberId);
                System.out.println("copyid :" + copyId);
                System.out.println("borrowingdate :" + borrowingDate);
                System.out.println("return date :" + returnDate);

                Reservation reservation = new Reservation(memberId, copyId, borrowingDate, returnDate);

                System.out.println(reservationService.makeReservation(reservation).getCopyId());

            }else {
                System.out.println("member doesn't exist");
            }
        }else {
            System.out.println("Book doesn't exists");
        }
    }
    private static void returnBook(Scanner scanner, BookService bookService, MemberService memberService, ReservationService reservationService, CopyService copyService) throws SQLException {
        System.out.println("Enter the ISBN of the book :");
        String isbn = scanner.nextLine();
        if(bookService.isBookExists(isbn)){
            System.out.println("Enter the member Code");
            int memberNumber = scanner.nextInt();
            scanner.nextLine();
            scanner.close();
            if(memberService.isMemberExists(memberNumber)) {
                int memberId = memberService.getMemberId(memberNumber);
                int test = reservationService.returnBook(isbn, memberId);
                System.out.println("Book returned successfully!");
            }else {
                System.out.println("There is no member with the provided member number");
            }
        }else {
            System.out.println("There is no book with the provided ISBN");
        }
    }
    private static void showStatistics(CopyRepository copyRepository) throws SQLException {
        copyRepository.displaystatistics();
        System.out.println("Statistics");
    }
}