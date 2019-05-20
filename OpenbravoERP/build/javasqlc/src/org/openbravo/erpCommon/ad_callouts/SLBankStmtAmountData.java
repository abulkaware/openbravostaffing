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

class SLBankStmtAmountData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLBankStmtAmountData.class);
  private String InitRecordNumber="0";
  public String conversion;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("conversion"))
      return conversion;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLBankStmtAmountData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SLBankStmtAmountData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS CONVERSION FROM DUAL ";

    ResultSet result;
    Vector<SLBankStmtAmountData> vector = new Vector<SLBankStmtAmountData>(0);
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
        SLBankStmtAmountData objectSLBankStmtAmountData = new SLBankStmtAmountData();
        objectSLBankStmtAmountData.conversion = UtilSql.getValue(result, "conversion");
        objectSLBankStmtAmountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLBankStmtAmountData);
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
    SLBankStmtAmountData objectSLBankStmtAmountData[] = new SLBankStmtAmountData[vector.size()];
    vector.copyInto(objectSLBankStmtAmountData);
    return(objectSLBankStmtAmountData);
  }

  public static String isConversion(ConnectionProvider connectionProvider, String currency, String dp)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE WHEN C_CURRENCY_ID = ? THEN 'N' ELSE 'Y' END) as CONVERSION" +
      "      FROM C_DEBT_PAYMENT" +
      "	    WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dp);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "conversion");
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
