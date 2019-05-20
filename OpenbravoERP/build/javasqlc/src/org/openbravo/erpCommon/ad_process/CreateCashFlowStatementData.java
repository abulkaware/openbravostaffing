//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CreateCashFlowStatementData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateCashFlowStatementData.class);
  private String InitRecordNumber="0";
  public String factAcctId;
  public String amount;
  public String recordId2;
  public String adTableId;
  public String dateacct;
  public String accountId;
  public String cInvoiceId;
  public String cOrderId;
  public String cSettlementGenerateId;
  public String id;
  public String ismanual;
  public String account;
  public String cSettlementCancelId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fact_acct_id") || fieldName.equals("factAcctId"))
      return factAcctId;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("record_id2") || fieldName.equals("recordId2"))
      return recordId2;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_settlement_generate_id") || fieldName.equals("cSettlementGenerateId"))
      return cSettlementGenerateId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("account"))
      return account;
    else if (fieldName.equalsIgnoreCase("c_settlement_cancel_id") || fieldName.equals("cSettlementCancelId"))
      return cSettlementCancelId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateCashFlowStatementData[] select(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return select(connectionProvider, adClientId, 0, 0);
  }

  public static CreateCashFlowStatementData[] select(ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT FACT_ACCT_ID, AMTACCTCR-AMTACCTDR AS AMOUNT, RECORD_ID2," +
      "        FACT_ACCT.AD_TABLE_ID, FACT_ACCT.DATEACCT, ACCOUNT_ID, " +
      "        '' AS C_INVOICE_ID, '' AS C_ORDER_ID, '' AS C_SETTLEMENT_GENERATE_ID, '' AS ID, '' AS ISMANUAL," +
      "        '' AS ACCOUNT, '' AS C_SETTLEMENT_CANCEL_ID" +
      "        FROM FACT_ACCT" +
      "        WHERE AD_TABLE_ID IN ('392', '407')" +
      "        AND LINE_ID IS NOT NULL" +
      "        and AD_CLIENT_ID = ?" +
      "        AND NOT EXISTS (SELECT 1 FROM FACT_ACCT_CFS" +
      "                WHERE FACT_ACCT.FACT_ACCT_ID = FACT_ACCT_CFS.FACT_ACCT_ID)" +
      "        ORDER BY FACT_ACCT.DATEACCT ,FACT_ACCT_ID ";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.factAcctId = UtilSql.getValue(result, "fact_acct_id");
        objectCreateCashFlowStatementData.amount = UtilSql.getValue(result, "amount");
        objectCreateCashFlowStatementData.recordId2 = UtilSql.getValue(result, "record_id2");
        objectCreateCashFlowStatementData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectCreateCashFlowStatementData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectCreateCashFlowStatementData.accountId = UtilSql.getValue(result, "account_id");
        objectCreateCashFlowStatementData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateCashFlowStatementData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateCashFlowStatementData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectCreateCashFlowStatementData.id = UtilSql.getValue(result, "id");
        objectCreateCashFlowStatementData.ismanual = UtilSql.getValue(result, "ismanual");
        objectCreateCashFlowStatementData.account = UtilSql.getValue(result, "account");
        objectCreateCashFlowStatementData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static CreateCashFlowStatementData[] selectPaymentWriteOff(ConnectionProvider connectionProvider, String payment, String settlementCancel)    throws ServletException {
    return selectPaymentWriteOff(connectionProvider, payment, settlementCancel, 0, 0);
  }

  public static CreateCashFlowStatementData[] selectPaymentWriteOff(ConnectionProvider connectionProvider, String payment, String settlementCancel, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ACCOUNT_ID, (AMTACCTCR-AMTACCTDR) AS AMOUNT, FACT_ACCT_ID AS ID" +
      "        FROM FACT_ACCT" +
      "        WHERE AD_TABLE_ID = '800019'" +
      "        AND RECORD_ID2 = ?" +
      "        AND RECORD_ID = ?" +
      "        AND ACCOUNT_ID IN (" +
      "                SELECT ACCOUNT_ID FROM C_ACCTSCHEMA_DEFAULT, C_VALIDCOMBINATION" +
      "                WHERE C_ACCTSCHEMA_DEFAULT.WRITEOFF_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID)";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementCancel);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.accountId = UtilSql.getValue(result, "account_id");
        objectCreateCashFlowStatementData.amount = UtilSql.getValue(result, "amount");
        objectCreateCashFlowStatementData.id = UtilSql.getValue(result, "id");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static String processId(ConnectionProvider connectionProvider, String processId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_PROCESS.AD_PROCESS_ID AS ID" +
      "      FROM AD_PROCESS" +
      "      WHERE VALUE = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static String selectOrderAccount(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ACCOUNT_ID FROM C_ACCTSCHEMA_GL, C_VALIDCOMBINATION" +
      "      WHERE C_ACCTSCHEMA_GL.CFS_ORDER_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "account_id");
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

  public static String selectPaymentAccount(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ACCOUNT_ID FROM C_ACCTSCHEMA_DEFAULT, C_VALIDCOMBINATION" +
      "      WHERE C_ACCTSCHEMA_DEFAULT.W_INVENTORY_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "account_id");
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

  public static CreateCashFlowStatementData[] selectPaymentInfo(ConnectionProvider connectionProvider, String payment)    throws ServletException {
    return selectPaymentInfo(connectionProvider, payment, 0, 0);
  }

  public static CreateCashFlowStatementData[] selectPaymentInfo(ConnectionProvider connectionProvider, String payment, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_INVOICE_ID, C_ORDER_ID, C_SETTLEMENT_GENERATE_ID, C_SETTLEMENT_CANCEL_ID, ISMANUAL" +
      "        FROM C_DEBT_PAYMENT" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateCashFlowStatementData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateCashFlowStatementData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectCreateCashFlowStatementData.cSettlementCancelId = UtilSql.getValue(result, "c_settlement_cancel_id");
        objectCreateCashFlowStatementData.ismanual = UtilSql.getValue(result, "ismanual");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static CreateCashFlowStatementData[] selectCancelledPayments(ConnectionProvider connectionProvider, String settlement)    throws ServletException {
    return selectCancelledPayments(connectionProvider, settlement, 0, 0);
  }

  public static CreateCashFlowStatementData[] selectCancelledPayments(ConnectionProvider connectionProvider, String settlement, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DEBT_PAYMENT_ID AS ID, C_INVOICE_ID, C_ORDER_ID, C_SETTLEMENT_GENERATE_ID, AMTACCTDR-AMTACCTCR AS AMOUNT" +
      "        FROM C_DEBT_PAYMENT, FACT_ACCT" +
      "        WHERE C_SETTLEMENT_CANCEL_ID = ?" +
      "        AND C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID = FACT_ACCT.RECORD_ID2" +
      "        AND AD_TABLE_ID = '800019'" +
      "        AND RECORD_ID = C_SETTLEMENT_CANCEL_ID" +
      "        AND LINE_ID = C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID" +
      "        AND ISPAID = 'N'";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlement);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.id = UtilSql.getValue(result, "id");
        objectCreateCashFlowStatementData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateCashFlowStatementData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateCashFlowStatementData.cSettlementGenerateId = UtilSql.getValue(result, "c_settlement_generate_id");
        objectCreateCashFlowStatementData.amount = UtilSql.getValue(result, "amount");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static String selectSumGeneratedPayments(ConnectionProvider connectionProvider, String settlement)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SUM(AMTACCTCR-AMTACCTDR) AS AMOUNT" +
      "        FROM C_DEBT_PAYMENT, FACT_ACCT" +
      "        WHERE C_SETTLEMENT_GENERATE_ID = ?" +
      "        AND C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID = FACT_ACCT.RECORD_ID2" +
      "        AND AD_TABLE_ID = '800019'" +
      "        AND RECORD_ID = C_SETTLEMENT_GENERATE_ID" +
      "        AND LINE_ID = C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID " +
      "        AND ACCOUNT_ID NOT IN (SELECT C_VALIDCOMBINATION.ACCOUNT_ID FROM C_GLITEM_ACCT, C_DEBT_PAYMENT, C_VALIDCOMBINATION" +
      "                                  WHERE C_GLITEM_ACCT.C_GLITEM_ID = C_DEBT_PAYMENT.C_GLITEM_ID" +
      "                                  AND C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID = C_GLITEM_ACCT.GLITEM_CREDIT_ACCT" +
      "                                  AND C_DEBT_PAYMENT_ID = RECORD_ID2)" +
      "        AND ACCOUNT_ID NOT IN (SELECT C_VALIDCOMBINATION.ACCOUNT_ID FROM C_GLITEM_ACCT, C_DEBT_PAYMENT, C_VALIDCOMBINATION" +
      "                                  WHERE C_GLITEM_ACCT.C_GLITEM_ID = C_DEBT_PAYMENT.C_GLITEM_ID" +
      "                                  AND C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID = C_GLITEM_ACCT.GLITEM_DEBIT_ACCT" +
      "                                  AND C_DEBT_PAYMENT_ID = RECORD_ID2)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlement);

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

  public static CreateCashFlowStatementData[] selectGLItemsSettlementCancel(ConnectionProvider connectionProvider, String settlement, String payment)    throws ServletException {
    return selectGLItemsSettlementCancel(connectionProvider, settlement, payment, 0, 0);
  }

  public static CreateCashFlowStatementData[] selectGLItemsSettlementCancel(ConnectionProvider connectionProvider, String settlement, String payment, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ACCOUNT_ID AS ACCOUNT, AMTACCTDR-AMTACCTCR AS AMOUNT, FACT_ACCT_ID AS ID" +
      "        FROM FACT_ACCT" +
      "        WHERE RECORD_ID = ?" +
      "        AND AD_TABLE_ID = '800019'" +
      "        AND RECORD_ID2 = ?" +
      "        AND ACCOUNT_ID NOT IN (SELECT ACCOUNT_ID FROM FACT_ACCT" +
      "                                          WHERE AD_TABLE_ID IN ('392','407')" +
      "                                          AND RECORD_ID2 = ?)";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.account = UtilSql.getValue(result, "account");
        objectCreateCashFlowStatementData.amount = UtilSql.getValue(result, "amount");
        objectCreateCashFlowStatementData.id = UtilSql.getValue(result, "id");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static String selectSumGLItemsCancel(ConnectionProvider connectionProvider, String settlement, String payment)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT sum(AMTACCTDR-AMTACCTCR) AS AMOUNT" +
      "        FROM FACT_ACCT" +
      "        WHERE RECORD_ID = ?" +
      "        AND AD_TABLE_ID = '800019'" +
      "        AND RECORD_ID2 = ?" +
      "        AND ACCOUNT_ID NOT IN (SELECT ACCOUNT_ID FROM FACT_ACCT" +
      "                                          WHERE AD_TABLE_ID IN ('392','407')" +
      "                                          AND RECORD_ID2 = ?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);

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

  public static CreateCashFlowStatementData[] selectGLItemsSettlementGenerate(ConnectionProvider connectionProvider, String settlement, String payment)    throws ServletException {
    return selectGLItemsSettlementGenerate(connectionProvider, settlement, payment, 0, 0);
  }

  public static CreateCashFlowStatementData[] selectGLItemsSettlementGenerate(ConnectionProvider connectionProvider, String settlement, String payment, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ACCOUNT_ID AS ACCOUNT, AMTACCTDR-AMTACCTCR AS AMOUNT, FACT_ACCT_ID AS ID" +
      "        FROM FACT_ACCT" +
      "        WHERE RECORD_ID =   ?" +
      "        AND AD_TABLE_ID = '800019'" +
      "        AND RECORD_ID2 = 	?" +
      "        AND ACCOUNT_ID NOT IN (SELECT C_VALIDCOMBINATION.ACCOUNT_ID FROM C_GLITEM_ACCT, C_DEBT_PAYMENT, C_VALIDCOMBINATION" +
      "                                          WHERE C_GLITEM_ACCT.C_GLITEM_ID = C_DEBT_PAYMENT.C_GLITEM_ID" +
      "                                          AND C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID = C_GLITEM_ACCT.GLITEM_CREDIT_ACCT" +
      "                                          AND C_DEBT_PAYMENT_ID = ?)" +
      "        AND ACCOUNT_ID NOT IN (SELECT C_VALIDCOMBINATION.ACCOUNT_ID FROM C_GLITEM_ACCT, C_DEBT_PAYMENT, C_VALIDCOMBINATION" +
      "                                          WHERE C_GLITEM_ACCT.C_GLITEM_ID = C_DEBT_PAYMENT.C_GLITEM_ID" +
      "                                          AND C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID = C_GLITEM_ACCT.GLITEM_DEBIT_ACCT" +
      "                                          AND C_DEBT_PAYMENT_ID = ?)";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.account = UtilSql.getValue(result, "account");
        objectCreateCashFlowStatementData.amount = UtilSql.getValue(result, "amount");
        objectCreateCashFlowStatementData.id = UtilSql.getValue(result, "id");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static String selectSumGLItemsGenerate(ConnectionProvider connectionProvider, String settlement, String payment)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT sum(AMTACCTDR-AMTACCTCR) AS AMOUNT" +
      "        FROM FACT_ACCT" +
      "        WHERE RECORD_ID =   ?" +
      "        AND AD_TABLE_ID = '800019'" +
      "        AND RECORD_ID2 = 	?" +
      "        AND ACCOUNT_ID NOT IN (SELECT C_VALIDCOMBINATION.ACCOUNT_ID FROM C_GLITEM_ACCT, C_DEBT_PAYMENT, C_VALIDCOMBINATION" +
      "                                          WHERE C_GLITEM_ACCT.C_GLITEM_ID = C_DEBT_PAYMENT.C_GLITEM_ID" +
      "                                          AND C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID = C_GLITEM_ACCT.GLITEM_CREDIT_ACCT" +
      "                                          AND C_DEBT_PAYMENT_ID = ?)" +
      "        AND ACCOUNT_ID NOT IN (SELECT C_VALIDCOMBINATION.ACCOUNT_ID FROM C_GLITEM_ACCT, C_DEBT_PAYMENT, C_VALIDCOMBINATION" +
      "                                          WHERE C_GLITEM_ACCT.C_GLITEM_ID = C_DEBT_PAYMENT.C_GLITEM_ID" +
      "                                          AND C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID = C_GLITEM_ACCT.GLITEM_DEBIT_ACCT" +
      "                                          AND C_DEBT_PAYMENT_ID = ?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payment);

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

  public static int insertStatements(Connection conn, ConnectionProvider connectionProvider, String factAcctCFS, String factAcctId, String adClientId, String adOrgId, String user, String accountId, String amount, String factAcctRef)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO FACT_ACCT_CFS" +
      "        (FACT_ACCT_CFS_ID,  FACT_ACCT_ID,  AD_CLIENT_ID,  AD_ORG_ID,  ISACTIVE,  CREATED,  CREATEDBY,  UPDATED,  UPDATEDBY,  ACCOUNT_ID,  AMOUNT, FACT_ACCT_REF_ID)" +
      "        VALUES" +
      "        (?,?,?,?,'Y',NOW(),?,NOW(),?,?,TO_NUMBER(?),?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctCFS);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctRef);

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

  public static CreateCashFlowStatementData[] selectStatements(ConnectionProvider connectionProvider, String table, String record)    throws ServletException {
    return selectStatements(connectionProvider, table, record, 0, 0);
  }

  public static CreateCashFlowStatementData[] selectStatements(ConnectionProvider connectionProvider, String table, String record, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ACCOUNT_ID, AMTACCTDR-AMTACCTCR AS AMOUNT, FACT_ACCT_ID AS ID" +
      "        FROM FACT_ACCT" +
      "        WHERE AD_TABLE_ID = ?" +
      "        AND RECORD_ID = ?" +
      "        AND RECORD_ID2 IS NULL";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, table);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, record);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.accountId = UtilSql.getValue(result, "account_id");
        objectCreateCashFlowStatementData.amount = UtilSql.getValue(result, "amount");
        objectCreateCashFlowStatementData.id = UtilSql.getValue(result, "id");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static String selectSumStatements(ConnectionProvider connectionProvider, String table, String record)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select sum(AmtAcctDr-AmtAcctCr) as amount" +
      "        from fact_acct" +
      "        where ad_table_id = ?" +
      "        and record_id = ?" +
      "        and record_id2 is null";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, table);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, record);

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

  public static String selectCheckDifference(Connection conn, ConnectionProvider connectionProvider, String factAcctId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select max(amtacctCr-amtacctDr)-sum(fact_acct_CFS.amount) as Difference" +
      "        from fact_acct, fact_acct_CFS " +
      "        where fact_acct.fact_acct_id = fact_acct_CFS.fact_acct_id " +
      "        AND fact_acct.fact_acct_id = ?" +
      "        group by fact_acct.fact_acct_id ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "difference");
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
    return(strReturn);
  }

  public static CreateCashFlowStatementData[] selectGetMaxId(Connection conn, ConnectionProvider connectionProvider, String factAcctId)    throws ServletException {
    return selectGetMaxId(conn, connectionProvider, factAcctId, 0, 0);
  }

  public static CreateCashFlowStatementData[] selectGetMaxId(Connection conn, ConnectionProvider connectionProvider, String factAcctId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select fact_acct_CFS.FACT_ACCT_CFS_ID as ID, amount" +
      "        from fact_acct, fact_acct_CFS " +
      "        where fact_acct.fact_acct_id = fact_acct_CFS.fact_acct_id " +
      "        AND fact_acct.fact_acct_id = ? " +
      "        order by abs(fact_acct_CFS.amount) desc";

    ResultSet result;
    Vector<CreateCashFlowStatementData> vector = new Vector<CreateCashFlowStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);

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
        CreateCashFlowStatementData objectCreateCashFlowStatementData = new CreateCashFlowStatementData();
        objectCreateCashFlowStatementData.id = UtilSql.getValue(result, "id");
        objectCreateCashFlowStatementData.amount = UtilSql.getValue(result, "amount");
        objectCreateCashFlowStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateCashFlowStatementData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CreateCashFlowStatementData objectCreateCashFlowStatementData[] = new CreateCashFlowStatementData[vector.size()];
    vector.copyInto(objectCreateCashFlowStatementData);
    return(objectCreateCashFlowStatementData);
  }

  public static int updateDifference(Connection conn, ConnectionProvider connectionProvider, String difference, String factAcctCFSId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        update fact_acct_CFS set amount = TO_NUMBER(?) + amount" +
      "        where fact_acct_CFS_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, difference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctCFSId);

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
