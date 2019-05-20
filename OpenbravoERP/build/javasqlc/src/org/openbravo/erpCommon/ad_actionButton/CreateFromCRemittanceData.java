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

class CreateFromCRemittanceData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromCRemittanceData.class);
  private String InitRecordNumber="0";
  public String cDebtPaymentId;
  public String paymentrule;
  public String bpartner;
  public String invoice;
  public String dateplanned;
  public String amount;
  public String isoCode;
  public String org;
  public String marcarId;
  public String disableInputs;
  public String status;
  public String line;
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
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("marcar_id") || fieldName.equals("marcarId"))
      return marcarId;
    else if (fieldName.equalsIgnoreCase("disable_inputs") || fieldName.equals("disableInputs"))
      return disableInputs;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromCRemittanceData[] select(ConnectionProvider connectionProvider, String language, String marcartodos, String rownum, String userClient, String userOrg, String adOrgId, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String statusFrom, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, language, marcartodos, rownum, userClient, userOrg, adOrgId, cBPartnerId, paymentrule, planneddateFrom, planneddateTo, isreceipt, amountFrom, amountTo, amount, statusFrom, oraLimit, pgLimit, 0, 0);
  }

  public static CreateFromCRemittanceData[] select(ConnectionProvider connectionProvider, String language, String marcartodos, String rownum, String userClient, String userOrg, String adOrgId, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String statusFrom, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B.C_DEBT_PAYMENT_ID, L.NAME AS PAYMENTRULE, BP.NAME AS BPARTNER, " +
      "		        Ad_Column_Identifier(to_char('C_Invoice'), to_char(i.C_Invoice_ID), to_char(?)) AS INVOICE, B.DATEPLANNED, " +
      "		        B.AMOUNT, B.ISO_CODE,  B.Org, " +
      "		        (CASE ? WHEN 'Y' THEN B.C_DEBT_PAYMENT_ID ELSE '-1' END) AS MARCAR_ID, " +
      "		        (CASE ? WHEN 'Y' THEN '-1' ELSE B.C_DEBT_PAYMENT_ID END) AS DISABLE_INPUTS, L1.name as status, '' as line" +
      "		   FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (" +
      "		      SELECT DP.C_DEBT_PAYMENT_ID, DP.AMOUNT, DP.PAYMENTRULE, DP.DATEPLANNED, DP.C_BPARTNER_ID," +
      "		             DP.C_INVOICE_ID, DP.STATUS, C.ISO_CODE, O.NAME AS ORG" +
      "		        FROM C_DEBT_PAYMENT DP, C_CURRENCY C, AD_Org O " +
      "		        WHERE DP.ISACTIVE = 'Y' " +
      "		        AND DP.AD_Org_ID = O.AD_Org_ID " +
      "		        AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ") " +
      "		        AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ") " +
      "		        AND  DP.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "		        AND DP.C_CURRENCY_ID = C.C_CURRENCY_ID ";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND DP.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND DP.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND DP.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND DP.ISRECEIPT = ?  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND DP.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND DP.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((amount==null || amount.equals(""))?"":"  AND ABS(DP.AMOUNT) < TO_NUMBER(?)  ");
    strSql = strSql + ((statusFrom==null || statusFrom.equals(""))?"":"  AND DP.STATUS = ?  ");
    strSql = strSql + 
      "		        AND CASE" +
      "		            WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "		            WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "		            WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "		            WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "		            ELSE 'P'" +
      "		          END = 'P' " +
      "		        AND NOT EXISTS (SELECT 1 FROM C_BankStatementLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "		        AND NOT EXISTS (SELECT 1 FROM C_CashLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "		        AND NOT EXISTS (SELECT 1 FROM C_RemittanceLine rl, C_Remittance r, C_REMITTANCE_TYPE rt " +
      "																		 WHERE r.C_REMITTANCE_ID = rl.C_REMITTANCE_ID" +
      "																		 AND rt.C_REMITTANCE_TYPE_ID = r.C_REMITTANCE_TYPE_ID" +
      "																		   AND r.PROCESSED = 'Y'" +
      "																		   AND rt.STATUS_RETURNED <> dp.STATUS" +
      "																			 AND rl.C_DEBT_PAYMENT_ID = dp.C_DEBT_PAYMENT_ID)" +
      "		        ORDER BY DP.DATEPLANNED DESC) A ) B LEFT JOIN AD_REF_LIST_V L ON B.PAYMENTRULE = L.VALUE" +
      "		                                                                     AND L.AD_REFERENCE_ID = '195'" +
      "		                                                                     AND L.AD_LANGUAGE = ?" +
      "		                                             left join C_BPARTNER BP    on B.C_BPARTNER_ID = BP.C_BPARTNER_ID " +
      "		                                             left join C_INVOICE I     on B.C_INVOICE_ID = I.C_INVOICE_ID" +
      "		                                             left join AD_REF_LIST_V L1 on B.STATUS = L1.value" +
      "		                                                                       and l1.ad_reference_id = '800070'" +
      "		                                                                       and l1.Ad_Language = ?" +
      "		     WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 <= " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<CreateFromCRemittanceData> vector = new Vector<CreateFromCRemittanceData>(0);
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
      if (userClient != null && !(userClient.equals(""))) {
        }
      if (userOrg != null && !(userOrg.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
        CreateFromCRemittanceData objectCreateFromCRemittanceData = new CreateFromCRemittanceData();
        objectCreateFromCRemittanceData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCreateFromCRemittanceData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCreateFromCRemittanceData.bpartner = UtilSql.getValue(result, "bpartner");
        objectCreateFromCRemittanceData.invoice = UtilSql.getValue(result, "invoice");
        objectCreateFromCRemittanceData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCreateFromCRemittanceData.amount = UtilSql.getValue(result, "amount");
        objectCreateFromCRemittanceData.isoCode = UtilSql.getValue(result, "iso_code");
        objectCreateFromCRemittanceData.org = UtilSql.getValue(result, "org");
        objectCreateFromCRemittanceData.marcarId = UtilSql.getValue(result, "marcar_id");
        objectCreateFromCRemittanceData.disableInputs = UtilSql.getValue(result, "disable_inputs");
        objectCreateFromCRemittanceData.status = UtilSql.getValue(result, "status");
        objectCreateFromCRemittanceData.line = UtilSql.getValue(result, "line");
        objectCreateFromCRemittanceData.rownum = Long.toString(countRecord);
        objectCreateFromCRemittanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromCRemittanceData);
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
    CreateFromCRemittanceData objectCreateFromCRemittanceData[] = new CreateFromCRemittanceData[vector.size()];
    vector.copyInto(objectCreateFromCRemittanceData);
    return(objectCreateFromCRemittanceData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String userClient, String userOrg, String adOrgId, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String isreceipt, String amountFrom, String amountTo, String amount, String statusFrom)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		      SELECT COUNT(*) AS AMOUNT" +
      "		        FROM C_DEBT_PAYMENT DP, C_CURRENCY C, AD_Org O " +
      "		        WHERE DP.ISACTIVE = 'Y' " +
      "		        AND DP.AD_Org_ID = O.AD_Org_ID " +
      "		        AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ") " +
      "		        AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ") " +
      "		        AND  DP.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "		        AND DP.C_CURRENCY_ID = C.C_CURRENCY_ID ";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND DP.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND DP.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND DP.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND DP.ISRECEIPT = ?  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND DP.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND DP.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((amount==null || amount.equals(""))?"":"  AND ABS(DP.AMOUNT) < TO_NUMBER(?)  ");
    strSql = strSql + ((statusFrom==null || statusFrom.equals(""))?"":"  AND DP.STATUS = ?  ");
    strSql = strSql + 
      "		        AND CASE" +
      "		            WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "		            WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "		            WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "		            WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "		            ELSE 'P'" +
      "		          END = 'P' " +
      "		        AND NOT EXISTS (SELECT 1 FROM C_BankStatementLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "		        AND NOT EXISTS (SELECT 1 FROM C_CashLine l WHERE DP.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID) " +
      "		        AND NOT EXISTS (SELECT 1 FROM C_RemittanceLine rl, C_Remittance r, C_REMITTANCE_TYPE rt " +
      "																		 WHERE r.C_REMITTANCE_ID = rl.C_REMITTANCE_ID" +
      "																		 AND rt.C_REMITTANCE_TYPE_ID = r.C_REMITTANCE_TYPE_ID" +
      "																		   AND r.PROCESSED = 'Y'" +
      "																		   AND rt.STATUS_RETURNED <> dp.STATUS" +
      "																			 AND rl.C_DEBT_PAYMENT_ID = dp.C_DEBT_PAYMENT_ID)";

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
      if (adOrgId != null && !(adOrgId.equals(""))) {
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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String LineID, String client, String adUserId, String key, String lineNo, String dpId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        insert into C_RemittanceLine(C_REMITTANCELINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, " +
      "                                     CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_REMITTANCE_ID, LINE, C_DEBT_PAYMENT_ID)" +
      "         SELECT ?,?, AD_ORG_ID ,'Y', " +
      "                now(), ?, now(), ?, ?,TO_NUMBER(?), C_DEBT_PAYMENT_ID" +
      "                FROM C_DEBT_PAYMENT" +
      "                WHERE C_DEBT_PAYMENT_ID = ?";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineNo);
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

  public static String selectLineNo(ConnectionProvider connectionProvider, String remittaceID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COALESCE(MAX(LINE),0) AS LINE" +
      "            FROM C_REMITTANCELINE " +
      "           WHERE C_REMITTANCE_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, remittaceID);

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
