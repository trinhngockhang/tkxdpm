package RequiredItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Mariadb;
import Models.ListOfListRequiredItem;

public class ListOfListRequiredItemController {
  public ArrayList getAllListOfList() {
	  ListOfListRequiredItem LLRI = new ListOfListRequiredItem();
	  return LLRI.getListItemArr();
  }
}
