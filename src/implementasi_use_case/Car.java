package implementasi_use_case;

import java.util.ArrayList;

public class Car {
	private String brand;
	private String color;
	private int speed;
	private double rentalPrice;
	private boolean available = true;


	public Car(String brand, String color, int speed, double rentalPrice) {
		this.brand = brand;
		this.color = color;
		this.speed = speed;
		this.rentalPrice = rentalPrice;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getRentalPrice() {
		return this.rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public boolean isAvailable() {
		return this.available;
	}

	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public ArrayList<String> getDetails()
	{
		ArrayList<String> details = new ArrayList<String>();
		details.add(brand);
		details.add(color);
		details.add(Integer.toString(speed));
		details.add(Double.toString(rentalPrice));
		
		return details;
	}
}