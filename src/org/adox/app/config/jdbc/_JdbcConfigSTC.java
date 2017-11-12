package org.adox.app.config.jdbc;

import java.sql.*;
import oracle.jdbc.OracleTypes;

public class _JdbcConfigSTC {

    private Connection conn;
    private Statement query;

    public _JdbcConfigSTC(Connection poConnection) {
        conn = poConnection;
    }

    public ResultSet doSelect(String strSQL) throws Exception {
        freeResources();
        query = (Statement) conn.createStatement();
        return query.executeQuery(strSQL);
    }

    public ResultSet doStoreOracle(String strSQL, char TipoDato) throws Exception {
        freeResources();
        CallableStatement oCallableStatement = conn.prepareCall(strSQL);
        switch (TipoDato) {
            case '1':
                oCallableStatement.registerOutParameter(1, OracleTypes.CURSOR);
                break;
            case '2':
                oCallableStatement.registerOutParameter(1, OracleTypes.VARCHAR);
                break;
            case '3':
                oCallableStatement.registerOutParameter(1, OracleTypes.INTEGER);
                break;
            case '4':
                oCallableStatement.registerOutParameter(1, OracleTypes.CHAR);
                break;
            case '5':
                oCallableStatement.registerOutParameter(1, OracleTypes.DOUBLE);
                break;
            case '6':
                oCallableStatement.registerOutParameter(1, OracleTypes.BOOLEAN);
                break;
        }
        oCallableStatement.execute();
        return (ResultSet) oCallableStatement.getObject(1);
    }

    public Object doStorePostgres(String strSQL, char TipoDato) throws Exception {
        freeResources();

        CallableStatement oCallableStatement = conn.prepareCall(strSQL);
        System.out.println("oCallableStatement : " + oCallableStatement.toString());
        switch (TipoDato) {
            case 'O':
                oCallableStatement.registerOutParameter(1, Types.OTHER);
                oCallableStatement.execute();
                return (ResultSet) oCallableStatement.getObject(1);

            case 'I':
                oCallableStatement.registerOutParameter(1, Types.INTEGER);
                oCallableStatement.execute();
                System.out.println("Resultado : " + oCallableStatement.getObject(1));
                return oCallableStatement.getObject(1);

            case 'V':
                oCallableStatement.registerOutParameter(1, Types.VARCHAR);
                oCallableStatement.execute();
                System.out.println("Resultado : " + oCallableStatement.getObject(1));
                return oCallableStatement.getObject(1).toString().trim();

            case 'C':
                oCallableStatement.registerOutParameter(1, Types.CHAR);
                oCallableStatement.execute();
                System.out.println("Resultado : " + oCallableStatement.getObject(1));
                return oCallableStatement.getObject(1).toString().trim();

            case 'M':
                return oCallableStatement;
        }
        return null;
    }

    public void doInsert(String strSQL) throws Exception {
        freeResources();
        query = (Statement) conn.createStatement();
        query.executeUpdate(strSQL);
        freeResources();
    }

    public void doUpdate(String strSQL) throws Exception {
        freeResources();
        query = (Statement) conn.createStatement();
        query.executeUpdate(strSQL);
        freeResources();
    }

    public void doDelete(String strSQL) throws Exception {
        freeResources();
        query = (Statement) conn.createStatement();
        query.executeUpdate(strSQL);
        freeResources();
    }

    public void freeResources() throws Exception {
        if (query != null) {
            query.close();
        }
        query = null;
    }
}
