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

class SLOrderAmtData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLOrderAmtData.class);
  private String InitRecordNumber="0";
  public String stdprecision;
  public String priceprecision;
  public String enforcepricelimit;
  public String mPricelistId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("enforcepricelimit"))
      return enforcepricelimit;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLOrderAmtData[] select(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return select(connectionProvider, cOrderId, 0, 0);
  }

  public static SLOrderAmtData[] select(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency.StdPrecision, C_Currency.PricePrecision, M_PriceList.EnforcePriceLimit, M_PriceList.M_PriceList_ID " +
      "      FROM C_Order, M_PriceList, C_Currency " +
      "      WHERE C_Order.M_PriceList_ID = M_PriceList.M_PriceList_ID" +
      "      AND M_PriceList.C_Currency_ID = C_Currency.C_Currency_ID" +
      "      AND C_Order.C_Order_ID = ?";

    ResultSet result;
    Vector<SLOrderAmtData> vector = new Vector<SLOrderAmtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
        SLOrderAmtData objectSLOrderAmtData = new SLOrderAmtData();
        objectSLOrderAmtData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectSLOrderAmtData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectSLOrderAmtData.enforcepricelimit = UtilSql.getValue(result, "enforcepricelimit");
        objectSLOrderAmtData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSLOrderAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLOrderAmtData);
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
    SLOrderAmtData objectSLOrderAmtData[] = new SLOrderAmtData[vector.size()];
    vector.copyInto(objectSLOrderAmtData);
    return(objectSLOrderAmtData);
  }

  public static boolean listPriceType(ConnectionProvider connectionProvider, String priceList)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE ENFORCEPRICELIMIT WHEN 'Y' THEN 1 ELSE 0 END) AS TYPE FROM M_PRICELIST WHERE M_PRICELIST_ID = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "type").equals("0");
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
    return(boolReturn);
  }
}
