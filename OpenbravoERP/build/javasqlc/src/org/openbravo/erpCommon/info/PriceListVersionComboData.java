//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PriceListVersionComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(PriceListVersionComboData.class);
  private String InitRecordNumber="0";
  public String mPricelistVersionId;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PriceListVersionComboData[] select(ConnectionProvider connectionProvider, String priceList, String adUserClient)    throws ServletException {
    return select(connectionProvider, priceList, adUserClient, 0, 0);
  }

  public static PriceListVersionComboData[] select(ConnectionProvider connectionProvider, String priceList, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PriceList_Version.M_PriceList_Version_ID, " +
      "        M_PriceList_Version.Name || ' - ' || c.Iso_Code AS Name " +
      "        FROM M_PriceList_Version, M_PriceList p, C_Currency c " +
      "        WHERE M_PriceList_Version.M_PriceList_ID=p.M_PriceList_ID " +
      "        AND p.C_Currency_ID=c.C_Currency_ID " +
      "        AND M_PriceList_Version.IsActive='Y' ";
    strSql = strSql + ((priceList==null || priceList.equals(""))?"":" AND EXISTS (SELECT * FROM M_PriceList xp WHERE xp.M_PriceList_ID= ? AND p.C_Currency_ID=xp.C_Currency_ID) ");
    strSql = strSql + 
      "        AND M_PriceList_Version.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        ORDER BY M_PriceList_Version.Name";

    ResultSet result;
    Vector<PriceListVersionComboData> vector = new Vector<PriceListVersionComboData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (priceList != null && !(priceList.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        PriceListVersionComboData objectPriceListVersionComboData = new PriceListVersionComboData();
        objectPriceListVersionComboData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListVersionComboData.name = UtilSql.getValue(result, "name");
        objectPriceListVersionComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListVersionComboData);
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
    PriceListVersionComboData objectPriceListVersionComboData[] = new PriceListVersionComboData[vector.size()];
    vector.copyInto(objectPriceListVersionComboData);
    return(objectPriceListVersionComboData);
  }

  public static PriceListVersionComboData[] selectActual(ConnectionProvider connectionProvider, String priceList, String date, String adUserClient)    throws ServletException {
    return selectActual(connectionProvider, priceList, date, adUserClient, 0, 0);
  }

  public static PriceListVersionComboData[] selectActual(ConnectionProvider connectionProvider, String priceList, String date, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT plv.M_PriceList_Version_ID " +
      "        FROM M_PriceList pl, M_PriceList_Version plv " +
      "        WHERE pl.M_PriceList_ID=plv.M_PriceList_ID " +
      "        AND plv.IsActive= 'Y' " +
      "        AND pl.M_PriceList_ID = ? " +
      "        AND plv.ValidFrom <= TO_DATE(?) " +
      "        AND plv.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        ORDER BY plv.ValidFrom Desc";

    ResultSet result;
    Vector<PriceListVersionComboData> vector = new Vector<PriceListVersionComboData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        PriceListVersionComboData objectPriceListVersionComboData = new PriceListVersionComboData();
        objectPriceListVersionComboData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListVersionComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListVersionComboData);
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
    PriceListVersionComboData objectPriceListVersionComboData[] = new PriceListVersionComboData[vector.size()];
    vector.copyInto(objectPriceListVersionComboData);
    return(objectPriceListVersionComboData);
  }
}
