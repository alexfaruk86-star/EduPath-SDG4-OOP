package util;

import model.Progress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

    private static final String DIRECTORY = "data";
    private static final String FILE_PATH = "data/student_progress.txt";

    // Save student progress and quiz score
    public static void saveProgress(Progress progress) {

        File directory = new File(DIRECTORY);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_PATH))) {

            writer.println(
                 progress.getStudent().getId()
                    + ","
                    + progress.getCompletedPercentage()
                    + ","
                    + progress.getQuizScore()
            );

            System.out.println("Progress saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving progress: "
                    + e.getMessage()
            );
        }
    }


    // Load previously saved progress
    public static void loadProgress(Progress progress) {

        File file = new File(FILE_PATH);

        if (!file.exists()) {

            System.out.println(
                    "No saved progress found. Using default values."
            );

            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line = reader.readLine();

            if (line != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    int completedPercentage =
                            Integer.parseInt(data[1]);

                    int quizScore =
                            Integer.parseInt(data[2]);

                    progress.updateProgress(completedPercentage);
                    progress.updateQuizScore(quizScore);

                    System.out.println(
                            "Progress loaded successfully."
                    );
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading progress: "
                    + e.getMessage()
            );
        }
    }
}