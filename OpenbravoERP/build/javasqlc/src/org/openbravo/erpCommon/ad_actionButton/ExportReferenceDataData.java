//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ExportReferenceDataData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExportReferenceDataData.class);
  private String InitRecordNumber="0";
  public String adDatasetId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String value;
  public String name;
  public String description;
  public String adModuleId;
  public String export;
  public String javapackage;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_dataset_id") || fieldName.equals("adDatasetId"))
      return adDatasetId;
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
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("export"))
      return export;
    else if (fieldName.equalsIgnoreCase("javapackage"))
      return javapackage;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExportReferenceDataData[] selectDataset(ConnectionProvider connectionProvider, String key)    throws ServletException {
    return selectDataset(connectionProvider, key, 0, 0);
  }

  public static ExportReferenceDataData[] selectDataset(ConnectionProvider connectionProvider, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_DATASET_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, VALUE, NAME, DESCRIPTION, AD_MODULE_ID, " +
      "        EXPORT, '' AS JAVAPACKAGE" +
      "        FROM AD_DATASET" +
      "        WHERE AD_DATASET_ID = ?" +
      "        AND EXPORTALLOWED = 'Y'";

    ResultSet result;
    Vector<ExportReferenceDataData> vector = new Vector<ExportReferenceDataData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        ExportReferenceDataData objectExportReferenceDataData = new ExportReferenceDataData();
        objectExportReferenceDataData.adDatasetId = UtilSql.getValue(result, "ad_dataset_id");
        objectExportReferenceDataData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExportReferenceDataData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExportReferenceDataData.isactive = UtilSql.getValue(result, "isactive");
        objectExportReferenceDataData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectExportReferenceDataData.createdby = UtilSql.getValue(result, "createdby");
        objectExportReferenceDataData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectExportReferenceDataData.updatedby = UtilSql.getValue(result, "updatedby");
        objectExportReferenceDataData.value = UtilSql.getValue(result, "value");
        objectExportReferenceDataData.name = UtilSql.getValue(result, "name");
        objectExportReferenceDataData.description = UtilSql.getValue(result, "description");
        objectExportReferenceDataData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectExportReferenceDataData.export = UtilSql.getValue(result, "export");
        objectExportReferenceDataData.javapackage = UtilSql.getValue(result, "javapackage");
        objectExportReferenceDataData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExportReferenceDataData);
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
    ExportReferenceDataData objectExportReferenceDataData[] = new ExportReferenceDataData[vector.size()];
    vector.copyInto(objectExportReferenceDataData);
    return(objectExportReferenceDataData);
  }

  public static ExportReferenceDataData[] selectModule(ConnectionProvider connectionProvider, String key)    throws ServletException {
    return selectModule(connectionProvider, key, 0, 0);
  }

  public static ExportReferenceDataData[] selectModule(ConnectionProvider connectionProvider, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT JAVAPACKAGE" +
      "        FROM AD_MODULE" +
      "        WHERE AD_MODULE_ID = ?";

    ResultSet result;
    Vector<ExportReferenceDataData> vector = new Vector<ExportReferenceDataData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        ExportReferenceDataData objectExportReferenceDataData = new ExportReferenceDataData();
        objectExportReferenceDataData.javapackage = UtilSql.getValue(result, "javapackage");
        objectExportReferenceDataData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExportReferenceDataData);
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
    ExportReferenceDataData objectExportReferenceDataData[] = new ExportReferenceDataData[vector.size()];
    vector.copyInto(objectExportReferenceDataData);
    return(objectExportReferenceDataData);
  }
}
