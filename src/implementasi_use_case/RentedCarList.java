package implementasi_use_case;

public class RentedCarList extends CarList {
    private Car[] Cars = new Car[listSize];
    public RentedCarList()
    {
        super(3, 0);
    }

    @Override
    public void displayCars()
    {
        int index = 0;
        while (Cars[index] != null)
        {
            String brand = Cars[index].getBrand();
            System.out.println("(" + (index + 1) + ") " + brand);
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
