package implementasi_use_case;

import java.time.LocalDate;

public class NormalPayment extends Payment{
    private double amount;

    @Override
    public boolean pay()
    {
        return true;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }


    public double getAmount() {
        return this.amount;
    }

    @Override
    public void calculateFee()
    {
        
    }
}
