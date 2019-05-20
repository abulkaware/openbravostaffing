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

class ReportWarehouseControlData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportWarehouseControlData.class);
  private String InitRecordNumber="0";
  public String description;
  public String productname;
  public String referential;
  public String movementdate;
  public String movementqty;
  public String ubication;
  public String id;
  public String inp;
  public String uom;
  public String locator;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("productname"))
      return productname;
    else if (fieldName.equalsIgnoreCase("referential"))
      return referential;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("ubication"))
      return ubication;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("inp"))
      return inp;
    else if (fieldName.equalsIgnoreCase("uom"))
      return uom;
    else if (fieldName.equalsIgnoreCase("locator"))
      return locator;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportWarehouseControlData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String reference, String pgLimit, String oraLimit1)    throws ServletException {
    return select(connectionProvider, adUserClient, adOrgClient, parDateFrom, parDateTo, reference, pgLimit, oraLimit1, 0, 0);
  }

  public static ReportWarehouseControlData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String reference, String pgLimit, String oraLimit1, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.* FROM ( " +
      "      SELECT A.DESCRIPTION, M_PRODUCT.NAME AS PRODUCTNAME, " +
      "      SUBSTR(M_ATTRIBUTESETINSTANCE.DESCRIPTION, 2, (LENGTH(M_ATTRIBUTESETINSTANCE.DESCRIPTION)-1)) AS REFERENTIAL, M_TRANSACTION.MOVEMENTDATE, SUM(M_TRANSACTION.MOVEMENTQTY) AS MOVEMENTQTY, A.UBICATION, A.ID, A.INP, C_UOM.NAME AS UOM, M_LOCATOR.VALUE AS LOCATOR" +
      "      FROM (SELECT (M_INOUT.DOCUMENTNO||' '||M_INOUT.MOVEMENTDATE||' '||COALESCE(TO_CHAR(C_PROJECT.VALUE), '')) AS DESCRIPTION, M_TRANSACTION.M_TRANSACTION_ID, M_INOUT.M_INOUT_ID AS ID, (CASE M_INOUT.ISSOTRX WHEN 'Y' THEN '257' ELSE '296' END) AS UBICATION, 'inpmInoutId' AS INP" +
      "      FROM M_TRANSACTION, M_INOUTLINE, M_INOUT left join C_PROJECT on M_INOUT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "      WHERE M_TRANSACTION.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "      AND M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "      UNION" +
      "      SELECT (M_PRODUCTION.NAME||' '||M_PRODUCTION.MOVEMENTDATE||' '||COALESCE(TO_CHAR(C_PROJECT.VALUE), '')) AS DESCRIPTION, M_TRANSACTION.M_TRANSACTION_ID, M_PRODUCTION.M_PRODUCTION_ID AS ID, '319'  AS UBICATION, 'inpmProductionId' AS INP" +
      "      FROM M_TRANSACTION, M_PRODUCTIONLINE, M_PRODUCTIONPLAN, M_PRODUCTION left join C_PROJECT on M_PRODUCTION.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "      WHERE M_TRANSACTION.M_PRODUCTIONLINE_ID = M_PRODUCTIONLINE.M_PRODUCTIONLINE_ID" +
      "      AND M_PRODUCTIONLINE.M_PRODUCTIONPLAN_ID = M_PRODUCTIONPLAN.M_PRODUCTIONPLAN_ID" +
      "      AND M_PRODUCTIONPLAN.M_PRODUCTION_ID = M_PRODUCTION.M_PRODUCTION_ID" +
      "      UNION" +
      "      SELECT (M_INVENTORY.NAME||' '||M_INVENTORY.MOVEMENTDATE||' '||COALESCE(TO_CHAR(C_PROJECT.VALUE), '')) AS DESCRIPTION, M_TRANSACTION.M_TRANSACTION_ID, M_INVENTORY.M_INVENTORY_ID AS ID, '255' AS UBICATION, 'inpmInventoryId' AS INP" +
      "      FROM M_TRANSACTION, M_INVENTORYLINE, M_INVENTORY left join C_PROJECT on M_INVENTORY.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "      WHERE M_TRANSACTION.M_INVENTORYLINE_ID = M_INVENTORYLINE.M_INVENTORYLINE_ID" +
      "      AND M_INVENTORYLINE.M_INVENTORY_ID = M_INVENTORY.M_INVENTORY_ID" +
      "      UNION" +
      "      SELECT (M_MOVEMENT.NAME||' '||M_MOVEMENT.MOVEMENTDATE||' '||COALESCE(TO_CHAR(C_PROJECT.VALUE), '')) AS DESCRIPTION, M_TRANSACTION.M_TRANSACTION_ID, M_MOVEMENT.M_MOVEMENT_ID AS ID, '259' AS UBICATION, 'inpmMovementId' AS INP" +
      "      FROM M_TRANSACTION, M_MOVEMENTLINE, M_MOVEMENT left join C_PROJECT on M_MOVEMENT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "      WHERE M_TRANSACTION.M_MOVEMENTLINE_ID = M_MOVEMENTLINE.M_MOVEMENTLINE_ID" +
      "      AND M_MOVEMENTLINE.M_MOVEMENT_ID = M_MOVEMENT.M_MOVEMENT_ID) A, M_TRANSACTION, M_PRODUCT, M_ATTRIBUTESETINSTANCE, C_UOM, M_LOCATOR" +
      "      WHERE M_TRANSACTION.M_TRANSACTION_ID = A.M_TRANSACTION_ID" +
      "      AND M_TRANSACTION.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND M_TRANSACTION.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_TRANSACTION.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID" +
      "      AND M_TRANSACTION.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND M_TRANSACTION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_TRANSACTION.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_TRANSACTION.MOVEMENTDATE >= to_date(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND M_TRANSACTION.MOVEMENTDATE < to_date(?) ");
    strSql = strSql + ((reference==null || reference.equals(""))?"":"  AND UPPER(M_ATTRIBUTESETINSTANCE.DESCRIPTION) LIKE '%'||UPPER(?)||'%' ");
    strSql = strSql + 
      "      GROUP BY A.DESCRIPTION, M_PRODUCT.NAME, M_LOCATOR.M_LOCATOR_ID, M_LOCATOR.VALUE, M_ATTRIBUTESETINSTANCE.DESCRIPTION, M_TRANSACTION.MOVEMENTDATE, A.ID, A.UBICATION, A.INP, C_UOM.NAME" +
      "      HAVING SUM(M_TRANSACTION.MOVEMENTQTY) <> 0" +
      "      ORDER BY A.ID, M_PRODUCT.NAME" +
      "      ) B";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":" WHERE ROWNUM <= " + oraLimit1);

    ResultSet result;
    Vector<ReportWarehouseControlData> vector = new Vector<ReportWarehouseControlData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
      if (reference != null && !(reference.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, reference);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
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
        ReportWarehouseControlData objectReportWarehouseControlData = new ReportWarehouseControlData();
        objectReportWarehouseControlData.description = UtilSql.getValue(result, "description");
        objectReportWarehouseControlData.productname = UtilSql.getValue(result, "productname");
        objectReportWarehouseControlData.referential = UtilSql.getValue(result, "referential");
        objectReportWarehouseControlData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectReportWarehouseControlData.movementqty = UtilSql.getValue(result, "movementqty");
        objectReportWarehouseControlData.ubication = UtilSql.getValue(result, "ubication");
        objectReportWarehouseControlData.id = UtilSql.getValue(result, "id");
        objectReportWarehouseControlData.inp = UtilSql.getValue(result, "inp");
        objectReportWarehouseControlData.uom = UtilSql.getValue(result, "uom");
        objectReportWarehouseControlData.locator = UtilSql.getValue(result, "locator");
        objectReportWarehouseControlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportWarehouseControlData);
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
    ReportWarehouseControlData objectReportWarehouseControlData[] = new ReportWarehouseControlData[vector.size()];
    vector.copyInto(objectReportWarehouseControlData);
    return(objectReportWarehouseControlData);
  }

  public static ReportWarehouseControlData[] set()    throws ServletException {
    ReportWarehouseControlData objectReportWarehouseControlData[] = new ReportWarehouseControlData[1];
    objectReportWarehouseControlData[0] = new ReportWarehouseControlData();
    objectReportWarehouseControlData[0].description = "";
    objectReportWarehouseControlData[0].productname = "";
    objectReportWarehouseControlData[0].referential = "";
    objectReportWarehouseControlData[0].movementdate = "";
    objectReportWarehouseControlData[0].movementqty = "";
    objectReportWarehouseControlData[0].ubication = "";
    objectReportWarehouseControlData[0].id = "";
    objectReportWarehouseControlData[0].inp = "";
    objectReportWarehouseControlData[0].uom = "";
    objectReportWarehouseControlData[0].locator = "";
    return objectReportWarehouseControlData;
  }
}
