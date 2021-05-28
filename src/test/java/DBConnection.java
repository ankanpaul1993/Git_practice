import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBConnection extends ReadData{

	private Statement statement;
	private Connection conn;
	private ResultSet resultSet;
	private String dbName = null;
	private String userName = null;
	private String password = null;
	private String server = null;
	private String dbURL = null;
	private String endPointURL = null;
	
	

	public void getDBDetails(String env) throws Exception {

		if (env.equalsIgnoreCase("INSPRINT")) {
			server = getAppProperties("DB_SERVERNAME_INSPRINT");
			dbName = getAppProperties("DB_NAME_INSPRINT");
			userName = getAppProperties("DB_USERNAME_INSPRINT");
			password = getAppProperties("DB_PASSWORD_INSPRINT");

		} else if (env.equalsIgnoreCase("QA")) {
			server = getAppProperties("DB_SERVERNAME_QA");
			dbName = getAppProperties("DB_NAME_QA");
			userName = getAppProperties("DB_USERNAME_QA");
			password = getAppProperties("DB_PASSWORD_QA");
		}

		else if (env.equalsIgnoreCase("SIT")) {
			server = getAppProperties("DB_SERVERNAME_SIT");
			dbName = getAppProperties("DB_NAME_SIT");
			userName = getAppProperties("DB_USERNAME_SIT");
			password = getAppProperties("DB_PASSWORD_SIT");
		}

		else if (env.equalsIgnoreCase("DEV")) {
			server = getAppProperties("DB_SERVERNAME_DEV");
			dbName = getAppProperties("DB_NAME_DEV");
			userName = getAppProperties("DB_USERNAME_DEV");
			password = getAppProperties("DB_PASSWORD_DEV");
		}

		else if (env.equalsIgnoreCase("EI")) {
			server = getAppProperties("DB_SERVERNAME_EI");
			dbName = getAppProperties("DB_NAME_EI");
			userName = getAppProperties("DB_USERNAME_EI");
			password = getAppProperties("DB_PASSWORD_EI");
		}

		dbURL = "jdbc:sqlserver://" + server + ":1433;DatabaseName=" + dbName
				+ ";encrypt=true;trustServerCertificate=true";
		try {
			// Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Properties properties = new Properties();
			properties.put("user", userName);
			properties.put("password", password);
			conn = DriverManager.getConnection(dbURL, properties);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void dbConnection(String query) throws SQLException {
		try {

			statement = conn.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getSetupConfigDetails(String env, String track) throws Exception {

		if (env.equalsIgnoreCase("INSPRINT")) {
			if (track.equalsIgnoreCase("SC"))
				endPointURL = getAppProperties("SETUP_CONFIG_ENDPOINT_URL_INSPRINT");
			if (track.equalsIgnoreCase("PS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_ENDPOINT_URL_INSPRINT");
			if (track.equalsIgnoreCase("SM"))
				endPointURL = getAppProperties("STUDENT_MANAGEMENT_ENDPOINT_URL_INSPRINT");

		} else if (env.equalsIgnoreCase("QA")) {

			if (track.equalsIgnoreCase("SC"))
				endPointURL = getAppProperties("SETUP_CONFIG_ENDPOINT_URL_QA");
			if (track.equalsIgnoreCase("PS.CMS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_CMS_ENDPOINT_URL_QA");
			if (track.equalsIgnoreCase("PS.SCHD"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_SCHEDULER_ENDPOINT_URL_QA");
			if (track.equalsIgnoreCase("PS.CAL"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_CALENDAR_ENDPOINT_URL_QA");
			if (track.equalsIgnoreCase("SM"))
				endPointURL = getAppProperties("STUDENT_MANAGEMENT_ENDPOINT_URL_QA");

		} else if (env.equalsIgnoreCase("SIT")) {

			if (track.equalsIgnoreCase("SC"))
				endPointURL = getAppProperties("SETUP_CONFIG_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("PS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("PS.CMS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_CMS_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("PS.SCHD"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_SCHEDULER_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("PS.CAL"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_CALENDAR_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("PS.GS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_GLOBAL_SEARCH_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("PS.UM"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_UM_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("PS.CASEMGMT"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_CASE_MANAGEMENT_ENDPOINT_URL_SIT");
			if (track.equalsIgnoreCase("SM"))
				endPointURL = getAppProperties("STUDENT_MANAGEMENT_ENDPOINT_URL_SIT");

		} else if (env.equalsIgnoreCase("DEV")) {

			if (track.equalsIgnoreCase("SC"))
				endPointURL = getAppProperties("SETUP_CONFIG_ENDPOINT_URL_DEV");
			if (track.equalsIgnoreCase("PS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_ENDPOINT_URL_DEV");
			if (track.equalsIgnoreCase("SM"))
				endPointURL = getAppProperties("STUDENT_MANAGEMENT_ENDPOINT_URL_DEV");
			if (track.equalsIgnoreCase("PS.SCHD"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_SCHEDULER_ENDPOINT_URL_DEV");
			if (track.equalsIgnoreCase("PS.GS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_GLOBAL_SEARCH_ENDPOINT_URL_DEV");
			if (track.equalsIgnoreCase("PS.CMS"))
				endPointURL = getAppProperties("PLATFORM_SERVICES_CMS_ENDPOINT_URL_DEV");

		}

		return endPointURL;
	}

	public List<List<String>> dbConnection(String query, String[] columnNameArr) throws Exception {
		List<List<String>> dbModel = new ArrayList<>();
		statement = conn.createStatement();
		resultSet = statement.executeQuery(query);

		if (resultSet != null) {
			while (resultSet.next()) {
				List<String> dbStore = new ArrayList<>();
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

				for (String columnName : columnNameArr) {
					for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
						if (resultSetMetaData.getColumnName(i).equalsIgnoreCase(columnName)) {
							dbStore.add(resultSet.getString(i));
							break;
						}

					}
				}

				dbModel.add(dbStore);
			}
		}

		try {
			if (resultSet != null)
				resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (statement != null)
				statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbModel;
	}

}
