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

class TaxData implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxData.class);
  private String InitRecordNumber="0";
  public String tax;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tax"))
      return tax;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static String taxGet(ConnectionProvider connectionProvider, String mProductId, String shipdate, String adOrgId, String mWarehouseId, String billPartnerLoc, String shipPartnerLoc, String cProjectId, String issotrx, String cGlitemId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_GetTax(?, TO_DATE(?), ?, ?, ?, ?, ?, ?, ?) AS TAX FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billPartnerLoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipPartnerLoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tax");
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

  public static String taxGet(ConnectionProvider connectionProvider, String mProductId, String shipdate, String adOrgId, String mWarehouseId, String billPartnerLoc, String shipPartnerLoc, String cProjectId, String issotrx, String cGlitemId, String forcedCashVAT)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_GetTax(?, TO_DATE(?), ?, ?, ?, ?, ?, ?, ?, ?) AS TAX FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billPartnerLoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipPartnerLoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, forcedCashVAT);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tax");
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
