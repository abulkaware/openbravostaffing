//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.businessUtility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

/**
This class offers methods related to retrieving the price for a product using the M_GET_OFFERS pl function.
 */
public class GetPriceOfferData implements FieldProvider {
static Logger log4j = Logger.getLogger(GetPriceOfferData.class);
  private String InitRecordNumber="0";
  public String total;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("total"))
      return total;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Retrieves the price for product on a certain date for a certain quantity using the price-precision of the currency.
 */
  public static String getOffersPriceCurrency(ConnectionProvider connectionProvider, String dateordered, String cBpartnerId, String mProductId, String pricestd, String qty, String pricelist, String currencyid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ROUND(M_GET_OFFERS_PRICE(TO_DATE(?),?,?,TO_NUMBER(?), TO_NUMBER(?), ?)," +
      "                   (SELECT PRICEPRECISION " +
      "                       FROM C_CURRENCY C" +
      "                      WHERE C.C_CURRENCY_ID = ?)) AS TOTAL FROM DUAL";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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
