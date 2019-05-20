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

class DocBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocBankData.class);
  private String InitRecordNumber="0";
  public String cBankstatementlineId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String cBankstatementId;
  public String line;
  public String description;
  public String valutadate;
  public String dateacct;
  public String cCurrencyId;
  public String trxamt;
  public String stmtamt;
  public String cChargeId;
  public String chargeamt;
  public String memo;
  public String referenceno;
  public String cDebtPaymentId;
  public String convertchargeamt;
  public String cDebtPaymentCreate;
  public String cDpManagementId;
  public String cGlitemId;
  public String cBankId;
  public String name;
  public String routingno;
  public String cLocationId;
  public String swiftcode;
  public String isownbank;
  public String codebank;
  public String codebranch;
  public String digitcontrol;
  public String cCashId;
  public String statementdate;
  public String beginningbalance;
  public String endingbalance;
  public String statementdifference;
  public String processing;
  public String processed;
  public String posted;
  public String adOrgtrxId;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String cBankaccountId;
  public String ismanual;
  public String createfrom;
  public String accountId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_bankstatementline_id") || fieldName.equals("cBankstatementlineId"))
      return cBankstatementlineId;
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
    else if (fieldName.equalsIgnoreCase("c_bankstatement_id") || fieldName.equals("cBankstatementId"))
      return cBankstatementId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("valutadate"))
      return valutadate;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("trxamt"))
      return trxamt;
    else if (fieldName.equalsIgnoreCase("stmtamt"))
      return stmtamt;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("memo"))
      return memo;
    else if (fieldName.equalsIgnoreCase("referenceno"))
      return referenceno;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("convertchargeamt"))
      return convertchargeamt;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_create") || fieldName.equals("cDebtPaymentCreate"))
      return cDebtPaymentCreate;
    else if (fieldName.equalsIgnoreCase("c_dp_management_id") || fieldName.equals("cDpManagementId"))
      return cDpManagementId;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("c_bank_id") || fieldName.equals("cBankId"))
      return cBankId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("routingno"))
      return routingno;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("swiftcode"))
      return swiftcode;
    else if (fieldName.equalsIgnoreCase("isownbank"))
      return isownbank;
    else if (fieldName.equalsIgnoreCase("codebank"))
      return codebank;
    else if (fieldName.equalsIgnoreCase("codebranch"))
      return codebranch;
    else if (fieldName.equalsIgnoreCase("digitcontrol"))
      return digitcontrol;
    else if (fieldName.equalsIgnoreCase("c_cash_id") || fieldName.equals("cCashId"))
      return cCashId;
    else if (fieldName.equalsIgnoreCase("statementdate"))
      return statementdate;
    else if (fieldName.equalsIgnoreCase("beginningbalance"))
      return beginningbalance;
    else if (fieldName.equalsIgnoreCase("endingbalance"))
      return endingbalance;
    else if (fieldName.equalsIgnoreCase("statementdifference"))
      return statementdifference;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocBankData[] select(ConnectionProvider connectionProvider, String C_BankAccount_ID)    throws ServletException {
    return select(connectionProvider, C_BankAccount_ID, 0, 0);
  }

  public static DocBankData[] select(ConnectionProvider connectionProvider, String C_BankAccount_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B.*, '' AS C_BANK_ID, '' AS NAME, '' AS ROUTINGNO, '' AS C_LOCATION_ID, '' AS SWIFTCODE, '' AS ISOWNBANK, '' AS CODEBANK," +
      "        '' AS CODEBRANCH, '' AS DIGITCONTROL, '' AS C_CASH_ID, '' AS STATEMENTDATE, '' AS BEGINNINGBALANCE, '' AS ENDINGBALANCE," +
      "        '' AS STATEMENTDIFFERENCE, '' AS PROCESSING, '' AS PROCESSED, '' AS POSTED, '' AS AD_ORGTRX_ID, '' AS C_PROJECT_ID," +
      "        '' AS C_CAMPAIGN_ID, '' AS C_ACTIVITY_ID, '' AS USER1_ID, '' AS USER2_ID, '' AS C_BANKACCOUNT_ID, '' AS ISMANUAL, '' AS CREATEFROM," +
      "        '' AS ACCOUNT_ID" +
      "        FROM C_BankStatementLine B WHERE C_BankStatement_ID = ? ORDER BY Line";

    ResultSet result;
    Vector<DocBankData> vector = new Vector<DocBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);

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
        DocBankData objectDocBankData = new DocBankData();
        objectDocBankData.cBankstatementlineId = UtilSql.getValue(result, "c_bankstatementline_id");
        objectDocBankData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocBankData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocBankData.isactive = UtilSql.getValue(result, "isactive");
        objectDocBankData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectDocBankData.createdby = UtilSql.getValue(result, "createdby");
        objectDocBankData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectDocBankData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocBankData.cBankstatementId = UtilSql.getValue(result, "c_bankstatement_id");
        objectDocBankData.line = UtilSql.getValue(result, "line");
        objectDocBankData.description = UtilSql.getValue(result, "description");
        objectDocBankData.valutadate = UtilSql.getDateValue(result, "valutadate", "dd-MM-yyyy");
        objectDocBankData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocBankData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocBankData.trxamt = UtilSql.getValue(result, "trxamt");
        objectDocBankData.stmtamt = UtilSql.getValue(result, "stmtamt");
        objectDocBankData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocBankData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocBankData.memo = UtilSql.getValue(result, "memo");
        objectDocBankData.referenceno = UtilSql.getValue(result, "referenceno");
        objectDocBankData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDocBankData.convertchargeamt = UtilSql.getValue(result, "convertchargeamt");
        objectDocBankData.cDebtPaymentCreate = UtilSql.getValue(result, "c_debt_payment_create");
        objectDocBankData.cDpManagementId = UtilSql.getValue(result, "c_dp_management_id");
        objectDocBankData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectDocBankData.cBankId = UtilSql.getValue(result, "c_bank_id");
        objectDocBankData.name = UtilSql.getValue(result, "name");
        objectDocBankData.routingno = UtilSql.getValue(result, "routingno");
        objectDocBankData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectDocBankData.swiftcode = UtilSql.getValue(result, "swiftcode");
        objectDocBankData.isownbank = UtilSql.getValue(result, "isownbank");
        objectDocBankData.codebank = UtilSql.getValue(result, "codebank");
        objectDocBankData.codebranch = UtilSql.getValue(result, "codebranch");
        objectDocBankData.digitcontrol = UtilSql.getValue(result, "digitcontrol");
        objectDocBankData.cCashId = UtilSql.getValue(result, "c_cash_id");
        objectDocBankData.statementdate = UtilSql.getValue(result, "statementdate");
        objectDocBankData.beginningbalance = UtilSql.getValue(result, "beginningbalance");
        objectDocBankData.endingbalance = UtilSql.getValue(result, "endingbalance");
        objectDocBankData.statementdifference = UtilSql.getValue(result, "statementdifference");
        objectDocBankData.processing = UtilSql.getValue(result, "processing");
        objectDocBankData.processed = UtilSql.getValue(result, "processed");
        objectDocBankData.posted = UtilSql.getValue(result, "posted");
        objectDocBankData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocBankData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocBankData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocBankData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocBankData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocBankData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocBankData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectDocBankData.ismanual = UtilSql.getValue(result, "ismanual");
        objectDocBankData.createfrom = UtilSql.getValue(result, "createfrom");
        objectDocBankData.accountId = UtilSql.getValue(result, "account_id");
        objectDocBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocBankData);
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
    DocBankData objectDocBankData[] = new DocBankData[vector.size()];
    vector.copyInto(objectDocBankData);
    return(objectDocBankData);
  }

  public static DocBankData[] selectCurrency(ConnectionProvider connectionProvider, String C_BankAccount_ID)    throws ServletException {
    return selectCurrency(connectionProvider, C_BankAccount_ID, 0, 0);
  }

  public static DocBankData[] selectCurrency(ConnectionProvider connectionProvider, String C_BankAccount_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Currency_ID FROM C_BankAccount WHERE C_BankAccount_ID=?";

    ResultSet result;
    Vector<DocBankData> vector = new Vector<DocBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);

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
        DocBankData objectDocBankData = new DocBankData();
        objectDocBankData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocBankData);
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
    DocBankData objectDocBankData[] = new DocBankData[vector.size()];
    vector.copyInto(objectDocBankData);
    return(objectDocBankData);
  }

  public static DocBankData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocBankData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B.AD_CLIENT_ID, B.AD_ORG_ID, B.NAME, B.C_BANKACCOUNT_ID, B.POSTED," +
      "        B.STATEMENTDATE, B.STATEMENTDIFFERENCE" +
      "        FROM C_BANKSTATEMENT B          " +
      "        WHERE AD_Client_ID=? " +
      "        AND C_BANKSTATEMENT_ID=?";

    ResultSet result;
    Vector<DocBankData> vector = new Vector<DocBankData>(0);
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
        DocBankData objectDocBankData = new DocBankData();
        objectDocBankData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocBankData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocBankData.name = UtilSql.getValue(result, "name");
        objectDocBankData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectDocBankData.posted = UtilSql.getValue(result, "posted");
        objectDocBankData.statementdate = UtilSql.getDateValue(result, "statementdate", "dd-MM-yyyy");
        objectDocBankData.statementdifference = UtilSql.getValue(result, "statementdifference");
        objectDocBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocBankData);
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
    DocBankData objectDocBankData[] = new DocBankData[vector.size()];
    vector.copyInto(objectDocBankData);
    return(objectDocBankData);
  }

  public static DocBankData[] selectBankInTransitAcct(ConnectionProvider connectionProvider, String C_BANKSTATEMENTLINE_ID, String C_ACCTSCHEMA_ID)    throws ServletException {
    return selectBankInTransitAcct(connectionProvider, C_BANKSTATEMENTLINE_ID, C_ACCTSCHEMA_ID, 0, 0);
  }

  public static DocBankData[] selectBankInTransitAcct(ConnectionProvider connectionProvider, String C_BANKSTATEMENTLINE_ID, String C_ACCTSCHEMA_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT B_INTRANSIT_ACCT  AS ACCOUNT_ID" +
      "		FROM C_BANKSTATEMENTLINE, C_BANKSTATEMENT, C_BANKACCOUNT, C_BANKACCOUNT_ACCT" +
      "		WHERE C_BANKSTATEMENTLINE.C_BANKSTATEMENT_ID = C_BANKSTATEMENT.C_BANKSTATEMENT_ID" +
      "		AND C_BANKSTATEMENT.C_BANKACCOUNT_ID = C_BANKACCOUNT.C_BANKACCOUNT_ID" +
      "		AND C_BANKACCOUNT.C_BANKACCOUNT_ID = C_BANKACCOUNT_ACCT.C_BANKACCOUNT_ID" +
      "		AND C_BANKSTATEMENTLINE_ID = ?" +
      "		AND C_BANKACCOUNT_ACCT.C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<DocBankData> vector = new Vector<DocBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BANKSTATEMENTLINE_ID);
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
        DocBankData objectDocBankData = new DocBankData();
        objectDocBankData.accountId = UtilSql.getValue(result, "account_id");
        objectDocBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocBankData);
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
    DocBankData objectDocBankData[] = new DocBankData[vector.size()];
    vector.copyInto(objectDocBankData);
    return(objectDocBankData);
  }
}
