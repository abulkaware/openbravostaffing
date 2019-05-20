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

class SLOrderProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLOrderProductData.class);
  private String InitRecordNumber="0";
  public String id;
  public String dateordered;
  public String cBpartnerId;
  public String mPricelistId;
  public String dateinvoiced;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLOrderProductData[] select(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return select(connectionProvider, cOrderId, 0, 0);
  }

  public static SLOrderProductData[] select(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_ORDER_ID AS ID, DATEORDERED, C_BPARTNER_ID, M_PRICELIST_ID, '' AS DATEINVOICED " +
      "        FROM C_ORDER WHERE C_ORDER_ID = ?";

    ResultSet result;
    Vector<SLOrderProductData> vector = new Vector<SLOrderProductData>(0);
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
        SLOrderProductData objectSLOrderProductData = new SLOrderProductData();
        objectSLOrderProductData.id = UtilSql.getValue(result, "id");
        objectSLOrderProductData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSLOrderProductData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSLOrderProductData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSLOrderProductData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectSLOrderProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLOrderProductData);
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
    SLOrderProductData objectSLOrderProductData[] = new SLOrderProductData[vector.size()];
    vector.copyInto(objectSLOrderProductData);
    return(objectSLOrderProductData);
  }

  public static SLOrderProductData[] selectInvoice(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return selectInvoice(connectionProvider, cInvoiceId, 0, 0);
  }

  public static SLOrderProductData[] selectInvoice(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_INVOICE_ID AS ID, DATEINVOICED, C_BPARTNER_ID, M_PRICELIST_ID" +
      "      	FROM C_INVOICE WHERE C_INVOICE_ID = ?";

    ResultSet result;
    Vector<SLOrderProductData> vector = new Vector<SLOrderProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        SLOrderProductData objectSLOrderProductData = new SLOrderProductData();
        objectSLOrderProductData.id = UtilSql.getValue(result, "id");
        objectSLOrderProductData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectSLOrderProductData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSLOrderProductData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSLOrderProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLOrderProductData);
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
    SLOrderProductData objectSLOrderProductData[] = new SLOrderProductData[vector.size()];
    vector.copyInto(objectSLOrderProductData);
    return(objectSLOrderProductData);
  }

  public static String hasSecondaryUOM(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE COUNT(*) WHEN 0 THEN 0 ELSE 1 END) AS TOTAL " +
      "      FROM M_PRODUCT_UOM " +
      "      WHERE M_PRODUCT_ID = ?" +
      "      AND ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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

  public static String getOrgLocationId(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  	SELECT C_LOCATION_ID " +
      "	  		FROM AD_ORGINFO " +
      "	  		WHERE AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	  		AND AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_location_id");
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

  public static String getWarehouseOrg(ConnectionProvider connectionProvider, String cWarehouseID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  SELECT AD_ORG_ID" +
      "      FROM M_WAREHOUSE" +
      "      WHERE M_WAREHOUSE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWarehouseID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getWarehouseOfOrg(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select min(w.m_warehouse_id)" +
      "        from m_warehouse w" +
      "        where w.ad_client_id=?" +
      "          and (ad_isorgincluded(?,w.ad_org_id,?)<>-1" +
      "            or ad_isorgincluded(w.ad_org_id,?,?)<>-1)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "min");
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
