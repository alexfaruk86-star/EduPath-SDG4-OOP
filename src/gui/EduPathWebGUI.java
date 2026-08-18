package gui;

import com.sun.net.httpserver.HttpServer;
import model.*;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class EduPathWebGUI {


    public static void main(String[] args) throws Exception {


        // ==========================================
        // CREATE TEACHER
        // ==========================================

        Teacher teacher = new Teacher(
                "T001",
                "Dr Ahmad",
                "12345",
                "TE001",
                "Java Programming"
        );


        // ==========================================
        // CREATE COURSE
        // ==========================================

        Course course = new Course(
                "C001",
                "Java Programming",
                "Object Oriented Programming Course",
                teacher
        );


        // ==========================================
        // CREATE STUDENT
        // ==========================================

        Student student = new Student(
                "U001",
                "Alex",
                "password",
                "ST001",
                "Java Programming"
        );


        // ==========================================
        // USERS FOR LOGIN
        // ==========================================

        User[] users = {
                teacher,
                student
        };


        // ==========================================
        // CREATE PROGRESS
        // ==========================================

        Progress progress =
                new Progress(student, course);

        progress.updateProgress(80);

        // Student has not taken the quiz yet
        progress.updateQuizScore(0);


        // ==========================================
        // CREATE QUIZ
        // ==========================================

        Quiz quiz = new Quiz(
                "Q001",
                "Java Basics Quiz"
        );


        quiz.addQuestion(

                new Question(
                        "What does OOP stand for?",
                        "Object Oriented Programming",
                        "Online Operating Program",
                        "Open Object Process",
                        "A"
                )
        );


        quiz.addQuestion(

                new Question(
                        "Which language is used in this course?",
                        "Python",
                        "Java",
                        "HTML",
                        "B"
                )
        );


        quiz.addQuestion(

                new Question(
                        "Which keyword creates an object in Java?",
                        "new",
                        "create",
                        "object",
                        "A"
                )
        );


        // ==========================================
        // CREATE WEB SERVER
        // ==========================================

        HttpServer server =
                HttpServer.create(

                        new InetSocketAddress(
                                "0.0.0.0",
                                8080
                        ),

                        0
                );


        // ==========================================
        // WEBSITE
        // ==========================================

        server.createContext("/", exchange -> {


            String query =
                    exchange.getRequestURI().getQuery();


            String response;


            // ======================================
            // COURSE CONTENT PAGE
            // ======================================

            if (query != null
                    && query.equals("course")) {


                response =

                        pageStart("Course Content")

                        +

                        "<h1>Java Programming</h1>"

                        +

                        "<p class='subtitle'>"
                        + course.getDescription()
                        + "</p>"

                        +

                        "<hr>"

                        +

                        "<h2>Learning Materials</h2>"

                        +

                        "<div class='section'>"

                        +

                        "<h3>1. Introduction to Java</h3>"

                        +

                        "<ul>"

                        +

                        "<li>What is Java?</li>"

                        +

                        "<li>Java applications</li>"

                        +

                        "<li>Basic Java syntax</li>"

                        +

                        "</ul>"

                        +

                        "</div>"

                        +

                        "<div class='section'>"

                        +

                        "<h3>2. Object-Oriented Programming</h3>"

                        +

                        "<ul>"

                        +

                        "<li>Classes and Objects</li>"

                        +

                        "<li>Encapsulation</li>"

                        +

                        "<li>Inheritance</li>"

                        +

                        "<li>Polymorphism</li>"

                        +

                        "</ul>"

                        +

                        "</div>"

                        +

                        "<a class='button green' "
                        + "href='/?completeCourse'>"
                        + "Mark Course as Completed"
                        + "</a>"

                        +

                        "<br><br>"

                        +

                        "<a href='/?id=U001&password=password'>"
                        + "Back to Student Dashboard"
                        + "</a>"

                        +

                        pageEnd();
            }


            // ======================================
            // COMPLETE COURSE
            // ======================================

            else if (query != null
                    && query.equals("completeCourse")) {


                progress.updateProgress(100);


                response =

                        pageStart("Course Completed")

                        +

                        "<h1>Course Completed!</h1>"

                        +

                        "<div class='success'>"

                        +

                        "<h2>Congratulations Alex!</h2>"

                        +

                        "<p>You completed Java Programming.</p>"

                        +

                        "<p><b>Progress: 100%</b></p>"

                        +

                        "</div>"

                        +

                        "<br>"

                        +

                        "<a class='button' "
                        + "href='/?id=U001&password=password'>"
                        + "Back to Dashboard"
                        + "</a>"

                        +

                        pageEnd();
            }


            // ======================================
            // QUIZ PAGE
            // ======================================

            else if (query != null
                    && query.equals("quiz")) {


                response =

                        pageStart(
                                quiz.getTitle()
                        )

                        +

                        "<h1>"
                        + quiz.getTitle()
                        + "</h1>"

                        +

                        "<p class='subtitle'>"
                        + "Answer all questions below."
                        + "</p>"

                        +

                        "<form method='get'>";


                int number = 1;


                for (Question question :
                        quiz.getQuestions()) {


                    response +=

                            "<div class='question'>"

                            +

                            "<h3>"
                            + number
                            + ". "
                            + question.getQuestionText()
                            + "</h3>"

                            +

                            "<label>"

                            +

                            "<input required "
                            + "type='radio' "
                            + "name='q"
                            + number
                            + "' "
                            + "value='A'> "

                            +

                            "A. "
                            + question.getOptionA()

                            +

                            "</label>"

                            +

                            "<br>"

                            +

                            "<label>"

                            +

                            "<input "
                            + "type='radio' "
                            + "name='q"
                            + number
                            + "' "
                            + "value='B'> "

                            +

                            "B. "
                            + question.getOptionB()

                            +

                            "</label>"

                            +

                            "<br>"

                            +

                            "<label>"

                            +

                            "<input "
                            + "type='radio' "
                            + "name='q"
                            + number
                            + "' "
                            + "value='C'> "

                            +

                            "C. "
                            + question.getOptionC()

                            +

                            "</label>"

                            +

                            "</div>";


                    number++;
                }


                response +=

                        "<button class='button' "
                        + "type='submit'>"
                        + "Submit Quiz"
                        + "</button>"

                        +

                        "</form>"

                        +

                        "<br>"

                        +

                        "<a href='/?id=U001&password=password'>"
                        + "Back to Student Dashboard"
                        + "</a>"

                        +

                        pageEnd();
            }


            // ======================================
            // QUIZ RESULT
            // ======================================

            else if (query != null
                    && query.contains("q1=")) {


                String q1 = "";
                String q2 = "";
                String q3 = "";


                String[] params =
                        query.split("&");


                for (String param : params) {


                    String[] data =
                            param.split("=");


                    if (data.length == 2) {


                        if (data[0].equals("q1")) {

                            q1 = data[1];
                        }


                        if (data[0].equals("q2")) {

                            q2 = data[1];
                        }


                        if (data[0].equals("q3")) {

                            q3 = data[1];
                        }
                    }
                }


                ArrayList<String> answers =
                        new ArrayList<>();


                answers.add(q1);
                answers.add(q2);
                answers.add(q3);


                int score =
                        quiz.calculateScore(answers);


                progress.updateQuizScore(score);


                response =

                        pageStart("Quiz Result")

                        +

                        "<h1>Quiz Result</h1>"

                        +

                        "<div class='result'>"

                        +

                        "<h2>"
                        + student.getName()
                        + "</h2>"

                        +

                        "<p>Your Score</p>"

                        +

                        "<div class='score'>"

                        +

                        score
                        + " / "
                        + quiz.getNumberOfQuestions()

                        +

                        "</div>"

                        +

                        "</div>"

                        +

                        "<br>"

                        +

                        "<a class='button' "
                        + "href='/?id=U001&password=password'>"
                        + "Back to Student Dashboard"
                        + "</a>"

                        +

                        pageEnd();
            }


            // ======================================
            // LOGIN PROCESS
            // ======================================

            else if (query != null
                    && query.contains("id=")) {


                String id = "";
                String password = "";


                String[] params =
                        query.split("&");


                for (String param : params) {


                    String[] data =
                            param.split("=");


                    if (data.length == 2) {


                        if (data[0].equals("id")) {

                            id = data[1];
                        }


                        if (data[0].equals("password")) {

                            password = data[1];
                        }
                    }
                }


                User loginUser =
                        Login.authenticate(
                                id,
                                password,
                                users
                        );


                // ==================================
                // STUDENT DASHBOARD
                // ==================================

                if (loginUser instanceof Student) {


                    Student loggedStudent =
                            (Student) loginUser;


                    response =

                            pageStart(
                                    "Student Dashboard"
                            )

                            +

                            "<h1>Student Dashboard</h1>"

                            +

                            "<h2>Welcome "
                            + loggedStudent.getName()
                            + "</h2>"

                            +

                            "<hr>"

                            +

                            "<div class='info'>"

                            +

                            "<p><b>Student ID:</b> "
                            + loggedStudent.getStudentId()
                            + "</p>"

                            +

                            "<p><b>Course:</b> "
                            + course.getCourseName()
                            + "</p>"

                            +

                            "<p><b>Teacher:</b> "
                            + teacher.getName()
                            + "</p>"

                            +

                            "</div>"

                            +

                            "<h3>Learning Progress</h3>"

                            +

                            "<div class='progress-background'>"

                            +

                            "<div class='progress-bar' "
                            + "style='width:"
                            + progress.getCompletedPercentage()
                            + "%;'>"

                            +

                            progress.getCompletedPercentage()
                            + "%"

                            +

                            "</div>"

                            +

                            "</div>"

                            +

                            "<br>"

                            +

                            "<p><b>Quiz Score:</b> "

                            +

                            progress.getQuizScore()

                            +

                            " / "

                            +

                            quiz.getNumberOfQuestions()

                            +

                            "</p>"

                            +

                            "<div class='buttons'>"

                            +

                            "<a class='button' "
                            + "href='/?course'>"
                            + "View Course Content"
                            + "</a>"

                            +

                            "<a class='button' "
                            + "href='/?quiz'>"
                            + "Take Quiz"
                            + "</a>"

                            +

                            "</div>"

                            +

                            "<br><br>"

                            +

                            "<a href='/'>Logout</a>"

                            +

                            pageEnd();
                }


                // ==================================
                // TEACHER DASHBOARD
                // ==================================

                else if (loginUser
                        instanceof Teacher) {


                    Teacher loggedTeacher =
                            (Teacher) loginUser;


                    response =

                            pageStart(
                                    "Teacher Dashboard"
                            )

                            +

                            "<h1>Teacher Dashboard</h1>"

                            +

                            "<h2>Welcome "
                            + loggedTeacher.getName()
                            + "</h2>"

                            +

                            "<hr>"

                            +

                            "<h3>Teacher Information</h3>"

                            +

                            "<p><b>Teacher ID:</b> "
                            + loggedTeacher.getTeacherId()
                            + "</p>"

                            +

                            "<p><b>Subject:</b> "
                            + loggedTeacher.getSubject()
                            + "</p>"

                            +

                            "<h3>Course Information</h3>"

                            +

                            "<p><b>Course:</b> "
                            + course.getCourseName()
                            + "</p>"

                            +

                            "<p><b>Description:</b> "
                            + course.getDescription()
                            + "</p>"

                            +

                            "<h3>Quiz Information</h3>"

                            +

                            "<p><b>Quiz:</b> "
                            + quiz.getTitle()
                            + "</p>"

                            +

                            "<p><b>Questions:</b> "
                            + quiz.getNumberOfQuestions()
                            + "</p>"

                            +

                            "<h3>Student Performance</h3>"

                            +

                            "<table>"

                            +

                            "<tr>"

                            +

                            "<th>Student</th>"

                            +

                            "<th>Progress</th>"

                            +

                            "<th>Quiz Score</th>"

                            +

                            "</tr>"

                            +

                            "<tr>"

                            +

                            "<td>"
                            + student.getName()
                            + "</td>"

                            +

                            "<td>"
                            + progress.getCompletedPercentage()
                            + "%</td>"

                            +

                            "<td>"
                            + progress.getQuizScore()
                            + "/"
                            + quiz.getNumberOfQuestions()
                            + "</td>"

                            +

                            "</tr>"

                            +

                            "</table>"

                            +

                            "<br><br>"

                            +

                            "<a href='/'>Logout</a>"

                            +

                            pageEnd();
                }


                // ==================================
                // INVALID LOGIN
                // ==================================

                else {


                    response =

                            pageStart(
                                    "Login Failed"
                            )

                            +

                            "<h1>Login Failed</h1>"

                            +

                            "<div class='error'>"

                            +

                            "<p>Invalid User ID "
                            + "or Password.</p>"

                            +

                            "</div>"

                            +

                            "<br>"

                            +

                            "<a class='button' "
                            + "href='/'>"
                            + "Try Again"
                            + "</a>"

                            +

                            pageEnd();
                }
            }


            // ======================================
            // LOGIN PAGE
            // ======================================

            else {


                response =

                        pageStart("EduPath Login")

                        +

                        "<h1>EduPath</h1>"

                        +

                        "<p class='subtitle'>"
                        + "SDG 4 - Quality Education"
                        + "</p>"

                        +

                        "<hr>"

                        +

                        "<h2>Login</h2>"

                        +

                        "<form method='get'>"

                        +

                        "<label>User ID</label>"

                        +

                        "<input "
                        + "name='id' "
                        + "placeholder='Enter User ID' "
                        + "required>"

                        +

                        "<label>Password</label>"

                        +

                        "<input "
                        + "name='password' "
                        + "type='password' "
                        + "placeholder='Enter Password' "
                        + "required>"

                        +

                        "<button class='button' "
                        + "type='submit'>"
                        + "Login"
                        + "</button>"

                        +

                        "</form>"

                        +

                        "<hr>"

                        +

                        "<h3>Demo Accounts</h3>"

                        +

                        "<p>"

                        +

                        "<b>Student</b><br>"

                        +

                        "ID: U001<br>"

                        +

                        "Password: password"

                        +

                        "</p>"

                        +

                        "<p>"

                        +

                        "<b>Teacher</b><br>"

                        +

                        "ID: T001<br>"

                        +

                        "Password: 12345"

                        +

                        "</p>"

                        +

                        pageEnd();
            }


            // ======================================
            // SEND HTML
            // ======================================

            byte[] responseBytes =
                    response.getBytes(
                            StandardCharsets.UTF_8
                    );


            exchange.getResponseHeaders()
                    .set(
                            "Content-Type",
                            "text/html; charset=UTF-8"
                    );


            exchange.sendResponseHeaders(
                    200,
                    responseBytes.length
            );


            OutputStream os =
                    exchange.getResponseBody();


            os.write(responseBytes);

            os.close();
        });


        // ==========================================
        // START SERVER
        // ==========================================

        server.start();


        System.out.println(

                "EduPath website running at "
                + "http://localhost:8080"
        );
    }


    // ==============================================
    // COMMON HTML START
    // ==============================================

    private static String pageStart(
            String title) {


        return

                "<!DOCTYPE html>"

                +

                "<html>"

                +

                "<head>"

                +

                "<meta charset='UTF-8'>"

                +

                "<meta name='viewport' "
                + "content='width=device-width,"
                + "initial-scale=1.0'>"

                +

                "<title>"
                + title
                + "</title>"

                +

                "<style>"

                +

                "*{box-sizing:border-box;}"

                +

                "body{"
                + "font-family:Arial,sans-serif;"
                + "background:#f1f6ff;"
                + "margin:0;"
                + "padding:40px;"
                + "color:#1f2937;"
                + "}"

                +

                ".container{"
                + "background:white;"
                + "max-width:700px;"
                + "margin:auto;"
                + "padding:35px;"
                + "border-radius:18px;"
                + "box-shadow:0 4px 15px "
                + "rgba(0,0,0,0.18);"
                + "}"

                +

                "h1{"
                + "color:#2563eb;"
                + "}"

                +

                ".subtitle{"
                + "color:#64748b;"
                + "}"

                +

                "input{"
                + "width:100%;"
                + "padding:12px;"
                + "margin:8px 0 18px 0;"
                + "border:1px solid #ccc;"
                + "border-radius:6px;"
                + "}"

                +

                ".button{"
                + "display:inline-block;"
                + "background:#2563eb;"
                + "color:white;"
                + "padding:11px 18px;"
                + "border:none;"
                + "border-radius:7px;"
                + "text-decoration:none;"
                + "cursor:pointer;"
                + "margin-right:8px;"
                + "}"

                +

                ".green{"
                + "background:#16a34a;"
                + "}"

                +

                ".section{"
                + "background:#f8fafc;"
                + "padding:15px;"
                + "margin:15px 0;"
                + "border-radius:8px;"
                + "}"

                +

                ".question{"
                + "padding:15px;"
                + "margin:15px 0;"
                + "background:#f8fafc;"
                + "border-radius:8px;"
                + "}"

                +

                ".progress-background{"
                + "background:#e5e7eb;"
                + "border-radius:20px;"
                + "overflow:hidden;"
                + "}"

                +

                ".progress-bar{"
                + "background:#2563eb;"
                + "color:white;"
                + "padding:8px;"
                + "text-align:center;"
                + "border-radius:20px;"
                + "}"

                +

                ".score{"
                + "font-size:45px;"
                + "font-weight:bold;"
                + "color:#2563eb;"
                + "}"

                +

                ".result,"
                + ".success{"
                + "background:#ecfdf5;"
                + "padding:20px;"
                + "border-radius:10px;"
                + "}"

                +

                ".error{"
                + "background:#fee2e2;"
                + "padding:20px;"
                + "border-radius:10px;"
                + "}"

                +

                "table{"
                + "width:100%;"
                + "border-collapse:collapse;"
                + "}"

                +

                "th,td{"
                + "border:1px solid #ddd;"
                + "padding:10px;"
                + "text-align:left;"
                + "}"

                +

                "th{"
                + "background:#2563eb;"
                + "color:white;"
                + "}"

                +

                ".buttons{"
                + "margin-top:20px;"
                + "}"

                +

                "</style>"

                +

                "</head>"

                +

                "<body>"

                +

                "<div class='container'>";
    }


    // ==============================================
    // COMMON HTML END
    // ==============================================

    private static String pageEnd() {

        return

                "</div>"

                +

                "</body>"

                +

                "</html>";
    }
}