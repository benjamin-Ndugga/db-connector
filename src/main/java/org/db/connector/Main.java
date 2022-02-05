package org.db.connector;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Benjamin E Ndugga
 */
public class Main {

    public static void main(String[] args) {
        /**
         *
         * </You can add a couple line to switch to various DBs/>
         *
         * </I advise that you use the Apache library for connection pooling for
         * the other types of databases./>
         */
        Connection conn = null;
        try {
            conn = OracleDBConnector.connect();

        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}