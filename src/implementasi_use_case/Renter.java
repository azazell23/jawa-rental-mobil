package implementasi_use_case;

import java.time.LocalDate;

public class Renter extends User {
    RentList rentList = new RentList();

    public Renter(String name) {
        super(name);
    }

    // fungsi menyewa mobil
    public boolean rentCar(LocalDate rentDate, LocalDate dueDate, Car car, Payment payment)
    {
        if (car.getAvailable())
        {
            payment.pay();
            this.rentList.addRent(new Rent(rentDate, dueDate, car, payment));
            return true;
        }
        return false;
    }

    public boolean returnCar(LocalDate returnDate, Car car, Payment payment)
    {
        for (int i = 0; i < this.rentList.getTotalRents(); i++)
        {
            if (this.rentList.getRents()[i].getCar() == car)
            {
                payment.pay();
                this.rentList.removeRent(this.rentList.getRents()[i]);
                return true;
            }
        }
        return false;
    }

    public RentList getRentList()
    {
        return this.rentList;
    }
}
