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
import java.util.*;

class WindowTreeChecksData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowTreeChecksData.class);
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

  public static WindowTreeChecksData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static WindowTreeChecksData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT * FROM DUAL";

    ResultSet result;
    Vector<WindowTreeChecksData> vector = new Vector<WindowTreeChecksData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        WindowTreeChecksData objectWindowTreeChecksData = new WindowTreeChecksData();
        objectWindowTreeChecksData.dummy = UtilSql.getValue(result, "dummy");
        objectWindowTreeChecksData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeChecksData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
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
    WindowTreeChecksData objectWindowTreeChecksData[] = new WindowTreeChecksData[vector.size()];
    vector.copyInto(objectWindowTreeChecksData);
    return(objectWindowTreeChecksData);
  }

  public static String selectIsSummary(ConnectionProvider connectionProvider, String table, String column, String columnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ISSUMMARY " +
      "        FROM ";
    strSql = strSql + ((table==null || table.equals(""))?"":table);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((column==null || column.equals(""))?"":column);
    strSql = strSql + 
      " = ?";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (table != null && !(table.equals(""))) {
        }
      if (column != null && !(column.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "issummary");
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
    return(strReturn);
  }

  public static String isItsOwnChild(ConnectionProvider connectionProvider, String tree, String parent, String node)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select instr(ad_parent_tree(?, ?),'|'||?||'|') AS isItsOwnChild from dual";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tree);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isitsownchild");
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
    return(strReturn);
  }

  public static boolean isMenuItemInDev(ConnectionProvider connectionProvider, String nodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*)" +
      "          FROM AD_MENU M, AD_MODULE O, AD_MODULE t" +
      "         WHERE (AD_MENU_ID = ?" +
      "                AND O.AD_MODULE_ID = M.AD_MODULE_ID" +
      "                AND O.ISINDEVELOPMENT='Y')" +
      "            OR (t.type='T'" +
      "                AND t.isindevelopment='Y')";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "count").equals("0");
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
