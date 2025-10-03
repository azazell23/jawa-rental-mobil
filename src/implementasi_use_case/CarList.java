package implementasi_use_case;

abstract class CarList {
	public int listSize;
    public int totalCars = 0;
    public Car[] Cars;

    public CarList(int listSize, int totalCars)
    {
        this.listSize = listSize;
        this.totalCars = totalCars;
    }

    abstract void displayCars();

}