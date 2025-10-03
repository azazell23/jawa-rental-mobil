package implementasi_use_case;

import java.time.LocalDate;

public class RentList {
    private Rent[] rents = new Rent[3];
    private int totalRents = 0;

    public void addRent(Rent rent)
    {
        if (totalRents < rents.length)
        {
            this.rents[totalRents] = rent;
            this.totalRents++;
        }
    }

    public void removeRent(Rent rent)
    {
        int index = 0;
        for (int i = 0; i < totalRents; i++)
        {
            if (this.rents[i] == rent)
            {
                index = i;
                break;
            }
        }

        if (index >= 0 && index < this.totalRents)
        {
            for (int i = index; i < this.totalRents - 1; i++)
            {
                this.rents[i] = this.rents[i + 1];
            }
            this.rents[totalRents - 1] = null;
            this.totalRents--;
        }
    }

    public void displayRents()
    {
        for (int i = 0; i < totalRents; i++)
        {
            String brand = rents[i].getCar().getBrand();
            LocalDate rentDate = rents[i].getRentDate();
            LocalDate dueDate = rents[i].getDueDate();
            System.out.println("(" + (i+1) + ") " + brand + " | Rent Date: " + rentDate + " | Due Date: " + dueDate);
        }
    }

    public Rent[] getRents() {
        return this.rents;
    }

    public int getTotalRents() {
        return this.totalRents;
    }
}
