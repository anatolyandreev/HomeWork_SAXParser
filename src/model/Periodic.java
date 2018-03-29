package model;

public class Periodic {
	
	private String isTakable;
	private int availableNumber;
	private String isTaken;
	private PeriodicType periodicType;
	
	public Periodic() {
	}

	public Periodic(String isTakable, int availableNumber, String isTaken) {
		this.isTakable = isTakable;
		this.availableNumber = availableNumber;
		this.isTaken = isTaken;
	}

	public String getIsTakable() {
		return isTakable;
	}

	public void setIsTakable(String i) {
		this.isTakable = i;
	}

	public int getAvailableNumber() {
		return availableNumber;
	}

	public void setAvailableNumber(int availableNumber) {
		this.availableNumber = availableNumber;
	}

	public String getIsTaken() {
		return isTaken;
	}

	public void setIsTaken(String isTaken) {
		this.isTaken = isTaken;
	}

	public PeriodicType getPeriodicType() {
		if (this instanceof Magazine) {
			periodicType = PeriodicType.MAGAZINE;
		} else if (this instanceof Book) {
			periodicType = PeriodicType.BOOK;
		} else if (this instanceof Paper) {
			periodicType = PeriodicType.PAPER;
		}
		return periodicType;
	}

	public void setPeriodicType(PeriodicType periodicType) {
		this.periodicType = periodicType;
	}
	
	
	

}
