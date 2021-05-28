import java.util.ArrayList;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

public class Validation {

	DBConnection dbCon = new DBConnection();

	public void validatingUsers() throws Exception {

		dbCon.getDBDetails("");

		List<List<String>> dbStore_GET_Person = new ArrayList<>();

		String[] columnName_Person = { "UserCode", "Salutation", "FirstName", "LastName", "EmailId", "OtherEmailId" };

		dbStore_GET_Person = dbCon.dbConnection("", columnName_Person);

		String userCode = "";
		String salutation = "";
		String firstName = "";
		String lastName = "";
		String emailID = "";
		String otherEmailID = "";
		// String roleName = "";
		// String roleType = "";

		List<String> personCode = ReadData.readdatafromExcelusingcolumnName("PersonCode");

		for (String counter : personCode) {
			System.out.println(counter);
			int dbRowCount = 0;

			while (dbRowCount < dbStore_GET_Person.size()) {

				if ((dbStore_GET_Person.get(dbRowCount).get(0) != null)
						&& dbStore_GET_Person.get(dbRowCount).get(0).contains(counter)) {

					userCode = dbStore_GET_Person.get(dbRowCount).get(0);
					salutation = dbStore_GET_Person.get(dbRowCount).get(1);
					firstName = dbStore_GET_Person.get(dbRowCount).get(2);
					lastName = dbStore_GET_Person.get(dbRowCount).get(3);
					emailID = dbStore_GET_Person.get(dbRowCount).get(4);
					otherEmailID = dbStore_GET_Person.get(dbRowCount).get(5);
					// roleName = dbStore_GET_Person.get(dbRowCount).get(6);
					// roleType = dbStore_GET_Person.get(dbRowCount).get(7);

				
				
				}
				dbRowCount++;
				// System.out.println(dbStore_GET_Person.get(dbRowCount).get(0).toString());

			}
			System.out.println(personCode + ":: " + lastName + ":: " + firstName);

		}

	}

	public void validateElement() {

	}
}
