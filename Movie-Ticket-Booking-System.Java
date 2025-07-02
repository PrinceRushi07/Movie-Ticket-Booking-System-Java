//package JavaCollections;
import java.util.*;

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> movies = new ArrayList<>();
        ArrayList<String> bookings = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n----------- Movie Ticket Booking System -----------");
            System.out.println("1. Add Multiple Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. View All Bookings");
            System.out.println("4. Check if User is Booked");
            System.out.println("5. Get Sublist of Bookings");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Get First and Last Booking");
            System.out.println("8. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter number of movies to add: ");
                    int n = sc.nextInt();
                    sc.nextLine(); 
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter movie " + (i + 1) + ": ");
                        String movie = sc.nextLine();
                        movies.add(movie);
                    }
                    System.out.println("Movies added successfully.");
                    break;

                case 2:
                    if (movies.isEmpty()) {
                        System.out.println("No movies available. Please add movies first.");
                        break;
                    }
                    System.out.print("Enter your name: ");
                    String user = sc.nextLine();
                    System.out.println("Available Movies:");
                    for (int i = 0; i < movies.size(); i++) {
                        System.out.println((i + 1) + ". " + movies.get(i));
                    }
                    System.out.print("Choose movie index: ");
                    int movieIndex = sc.nextInt();
                    sc.nextLine(); 
                    if (movieIndex >= 1 && movieIndex <= movies.size()) {
                        String movieBooked = movies.get(movieIndex - 1);
                        bookings.add(user + " - " + movieBooked);
                        System.out.println("Ticket booked successfully for " + user);
                    } else {
                        System.out.println("Invalid movie index.");
                    }
                    break;

                case 3:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings found.");
                    } else {
                        System.out.println("All Bookings:");
                        for (String booking : bookings) {
                            System.out.println(booking);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter user name to search: ");
                    String searchUser = sc.nextLine();
                    boolean found = false;
                    for (String booking : bookings) {
                        if (booking.startsWith(searchUser + " -")) {
                            System.out.println("Booking found: " + booking);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No booking found for user " + searchUser);
                    }
                    break;

                case 5:
                    if (bookings.size() < 2) {
                        System.out.println("Not enough bookings for sublist.");
                    } else {
                        System.out.print("Enter start index (0-based): ");
                        int start = sc.nextInt();
                        System.out.print("Enter end index (exclusive): ");
                        int end = sc.nextInt();
                        sc.nextLine();

                        if (start >= 0 && end <= bookings.size() && start < end) {
                            List<String> sublist = bookings.subList(start, end);
                            System.out.println("Sublist of bookings:");
                            for (String s : sublist) {
                                System.out.println(s);
                            }
                        } else {
                            System.out.println("Invalid index range.");
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter user name to cancel ticket: ");
                    String cancelUser = sc.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < bookings.size(); i++) {
                        if (bookings.get(i).startsWith(cancelUser + " -")) {
                            bookings.remove(i);
                            System.out.println("Booking cancelled for " + cancelUser);
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("No booking found for user " + cancelUser);
                    }
                    break;

                case 7:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings to show.");
                    } else {
                        System.out.println("First Booking: " + bookings.get(0));
                        System.out.println("Last Booking: " + bookings.get(bookings.size() - 1));
                    }
                    break;

                case 8:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}
