package gui;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class EduPathWebGUI {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", 8080), 
                0
        );

        server.createContext("/", exchange -> {

            String response = """
                    <!DOCTYPE html>
                    <html>
                    <head>
                        <title>EduPath - SDG 4 Quality Education</title>

                        <style>
                            body {
                                font-family: Arial;
                                background-color: #f4f6f8;
                                padding: 40px;
                            }

                            .card {
                                background:white;
                                padding:30px;
                                border-radius:15px;
                                width:500px;
                                box-shadow:0 0 10px gray;
                            }

                            h1 {
                                color:#1a73e8;
                            }

                            h2 {
                                color:#333;
                            }

                            p {
                                font-size:18px;
                            }
                        </style>

                    </head>

                    <body>

                        <div class="card">

                            <h1>
                            EduPath - SDG 4 Quality Education
                            </h1>

                            <hr>

                            <h2>
                            Course Information
                            </h2>

                            <p>
                            Course: Java Programming
                            </p>

                            <p>
                            Teacher: Dr Ahmad
                            </p>


                            <h2>
                            Student Progress
                            </h2>

                            <p>
                            Student: Alex
                            </p>

                            <p>
                            Completion: 80%
                            </p>

                            <p>
                            Quiz Score: 9/10
                            </p>


                        </div>

                    </body>

                    </html>
                    """;


            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html");


            exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
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