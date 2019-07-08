
	package DAO;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import model.ITronConector;

	/**
	 * <h1>The Class LoranBDDConnector.</h1>
	 *
	 * 
	 * @version 1.0
	 */
	final class TronConnector implements ITronConector{

	 /** The instance. */
	 private static TronConnector instance;

	 /** The login. */
	 private static String user = "root";

	 /** The password. */
	 private static String password = "";

	 /** The url. */
	 private static String url = "jdbc:mysql://localhost/games?useSSL=false&serverTimezone=UTC";

	 /** The connection. */
	 private Connection connection;

	 /** The statement. */
	 private Statement statement;

	 /**
	 * Instantiates a new  BDD connector.
	 */
	 private TronConnector() {
	 this.open();
	 
	 }

	 /**
	 * Gets the single instance of TronConnector.
	 *
	 * @return single instance of TronConnector
	 */
	 public static TronConnector getInstance() {
	 if (instance == null) {
	 setInstance(new TronConnector());
	 
	 }
	 return instance;
	 
	 }

	 /**
	 * Sets the instance.
	 *
	 * @param instance
	 * the new instance
	 */
	 private static void setInstance(final TronConnector instance) {
	 TronConnector.instance = instance;
	 
	 }

	 /**
	 * Open.
	 *
	 * @return true, if successful
	 */
	 private boolean open() {
		 try {
			 this.connection = DriverManager.getConnection(TronConnector.url, TronConnector.user,
			 TronConnector.password);
			 this.statement = this.connection.createStatement();
			 return true;
		 
		 } catch (final SQLException exception) {
		 exception.printStackTrace();
		 
		 }
		 return false;
		 
	 }

	 /**
	 * Execute query.
	 *
	 * @param query
	 * the query
	 * @return the result set
	 */
	 public ResultSet executeQuery(final String query) {
	 try {
		 return this.getStatement().executeQuery(query);
	 
	 } catch (final SQLException e) {
	 e.printStackTrace();
	 
	 }
	 return null;
	 
	 }

	 /**
	 * Prepare call.
	 *
	 * @param query
	 * the query
	 * @return the java.sql. callable statement
	 */
	 public java.sql.CallableStatement prepareCall(final String query) {
	 try {
	 return this.getConnection().prepareCall(query);
	 
	 } catch (final SQLException e) {
	 e.printStackTrace();
	 
	 }
	 return null;
	 
	 }

	 /**
	 * Execute update.
	 *
	 * @param query
	 * the query
	 * @return the int
	 */
	 public int executeUpdate(final String query) {
	 try {
		 return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
	 
	 } catch (final SQLException e) {
	 e.printStackTrace();
	 
	 }
	 return 0;
	 
	 }

	 /**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	 private Connection getConnection() {
		 return this.connection;
	 
	 }

	 /**
	 * Sets the connection.
	 *
	 * @param connection
	 * the new connection
	 */
	 public void setConnection(final Connection connection) {
		 this.connection = connection;
	 
	 }

	 /**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	 private Statement getStatement() {
		 return this.statement;
	 
	 }

	 /**
	 * Sets the statement.
	 *
	 * @param statement
	 * the new statement
	 */
	 public void setStatement(final Statement statement) {
		 this.statement = statement;
	 
	 }

	}

