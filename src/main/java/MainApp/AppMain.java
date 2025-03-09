package MainApp;

import DAOs.AnimalDao;
import DAOs.MySqlDonorDao;
import DTOs.Animal;
import DAOs.MySqlAnimalDao;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.sql.SQLException;

public class AppMain {
    private MySqlAnimalDao animalDAO = new MySqlAnimalDao();
    private MySqlDonorDao donorDAO = new MySqlDonorDao();
    private Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        new AppMain().run();
    }

    public void run() {
        while (true) {
            System.out.println("Welcome to our Animal Shelter");
            System.out.println("Menu:");
            System.out.println("1) Display all animals");
            System.out.println("2) Find animal");
            System.out.println("3) Delete animal");
            System.out.println("4) Add animal");
            System.out.println("5) Update animal's health status");
            System.out.println("6) Get list of animals based by a Filter");
            System.out.println("7) Exit");
            System.out.println("\n Enter your input: ");

            int input = keyboard.nextInt();
            keyboard.nextLine();

            switch (input) {
                case 1 -> getAllAnimals();
                case 2 -> getAnimalById();
                case 3 -> deleteAnimal();
                case 4 -> createAnimal();
                case 5 -> updateById();
                case 6 -> filteringSecondName();
                case 7 -> {
                    System.out.println("Finished");
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }

    //Feature 1
    private void getAllAnimals() {
        try {
            List<Animal> animal = animalDAO.getAllAnimals();
            if (animal.isEmpty()) {
                System.out.println("No animals found.");
            } else {
                animal.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving animals: " + e.getMessage());
        }
    }

    //Feature 2
    private void getAnimalById() {
        System.out.println("Enter animal ID: ");
        int id = keyboard.nextInt();
        keyboard.nextLine();

        try {
            Animal animal = animalDAO.getAnimalById(id);
            if (animal != null) {
                System.out.println(animal);
            } else {
                System.out.println("Animal not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error finding animal: " + e.getMessage());
        }
    }

    //feature 3
    private void deleteAnimal() {
        System.out.print("Enter the Animal ID to delete: ");

        int animalId;
        try {
            animalId = keyboard.nextInt();
            keyboard.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid numeric ID.");
            keyboard.nextLine(); // Clear the buffer
            return;
        }

        try {
            animalDAO.deleteAnimal(animalId);
            System.out.println("Animal deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting animal: " + e.getMessage());
        }
    }

    //feature 4
    private void createAnimal() {
        try {
            System.out.print("Enter Animal ID: ");
            int animalId = keyboard.nextInt();
            keyboard.nextLine();

            System.out.print("Enter Type: ");
            String type = keyboard.nextLine();

            System.out.print("Enter Breed: ");
            String breed = keyboard.nextLine();

            System.out.print("Enter Name: ");
            String name = keyboard.nextLine();

            System.out.print("Enter Age: ");
            int age = keyboard.nextInt();

            System.out.print("Enter Weight: ");
            float weight = keyboard.nextFloat();

            System.out.print("Is the animal neutered? (true/false): ");
            boolean neutered = keyboard.nextBoolean();
            keyboard.nextLine();

            System.out.print("Enter Health Status: ");
            String health = keyboard.nextLine();

            System.out.print("Enter Admission Date (YYYY-MM-DD): ");
            LocalDate admitted = LocalDate.parse(keyboard.nextLine());

            System.out.print("Enter Gender (M/F): ");
            String gender = keyboard.nextLine();

            System.out.print("Enter Donor ID: ");
            int donorId = keyboard.nextInt();
            keyboard.nextLine();

            Animal animal = new Animal(animalId, type, breed, name, age, weight, neutered, health, admitted, gender, donorId);
            animalDAO.createAnimal(animal);
            System.out.println("Animal created successfully!");

        } catch (SQLException e) {
            System.err.println("Error creating animal: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input. Please try again.");
            keyboard.nextLine();
        }
    }

    //Feature 5 - Update an existing Entity by ID - changing status of health of an animal
    private void updateById() {
        System.out.println("Enter animal ID: ");
        int id = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Update the animals health status: ");
        String healthStatus = keyboard.nextLine();
        keyboard.nextLine();

        try {
            animalDAO.updateHealth(healthStatus, id);
            System.out.println("Updated the animals health status: " + healthStatus);
        } catch (SQLException e) {
            System.out.println("Error updating health");
        }
    }

    //Feature 6 - Get list of entities matching a filter (based on DTO object) - Filtering Donor second names
    private void filteringSecondName() {
        System.out.println("Enter name you want to filter: ");
        String name = keyboard.nextLine();
        keyboard.nextLine();

        try {
            donorDAO.filteringSecondName(name);
            System.out.println("Filtering out the name " + name);
        } catch (SQLException e) {
            System.out.println("Error filtering name " + e.getMessage());
        }
    }
}


