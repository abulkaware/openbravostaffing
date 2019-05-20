//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ActionButtonDefaultData implements FieldProvider {
static Logger log4j = Logger.getLogger(ActionButtonDefaultData.class);
  private String InitRecordNumber="0";
  public String name;
  public String description;
  public String help;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ActionButtonDefaultData[] select(ConnectionProvider connectionProvider, String adProcessId)    throws ServletException {
    return select(connectionProvider, adProcessId, 0, 0);
  }

  public static ActionButtonDefaultData[] select(ConnectionProvider connectionProvider, String adProcessId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, DESCRIPTION, HELP FROM AD_PROCESS WHERE AD_PROCESS_ID = ?";

    ResultSet result;
    Vector<ActionButtonDefaultData> vector = new Vector<ActionButtonDefaultData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
        ActionButtonDefaultData objectActionButtonDefaultData = new ActionButtonDefaultData();
        objectActionButtonDefaultData.name = UtilSql.getValue(result, "name");
        objectActionButtonDefaultData.description = UtilSql.getValue(result, "description");
        objectActionButtonDefaultData.help = UtilSql.getValue(result, "help");
        objectActionButtonDefaultData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActionButtonDefaultData);
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
    ActionButtonDefaultData objectActionButtonDefaultData[] = new ActionButtonDefaultData[vector.size()];
    vector.copyInto(objectActionButtonDefaultData);
    return(objectActionButtonDefaultData);
  }

  public static ActionButtonDefaultData[] selectLanguage(ConnectionProvider connectionProvider, String adLanguage, String adProcessId)    throws ServletException {
    return selectLanguage(connectionProvider, adLanguage, adProcessId, 0, 0);
  }

  public static ActionButtonDefaultData[] selectLanguage(ConnectionProvider connectionProvider, String adLanguage, String adProcessId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(PT.NAME, P.NAME) AS NAME, " +
      "        COALESCE(PT.DESCRIPTION, P.DESCRIPTION) AS DESCRIPTION, " +
      "        COALESCE(PT.HELP, P.HELP) AS HELP " +
      "        FROM AD_PROCESS P left join AD_PROCESS_TRL PT on P.AD_PROCESS_ID = PT.AD_PROCESS_ID" +
      "                                      AND PT.AD_LANGUAGE = ?" +
      "        WHERE P.AD_PROCESS_ID = ? ";

    ResultSet result;
    Vector<ActionButtonDefaultData> vector = new Vector<ActionButtonDefaultData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
        ActionButtonDefaultData objectActionButtonDefaultData = new ActionButtonDefaultData();
        objectActionButtonDefaultData.name = UtilSql.getValue(result, "name");
        objectActionButtonDefaultData.description = UtilSql.getValue(result, "description");
        objectActionButtonDefaultData.help = UtilSql.getValue(result, "help");
        objectActionButtonDefaultData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActionButtonDefaultData);
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
    ActionButtonDefaultData objectActionButtonDefaultData[] = new ActionButtonDefaultData[vector.size()];
    vector.copyInto(objectActionButtonDefaultData);
    return(objectActionButtonDefaultData);
  }

  public static ActionButtonDefaultData[] windowName(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    return windowName(connectionProvider, adTabId, 0, 0);
  }

  public static ActionButtonDefaultData[] windowName(ConnectionProvider connectionProvider, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT T.HASTREE AS HELP, W.NAME AS DESCRIPTION, T.NAME AS NAME " +
      "        FROM AD_WINDOW W, AD_TAB T " +
      "        WHERE T.AD_TAB_ID = ? " +
      "        AND W.AD_WINDOW_ID = T.AD_WINDOW_ID ";

    ResultSet result;
    Vector<ActionButtonDefaultData> vector = new Vector<ActionButtonDefaultData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        ActionButtonDefaultData objectActionButtonDefaultData = new ActionButtonDefaultData();
        objectActionButtonDefaultData.help = UtilSql.getValue(result, "help");
        objectActionButtonDefaultData.description = UtilSql.getValue(result, "description");
        objectActionButtonDefaultData.name = UtilSql.getValue(result, "name");
        objectActionButtonDefaultData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActionButtonDefaultData);
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
    ActionButtonDefaultData objectActionButtonDefaultData[] = new ActionButtonDefaultData[vector.size()];
    vector.copyInto(objectActionButtonDefaultData);
    return(objectActionButtonDefaultData);
  }

  public static String getText(ConnectionProvider connectionProvider, String adLanguage, String adReferenceId, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select coalesce(tt.name, t.name) as name " +
      "        from ad_ref_list t left join ad_ref_list_trl tt on t.ad_ref_list_id = tt.ad_ref_list_id " +
      "                                                        and tt.ad_language = ?" +
      "        where ad_reference_id = ?" +
      "        and value = (CASE TO_CHAR(?) WHEN '--' THEN 'CL' ELSE TO_CHAR(?) END)";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
}
