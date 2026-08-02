package lk.jiat.bookverselibraryportal;
import lk.jiat.bookverselibraryportal.util.HibernateUtil;
import lk.jiat.bookverselibraryportal.dao.BookDao;
import lk.jiat.bookverselibraryportal.dao.BookCopyDao;
import lk.jiat.bookverselibraryportal.model.Book;
import lk.jiat.bookverselibraryportal.model.BookCopy;
import lk.jiat.bookverselibraryportal.model.enums.BookStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CheckData {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Diagnostic...");
            BookDao bookDao = new BookDao();
            BookCopyDao copyDao = new BookCopyDao();
            
            List<Book> books = bookDao.getAllBooks();
            System.out.println("Total Books: " + (books == null ? "NULL" : books.size()));
            if(books != null) {
                for(Book b : books) {
                    System.out.println("Book: " + b.getId() + " - " + b.getTitle());
                }
            }
            
            List<BookCopy> copies = null;
            try(Session session = HibernateUtil.getSessionFactory().openSession()) {
                copies = session.createQuery("from BookCopy", BookCopy.class).list();
                System.out.println("Total Copies: " + (copies == null ? "NULL" : copies.size()));
                if(copies != null) {
                    for(BookCopy c : copies) {
                        System.out.println("Copy: " + c.getId() + " - " + c.getCopyNumber() + " - " + c.getStatus());
                    }
                }
            }
            
            System.out.println("Running Quick Fix manually...");
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = session.beginTransaction();
                for (Book b : books) {
                    Long count = session.createQuery("select count(c) from BookCopy c where c.book.id = :bid", Long.class)
                        .setParameter("bid", b.getId()).uniqueResult();
                    if (count == null || count == 0) {
                        System.out.println("Creating copy for book " + b.getId());
                        BookCopy copy = new BookCopy();
                        copy.setCopyNumber("C-" + System.nanoTime());
                        copy.setStatus(BookStatus.AVAILABLE);
                        Book attachedBook = session.get(Book.class, b.getId());
                        copy.setBook(attachedBook);
                        session.persist(copy);
                    }
                }
                t.commit();
            }
            
            System.out.println("Testing getAvailableCopies...");
            List<BookCopy> available = copyDao.getAvailableCopies();
            System.out.println("Available Copies: " + (available == null ? "NULL" : available.size()));
            
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
