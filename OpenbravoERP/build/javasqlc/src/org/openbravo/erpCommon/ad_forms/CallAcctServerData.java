//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CallAcctServerData implements FieldProvider {
static Logger log4j = Logger.getLogger(CallAcctServerData.class);
  private String InitRecordNumber="0";
  public String id;
  public String processId;
  public String client;
  public String organization;
  public String userid;
  public String isrolesecurity;
  public String status;
  public String channel;
  public String obContext;
  public String params;
  public String adProcessSetId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("process_id") || fieldName.equals("processId"))
      return processId;
    else if (fieldName.equalsIgnoreCase("client"))
      return client;
    else if (fieldName.equalsIgnoreCase("organization"))
      return organization;
    else if (fieldName.equalsIgnoreCase("userid"))
      return userid;
    else if (fieldName.equalsIgnoreCase("isrolesecurity"))
      return isrolesecurity;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("channel"))
      return channel;
    else if (fieldName.equalsIgnoreCase("ob_context") || fieldName.equals("obContext"))
      return obContext;
    else if (fieldName.equalsIgnoreCase("params"))
      return params;
    else if (fieldName.equalsIgnoreCase("ad_process_set_id") || fieldName.equals("adProcessSetId"))
      return adProcessSetId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CallAcctServerData[] selectByProcessId(ConnectionProvider connectionProvider, String processId, String clientId)    throws ServletException {
    return selectByProcessId(connectionProvider, processId, clientId, 0, 0);
  }

  public static CallAcctServerData[] selectByProcessId(ConnectionProvider connectionProvider, String processId, String clientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Process_Request_ID AS Id, AD_Process_ID AS Process_Id," +
      "        AD_Client_ID AS Client, AD_Org_Id AS Organization, AD_User_ID AS UserId," +
      "        IsRoleSecurity, Status, Channel, Ob_Context, Params, AD_Process_Set_Id " +
      "        FROM AD_Process_Request" +
      "        WHERE AD_Process_Id = ? AND (AD_CLIENT_ID = '0' OR AD_CLIENT_ID = ?)";

    ResultSet result;
    Vector<CallAcctServerData> vector = new Vector<CallAcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);

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
        CallAcctServerData objectCallAcctServerData = new CallAcctServerData();
        objectCallAcctServerData.id = UtilSql.getValue(result, "id");
        objectCallAcctServerData.processId = UtilSql.getValue(result, "process_id");
        objectCallAcctServerData.client = UtilSql.getValue(result, "client");
        objectCallAcctServerData.organization = UtilSql.getValue(result, "organization");
        objectCallAcctServerData.userid = UtilSql.getValue(result, "userid");
        objectCallAcctServerData.isrolesecurity = UtilSql.getValue(result, "isrolesecurity");
        objectCallAcctServerData.status = UtilSql.getValue(result, "status");
        objectCallAcctServerData.channel = UtilSql.getValue(result, "channel");
        objectCallAcctServerData.obContext = UtilSql.getValue(result, "ob_context");
        objectCallAcctServerData.params = UtilSql.getValue(result, "params");
        objectCallAcctServerData.adProcessSetId = UtilSql.getValue(result, "ad_process_set_id");
        objectCallAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCallAcctServerData);
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
    CallAcctServerData objectCallAcctServerData[] = new CallAcctServerData[vector.size()];
    vector.copyInto(objectCallAcctServerData);
    return(objectCallAcctServerData);
  }

  public static String processID(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_PROCESS_ID FROM AD_PROCESS WHERE UPPER(VALUE) = 'ACCTSERVERPROCESS' AND ISBACKGROUND='Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_process_id");
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

  public static String selectLog(ConnectionProvider connectionProvider, String adProcessRunId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT LOG FROM AD_PROCESS_RUN " +
      "      WHERE AD_PROCESS_RUN_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRunId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "log");
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
