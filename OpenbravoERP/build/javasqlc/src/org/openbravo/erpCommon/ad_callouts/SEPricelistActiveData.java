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

class SEPricelistActiveData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEPricelistActiveData.class);
  private String InitRecordNumber="0";
  public String pricelistversion;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pricelistversion"))
      return pricelistversion;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SEPricelistActiveData[] getActivePricelistVersion(ConnectionProvider connectionProvider, String MPricelistId)    throws ServletException {
    return getActivePricelistVersion(connectionProvider, MPricelistId, 0, 0);
  }

  public static SEPricelistActiveData[] getActivePricelistVersion(ConnectionProvider connectionProvider, String MPricelistId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT V.M_PRICELIST_ID AS PricelistVersion" +
      "		FROM M_PRICELIST P, M_PRICELIST_VERSION V" +
      "		WHERE P.M_PRICELIST_ID = V.M_PRICELIST_ID" +
      "		AND V.ISACTIVE = 'Y'" +
      "		AND P.M_PRICELIST_ID = ?";

    ResultSet result;
    Vector<SEPricelistActiveData> vector = new Vector<SEPricelistActiveData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MPricelistId);

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
        SEPricelistActiveData objectSEPricelistActiveData = new SEPricelistActiveData();
        objectSEPricelistActiveData.pricelistversion = UtilSql.getValue(result, "pricelistversion");
        objectSEPricelistActiveData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEPricelistActiveData);
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
    SEPricelistActiveData objectSEPricelistActiveData[] = new SEPricelistActiveData[vector.size()];
    vector.copyInto(objectSEPricelistActiveData);
    return(objectSEPricelistActiveData);
  }
}
