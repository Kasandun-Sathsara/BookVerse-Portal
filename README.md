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

## Core Concepts Demonstrated
1. **MVC Architecture:** Separation of concerns using Controllers (Servlets), Views (JSPs), and Model (JavaBeans + Repositories).
2. **In-Memory Data Storage:** The `DataStore` Singleton uses thread-safe static Maps to persist data during the application lifecycle.
3. **Advanced JSP & EL:** Complete elimination of Scriptlets. Extensive use of Expression Language (`${}`) with `pageScope`, `requestScope`, and `sessionScope`.
4. **JSTL Core Tags:** Used for conditional logic (`<c:if>`, `<c:choose>`) and iteration (`<c:forEach>`) in views.
5. **Custom Tags:** Reusable UI components like `<t:header>`, `<t:sidebar>`, `<t:footer>`, `<t:alert>`, and `<t:roleBadge>` encapsulated as tag files.
6. **Role-Based Access Control (RBAC):** `AuthorizationFilter` intercepts requests to validate active sessions and route users based on role permissions (Admin, Manager, Staff, Member).
7. **Listener Pattern:** `AppInitListener` bootstraps the in-memory data when Tomcat starts the application.

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
