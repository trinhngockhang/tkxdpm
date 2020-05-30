package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Mariadb;

public class ListOfListRequiredItem {
	private ArrayList listArr = new ArrayList();

	public ArrayList getListItemArr() {
		// khooi tao sql
	    Mariadb dbUtil = new Mariadb();
	    
		String sql = "SELECT * FROM listRequiredItem";
		ArrayList arr = new ArrayList();
		
		ResultSet res = dbUtil.query(sql, arr);
		try {
			while(res.next()) {
				// get name
				String name = res.getString("name");
				// get id
				int id = res.getInt("id");
				System.out.println("item: " + id + " name: " + name);
				// new LRI
				ListRequiredItem LRI = new ListRequiredItem(id, name);
				listArr.add(LRI);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listArr;
	}

	public void setListItemArr(ArrayList listItemArr) {
		this.listArr = listItemArr;
	}
}
