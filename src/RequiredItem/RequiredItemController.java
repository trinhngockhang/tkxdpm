package RequiredItem;

import java.util.ArrayList;

import Models.Item;
import Models.ListRequiredItem;

public class RequiredItemController {

	 public ArrayList getAllListItem(int id) {
		  ListRequiredItem LRI = new ListRequiredItem(id, "");
		  return LRI.getItemArr(id);
	  }
	 public ArrayList getAllItem() {
		  Item item = new Item((Integer) null, null);
		  return item.getAllItem();
	  }
}
