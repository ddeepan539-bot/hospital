import java.util.*;

class Patient {
    int id, age;
    String name, contact, doctor, appointment;

    Patient(int id, String name, int age, String contact, String doctor, String appointment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.doctor = doctor;
        this.appointment = appointment;
    }

    void display() {
        System.out.println("\n----------------------------------------");
        System.out.println("Patient ID  : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Contact     : " + contact);
        System.out.println("Doctor      : " + doctor);
        System.out.println("Appointment : " + appointment);
        System.out.println("----------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();
        boolean running = true;

        System.out.println("=== Hospital Management System ===");

        while (running) {
            System.out.println("\n--- Hospital Menu ---");
            System.out.println("1. Register Patient & Appointment");
            System.out.println("2. Search Patient by ID");
            System.out.println("3. Display Appointments for a Selected Doctor");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctor = scanner.nextLine();
                    System.out.print("Enter Appointment Date/Time: ");
                    String appointment = scanner.nextLine();

                    patients.add(new Patient(id, name, age, contact, doctor, appointment));
                    System.out.println("Patient and appointment registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to Search: ");
                    int searchId = scanner.nextInt();
                    boolean found = false;
                    for (Patient p : patients) {
                        if (p.id == searchId) {
                            p.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Patient with ID " + searchId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Doctor Name: ");
                    String searchDoctor = scanner.nextLine();
                    boolean docFound = false;
                    System.out.println("\n--- Appointments for Dr. " + searchDoctor + " ---");
                    for (Patient p : patients) {
                        if (p.doctor.equalsIgnoreCase(searchDoctor)) {
                            System.out.println("- Patient: " + p.name + " (ID: " + p.id + ") at " + p.appointment);
                            docFound = true;
                        }
                    }
                    if (!docFound) {
                        System.out.println("No appointments found for this doctor.");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}