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

class AlertData implements FieldProvider {
static Logger log4j = Logger.getLogger(AlertData.class);
  private String InitRecordNumber="0";
  public String adAlertId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String description;
  public String adAlertruleId;
  public String adRoleId;
  public String adUserId;
  public String recordId;
  public String referencekeyId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_alert_id") || fieldName.equals("adAlertId"))
      return adAlertId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_alertrule_id") || fieldName.equals("adAlertruleId"))
      return adAlertruleId;
    else if (fieldName.equalsIgnoreCase("ad_role_id") || fieldName.equals("adRoleId"))
      return adRoleId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
    else if (fieldName.equalsIgnoreCase("referencekey_id") || fieldName.equals("referencekeyId"))
      return referencekeyId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AlertData[] select(ConnectionProvider connectionProvider, String adAlertId)    throws ServletException {
    return select(connectionProvider, adAlertId, 0, 0);
  }

  public static AlertData[] select(ConnectionProvider connectionProvider, String adAlertId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	       SELECT AD_Alert_ID, AD_Client_ID, AD_Org_ID, IsActive, " +
      "	              Created, CreatedBy, Updated, UpdatedBy, Description, AD_AlertRule_ID," +
      "                  AD_Role_ID, AD_User_ID, Record_Id, Referencekey_ID" +
      "      		 FROM AD_Alert" +
      "      		WHERE AD_AlertRule_ID = ?";

    ResultSet result;
    Vector<AlertData> vector = new Vector<AlertData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertId);

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
        AlertData objectAlertData = new AlertData();
        objectAlertData.adAlertId = UtilSql.getValue(result, "ad_alert_id");
        objectAlertData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectAlertData.createdby = UtilSql.getValue(result, "createdby");
        objectAlertData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectAlertData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertData.description = UtilSql.getValue(result, "description");
        objectAlertData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertData.referencekeyId = UtilSql.getValue(result, "referencekey_id");
        objectAlertData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertData);
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
    AlertData objectAlertData[] = new AlertData[vector.size()];
    vector.copyInto(objectAlertData);
    return(objectAlertData);
  }

  public static AlertData[] select(ConnectionProvider connectionProvider, String adAlertId, String recordId)    throws ServletException {
    return select(connectionProvider, adAlertId, recordId, 0, 0);
  }

  public static AlertData[] select(ConnectionProvider connectionProvider, String adAlertId, String recordId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	       SELECT AD_Alert_ID, AD_Client_ID, AD_Org_ID, IsActive, " +
      "	              Created, CreatedBy, Updated, UpdatedBy, Description, AD_AlertRule_ID," +
      "                  AD_Role_ID, AD_User_ID, Record_Id" +
      "      		 FROM AD_Alert" +
      "      		WHERE AD_AlertRule_ID = ? AND Record_Id = ?";

    ResultSet result;
    Vector<AlertData> vector = new Vector<AlertData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);

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
        AlertData objectAlertData = new AlertData();
        objectAlertData.adAlertId = UtilSql.getValue(result, "ad_alert_id");
        objectAlertData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectAlertData.createdby = UtilSql.getValue(result, "createdby");
        objectAlertData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectAlertData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertData.description = UtilSql.getValue(result, "description");
        objectAlertData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertData);
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
    AlertData objectAlertData[] = new AlertData[vector.size()];
    vector.copyInto(objectAlertData);
    return(objectAlertData);
  }

  public static AlertData[] selectByDescription(ConnectionProvider connectionProvider, String adAlertId, String description)    throws ServletException {
    return selectByDescription(connectionProvider, adAlertId, description, 0, 0);
  }

  public static AlertData[] selectByDescription(ConnectionProvider connectionProvider, String adAlertId, String description, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	       SELECT AD_Alert_ID, AD_Client_ID, AD_Org_ID, IsActive, " +
      "	              Created, CreatedBy, Updated, UpdatedBy, Description, AD_AlertRule_ID," +
      "                  AD_Role_ID, AD_User_ID, Record_Id, Description" +
      "      		 FROM AD_Alert" +
      "      		WHERE AD_AlertRule_ID = ? AND Description = ?";

    ResultSet result;
    Vector<AlertData> vector = new Vector<AlertData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);

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
        AlertData objectAlertData = new AlertData();
        objectAlertData.adAlertId = UtilSql.getValue(result, "ad_alert_id");
        objectAlertData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectAlertData.createdby = UtilSql.getValue(result, "createdby");
        objectAlertData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectAlertData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertData.description = UtilSql.getValue(result, "description");
        objectAlertData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertData.description = UtilSql.getValue(result, "description");
        objectAlertData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertData);
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
    AlertData objectAlertData[] = new AlertData[vector.size()];
    vector.copyInto(objectAlertData);
    return(objectAlertData);
  }

  public static int insert(ConnectionProvider connectionProvider, String description, String adAlertRuleId, String recordId, String referencekeyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       INSERT INTO AD_Alert (AD_Alert_ID, AD_Client_ID, AD_Org_ID, IsActive, " +
      "                      Created, CreatedBy, Updated, UpdatedBy, Description, AD_AlertRule_ID, Record_Id, Referencekey_ID," +
      "                      status)" +
      "      		VALUES (get_uuid(), 0, 0, 'Y', NOW(), 0, NOW(), 0, ?, ?, ?, ?,'NEW')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAlertRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referencekeyId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
