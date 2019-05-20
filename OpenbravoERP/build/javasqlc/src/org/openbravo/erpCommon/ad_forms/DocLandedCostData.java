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

class DocLandedCostData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLandedCostData.class);
  private String InitRecordNumber="0";
  public String mLandedcostId;
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

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_landedcost_id") || fieldName.equals("mLandedcostId"))
      return mLandedcostId;
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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLandedCostData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DocLandedCostData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_LANDEDCOST_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID, '' AS ISACTIVE," +
      "          '' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS DATETRX, '' AS PROCESSING," +
      "          '' AS PROCESSED, '' AS POSTED, '' AS DATEACCT, '' AS DATEDOC" +
      "        FROM DUAL";

    ResultSet result;
    Vector<DocLandedCostData> vector = new Vector<DocLandedCostData>(0);
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
        DocLandedCostData objectDocLandedCostData = new DocLandedCostData();
        objectDocLandedCostData.mLandedcostId = UtilSql.getValue(result, "m_landedcost_id");
        objectDocLandedCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLandedCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLandedCostData.isactive = UtilSql.getValue(result, "isactive");
        objectDocLandedCostData.created = UtilSql.getValue(result, "created");
        objectDocLandedCostData.createdby = UtilSql.getValue(result, "createdby");
        objectDocLandedCostData.updated = UtilSql.getValue(result, "updated");
        objectDocLandedCostData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocLandedCostData.datetrx = UtilSql.getValue(result, "datetrx");
        objectDocLandedCostData.processing = UtilSql.getValue(result, "processing");
        objectDocLandedCostData.processed = UtilSql.getValue(result, "processed");
        objectDocLandedCostData.posted = UtilSql.getValue(result, "posted");
        objectDocLandedCostData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocLandedCostData.datedoc = UtilSql.getValue(result, "datedoc");
        objectDocLandedCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLandedCostData);
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
    DocLandedCostData objectDocLandedCostData[] = new DocLandedCostData[vector.size()];
    vector.copyInto(objectDocLandedCostData);
    return(objectDocLandedCostData);
  }

  public static DocLandedCostData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocLandedCostData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT LC.M_LANDEDCOST_ID, LC.AD_CLIENT_ID, LC.AD_ORG_ID, LC.ISACTIVE, LC.CREATED, LC.CREATEDBY, LC.UPDATED,        " +
      "        LC.UPDATEDBY, LC.REFERENCEDATE AS DATETRX, LC.PROCESSING,        " +
      "        LC.PROCESSED, LC.POSTED, LC.REFERENCEDATE AS DATEACCT, LC.REFERENCEDATE AS DATEDOC" +
      "        FROM M_LANDEDCOST LC      " +
      "        WHERE LC.AD_Client_ID=?" +
      "        AND LC.M_LANDEDCOST_ID=?";

    ResultSet result;
    Vector<DocLandedCostData> vector = new Vector<DocLandedCostData>(0);
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
        DocLandedCostData objectDocLandedCostData = new DocLandedCostData();
        objectDocLandedCostData.mLandedcostId = UtilSql.getValue(result, "m_landedcost_id");
        objectDocLandedCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLandedCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLandedCostData.isactive = UtilSql.getValue(result, "isactive");
        objectDocLandedCostData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectDocLandedCostData.createdby = UtilSql.getValue(result, "createdby");
        objectDocLandedCostData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectDocLandedCostData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocLandedCostData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectDocLandedCostData.processing = UtilSql.getValue(result, "processing");
        objectDocLandedCostData.processed = UtilSql.getValue(result, "processed");
        objectDocLandedCostData.posted = UtilSql.getValue(result, "posted");
        objectDocLandedCostData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocLandedCostData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocLandedCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLandedCostData);
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
    DocLandedCostData objectDocLandedCostData[] = new DocLandedCostData[vector.size()];
    vector.copyInto(objectDocLandedCostData);
    return(objectDocLandedCostData);
  }
}
