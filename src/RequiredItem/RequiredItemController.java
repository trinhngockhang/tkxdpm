package RequiredItem;

import java.util.ArrayList;

import Models.Item;
import Models.ListRequiredItem;

public class RequiredItemController {
	 ListRequiredItem LRI;
	 
	 public RequiredItemController() {
		
	 }
	 public ArrayList getAllListItem(int id) {
		 LRI = new ListRequiredItem(id, "");
		 return LRI.getItemArr(id);
	  }
	 public ArrayList getAllItem() {
		  Item item = new Item(1, null);
		  return item.getAllItem();
	  }
	 public boolean saveListItem(String listName, ArrayList listItemArr) {
		 try {
			 // save list required Item
			 LRI = new ListRequiredItem(1, "");
			 int listId = LRI.createListItem(listName);
			 System.out.println("id: " + listId);
			 
			 // save required item
			 LRI.saveRequiredItem(listId, listItemArr);	
			 return true;
		 } catch(Exception e) {
			 return false;
		 }
	 }
}
