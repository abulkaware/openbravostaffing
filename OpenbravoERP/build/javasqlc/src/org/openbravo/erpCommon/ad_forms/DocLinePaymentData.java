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

class DocLinePaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLinePaymentData.class);
  private String InitRecordNumber="0";
  public String ismanual;
  public String isreceipt;
  public String adOrgId;
  public String cBpartnerId;
  public String description;
  public String cDebtPaymentId;
  public String amount;
  public String writeoffamt;
  public String ispaid;
  public String cSettlementCancelId;
  public String cSettlementGenerateId;
  public String cProjectId;
  public String debitAcct;
  public String creditAcct;
  public String cGlitemId;
  public String isdirectposting;
  public String withholdingamount;
  public String cInvoiceId;
  public String cWithholdingId;
  public String conversiondate;
  public String cCurrencyId;
  public String cBankaccountId;
  public String cCashbookId;
  public String cBankstatementlineId;
  public String cCashlineId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_id") || fieldName.equals("cSettlementCancelId"))
      return cSettlementCancelId;
    else if (fieldName.equalsIgnoreCase("c_settlement_generate_id") || fieldName.equals("cSettlementGenerateId"))
      return cSettlementGenerateId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("debit_acct") || fieldName.equals("debitAcct"))
      return debitAcct;
    else if (fieldName.equalsIgnoreCase("credit_acct") || fieldName.equals("creditAcct"))
      return creditAcct;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("isdirectposting"))
      return isdirectposting;
    else if (fieldName.equalsIgnoreCase("withholdingamount"))
      return withholdingamount;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_withholding_id") || fieldName.equals("cWithholdingId"))
      return cWithholdingId;
    else if (fieldName.equalsIgnoreCase("conversiondate"))
      return conversiondate;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("c_cashbook_id") || fieldName.equals("cCashbookId"))
      return cCashbookId;
    else if (fieldName.equalsIgnoreCase("c_bankstatementline_id") || fieldName.equals("cBankstatementlineId"))
      return cBankstatementlineId;
    else if (fieldName.equalsIgnoreCase("c_cashline_id") || fieldName.equals("cCashlineId"))
      return cCashlineId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLinePaymentData[] select(ConnectionProvider connectionProvider, String C_SETTLEMENT_ID)    throws ServletException {
    return select(connectionProvider, C_SETTLEMENT_ID, 0, 0);
  }

  public static DocLinePaymentData[] select(ConnectionProvider connectionProvider, String C_SETTLEMENT_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT  DP.ISMANUAL, DP.ISRECEIPT,DP.AD_ORG_ID, DP.C_BPARTNER_ID, DP.DESCRIPTION, DP.C_DEBT_PAYMENT_ID," +
      "      DP.AMOUNT, DP.WRITEOFFAMT, DP.ISPAID, DP.C_SETTLEMENT_CANCEL_ID, DP.C_SETTLEMENT_GENERATE_ID, DP.C_PROJECT_ID," +
      "      '' AS DEBIT_ACCT, '' AS CREDIT_ACCT, '' AS C_GLITEM_ID, ISDIRECTPOSTING, DP.WithHoldingAmount,DP.C_INVOICE_ID," +
      "      CASE WHEN (DP.C_SETTLEMENT_CANCEL_ID = ST.C_SETTLEMENT_ID AND (DP.ISPAID = 'Y' or amount = writeoffamt)) THEN C_WITHHOLDING_ID ELSE NULL END AS C_WITHHOLDING_ID," +
      "			TRUNC(COALESCE((SELECT O.DATEACCT" +
      "				          FROM C_ORDER O" +
      "								WHERE DP.C_ORDER_ID = O.C_ORDER_ID)," +
      "							 (SELECT I.DATEACCT" +
      "							   FROM C_INVOICE I" +
      "								WHERE DP.C_INVOICE_ID = I.C_INVOICE_ID)," +
      "							(SELECT ST2.DATEACCT" +
      "							 FROM C_SETTLEMENT ST2" +
      "							 WHERE DP.C_SETTLEMENT_GENERATE_ID = ST2.C_SETTLEMENT_ID))) AS CONVERSIONDATE, DP.C_CURRENCY_ID ," +
      "      C_BANKACCOUNT_ID, C_CASHBOOK_ID, C_BANKSTATEMENTLINE_ID, C_CASHLINE_ID" +
      "      FROM C_DEBT_PAYMENT DP, C_SETTLEMENT ST" +
      "      WHERE ST.C_SETTLEMENT_ID = ?" +
      "      AND (DP.C_SETTLEMENT_CANCEL_ID = ST.C_SETTLEMENT_ID" +
      "      OR DP.C_SETTLEMENT_GENERATE_ID = ST.C_SETTLEMENT_ID)" +
      "      AND (ST.SETTLEMENTTYPE <> 'I' OR DP.ISDIRECTPOSTING = 'Y')" +
      "      ORDER BY C_SETTLEMENT_CANCEL_ID";

    ResultSet result;
    Vector<DocLinePaymentData> vector = new Vector<DocLinePaymentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_SETTLEMENT_ID);

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
        DocLinePaymentData objectDocLinePaymentData = new DocLinePaymentData();
        objectDocLinePaymentData.ismanual = UtilSql.getValue(result, "ismanual");
        objectDocLinePaymentData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectDocLinePaymentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLinePaymentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLinePaymentData.description = UtilSql.getValue(result, "description");
        objectDocLinePaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDocLinePaymentData.amount = UtilSql.getValue(result, "amount");
        objectDocLinePaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectDocLinePaymentData.ispaid = UtilSql.getValue(result, "ispaid");
        objectDocLinePaymentData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectDocLinePaymentData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectDocLinePaymentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLinePaymentData.debitAcct = UtilSql.getValue(result, "debit_acct");
        objectDocLinePaymentData.creditAcct = UtilSql.getValue(result, "credit_acct");
        objectDocLinePaymentData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectDocLinePaymentData.isdirectposting = UtilSql.getValue(result, "isdirectposting");
        objectDocLinePaymentData.withholdingamount = UtilSql.getValue(result, "withholdingamount");
        objectDocLinePaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocLinePaymentData.cWithholdingId = UtilSql.getValue(result, "c_withholding_id");
        objectDocLinePaymentData.conversiondate = UtilSql.getDateValue(result, "conversiondate", "dd-MM-yyyy");
        objectDocLinePaymentData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLinePaymentData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectDocLinePaymentData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectDocLinePaymentData.cBankstatementlineId = UtilSql.getValue(result, "c_bankstatementline_id");
        objectDocLinePaymentData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectDocLinePaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLinePaymentData);
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
    DocLinePaymentData objectDocLinePaymentData[] = new DocLinePaymentData[vector.size()];
    vector.copyInto(objectDocLinePaymentData);
    return(objectDocLinePaymentData);
  }

  public static String getDPStatus(ConnectionProvider connectionProvider, String C_SETTLEMENT_ID, String C_DP_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT DP.STATUS_INITIAL AS DPSTATUS" +
      "         FROM C_DEBT_PAYMENT DP" +
      "        WHERE C_SETTLEMENT_GENERATE_ID = ?" +
      "          AND C_DEBT_PAYMENT_ID = ?" +
      "        UNION" +
      "       SELECT DP.STATUS" +
      "         FROM C_DEBT_PAYMENT DP" +
      "        WHERE C_SETTLEMENT_CANCEL_ID = ?" +
      "          AND C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_SETTLEMENT_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DP_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_SETTLEMENT_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DP_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "dpstatus");
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
