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

class CreateFromSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromSettlementData.class);
  private String InitRecordNumber="0";
  public String cDebtPaymentId;
  public String paymentrule;
  public String bpartner;
  public String invoice;
  public String dateplanned;
  public String amount;
  public String isoCode;
  public String writeoffamt;
  public String ispaid;
  public String org;
  public String marcarId;
  public String disableInputs;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("iso_code") || fieldName.equals("isoCode"))
      return isoCode;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("marcar_id") || fieldName.equals("marcarId"))
      return marcarId;
    else if (fieldName.equalsIgnoreCase("disable_inputs") || fieldName.equals("disableInputs"))
      return disableInputs;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromSettlementData[] select(ConnectionProvider connectionProvider, String language, String marcartodos, String rownum, String isautocalculated, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String adOrgId, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, language, marcartodos, rownum, isautocalculated, userClient, userOrg, cBPartnerId, paymentrule, planneddateFrom, planneddateTo, isreceipt, amountFrom, amountTo, amount, adOrgId, oraLimit, pgLimit, 0, 0);
  }

  public static CreateFromSettlementData[] select(ConnectionProvider connectionProvider, String language, String marcartodos, String rownum, String isautocalculated, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String adOrgId, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT B.C_DEBT_PAYMENT_ID, L.NAME AS PAYMENTRULE, BP.NAME AS BPARTNER, " +
      "        Ad_Column_Identifier(to_char('C_Invoice'), to_char(i.C_Invoice_ID), to_char(?)) AS INVOICE, B.DATEPLANNED, " +
      "        B.AMOUNT, B.ISO_CODE, B.WRITEOFFAMT, B.ISPAID, B.ORG, " +
      "        (CASE ? WHEN 'Y' THEN B.C_DEBT_PAYMENT_ID ELSE '-1' END) AS MARCAR_ID, " +
      "        (CASE ? WHEN 'Y' THEN '-1' ELSE B.C_DEBT_PAYMENT_ID END) AS DISABLE_INPUTS " +
      "		  FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (" +
      "		  SELECT DP.C_DEBT_PAYMENT_ID, DP.DATEPLANNED, DP.AMOUNT, DP.";
    strSql = strSql + ((isautocalculated==null || isautocalculated.equals(""))?"":isautocalculated);
    strSql = strSql + 
      " AS WRITEOFFAMT, DP.ISPAID, DP.PAYMENTRULE, DP.C_BPARTNER_ID, DP.C_INVOICE_ID," +
      "		         O.Name AS ORG, C.Iso_Code" +
      "		    FROM C_DEBT_PAYMENT DP, C_CURRENCY C, AD_ORG O" +
      "		   WHERE DP.ISACTIVE = 'Y' " +
      "		     AND DP.AD_Org_ID = O.AD_Org_ID " +
      "		     AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ") " +
      "		     AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ") " +
      "		    AND DP.C_CURRENCY_ID = C.C_CURRENCY_ID ";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND DP.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND DP.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND DP.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND DP.ISRECEIPT = ?  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND DP.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND DP.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((amount==null || amount.equals(""))?"":"  AND ABS(DP.AMOUNT) < TO_NUMBER(?)  ");
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND DP.AD_Org_ID = ?  ");
    strSql = strSql + 
      "		    AND CASE" +
      "	              WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "	              WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "	              WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "	              WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "	              ELSE 'P'" +
      "                END = 'P' " +
      "		    AND NOT EXISTS (SELECT * FROM C_BankStatementLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "		    AND NOT EXISTS (SELECT * FROM C_CashLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID)" +
      "		    ORDER BY DP.DATEPLANNED DESC) A) B LEFT JOIN AD_REF_LIST_V L ON B.PAYMENTRULE = L.VALUE" +
      "		                                                                AND L.AD_REFERENCE_ID = '195'" +
      "		                                                                AND L.AD_LANGUAGE = ?" +
      "		                                       LEFT JOIN C_BPARTNER BP ON B.C_BPARTNER_ID = BP.C_BPARTNER_ID " +
      "		                                       LEFT JOIN C_INVOICE I ON B.C_INVOICE_ID = I.C_INVOICE_ID" +
      "		  WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 <= " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<CreateFromSettlementData> vector = new Vector<CreateFromSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marcartodos);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marcartodos);
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (isautocalculated != null && !(isautocalculated.equals(""))) {
        }
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
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
        CreateFromSettlementData objectCreateFromSettlementData = new CreateFromSettlementData();
        objectCreateFromSettlementData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCreateFromSettlementData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCreateFromSettlementData.bpartner = UtilSql.getValue(result, "bpartner");
        objectCreateFromSettlementData.invoice = UtilSql.getValue(result, "invoice");
        objectCreateFromSettlementData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCreateFromSettlementData.amount = UtilSql.getValue(result, "amount");
        objectCreateFromSettlementData.isoCode = UtilSql.getValue(result, "iso_code");
        objectCreateFromSettlementData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectCreateFromSettlementData.ispaid = UtilSql.getValue(result, "ispaid");
        objectCreateFromSettlementData.org = UtilSql.getValue(result, "org");
        objectCreateFromSettlementData.marcarId = UtilSql.getValue(result, "marcar_id");
        objectCreateFromSettlementData.disableInputs = UtilSql.getValue(result, "disable_inputs");
        objectCreateFromSettlementData.rownum = Long.toString(countRecord);
        objectCreateFromSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromSettlementData);
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
    CreateFromSettlementData objectCreateFromSettlementData[] = new CreateFromSettlementData[vector.size()];
    vector.copyInto(objectCreateFromSettlementData);
    return(objectCreateFromSettlementData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS AMOUNT" +
      "        FROM C_DEBT_PAYMENT DP" +
      "        WHERE DP.ISACTIVE = 'Y'" +
      "        AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ")        " +
      "        AND CASE" +
      "                  WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "                  WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "                  WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "                  WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "                  ELSE 'P'" +
      "                END = 'P'";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND DP.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND DP.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND DP.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND DP.ISRECEIPT = ?  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND DP.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND DP.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((amount==null || amount.equals(""))?"":"  AND ABS(DP.AMOUNT) < TO_NUMBER(?)  ");
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND DP.AD_Org_ID = ?  ");
    strSql = strSql + 
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
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "amount");
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
      "      SELECT COUNT(*) AS TOTAL" +
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
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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

  public static int update(Connection conn, ConnectionProvider connectionProvider, String adUserId, String cSettlementCancelId, String writeoffamt, String ispaid, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_DEBT_PAYMENT SET UPDATED=now(), UPDATEDBY = ?, C_SETTLEMENT_CANCEL_id = ?, WRITEOFFAMT=TO_NUMBER(?), ISPAID=? " +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementCancelId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

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
}
