//Sqlc generated V1.O00-1
package org.openbravo.scheduling;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProcessRequestData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessRequestData.class);
  private String InitRecordNumber="0";
  public String id;
  public String processId;
  public String client;
  public String organization;
  public String isrolesecurity;
  public String status;
  public String channel;
  public String obContext;
  public String params;
  public String isgroup;
  public String timingOption;

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
    else if (fieldName.equalsIgnoreCase("isgroup"))
      return isgroup;
    else if (fieldName.equalsIgnoreCase("timing_option") || fieldName.equals("timingOption"))
      return timingOption;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProcessRequestData select(ConnectionProvider connectionProvider, String processRequestId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT AD_Process_Request_ID AS Id, AD_Process_ID AS Process_Id," +
      "      	AD_Client_ID AS Client, AD_Org_Id AS Organization," +
      "      	IsRoleSecurity, Status, Channel, Ob_Context, Params," +
      "      	IsGroup, timing_option" +
      "      	FROM AD_Process_Request" +
      "      	WHERE AD_Process_Request_ID = ?";

    ResultSet result;
    ProcessRequestData objectProcessRequestData = new ProcessRequestData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processRequestId);

      result = st.executeQuery();
      if(result.next()) {
        objectProcessRequestData.id = UtilSql.getValue(result, "id");
        objectProcessRequestData.processId = UtilSql.getValue(result, "process_id");
        objectProcessRequestData.client = UtilSql.getValue(result, "client");
        objectProcessRequestData.organization = UtilSql.getValue(result, "organization");
        objectProcessRequestData.isrolesecurity = UtilSql.getValue(result, "isrolesecurity");
        objectProcessRequestData.status = UtilSql.getValue(result, "status");
        objectProcessRequestData.channel = UtilSql.getValue(result, "channel");
        objectProcessRequestData.obContext = UtilSql.getValue(result, "ob_context");
        objectProcessRequestData.params = UtilSql.getValue(result, "params");
        objectProcessRequestData.isgroup = UtilSql.getValue(result, "isgroup");
        objectProcessRequestData.timingOption = UtilSql.getValue(result, "timing_option");
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
    return(objectProcessRequestData);
  }

  public static ProcessRequestData[] selectByStatus(ConnectionProvider connectionProvider, String status)    throws ServletException {
    return selectByStatus(connectionProvider, status, 0, 0);
  }

  public static ProcessRequestData[] selectByStatus(ConnectionProvider connectionProvider, String status, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT AD_Process_Request_ID AS Id, AD_Process_ID AS Process_Id," +
      "      	Channel, Ob_Context,timing_option" +
      "      	FROM AD_Process_Request" +
      "      	WHERE Status = ?";

    ResultSet result;
    Vector<ProcessRequestData> vector = new Vector<ProcessRequestData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);

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
        ProcessRequestData objectProcessRequestData = new ProcessRequestData();
        objectProcessRequestData.id = UtilSql.getValue(result, "id");
        objectProcessRequestData.processId = UtilSql.getValue(result, "process_id");
        objectProcessRequestData.channel = UtilSql.getValue(result, "channel");
        objectProcessRequestData.obContext = UtilSql.getValue(result, "ob_context");
        objectProcessRequestData.timingOption = UtilSql.getValue(result, "timing_option");
        objectProcessRequestData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProcessRequestData);
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
    ProcessRequestData objectProcessRequestData[] = new ProcessRequestData[vector.size()];
    vector.copyInto(objectProcessRequestData);
    return(objectProcessRequestData);
  }

  public static int insert(ConnectionProvider connectionProvider, String adOrgId, String adClientId, String createdby, String updatedby, String id, String processId, String user, String status, String channel, String obContext, String params, String previousFireTime, String dateTimeFormat, String nextFireTime, String scheduledFinish)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	INSERT INTO AD_Process_Request" +
      "        (AD_Org_ID, AD_Client_ID, Isactive, Created, Createdby, Updated, UpdatedBy," +
      "        AD_Process_Request_ID, AD_Process_ID, AD_User_ID, Status, Channel, Ob_Context, " +
      "        Params, Previous_Fire_Time, Next_Fire_Time, Scheduled_Finish)" +
      "        VALUES (?, ?, 'Y', NOW(), ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?," +
      "        TO_TIMESTAMP(?, ?), TO_TIMESTAMP(?, ?)," +
      "        TO_TIMESTAMP(?, ?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, channel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obContext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, params);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, previousFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduledFinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);

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

  public static int update(ConnectionProvider connectionProvider, String status, String updatedBy, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	UPDATE AD_Process_Request" +
      "      	SET Status = ?," +
      "      	Updated = NOW()," +
      "      	UpdatedBy = ?" +
      "      	WHERE AD_Process_Request_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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

  public static int update(ConnectionProvider connectionProvider, String status, String nextFireTime, String dateTimeFormat, String scheduledFinish, String updatedBy, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	UPDATE AD_Process_Request" +
      "      	SET Status = ?," +
      "      	Next_Fire_Time = TO_TIMESTAMP(?, ?)," +
      "      	Scheduled_Finish = TO_TIMESTAMP(?, ?)," +
      "      	Updated = NOW()," +
      "      	UpdatedBy = ?" +
      "      	WHERE AD_Process_Request_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduledFinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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

  public static int update(ConnectionProvider connectionProvider, String updatedBy, String user, String status, String channel, String previousFireTime, String dateTimeFormat, String nextFireTime, String scheduledFinish, String obContext, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	UPDATE AD_Process_Request" +
      "      	SET Updatedby = ?, AD_User_ID = ?, Status = ?, Channel = ?," +
      "      	Previous_Fire_Time = TO_TIMESTAMP(?, ?)," +
      "      	Next_Fire_Time = TO_TIMESTAMP(?, ?)," +
      "      	Scheduled_Finish = TO_TIMESTAMP(?, ?)," +
      "      	Ob_Context = ?," +
      "      	Updated = NOW()" +
      "      	WHERE AD_Process_Request_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, channel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, previousFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduledFinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obContext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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

  public static int setContext(ConnectionProvider connectionProvider, String updatedBy, String user, String status, String channel, String obContext, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Process_Request" +
      "        SET Updatedby = ?," +
      "            Updated = NOW()," +
      "            AD_User_ID = ?, " +
      "            Status = ?, " +
      "            Channel = ?," +
      "            Ob_Context = ?" +
      "        WHERE AD_Process_Request_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, channel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obContext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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

  public static int updateGroup(ConnectionProvider connectionProvider, String group, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Process_Request" +
      "        SET AD_Process_Request_Group_ID = ?" +
      "        WHERE AD_Process_Request_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, group);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
