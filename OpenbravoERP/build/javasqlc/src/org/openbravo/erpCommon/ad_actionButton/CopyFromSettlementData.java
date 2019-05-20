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

class CopyFromSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromSettlementData.class);
  private String InitRecordNumber="0";
  public String cDebtPaymentId;
  public String isreceipt;
  public String description;
  public String cBpartnerId;
  public String cCashbookId;
  public String paymentrule;
  public String amount;
  public String writeoffamt;
  public String glitemamt;
  public String cGlitemId;
  public String isdirectposting;
  public String amountdebit;
  public String status;
  public String amountcredit;
  public String cCurrencyId;
  public String cBankaccountId;
  public String ismanual;
  public String client;
  public String org;
  public String datetrx;
  public String cSettlementId;
  public String documentno;
  public String cDebtPaymentBalancingId;
  public String tercero;
  public String efecto;
  public String concepto;
  public String dateplanned;
  public String dateformat;
  public String scriptdate;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_cashbook_id") || fieldName.equals("cCashbookId"))
      return cCashbookId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("glitemamt"))
      return glitemamt;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("isdirectposting"))
      return isdirectposting;
    else if (fieldName.equalsIgnoreCase("amountdebit"))
      return amountdebit;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("amountcredit"))
      return amountcredit;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("client"))
      return client;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("datetrx"))
      return datetrx;
    else if (fieldName.equalsIgnoreCase("c_settlement_id") || fieldName.equals("cSettlementId"))
      return cSettlementId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_balancing_id") || fieldName.equals("cDebtPaymentBalancingId"))
      return cDebtPaymentBalancingId;
    else if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("efecto"))
      return efecto;
    else if (fieldName.equalsIgnoreCase("concepto"))
      return concepto;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("dateformat"))
      return dateformat;
    else if (fieldName.equalsIgnoreCase("scriptdate"))
      return scriptdate;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromSettlementData[] select(ConnectionProvider connectionProvider, String cSettlementId)    throws ServletException {
    return select(connectionProvider, cSettlementId, 0, 0);
  }

  public static CopyFromSettlementData[] select(ConnectionProvider connectionProvider, String cSettlementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_debt_payment_id,isreceipt, description, c_bpartner_id, c_cashbook_id, paymentrule," +
      "        amount, writeoffamt, glitemamt, c_glitem_id, isdirectposting, 0 as amountdebit, status_initial as status, " +
      "        0 as amountcredit, c_currency_id, c_bankaccount_id, ismanual, '' as client, '' as org, '' as datetrx," +
      "        '' as c_settlement_id, '' as documentno,  '' AS C_DEBT_PAYMENT_BALANCING_ID, '' AS TERCERO, '' AS EFECTO," +
      "        '' AS CONCEPTO, '' AS DATEPLANNED, '' AS DATEFORMAT, '' AS SCRIPTDATE" +
      "        FROM C_DEBT_PAYMENT" +
      "        WHERE c_settlement_generate_id = ?" +
      "        AND isactive='Y' ";

    ResultSet result;
    Vector<CopyFromSettlementData> vector = new Vector<CopyFromSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);

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
        CopyFromSettlementData objectCopyFromSettlementData = new CopyFromSettlementData();
        objectCopyFromSettlementData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCopyFromSettlementData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectCopyFromSettlementData.description = UtilSql.getValue(result, "description");
        objectCopyFromSettlementData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCopyFromSettlementData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectCopyFromSettlementData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectCopyFromSettlementData.amount = UtilSql.getValue(result, "amount");
        objectCopyFromSettlementData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectCopyFromSettlementData.glitemamt = UtilSql.getValue(result, "glitemamt");
        objectCopyFromSettlementData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectCopyFromSettlementData.isdirectposting = UtilSql.getValue(result, "isdirectposting");
        objectCopyFromSettlementData.amountdebit = UtilSql.getValue(result, "amountdebit");
        objectCopyFromSettlementData.status = UtilSql.getValue(result, "status");
        objectCopyFromSettlementData.amountcredit = UtilSql.getValue(result, "amountcredit");
        objectCopyFromSettlementData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromSettlementData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectCopyFromSettlementData.ismanual = UtilSql.getValue(result, "ismanual");
        objectCopyFromSettlementData.client = UtilSql.getValue(result, "client");
        objectCopyFromSettlementData.org = UtilSql.getValue(result, "org");
        objectCopyFromSettlementData.datetrx = UtilSql.getValue(result, "datetrx");
        objectCopyFromSettlementData.cSettlementId = UtilSql.getValue(result, "c_settlement_id");
        objectCopyFromSettlementData.documentno = UtilSql.getValue(result, "documentno");
        objectCopyFromSettlementData.cDebtPaymentBalancingId = UtilSql.getValue(result, "c_debt_payment_balancing_id");
        objectCopyFromSettlementData.tercero = UtilSql.getValue(result, "tercero");
        objectCopyFromSettlementData.efecto = UtilSql.getValue(result, "efecto");
        objectCopyFromSettlementData.concepto = UtilSql.getValue(result, "concepto");
        objectCopyFromSettlementData.dateplanned = UtilSql.getValue(result, "dateplanned");
        objectCopyFromSettlementData.dateformat = UtilSql.getValue(result, "dateformat");
        objectCopyFromSettlementData.scriptdate = UtilSql.getValue(result, "scriptdate");
        objectCopyFromSettlementData.rownum = Long.toString(countRecord);
        objectCopyFromSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromSettlementData);
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
    CopyFromSettlementData objectCopyFromSettlementData[] = new CopyFromSettlementData[vector.size()];
    vector.copyInto(objectCopyFromSettlementData);
    return(objectCopyFromSettlementData);
  }

  public static CopyFromSettlementData[] selectSettlement(ConnectionProvider connectionProvider, String cSettlementId)    throws ServletException {
    return selectSettlement(connectionProvider, cSettlementId, 0, 0);
  }

  public static CopyFromSettlementData[] selectSettlement(ConnectionProvider connectionProvider, String cSettlementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_org_id as org, ad_client_id as client, datetrx" +
      "        FROM C_Settlement" +
      "        WHERE c_settlement_id = ?";

    ResultSet result;
    Vector<CopyFromSettlementData> vector = new Vector<CopyFromSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);

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
        CopyFromSettlementData objectCopyFromSettlementData = new CopyFromSettlementData();
        objectCopyFromSettlementData.org = UtilSql.getValue(result, "org");
        objectCopyFromSettlementData.client = UtilSql.getValue(result, "client");
        objectCopyFromSettlementData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectCopyFromSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromSettlementData);
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
    CopyFromSettlementData objectCopyFromSettlementData[] = new CopyFromSettlementData[vector.size()];
    vector.copyInto(objectCopyFromSettlementData);
    return(objectCopyFromSettlementData);
  }

  public static CopyFromSettlementData[] selectRelation(ConnectionProvider connectionProvider, String description, String documentno, String adOrgClient, String adUserClient, String parDateFrom, String parDateTo)    throws ServletException {
    return selectRelation(connectionProvider, description, documentno, adOrgClient, adUserClient, parDateFrom, parDateTo, 0, 0);
  }

  public static CopyFromSettlementData[] selectRelation(ConnectionProvider connectionProvider, String description, String documentno, String adOrgClient, String adUserClient, String parDateFrom, String parDateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_settlement_id, description, datetrx, documentno" +
      "        FROM C_Settlement" +
      "        WHERE settlementtype = 'I'" +
      "        and processed = 'Y'" +
      "        and upper(coalesce(description,' ')) like upper(?)" +
      "        and upper(documentno) like upper(?)" +
      "        and coalesce(IsTemplate,'N') = 'Y'" +
      "        AND AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND 1=1 ";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND datetrx >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND datetrx <= TO_DATE(?) ");

    ResultSet result;
    Vector<CopyFromSettlementData> vector = new Vector<CopyFromSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
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
        CopyFromSettlementData objectCopyFromSettlementData = new CopyFromSettlementData();
        objectCopyFromSettlementData.cSettlementId = UtilSql.getValue(result, "c_settlement_id");
        objectCopyFromSettlementData.description = UtilSql.getValue(result, "description");
        objectCopyFromSettlementData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectCopyFromSettlementData.documentno = UtilSql.getValue(result, "documentno");
        objectCopyFromSettlementData.rownum = Long.toString(countRecord);
        objectCopyFromSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromSettlementData);
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
    CopyFromSettlementData objectCopyFromSettlementData[] = new CopyFromSettlementData[vector.size()];
    vector.copyInto(objectCopyFromSettlementData);
    return(objectCopyFromSettlementData);
  }

  public static int insertDebtPayment(Connection conn, ConnectionProvider connectionProvider, String cDebtPeymentId, String client, String org, String user, String isreceipt, String settlement, String description, String cBpartnerId, String currency, String bankaccount, String cashbook, String paymentrule, String amount, String writeoffamt, String dateplanned, String ismanual, String glitemid, String isdirectposting, String status)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_DEBT_PAYMENT " +
      "        ( C_DEBT_PAYMENT_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "          CREATEDBY, UPDATEDBY, ISRECEIPT, " +
      "          C_SETTLEMENT_GENERATE_ID,DESCRIPTION, C_BPARTNER_ID, " +
      "          C_CURRENCY_ID, C_BANKACCOUNT_ID,C_CASHBOOK_ID, " +
      "          PAYMENTRULE, AMOUNT, WRITEOFFAMT, " +
      "          DATEPLANNED, ISMANUAL,GLITEMAMT," +
      "          C_GLITEM_ID, ISDIRECTPOSTING, ISPAID," +
      "          ISVALID, STATUS, STATUS_INITIAL) " +
      "      VALUES     " +
      "        (?,?,?," +
      "         ?,?,?," +
      "         ?,?,?," +
      "         ?,?,?," +
      "         ?,TO_NUMBER(?),TO_NUMBER(?)," +
      "         TO_DATE(?),?,0," +
      "         ?,?,'N'," +
      "         'N',?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPeymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashbook);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, writeoffamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glitemid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdirectposting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);

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

  public static CopyFromSettlementData[] selectDebtPaymentBalancing(ConnectionProvider connectionProvider, String cDebtPeymentId)    throws ServletException {
    return selectDebtPaymentBalancing(connectionProvider, cDebtPeymentId, 0, 0);
  }

  public static CopyFromSettlementData[] selectDebtPaymentBalancing(ConnectionProvider connectionProvider, String cDebtPeymentId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AMOUNTDEBIT, AMOUNTCREDIT, C_GLITEM_ID, C_DEBT_PAYMENT_BALANCING_ID" +
      "        FROM C_DEBT_PAYMENT_BALANCING" +
      "        WHERE c_debt_payment_id = ?" +
      "        AND isactive = 'Y'";

    ResultSet result;
    Vector<CopyFromSettlementData> vector = new Vector<CopyFromSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPeymentId);

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
        CopyFromSettlementData objectCopyFromSettlementData = new CopyFromSettlementData();
        objectCopyFromSettlementData.amountdebit = UtilSql.getValue(result, "amountdebit");
        objectCopyFromSettlementData.amountcredit = UtilSql.getValue(result, "amountcredit");
        objectCopyFromSettlementData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectCopyFromSettlementData.cDebtPaymentBalancingId = UtilSql.getValue(result, "c_debt_payment_balancing_id");
        objectCopyFromSettlementData.rownum = Long.toString(countRecord);
        objectCopyFromSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromSettlementData);
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
    CopyFromSettlementData objectCopyFromSettlementData[] = new CopyFromSettlementData[vector.size()];
    vector.copyInto(objectCopyFromSettlementData);
    return(objectCopyFromSettlementData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cDebtPeymentBalancingId, String client, String org, String user, String cDebtPeymentId, String amountdebit, String amountcredit, String cGLItemId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_DEBT_PAYMENT_BALANCING ( C_DEBT_PAYMENT_BALANCING_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "      ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_DEBT_PAYMENT_ID, " +
      "      AMOUNTDEBIT, AMOUNTCREDIT,C_GLITEM_ID) " +
      "      VALUES ( ?, ?, ?, 'Y',  now(), ?,  now(), ?, ?, " +
      "              TO_NUMBER(?), TO_NUMBER(?), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPeymentBalancingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPeymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountdebit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountcredit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGLItemId);

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

/**
Principal select
 */
  public static CopyFromSettlementData[] selectDebtPaymentBalancingF4(ConnectionProvider connectionProvider, String dateformat, String adLanguage, String cSettlementId)    throws ServletException {
    return selectDebtPaymentBalancingF4(connectionProvider, dateformat, adLanguage, cSettlementId, 0, 0);
  }

/**
Principal select
 */
  public static CopyFromSettlementData[] selectDebtPaymentBalancingF4(ConnectionProvider connectionProvider, String dateformat, String adLanguage, String cSettlementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID, C_SETTLEMENT.C_SETTLEMENT_ID, C_DEBT_PAYMENT_BALANCING.C_DEBT_PAYMENT_BALANCING_ID," +
      "        C_BPARTNER.NAME AS TERCERO, C_BPARTNER.NAME || ' - ' ||AD_REF_LIST_V.NAME ||' - ' || TO_CHAR(C_DEBT_PAYMENT.DATEPLANNED, ?) AS EFECTO," +
      "        C_GLITEM.NAME AS CONCEPTO, C_DEBT_PAYMENT.DATEPLANNED AS DATEPLANNED, " +
      "        C_DEBT_PAYMENT_BALANCING.AMOUNTCREDIT, C_DEBT_PAYMENT_BALANCING.AMOUNTDEBIT," +
      "        C_BPARTNER.C_BPARTNER_ID, C_DEBT_PAYMENT.AMOUNT, to_char(?) AS dateformat, " +
      "        'djConfig.searchIds.push(\"paramfieldDate' || C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID || '\");' AS SCRIPTDATE" +
      "        FROM (C_SETTLEMENT LEFT JOIN C_DEBT_PAYMENT ON C_DEBT_PAYMENT.C_SETTLEMENT_GENERATE_ID = C_SETTLEMENT.C_SETTLEMENT_ID) " +
      "        LEFT JOIN C_DEBT_PAYMENT_BALANCING ON C_DEBT_PAYMENT_BALANCING.C_DEBT_PAYMENT_ID = C_DEBT_PAYMENT.C_DEBT_PAYMENT_ID" +
      "        LEFT JOIN C_GLITEM ON C_DEBT_PAYMENT_BALANCING.C_GLITEM_ID = C_GLITEM.C_GLITEM_ID" +
      "        LEFT JOIN C_BPARTNER ON C_DEBT_PAYMENT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "        LEFT JOIN AD_REF_LIST_V ON C_DEBT_PAYMENT.PAYMENTRULE = AD_REF_LIST_V.VALUE AND AD_REF_LIST_V.AD_LANGUAGE = ? AND AD_REF_LIST_V.AD_REFERENCE_ID = '195'" +
      "        WHERE C_DEBT_PAYMENT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID	" +
      "        AND C_SETTLEMENT.C_SETTLEMENT_ID = ?" +
      "        ORDER BY C_DEBT_PAYMENT.DATEPLANNED, TERCERO, EFECTO";

    ResultSet result;
    Vector<CopyFromSettlementData> vector = new Vector<CopyFromSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);

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
        CopyFromSettlementData objectCopyFromSettlementData = new CopyFromSettlementData();
        objectCopyFromSettlementData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCopyFromSettlementData.cSettlementId = UtilSql.getValue(result, "c_settlement_id");
        objectCopyFromSettlementData.cDebtPaymentBalancingId = UtilSql.getValue(result, "c_debt_payment_balancing_id");
        objectCopyFromSettlementData.tercero = UtilSql.getValue(result, "tercero");
        objectCopyFromSettlementData.efecto = UtilSql.getValue(result, "efecto");
        objectCopyFromSettlementData.concepto = UtilSql.getValue(result, "concepto");
        objectCopyFromSettlementData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCopyFromSettlementData.amountcredit = UtilSql.getValue(result, "amountcredit");
        objectCopyFromSettlementData.amountdebit = UtilSql.getValue(result, "amountdebit");
        objectCopyFromSettlementData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCopyFromSettlementData.amount = UtilSql.getValue(result, "amount");
        objectCopyFromSettlementData.dateformat = UtilSql.getValue(result, "dateformat");
        objectCopyFromSettlementData.scriptdate = UtilSql.getValue(result, "scriptdate");
        objectCopyFromSettlementData.rownum = Long.toString(countRecord);
        objectCopyFromSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromSettlementData);
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
    CopyFromSettlementData objectCopyFromSettlementData[] = new CopyFromSettlementData[vector.size()];
    vector.copyInto(objectCopyFromSettlementData);
    return(objectCopyFromSettlementData);
  }
}
