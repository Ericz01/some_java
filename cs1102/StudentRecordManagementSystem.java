import java.util.InputMismatchException;
import java.util.Scanner;

// Declare the main class
public class StudentRecordManagementSystem {

    static int totalStudents = 0; // Initializing students count
    static String[] studentNames = new String[100];
    static int[] studentIDs = new int[100];
    static int[] studentAges = new int[100];
    static double[] studentGrades = new double[100];

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Student Record Management System. Select an option:");
    
        while (true) {
            // Display the options available 
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Get the option selected by user
            int choice = scanner.nextInt();
    
            // Consume the newline character
            scanner.nextLine();
            
            // Handle user's choice
            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    updateStudentInformation(scanner);
                    break;
                case 3:
                    viewStudentDetails(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Student Record Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }    
    // Method to add a student to the system
    public static void addNewStudent(Scanner scanner) {
        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim(); // Use nextLine to handle spaces
            if (name.isEmpty()) {
                System.out.println("Invalid name. Please enter a non-empty name.");
            } else {
                int id;
                while (true) {
                    try {
                        System.out.print("Enter student ID: ");
                        id = scanner.nextInt();
                        break; // Exit the loop if ID input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID format. Please enter a valid integer ID.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                }
                scanner.nextLine(); // Consume the newline character
                int age;
                while (true) {
                    try {
                        System.out.print("Enter student age: ");
                        age = scanner.nextInt();
                        break; // Exit the loop if age input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid age format. Please enter a valid integer age.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                }
                scanner.nextLine(); // Consume the newline character
                double grade;
                while (true) {
                    try {
                        System.out.print("Enter student grade: ");
                        grade = scanner.nextDouble();
                        break; // Exit the loop if grade input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid grade format. Please enter a valid double grade.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                }
                scanner.nextLine(); // Consume the newline character

                studentNames[totalStudents] = name;
                studentIDs[totalStudents] = id;
                studentAges[totalStudents] = age;
                studentGrades[totalStudents] = grade;
                totalStudents++;

                System.out.println("Student added successfully!");
                break; // Exit the loop after successful addition
            }
        }
    }

    public static void updateStudentInformation(Scanner scanner) {
        System.out.print("Enter student ID to update information: ");
        int id;
        while (true) {
            try {
                id = scanner.nextInt();
                break; // Exit the loop if ID input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid ID format. Please enter a valid integer ID.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character

        int index = findStudentIndexByID(id);
        if (index != -1) {
            System.out.print("Enter updated student name: ");
            studentNames[index] = scanner.nextLine();

            int age;
            while (true) {
                try {
                    System.out.print("Enter updated student age: ");
                    age = scanner.nextInt();
                    break; // Exit the loop if age input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid age format. Please enter a valid integer age.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            scanner.nextLine(); // Consume the newline character

            double grade;
            while (true) {
                try {
                    System.out.print("Enter updated student grade: ");
                    grade = scanner.nextDouble();
                    break; // Exit the loop if grade input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid grade format. Please enter a valid double grade.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            scanner.nextLine(); // Consume the newline character

            studentAges[index] = age;
            studentGrades[index] = grade;
            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Student ID not found!");
        }
    }

    // Displaying student info
    public static void viewStudentDetails(Scanner scanner) {
        System.out.print("Enter student ID to view details: ");
        int id = scanner.nextInt();
        int index = findStudentIndexByID(id);
        if (index != -1) {
            System.out.println("Student Name: " + studentNames[index]);
            System.out.println("Student ID: " + studentIDs[index]);
            System.out.println("Student Age: " + studentAges[index]);
            System.out.println("Student Grade: " + studentGrades[index]);
        } else {
            System.out.println("Student ID not found!");
        }
    }

    // Indexing students by their IDs
    public static int findStudentIndexByID(int id) {
        for (int i = 0; i < totalStudents; i++) {
            // Return student's id
            if (studentIDs[i] == id) {
                return i;
            }
        }
        // If ID not found
        return -1;
    }
}
