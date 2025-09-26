package Notes_manager;


	import java.io.*;   // For FileReader, FileWriter, BufferedReader
	import java.util.Scanner;

	public class Notes_manager {
	    private static final String FILE_NAME = "notes.txt"; // File to store notes

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n=== Notes Manager ===");
	            System.out.println("1. Add a Note");
	            System.out.println("2. View Notes");
	            System.out.println("3. Exit");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); // consume leftover newline

	            switch (choice) {
	                case 1:
	                    addNote(sc);
	                    break;
	                case 2:
	                    viewNotes();
	                    break;
	                case 3:
	                    System.out.println("Goodbye!");
	                    sc.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice, try again.");
	            }
	        }
	    }

	    // Function to add a note
	    private static void addNote(Scanner sc) {
	        System.out.print("Enter your note: ");
	        String note = sc.nextLine();

	        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { 
	            // true = append mode
	            writer.write(note + "\n");
	            System.out.println("Note saved successfully!");
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }
	    }

	    // Function to view notes
	    private static void viewNotes() {
	        System.out.println("\n--- Your Notes ---");
	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            boolean empty = true;
	            while ((line = reader.readLine()) != null) {
	                System.out.println("- " + line);
	                empty = false;
	            }
	            if (empty) {
	                System.out.println("(No notes found)");
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("No notes file found. Add some notes first!");
	        } catch (IOException e) {
	            System.out.println("Error reading from file: " + e.getMessage());
	        }
	    }
	}
