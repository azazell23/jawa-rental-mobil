package implementasi_use_case;

public class CarList {
    private final int listSize = 100;
    private int totalCars = 0;
	private Car[] Cars = new Car[listSize];

    public void generateCars()
    {
        Cars[0] = new Car("Toyota", "Red", 180, 300000);
        Cars[1] = new Car("Honda", "Blue", 200, 350000);
        Cars[2] = new Car("Suzuki", "Black", 150, 250000);
        Cars[3] = new Car("Daihatsu", "White", 170, 280000);
        Cars[4] = new Car("Mitsubishi", "Silver", 220, 400000);
        Cars[5] = new Car("Nissan", "Green", 190, 320000);
        Cars[6] = new Car("Mazda", "Yellow", 210, 370000);
        Cars[7] = new Car("Ford", "Gray", 230, 450000);
        Cars[8] = new Car("Chevrolet", "Orange", 240, 480000);
        Cars[9] = new Car("Volkswagen", "Purple", 160, 290000);
        Cars[10] = new Car("Hyundai", "Brown", 175, 310000);

        totalCars = 11;
    }
    
    public void displayCars()
    {
        int index = 0;
        while (Cars[index] != null)
        {
            if (Cars[index].getAvailable())
            {
                String brand = Cars[index].getBrand();
                System.out.println("(" + (index + 1) + ") " + brand + " - Price: " + Cars[index].getRentalPrice());
            }
            index++;
        }
    }

    public int getTotalCars()
    {
        return this.totalCars;
    }

    public Car[] getCars()
    {
        return this.Cars;
    }

    public boolean addCar(Car car)
    {
        if (totalCars < listSize)
        {
            this.Cars[totalCars] = car;
            this.totalCars++;
            return true;
        }
        return false;
    }

}