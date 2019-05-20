//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLCCostData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLCCostData.class);
  private String InitRecordNumber="0";
  public String mLcCostId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String datetrx;
  public String processing;
  public String processed;
  public String posted;
  public String dateacct;
  public String datedoc;
  public String cCurrencyId;
  public String differenceamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_lc_cost_id") || fieldName.equals("mLcCostId"))
      return mLcCostId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("datetrx"))
      return datetrx;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("differenceamt"))
      return differenceamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLCCostData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DocLCCostData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_LC_COST_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID, '' AS ISACTIVE," +
      "          '' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS DATETRX, '' AS PROCESSING," +
      "          '' AS PROCESSED, '' AS POSTED, '' AS DATEACCT, '' AS DATEDOC, '' AS C_CURRENCY_ID, '' AS DIFFERENCEAMT" +
      "        FROM DUAL";

    ResultSet result;
    Vector<DocLCCostData> vector = new Vector<DocLCCostData>(0);
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
        DocLCCostData objectDocLCCostData = new DocLCCostData();
        objectDocLCCostData.mLcCostId = UtilSql.getValue(result, "m_lc_cost_id");
        objectDocLCCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLCCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLCCostData.isactive = UtilSql.getValue(result, "isactive");
        objectDocLCCostData.created = UtilSql.getValue(result, "created");
        objectDocLCCostData.createdby = UtilSql.getValue(result, "createdby");
        objectDocLCCostData.updated = UtilSql.getValue(result, "updated");
        objectDocLCCostData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocLCCostData.datetrx = UtilSql.getValue(result, "datetrx");
        objectDocLCCostData.processing = UtilSql.getValue(result, "processing");
        objectDocLCCostData.processed = UtilSql.getValue(result, "processed");
        objectDocLCCostData.posted = UtilSql.getValue(result, "posted");
        objectDocLCCostData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocLCCostData.datedoc = UtilSql.getValue(result, "datedoc");
        objectDocLCCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLCCostData.differenceamt = UtilSql.getValue(result, "differenceamt");
        objectDocLCCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLCCostData);
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
    DocLCCostData objectDocLCCostData[] = new DocLCCostData[vector.size()];
    vector.copyInto(objectDocLCCostData);
    return(objectDocLCCostData);
  }

  public static DocLCCostData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocLCCostData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT LCC.M_LC_COST_ID, LCC.AD_CLIENT_ID, LCC.AD_ORG_ID, LCC.ISACTIVE, LCC.CREATED, LCC.CREATEDBY, LCC.UPDATED,        " +
      "        LCC.UPDATEDBY, LCC.DATEACCT AS DATETRX, LCC.PROCESSING,        " +
      "        LCC.PROCESSED AS PROCESSED, LCC.POSTED, LCC.DATEACCT, LCC.DATEACCT AS DATEDOC, LCC.C_CURRENCY_ID, " +
      "        LCC.AMOUNT - LCC.MATCHING_AMT AS DIFFERENCEAMT" +
      "        FROM M_LC_COST LCC      " +
      "        WHERE LCC.AD_Client_ID=?" +
      "        AND LCC.M_LC_COST_ID=?";

    ResultSet result;
    Vector<DocLCCostData> vector = new Vector<DocLCCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocLCCostData objectDocLCCostData = new DocLCCostData();
        objectDocLCCostData.mLcCostId = UtilSql.getValue(result, "m_lc_cost_id");
        objectDocLCCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLCCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLCCostData.isactive = UtilSql.getValue(result, "isactive");
        objectDocLCCostData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectDocLCCostData.createdby = UtilSql.getValue(result, "createdby");
        objectDocLCCostData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectDocLCCostData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocLCCostData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectDocLCCostData.processing = UtilSql.getValue(result, "processing");
        objectDocLCCostData.processed = UtilSql.getValue(result, "processed");
        objectDocLCCostData.posted = UtilSql.getValue(result, "posted");
        objectDocLCCostData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocLCCostData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocLCCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLCCostData.differenceamt = UtilSql.getValue(result, "differenceamt");
        objectDocLCCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLCCostData);
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
    DocLCCostData objectDocLCCostData[] = new DocLCCostData[vector.size()];
    vector.copyInto(objectDocLCCostData);
    return(objectDocLCCostData);
  }
}
