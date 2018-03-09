import java.time.format.DateTimeParseException;
import java.sql.SQLException;

public class RethrowingExceptions {
	public void parseData() throws SQLException, DateTimeParseException {}
	
	public void rethrowing() throws SQLException, DateTimeParseException {
		try {
			parseData();
		} catch (Exception e) {
			System.err.println(e);
			throw e;
		} 
	}
}
