package com.oeps.util;



/*
 * INTERFACE with common SQL database commands
 */
public interface CommonUtil {
	
	/** file name of MySQL database connectivity credentials file  */
	public static final String property_File = "config.properties";
	
	/** Constant for Driver key of MySQL database in config.properties */
	public static final String jdbcDriver = "jdbcDriverName";
	
	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "jdbcURL";
	
	/** Constant for username key of MySQL database in config.properties */
	public static final String userName = "username";
	
	/** Constant for password key of MySQL database in config.properties */
	public static final String password = "password";

	
	public static final String COUNT_ROWS_CLIENTS = "COUNT_ROWS_CLIENTS";
	
	public static final String COUNT_ROWS_ADMINS = "COUNT_ROWS_ADMINS";
	
	public static final String SELECT_ADMIN_SQL = "SELECT_ADMIN_SQL";
	
	public static final String SELECT_ADMINS_SQL = "SELECT_ADMINS_SQL";
	
	public static final String SELECT_CLIENTS_SQL = "SELECT_CLIENTS_SQL";
	
	public static final String INSERT_CLIENTS_SQL = "INSERT_CLIENTS_SQL"	;
	
	public static final String DELETE_ADMIN_SQL = "DELETE_ADMIN_SQL";
	
	public static final String DELETE_CLIENT_SQL = "DELETE_CLIENT_SQL";
	
	public static final String SELECT_A_ADMIN_SQL = "SELECT_A_ADMIN_SQL";
	
	public static final String UPDATE_ADMIN_SQL = "UPDATE_ADMIN_SQL";
	
	public static final String SELECT_A_CLIENT_SQL = "SELECT_A_CLIENT_SQL";
	
	public static final String SELECT_ADMIN_TO_CHECK_SQL = "SELECT_ADMIN_TO_CHECK_SQL";
	
	public static final String SELECT_CLIENT_TO_CHECK_SQL = "SELECT_CLIENT_TO_CHECK_SQL";
	
	public static final String INSERT_ADMIN_SQL = "INSERT_ADMIN_SQL";
	
	public static final String CREATE_TABLE_ADMIN = "CREATE_TABLE_ADMIN";
	
	public static final String CREATE_TABLE_CLIENT = "CREATE_TABLE_CLIENT";
	
	public static final String DROP_TABLE_ADMIN = "DROP_TABLE_ADMIN";
	
	public static final String DROP_TABLE_CLIENT = "DROP_TABLE_CLIENT";
	
	public static final String DEFAULT_ADMIN = "DEFAULT_ADMIN";
	
	
	
}
