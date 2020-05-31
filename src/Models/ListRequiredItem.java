package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Mariadb;

public class ListRequiredItem {

	private ArrayList itemArr = new ArrayList();
	private String name;
	private int id;
	
	public ListRequiredItem(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ArrayList getItemArr(int id) {
			Mariadb dbUtil = new Mariadb();
		    
			String sql = "SELECT requiredItem.*, items.name FROM requiredItem, items WHERE listId = ? AND items.id = requiredItem.itemId";
			ArrayList arr = new ArrayList();
			arr.add(id);
			
			ResultSet res = dbUtil.query(sql, arr);
			try {
				while(res.next()) {
					// get unit
					String unit = res.getString("unit");
					// get name
					String itemName = res.getString("name");
					// get number
					int number = res.getInt("number");
					// get date
					int day = res.getInt("day");
					// get month
					int month = res.getInt("month");
					// get year
					int year = res.getInt("year");
					// get id
					int itemId = res.getInt("itemId");
					System.out.println("item: " + id + " number: " + number);
					// new LRI
					RequiredItem requiredItem = new RequiredItem(itemId, unit, itemName, day, month, year);
					itemArr.add(requiredItem);
				}	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return itemArr;
	}
	public void setItemArr(ArrayList itemArr) {
		this.itemArr = itemArr;
	}
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
}
