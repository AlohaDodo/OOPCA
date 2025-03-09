package MainApp;

import DAOs.AnimalDao;
import DTOs.Animal;
import DAOs.MySqlAnimalDao;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.sql.SQLException;

public class AppMain {
    private MySqlAnimalDao animalDAO = new MySqlAnimalDao();
    private Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        new AppMain().run();
    }

    public void run() {
        while(true){
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

             switch(input){
                 case 1 -> getAllAnimals();
                 case 2 -> getAnimalById();
            //     case 3 -> deleteAnimal();
            //     case 4 -> addAnimal();
                 case 5 -> updateById();
            //     case 6 -> findAnimalByFilter();
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
}
