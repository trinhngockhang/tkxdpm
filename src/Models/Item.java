package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Mariadb;

public class Item {
	private int id;
	private String unit;
	private int number;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
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

	
	public Item(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ArrayList getAllItem() {
		Mariadb dbUtil = new Mariadb();
		 
		String sql = "SELECT * FROM items";
		ArrayList arr = new ArrayList();
		arr.add(id);
		
		ResultSet res = dbUtil.query(sql, arr);
		try {
			while(res.next()) {
				String itemName = res.getString("name");
				// get id
				int itemId = res.getInt("id");
				System.out.println("item: " + id + " name: " + itemName);
				// new LRI
				Item item = new Item (itemId, itemName);
				arr.add(item);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return arr;
	}
}
