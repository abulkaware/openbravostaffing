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

class ReportWarehousePartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportWarehousePartnerData.class);
  private String InitRecordNumber="0";
  public String categoryname;
  public String name;
  public String movementqty;
  public String x;
  public String y;
  public String warehouse;
  public String z;
  public String uommovementqty;
  public String mAttributesetinstanceId;
  public String description;
  public String weight;
  public String uomweight;
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("categoryname"))
      return categoryname;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("x"))
      return x;
    else if (fieldName.equalsIgnoreCase("y"))
      return y;
    else if (fieldName.equalsIgnoreCase("warehouse"))
      return warehouse;
    else if (fieldName.equalsIgnoreCase("z"))
      return z;
    else if (fieldName.equalsIgnoreCase("uommovementqty"))
      return uommovementqty;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("uomweight"))
      return uomweight;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportWarehousePartnerData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String parDate, String mProduct, String mLocator, String mProductCategory, String locatorX, String locatorY, String locatorZ)    throws ServletException {
    return select(connectionProvider, language, adUserClient, adOrgClient, parDate, mProduct, mLocator, mProductCategory, locatorX, locatorY, locatorZ, 0, 0);
  }

  public static ReportWarehousePartnerData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String parDate, String mProduct, String mLocator, String mProductCategory, String locatorX, String locatorY, String locatorZ, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_PRODUCT_CATEGORY.NAME AS CATEGORYNAME, M_PRODUCT.VALUE||'-'||M_PRODUCT.NAME AS NAME, SUM(MOVEMENTQTY) AS MOVEMENTQTY, M_LOCATOR.X, M_LOCATOR.Y, " +
      "      AD_COLUMN_IDENTIFIER('M_WAREHOUSE', to_char(M_LOCATOR.M_WAREHOUSE_ID), ?) AS WAREHOUSE," +
      "      M_LOCATOR.Z, C1.NAME AS UOMMOVEMENTQTY, M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID, M_ATTRIBUTESETINSTANCE.DESCRIPTION," +
      "      (CASE WHEN M_TRANSACTION.M_PRODUCT_UOM_ID IS NULL THEN (CASE M_PRODUCT.WEIGHT*SUM(M_TRANSACTION.MOVEMENTQTY) WHEN 0 THEN NULL ELSE M_PRODUCT.WEIGHT*SUM(M_TRANSACTION.MOVEMENTQTY) END) ELSE SUM(M_TRANSACTION.QUANTITYORDER) END) AS WEIGHT, " +
      "      (CASE WHEN M_PRODUCT.WEIGHT = 0 THEN '' WHEN M_PRODUCT.WEIGHT IS NULL THEN '' ELSE TO_CHAR(C2.UOMSYMBOL) END) AS UOMWEIGHT, '' as id" +
      "      FROM M_PRODUCT left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID  = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID," +
      "           M_PRODUCT_UOM right join M_TRANSACTION on M_TRANSACTION.M_PRODUCT_UOM_ID = M_PRODUCT_UOM.M_PRODUCT_UOM_ID" +
      "                         left join AD_CLIENTINFO CI on CI.AD_CLIENT_ID = M_TRANSACTION.AD_CLIENT_ID" +
      "                         left join C_UOM C2 on CI.C_UOM_WEIGHT_ID = C2.C_UOM_ID," +
      "        M_LOCATOR, C_UOM C1, M_ATTRIBUTESETINSTANCE" +
      "      WHERE M_TRANSACTION.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_TRANSACTION.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID" +
      "      AND M_TRANSACTION.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID " +
      "      AND M_TRANSACTION.C_UOM_ID = C1.C_UOM_ID" +
      "      AND M_TRANSACTION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_LOCATOR.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDate==null || parDate.equals(""))?"":"  AND M_TRANSACTION.MOVEMENTDATE < to_date(?) ");
    strSql = strSql + ((mProduct==null || mProduct.equals(""))?"":"  AND M_TRANSACTION.M_PRODUCT_ID IN" + mProduct);
    strSql = strSql + ((mLocator==null || mLocator.equals(""))?"":"  AND M_LOCATOR.M_LOCATOR_ID IN" + mLocator);
    strSql = strSql + ((mProductCategory==null || mProductCategory.equals(""))?"":"  AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((locatorX==null || locatorX.equals(""))?"":"  AND UPPER(M_LOCATOR.X) = UPPER(?) ");
    strSql = strSql + ((locatorY==null || locatorY.equals(""))?"":"  AND UPPER(M_LOCATOR.Y) = UPPER(?) ");
    strSql = strSql + ((locatorZ==null || locatorZ.equals(""))?"":"  AND UPPER(M_LOCATOR.Z) = UPPER(?) ");
    strSql = strSql + 
      "      GROUP BY M_PRODUCT_CATEGORY.NAME,M_PRODUCT.VALUE, M_PRODUCT.NAME, M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID, M_ATTRIBUTESETINSTANCE.DESCRIPTION, M_LOCATOR.M_LOCATOR_ID, M_LOCATOR.X, M_LOCATOR.Y, M_LOCATOR.Z, C1.NAME, M_PRODUCT.WEIGHT, C1.C_UOM_ID, M_TRANSACTION.M_PRODUCT_UOM_ID, C2.UOMSYMBOL, M_LOCATOR.M_WAREHOUSE_ID" +
      "      HAVING SUM(MOVEMENTQTY) <> 0" +
      "      ORDER BY  M_PRODUCT_CATEGORY.NAME,M_PRODUCT.VALUE, M_PRODUCT.NAME, M_ATTRIBUTESETINSTANCE.DESCRIPTION,M_LOCATOR.X, M_LOCATOR.Y, M_LOCATOR.Z";

    ResultSet result;
    Vector<ReportWarehousePartnerData> vector = new Vector<ReportWarehousePartnerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDate != null && !(parDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDate);
      }
      if (mProduct != null && !(mProduct.equals(""))) {
        }
      if (mLocator != null && !(mLocator.equals(""))) {
        }
      if (mProductCategory != null && !(mProductCategory.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategory);
      }
      if (locatorX != null && !(locatorX.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorX);
      }
      if (locatorY != null && !(locatorY.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorY);
      }
      if (locatorZ != null && !(locatorZ.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorZ);
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
        ReportWarehousePartnerData objectReportWarehousePartnerData = new ReportWarehousePartnerData();
        objectReportWarehousePartnerData.categoryname = UtilSql.getValue(result, "categoryname");
        objectReportWarehousePartnerData.name = UtilSql.getValue(result, "name");
        objectReportWarehousePartnerData.movementqty = UtilSql.getValue(result, "movementqty");
        objectReportWarehousePartnerData.x = UtilSql.getValue(result, "x");
        objectReportWarehousePartnerData.y = UtilSql.getValue(result, "y");
        objectReportWarehousePartnerData.warehouse = UtilSql.getValue(result, "warehouse");
        objectReportWarehousePartnerData.z = UtilSql.getValue(result, "z");
        objectReportWarehousePartnerData.uommovementqty = UtilSql.getValue(result, "uommovementqty");
        objectReportWarehousePartnerData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectReportWarehousePartnerData.description = UtilSql.getValue(result, "description");
        objectReportWarehousePartnerData.weight = UtilSql.getValue(result, "weight");
        objectReportWarehousePartnerData.uomweight = UtilSql.getValue(result, "uomweight");
        objectReportWarehousePartnerData.id = UtilSql.getValue(result, "id");
        objectReportWarehousePartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportWarehousePartnerData);
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
    ReportWarehousePartnerData objectReportWarehousePartnerData[] = new ReportWarehousePartnerData[vector.size()];
    vector.copyInto(objectReportWarehousePartnerData);
    return(objectReportWarehousePartnerData);
  }
}
