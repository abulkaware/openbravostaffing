//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportProductionData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProductionData.class);
  private String InitRecordNumber="0";
  public String productionName;
  public String movementdate;
  public String productName;
  public String movementqty;
  public String description;
  public String uomName;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("production_name") || fieldName.equals("productionName"))
      return productionName;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("uom_name") || fieldName.equals("uomName"))
      return uomName;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportProductionData[] select(ConnectionProvider connectionProvider, String isRaw, String adUserClient, String adUserOrg, String dateFrom, String dateTo)    throws ServletException {
    return select(connectionProvider, isRaw, adUserClient, adUserOrg, dateFrom, dateTo, 0, 0);
  }

  public static ReportProductionData[] select(ConnectionProvider connectionProvider, String isRaw, String adUserClient, String adUserOrg, String dateFrom, String dateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PRODUCTION_NAME, MOVEMENTDATE, PRODUCT_NAME, MOVEMENTQTY, DESCRIPTION, UOM_NAME" +
      "      FROM (SELECT M_PRODUCTION.NAME AS PRODUCTION_NAME, M_PRODUCTION.MOVEMENTDATE, M_PRODUCT.NAME AS PRODUCT_NAME, " +
      "      SUM((CASE ? WHEN 'Y' THEN ROUND(M_PRODUCTIONLINE.MOVEMENTQTY, 2) ELSE (CASE SIGN(M_PRODUCTIONLINE.MOVEMENTQTY) WHEN -1 THEN 0 ELSE ROUND(M_PRODUCTIONLINE.MOVEMENTQTY, 2) END) END)) AS MOVEMENTQTY, M_ATTRIBUTESETINSTANCE.DESCRIPTION, C_UOM.NAME AS UOM_NAME" +
      "      FROM M_PRODUCTIONLINE left join M_ATTRIBUTESETINSTANCE on M_PRODUCTIONLINE.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID," +
      "      M_PRODUCTION, M_PRODUCTIONPLAN,  M_PRODUCT,  C_UOM" +
      "      WHERE M_PRODUCTION.M_PRODUCTION_ID = M_PRODUCTIONPLAN.M_PRODUCTION_ID" +
      "      AND M_PRODUCTIONPLAN.M_PRODUCTIONPLAN_ID = M_PRODUCTIONLINE.M_PRODUCTIONPLAN_ID" +
      "      AND M_PRODUCTIONLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCTIONLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND M_PRODUCTION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_PRODUCTION.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND M_PRODUCTION.PROCESSED = 'Y'" +
      "      AND M_PRODUCTION.MOVEMENTDATE >= to_date(?)" +
      "      AND M_PRODUCTION.MOVEMENTDATE < to_date(?)" +
      "      AND M_PRODUCTION.ISSOTRX = 'Y'" +
      "      GROUP BY M_PRODUCTION.NAME, M_PRODUCTION.MOVEMENTDATE, M_PRODUCT.NAME, M_ATTRIBUTESETINSTANCE.DESCRIPTION, C_UOM.NAME" +
      "      ORDER BY PRODUCTION_NAME, MOVEMENTDATE, MOVEMENTQTY DESC) AA" +
      "      WHERE MOVEMENTQTY <> 0";

    ResultSet result;
    Vector<ReportProductionData> vector = new Vector<ReportProductionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isRaw);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);

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
        ReportProductionData objectReportProductionData = new ReportProductionData();
        objectReportProductionData.productionName = UtilSql.getValue(result, "production_name");
        objectReportProductionData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectReportProductionData.productName = UtilSql.getValue(result, "product_name");
        objectReportProductionData.movementqty = UtilSql.getValue(result, "movementqty");
        objectReportProductionData.description = UtilSql.getValue(result, "description");
        objectReportProductionData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionData);
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
    ReportProductionData objectReportProductionData[] = new ReportProductionData[vector.size()];
    vector.copyInto(objectReportProductionData);
    return(objectReportProductionData);
  }

  public static ReportProductionData[] set()    throws ServletException {
    ReportProductionData objectReportProductionData[] = new ReportProductionData[1];
    objectReportProductionData[0] = new ReportProductionData();
    objectReportProductionData[0].productionName = "";
    objectReportProductionData[0].movementdate = "";
    objectReportProductionData[0].productName = "";
    objectReportProductionData[0].movementqty = "";
    objectReportProductionData[0].description = "";
    objectReportProductionData[0].uomName = "";
    return objectReportProductionData;
  }

  public static ReportProductionData[] selectSummering(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String dateFrom, String dateTo)    throws ServletException {
    return selectSummering(connectionProvider, adUserClient, adUserOrg, dateFrom, dateTo, 0, 0);
  }

  public static ReportProductionData[] selectSummering(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String dateFrom, String dateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_PRODUCT.NAME AS PRODUCT_NAME, SUM(ROUND(M_PRODUCTIONLINE.MOVEMENTQTY,2)) AS MOVEMENTQTY, C_UOM.NAME AS UOM_NAME" +
      "      FROM M_PRODUCTION, M_PRODUCTIONPLAN, M_PRODUCTIONLINE, M_PRODUCT, C_UOM" +
      "      WHERE M_PRODUCTION.M_PRODUCTION_ID = M_PRODUCTIONPLAN.M_PRODUCTION_ID" +
      "      AND M_PRODUCTIONPLAN.M_PRODUCTIONPLAN_ID = M_PRODUCTIONLINE.M_PRODUCTIONPLAN_ID" +
      "      AND M_PRODUCTIONLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCTIONLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND M_PRODUCTION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_PRODUCTION.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND M_PRODUCTION.PROCESSED = 'Y'" +
      "      AND M_PRODUCTIONLINE.MOVEMENTQTY > 0" +
      "      AND M_PRODUCTION.MOVEMENTDATE >= to_date(?)" +
      "      AND M_PRODUCTION.MOVEMENTDATE < to_date(?)" +
      "      AND M_PRODUCTION.ISSOTRX = 'Y'" +
      "      GROUP BY M_PRODUCT.NAME, C_UOM.NAME" +
      "      HAVING SUM(ROUND(M_PRODUCTIONLINE.MOVEMENTQTY,2)) > 0";

    ResultSet result;
    Vector<ReportProductionData> vector = new Vector<ReportProductionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);

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
        ReportProductionData objectReportProductionData = new ReportProductionData();
        objectReportProductionData.productName = UtilSql.getValue(result, "product_name");
        objectReportProductionData.movementqty = UtilSql.getValue(result, "movementqty");
        objectReportProductionData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionData);
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
    ReportProductionData objectReportProductionData[] = new ReportProductionData[vector.size()];
    vector.copyInto(objectReportProductionData);
    return(objectReportProductionData);
  }
}
