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

class DocLineCashData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineCashData.class);
  private String InitRecordNumber="0";
  public String cCashlineId;
  public String adOrgId;
  public String line;
  public String description;
  public String cChargeId;
  public String cOrderId;
  public String cDebtPaymentId;
  public String amount;
  public String writeoffamt;
  public String cashtype;
  public String discountamt;
  public String cCurrencyId;
  public String cBpartnerId;
  public String cGlitemId;
  public String glitemCreditAcct;
  public String glitemDebitAcct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_cashline_id") || fieldName.equals("cCashlineId"))
      return cCashlineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("cashtype"))
      return cashtype;
    else if (fieldName.equalsIgnoreCase("discountamt"))
      return discountamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("glitem_credit_acct") || fieldName.equals("glitemCreditAcct"))
      return glitemCreditAcct;
    else if (fieldName.equalsIgnoreCase("glitem_debit_acct") || fieldName.equals("glitemDebitAcct"))
      return glitemDebitAcct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineCashData[] select(ConnectionProvider connectionProvider, String cash)    throws ServletException {
    return select(connectionProvider, cash, 0, 0);
  }

  public static DocLineCashData[] select(ConnectionProvider connectionProvider, String cash, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C.C_CASHLINE_ID, C.AD_ORG_ID, C.LINE, C.DESCRIPTION, C.C_CHARGE_ID," +
      "      c.C_ORDER_ID, C.C_DEBT_PAYMENT_ID, " +
      "      C.AMOUNT,C.WRITEOFFAMT,C.CASHTYPE, C.DISCOUNTAMT,CB.C_CURRENCY_ID AS C_Currency_ID, " +
      "      (CASE WHEN DP.C_BPARTNER_ID IS NULL THEN O.C_BPARTNER_ID ELSE DP.C_BPARTNER_ID END) AS C_BPARTNER_ID," +
      "      C.C_GLITEM_ID, '' AS glitem_credit_acct, '' AS glitem_debit_acct" +
      "      FROM C_CashLine C left join C_DEBT_PAYMENT DP on C.C_DEBT_PAYMENT_ID = DP.C_DEBT_PAYMENT_ID" +
      "                        left join C_ORDER O on C.C_ORDER_ID = O.C_ORDER_ID,   " +
      "           C_CASHBOOK CB, C_CASH CA" +
      "      WHERE CA.C_Cash_ID= ?" +
      "      AND CB.C_CASHBOOK_ID = CA.C_CASHBOOK_ID" +
      "      AND CA.C_CASH_ID = C.C_CASH_ID" +
      "      ORDER BY Line";

    ResultSet result;
    Vector<DocLineCashData> vector = new Vector<DocLineCashData>(0);
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
        DocLineCashData objectDocLineCashData = new DocLineCashData();
        objectDocLineCashData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectDocLineCashData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineCashData.line = UtilSql.getValue(result, "line");
        objectDocLineCashData.description = UtilSql.getValue(result, "description");
        objectDocLineCashData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocLineCashData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectDocLineCashData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDocLineCashData.amount = UtilSql.getValue(result, "amount");
        objectDocLineCashData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectDocLineCashData.cashtype = UtilSql.getValue(result, "cashtype");
        objectDocLineCashData.discountamt = UtilSql.getValue(result, "discountamt");
        objectDocLineCashData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineCashData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineCashData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectDocLineCashData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineCashData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineCashData);
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
    DocLineCashData objectDocLineCashData[] = new DocLineCashData[vector.size()];
    vector.copyInto(objectDocLineCashData);
    return(objectDocLineCashData);
  }

  public static DocLineCashData[] selectOrder(ConnectionProvider connectionProvider, String C_Order_ID)    throws ServletException {
    return selectOrder(connectionProvider, C_Order_ID, 0, 0);
  }

  public static DocLineCashData[] selectOrder(ConnectionProvider connectionProvider, String C_Order_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_Org_ID, C_Currency_ID, C_BPartner_ID FROM C_Order WHERE C_Order_ID=?";

    ResultSet result;
    Vector<DocLineCashData> vector = new Vector<DocLineCashData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_ID);

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
        DocLineCashData objectDocLineCashData = new DocLineCashData();
        objectDocLineCashData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineCashData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineCashData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineCashData);
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
    DocLineCashData objectDocLineCashData[] = new DocLineCashData[vector.size()];
    vector.copyInto(objectDocLineCashData);
    return(objectDocLineCashData);
  }

  public static DocLineCashData[] selectPayment(ConnectionProvider connectionProvider, String C_DEBT_PAYMENT_ID)    throws ServletException {
    return selectPayment(connectionProvider, C_DEBT_PAYMENT_ID, 0, 0);
  }

  public static DocLineCashData[] selectPayment(ConnectionProvider connectionProvider, String C_DEBT_PAYMENT_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_Org_ID, C_Currency_ID, C_BPartner_ID FROM C_DEBT_PAYMENT WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    Vector<DocLineCashData> vector = new Vector<DocLineCashData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DEBT_PAYMENT_ID);

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
        DocLineCashData objectDocLineCashData = new DocLineCashData();
        objectDocLineCashData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineCashData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineCashData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineCashData);
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
    DocLineCashData objectDocLineCashData[] = new DocLineCashData[vector.size()];
    vector.copyInto(objectDocLineCashData);
    return(objectDocLineCashData);
  }

  public static String selectDebtBPartner(ConnectionProvider connectionProvider, String C_DEBT_PAYMENT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BPartner_ID FROM C_DEBT_PAYMENT WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DEBT_PAYMENT_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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

  public static DocLineCashData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectGlitem(connectionProvider, C_Glitem_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocLineCashData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT GLITEM_DEBIT_ACCT, GLITEM_CREDIT_ACCT" +
      "		FROM C_GLITEM_ACCT " +
      "		WHERE C_GLITEM_id = ?" +
      "		AND C_ACCTSCHEMA_id = ?";

    ResultSet result;
    Vector<DocLineCashData> vector = new Vector<DocLineCashData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Glitem_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        DocLineCashData objectDocLineCashData = new DocLineCashData();
        objectDocLineCashData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineCashData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineCashData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineCashData);
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
    DocLineCashData objectDocLineCashData[] = new DocLineCashData[vector.size()];
    vector.copyInto(objectDocLineCashData);
    return(objectDocLineCashData);
  }
}
