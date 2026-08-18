package gui;

import com.sun.net.httpserver.HttpServer;
import model.*;

import java.io.OutputStream;
import java.net.InetSocketAddress;


public class EduPathWebGUI {


    public static void main(String[] args) throws Exception {


        Teacher teacher = new Teacher(
                "T001",
                "Dr Ahmad",
                "12345",
                "TE001",
                "Java Programming"
        );


        Course course = new Course(
                "C001",
                "Java Programming",
                "Object Oriented Programming Course",
                teacher
        );


        Student student = new Student(
                "U001",
                "Alex",
                "password",
                "ST001",
                "Java Programming"
        );


        Progress progress = new Progress(student, course);

        progress.updateProgress(80);
        progress.updateQuizScore(9);



        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0",8080),
                0
        );



        server.createContext("/", exchange -> {


            String response =

            "<html>" +
            "<head>" +
            "<title>EduPath Dashboard</title>" +

            "<style>" +

            "body{" +
            "font-family:Arial;" +
            "background:#f2f7ff;" +
            "padding:40px;" +
            "}" +

            ".card{" +
            "background:white;" +
            "padding:25px;" +
            "width:400px;" +
            "border-radius:15px;" +
            "box-shadow:0 4px 10px gray;" +
            "}" +

            "h1{color:#2563eb;}" +

            "</style>" +

            "</head>" +


            "<body>" +

            "<div class='card'>" +

            "<h1>EduPath - SDG 4 Quality Education</h1>" +

            "<hr>" +

            "<h2>Course Information</h2>" +

            "Course: " + course.getCourseName() +

            "<br><br>" +

            "Teacher: " + course.getTeacher().getName() +

            "<br><br>" +

            "Description: " + course.getDescription() +


            "<h2>Student Progress</h2>" +

            "Student: " + student.getName() +

            "<br><br>" +

            "Completion: " + progress.getCompletedPercentage() + "%" +

            "<br><br>" +

            "Quiz Score: " + progress.getQuizScore() + "/10" +


            "</div>" +

            "</body>" +

            "</html>";



            exchange.getResponseHeaders()
                    .set("Content-Type","text/html");

            exchange.sendResponseHeaders(
                    200,
                    response.length()
            );


            OutputStream os =
                    exchange.getResponseBody();


            os.write(response.getBytes());

            os.close();


        });



        server.start();


        System.out.println(
                "EduPath website running at http://localhost:8080"
        );


    }

}