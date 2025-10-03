package implementasi_use_case;

import java.time.LocalDate;

public class NormalPayment extends Payment{
    private double amount;

    @Override
    public boolean pay()
    {
        return true;
    }

    @Override
    public void calculateFee()
    {
        
    }
}
