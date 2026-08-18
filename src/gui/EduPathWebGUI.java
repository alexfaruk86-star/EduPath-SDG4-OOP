package gui;

import model.*;
import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class EduPathWebGUI {

    public static void main(String[] args) throws Exception {

        // Create OOP objects
        Student student = new Student(
                "Alex",
                "Computer Science"
        );

        Teacher teacher = new Teacher(
                "Dr Ahmad",
                "T001",
                "Programming"
        );


        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 
                0
        );


        server.createContext("/", exchange -> {

            String response = 
            """
            <html>

            <head>
                <title>EduPath SDG 4</title>
            </head>


            <body>

            <h1>EduPath - SDG 4 Quality Education</h1>

            <hr>


            <h2>Course Information</h2>

            <p>
            Course: Java Programming
            </p>


            <p>
            Teacher: """ + teacher.getName() + """
            </p>



            <h2>Student Progress</h2>


            <p>
            Student: """ + student.getName() + """
            </p>


            <p>
            Course: """ + student.getCourse() + """
            </p>


            <p>
            Completion: 80%
            </p>


            <p>
            Quiz Score: 9/10
            </p>


            </body>

            </html>
            """;


            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html");


            exchange.sendResponseHeaders(
                    200,
                    response.length()
            );


            OutputStream os = exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();

        });


        server.start();


        System.out.println(
            "EduPath website running at http://localhost:8080"
        );

    }

}