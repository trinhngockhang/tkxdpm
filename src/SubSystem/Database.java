package SubSystem;

import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class Database {
	abstract ResultSet query();
	abstract ArrayList excute();
}
