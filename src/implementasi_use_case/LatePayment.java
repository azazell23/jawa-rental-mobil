package implementasi_use_case;

import java.time.LocalDate;

public class LatePayment extends Payment {
    private double lateFee;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public LatePayment(LocalDate dueDate, LocalDate returnDate)
    {
        this.lateFee = 0;
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
    }

    public double getLateFee()
    {
        return this.lateFee;
    }


}
