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

class ReportValuationStockLegacyData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportValuationStockLegacyData.class);
  private String InitRecordNumber="0";
  public String categoryName;
  public String mProductId;
  public String productName;
  public String qty;
  public String uomName;
  public String averageCost;
  public String totalCost;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("category_name") || fieldName.equals("categoryName"))
      return categoryName;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("uom_name") || fieldName.equals("uomName"))
      return uomName;
    else if (fieldName.equalsIgnoreCase("average_cost") || fieldName.equals("averageCost"))
      return averageCost;
    else if (fieldName.equalsIgnoreCase("total_cost") || fieldName.equals("totalCost"))
      return totalCost;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportValuationStockLegacyData[] select(ConnectionProvider connectionProvider, String adLanguage, String date, String cCurrencyBase, String cCurrencyConv, String datePlus, String warehouse, String categoryProduct)    throws ServletException {
    return select(connectionProvider, adLanguage, date, cCurrencyBase, cCurrencyConv, datePlus, warehouse, categoryProduct, 0, 0);
  }

  public static ReportValuationStockLegacyData[] select(ConnectionProvider connectionProvider, String adLanguage, String date, String cCurrencyBase, String cCurrencyConv, String datePlus, String warehouse, String categoryProduct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT CATEGORY_NAME, M_PRODUCT_ID, PRODUCT_NAME, QTY, UOM_NAME, AVERAGE_COST, TOTAL_COST FROM (" +
      "      SELECT M_PRODUCT_CATEGORY.NAME AS CATEGORY_NAME, A.M_PRODUCT_ID, AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(M_PRODUCT.M_PRODUCT_ID), TO_CHAR(?)) AS PRODUCT_NAME, " +
      "      A.QTY, C_UOM.NAME AS UOM_NAME, " +
      "      C_CURRENCY_CONVERT_PRECISION(M_GET_PRODUCT_COST(A.M_PRODUCT_ID,TO_DATE(?), NULL), ?, ?, COALESCE(MC.DATEFROM,TO_DATE(?)), NULL, MC.AD_CLIENT_ID, MC.AD_ORG_ID, 'C') AS AVERAGE_COST,       " +
      "      C_CURRENCY_CONVERT_PRECISION(M_GET_PRODUCT_COST(A.M_PRODUCT_ID,TO_DATE(?), NULL)*A.QTY, ?, ?, COALESCE(MC.DATEFROM,TO_DATE(?)), NULL, MC.AD_CLIENT_ID, MC.AD_ORG_ID, 'C') AS TOTAL_COST" +
      "      FROM M_PRODUCT_CATEGORY," +
      "      (SELECT M_PRODUCT_ID, SUM(MOVEMENTQTY) AS QTY, C_UOM_ID FROM M_TRANSACTION, M_LOCATOR" +
      "      WHERE M_TRANSACTION.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND MOVEMENTDATE < to_date(?)" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = ?" +
      "      GROUP BY M_PRODUCT_ID, C_UOM_ID) A, C_UOM," +
      "      M_PRODUCT LEFT JOIN M_COSTING MC ON MC.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      WHERE A.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND A.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND 1=1";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "      AND A.QTY <>0) ZZ" +
      "      GROUP BY M_PRODUCT_ID, CATEGORY_NAME , PRODUCT_NAME, QTY, UOM_NAME, AVERAGE_COST, TOTAL_COST" +
      "      ORDER BY CATEGORY_NAME, PRODUCT_NAME";

    ResultSet result;
    Vector<ReportValuationStockLegacyData> vector = new Vector<ReportValuationStockLegacyData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
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
        ReportValuationStockLegacyData objectReportValuationStockLegacyData = new ReportValuationStockLegacyData();
        objectReportValuationStockLegacyData.categoryName = UtilSql.getValue(result, "category_name");
        objectReportValuationStockLegacyData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportValuationStockLegacyData.productName = UtilSql.getValue(result, "product_name");
        objectReportValuationStockLegacyData.qty = UtilSql.getValue(result, "qty");
        objectReportValuationStockLegacyData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportValuationStockLegacyData.averageCost = UtilSql.getValue(result, "average_cost");
        objectReportValuationStockLegacyData.totalCost = UtilSql.getValue(result, "total_cost");
        objectReportValuationStockLegacyData.rownum = Long.toString(countRecord);
        objectReportValuationStockLegacyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportValuationStockLegacyData);
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
    ReportValuationStockLegacyData objectReportValuationStockLegacyData[] = new ReportValuationStockLegacyData[vector.size()];
    vector.copyInto(objectReportValuationStockLegacyData);
    return(objectReportValuationStockLegacyData);
  }

  public static ReportValuationStockLegacyData[] set()    throws ServletException {
    ReportValuationStockLegacyData objectReportValuationStockLegacyData[] = new ReportValuationStockLegacyData[1];
    objectReportValuationStockLegacyData[0] = new ReportValuationStockLegacyData();
    objectReportValuationStockLegacyData[0].categoryName = "";
    objectReportValuationStockLegacyData[0].mProductId = "";
    objectReportValuationStockLegacyData[0].productName = "";
    objectReportValuationStockLegacyData[0].qty = "";
    objectReportValuationStockLegacyData[0].uomName = "";
    objectReportValuationStockLegacyData[0].averageCost = "";
    objectReportValuationStockLegacyData[0].totalCost = "";
    return objectReportValuationStockLegacyData;
  }
}
