import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Define scanner.
        Scanner scanner = new Scanner(System.in);

        // define quiz questions
        String[] questions = {
            "Evaluate: 7 x 2 + 10 ÷ 2 - (2 x 6)",
            "Which is the largest country on earth?",
            "Who developed calculus?",
            "Which is the second stage in metamorphosis?",
            "Which among these is not a programming language?"
        };

        // Define a string array of answers,
        String[] options = {
            "A. 60", "B. 13", "C. 7", "D. 10",
            "A. China", "B. USA", "C. Australia", "D. Russia",
            "A. Albert Einstein", "B. Isaac Newton", "C. Charles Darwin", "D. Galileo Galilei",
            "A. Larva", "B. Pupa", "C. Adult", "D. Egg",
            "A. Swift", "B. HTML", "C. C", "D. Javascript"
        };

        // Define an array of the correct answer characters.
        char[] answers = {'C', 'D', 'B', 'A', 'B'};

        int total_questions = questions.length;
        int score = 0;

        // Display and process each question
        for (int i = 0; i < total_questions; i++) {
            boolean valid_choice = false;
            int question_index = i + 1;
            // Handle invalid input
            while (!valid_choice) {
                System.out.println("\n" + question_index + ") " + questions[i]);
                for (int j = 0; j < 4; j++) {
                    System.out.println(options[i * 4 + j]);
                }

                // Take user's answers
                System.out.print("Enter answer: ");
                char user_answer = Character.toUpperCase(scanner.next().charAt(0));

                // Check if the answer is valid
                if (user_answer == 'A' || user_answer == 'B' || user_answer == 'C' || user_answer == 'D') {
                    valid_choice = true;
                    // Check if the answer is correct. If correct, increase the score.
                    if (user_answer == answers[i]) {
                        System.out.println("Correct!\n");
                        score++;
                    } else {
                        System.out.println("Incorrect!\n");
                    }
                // Display a message if the input is invalid.
                } else {
                    System.out.println("\nInvalid option. Select A, B, C or D.");
                }
               
            }
        }
        // Compute the percentage 
        double percentage = ((double)score / total_questions) * 100;

        // Display the score
        System.out.printf("Quiz completed! You scored %d out of %d (%.0f%%).%n", score, total_questions, percentage);

        // Close the scanner
        scanner.close();
    }
}
