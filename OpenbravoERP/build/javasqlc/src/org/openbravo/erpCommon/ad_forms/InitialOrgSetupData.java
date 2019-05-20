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

class InitialOrgSetupData implements FieldProvider {
static Logger log4j = Logger.getLogger(InitialOrgSetupData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InitialOrgSetupData[] selectOrgType(ConnectionProvider connectionProvider, String language, String client)    throws ServletException {
    return selectOrgType(connectionProvider, language, client, 0, 0);
  }

  public static InitialOrgSetupData[] selectOrgType(ConnectionProvider connectionProvider, String language, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_ORGTYPE_ID AS ID , AD_COLUMN_IDENTIFIER('AD_ORGTYPE',AD_ORGTYPE_ID,?) AS NAME" +
      "      FROM AD_ORGTYPE" +
      "      WHERE AD_CLIENT_ID = ?" +
      "      OR AD_CLIENT_ID = '0'" +
      "      ORDER BY 2";

    ResultSet result;
    Vector<InitialOrgSetupData> vector = new Vector<InitialOrgSetupData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        InitialOrgSetupData objectInitialOrgSetupData = new InitialOrgSetupData();
        objectInitialOrgSetupData.id = UtilSql.getValue(result, "id");
        objectInitialOrgSetupData.name = UtilSql.getValue(result, "name");
        objectInitialOrgSetupData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInitialOrgSetupData);
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
    InitialOrgSetupData objectInitialOrgSetupData[] = new InitialOrgSetupData[vector.size()];
    vector.copyInto(objectInitialOrgSetupData);
    return(objectInitialOrgSetupData);
  }

  public static InitialOrgSetupData[] selectParentOrg(ConnectionProvider connectionProvider, String language, String client)    throws ServletException {
    return selectParentOrg(connectionProvider, language, client, 0, 0);
  }

  public static InitialOrgSetupData[] selectParentOrg(ConnectionProvider connectionProvider, String language, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_ORG_ID AS ID , AD_COLUMN_IDENTIFIER('AD_ORG',AD_ORG_ID,?) AS NAME" +
      "      FROM AD_ORG" +
      "      WHERE (ISSUMMARY = 'Y'  AND AD_CLIENT_ID = ? AND ISACTIVE = 'Y') OR AD_ORG_ID = '0'" +
      "      ORDER BY 2";

    ResultSet result;
    Vector<InitialOrgSetupData> vector = new Vector<InitialOrgSetupData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        InitialOrgSetupData objectInitialOrgSetupData = new InitialOrgSetupData();
        objectInitialOrgSetupData.id = UtilSql.getValue(result, "id");
        objectInitialOrgSetupData.name = UtilSql.getValue(result, "name");
        objectInitialOrgSetupData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInitialOrgSetupData);
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
    InitialOrgSetupData objectInitialOrgSetupData[] = new InitialOrgSetupData[vector.size()];
    vector.copyInto(objectInitialOrgSetupData);
    return(objectInitialOrgSetupData);
  }

  public static int insertOrgModule(ConnectionProvider connectionProvider, String AD_Client_ID, String AD_Org_ID, String AD_User_ID, String AD_Module_ID, String version)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_ORGMODULE (AD_ORGMODULE_ID,AD_Client_ID, AD_ORG_ID,IsActive,Created,CreatedBy," +
      "      Updated,UpdatedBy,AD_MODULE_ID, VERSION)" +
      "      VALUES (GET_UUID(),?,?,'Y',now(),?,now(),?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Module_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, version);

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
