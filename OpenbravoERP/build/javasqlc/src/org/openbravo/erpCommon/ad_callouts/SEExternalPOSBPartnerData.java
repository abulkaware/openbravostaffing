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

class SEExternalPOSBPartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEExternalPOSBPartnerData.class);
  private String InitRecordNumber="0";
  public String mPricelistId;
  public String poPricelistId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("po_pricelist_id") || fieldName.equals("poPricelistId"))
      return poPricelistId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SEExternalPOSBPartnerData[] select(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, 0, 0);
  }

  public static SEExternalPOSBPartnerData[] select(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    SELECT p.M_PriceList_ID, p.PO_PriceList_ID" +
      "        FROM C_BPartner p" +
      "        WHERE p.C_BPartner_ID = TO_CHAR(?)";

    ResultSet result;
    Vector<SEExternalPOSBPartnerData> vector = new Vector<SEExternalPOSBPartnerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        SEExternalPOSBPartnerData objectSEExternalPOSBPartnerData = new SEExternalPOSBPartnerData();
        objectSEExternalPOSBPartnerData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSEExternalPOSBPartnerData.poPricelistId = UtilSql.getValue(result, "po_pricelist_id");
        objectSEExternalPOSBPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEExternalPOSBPartnerData);
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
    SEExternalPOSBPartnerData objectSEExternalPOSBPartnerData[] = new SEExternalPOSBPartnerData[vector.size()];
    vector.copyInto(objectSEExternalPOSBPartnerData);
    return(objectSEExternalPOSBPartnerData);
  }
}
