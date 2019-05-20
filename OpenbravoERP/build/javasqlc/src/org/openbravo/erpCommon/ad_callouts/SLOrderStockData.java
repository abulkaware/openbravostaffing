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

class SLOrderStockData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLOrderStockData.class);
  private String InitRecordNumber="0";
  public String stock;
  public String enforceAttribute;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("stock"))
      return stock;
    else if (fieldName.equalsIgnoreCase("enforce_attribute") || fieldName.equals("enforceAttribute"))
      return enforceAttribute;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLOrderStockData[] select(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    return select(connectionProvider, mProductId, 0, 0);
  }

  public static SLOrderStockData[] select(ConnectionProvider connectionProvider, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(Stock_Min,0) as Stock, Enforce_Attribute" +
      "      FROM M_Product" +
      "      WHERE M_Product_ID = ?";

    ResultSet result;
    Vector<SLOrderStockData> vector = new Vector<SLOrderStockData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
        SLOrderStockData objectSLOrderStockData = new SLOrderStockData();
        objectSLOrderStockData.stock = UtilSql.getValue(result, "stock");
        objectSLOrderStockData.enforceAttribute = UtilSql.getValue(result, "enforce_attribute");
        objectSLOrderStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLOrderStockData);
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
    SLOrderStockData objectSLOrderStockData[] = new SLOrderStockData[vector.size()];
    vector.copyInto(objectSLOrderStockData);
    return(objectSLOrderStockData);
  }

  public static String totalStockNoAttribute(ConnectionProvider connectionProvider, String mProductId, String cUOMId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(SUM (QTYONHAND),0) AS QTY FROM M_STORAGE_DETAIL" +
      "      WHERE M_PRODUCT_ID = ?" +
      "      AND C_UOM_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUOMId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "qty");
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

  public static String totalStockAttribute(ConnectionProvider connectionProvider, String mProductId, String cUOMId, String MAttributesetinstanceID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(SUM (QTYONHAND),0) AS QTY FROM M_STORAGE_DETAIL" +
      "      WHERE M_PRODUCT_ID = ?" +
      "      AND C_UOM_ID = ?" +
      "      AND M_ATTRIBUTESETINSTANCE_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUOMId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MAttributesetinstanceID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "qty");
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

  public static String isSotrx(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ISSOTRX FROM C_ORDER" +
      "      WHERE C_ORDER_ID = ?";

    ResultSet result;
    String strReturn = "Y";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "issotrx");
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
