package org.db.connector;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/**
 *
 * @author Benjamin E Ndugga
 */
public class OracleDBConnector {

    private static final String DB_USER = "";
    private static final String DB_PASS = "";
    private static final String DB_URL = "";
    private static PoolDataSource poolDataSource;

    static {
        try {
            System.out.println("Creating Connection Pool");

            //Creating a pool-enabled data source
            poolDataSource = PoolDataSourceFactory.getPoolDataSource();
            poolDataSource.setConnectionPoolName("DB_POOL");
            poolDataSource.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
            poolDataSource.setURL(DB_URL);
            poolDataSource.setUser(DB_USER);
            poolDataSource.setPassword(DB_PASS);

            //Setting pool properties
            poolDataSource.setInitialPoolSize(5);
            poolDataSource.setMinPoolSize(10);
            poolDataSource.setMaxPoolSize(20);

            poolDataSource.setMaxConnectionReuseCount(100);

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        }
    }

    public static Connection connect() throws SQLException {

        Connection connection;
        System.out.println("available connections: " + poolDataSource.getAvailableConnectionsCount() + " Connections | " + poolDataSource.getConnectionPoolName() + " | " + Thread.currentThread().getName());
        System.out.println("borrowed connections: " + poolDataSource.getBorrowedConnectionsCount() + " Connections | " + poolDataSource.getConnectionPoolName() + " | " + Thread.currentThread().getName());
        connection = poolDataSource.getConnection();
        return connection;
    }
}
