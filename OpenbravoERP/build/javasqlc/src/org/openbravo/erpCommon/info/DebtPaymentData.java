//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DebtPaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(DebtPaymentData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cDebtPaymentId;
  public String bpartner;
  public String invoice;
  public String dateplanned;
  public String orderno;
  public String amount;
  public String writeoffamt;
  public String currency;
  public String payrule;
  public String cSettlementCancelId;
  public String cSettlementGenerateId;
  public String rowkey;
  public String paymentrule;
  public String debtcancel;
  public String debtgenerate;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("orderno"))
      return orderno;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("payrule"))
      return payrule;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_id") || fieldName.equals("cSettlementCancelId"))
      return cSettlementCancelId;
    else if (fieldName.equalsIgnoreCase("c_settlement_generate_id") || fieldName.equals("cSettlementGenerateId"))
      return cSettlementGenerateId;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("debtcancel"))
      return debtcancel;
    else if (fieldName.equalsIgnoreCase("debtgenerate"))
      return debtgenerate;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DebtPaymentData[] select(ConnectionProvider connectionProvider, String language, String rownum, String adUserClient, String adUserOrg, String businesPartner, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isPaid, String isReceipt, String invoiceId, String orderId, String isPending, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, language, rownum, adUserClient, adUserOrg, businesPartner, dateFrom, dateTo, AmountFrom, AmountTo, paymentRule, isPaid, isReceipt, invoiceId, orderId, isPending, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static DebtPaymentData[] select(ConnectionProvider connectionProvider, String language, String rownum, String adUserClient, String adUserOrg, String businesPartner, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isPaid, String isReceipt, String invoiceId, String orderId, String isPending, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT B.*," +
      "            C_DEBT_PAYMENT_ID || '@_##_@' || Ad_Column_Identifier(TO_CHAR('C_Debt_Payment'), TO_CHAR(C_DEBT_PAYMENT_ID), TO_CHAR(?)) AS ROWKEY," +
      "            (SELECT COALESCE(RLT.NAME, RL.NAME) FROM AD_REF_LIST RL LEFT JOIN AD_REF_LIST_TRL RLT on RL.AD_REF_LIST_ID = RLT.AD_REF_LIST_ID AND RLT.AD_LANGUAGE = ?" +
      "             WHERE B.payrule = RL.VALUE AND RL.AD_REFERENCE_ID = '195') AS PAYMENTRULE," +
      "            (SELECT DOCUMENTNO FROM C_SETTLEMENT S1 WHERE S1.C_SETTLEMENT_ID = b.C_SETTLEMENT_CANCEL_ID) AS DEBTCANCEL," +
      "            (SELECT DOCUMENTNO FROM C_SETTLEMENT S2 WHERE S2.C_SETTLEMENT_ID = b.C_SETTLEMENT_GENERATE_ID) AS DEBTGENERATE" +
      "      	FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (" +
      "	        SELECT DP.C_DEBT_PAYMENT_ID, B.NAME AS BPARTNER, I.DOCUMENTNO AS INVOICE, DP.DATEPLANNED," +
      "	        O.DOCUMENTNO AS ORDERNO, DP.AMOUNT, DP.WRITEOFFAMT, C.ISO_CODE AS CURRENCY," +
      "	        dp.paymentrule as payrule, dp.c_settlement_cancel_id, dp.c_settlement_generate_id" +
      "	        FROM C_DEBT_PAYMENT DP left join C_BPARTNER B on DP.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "	                               left join C_INVOICE I  on DP.C_INVOICE_ID = I.C_INVOICE_ID" +
      "	                               left join C_ORDER    O on DP.C_ORDER_ID = O.C_ORDER_ID," +
      "	            C_CURRENCY C" +
      "	        WHERE DP.C_CURRENCY_ID = C.C_CURRENCY_ID " +
      "	        AND DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	        AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "	        AND DP.IsActive='Y'" +
      "	        AND DP.IsValid='Y'";
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND b.C_BPartner_ID=?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND dp.Dateplanned >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND dp.Dateplanned < TO_DATE(?)  ");
    strSql = strSql + ((AmountFrom==null || AmountFrom.equals(""))?"":"  AND dp.amount >= TO_NUMBER(?)  ");
    strSql = strSql + ((AmountTo==null || AmountTo.equals(""))?"":"  AND dp.amount <= TO_NUMBER(?)  ");
    strSql = strSql + ((paymentRule==null || paymentRule.equals(""))?"":"  AND dp.paymentrule = ?  ");
    strSql = strSql + ((isPaid==null || isPaid.equals(""))?"":"  AND dp.ispaid = ?  ");
    strSql = strSql + ((isReceipt==null || isReceipt.equals(""))?"":"  AND dp.isreceipt = ?  ");
    strSql = strSql + ((invoiceId==null || invoiceId.equals("") || invoiceId.equals("%") )?"":"  AND i.documentno like ?  ");
    strSql = strSql + ((orderId==null || orderId.equals("") || orderId.equals("%") )?"":"  AND o.documentno like ?  ");
    strSql = strSql + 
      "            AND CASE" +
      "                  WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "                  WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "                  WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "                  WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "                  ELSE 'P'" +
      "                END ";
    strSql = strSql + ((isPending==null || isPending.equals(""))?"":isPending);
    strSql = strSql + 
      "	        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "	        ) A ) B" +
      "		WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<DebtPaymentData> vector = new Vector<DebtPaymentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (AmountFrom != null && !(AmountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountFrom);
      }
      if (AmountTo != null && !(AmountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountTo);
      }
      if (paymentRule != null && !(paymentRule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentRule);
      }
      if (isPaid != null && !(isPaid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isPaid);
      }
      if (isReceipt != null && !(isReceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isReceipt);
      }
      if (invoiceId != null && !(invoiceId.equals("")) && !(invoiceId.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);
      }
      if (orderId != null && !(orderId.equals("")) && !(orderId.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderId);
      }
      if (isPending != null && !(isPending.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
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
        DebtPaymentData objectDebtPaymentData = new DebtPaymentData();
        objectDebtPaymentData.rn1 = UtilSql.getValue(result, "rn1");
        objectDebtPaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDebtPaymentData.bpartner = UtilSql.getValue(result, "bpartner");
        objectDebtPaymentData.invoice = UtilSql.getValue(result, "invoice");
        objectDebtPaymentData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectDebtPaymentData.orderno = UtilSql.getValue(result, "orderno");
        objectDebtPaymentData.amount = UtilSql.getValue(result, "amount");
        objectDebtPaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectDebtPaymentData.currency = UtilSql.getValue(result, "currency");
        objectDebtPaymentData.payrule = UtilSql.getValue(result, "payrule");
        objectDebtPaymentData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectDebtPaymentData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectDebtPaymentData.rowkey = UtilSql.getValue(result, "rowkey");
        objectDebtPaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectDebtPaymentData.debtcancel = UtilSql.getValue(result, "debtcancel");
        objectDebtPaymentData.debtgenerate = UtilSql.getValue(result, "debtgenerate");
        objectDebtPaymentData.position = Long.toString(countRecord);
        objectDebtPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDebtPaymentData);
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
    DebtPaymentData objectDebtPaymentData[] = new DebtPaymentData[vector.size()];
    vector.copyInto(objectDebtPaymentData);
    return(objectDebtPaymentData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String businesPartner, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isPaid, String isReceipt, String invoiceId, String orderId, String isPending, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	        SELECT COUNT(*) AS value" +
      "	        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.*  FROM ( " +
      "	        SELECT 1 FROM C_DEBT_PAYMENT DP left join C_BPARTNER B on DP.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "	                               left join C_INVOICE I  on DP.C_INVOICE_ID = I.C_INVOICE_ID" +
      "	                               left join C_ORDER    O on DP.C_ORDER_ID = O.C_ORDER_ID" +
      "	        WHERE " +
      "	            DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	        AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "	        AND DP.IsActive='Y'" +
      "	        AND DP.IsValid='Y'";
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND b.C_BPartner_ID = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND dp.Dateplanned >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND dp.Dateplanned < TO_DATE(?)  ");
    strSql = strSql + ((AmountFrom==null || AmountFrom.equals(""))?"":"  AND dp.amount >= TO_NUMBER(?)  ");
    strSql = strSql + ((AmountTo==null || AmountTo.equals(""))?"":"  AND dp.amount <= TO_NUMBER(?)  ");
    strSql = strSql + ((paymentRule==null || paymentRule.equals(""))?"":"  AND dp.paymentrule = ?  ");
    strSql = strSql + ((isPaid==null || isPaid.equals(""))?"":"  AND dp.ispaid = ?  ");
    strSql = strSql + ((isReceipt==null || isReceipt.equals(""))?"":"  AND dp.isreceipt = ?  ");
    strSql = strSql + ((invoiceId==null || invoiceId.equals("") || invoiceId.equals("%") )?"":"  AND i.documentno like ?  ");
    strSql = strSql + ((orderId==null || orderId.equals("") || orderId.equals("%") )?"":"  AND o.documentno like ?  ");
    strSql = strSql + 
      "            AND CASE" +
      "                  WHEN (DP.ISVALID = 'N') THEN 'I'" +
      "                  WHEN (DP.C_CASHLINE_ID IS NOT NULL OR DP.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "                  WHEN (DP.CANCEL_PROCESSED = 'Y' AND DP.ISPAID = 'N') THEN 'W'" +
      "                  WHEN (DP.CANCEL_PROCESSED = 'Y' OR(DP.C_Settlement_Cancel_ID IS NULL AND DP.GENERATE_PROCESSED = 'Y' AND DP.ISPAID = 'Y')) THEN 'A'" +
      "                  ELSE 'P'" +
      "                END ";
    strSql = strSql + ((isPending==null || isPending.equals(""))?"":isPending);
    strSql = strSql + 
      "                 AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "                ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "      ) A ";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" WHERE RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (AmountFrom != null && !(AmountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountFrom);
      }
      if (AmountTo != null && !(AmountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountTo);
      }
      if (paymentRule != null && !(paymentRule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentRule);
      }
      if (isPaid != null && !(isPaid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isPaid);
      }
      if (isReceipt != null && !(isReceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isReceipt);
      }
      if (invoiceId != null && !(invoiceId.equals("")) && !(invoiceId.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);
      }
      if (orderId != null && !(orderId.equals("")) && !(orderId.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderId);
      }
      if (isPending != null && !(isPending.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
