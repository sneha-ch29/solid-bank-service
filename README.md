# 🏦 SOLID Principles Banking Service

A real-time Spring Boot application demonstrating the five **SOLID** principles of object-oriented design.

---

## 🚀 Getting Started

### Prerequisites
* Java 17 or higher
* Maven 3.6+

### Run the Application
1. Clone the repository.
2. Open your terminal in the project root.
3. Run the following command:
   ```bash
   ./mvnw spring-boot:run

4. Access the H2 Database Console at: http://localhost:8080/h2-console
    JDBC URL: jdbc:h2:mem:bankdb
    User: sa | Password: password

🏗️ SOLID Implementation Details
   This project is organized to showcase clean code architecture:

1. Single Responsibility Principle (SRP)

   Each class has one job. 
   TransactionService: Handles the logic of moving money.
   EmailProvider: Handles the logic of sending notifications.

2. Open/Closed Principle (OCP)

   The system is open for extension but closed for modification.
   We use the Strategy Pattern for Interest calculation. You can add a new InvestmentInterest class without changing the InterestService.

3. Liskov Substitution Principle (LSP)

   Subclasses can replace their parent without breaking the app.
   FixedDepositAccount is an Account, but it explicitly flags that it is not withdrawable, allowing the service to handle it gracefully without crashing.

4. Interface Segregation Principle (ISP)

   Clients only see what they need.
   CustomerController provides only deposit/withdraw actions. Admin actions (like deleting accounts) are kept in separate interfaces/controllers.

5. Dependency Inversion Principle (DIP)

   High-level modules depend on abstractions, not concretions.
   TransactionService depends on the MessageProvider interface, not the specific EmailProvider class.