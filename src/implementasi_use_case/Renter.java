package implementasi_use_case;

public class Renter extends User {
    RentedCarList rentedCars = new RentedCarList();

    public Renter(String name) {
        super(name);
    }

    // fungsi menyewa mobil
    public boolean rentCar(Car car)
    {
        car.setAvailable(false);
        if(rentedCars.addCar(car))
        {
            return true;
        }
        return false;   
    }
    
    // fungsi mengembalikan mobil yang disewa
    public boolean returnCar(Car car) {
    int foundIndex = -1;
    for (int i = 0; i < rentedCars.getTotalCars(); i++) {
        if (rentedCars.getCars()[i] == car) {
            foundIndex = i;
            break;
        }
    }
    if (foundIndex != -1) {
        for (int i = foundIndex; i < rentedCars.getTotalCars() - 1; i++) {
            rentedCars.getCars()[i] = rentedCars.getCars()[i + 1];
        }
        rentedCars.getCars()[rentedCars.getTotalCars() - 1] = null;
        rentedCars.totalCars--;

        car.setAvailable(true);
        return true;
    }

    return false;
}


    public RentedCarList getRentedCars()
    {
        return rentedCars;
    }
}
