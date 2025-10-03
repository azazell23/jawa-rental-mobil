package implementasi_use_case;

import java.time.LocalDate;

public class LatePayment extends Payment {
    private double baseAmount;
    private double lateFee;
    private double totalAmount;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public LatePayment(double baseAmount, LocalDate dueDate, LocalDate returnDate)
    {
        this.baseAmount = baseAmount;
        this.lateFee = 0;
        this.totalAmount = baseAmount;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    @Override
    public boolean pay()
    {
        return true;
    }

    @Override
    public void calculateFee()
    {
        long daysLate = 0;

        if (returnDate.isAfter(dueDate)) {
            daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
        }

        this.lateFee = daysLate * 50000;
        this.totalAmount = this.baseAmount + this.lateFee;
    }

    public double getTotalAmount()
    {
        return this.totalAmount;
    }


}
