package lk.jiat.bookverselibraryportal.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                sessionFactory = new Configuration().configure().buildSessionFactory();
                
                // Seed default admin user if database is empty
                try (org.hibernate.Session s = sessionFactory.openSession()) {
                    Long count = s.createQuery("select count(u) from User u", Long.class).uniqueResult();
                    if (count == 0) {
                        org.hibernate.Transaction t = s.beginTransaction();
                        lk.jiat.bookverselibraryportal.model.User admin = new lk.jiat.bookverselibraryportal.model.User(
                            "admin", "admin123", "admin@bookverse.com", "System", "Administrator", true, lk.jiat.bookverselibraryportal.model.enums.Role.ADMIN
                        );
                        s.persist(admin);
                        t.commit();
                        System.out.println("Default admin user created automatically!");
                    }
                }
                
            } catch (Exception ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
