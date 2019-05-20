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

class SLProjectPriceListData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLProjectPriceListData.class);
  private String InitRecordNumber="0";
  public String istaxincluded;
  public String cCurrencyId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLProjectPriceListData[] select(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    return select(connectionProvider, mPricelistId, 0, 0);
  }

  public static SLProjectPriceListData[] select(ConnectionProvider connectionProvider, String mPricelistId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT pl.IsTaxIncluded, pl.C_Currency_ID " +
      "        FROM M_PriceList pl " +
      "        WHERE pl.M_PriceList_ID = ?";

    ResultSet result;
    Vector<SLProjectPriceListData> vector = new Vector<SLProjectPriceListData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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
        SLProjectPriceListData objectSLProjectPriceListData = new SLProjectPriceListData();
        objectSLProjectPriceListData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectSLProjectPriceListData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSLProjectPriceListData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLProjectPriceListData);
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
    SLProjectPriceListData objectSLProjectPriceListData[] = new SLProjectPriceListData[vector.size()];
    vector.copyInto(objectSLProjectPriceListData);
    return(objectSLProjectPriceListData);
  }
}
