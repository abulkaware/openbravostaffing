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

class DocAmortizationData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocAmortizationData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cCurrencyId;
  public String name;
  public String description;
  public String posted;
  public String dateacct;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String accumdepreciation;
  public String depreciation;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("accumdepreciation"))
      return accumdepreciation;
    else if (fieldName.equalsIgnoreCase("depreciation"))
      return depreciation;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocAmortizationData[] select(ConnectionProvider connectionProvider, String A_AMORTIZATION_ID)    throws ServletException {
    return select(connectionProvider, A_AMORTIZATION_ID, 0, 0);
  }

  public static DocAmortizationData[] select(ConnectionProvider connectionProvider, String A_AMORTIZATION_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT_ID, AD_ORG_ID, C_CURRENCY_ID, NAME,DESCRIPTION, POSTED, DATEACCT," +
      "      C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, USER1_ID, USER2_ID, '' AS ACCUMDEPRECIATION," +
      "      '' AS DEPRECIATION" +
      "      FROM A_AMORTIZATION" +
      "      WHERE A_AMORTIZATION_ID = ?";

    ResultSet result;
    Vector<DocAmortizationData> vector = new Vector<DocAmortizationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_AMORTIZATION_ID);

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
        DocAmortizationData objectDocAmortizationData = new DocAmortizationData();
        objectDocAmortizationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocAmortizationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocAmortizationData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocAmortizationData.name = UtilSql.getValue(result, "name");
        objectDocAmortizationData.description = UtilSql.getValue(result, "description");
        objectDocAmortizationData.posted = UtilSql.getValue(result, "posted");
        objectDocAmortizationData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocAmortizationData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocAmortizationData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocAmortizationData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocAmortizationData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocAmortizationData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocAmortizationData.accumdepreciation = UtilSql.getValue(result, "accumdepreciation");
        objectDocAmortizationData.depreciation = UtilSql.getValue(result, "depreciation");
        objectDocAmortizationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocAmortizationData);
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
    DocAmortizationData objectDocAmortizationData[] = new DocAmortizationData[vector.size()];
    vector.copyInto(objectDocAmortizationData);
    return(objectDocAmortizationData);
  }

  public static DocAmortizationData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocAmortizationData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT_ID, AD_ORG_ID, C_CURRENCY_ID, NAME,DESCRIPTION, POSTED, DATEACCT," +
      "      C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, USER1_ID, USER2_ID" +
      "      FROM A_AMORTIZATION" +
      "      WHERE AD_Client_ID=? " +
      "      AND A_AMORTIZATION_ID=?";

    ResultSet result;
    Vector<DocAmortizationData> vector = new Vector<DocAmortizationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocAmortizationData objectDocAmortizationData = new DocAmortizationData();
        objectDocAmortizationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocAmortizationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocAmortizationData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocAmortizationData.name = UtilSql.getValue(result, "name");
        objectDocAmortizationData.description = UtilSql.getValue(result, "description");
        objectDocAmortizationData.posted = UtilSql.getValue(result, "posted");
        objectDocAmortizationData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocAmortizationData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocAmortizationData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocAmortizationData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocAmortizationData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocAmortizationData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocAmortizationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocAmortizationData);
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
    DocAmortizationData objectDocAmortizationData[] = new DocAmortizationData[vector.size()];
    vector.copyInto(objectDocAmortizationData);
    return(objectDocAmortizationData);
  }

  public static DocAmortizationData[] selectAssetAcct(ConnectionProvider connectionProvider, String Asset, String AcctSchema)    throws ServletException {
    return selectAssetAcct(connectionProvider, Asset, AcctSchema, 0, 0);
  }

  public static DocAmortizationData[] selectAssetAcct(ConnectionProvider connectionProvider, String Asset, String AcctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT A_depreciation_Acct as depreciation, A_AccumDepreciation_Acct as accumdepreciation" +
      "      FROM A_Asset_Acct" +
      "      WHERE A_Asset_ID = ?" +
      "      AND C_AcctSchema_ID = ?";

    ResultSet result;
    Vector<DocAmortizationData> vector = new Vector<DocAmortizationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Asset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);

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
        DocAmortizationData objectDocAmortizationData = new DocAmortizationData();
        objectDocAmortizationData.depreciation = UtilSql.getValue(result, "depreciation");
        objectDocAmortizationData.accumdepreciation = UtilSql.getValue(result, "accumdepreciation");
        objectDocAmortizationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocAmortizationData);
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
    DocAmortizationData objectDocAmortizationData[] = new DocAmortizationData[vector.size()];
    vector.copyInto(objectDocAmortizationData);
    return(objectDocAmortizationData);
  }
}
