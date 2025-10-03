package implementasi_use_case;

import java.time.LocalDate;

    
public abstract class Payment {

    abstract boolean pay();
    abstract void calculateFee();
}