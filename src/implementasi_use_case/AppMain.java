package implementasi_use_case;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarList cars = new CarList();
        cars.generateCars();
        Renter renter = new Renter("Guest");
        do {
            System.out.println("========= Car Rental Application ==========");
            System.out.println("\nWelcome to the menu, what would you like to do:");
            System.out.println("(1) Rent a Car");
            System.out.println("(2) Return a Car");
            System.out.println("(0) Exit");
            System.out.println("Input User Option: ");
            int userOption = scanner.nextInt();
            System.out.println("\n===========================================");
            
            if (userOption == 1)
            {
                System.out.println("Hello, " + renter.getName() + "!\nHere are the available cars:");
                cars.displayCars();
                System.out.println("\nSelect the number of the car you want to rent:");
                int carOption = scanner.nextInt();

                if (carOption > 0 && carOption <= cars.getTotalCars())
                {
                    Car selectedCar = cars.getCars()[carOption - 1];
                    System.out.println("You have selected the following car:");
                    ArrayList<String> carDetails = selectedCar.getDetails();
                    System.out.println("Brand: " + carDetails.get(0));
                    System.out.println("Color: " + carDetails.get(1));
                    System.out.println("Speed: " + carDetails.get(2) + " km/h");
                    System.out.println("Rental Price: " + carDetails.get(3) + " per day");
                    
                    System.out.print("How many days do you want to rent the car: ");
                    LocalDate rentDate = LocalDate.now();
                    int rentalDays = scanner.nextInt();
                    LocalDate dueDate = rentDate.plusDays(rentalDays);
                    NormalPayment payment = new NormalPayment();
                    System.out.println("Total amount you have to pay: " + (selectedCar.getRentalPrice() * rentalDays));
                    System.out.println("Would you like to proceed? (yes/no): ");
                    String renterConfirmation = scanner.next();
                    if (renterConfirmation.equalsIgnoreCase("yes"))
                    {
                        if (renter.rentCar(rentDate, dueDate, selectedCar, payment))
                        {
                            System.out.println("You have successfully rented the car. Thank you for the purchase!");
                        }
                        else
                        {
                            System.out.println("Failed to rent the car. Please try again.");
                        }
                    }
                    else
                    {
                        System.out.println("Rental cancelled.");
                    }
                }
            }

            else if (userOption == 2)
            {
                System.out.println("Rented Car: ");
                renter.getRentList().displayRents();

                System.out.println("Select the number of the car you want to return:");
                int returnCarOption = scanner.nextInt();

                if (returnCarOption > 0 && returnCarOption <= renter.getRentList().getTotalRents())
                {
                    Rent currentRent = renter.getRentList().getRents()[returnCarOption - 1];
                    System.out.print("Do you want to Return Car? (yes/no): ");
                    String rentedConfirmation = scanner.next();

                    if (rentedConfirmation.equalsIgnoreCase("yes"))
                    {
                        System.out.print("Enter return date with format (YYYY-MM-DD): ");
                        String returnDateInput = scanner.next();
                        LocalDate returnDate = LocalDate.parse(returnDateInput);
             
                        LatePayment payment = new LatePayment(currentRent.getCar().getRentalPrice(), currentRent.getDueDate(), returnDate);
                        payment.calculateFee();
                        System.out.println("Total fee have to pay: " + payment.getTotalAmount());

                        if(renter.returnCar(returnDate, currentRent.getCar(), payment))
                        {
                            System.out.println("You have successfully returned the car. Thank you!");
                        }
                        else
                        {
                            System.out.println("Failed to return the car. Please try again.");
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid car selection.");
                }
            }

            else if (userOption == 0)
            {
                System.out.println("Thank you for using the Car Rental Application. Goodbye!");
                break;
            }

            else
            {
                System.err.println("Invalid input, please try again.");
            }
        } while (true);
        scanner.close();
    }
}
