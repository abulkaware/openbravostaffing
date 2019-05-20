//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.obps;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

class ActivationKeyData implements FieldProvider {
static Logger log4j = Logger.getLogger(ActivationKeyData.class);
  private String InitRecordNumber="0";
  public String dummy;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dummy"))
      return dummy;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ActivationKeyData dummy(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' as dummy from dual";

    ResultSet result;
    ActivationKeyData objectActivationKeyData = new ActivationKeyData();
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        objectActivationKeyData.dummy = UtilSql.getValue(result, "dummy");
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(objectActivationKeyData);
  }

  public static int deactivateSessions(Connection conn, ConnectionProvider connectionProvider, String sessions)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE AD_SESSION" +
      "         SET SESSION_ACTIVE = 'N', UPDATED = NOW()" +
      "       WHERE AD_SESSION_ID IN (";
    strSql = strSql + ((sessions==null || sessions.equals(""))?"":sessions);
    strSql = strSql + 
      ")";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (sessions != null && !(sessions.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
