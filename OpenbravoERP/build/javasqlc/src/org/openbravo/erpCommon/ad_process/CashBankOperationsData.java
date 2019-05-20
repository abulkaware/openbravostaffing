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

class CashBankOperationsData implements FieldProvider {
static Logger log4j = Logger.getLogger(CashBankOperationsData.class);
  private String InitRecordNumber="0";
  public String padre;
  public String id;
  public String name;
  public String cBpartnerId;
  public String isoCode;
  public String cCashId;
  public String cDoctypeId;
  public String cCurrencyId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("iso_code") || fieldName.equals("isoCode"))
      return isoCode;
    else if (fieldName.equalsIgnoreCase("c_cash_id") || fieldName.equals("cCashId"))
      return cCashId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CashBankOperationsData[] selectDummy(ConnectionProvider connectionProvider)    throws ServletException {
    return selectDummy(connectionProvider, 0, 0);
  }

  public static CashBankOperationsData[] selectDummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT '' AS PADRE, " +
      "			   '' AS ID, " +
      "			   '' AS NAME, " +
      "			   '' AS C_BPARTNER_ID, " +
      "			   '' AS iso_code, " +
      "			   '' AS C_CASH_ID, " +
      "			   '' AS C_DOCTYPE_ID, " +
      "			   '' AS c_currency_id" +
      "		FROM DUAL";

    ResultSet result;
    Vector<CashBankOperationsData> vector = new Vector<CashBankOperationsData>(0);
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
        CashBankOperationsData objectCashBankOperationsData = new CashBankOperationsData();
        objectCashBankOperationsData.padre = UtilSql.getValue(result, "padre");
        objectCashBankOperationsData.id = UtilSql.getValue(result, "id");
        objectCashBankOperationsData.name = UtilSql.getValue(result, "name");
        objectCashBankOperationsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCashBankOperationsData.isoCode = UtilSql.getValue(result, "iso_code");
        objectCashBankOperationsData.cCashId = UtilSql.getValue(result, "c_cash_id");
        objectCashBankOperationsData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCashBankOperationsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCashBankOperationsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCashBankOperationsData);
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
    CashBankOperationsData objectCashBankOperationsData[] = new CashBankOperationsData[vector.size()];
    vector.copyInto(objectCashBankOperationsData);
    return(objectCashBankOperationsData);
  }

  public static CashBankOperationsData[] selectBankDouble(ConnectionProvider connectionProvider, String adOrgId, String adClientId)    throws ServletException {
    return selectBankDouble(connectionProvider, adOrgId, adClientId, 0, 0);
  }

  public static CashBankOperationsData[] selectBankDouble(ConnectionProvider connectionProvider, String adOrgId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT P.AD_ORG_ID AS PADRE, C.C_BANKACCOUNT_ID AS ID, C.DISPLAYEDACCOUNT AS NAME" +
      "		FROM AD_ORG O, AD_ORG P, C_BANKACCOUNT C" +
      "		WHERE O.AD_ORG_ID = C.AD_ORG_ID" +
      "		  AND AD_ISORGINCLUDED(P.AD_ORG_ID,C.AD_ORG_ID,P.AD_CLIENT_ID) <> -1" +
      "		  AND C.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "		  AND C.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")" +
      "		ORDER BY PADRE, NAME";

    ResultSet result;
    Vector<CashBankOperationsData> vector = new Vector<CashBankOperationsData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adClientId != null && !(adClientId.equals(""))) {
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
        CashBankOperationsData objectCashBankOperationsData = new CashBankOperationsData();
        objectCashBankOperationsData.padre = UtilSql.getValue(result, "padre");
        objectCashBankOperationsData.id = UtilSql.getValue(result, "id");
        objectCashBankOperationsData.name = UtilSql.getValue(result, "name");
        objectCashBankOperationsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCashBankOperationsData);
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
    CashBankOperationsData objectCashBankOperationsData[] = new CashBankOperationsData[vector.size()];
    vector.copyInto(objectCashBankOperationsData);
    return(objectCashBankOperationsData);
  }

  public static CashBankOperationsData[] selectCashDouble(ConnectionProvider connectionProvider, String adLanguage, String adOrgId, String adClientId)    throws ServletException {
    return selectCashDouble(connectionProvider, adLanguage, adOrgId, adClientId, 0, 0);
  }

  public static CashBankOperationsData[] selectCashDouble(ConnectionProvider connectionProvider, String adLanguage, String adOrgId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT P.AD_ORG_ID AS PADRE, C.C_CASHBOOK_ID AS ID, AD_COLUMN_IDENTIFIER(TO_CHAR('C_CASHBOOK'),TO_CHAR(C.C_CASHBOOK_ID),TO_CHAR(?)) AS NAME" +
      "		FROM AD_ORG O, AD_ORG P, C_CASHBOOK C" +
      "		WHERE O.AD_ORG_ID = C.AD_ORG_ID" +
      "		  AND AD_ISORGINCLUDED(P.AD_ORG_ID,C.AD_ORG_ID,P.AD_CLIENT_ID) <> -1" +
      "		  AND C.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "		  AND C.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")" +
      "		ORDER BY PADRE, NAME";

    ResultSet result;
    Vector<CashBankOperationsData> vector = new Vector<CashBankOperationsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adClientId != null && !(adClientId.equals(""))) {
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
        CashBankOperationsData objectCashBankOperationsData = new CashBankOperationsData();
        objectCashBankOperationsData.padre = UtilSql.getValue(result, "padre");
        objectCashBankOperationsData.id = UtilSql.getValue(result, "id");
        objectCashBankOperationsData.name = UtilSql.getValue(result, "name");
        objectCashBankOperationsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCashBankOperationsData);
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
    CashBankOperationsData objectCashBankOperationsData[] = new CashBankOperationsData[vector.size()];
    vector.copyInto(objectCashBankOperationsData);
    return(objectCashBankOperationsData);
  }

  public static String select(ConnectionProvider connectionProvider, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BPARTNER_ID FROM AD_ORGINFO" +
      "        WHERE AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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

  public static String selectCurrency(ConnectionProvider connectionProvider, String currencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select iso_code from c_currency where c_currency_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "iso_code");
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

  public static String selectNextCashLine(ConnectionProvider connectionProvider, String cashId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(line),0) + 10 FROM c_cashline" +
      "        WHERE c_cash_id =?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static String selectOpenCash(ConnectionProvider connectionProvider, String cashBook, String dateacct)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C.C_CASH_ID)" +
      "        FROM C_CASH C" +
      "        WHERE C.C_CASHBOOK_ID=?" +
      "        AND C.DATEACCT = TO_DATE(?)" +
      "        AND C.PROCESSED = 'N'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashBook);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String selectSettlementDoctypeId(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DOCTYPE_ID FROM C_DOCTYPE" +
      "        WHERE docbasetype = 'STT'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_doctype_id");
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

  public static String selectBankCurrency(ConnectionProvider connectionProvider, String bankAccount)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_currency_id FROM C_BANKACCOUNT" +
      "      WHERE c_bankaccount_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankAccount);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static String selectCashCurrency(ConnectionProvider connectionProvider, String cashBook)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_currency_id FROM C_CASHBOOK" +
      "      WHERE c_cashbook_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashBook);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static int insertSettlement(Connection conn, ConnectionProvider connectionProvider, String settlementId, String adClientId, String adOrgId, String adUserId, String documentNo, String date, String doctypeId, String currencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     INSERT INTO C_SETTLEMENT (C_SETTLEMENT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "     DOCUMENTNO, DATETRX, DATEACCT, SETTLEMENTTYPE, C_DOCTYPE_ID, PROCESSING, PROCESSED, POSTED, C_CURRENCY_ID, C_PROJECT_ID, C_CAMPAIGN_ID," +
      "     C_ACTIVITY_ID, USER1_ID, USER2_ID, CREATEFROM, CANCELEDNOTCHARGEAMT,GENERATEDAMT,CHARGEDAMT,ISGENERATED)" +
      "     VALUES (?, ?, ?, 'Y',now(), ?, now(), ?," +
      "     '*FT*'||?, TO_DATE(?), TO_DATE(?),'B',?, 'N','N','N', ?,NULL, NULL,NULL, NULL, NULL, 'N',0,0,0,'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);

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

  public static int insertDebtpayment(Connection conn, ConnectionProvider connectionProvider, String debtpaymentId, String adClientId, String adOrgId, String adUserId, String isReceipt, String settlementId, String description, String bPartner, String currency, String cashLine, String bankaccount, String cashbook, String paymentRule, String amount, String date, String bankStatementLine)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_DEBT_PAYMENT" +
      "          (C_DEBT_PAYMENT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, " +
      "           CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "           ISRECEIPT, C_SETTLEMENT_CANCEL_ID, C_SETTLEMENT_GENERATE_ID, DESCRIPTION, " +
      "           C_INVOICE_ID, C_BPARTNER_ID, C_CURRENCY_ID, C_CASHLINE_ID, " +
      "           C_BANKACCOUNT_ID, C_CASHBOOK_ID, PAYMENTRULE, ISPAID, " +
      "           AMOUNT, WRITEOFFAMT, DATEPLANNED, ISMANUAL, " +
      "           ISVALID, C_BANKSTATEMENTLINE_ID, CHANGESETTLEMENTCANCEL, CANCEL_PROCESSED, " +
      "           GENERATE_PROCESSED,STATUS_INITIAL)" +
      "      VALUES " +
      "          (?, ?, ?, 'Y', " +
      "           now(), ?, now(), ?," +
      "           ?, NULL, ?, ?," +
      "           NULL, ?, ?, ?," +
      "           ?, ?, ?,'N'," +
      "           TO_NUMBER(?), 0,TO_DATE(?),'N'," +
      "           'Y', ?,'Y','N'," +
      "           'Y','DE')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, debtpaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isReceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPartner);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashLine);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashbook);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentRule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankStatementLine);

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

  public static int insertCash(Connection conn, ConnectionProvider connectionProvider, String cashId, String adClientId, String adOrgId, String adUserId, String cashBook, String name, String date)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          INSERT INTO C_CASH " +
      "            (C_Cash_ID,AD_Client_ID, AD_Org_ID, IsActive, " +
      "             Created,CreatedBy, Updated,UpdatedBy," +
      "             C_CashBook_ID, NAME, StatementDate,DateAcct, BeginningBalance,EndingBalance,StatementDifference," +
      "          Processing,Processed,Posted)" +
      "          VALUES " +
      "            (?, ?, ?, 'Y', " +
      "             now(),?, now(),?, " +
      "             ?, ?, TO_DATE(?), TO_DATE(?), " +
      "             0,0,0, 'N','N','N')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashBook);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);

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

  public static int insertCashLine(Connection conn, ConnectionProvider connectionProvider, String cashlineId, String adClientId, String adOrgId, String adUserId, String cashId, String cDPId, String line, String description, String amount, String currency)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       INSERT INTO C_CASHLINE " +
      "            (C_CashLine_ID, AD_Client_ID, AD_Org_ID, IsActive," +
      "             Created,       CreatedBy,    Updated,  UpdatedBy," +
      "             C_Cash_ID,     C_Debt_Payment_ID, Line, Description," +
      "             Amount,        CashType,     C_Currency_ID, DiscountAmt, " +
      "             WriteOffAmt,   IsGenerated)" +
      "       VALUES" +
      "            (?, ?, ?, 'Y', " +
      "             now(),        ?, now(), ?, " +
      "             ?, ?, TO_NUMBER(?), ?, " +
      "             TO_NUMBER(?), 'P',  ?, 0, " +
      "             0, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDPId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);

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

  public static int updateSettlement(Connection conn, ConnectionProvider connectionProvider, String settlementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_SETTLEMENT SET PROCESSED = 'Y'" +
      "        WHERE C_SETTLEMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, settlementId);

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

  public static String selectCashBook(ConnectionProvider connectionProvider, String cashBook)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM C_CASHBOOK WHERE C_CASHBOOK_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashBook);

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

  public static String selectBankAccount(ConnectionProvider connectionProvider, String bankAccount, String adLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_column_identifier(TO_CHAR('C_BankAccount'),TO_CHAR(?),TO_CHAR(?)) FROM dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankAccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_column_identifier");
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
