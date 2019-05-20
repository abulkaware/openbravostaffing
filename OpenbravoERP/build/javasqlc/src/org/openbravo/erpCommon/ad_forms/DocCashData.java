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

class DocCashData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocCashData.class);
  private String InitRecordNumber="0";
  public String cCashbookId;
  public String adOrgId;
  public String cCurrencyId;
  public String cCashId;
  public String adClientId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String name;
  public String description;
  public String statementdate;
  public String dateacct;
  public String statementdifference;
  public String posted;
  public String adOrgtrxId;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String issotrx;
  public String cBpartnerId;
  public String isreceipt;
  public String accountId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_cashbook_id") || fieldName.equals("cCashbookId"))
      return cCashbookId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_cash_id") || fieldName.equals("cCashId"))
      return cCashId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("statementdate"))
      return statementdate;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("statementdifference"))
      return statementdifference;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
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
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocCashData[] select(ConnectionProvider connectionProvider, String cash)    throws ServletException {
    return select(connectionProvider, cash, 0, 0);
  }

  public static DocCashData[] select(ConnectionProvider connectionProvider, String cash, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT cb.C_CashBook_ID, cb.AD_Org_ID, cb.C_Currency_ID, '' AS C_CASH_ID, '' AS AD_CLIENT_ID, '' AS ISACTIVE," +
      "	'' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS NAME, '' AS DESCRIPTION, '' AS STATEMENTDATE," +
      "	'' AS DATEACCT,'' AS STATEMENTDIFFERENCE," +
      "	'' AS POSTED, '' AS AD_ORGTRX_ID, '' AS C_PROJECT_ID, '' AS C_CAMPAIGN_ID, '' AS C_ACTIVITY_ID, '' AS USER1_ID, '' AS USER2_ID," +
      "	'' as ISSOTRX, '' AS C_BPARTNER_ID, '' AS ISRECEIPT, '' AS ACCOUNT_ID" +
      "	FROM C_Cash c, C_CashBook cb " +
      "	WHERE c.C_CashBook_ID=cb.C_CashBook_ID AND c.C_Cash_ID=?";

    ResultSet result;
    Vector<DocCashData> vector = new Vector<DocCashData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cash);

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
        DocCashData objectDocCashData = new DocCashData();
        objectDocCashData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectDocCashData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocCashData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocCashData.cCashId = UtilSql.getValue(result, "c_cash_id");
        objectDocCashData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocCashData.isactive = UtilSql.getValue(result, "isactive");
        objectDocCashData.created = UtilSql.getValue(result, "created");
        objectDocCashData.createdby = UtilSql.getValue(result, "createdby");
        objectDocCashData.updated = UtilSql.getValue(result, "updated");
        objectDocCashData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocCashData.name = UtilSql.getValue(result, "name");
        objectDocCashData.description = UtilSql.getValue(result, "description");
        objectDocCashData.statementdate = UtilSql.getValue(result, "statementdate");
        objectDocCashData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocCashData.statementdifference = UtilSql.getValue(result, "statementdifference");
        objectDocCashData.posted = UtilSql.getValue(result, "posted");
        objectDocCashData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocCashData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocCashData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocCashData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocCashData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocCashData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocCashData.issotrx = UtilSql.getValue(result, "issotrx");
        objectDocCashData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocCashData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectDocCashData.accountId = UtilSql.getValue(result, "account_id");
        objectDocCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocCashData);
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
    DocCashData objectDocCashData[] = new DocCashData[vector.size()];
    vector.copyInto(objectDocCashData);
    return(objectDocCashData);
  }

  public static DocCashData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocCashData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C.AD_CLIENT_ID, C.AD_ORG_ID, C.AD_ORGTRX_ID, C.C_PROJECT_ID, C.C_CAMPAIGN_ID," +
      "        C.C_ACTIVITY_ID, C.USER1_ID, C.USER2_ID, C.NAME, C.DATEACCT, C.POSTED, C.STATEMENTDATE," +
      "        C.STATEMENTDIFFERENCE" +
      "        FROM C_CASH C" +
      "        WHERE AD_CLIENT_ID=? " +
      "        AND C_CASH_ID=?";

    ResultSet result;
    Vector<DocCashData> vector = new Vector<DocCashData>(0);
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
        DocCashData objectDocCashData = new DocCashData();
        objectDocCashData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocCashData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocCashData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocCashData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocCashData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocCashData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocCashData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocCashData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocCashData.name = UtilSql.getValue(result, "name");
        objectDocCashData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocCashData.posted = UtilSql.getValue(result, "posted");
        objectDocCashData.statementdate = UtilSql.getDateValue(result, "statementdate", "dd-MM-yyyy");
        objectDocCashData.statementdifference = UtilSql.getValue(result, "statementdifference");
        objectDocCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocCashData);
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
    DocCashData objectDocCashData[] = new DocCashData[vector.size()];
    vector.copyInto(objectDocCashData);
    return(objectDocCashData);
  }

  public static DocCashData[] selectBankInTransitAcct(ConnectionProvider connectionProvider, String C_BANKACCOUNT_ID, String C_ACCTSCHEMA_ID)    throws ServletException {
    return selectBankInTransitAcct(connectionProvider, C_BANKACCOUNT_ID, C_ACCTSCHEMA_ID, 0, 0);
  }

  public static DocCashData[] selectBankInTransitAcct(ConnectionProvider connectionProvider, String C_BANKACCOUNT_ID, String C_ACCTSCHEMA_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT B_INTRANSIT_ACCT  AS ACCOUNT_ID" +
      "		FROM C_BANKACCOUNT_ACCT" +
      "		WHERE C_BANKACCOUNT_ID = ?" +
      "		AND C_BANKACCOUNT_ACCT.C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<DocCashData> vector = new Vector<DocCashData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BANKACCOUNT_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_ACCTSCHEMA_ID);

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
        DocCashData objectDocCashData = new DocCashData();
        objectDocCashData.accountId = UtilSql.getValue(result, "account_id");
        objectDocCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocCashData);
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
    DocCashData objectDocCashData[] = new DocCashData[vector.size()];
    vector.copyInto(objectDocCashData);
    return(objectDocCashData);
  }
}
