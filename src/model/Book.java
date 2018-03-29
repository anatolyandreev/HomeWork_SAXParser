package model;

public class Book extends Periodic{
	
	private int maxExpireDays;

	public Book() {
	}

	public Book(String isTakable, int availableNumber, String isTaken, int maxExpireDays) {
		super(isTakable, availableNumber, isTaken);
		this.maxExpireDays = maxExpireDays;
	}

	public int getMaxExpireDays() {
		return maxExpireDays;
	}

	public void setMaxExpireDays(int maxExpireDays) {
		this.maxExpireDays = maxExpireDays;
	}
	
	

}
