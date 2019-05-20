//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

public class WindowAccessData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowAccessData.class);
  private String InitRecordNumber="0";
  public String total;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("total"))
      return total;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static boolean hasReadOnlyAccess(ConnectionProvider connectionProvider, String adRoleId, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS TOTAL" +
      "      FROM (" +
      "         SELECT 1 " +
      "           FROM AD_Table_Access t, " +
      "                AD_Tab tb" +
      "          WHERE t.AD_Table_ID = tb.AD_Table_ID" +
      "            AND t.AD_Role_ID = ?" +
      "            AND tb.AD_Tab_ID = ?" +
      "            AND t.IsActive = 'Y'" +
      "            AND t.IsExclude = 'N'" +
      "            AND (t.IsReadOnly = 'Y' OR tb.UIPattern = 'RO')" +
      "        UNION" +
      "        SELECT 1" +
      "          FROM AD_Window_Access w," +
      "               AD_Tab t" +
      "         WHERE w.IsActive='Y'" +
      "           AND w.AD_Window_ID = t.AD_Window_ID" +
      "           AND w.AD_Role_ID = ?" +
      "           AND t.AD_Tab_ID = ?" +
      "           AND w.isReadWrite = 'N'" +
      "           AND w.isActive='Y'" +
      "           AND NOT EXISTS (" +
      "               SELECT 1 FROM AD_Tab_Access ta " +
      "               WHERE ta.IsActive = 'Y' " +
      "               AND ta.AD_Window_Access_ID = w.AD_Window_Access_ID" +
      "               AND ta.AD_Tab_ID = t.AD_Tab_ID" +
      "               and (ta.isReadWrite = 'Y'" +
      "                 OR  EXISTS (" +
      "                     SELECT 1 FROM AD_Field_Access fa " +
      "                     WHERE fa.IsActive = 'Y' " +
      "                     AND fa.AD_Tab_Access_ID = ta.AD_Tab_Access_ID" +
      "                     AND fa.isReadWrite = 'Y')))" +
      "        UNION" +
      "        SELECT 1" +
      "          FROM AD_Window_Access w," +
      "               AD_Tab_Access t" +
      "         WHERE w.IsActive='Y'" +
      "           AND w.AD_Window_Access_ID = t.AD_Window_Access_ID" +
      "           AND w.AD_Role_ID = ?" +
      "           AND t.AD_Tab_ID = ?" +
      "           AND t.isReadWrite = 'N'" +
      "           AND t.isActive='Y'" +
      "           AND NOT EXISTS (" +
      "               SELECT 1 FROM AD_Field_Access fa " +
      "               WHERE fa.IsActive = 'Y' " +
      "               AND fa.AD_Tab_Access_ID = t.AD_Tab_Access_ID" +
      "               and fa.isReadWrite = 'Y')) t";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static boolean hasWriteAccess(ConnectionProvider connectionProvider, String adWindowId, String adRoleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	     select Count(*) AS TOTAL " +
      "	     FROM AD_Window_Access " +
      "	     WHERE AD_Window_ID = ?" +
      "	     AND AD_Role_ID = ? " +
      "	     AND IsActive = 'Y' ";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }
}
