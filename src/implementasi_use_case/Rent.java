package implementasi_use_case;

import java.time.LocalDate;

public class Rent {
    private LocalDate rentDate;
    private LocalDate dueDate;

    private static int rentID = 1;
    private Car car = null;
    private Payment payment = null;


    public Rent(LocalDate rentDate, LocalDate dueDate, Car car, Payment payment) {
        this.rentDate = rentDate;
        this.dueDate = dueDate;
        this.car = car;
        this.payment = payment;
        payRent(car.getRentalPrice() * (dueDate.getDayOfYear() - rentDate.getDayOfYear()));
        car.setAvailable(false);
    }

    public boolean payRent(double amount)
    {
        return payment.pay();
    }


    public LocalDate getRentDate() {
        return this.rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}