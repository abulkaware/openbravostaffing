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

class DocCostAdjustmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocCostAdjustmentData.class);
  private String InitRecordNumber="0";
  public String mCostadjustmentId;
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
  public String cDoctypeId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_costadjustment_id") || fieldName.equals("mCostadjustmentId"))
      return mCostadjustmentId;
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
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocCostAdjustmentData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocCostAdjustmentData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CA.M_COSTADJUSTMENT_ID, CA.AD_CLIENT_ID, CA.AD_ORG_ID, CA.ISACTIVE, CA.CREATED, CA.CREATEDBY, CA.UPDATED,        " +
      "        CA.UPDATEDBY, CA.REFERENCEDATE AS DATETRX, CA.PROCESSING,        " +
      "        CA.PROCESSED, CA.POSTED, CA.REFERENCEDATE AS DATEACCT, CA.REFERENCEDATE AS DATEDOC, CA.C_DOCTYPE_ID" +
      "        FROM M_COSTADJUSTMENT CA      " +
      "        WHERE CA.AD_Client_ID=?" +
      "        AND CA.M_COSTADJUSTMENT_ID=?";

    ResultSet result;
    Vector<DocCostAdjustmentData> vector = new Vector<DocCostAdjustmentData>(0);
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
        DocCostAdjustmentData objectDocCostAdjustmentData = new DocCostAdjustmentData();
        objectDocCostAdjustmentData.mCostadjustmentId = UtilSql.getValue(result, "m_costadjustment_id");
        objectDocCostAdjustmentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocCostAdjustmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocCostAdjustmentData.isactive = UtilSql.getValue(result, "isactive");
        objectDocCostAdjustmentData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectDocCostAdjustmentData.createdby = UtilSql.getValue(result, "createdby");
        objectDocCostAdjustmentData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectDocCostAdjustmentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocCostAdjustmentData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectDocCostAdjustmentData.processing = UtilSql.getValue(result, "processing");
        objectDocCostAdjustmentData.processed = UtilSql.getValue(result, "processed");
        objectDocCostAdjustmentData.posted = UtilSql.getValue(result, "posted");
        objectDocCostAdjustmentData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocCostAdjustmentData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocCostAdjustmentData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocCostAdjustmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocCostAdjustmentData);
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
    DocCostAdjustmentData objectDocCostAdjustmentData[] = new DocCostAdjustmentData[vector.size()];
    vector.copyInto(objectDocCostAdjustmentData);
    return(objectDocCostAdjustmentData);
  }
}
