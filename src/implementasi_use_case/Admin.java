package implementasi_use_case;

public class Admin extends User{
    private String adminPassword = "admin123";

    public boolean login(String password)
    {
        if (this.adminPassword == password)
        {
            return true;
        }
        return false;
    }

    public Admin() 
    {
        super("Admin");
    }

}