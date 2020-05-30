package RequiredItem;

import java.util.ArrayList;

import Models.ListRequiredItem;

public class RequiredItemController {

	 public ArrayList getAllListItem(int id) {
		  ListRequiredItem LRI = new ListRequiredItem(id, "");
		  return LRI.getItemArr(id);
	  }
}
