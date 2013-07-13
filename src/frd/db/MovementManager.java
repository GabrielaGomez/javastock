package frd.db;

import java.sql.SQLException;
import java.util.Date;


public class MovementManager extends JDBCManager {
	public static void createDbMovementTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBMOVEMENT("
				+ "LOT_ID NUMERIC(5) NOT NULL , "
				+ "MOVEMENT_ID NUMERIC(5) NOT NULL, "
				+ "MOVEMENTDATE DATE NOT NULL, "
				+ "USER VARCHAR(20) NOT NULL "
				+ "CANT NUMERIC(5) NOT NULL, "
				+ ")";

		execute( createTableSQL );
	}
	
	public static void insertMovementProduct(int lot_id, int movement_id, Date movementdate, String user, int cant, Date creation) throws SQLException{
		String insertTableSQL = "INSERT INTO DBPRODUCT"
			+ "(LOT_ID, MOVEMENT_ID, MOVEMENTDATE, USER, CANT) " + "VALUES"
			+ "('"+lot_id+"','"+movement_id+"','"+movementdate+"','"+user+"', '"+cant+"' " + "to_date('"
			+ dateFormat.format(creation.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'))";
		
		executeUpdate( insertTableSQL );
	}
}
