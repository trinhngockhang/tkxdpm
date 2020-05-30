package Models;

public class RequiredItem {
	private int id;
	private String unit;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int number;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private int day;
	private int month;
	private int year;
	
	public RequiredItem(int id, String unit, String name, int day, int month, int year) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
}
