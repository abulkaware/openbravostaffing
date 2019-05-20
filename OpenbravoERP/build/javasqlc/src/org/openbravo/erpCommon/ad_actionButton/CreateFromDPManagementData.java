//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CreateFromDPManagementData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromDPManagementData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cDebtPaymentId;
  public String dpPaymentrule;
  public String dateplanned;
  public String cInvoiceId;
  public String cBpartnerId;
  public String amount;
  public String isoCode;
  public String org;
  public String dpStatus;
  public String marcarId;
  public String disableInputs;
  public String line;
  public String invoice;
  public String bpartner;
  public String status;
  public String paymentrule;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("dp_paymentrule") || fieldName.equals("dpPaymentrule"))
      return dpPaymentrule;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("iso_code") || fieldName.equals("isoCode"))
      return isoCode;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("dp_status") || fieldName.equals("dpStatus"))
      return dpStatus;
    else if (fieldName.equalsIgnoreCase("marcar_id") || fieldName.equals("marcarId"))
      return marcarId;
    else if (fieldName.equalsIgnoreCase("disable_inputs") || fieldName.equals("disableInputs"))
      return disableInputs;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromDPManagementData[] select(ConnectionProvider connectionProvider, String language, String rownum, String marcartodos, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String statusFrom, String adOrgId, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, language, rownum, marcartodos, userClient, userOrg, cBPartnerId, paymentrule, planneddateFrom, planneddateTo, isreceipt, amountFrom, amountTo, amount, statusFrom, adOrgId, oraLimit, pgLimit, 0, 0);
  }

  public static CreateFromDPManagementData[] select(ConnectionProvider connectionProvider, String language, String rownum, String marcartodos, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String statusFrom, String adOrgId, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B.*," +
      "            Ad_Column_Identifier(to_char('C_Invoice'), to_char(C_Invoice_ID), to_char(?)) AS INVOICE," +
      "            (SELECT NAME FROM C_BPARTNER BP WHERE BP.C_BPARTNER_ID = b.C_BPARTNER_ID) AS BPARTNER," +
      "            COALESCE(" +
      "            	(SELECT NAME FROM AD_REF_LIST_V L1 where dp_status = L1.VALUE AND L1.AD_REFERENCE_ID = '800070' AND L1.AD_LANGUAGE = ?)," +
      "            	dp_status" +
      "            ) AS status," +
      "            COALESCE(" +
      "            	(SELECT NAME FROM AD_REF_LIST_V L where dp_paymentrule = L.VALUE AND L.AD_REFERENCE_ID = '195' AND L.AD_LANGUAGE = ?)," +
      "            	dp_paymentrule" +
      "            ) AS paymentrule" +
      "        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (" +
      "        SELECT DP.C_DEBT_PAYMENT_ID, " +
      "        dp.paymentrule  as dp_paymentrule," +
      "        DP.DATEPLANNED, " +
      "        dp.C_Invoice_ID, dp.c_bpartner_id," +
      "        DP.AMOUNT, C.ISO_CODE,  O.Name as Org, DP.status as dp_status," +
      "        (CASE ? WHEN 'Y' THEN DP.C_DEBT_PAYMENT_ID ELSE '-1' END) AS MARCAR_ID, " +
      "        (CASE ? WHEN 'Y' THEN '-1' ELSE DP.C_DEBT_PAYMENT_ID END) AS DISABLE_INPUTS," +
      "        '' AS LINE" +
      "        FROM C_DEBT_PAYMENT DP," +
      "           C_CURRENCY C, AD_Org O " +
      "        WHERE DP.ISACTIVE = 'Y' " +
      "        AND DP.AD_Org_ID = O.AD_Org_ID " +
      "        AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ") " +
      "        AND DP.C_CURRENCY_ID = C.C_CURRENCY_ID ";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND DP.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND DP.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND DP.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND DP.ISRECEIPT = ?  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND DP.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND DP.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((amount==null || amount.equals(""))?"":"  AND ABS(DP.AMOUNT) < TO_NUMBER(?)  ");
    strSql = strSql + ((statusFrom==null || statusFrom.equals(""))?"":"  AND DP.STATUS = ?  ");
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND DP.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND CASE" +
      "              WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "              WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "              WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "              WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "              ELSE 'P'" +
      "            END = 'P'" +
      "        AND NOT EXISTS (SELECT * FROM C_BankStatementLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "        AND NOT EXISTS (SELECT * FROM C_CashLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "        ORDER BY DP.DATEPLANNED DESC " +
      "        ) A ) B" +
      "        WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 <= " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<CreateFromDPManagementData> vector = new Vector<CreateFromDPManagementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marcartodos);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marcartodos);
      if (userClient != null && !(userClient.equals(""))) {
        }
      if (userOrg != null && !(userOrg.equals(""))) {
        }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (paymentrule != null && !(paymentrule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      }
      if (planneddateFrom != null && !(planneddateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateFrom);
      }
      if (planneddateTo != null && !(planneddateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateTo);
      }
      if (isreceipt != null && !(isreceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      }
      if (amountFrom != null && !(amountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountFrom);
      }
      if (amountTo != null && !(amountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountTo);
      }
      if (amount != null && !(amount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      }
      if (statusFrom != null && !(statusFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusFrom);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }
      if (oraLimit != null && !(oraLimit.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }

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
        CreateFromDPManagementData objectCreateFromDPManagementData = new CreateFromDPManagementData();
        objectCreateFromDPManagementData.rn1 = UtilSql.getValue(result, "rn1");
        objectCreateFromDPManagementData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCreateFromDPManagementData.dpPaymentrule = UtilSql.getValue(result, "dp_paymentrule");
        objectCreateFromDPManagementData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCreateFromDPManagementData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromDPManagementData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromDPManagementData.amount = UtilSql.getValue(result, "amount");
        objectCreateFromDPManagementData.isoCode = UtilSql.getValue(result, "iso_code");
        objectCreateFromDPManagementData.org = UtilSql.getValue(result, "org");
        objectCreateFromDPManagementData.dpStatus = UtilSql.getValue(result, "dp_status");
        objectCreateFromDPManagementData.marcarId = UtilSql.getValue(result, "marcar_id");
        objectCreateFromDPManagementData.disableInputs = UtilSql.getValue(result, "disable_inputs");
        objectCreateFromDPManagementData.line = UtilSql.getValue(result, "line");
        objectCreateFromDPManagementData.invoice = UtilSql.getValue(result, "invoice");
        objectCreateFromDPManagementData.bpartner = UtilSql.getValue(result, "bpartner");
        objectCreateFromDPManagementData.status = UtilSql.getValue(result, "status");
        objectCreateFromDPManagementData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCreateFromDPManagementData.rownum = Long.toString(countRecord);
        objectCreateFromDPManagementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromDPManagementData);
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
    CreateFromDPManagementData objectCreateFromDPManagementData[] = new CreateFromDPManagementData[vector.size()];
    vector.copyInto(objectCreateFromDPManagementData);
    return(objectCreateFromDPManagementData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String statusFrom, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS COUNT " +
      "        FROM C_DEBT_PAYMENT DP" +
      "        WHERE DP.ISACTIVE = 'Y' " +
      "        AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ") " +
      "        AND 1=1";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND DP.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND DP.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND DP.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND DP.ISRECEIPT = ?  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND DP.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND DP.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((amount==null || amount.equals(""))?"":"  AND ABS(DP.AMOUNT) < TO_NUMBER(?)  ");
    strSql = strSql + ((statusFrom==null || statusFrom.equals(""))?"":"  AND DP.STATUS = ?  ");
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND DP.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND CASE" +
      "              WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "              WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "              WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "              WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "              ELSE 'P'" +
      "            END = 'P'" +
      "        AND NOT EXISTS (SELECT * FROM C_BankStatementLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "        AND NOT EXISTS (SELECT * FROM C_CashLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (userClient != null && !(userClient.equals(""))) {
        }
      if (userOrg != null && !(userOrg.equals(""))) {
        }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (paymentrule != null && !(paymentrule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      }
      if (planneddateFrom != null && !(planneddateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateFrom);
      }
      if (planneddateTo != null && !(planneddateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateTo);
      }
      if (isreceipt != null && !(isreceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      }
      if (amountFrom != null && !(amountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountFrom);
      }
      if (amountTo != null && !(amountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountTo);
      }
      if (amount != null && !(amount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      }
      if (statusFrom != null && !(statusFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusFrom);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String bpartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static boolean NotIsCancelled(Connection conn, ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) " +
      "      FROM C_DEBT_PAYMENT DP " +
      "      WHERE DP.C_DEBT_PAYMENT_ID = ? " +
      "      AND C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.Cancel_Processed, DP.Generate_Processed, " +
      "      DP.IsPaid, DP.IsValid, DP.C_CashLine_ID, DP.C_BankStatementLine_ID)='P' " +
      "      AND NOT EXISTS (SELECT * FROM C_BankStatementLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "      AND NOT EXISTS (SELECT * FROM C_CashLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) ";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "count").equals("0");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(boolReturn);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String LineID, String client, String adUserId, String key, String statusTo, String line, String dpId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        insert into C_DP_ManagementLine (C_DP_MANAGEMENTLINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, " +
      "                                         CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_DP_MANAGEMENT_ID, STATUS_TO,C_DEBT_PAYMENT_ID, LINE)" +
      "        SELECT ?,?, ad_org_id,'Y', now(), ?, now(), ?, ?,?,C_DEBT_PAYMENT_ID, TO_NUMBER(?)" +
      "        FROM C_DEBT_PAYMENT" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, LineID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statusTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dpId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static String getLine(ConnectionProvider connectionProvider, String dpmId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    SELECT COALESCE(MAX(LINE),0) AS LINE" +
      "		  FROM C_DP_ManagementLine" +
      "		 WHERE C_DP_MANAGEMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dpmId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "line");
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
