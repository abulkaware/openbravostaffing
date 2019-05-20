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

class ReportGuaranteeDateData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportGuaranteeDateData.class);
  private String InitRecordNumber="0";
  public String name;
  public String partnername;
  public String guaranteedate;
  public String movementqty;
  public String uom;
  public String weight;
  public String uom2;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("partnername"))
      return partnername;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("uom"))
      return uom;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("uom2"))
      return uom2;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportGuaranteeDateData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String parDate, String cBpartner, String mWarehouse)    throws ServletException {
    return select(connectionProvider, adUserClient, adOrgClient, parDate, cBpartner, mWarehouse, 0, 0);
  }

  public static ReportGuaranteeDateData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String parDate, String cBpartner, String mWarehouse, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT.NAME, C_BPARTNER.NAME AS PARTNERNAME, M_ATTRIBUTESETINSTANCE.GUARANTEEDATE AS GUARANTEEDATE, S.QTYONHAND AS MOVEMENTQTY, C1.NAME AS UOM," +
      "        (CASE WHEN S.M_PRODUCT_UOM_ID IS NULL THEN (CASE C1.C_UOM_ID WHEN '1000001' THEN NULL ELSE ((CASE WHEN M_PRODUCT.WEIGHT=0 THEN NULL WHEN M_PRODUCT.WEIGHT IS NULL THEN NULL ELSE M_PRODUCT.WEIGHT*S.QTYONHAND END)) END) ELSE S.QTYORDERONHAND END) AS WEIGHT, C2.NAME AS UOM2" +
      "        FROM M_STORAGE_DETAIL S left join M_PRODUCT on S.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                                left join M_PRODUCT_UOM on S.M_PRODUCT_UOM_ID = M_PRODUCT_UOM.M_PRODUCT_UOM_ID" +
      "                                left join C_BPARTNER on M_PRODUCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID " +
      "                                left join C_UOM C2 on M_PRODUCT_UOM.C_UOM_ID = C2.C_UOM_ID" +
      "                                left join M_ATTRIBUTESETINSTANCE on S.M_ATTRIBUTESETINSTANCE_ID =  M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID, " +
      "             C_UOM C1, M_LOCATOR, M_WAREHOUSE" +
      "        WHERE S.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "        AND M_LOCATOR.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "        AND S.C_UOM_ID = C1.C_UOM_ID" +
      "        AND S.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND S.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND S.QTYONHAND <>0" +
      "        AND 1=1";
    strSql = strSql + ((parDate==null || parDate.equals(""))?"":"  AND COALESCE(M_ATTRIBUTESETINSTANCE.GUARANTEEDATE, TO_DATE('31/12/9999', 'DD/MM/YYYY')) < to_date(?) ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID = ? ");
    strSql = strSql + ((mWarehouse==null || mWarehouse.equals(""))?"":"  AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      "        ORDER BY C_BPARTNER.NAME, GUARANTEEDATE DESC ";

    ResultSet result;
    Vector<ReportGuaranteeDateData> vector = new Vector<ReportGuaranteeDateData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDate != null && !(parDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDate);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartner);
      }
      if (mWarehouse != null && !(mWarehouse.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouse);
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
        ReportGuaranteeDateData objectReportGuaranteeDateData = new ReportGuaranteeDateData();
        objectReportGuaranteeDateData.name = UtilSql.getValue(result, "name");
        objectReportGuaranteeDateData.partnername = UtilSql.getValue(result, "partnername");
        objectReportGuaranteeDateData.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectReportGuaranteeDateData.movementqty = UtilSql.getValue(result, "movementqty");
        objectReportGuaranteeDateData.uom = UtilSql.getValue(result, "uom");
        objectReportGuaranteeDateData.weight = UtilSql.getValue(result, "weight");
        objectReportGuaranteeDateData.uom2 = UtilSql.getValue(result, "uom2");
        objectReportGuaranteeDateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGuaranteeDateData);
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
    ReportGuaranteeDateData objectReportGuaranteeDateData[] = new ReportGuaranteeDateData[vector.size()];
    vector.copyInto(objectReportGuaranteeDateData);
    return(objectReportGuaranteeDateData);
  }

  public static String selectBpartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BPARTNER.NAME" +
      "      FROM C_BPARTNER" +
      "      WHERE C_BPARTNER.C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static ReportGuaranteeDateData[] set()    throws ServletException {
    ReportGuaranteeDateData objectReportGuaranteeDateData[] = new ReportGuaranteeDateData[1];
    objectReportGuaranteeDateData[0] = new ReportGuaranteeDateData();
    objectReportGuaranteeDateData[0].name = "";
    return objectReportGuaranteeDateData;
  }
}
