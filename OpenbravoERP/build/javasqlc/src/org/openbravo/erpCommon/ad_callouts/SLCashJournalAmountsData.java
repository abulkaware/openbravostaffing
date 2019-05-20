//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SLCashJournalAmountsData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLCashJournalAmountsData.class);
  private String InitRecordNumber="0";
  public String mProductId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLCashJournalAmountsData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SLCashJournalAmountsData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT m_product_id FROM m_product ";

    ResultSet result;
    Vector<SLCashJournalAmountsData> vector = new Vector<SLCashJournalAmountsData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        SLCashJournalAmountsData objectSLCashJournalAmountsData = new SLCashJournalAmountsData();
        objectSLCashJournalAmountsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSLCashJournalAmountsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLCashJournalAmountsData);
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
    SLCashJournalAmountsData objectSLCashJournalAmountsData[] = new SLCashJournalAmountsData[vector.size()];
    vector.copyInto(objectSLCashJournalAmountsData);
    return(objectSLCashJournalAmountsData);
  }

  public static String amountOrder(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE ISSOTRX WHEN 'Y' THEN C_ORDER.GRANDTOTAL ELSE -C_ORDER.GRANDTOTAL END) AS AMOUNT" +
      "      FROM C_ORDER " +
      "      WHERE C_ORDER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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

  public static String amountDebtPayment(ConnectionProvider connectionProvider, String cCash, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency_Convert((CASE ISRECEIPT WHEN 'Y' THEN p.AMOUNT ELSE -p.AMOUNT END), p.C_Currency_ID, (SELECT b.C_CURRENCY_ID" +
      "                                                                              FROM C_CASH C, C_CASHBOOK B " +
      "                                                                              WHERE C.C_CASHBOOK_ID = B.C_CASHBOOK_ID" +
      "                                                                              AND C.C_CASH_ID = ?)," +
      "                                                    (SELECT STATEMENTDATE FROM C_CASH WHERE C_CASH_ID = ?),null,p.AD_Client_ID,p.AD_Org_ID) as amount" +
      "      FROM C_DEBT_PAYMENT p" +
      "      WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCash);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCash);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

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

  public static String amountDebtPaymentBank(ConnectionProvider connectionProvider, String cBankstatement, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency_Convert((CASE ISRECEIPT WHEN 'Y' THEN p.AMOUNT ELSE -p.AMOUNT END), p.C_Currency_ID,(SELECT A.C_CURRENCY_ID" +
      "                                                                              FROM C_BANKSTATEMENT S, C_BANKACCOUNT A " +
      "                                                                              WHERE S.C_BANKACCOUNT_ID = A.C_BANKACCOUNT_ID " +
      "                                                                              AND S.C_BankStatement_ID = ?)," +
      "                                                                        (SELECT STATEMENTDATE FROM C_BANKSTATEMENT WHERE C_BANKSTATEMENT_ID = ?),null,p.AD_Client_ID,p.AD_Org_ID) as amount" +
      "      FROM C_DEBT_PAYMENT p" +
      "      WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

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

  public static String debtPaymentDescription(ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DESCRIPTION" +
      "      FROM C_DEBT_PAYMENT" +
      "      WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "description");
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
