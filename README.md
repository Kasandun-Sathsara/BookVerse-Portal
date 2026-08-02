# BookVerse Online Library Portal

BookVerse Online Library Portal is a Java EE JSP Web Application demonstrating advanced JSP/Servlet concepts in an MVC architecture, built specifically without any database dependencies. It utilizes Java Collections (ArrayList, HashMap) as an in-memory data store for the sake of learning and demonstrating core Java EE web components.

## Technologies Used
- Java 17
- Jakarta EE 11 (Servlets, JSP, Expression Language)
- JSTL (Jakarta Standard Tag Library)
- JavaBeans
- MVC Design Pattern
- Custom Tag Files
- Bootstrap 5
- Maven



## How to Run

1. Ensure you have Java 17+ and Maven installed.
2. Ensure you have Apache Tomcat configured (e.g., Tomcat 10+).
3. Build the project using Maven:
   ```bash
   mvn clean package
   ```
4. Deploy the generated `.war` file (located in `target/BookVerse-library-portal-1.0-SNAPSHOT.war`) to your Tomcat server.
5. Access the application: `http://localhost:8080/BookVerse-library-portal/`

### Sample Accounts
The application initializes with the following default accounts (username / password):
- **admin** / admin123 (Admin Role)
- **manager** / manager123 (Manager Role)
- **staff** / staff123 (Staff Role)
- **member** / member123 (Member Role)

## Project Structure
- `src/main/java/lk/jiat/bookverselibraryportal/bean/`: JavaBeans serving as Data Transfer Objects.
- `src/main/java/lk/jiat/bookverselibraryportal/config/`: Singleton DataStore configuration.
- `src/main/java/lk/jiat/bookverselibraryportal/controller/`: Servlet Controllers mapping HTTP requests to JSP views.
- `src/main/java/lk/jiat/bookverselibraryportal/repository/`: Data access logic wrapping the in-memory Collections.
- `src/main/java/lk/jiat/bookverselibraryportal/service/`: Business logic delegators.
- `src/main/java/lk/jiat/bookverselibraryportal/filter/`: Security and authorization filters.
- `src/main/java/lk/jiat/bookverselibraryportal/listener/`: Application lifecycle listeners.
- `src/main/webapp/WEB-INF/views/`: Protected JSP pages.
- `src/main/webapp/WEB-INF/tags/`: Custom tag component files.
