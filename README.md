# EduPath - SDG 4 Quality Education

EduPath is a Java Object-Oriented Programming (OOP) application developed to support **Sustainable Development Goal 4 (SDG 4): Quality Education**.

The system provides a simple educational platform where students can log in, view course information and learning materials, monitor their learning progress, complete quizzes, and view their scores. Teachers can log in to monitor student progress and quiz results.

---

## Features

- Student and Teacher login
- Role-based dashboards
- OOP-based authentication
- Course information
- Learning materials
- Student progress tracking
- Progress bar
- Mark course as complete
- Quiz system
- Multiple-choice questions
- Automatic quiz marking
- Quiz score update
- Teacher viewing student progress and results
- Invalid login handling
- Logout functionality

---

## OOP Concepts Used

### 1. Encapsulation

Private attributes are used in classes such as `User`, `Student`, `Teacher`, `Course`, `Progress`, `Question`, and `Quiz`.

Getter and setter methods are used to access or modify object data safely.

### 2. Inheritance

The `Student` and `Teacher` classes inherit common attributes and methods from the `User` class.

Example:

```java
public class Student extends User
```

```java
public class Teacher extends User
```

### 3. Abstraction

`User` is an abstract class containing the abstract method:

```java
public abstract void displayDashboard();
```

This method must be implemented by subclasses such as `Student` and `Teacher`.

### 4. Polymorphism

`Student` and `Teacher` provide their own implementation of:

```java
displayDashboard()
```

The system can also use a `User` reference to represent different types of users during authentication.

### 5. Association

The project demonstrates relationships between different objects.

Examples:

- A `Course` has a `Teacher`
- A `Progress` object is associated with a `Student`
- A `Progress` object is associated with a `Course`
- A `Quiz` contains multiple `Question` objects

### 6. Collections

`ArrayList` is used in the `Quiz` class to store multiple `Question` objects.

---

## Project Structure

```text
EduPath-SDG4-OOP
│
├── src
│   │
│   ├── gui
│   │   └── EduPathWebGUI.java
│   │
│   └── model
│       ├── Course.java
│       ├── Login.java
│       ├── Progress.java
│       ├── Question.java
│       ├── Quiz.java
│       ├── Student.java
│       ├── Teacher.java
│       └── User.java
│
├── .gitignore
└── README.md
```

---

## Demo Accounts

### Student Login

```text
User ID: U001
Password: password
```

### Teacher Login

```text
User ID: T001
Password: 12345
```

---

## How to Compile

Open the terminal from the project root directory and run:

```bash
javac -cp src src/model/*.java src/gui/EduPathWebGUI.java
```

If there are no compilation errors, run the application using:

```bash
java -cp src gui.EduPathWebGUI
```

The terminal should display:

```text
EduPath website running at http://localhost:8080
```

When using GitHub Codespaces, open the forwarded **Port 8080** to access the application in the browser.

---

## System Flow

```text
                    Login
                      |
          +-----------+-----------+
          |                       |
       Student                  Teacher
          |                       |
 Student Dashboard       Teacher Dashboard
          |                       |
          |                View Student
          |                Progress & Result
          |
          +---- View Course Information
          |
          +---- View Learning Materials
          |
          +---- Monitor Progress
          |
          +---- Mark Course Complete
          |
          +---- Take Quiz
          |
          +---- Automatic Marking
          |
          +---- View Quiz Score
```

---

## Student Functions

After logging in as a student, the user can:

1. View student information
2. View course information
3. View teacher information
4. View learning materials
5. Monitor course completion
6. View the progress bar
7. Mark the course as completed
8. Take the Java Basics Quiz
9. Submit quiz answers
10. Receive an automatically calculated quiz score
11. View the updated quiz score
12. Logout from the system

---

## Teacher Functions

After logging in as a teacher, the user can:

1. View teacher information
2. View subject information
3. View course information
4. View quiz information
5. View the number of quiz questions
6. View student information
7. Monitor student course progress
8. View student quiz results
9. Logout from the system

---

## Quiz System

The application contains a **Java Basics Quiz**.

The quiz currently contains questions covering:

- Object-Oriented Programming
- Java programming language
- Java object creation

Each question contains three possible answers:

```text
A
B
C
```

The student selects an answer for each question and submits the quiz.

The system automatically checks the answers and calculates the student's score.

Example:

```text
Quiz Score: 3/3
```

The updated result can then be viewed from the Student Dashboard and Teacher Dashboard.

---

## Login System

The application supports two user roles:

### Student

Students are redirected to the **Student Dashboard** after successful authentication.

### Teacher

Teachers are redirected to the **Teacher Dashboard** after successful authentication.

If the User ID or password is incorrect, the system handles the invalid login attempt instead of allowing access to the dashboard.

---

## Course Progress

The system tracks the student's progress for the course.

The `Progress` class connects:

```text
Student
   |
Progress
   |
Course
```

The progress information includes:

- Course completion percentage
- Quiz score

The completion percentage can be displayed visually using a progress bar.

---

## Classes

### User

The `User` class is the abstract parent class for system users.

It contains common information such as:

- ID
- Name
- Password

It also defines:

```java
public abstract void displayDashboard();
```

---

### Student

The `Student` class extends `User`.

It contains student-specific information such as:

- Student ID
- Course

---

### Teacher

The `Teacher` class extends `User`.

It contains teacher-specific information such as:

- Teacher ID
- Subject

---

### Course

The `Course` class stores course information including:

- Course ID
- Course name
- Description
- Teacher

---

### Progress

The `Progress` class tracks:

- Student
- Course
- Completion percentage
- Quiz score

---

### Question

The `Question` class represents an individual quiz question.

It stores:

- Question text
- Option A
- Option B
- Option C
- Correct answer

---

### Quiz

The `Quiz` class manages quiz information.

It stores:

- Quiz ID
- Quiz title
- Multiple questions using `ArrayList<Question>`

---

### Login

The `Login` class is responsible for authenticating users.

It checks the entered:

- User ID
- Password

and returns the correct `User` when the login credentials are valid.

---

### EduPathWebGUI

`EduPathWebGUI` provides the web-based user interface for the EduPath system.

It handles pages such as:

- Login
- Student Dashboard
- Teacher Dashboard
- Course information
- Learning materials
- Quiz
- Quiz results
- Logout

The web application runs using Java's HTTP server.

---

## SDG 4 Contribution

EduPath supports **United Nations Sustainable Development Goal 4: Quality Education**.

The project demonstrates how a digital education system can support learning through:

- Accessible educational content
- Digital learning materials
- Student progress monitoring
- Online assessments
- Automatic assessment feedback
- Teacher monitoring of student performance

These features demonstrate the use of technology to support accessible and effective learning.

---

## Technologies Used

- Java
- Object-Oriented Programming
- Java Collections
- `ArrayList`
- Java HTTP Server
- HTML
- CSS
- Git
- GitHub
- GitHub Codespaces

---

## Testing

The following functions were tested:

| Test | Expected Result |
|---|---|
| Student login with correct credentials | Student Dashboard displayed |
| Teacher login with correct credentials | Teacher Dashboard displayed |
| Incorrect login | Invalid login message displayed |
| View course information | Course details displayed |
| View learning materials | Learning materials displayed |
| View student progress | Completion percentage displayed |
| Mark course complete | Progress updated |
| Open quiz | Quiz questions displayed |
| Submit correct quiz answers | Correct score calculated |
| Submit incorrect answers | Score calculated based on correct answers |
| Student quiz result | Updated score displayed |
| Teacher views student result | Student score displayed |
| Logout | User returned to login page |

---

## Expected Student Login Result

Using:

```text
User ID: U001
Password: password
```

The system displays the **Student Dashboard**, including:

- Student ID
- Course
- Teacher
- Course completion
- Quiz score
- Learning functions
- Quiz function

---

## Expected Teacher Login Result

Using:

```text
User ID: T001
Password: 12345
```

The system displays the **Teacher Dashboard**, including:

- Teacher ID
- Subject
- Course
- Quiz information
- Number of questions
- Student information
- Student progress
- Student quiz score

---

## Conclusion

EduPath demonstrates the implementation of Object-Oriented Programming concepts in a simple educational web application.

The project combines Java classes, inheritance, abstraction, encapsulation, polymorphism, association, collections, authentication, progress tracking, and quiz functionality.

The application supports **SDG 4: Quality Education** by providing a basic digital learning environment for students and teachers.