package MainApp;

import java.util.List;
import java.util.Scanner;

public class AppMain {
   //private MySqlAanimaDao animalDAO = new MySQLExpenseDao();
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
            System.out.println("5) Update animal's info");
            System.out.println("6) Get list of animals based by a Filter");
            System.out.println("\n Enter your input: ");

            int input = keyboard.nextInt();
            keyboard.nextLine();
           

    }
}
}
