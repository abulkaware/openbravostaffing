//Sqlc generated V1.O00-1
package org.openbravo.client.application;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class AlertActionHandlerData implements FieldProvider {
static Logger log4j = Logger.getLogger(AlertActionHandlerData.class);
  private String InitRecordNumber="0";
  public String adSessionId;
  public String serverUrl;
  public String supportContact;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_session_id") || fieldName.equals("adSessionId"))
      return adSessionId;
    else if (fieldName.equalsIgnoreCase("server_url") || fieldName.equals("serverUrl"))
      return serverUrl;
    else if (fieldName.equals("supportContact"))
      return supportContact;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AlertActionHandlerData[] activeSessions(ConnectionProvider connectionProvider)    throws ServletException {
    return activeSessions(connectionProvider, 0, 0);
  }

  public static AlertActionHandlerData[] activeSessions(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_SESSION_ID, SERVER_URL" +
      "          FROM AD_SESSION" +
      "         WHERE SESSION_ACTIVE = 'Y'";

    ResultSet result;
    Vector<AlertActionHandlerData> vector = new Vector<AlertActionHandlerData>(0);
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
        AlertActionHandlerData objectAlertActionHandlerData = new AlertActionHandlerData();
        objectAlertActionHandlerData.adSessionId = UtilSql.getValue(result, "ad_session_id");
        objectAlertActionHandlerData.serverUrl = UtilSql.getValue(result, "server_url");
        objectAlertActionHandlerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertActionHandlerData);
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
    AlertActionHandlerData objectAlertActionHandlerData[] = new AlertActionHandlerData[vector.size()];
    vector.copyInto(objectAlertActionHandlerData);
    return(objectAlertActionHandlerData);
  }

  public static int setLastPing(ConnectionProvider connectionProvider, String adSessionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Session" +
      "        SET last_session_ping = NOW()" +
      "        WHERE AD_Session.AD_Session_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);

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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
