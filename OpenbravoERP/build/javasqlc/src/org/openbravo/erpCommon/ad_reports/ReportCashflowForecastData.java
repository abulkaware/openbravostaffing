//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
Clase ReportToInvoiceConsignmentData
 */
class ReportCashflowForecastData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportCashflowForecastData.class);
  private String InitRecordNumber="0";
  public String bankaccount;
  public String initialbalance;
  public String currentdate;
  public String income;
  public String payment;
  public String incpay;
  public String finalsummary;
  public String cBankaccountId;
  public String cDebtPaymentId;
  public String dateplanned;
  public String bpartner;
  public String description;
  public String invoiceno;
  public String dateinvoiced;
  public String amount;
  public String isreceipt;
  public String url;
  public String isreceiptmessage;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("bankaccount"))
      return bankaccount;
    else if (fieldName.equalsIgnoreCase("initialbalance"))
      return initialbalance;
    else if (fieldName.equalsIgnoreCase("currentdate"))
      return currentdate;
    else if (fieldName.equalsIgnoreCase("income"))
      return income;
    else if (fieldName.equalsIgnoreCase("payment"))
      return payment;
    else if (fieldName.equalsIgnoreCase("incpay"))
      return incpay;
    else if (fieldName.equalsIgnoreCase("finalsummary"))
      return finalsummary;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("invoiceno"))
      return invoiceno;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("isreceiptmessage"))
      return isreceiptmessage;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportCashflowForecastData[] select(ConnectionProvider connectionProvider, String language, String dateMax, String bankaccount, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, language, dateMax, bankaccount, adUserClient, adUserOrg, 0, 0);
  }

  public static ReportCashflowForecastData[] select(ConnectionProvider connectionProvider, String language, String dateMax, String bankaccount, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_COLUMN_IDENTIFIER(TO_CHAR('C_BankAccount'), TO_CHAR(BANKACCOUNTID), TO_CHAR(?)) as BANKACCOUNT, " +
      "             INITIALBALANCE," +
      "             TRUNC(NOW()) AS CURRENTDATE, " +
      "             INCOME, " +
      "             PAYMENT, " +
      "             INCOME-PAYMENT AS INCPAY, " +
      "             INITIALBALANCE+INCOME-PAYMENT AS " +
      "             FINALSUMMARY, C_BANKACCOUNT_ID,             " +
      "             '' AS C_DEBT_PAYMENT_ID, " +
      "             '' AS DATEPLANNED, " +
      "             '' AS BPARTNER," +
      "             '' AS DESCRIPTION, " +
      "             '' AS INVOICENO, " +
      "             '' AS DATEINVOICED," +
      "             '' AS AMOUNT," +
      "             '' AS ISRECEIPT," +
      "             '' AS URL," +
      "             '' AS ISRECEIPTMESSAGE FROM (     " +
      "            SELECT BA.C_BANKACCOUNT_ID AS BANKACCOUNTID," +
      "             SUM(c_currency_convert(STMTAMT, BL.C_CURRENCY_ID, BA.C_CURRENCY_ID, BL.VALUTADATE, NULL, ba.ad_client_id, ba.ad_org_id)) AS INITIALBALANCE," +
      "             COALESCE((SELECT SUM(c_currency_convert(DP.AMOUNT, dp.C_CURRENCY_ID, ba.c_Currency_ID, dp.dateplanned,null, ba.ad_client_id, ba.ad_org_id))" +
      "                FROM C_DEBT_PAYMENT_V DP" +
      "               WHERE C_SETTLEMENT_CANCEL_ID IS NULL" +
      "                 AND DP.C_BANKACCOUNT_ID IS NOT NULL         " +
      "                 AND C_DEBT_PAYMENT_STATUS(C_SETTLEMENT_CANCEL_ID, CANCEL_PROCESSED, GENERATE_PROCESSED, DP.ISPAID, ISVALID, C_CASHLINE_ID, C_BANKSTATEMENTLINE_ID) = 'P'" +
      "                 AND ISRECEIPT = 'Y'" +
      "                 AND DP.C_BANKACCOUNT_ID = BA.C_BANKACCOUNT_ID" +
      "                 AND 1=1";
    strSql = strSql + ((dateMax==null || dateMax.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + 
      "                 AND NOT EXISTS (SELECT 1 " +
      "                           FROM C_REMITTANCELINE  RL," +
      "                                C_REMITTANCE      R," +
      "                                C_REMITTANCE_TYPE RT" +
      "                          WHERE R.C_REMITTANCE_ID = RL.C_REMITTANCE_ID" +
      "                            AND R.C_REMITTANCE_TYPE_ID = RT.C_REMITTANCE_TYPE_ID" +
      "                            AND CONSOLIDATE = 'Y' " +
      "                            AND (C_DEBT_PAYMENT_ID  = DP.C_DEBT_PAYMENT_ID" +
      "                             OR C_DEBT_PAYMENT_CANCELLED = DP.C_DEBT_PAYMENT_ID)" +
      "                            AND NOT EXISTS (SELECT 1   /*IF CANCEL DP IS IN BANK (IT IS RETURNED) IT HAS TO APPEAR*/" +
      "                                              FROM C_BANKSTATEMENTLINE BSL," +
      "                                                   C_BANKSTATEMENT B" +
      "                                            WHERE BSL.C_DEBT_PAYMENT_ID = RL.C_DEBT_PAYMENT_CANCELLED" +
      "                                              AND BSL.C_BANKSTATEMENT_ID = B.C_BANKSTATEMENT_ID" +
      "                                              AND B.PROCESSED='Y'))" +
      "              ),0) AS INCOME," +
      "            -COALESCE((SELECT SUM(c_currency_convert(DP.AMOUNT, dp.C_CURRENCY_ID, ba.c_Currency_ID, dp.dateplanned,null, ba.ad_client_id, ba.ad_org_id))" +
      "                FROM C_DEBT_PAYMENT_V DP" +
      "               WHERE C_SETTLEMENT_CANCEL_ID IS NULL" +
      "                 AND DP.C_BANKACCOUNT_ID IS NOT NULL         " +
      "                 AND C_DEBT_PAYMENT_STATUS(C_SETTLEMENT_CANCEL_ID, CANCEL_PROCESSED, GENERATE_PROCESSED, DP.ISPAID, ISVALID, C_CASHLINE_ID, C_BANKSTATEMENTLINE_ID) = 'P'" +
      "                 AND ISRECEIPT='N'" +
      "                 AND DP.C_BANKACCOUNT_ID = BA.C_BANKACCOUNT_ID" +
      "                 AND 2=2";
    strSql = strSql + ((dateMax==null || dateMax.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + 
      "                 AND NOT EXISTS (SELECT 1 " +
      "                           FROM C_REMITTANCELINE  RL," +
      "                                C_REMITTANCE      R," +
      "                                C_REMITTANCE_TYPE RT" +
      "                          WHERE R.C_REMITTANCE_ID = RL.C_REMITTANCE_ID" +
      "                            AND R.C_REMITTANCE_TYPE_ID = RT.C_REMITTANCE_TYPE_ID" +
      "                            AND CONSOLIDATE = 'Y' " +
      "                            AND (C_DEBT_PAYMENT_ID  = DP.C_DEBT_PAYMENT_ID" +
      "                             OR C_DEBT_PAYMENT_CANCELLED = DP.C_DEBT_PAYMENT_ID)" +
      "                            AND NOT EXISTS (SELECT 1   /*IF CANCEL DP IS IN BANK (IT IS RETURNED) IT HAS TO APPEAR*/" +
      "                                              FROM C_BANKSTATEMENTLINE BSL," +
      "                                                   C_BANKSTATEMENT B" +
      "                                            WHERE BSL.C_DEBT_PAYMENT_ID = RL.C_DEBT_PAYMENT_CANCELLED" +
      "                                              AND BSL.C_BANKSTATEMENT_ID = B.C_BANKSTATEMENT_ID" +
      "                                              AND B.PROCESSED='Y'))" +
      "               ),0) AS PAYMENT," +
      "             BA.C_BANKACCOUNT_ID" +
      "      FROM C_BANKSTATEMENTLINE BL," +
      "           C_BANKSTATEMENT     BS," +
      "           C_BANKACCOUNT       BA" +
      "      WHERE BS.C_BANKSTATEMENT_ID = BL.C_BANKSTATEMENT_ID" +
      "        AND BA.C_BANKACCOUNT_ID = BS.C_BANKACCOUNT_ID" +
      "        AND BS.PROCESSED='Y'  " +
      "        AND BS.STATEMENTDATE <= NOW()" +
      "        AND 3=3";
    strSql = strSql + ((bankaccount==null || bankaccount.equals(""))?"":"  AND BA.C_BANKACCOUNT_ID = ?  ");
    strSql = strSql + 
      "        AND BA.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND BA.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "       GROUP BY BA.C_BANKACCOUNT_ID, ba.c_Currency_ID, ba.ad_client_id, ba.ad_org_id " +
      "       ) AAA  " +
      "       ORDER BY 1";

    ResultSet result;
    Vector<ReportCashflowForecastData> vector = new Vector<ReportCashflowForecastData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (dateMax != null && !(dateMax.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateMax);
      }
      if (dateMax != null && !(dateMax.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateMax);
      }
      if (bankaccount != null && !(bankaccount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccount);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        ReportCashflowForecastData objectReportCashflowForecastData = new ReportCashflowForecastData();
        objectReportCashflowForecastData.bankaccount = UtilSql.getValue(result, "bankaccount");
        objectReportCashflowForecastData.initialbalance = UtilSql.getValue(result, "initialbalance");
        objectReportCashflowForecastData.currentdate = UtilSql.getDateValue(result, "currentdate", "dd-MM-yyyy");
        objectReportCashflowForecastData.income = UtilSql.getValue(result, "income");
        objectReportCashflowForecastData.payment = UtilSql.getValue(result, "payment");
        objectReportCashflowForecastData.incpay = UtilSql.getValue(result, "incpay");
        objectReportCashflowForecastData.finalsummary = UtilSql.getValue(result, "finalsummary");
        objectReportCashflowForecastData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectReportCashflowForecastData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectReportCashflowForecastData.dateplanned = UtilSql.getValue(result, "dateplanned");
        objectReportCashflowForecastData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportCashflowForecastData.description = UtilSql.getValue(result, "description");
        objectReportCashflowForecastData.invoiceno = UtilSql.getValue(result, "invoiceno");
        objectReportCashflowForecastData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectReportCashflowForecastData.amount = UtilSql.getValue(result, "amount");
        objectReportCashflowForecastData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectReportCashflowForecastData.url = UtilSql.getValue(result, "url");
        objectReportCashflowForecastData.isreceiptmessage = UtilSql.getValue(result, "isreceiptmessage");
        objectReportCashflowForecastData.rownum = Long.toString(countRecord);
        objectReportCashflowForecastData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportCashflowForecastData);
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
    ReportCashflowForecastData objectReportCashflowForecastData[] = new ReportCashflowForecastData[vector.size()];
    vector.copyInto(objectReportCashflowForecastData);
    return(objectReportCashflowForecastData);
  }

  public static ReportCashflowForecastData[] selectLines(ConnectionProvider connectionProvider, String dateFormat, String language, String bankaccount, String dateMax, String order)    throws ServletException {
    return selectLines(connectionProvider, dateFormat, language, bankaccount, dateMax, order, 0, 0);
  }

  public static ReportCashflowForecastData[] selectLines(ConnectionProvider connectionProvider, String dateFormat, String language, String bankaccount, String dateMax, String order, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DATEPLANNED, " +
      "              ISRECEIPT," +
      "              COALESCE(mt.msgtext,m.msgtext) as IsReceiptMessage, " +
      "              DP.C_DEBT_PAYMENT_ID, " +
      "              BP.NAME AS BPARTNER," +
      "              DP.DESCRIPTION, " +
      "              I.DOCUMENTNO AS INVOICENO, " +
      "              TO_CHAR(I.DATEINVOICED,TO_CHAR(?)) AS DATEINVOICED," +
      "              c_currency_convert(DP.AMOUNT, dp.C_CURRENCY_ID, ba.c_Currency_ID, dp.dateplanned,null, ba.ad_client_id, ba.ad_org_id) AS AMOUNT," +
      "              (CASE WHEN DP.C_Invoice_ID IS NOT NULL" +
      "                THEN (CASE ISRECEIPT WHEN 'Y' THEN 'SalesInvoice/Payment_Relation.html' WHEN 'N' THEN 'PurchaseInvoice/Payment_Relation.html' END) " +
      "               ELSE" +
      "                CASE WHEN DP.C_Order_ID IS NOT NULL" +
      "                  THEN (CASE ISRECEIPT WHEN 'Y' THEN 'SalesOrder/Payment_Relation.html' WHEN 'N' THEN 'PurchaseOrder/Payment_Relation.html' END)" +
      "                ELSE" +
      "                  CASE WHEN DP.C_Settlement_Generate_ID IS NOT NULL" +
      "                    THEN 'Settlement/CreatedPayments_Relation.html'" +
      "                  END                  " +
      "                END" +
      "               END) AS URL," +
      "              (SELECT SUM(c_currency_convert(STMTAMT, BL.C_CURRENCY_ID, BA.C_CURRENCY_ID, BL.VALUTADATE, NULL, ba.ad_client_id, ba.ad_org_id)) AS BALANCE             " +
      "                 FROM C_BANKSTATEMENTLINE BL," +
      "                      C_BANKSTATEMENT     BS" +
      "                 WHERE BS.C_BANKSTATEMENT_ID = BL.C_BANKSTATEMENT_ID" +
      "                   AND BS.PROCESSED='Y'  " +
      "                   AND BS.STATEMENTDATE <= NOW()" +
      "                   AND BS.C_BANKACCOUNT_ID = DP.C_BANKACCOUNT_ID ) as initialbalance" +
      "        FROM C_DEBT_PAYMENT_V DP LEFT JOIN C_INVOICE I ON DP.C_INVOICE_ID = I.C_INVOICE_ID," +
      "             AD_MESSAGE M        LEFT JOIN AD_MESSAGE_TRL MT ON m.ad_message_id = mt.ad_message_id         " +
      "                                                            and mt.ad_language = ?," +
      "             C_BPARTNER BP," +
      "             C_BANKACCOUNT       BA             " +
      "       WHERE BA.C_BANKACCOUNT_ID = DP.C_BANKACCOUNT_ID" +
      "         AND C_SETTLEMENT_CANCEL_ID IS NULL" +
      "         AND DP.C_BANKACCOUNT_ID IS NOT NULL         " +
      "         AND C_DEBT_PAYMENT_STATUS(C_SETTLEMENT_CANCEL_ID, CANCEL_PROCESSED, GENERATE_PROCESSED, DP.ISPAID, ISVALID, C_CASHLINE_ID, C_BANKSTATEMENTLINE_ID) = 'P'" +
      "         AND BP.C_BPARTNER_ID = DP.C_BPARTNER_ID" +
      "         AND DP.C_BANKACCOUNT_ID = ?" +
      "         AND M.VALUE = (CASE DP.ISRECEIPT WHEN 'Y' THEN 'Income' WHEN 'N' THEN 'Payments' END)" +
      "         AND NOT EXISTS (SELECT 1 " +
      "                           FROM C_REMITTANCELINE  RL," +
      "                                C_REMITTANCE      R," +
      "                                C_REMITTANCE_TYPE RT" +
      "                          WHERE R.C_REMITTANCE_ID = RL.C_REMITTANCE_ID" +
      "                            AND R.C_REMITTANCE_TYPE_ID = RT.C_REMITTANCE_TYPE_ID" +
      "                            AND CONSOLIDATE = 'Y' " +
      "                            AND (C_DEBT_PAYMENT_ID  = DP.C_DEBT_PAYMENT_ID" +
      "                             OR C_DEBT_PAYMENT_CANCELLED = DP.C_DEBT_PAYMENT_ID)" +
      "                            AND NOT EXISTS (SELECT 1   /*IF CANCEL DP IS IN BANK (IT IS RETURNED) IT HAS TO APPEAR*/" +
      "                                              FROM C_BANKSTATEMENTLINE BSL," +
      "                                                   C_BANKSTATEMENT B" +
      "                                            WHERE BSL.C_DEBT_PAYMENT_ID = RL.C_DEBT_PAYMENT_CANCELLED" +
      "                                              AND BSL.C_BANKSTATEMENT_ID = B.C_BANKSTATEMENT_ID" +
      "                                              AND B.PROCESSED='Y'))" +
      "         AND 1=1";
    strSql = strSql + ((dateMax==null || dateMax.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + 
      "       ORDER BY ";
    strSql = strSql + ((order==null || order.equals(""))?"":order);

    ResultSet result;
    Vector<ReportCashflowForecastData> vector = new Vector<ReportCashflowForecastData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccount);
      if (dateMax != null && !(dateMax.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateMax);
      }
      if (order != null && !(order.equals(""))) {
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
        ReportCashflowForecastData objectReportCashflowForecastData = new ReportCashflowForecastData();
        objectReportCashflowForecastData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectReportCashflowForecastData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectReportCashflowForecastData.isreceiptmessage = UtilSql.getValue(result, "isreceiptmessage");
        objectReportCashflowForecastData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectReportCashflowForecastData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportCashflowForecastData.description = UtilSql.getValue(result, "description");
        objectReportCashflowForecastData.invoiceno = UtilSql.getValue(result, "invoiceno");
        objectReportCashflowForecastData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectReportCashflowForecastData.amount = UtilSql.getValue(result, "amount");
        objectReportCashflowForecastData.url = UtilSql.getValue(result, "url");
        objectReportCashflowForecastData.initialbalance = UtilSql.getValue(result, "initialbalance");
        objectReportCashflowForecastData.rownum = Long.toString(countRecord);
        objectReportCashflowForecastData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportCashflowForecastData);
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
    ReportCashflowForecastData objectReportCashflowForecastData[] = new ReportCashflowForecastData[vector.size()];
    vector.copyInto(objectReportCashflowForecastData);
    return(objectReportCashflowForecastData);
  }

  public static String getDate(ConnectionProvider connectionProvider, String dateFormat)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT TO_CHAR(NOW(),TO_CHAR(?)) AS CURRENTDATE FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "currentdate");
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

  public static ReportCashflowForecastData[] selectAllLines(ConnectionProvider connectionProvider, String dateFormat, String language, String bankaccount, String dateMax, String order)    throws ServletException {
    return selectAllLines(connectionProvider, dateFormat, language, bankaccount, dateMax, order, 0, 0);
  }

  public static ReportCashflowForecastData[] selectAllLines(ConnectionProvider connectionProvider, String dateFormat, String language, String bankaccount, String dateMax, String order, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (B.CODEBANK || '/' || B.CODEBRANCH || B.DIGITCONTROL || BA.CODEACCOUNT || '.' || BA.DIGITCONTROL) AS BANKACCOUNT," +
      "              DATEPLANNED, " +
      "              ISRECEIPT, " +
      "              COALESCE(mt.msgtext,m.msgtext) as IsReceiptMessage, " +
      "              DP.C_DEBT_PAYMENT_ID, " +
      "              BP.NAME AS BPARTNER," +
      "              DP.DESCRIPTION, " +
      "              I.DOCUMENTNO AS INVOICENO, " +
      "              TO_CHAR(I.DATEINVOICED,TO_CHAR(?)) AS DATEINVOICED," +
      "              c_currency_convert(DP.AMOUNT, dp.C_CURRENCY_ID, ba.c_Currency_ID, dp.dateplanned,null, ba.ad_client_id, ba.ad_org_id) AS AMOUNT," +
      "              (CASE WHEN DP.C_Invoice_ID IS NOT NULL" +
      "                THEN (CASE ISRECEIPT WHEN 'Y' THEN 'SalesInvoice/Payment_Relation.html' WHEN 'N' THEN 'PurchaseInvoice/Payment_Relation.html' END) " +
      "               ELSE" +
      "                CASE WHEN DP.C_Order_ID IS NOT NULL" +
      "                  THEN (CASE ISRECEIPT WHEN 'Y' THEN 'SalesOrder/Payment_Relation.html' WHEN 'N' THEN 'PurchaseOrder/Payment_Relation.html' END)" +
      "                ELSE" +
      "                  CASE WHEN DP.C_Settlement_Generate_ID IS NOT NULL" +
      "                    THEN 'Settlement/CreatedPayments_Relation.html'" +
      "                  END                  " +
      "                END" +
      "               END) AS URL," +
      "              (SELECT SUM(c_currency_convert(STMTAMT, BL.C_CURRENCY_ID, BA.C_CURRENCY_ID, BL.VALUTADATE, NULL, ba.ad_client_id, ba.ad_org_id)) AS BALANCE             " +
      "                 FROM C_BANKSTATEMENTLINE BL," +
      "                      C_BANKSTATEMENT     BS" +
      "                 WHERE BS.C_BANKSTATEMENT_ID = BL.C_BANKSTATEMENT_ID" +
      "                   AND BS.PROCESSED='Y'  " +
      "                   AND BS.STATEMENTDATE <= NOW()" +
      "                   AND BS.C_BANKACCOUNT_ID = DP.C_BANKACCOUNT_ID ) as initialbalance" +
      "        FROM C_DEBT_PAYMENT_V DP LEFT JOIN C_INVOICE I ON DP.C_INVOICE_ID = I.C_INVOICE_ID," +
      "             AD_MESSAGE M        LEFT JOIN AD_MESSAGE_TRL MT ON m.ad_message_id = mt.ad_message_id         " +
      "                                                            and mt.ad_language = ?," +
      "             C_BPARTNER BP," +
      "             C_BANKACCOUNT       BA," +
      "             C_BANK              B             " +
      "       WHERE BA.C_BANKACCOUNT_ID = DP.C_BANKACCOUNT_ID" +
      "         AND C_SETTLEMENT_CANCEL_ID IS NULL" +
      "         AND BA.C_BANK_ID = B.C_BANK_ID " +
      "         AND DP.C_BANKACCOUNT_ID IS NOT NULL         " +
      "         AND C_DEBT_PAYMENT_STATUS(C_SETTLEMENT_CANCEL_ID, CANCEL_PROCESSED, GENERATE_PROCESSED, DP.ISPAID, ISVALID, C_CASHLINE_ID, C_BANKSTATEMENTLINE_ID) = 'P'" +
      "         AND BP.C_BPARTNER_ID = DP.C_BPARTNER_ID" +
      "         AND 2=2";
    strSql = strSql + ((bankaccount==null || bankaccount.equals(""))?"":" AND DP.C_BANKACCOUNT_ID = ? ");
    strSql = strSql + 
      "         AND M.VALUE = (CASE DP.ISRECEIPT WHEN 'Y' THEN 'Income' WHEN 'N' THEN 'Payments' END)" +
      "         AND NOT EXISTS (SELECT 1 " +
      "                           FROM C_REMITTANCELINE  RL," +
      "                                C_REMITTANCE      R," +
      "                                C_REMITTANCE_TYPE RT" +
      "                          WHERE R.C_REMITTANCE_ID = RL.C_REMITTANCE_ID" +
      "                            AND R.C_REMITTANCE_TYPE_ID = RT.C_REMITTANCE_TYPE_ID" +
      "                            AND CONSOLIDATE = 'Y' " +
      "                            AND (C_DEBT_PAYMENT_ID  = DP.C_DEBT_PAYMENT_ID" +
      "                             OR C_DEBT_PAYMENT_CANCELLED = DP.C_DEBT_PAYMENT_ID)" +
      "                            AND NOT EXISTS (SELECT 1   /*IF CANCEL DP IS IN BANK (IT IS RETURNED) IT HAS TO APPEAR*/" +
      "                                              FROM C_BANKSTATEMENTLINE BSL," +
      "                                                   C_BANKSTATEMENT B" +
      "                                            WHERE BSL.C_DEBT_PAYMENT_ID = RL.C_DEBT_PAYMENT_CANCELLED" +
      "                                              AND BSL.C_BANKSTATEMENT_ID = B.C_BANKSTATEMENT_ID" +
      "                                              AND B.PROCESSED='Y'))" +
      "         AND 1=1";
    strSql = strSql + ((dateMax==null || dateMax.equals(""))?"":"  AND DP.DATEPLANNED <= TO_DATE(?) ");
    strSql = strSql + 
      "       ORDER BY ";
    strSql = strSql + ((order==null || order.equals(""))?"":order);

    ResultSet result;
    Vector<ReportCashflowForecastData> vector = new Vector<ReportCashflowForecastData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (bankaccount != null && !(bankaccount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccount);
      }
      if (dateMax != null && !(dateMax.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateMax);
      }
      if (order != null && !(order.equals(""))) {
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
        ReportCashflowForecastData objectReportCashflowForecastData = new ReportCashflowForecastData();
        objectReportCashflowForecastData.bankaccount = UtilSql.getValue(result, "bankaccount");
        objectReportCashflowForecastData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectReportCashflowForecastData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectReportCashflowForecastData.isreceiptmessage = UtilSql.getValue(result, "isreceiptmessage");
        objectReportCashflowForecastData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectReportCashflowForecastData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportCashflowForecastData.description = UtilSql.getValue(result, "description");
        objectReportCashflowForecastData.invoiceno = UtilSql.getValue(result, "invoiceno");
        objectReportCashflowForecastData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectReportCashflowForecastData.amount = UtilSql.getValue(result, "amount");
        objectReportCashflowForecastData.url = UtilSql.getValue(result, "url");
        objectReportCashflowForecastData.initialbalance = UtilSql.getValue(result, "initialbalance");
        objectReportCashflowForecastData.rownum = Long.toString(countRecord);
        objectReportCashflowForecastData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportCashflowForecastData);
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
    ReportCashflowForecastData objectReportCashflowForecastData[] = new ReportCashflowForecastData[vector.size()];
    vector.copyInto(objectReportCashflowForecastData);
    return(objectReportCashflowForecastData);
  }
}
