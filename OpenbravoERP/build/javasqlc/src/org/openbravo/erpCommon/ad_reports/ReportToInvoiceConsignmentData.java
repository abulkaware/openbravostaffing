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

class ReportToInvoiceConsignmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportToInvoiceConsignmentData.class);
  private String InitRecordNumber="0";
  public String mwarehouse;
  public String productname;
  public String cProjectId;
  public String movementqty;
  public String quantityorder;
  public String bpartnername;
  public String uomname1;
  public String uomname2;
  public String category;
  public String plannedpoprice;
  public String convplannedpoprice;
  public String netamt;
  public String convnetamt;
  public String transcurrencyid;
  public String transdate;
  public String transclientid;
  public String transorgid;
  public String transym;
  public String convsym;
  public String convisosym;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("mwarehouse"))
      return mwarehouse;
    else if (fieldName.equalsIgnoreCase("productname"))
      return productname;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("bpartnername"))
      return bpartnername;
    else if (fieldName.equalsIgnoreCase("uomname1"))
      return uomname1;
    else if (fieldName.equalsIgnoreCase("uomname2"))
      return uomname2;
    else if (fieldName.equalsIgnoreCase("category"))
      return category;
    else if (fieldName.equalsIgnoreCase("plannedpoprice"))
      return plannedpoprice;
    else if (fieldName.equalsIgnoreCase("convplannedpoprice"))
      return convplannedpoprice;
    else if (fieldName.equalsIgnoreCase("netamt"))
      return netamt;
    else if (fieldName.equalsIgnoreCase("convnetamt"))
      return convnetamt;
    else if (fieldName.equalsIgnoreCase("transcurrencyid"))
      return transcurrencyid;
    else if (fieldName.equalsIgnoreCase("transdate"))
      return transdate;
    else if (fieldName.equalsIgnoreCase("transclientid"))
      return transclientid;
    else if (fieldName.equalsIgnoreCase("transorgid"))
      return transorgid;
    else if (fieldName.equalsIgnoreCase("transym"))
      return transym;
    else if (fieldName.equalsIgnoreCase("convsym"))
      return convsym;
    else if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportToInvoiceConsignmentData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String mWarehouseId)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserClient, adOrgClient, parDateFrom, parDateTo, mWarehouseId, 0, 0);
  }

  public static ReportToInvoiceConsignmentData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String mWarehouseId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT A.MWAREHOUSE, A.PRODUCTNAME, A.C_PROJECT_ID, SUM(A.MOVEMENTQTY) AS MOVEMENTQTY, " +
      "      SUM(A.QUANTITYORDER) AS QUANTITYORDER, A.BPARTNERNAME, A.UOMNAME1, A.UOMNAME2, A.CATEGORY," +
      "      C_PROJECTLINE.PLANNEDPOPRICE," +
      "	  C_CURRENCY_CONVERT(C_PROJECTLINE.PLANNEDPOPRICE, C_PROJECT.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, NOW())), NULL, C_PROJECTLINE.AD_CLIENT_ID, C_PROJECTLINE.AD_ORG_ID) AS CONVPLANNEDPOPRICE,       " +
      "      SUM(A.MOVEMENTQTY)*C_PROJECTLINE.PLANNEDPOPRICE AS NETAMT," +
      "      C_CURRENCY_CONVERT(SUM(A.MOVEMENTQTY)*C_PROJECTLINE.PLANNEDPOPRICE, C_PROJECT.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, NOW())), NULL, C_PROJECTLINE.AD_CLIENT_ID, C_PROJECTLINE.AD_ORG_ID) AS CONVNETAMT,             " +
      "      C_PROJECT.C_CURRENCY_ID AS TRANSCURRENCYID," +
      "	  TO_DATE(COALESCE(C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, NOW())) AS TRANSDATE," +
      "	  C_PROJECTLINE.AD_CLIENT_ID AS TRANSCLIENTID, " +
      "	  C_PROJECTLINE.AD_ORG_ID AS TRANSORGID," +
      "	  C_CURRENCY_SYMBOL(C_PROJECT.C_CURRENCY_ID, '0', 'Y') AS TRANSYM," +
      "	  C_CURRENCY_SYMBOL(?, '0', 'Y') AS CONVSYM," +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM" +
      "      FROM (SELECT M_WAREHOUSE.NAME AS MWAREHOUSE, M_PRODUCT.NAME AS PRODUCTNAME, M_INOUTLINE.MOVEMENTQTY, " +
      "      M_INOUTLINE.QUANTITYORDER, C_BPARTNER.NAME AS BPARTNERNAME, C_PROJECT.C_PROJECT_ID, " +
      "      M_PRODUCT.M_PRODUCT_ID, C1.NAME AS UOMNAME1, C2.NAME AS UOMNAME2, M_PRODUCT.M_PRODUCT_CATEGORY_ID AS CATEGORY " +
      "      FROM M_INOUTLINE left join C_UOM C2 on M_INOUTLINE.C_UOM_ID = C2.C_UOM_ID" +
      "                       left join M_PRODUCT_UOM on M_INOUTLINE.M_PRODUCT_UOM_ID = M_PRODUCT_UOM.M_PRODUCT_UOM_ID" +
      "                       left join C_UOM C1 on M_PRODUCT_UOM.C_UOM_ID = C1.C_UOM_ID," +
      "           M_LOCATOR, M_WAREHOUSE, M_PRODUCT, C_PROJECT, C_BPARTNER, M_INOUT" +
      "          WHERE M_INOUT.M_INOUT_ID = M_INOUTLINE.M_INOUT_ID" +
      "      AND M_INOUTLINE.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND M_INOUTLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_INOUT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "      AND C_PROJECT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND M_INOUT.ISSOTRX = 'Y'" +
      "      AND M_INOUT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_INOUT.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_INOUT.MOVEMENTDATE >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND M_INOUT.MOVEMENTDATE < TO_DATE(?) ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      "      UNION ALL" +
      "      SELECT M_WAREHOUSE.NAME AS MWAREHOUSE, M_PRODUCT.NAME AS PRODUCTNAME, M_MOVEMENTLINE.MOVEMENTQTY, " +
      "      M_MOVEMENTLINE.QUANTITYORDER, C_BPARTNER.NAME AS BPARTNERNAEM, C_PROJECT.C_PROJECT_ID, " +
      "      M_PRODUCT.M_PRODUCT_ID, C1.NAME AS UOMNAME, C2.NAME AS UOMNAME2, M_PRODUCT.M_PRODUCT_CATEGORY_ID AS CATEGORY" +
      "      FROM M_MOVEMENTLINE left join M_PRODUCT_UOM on M_MOVEMENTLINE.M_PRODUCT_UOM_ID = M_PRODUCT_UOM.M_PRODUCT_UOM_ID" +
      "                          left join C_UOM C1 on M_PRODUCT_UOM.C_UOM_ID = C1.C_UOM_ID" +
      "                          left join C_UOM C2 on M_MOVEMENTLINE.C_UOM_ID = C2.C_UOM_ID," +
      "      M_MOVEMENT, M_LOCATOR, M_WAREHOUSE, M_PRODUCT, C_PROJECT, C_BPARTNER" +
      "      WHERE M_MOVEMENT.M_MOVEMENT_ID = M_MOVEMENTLINE.M_MOVEMENT_ID" +
      "      AND M_MOVEMENTLINE.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND M_MOVEMENTLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_MOVEMENT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "      AND C_PROJECT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND M_MOVEMENT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_MOVEMENT.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND 2=2";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_MOVEMENT.MOVEMENTDATE >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND M_MOVEMENT.MOVEMENTDATE < TO_DATE(?) ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      ") A, C_PROJECTLINE, C_PROJECT" +
      "      WHERE C_PROJECTLINE.C_PROJECT_ID = A.C_PROJECT_ID" +
      "      AND C_PROJECTLINE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "      AND C_PROJECTLINE.M_PRODUCT_ID = A.M_PRODUCT_ID " +
      "      GROUP BY C_PROJECTLINE.PLANNEDPOPRICE, A.MWAREHOUSE, A.PRODUCTNAME, A.C_PROJECT_ID," +
      "      A.BPARTNERNAME, A.UOMNAME1, A.UOMNAME2, A.CATEGORY," +
      "      C_PROJECT.C_CURRENCY_ID, C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, " +
      "	  C_PROJECTLINE.AD_CLIENT_ID, C_PROJECTLINE.AD_ORG_ID" +
      "      ORDER BY BPARTNERNAME";

    ResultSet result;
    Vector<ReportToInvoiceConsignmentData> vector = new Vector<ReportToInvoiceConsignmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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
        ReportToInvoiceConsignmentData objectReportToInvoiceConsignmentData = new ReportToInvoiceConsignmentData();
        objectReportToInvoiceConsignmentData.mwarehouse = UtilSql.getValue(result, "mwarehouse");
        objectReportToInvoiceConsignmentData.productname = UtilSql.getValue(result, "productname");
        objectReportToInvoiceConsignmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectReportToInvoiceConsignmentData.movementqty = UtilSql.getValue(result, "movementqty");
        objectReportToInvoiceConsignmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectReportToInvoiceConsignmentData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectReportToInvoiceConsignmentData.uomname1 = UtilSql.getValue(result, "uomname1");
        objectReportToInvoiceConsignmentData.uomname2 = UtilSql.getValue(result, "uomname2");
        objectReportToInvoiceConsignmentData.category = UtilSql.getValue(result, "category");
        objectReportToInvoiceConsignmentData.plannedpoprice = UtilSql.getValue(result, "plannedpoprice");
        objectReportToInvoiceConsignmentData.convplannedpoprice = UtilSql.getValue(result, "convplannedpoprice");
        objectReportToInvoiceConsignmentData.netamt = UtilSql.getValue(result, "netamt");
        objectReportToInvoiceConsignmentData.convnetamt = UtilSql.getValue(result, "convnetamt");
        objectReportToInvoiceConsignmentData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportToInvoiceConsignmentData.transdate = UtilSql.getDateValue(result, "transdate", "dd-MM-yyyy");
        objectReportToInvoiceConsignmentData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportToInvoiceConsignmentData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportToInvoiceConsignmentData.transym = UtilSql.getValue(result, "transym");
        objectReportToInvoiceConsignmentData.convsym = UtilSql.getValue(result, "convsym");
        objectReportToInvoiceConsignmentData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportToInvoiceConsignmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportToInvoiceConsignmentData);
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
    ReportToInvoiceConsignmentData objectReportToInvoiceConsignmentData[] = new ReportToInvoiceConsignmentData[vector.size()];
    vector.copyInto(objectReportToInvoiceConsignmentData);
    return(objectReportToInvoiceConsignmentData);
  }

  public static ReportToInvoiceConsignmentData[] set()    throws ServletException {
    ReportToInvoiceConsignmentData objectReportToInvoiceConsignmentData[] = new ReportToInvoiceConsignmentData[1];
    objectReportToInvoiceConsignmentData[0] = new ReportToInvoiceConsignmentData();
    objectReportToInvoiceConsignmentData[0].mwarehouse = "";
    objectReportToInvoiceConsignmentData[0].productname = "";
    objectReportToInvoiceConsignmentData[0].cProjectId = "";
    objectReportToInvoiceConsignmentData[0].movementqty = "";
    objectReportToInvoiceConsignmentData[0].quantityorder = "";
    objectReportToInvoiceConsignmentData[0].bpartnername = "";
    objectReportToInvoiceConsignmentData[0].uomname1 = "";
    objectReportToInvoiceConsignmentData[0].uomname2 = "";
    objectReportToInvoiceConsignmentData[0].category = "";
    objectReportToInvoiceConsignmentData[0].plannedpoprice = "";
    objectReportToInvoiceConsignmentData[0].convplannedpoprice = "";
    objectReportToInvoiceConsignmentData[0].netamt = "";
    objectReportToInvoiceConsignmentData[0].convnetamt = "";
    objectReportToInvoiceConsignmentData[0].transcurrencyid = "";
    objectReportToInvoiceConsignmentData[0].transdate = "";
    objectReportToInvoiceConsignmentData[0].transclientid = "";
    objectReportToInvoiceConsignmentData[0].transorgid = "";
    objectReportToInvoiceConsignmentData[0].transym = "";
    objectReportToInvoiceConsignmentData[0].convsym = "";
    objectReportToInvoiceConsignmentData[0].convisosym = "";
    return objectReportToInvoiceConsignmentData;
  }
}
