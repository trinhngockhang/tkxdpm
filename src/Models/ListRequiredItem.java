package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import Database.Mariadb;
import RequiredItem.AddItemGUI;

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
	
	public int createListItem(String name) {
		int id = 0;
		Mariadb dbUtil = new Mariadb();
		// sql insert list name
		String insertSql = "INSERT INTO listRequiredItem(name) VALUES(?)";
		ArrayList insertArr = new ArrayList();
		insertArr.add(name);
		// sql get last id
		String getIdSql = "SELECT id FROM listRequiredItem ORDER BY id DESC LIMIT 1";
		ArrayList getIdArr = new ArrayList();
		
		// excute SQL
		ResultSet insertRes = dbUtil.query(insertSql, insertArr);
		ResultSet getIdRes = dbUtil.query(getIdSql, getIdArr);
		try {
			getIdRes.next();
			id = getIdRes.getInt("id");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	public void saveRequiredItem(int listId, ArrayList itemArr) {
		Mariadb dbUtil = new Mariadb();
		
		String sql = "INSERT INTO requiredItem(itemId, listId, unit, number, day, month, year) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = Mariadb.conn.prepareStatement(sql);
			for (int counter = 0; counter < itemArr.size(); counter++) { 	
				AddItemGUI addItemGUI = (AddItemGUI)  itemArr.get(counter);
				// id
				int id = addItemGUI.getId();
				// unit
				String unit = addItemGUI.getUnit();
				// number
				int number = addItemGUI.getNumber();
				// day
				int day = addItemGUI.getDay();
				// month
				int month = addItemGUI.getMonth();
				// year
				int year = addItemGUI.getYear();
				// name list
				System.out.println("Id: " + id + " unit: " + unit + " number " + number + " day " + day + " month " + month + " year " + year );
				
				// add to sql
				preparedStatement.setInt(1, id);
				preparedStatement.setInt(2, listId);
				preparedStatement.setString(3, unit);
				preparedStatement.setInt(4, number);
				preparedStatement.setInt(5, day);
				preparedStatement.setInt(6, month);
				preparedStatement.setInt(7, year);
				// add item
				preparedStatement.addBatch();
		    } 
			// excute
			int[] updateCounts = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
