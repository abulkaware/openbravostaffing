//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class AlertProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(AlertProcessData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String isactive;
  public String adUserId;
  public String adRoleId;
  public String recordId;
  public String description;
  public String referencekeyId;
  public String adAlertruleId;
  public String sql;
  public String name;
  public String smtphost;
  public String requestuser;
  public String requestuserpw;
  public String mailto;
  public String mailfrom;
  public String adLanguage;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_role_id") || fieldName.equals("adRoleId"))
      return adRoleId;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("referencekey_id") || fieldName.equals("referencekeyId"))
      return referencekeyId;
    else if (fieldName.equalsIgnoreCase("ad_alertrule_id") || fieldName.equals("adAlertruleId"))
      return adAlertruleId;
    else if (fieldName.equalsIgnoreCase("sql"))
      return sql;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("smtphost"))
      return smtphost;
    else if (fieldName.equalsIgnoreCase("requestuser"))
      return requestuser;
    else if (fieldName.equalsIgnoreCase("requestuserpw"))
      return requestuserpw;
    else if (fieldName.equalsIgnoreCase("mailto"))
      return mailto;
    else if (fieldName.equalsIgnoreCase("mailfrom"))
      return mailfrom;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AlertProcessData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static AlertProcessData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS AD_CLIENT_ID," +
      "               '' AS AD_ORG_ID," +
      "               '' AS CREATED," +
      "               '' AS CREATEDBY," +
      "               '' AS UPDATED," +
      "               '' AS UPDATEDBY," +
      "               '' AS ISACTIVE," +
      "               '' AS AD_USER_ID," +
      "               '' AS AD_ROLE_ID," +
      "               '' AS RECORD_ID," +
      "               '' AS DESCRIPTION," +
      "               '' AS REFERENCEKEY_ID, " +
      "               '' AS AD_ALERTRULE_ID," +
      "               '' AS SQL," +
      "               '' AS NAME," +
      "               '' AS SMTPHOST," +
      "               '' AS REQUESTUSER," +
      "               '' AS REQUESTUSERPW," +
      "               '' AS MAILTO," +
      "               '' AS MAILFROM," +
      "               '' AS AD_LANGUAGE" +
      "          FROM DUAL";

    ResultSet result;
    Vector<AlertProcessData> vector = new Vector<AlertProcessData>(0);
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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertProcessData.created = UtilSql.getValue(result, "created");
        objectAlertProcessData.createdby = UtilSql.getValue(result, "createdby");
        objectAlertProcessData.updated = UtilSql.getValue(result, "updated");
        objectAlertProcessData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAlertProcessData.isactive = UtilSql.getValue(result, "isactive");
        objectAlertProcessData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAlertProcessData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectAlertProcessData.recordId = UtilSql.getValue(result, "record_id");
        objectAlertProcessData.description = UtilSql.getValue(result, "description");
        objectAlertProcessData.referencekeyId = UtilSql.getValue(result, "referencekey_id");
        objectAlertProcessData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertProcessData.sql = UtilSql.getValue(result, "sql");
        objectAlertProcessData.name = UtilSql.getValue(result, "name");
        objectAlertProcessData.smtphost = UtilSql.getValue(result, "smtphost");
        objectAlertProcessData.requestuser = UtilSql.getValue(result, "requestuser");
        objectAlertProcessData.requestuserpw = UtilSql.getValue(result, "requestuserpw");
        objectAlertProcessData.mailto = UtilSql.getValue(result, "mailto");
        objectAlertProcessData.mailfrom = UtilSql.getValue(result, "mailfrom");
        objectAlertProcessData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }

  public static AlertProcessData[] selectSQL(ConnectionProvider connectionProvider)    throws ServletException {
    return selectSQL(connectionProvider, 0, 0);
  }

  public static AlertProcessData[] selectSQL(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ALERTRULE_ID, SQL, NAME, AD_CLIENT_ID, AD_ORG_ID" +
      "          FROM AD_ALERTRULE" +
      "         WHERE ISACTIVE = 'Y'";

    ResultSet result;
    Vector<AlertProcessData> vector = new Vector<AlertProcessData>(0);
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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertProcessData.sql = UtilSql.getValue(result, "sql");
        objectAlertProcessData.name = UtilSql.getValue(result, "name");
        objectAlertProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }

  public static AlertProcessData[] selectSQL(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return selectSQL(connectionProvider, adClientId, 0, 0);
  }

  public static AlertProcessData[] selectSQL(ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ALERTRULE_ID, SQL, NAME, AD_CLIENT_ID, AD_ORG_ID" +
      "          FROM AD_ALERTRULE" +
      "         WHERE ISACTIVE = 'Y'" +
      "           AND AD_CLIENT_ID = ?";

    ResultSet result;
    Vector<AlertProcessData> vector = new Vector<AlertProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.adAlertruleId = UtilSql.getValue(result, "ad_alertrule_id");
        objectAlertProcessData.sql = UtilSql.getValue(result, "sql");
        objectAlertProcessData.name = UtilSql.getValue(result, "name");
        objectAlertProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }

  public static int updateAlert(ConnectionProvider connectionProvider, String alertRuleId, String sql)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_ALERT" +
      "           SET STATUS    = 'SOLVED'," +
      "               UPDATED   = NOW()," +
      "               UPDATEDBY = 0" +
      "         WHERE AD_ALERTRULE_ID = ?" +
      "           AND COALESCE(STATUS, 'NEW') != 'SOLVED'" +
      "           AND NOT EXISTS " +
      "                   (SELECT 1 FROM (";
    strSql = strSql + ((sql==null || sql.equals(""))?"":sql);
    strSql = strSql + 
      ") A WHERE 1=1" +
      "                              AND A.REFERENCEKEY_ID = AD_ALERT.REFERENCEKEY_ID)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);
      if (sql != null && !(sql.equals(""))) {
        }

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

  public static AlertProcessData[] prepareMails(ConnectionProvider connectionProvider, String alertRuleId)    throws ServletException {
    return prepareMails(connectionProvider, alertRuleId, 0, 0);
  }

  public static AlertProcessData[] prepareMails(ConnectionProvider connectionProvider, String alertRuleId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c.smtphost, c.requestuser, c.requestuserpw, c.requestemail as mailfrom, " +
      "               u.email as mailto, c.ad_language, c.ad_client_id" +
      "          from ad_alertrecipient  ar, ad_user_roles ur, ad_user u, ad_client c" +
      "          where ar.ad_alertrule_id = ?" +
      "            and ur.ad_role_id = ar.ad_role_id" +
      "            and ur.ad_client_id = ar.ad_client_id" +
      "            and ur.ad_user_id = u.ad_user_id" +
      "            and u.ad_client_id = c.ad_client_id" +
      "            and c.requestuser is not null" +
      "            and c.requestuserpw is not null" +
      "            and u.email is not null" +
      "            and ar.ad_user_id is null" +
      "            and ar.sendemail = 'Y'" +
      "        union" +
      "        select c.smtphost, c.requestuser, c.requestuserpw, c.requestemail as mailfrom, " +
      "               u.email as mailto, c.ad_language, c.ad_client_id" +
      "          from ad_alertrecipient  ar, ad_user u, ad_client c" +
      "          where ar.ad_alertrule_id = ?" +
      "            and u.ad_client_id = c.ad_client_id" +
      "            and ar.ad_user_id = u.ad_user_id" +
      "            and c.requestuser is not null" +
      "            and c.requestuserpw is not null" +
      "            and u.email is not null" +
      "            and ar.ad_user_id is not null" +
      "            and ar.sendemail = 'Y'";

    ResultSet result;
    Vector<AlertProcessData> vector = new Vector<AlertProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertRuleId);

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
        AlertProcessData objectAlertProcessData = new AlertProcessData();
        objectAlertProcessData.smtphost = UtilSql.getValue(result, "smtphost");
        objectAlertProcessData.requestuser = UtilSql.getValue(result, "requestuser");
        objectAlertProcessData.requestuserpw = UtilSql.getValue(result, "requestuserpw");
        objectAlertProcessData.mailfrom = UtilSql.getValue(result, "mailfrom");
        objectAlertProcessData.mailto = UtilSql.getValue(result, "mailto");
        objectAlertProcessData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectAlertProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAlertProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAlertProcessData);
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
    AlertProcessData objectAlertProcessData[] = new AlertProcessData[vector.size()];
    vector.copyInto(objectAlertProcessData);
    return(objectAlertProcessData);
  }
}
