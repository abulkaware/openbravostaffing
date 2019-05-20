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

class ReportValuationStockData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportValuationStockData.class);
  private String InitRecordNumber="0";
  public String categoryName;
  public String mProductId;
  public String productName;
  public String productSearchkey;
  public String qty;
  public String uomName;
  public String averageCost;
  public String totalCost;
  public String costType;
  public String valuationType;
  public String warehouse;
  public String id;
  public String padre;
  public String name;
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
    else if (fieldName.equalsIgnoreCase("product_searchkey") || fieldName.equals("productSearchkey"))
      return productSearchkey;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("uom_name") || fieldName.equals("uomName"))
      return uomName;
    else if (fieldName.equalsIgnoreCase("average_cost") || fieldName.equals("averageCost"))
      return averageCost;
    else if (fieldName.equalsIgnoreCase("total_cost") || fieldName.equals("totalCost"))
      return totalCost;
    else if (fieldName.equalsIgnoreCase("cost_type") || fieldName.equals("costType"))
      return costType;
    else if (fieldName.equalsIgnoreCase("valuation_type") || fieldName.equals("valuationType"))
      return valuationType;
    else if (fieldName.equalsIgnoreCase("warehouse"))
      return warehouse;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportValuationStockData[] select(ConnectionProvider connectionProvider, String adLanguage, String cCurrencyConv, String legalEntity, String datePlus, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String costOrg, String costClient, String costType, String warehouseDimension, String categoryProduct)    throws ServletException {
    return select(connectionProvider, adLanguage, cCurrencyConv, legalEntity, datePlus, maxaggDate, processTime, dateTimeFormat, organization, warehouse, costOrg, costClient, costType, warehouseDimension, categoryProduct, 0, 0);
  }

  public static ReportValuationStockData[] select(ConnectionProvider connectionProvider, String adLanguage, String cCurrencyConv, String legalEntity, String datePlus, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String costOrg, String costClient, String costType, String warehouseDimension, String categoryProduct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CATEGORY_NAME, M_PRODUCT_ID, PRODUCT_NAME, PRODUCT_SEARCHKEY, SUM(QTY) AS QTY, UOM_NAME, CASE ISCOSTCALCULATED" +
      "                       WHEN 'Y' THEN SUM(TOTAL_COST) / SUM(QTY)" +
      "                       ELSE NULL" +
      "                     END AS AVERAGE_COST," +
      "               SUM(TOTAL_COST) AS TOTAL_COST," +
      "               COSTTYPE as COST_TYPE," +
      "               SUM(QTY) * COSTTYPE as VALUATION_TYPE," +
      "               ZZ.WAREHOUSE as WAREHOUSE," +
      "               '' as ID, '' as PADRE , '' AS NAME" +
      "        FROM (SELECT M_PRODUCT_CATEGORY.NAME AS CATEGORY_NAME, A.M_PRODUCT_ID, AD_COLUMN_IDENTIFIER (to_char('M_Product'),to_char(M_PRODUCT.M_PRODUCT_ID),to_char(?)) AS PRODUCT_NAME, " +
      "              M_PRODUCT.VALUE AS PRODUCT_SEARCHKEY, A.QTY, C_UOM.NAME AS UOM_NAME," +
      "                     CASE a.iscostcalculated" +
      "                       WHEN 'Y' THEN C_CURRENCY_CONVERT_PRECISION (Suma,A.c_currency_id,?,A.MOVEMENTDATE,NULL,A.AD_CLIENT_ID,?,'C')" +
      "                       ELSE NULL" +
      "                     END AS TOTAL_COST,  A.ISCOSTCALCULATED, A.AD_CLIENT_ID, A.MOVEMENTDATE, A.C_CURRENCY_ID," +
      "                     CASE a.iscostcalculated" +
      "                       WHEN 'Y' THEN C_CURRENCY_CONVERT_PRECISION (P.COST,P.c_currency_id,?,to_date(?),NULL,A.AD_CLIENT_ID,?,'C')" +
      "                       ELSE NULL" +
      "                     END AS COSTTYPE, A.WAREHOUSE AS WAREHOUSE" +
      "              FROM M_PRODUCT_CATEGORY," +
      "                   (SELECT trx.M_PRODUCT_ID, sum(trx.MOVEMENTQTY) AS QTY, sum(CASE WHEN trx.MOVEMENTQTY < 0 THEN- tc.trxcost ELSE tc.trxcost END) AS Suma, " +
      "                   trx.C_UOM_ID, trx.AD_CLIENT_ID, trx.iscostcalculated, tc.c_currency_id, trx.movementdate, WH.NAME AS WAREHOUSE, WH.M_WAREHOUSE_ID " +
      "                    FROM M_TRANSACTION trx " +
      "                      JOIN M_LOCATOR l ON trx.M_LOCATOR_ID = l.M_LOCATOR_ID" +
      "                      INNER JOIN M_WAREHOUSE WH ON l.M_WAREHOUSE_ID = WH.M_WAREHOUSE_ID" +
      "                      LEFT JOIN (SELECT sum(cost) AS trxcost, m_transaction_id, c_currency_id" +
      "                                 FROM M_TRANSACTION_COST" +
      "                                 WHERE dateacct < to_date(?)" +
      "                                   AND dateacct > to_date(?)" +
      "                                 GROUP BY m_transaction_id, c_currency_id) tc ON trx.m_transaction_id = tc.m_transaction_id" +
      "                    WHERE trx.MOVEMENTDATE < to_date(?)" +
      "                    AND trx.MOVEMENTDATE > to_date(?)" +
      "                    AND trx.TRXPROCESSDATE >= to_timestamp(?, ?)" +
      "                    AND trx.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                    AND 0=0";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + 
      "                    GROUP BY trx.M_PRODUCT_ID, trx.C_UOM_ID, trx.AD_CLIENT_ID, trx.iscostcalculated, tc.c_currency_id, trx.movementdate, WH.NAME, WH.M_WAREHOUSE_ID " +
      "                    UNION ALL" +
      "                    SELECT agg.m_product_id, stock as qty, valuation as Suma, agg.c_uom_id, agg.ad_client_id, CASE WHEN valuation <> 0 THEN 'Y' ELSE 'N' END," +
      "                      agg.c_currency_id, dateto, wh.name as warehouse, WH.M_WAREHOUSE_ID " +
      "                    FROM m_valued_stock_agg agg" +
      "                      JOIN m_locator l ON (agg.m_locator_id = l.m_locator_id)" +
      "                      JOIN m_warehouse wh ON (l.m_warehouse_id = wh.m_warehouse_id)" +
      "                    WHERE agg.dateto = (SELECT MAX(agg2.dateto)" +
      "                                       FROM m_valued_stock_agg agg2" +
      "                                       WHERE agg2.dateto < TO_DATE(?)" +
      "                                       AND agg2.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      "))" +
      "                      AND agg.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                      AND 3=3";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + 
      "                    ) A," +
      "                    C_UOM," +
      "                    M_PRODUCT LEFT JOIN (SELECT mc.COST as COST, mc.DATEFROM, mc.M_PRODUCT_ID, mc.c_currency_id, MC.M_WAREHOUSE_ID" +
      "                                        FROM M_COSTING mc" +
      "                                          JOIN (SELECT mc2.M_PRODUCT_ID, max(mc2.DATEFROM) AS datefrom, MC2.M_WAREHOUSE_ID" +
      "                                                FROM M_COSTING mc2" +
      "                                                WHERE mc2.DATEFROM < to_date(?)" +
      "                                                  AND 2 = 2";
    strSql = strSql + ((costOrg==null || costOrg.equals(""))?"":"  AND mc2.AD_ORG_ID IN (?,'0')  ");
    strSql = strSql + ((costClient==null || costClient.equals(""))?"":"  AND mc2.ad_client_id = ?  ");
    strSql = strSql + 
      "                                                  AND mc2.COSTTYPE IN (";
    strSql = strSql + ((costType==null || costType.equals(""))?"":costType);
    strSql = strSql + 
      ")" +
      "                                                GROUP BY mc2.M_PRODUCT_ID, MC2.M_WAREHOUSE_ID) dc ON (mc.DATEFROM = dc.DATEFROM AND mc.M_PRODUCT_ID = dc.M_PRODUCT_ID" +
      "                                                  AND ((? = 'N' AND DC.M_WAREHOUSE_ID IS NULL) OR (? = 'Y' AND MC.M_WAREHOUSE_ID = DC.M_WAREHOUSE_ID)))" +
      "                                        WHERE mc.DATETO> mc.DATEFROM" +
      "                                       AND 9 = 9";
    strSql = strSql + ((costOrg==null || costOrg.equals(""))?"":"  AND mc.AD_ORG_ID IN (?,'0')  ");
    strSql = strSql + 
      "                                       ) P" +
      "                               ON M_PRODUCT.M_PRODUCT_ID = P.M_PRODUCT_ID" +
      "              WHERE A.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "              AND   ((? = 'N' AND P.M_WAREHOUSE_ID IS NULL) OR (? = 'Y' AND A.M_WAREHOUSE_ID = P.M_WAREHOUSE_ID))" +
      "              AND   A.C_UOM_ID = C_UOM.C_UOM_ID" +
      "              AND   M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "              AND   1 = 1";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "              AND   (A.QTY <> 0 OR A.Suma <> 0)) ZZ" +
      "        GROUP BY ZZ.M_PRODUCT_ID, CATEGORY_NAME, ZZ.WAREHOUSE, PRODUCT_NAME, PRODUCT_SEARCHKEY, UOM_NAME, ISCOSTCALCULATED, COSTTYPE" +
      "        HAVING SUM(QTY) <> 0" +
      "        ORDER BY WAREHOUSE, CATEGORY_NAME, PRODUCT_NAME";

    ResultSet result;
    Vector<ReportValuationStockData> vector = new Vector<ReportValuationStockData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      if (organization != null && !(organization.equals(""))) {
        }
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      if (costOrg != null && !(costOrg.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, costOrg);
      }
      if (costClient != null && !(costClient.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, costClient);
      }
      if (costType != null && !(costType.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouseDimension);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouseDimension);
      if (costOrg != null && !(costOrg.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, costOrg);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouseDimension);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouseDimension);
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
        ReportValuationStockData objectReportValuationStockData = new ReportValuationStockData();
        objectReportValuationStockData.categoryName = UtilSql.getValue(result, "category_name");
        objectReportValuationStockData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportValuationStockData.productName = UtilSql.getValue(result, "product_name");
        objectReportValuationStockData.productSearchkey = UtilSql.getValue(result, "product_searchkey");
        objectReportValuationStockData.qty = UtilSql.getValue(result, "qty");
        objectReportValuationStockData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportValuationStockData.averageCost = UtilSql.getValue(result, "average_cost");
        objectReportValuationStockData.totalCost = UtilSql.getValue(result, "total_cost");
        objectReportValuationStockData.costType = UtilSql.getValue(result, "cost_type");
        objectReportValuationStockData.valuationType = UtilSql.getValue(result, "valuation_type");
        objectReportValuationStockData.warehouse = UtilSql.getValue(result, "warehouse");
        objectReportValuationStockData.id = UtilSql.getValue(result, "id");
        objectReportValuationStockData.padre = UtilSql.getValue(result, "padre");
        objectReportValuationStockData.name = UtilSql.getValue(result, "name");
        objectReportValuationStockData.rownum = Long.toString(countRecord);
        objectReportValuationStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportValuationStockData);
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
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[vector.size()];
    vector.copyInto(objectReportValuationStockData);
    return(objectReportValuationStockData);
  }

  public static ReportValuationStockData[] selectClusteredByWarehouse(ConnectionProvider connectionProvider, String adLanguage, String datePlus, String legalEntity, String cCurrencyConv, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String categoryProduct, String costOrg, String costClient, String costType, String warehouseDimension, String filterOrgId)    throws ServletException {
    return selectClusteredByWarehouse(connectionProvider, adLanguage, datePlus, legalEntity, cCurrencyConv, maxaggDate, processTime, dateTimeFormat, organization, warehouse, categoryProduct, costOrg, costClient, costType, warehouseDimension, filterOrgId, 0, 0);
  }

  public static ReportValuationStockData[] selectClusteredByWarehouse(ConnectionProvider connectionProvider, String adLanguage, String datePlus, String legalEntity, String cCurrencyConv, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String categoryProduct, String costOrg, String costClient, String costType, String warehouseDimension, String filterOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  SELECT CATEGORY_NAME, zz.M_PRODUCT_ID," +
      "     AD_COLUMN_IDENTIFIER (to_char('M_Product'),to_char(zz.M_PRODUCT_ID),to_char(?)) AS PRODUCT_NAME," +
      "     PRODUCT_SEARCHKEY, zz.QTY AS QTY, C_UOM.NAME AS UOM_NAME," +
      "     ROUND(TOTAL_COST / zz.QTY, c_currency.costingprecision) AS AVERAGE_COST," +
      "     TOTAL_COST AS TOTAL_COST," +
      "     C_CURRENCY_CONVERT_PRECISION (c.COST,c.c_currency_id, c_currency.c_currency_id,to_date(?),NULL,c.AD_CLIENT_ID,?,'C') AS COST_TYPE," +
      "     ROUND(zz.QTY *  C_CURRENCY_CONVERT_PRECISION (c.COST,c.c_currency_id, c_currency.c_currency_id,to_date(?),NULL,c.AD_CLIENT_ID,?,'C'), c_currency.stdprecision) as VALUATION_TYPE," +
      "     'ALL Warehouses' as WAREHOUSE," +
      "     '' as ID, '' as PADRE , '' AS NAME" +
      "  FROM (" +
      "    SELECT pc.NAME AS CATEGORY_NAME," +
      "        A.M_PRODUCT_ID, " +
      "        p.VALUE AS PRODUCT_SEARCHKEY, SUM(A.QTY) AS QTY, a.c_uom_id," +
      "        SUM(C_CURRENCY_CONVERT_PRECISION(Suma, A.c_currency_id, ?, a.dateacct, NULL, A.AD_CLIENT_ID, ?,'C')) AS TOTAL_COST" +
      "    FROM M_PRODUCT_CATEGORY pc" +
      "      JOIN M_PRODUCT p ON pc.m_product_category_id = p.m_product_category_id" +
      "      JOIN (" +
      "          SELECT trx.M_PRODUCT_ID," +
      "              sum(CASE WHEN tc.m_costadjustmentline_id IS NULL THEN trx.MOVEMENTQTY ELSE 0 END) AS QTY," +
      "              sum(CASE WHEN trx.MOVEMENTQTY < 0 THEN -tc.cost ELSE tc.cost END) AS Suma, " +
      "              trx.C_UOM_ID, trx.AD_CLIENT_ID, tc.c_currency_id, tc.dateacct" +
      "          FROM M_TRANSACTION trx " +
      "            JOIN M_LOCATOR l ON trx.M_LOCATOR_ID = l.M_LOCATOR_ID" +
      "            JOIN M_PRODUCT p ON trx.m_product_id = p.m_product_id" +
      "            JOIN M_TRANSACTION_COST tc ON trx.m_transaction_id = tc.m_transaction_id AND tc.dateacct < to_date(?)" +
      "              AND tc.dateacct > to_date(?)" +
      "          WHERE trx.MOVEMENTDATE < to_date(?)" +
      "            AND trx.MOVEMENTDATE > to_date(?)" +
      "            AND trx.TRXPROCESSDATE >= to_timestamp(?, ?)" +
      "            AND trx.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "            AND trx.iscostcalculated = 'Y'" +
      "            AND 0 = 0";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND p.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "          GROUP BY trx.M_PRODUCT_ID, trx.C_UOM_ID, trx.AD_CLIENT_ID, tc.c_currency_id, tc.dateacct" +
      "          UNION ALL" +
      "          SELECT agg.m_product_id, stock as qty, valuation as Suma, agg.c_uom_id, agg.ad_client_id, agg.c_currency_id, dateto" +
      "                    FROM m_valued_stock_agg agg" +
      "                      JOIN m_locator l ON (agg.m_locator_id = l.m_locator_id)" +
      "                      JOIN m_product p ON (agg.m_product_id = p.m_product_id)" +
      "                    WHERE agg.dateto = (SELECT MAX(agg2.dateto)" +
      "                                       FROM m_valued_stock_agg agg2" +
      "                                       WHERE agg2.dateto < TO_DATE(?)" +
      "                                       AND agg2.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      "))" +
      "                      AND agg.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                      AND 8=8";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND p.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "        ) A ON a.m_product_id = p.m_product_id" +
      "    WHERE 1 = 1";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND pc.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "      AND (A.QTY <> 0 OR A.Suma <> 0)" +
      "  GROUP BY a.M_PRODUCT_ID, pc.NAME, p.VALUE, a.c_uom_id" +
      "  HAVING SUM(A.QTY) <>0" +
      "  ) ZZ" +
      "    JOIN C_UOM ON c_uom.c_uom_id = zz.c_uom_id" +
      "    LEFT JOIN (" +
      "        SELECT AVG(c.COST) as COST, c.DATEFROM, c.M_PRODUCT_ID, c.c_currency_id, c.ad_client_id" +
      "        FROM M_COSTING c" +
      "        LEFT JOIN M_WAREHOUSE w ON (c.m_warehouse_id = w.m_warehouse_id)" +
      "          JOIN (SELECT c2.M_PRODUCT_ID, max(c2.DATEFROM) AS datefrom" +
      "                FROM M_COSTING c2" +
      "                WHERE c2.DATEFROM < to_date(?)" +
      "                  AND 4 = 4";
    strSql = strSql + ((costOrg==null || costOrg.equals(""))?"":"  AND c2.AD_ORG_ID IN (?,'0')  ");
    strSql = strSql + ((costClient==null || costClient.equals(""))?"":"  AND c2.ad_client_id = ?  ");
    strSql = strSql + 
      "                  AND c2.costtype IN (";
    strSql = strSql + ((costType==null || costType.equals(""))?"":costType);
    strSql = strSql + 
      ")" +
      "                GROUP BY c2.M_PRODUCT_ID) dc ON (c.DATEFROM = dc.DATEFROM AND c.M_PRODUCT_ID = dc.M_PRODUCT_ID)" +
      "        WHERE c.DATETO > c.DATEFROM" +
      "          AND 5 = 5";
    strSql = strSql + ((costOrg==null || costOrg.equals(""))?"":"  AND c.AD_ORG_ID IN (?,'0')  ");
    strSql = strSql + ((costClient==null || costClient.equals(""))?"":"  AND c.ad_client_id = ?  ");
    strSql = strSql + 
      "          AND c.costtype IN (";
    strSql = strSql + ((costType==null || costType.equals(""))?"":costType);
    strSql = strSql + 
      ")" +
      "          AND ((? = 'N' AND c.m_warehouse_id IS NULL) OR (? = 'Y' AND ad_isorgincluded(w.ad_org_id, ?, w.ad_client_id) <> -1))" +
      "        GROUP BY c.DATEFROM, c.M_PRODUCT_ID, c.c_currency_id, c.ad_client_id" +
      "    ) C ON C.M_PRODUCT_ID = ZZ.M_PRODUCT_ID" +
      "    JOIN c_currency ON c_currency.c_currency_id = ?" +
      "  UNION ALL" +
      "  SELECT pc.name AS category_name," +
      "      stock.m_product_id," +
      "      AD_COLUMN_IDENTIFIER (to_char('M_Product'),to_char(stock.M_PRODUCT_ID),to_char(?)) AS PRODUCT_NAME," +
      "      stock.value AS PRODUCT_SEARCHKEY," +
      "      stock.QTY AS QTY," +
      "      uom.name as UOM_NAME," +
      "      null AS AVERAGE_COST," +
      "      null AS TOTAL_COST," +
      "      null as COST_TYPE," +
      "      null as VALUATION_TYPE," +
      "      'ALL Warehouses' as WAREHOUSE," +
      "      '' as ID, '' as PADRE , '' AS NAME" +
      "  FROM m_product_category pc" +
      "    LEFT JOIN (" +
      "      SELECT sum(trx.movementqty) as QTY, p.m_product_id, p.value, p.m_product_category_id, trx.c_uom_id" +
      "      FROM m_product p" +
      "        JOIN m_transaction trx ON trx.m_product_id = p.m_product_id" +
      "        JOIN m_locator l ON trx.m_locator_id = l.m_locator_id" +
      "      WHERE trx.iscostcalculated = 'N'" +
      "        AND trx.MOVEMENTDATE < to_date(?)" +
      "        AND trx.MOVEMENTDATE > to_date(?)" +
      "        AND trx.TRXPROCESSDATE >= to_timestamp(?, ?)" +
      "        AND  trx.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "        AND 2 = 2";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND p.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "      GROUP BY p.m_product_id, p.value, p.m_product_category_id, trx.c_uom_id" +
      "      HAVING sum(trx.movementqty) <> 0" +
      "    ) stock ON pc.m_product_category_id = stock.m_product_category_id" +
      "    JOIN c_uom uom ON stock.c_uom_id = uom.c_uom_id" +
      "    JOIN c_currency ON c_currency.c_currency_id = ?" +
      "  WHERE 3 = 3";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND pc.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "  ORDER BY CATEGORY_NAME, PRODUCT_NAME";

    ResultSet result;
    Vector<ReportValuationStockData> vector = new Vector<ReportValuationStockData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      if (organization != null && !(organization.equals(""))) {
        }
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      if (costOrg != null && !(costOrg.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, costOrg);
      }
      if (costClient != null && !(costClient.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, costClient);
      }
      if (costType != null && !(costType.equals(""))) {
        }
      if (costOrg != null && !(costOrg.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, costOrg);
      }
      if (costClient != null && !(costClient.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, costClient);
      }
      if (costType != null && !(costType.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouseDimension);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouseDimension);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filterOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
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
        ReportValuationStockData objectReportValuationStockData = new ReportValuationStockData();
        objectReportValuationStockData.categoryName = UtilSql.getValue(result, "category_name");
        objectReportValuationStockData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportValuationStockData.productName = UtilSql.getValue(result, "product_name");
        objectReportValuationStockData.productSearchkey = UtilSql.getValue(result, "product_searchkey");
        objectReportValuationStockData.qty = UtilSql.getValue(result, "qty");
        objectReportValuationStockData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportValuationStockData.averageCost = UtilSql.getValue(result, "average_cost");
        objectReportValuationStockData.totalCost = UtilSql.getValue(result, "total_cost");
        objectReportValuationStockData.costType = UtilSql.getValue(result, "cost_type");
        objectReportValuationStockData.valuationType = UtilSql.getValue(result, "valuation_type");
        objectReportValuationStockData.warehouse = UtilSql.getValue(result, "warehouse");
        objectReportValuationStockData.id = UtilSql.getValue(result, "id");
        objectReportValuationStockData.padre = UtilSql.getValue(result, "padre");
        objectReportValuationStockData.name = UtilSql.getValue(result, "name");
        objectReportValuationStockData.rownum = Long.toString(countRecord);
        objectReportValuationStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportValuationStockData);
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
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[vector.size()];
    vector.copyInto(objectReportValuationStockData);
    return(objectReportValuationStockData);
  }

  public static ReportValuationStockData[] selectWithoutCost(ConnectionProvider connectionProvider, String adLanguage, String cCurrencyConv, String legalEntity, String datePlus, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String categoryProduct)    throws ServletException {
    return selectWithoutCost(connectionProvider, adLanguage, cCurrencyConv, legalEntity, datePlus, maxaggDate, processTime, dateTimeFormat, organization, warehouse, categoryProduct, 0, 0);
  }

  public static ReportValuationStockData[] selectWithoutCost(ConnectionProvider connectionProvider, String adLanguage, String cCurrencyConv, String legalEntity, String datePlus, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String categoryProduct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CATEGORY_NAME, M_PRODUCT_ID, PRODUCT_NAME, PRODUCT_SEARCHKEY, SUM(QTY) AS QTY, UOM_NAME, CASE ISCOSTCALCULATED" +
      "                       WHEN 'Y' THEN SUM(TOTAL_COST) / SUM(QTY)" +
      "                       ELSE NULL" +
      "                     END AS AVERAGE_COST," +
      "               SUM(TOTAL_COST) AS TOTAL_COST," +
      "               ZZ.WAREHOUSE as WAREHOUSE" +
      "        FROM (SELECT M_PRODUCT_CATEGORY.NAME AS CATEGORY_NAME, A.M_PRODUCT_ID, AD_COLUMN_IDENTIFIER (to_char('M_Product'),to_char(M_PRODUCT.M_PRODUCT_ID),to_char(?)) AS PRODUCT_NAME, " +
      "              M_PRODUCT.VALUE AS PRODUCT_SEARCHKEY, A.QTY, C_UOM.NAME AS UOM_NAME," +
      "                     CASE a.iscostcalculated" +
      "                       WHEN 'Y' THEN C_CURRENCY_CONVERT_PRECISION (Suma,A.c_currency_id,?,A.movementdate,NULL,A.AD_CLIENT_ID,?,'C')" +
      "                       ELSE NULL" +
      "                     END AS TOTAL_COST,  A.ISCOSTCALCULATED, A.AD_CLIENT_ID, A.MOVEMENTDATE, A.C_CURRENCY_ID, A.WAREHOUSE AS WAREHOUSE" +
      "              FROM M_PRODUCT_CATEGORY," +
      "                   (SELECT trx.M_PRODUCT_ID, sum(trx.MOVEMENTQTY) AS QTY, sum(CASE WHEN trx.MOVEMENTQTY < 0 THEN- tc.trxcost ELSE tc.trxcost END) AS Suma, " +
      "                   trx.C_UOM_ID, trx.AD_CLIENT_ID, trx.iscostcalculated, tc.c_currency_id, trx.movementdate, WH.NAME AS WAREHOUSE" +
      "                    FROM M_TRANSACTION trx " +
      "                      JOIN M_LOCATOR l ON trx.M_LOCATOR_ID = l.M_LOCATOR_ID" +
      "                      INNER JOIN M_WAREHOUSE WH ON l.M_WAREHOUSE_ID = WH.M_WAREHOUSE_ID" +
      "                      LEFT JOIN (SELECT sum(cost) AS trxcost, m_transaction_id, c_currency_id" +
      "                                 FROM M_TRANSACTION_COST" +
      "                                 WHERE dateacct < to_date(?)" +
      "                                   AND dateacct > to_date(?)" +
      "                                 GROUP BY m_transaction_id, c_currency_id) tc ON trx.m_transaction_id = tc.m_transaction_id" +
      "                    WHERE trx.MOVEMENTDATE < to_date(?)" +
      "                    AND trx.MOVEMENTDATE > to_date(?)" +
      "                    AND trx.TRXPROCESSDATE >= to_timestamp(?, ?)" +
      "                    AND trx.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                    AND 0=0";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + 
      "                    GROUP BY trx.M_PRODUCT_ID, trx.C_UOM_ID, trx.AD_CLIENT_ID, trx.iscostcalculated, tc.c_currency_id, trx.movementdate, WH.NAME" +
      "                    UNION ALL" +
      "                    SELECT agg.m_product_id, stock as qty, valuation as Suma, agg.c_uom_id, agg.ad_client_id, CASE WHEN valuation <> 0 THEN 'Y' ELSE 'N' END," +
      "                      agg.c_currency_id, dateto, wh.name as warehouse" +
      "                    FROM m_valued_stock_agg agg" +
      "                      JOIN m_locator l ON (agg.m_locator_id = l.m_locator_id)" +
      "                      JOIN m_warehouse wh ON (l.m_warehouse_id = wh.m_warehouse_id)" +
      "                    WHERE agg.dateto = (SELECT MAX(agg2.dateto)" +
      "                                       FROM m_valued_stock_agg agg2" +
      "                                       WHERE agg2.dateto < TO_DATE(?)" +
      "                                       AND agg2.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      "))" +
      "                      AND agg.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                      AND 2=2";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + 
      ") A," +
      "                   C_UOM," +
      "                   M_PRODUCT" +
      "              WHERE A.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "              AND   A.C_UOM_ID = C_UOM.C_UOM_ID" +
      "              AND   M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "              AND   1 = 1";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "              AND   (A.QTY <> 0 OR A.Suma <> 0)) ZZ" +
      "        GROUP BY ZZ.M_PRODUCT_ID, CATEGORY_NAME, ZZ.WAREHOUSE, PRODUCT_NAME, PRODUCT_SEARCHKEY, UOM_NAME, ISCOSTCALCULATED" +
      "        HAVING SUM(QTY) <> 0" +
      "        ORDER BY WAREHOUSE, CATEGORY_NAME, PRODUCT_NAME";

    ResultSet result;
    Vector<ReportValuationStockData> vector = new Vector<ReportValuationStockData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      if (organization != null && !(organization.equals(""))) {
        }
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
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
        ReportValuationStockData objectReportValuationStockData = new ReportValuationStockData();
        objectReportValuationStockData.categoryName = UtilSql.getValue(result, "category_name");
        objectReportValuationStockData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportValuationStockData.productName = UtilSql.getValue(result, "product_name");
        objectReportValuationStockData.productSearchkey = UtilSql.getValue(result, "product_searchkey");
        objectReportValuationStockData.qty = UtilSql.getValue(result, "qty");
        objectReportValuationStockData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportValuationStockData.averageCost = UtilSql.getValue(result, "average_cost");
        objectReportValuationStockData.totalCost = UtilSql.getValue(result, "total_cost");
        objectReportValuationStockData.warehouse = UtilSql.getValue(result, "warehouse");
        objectReportValuationStockData.rownum = Long.toString(countRecord);
        objectReportValuationStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportValuationStockData);
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
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[vector.size()];
    vector.copyInto(objectReportValuationStockData);
    return(objectReportValuationStockData);
  }

  public static ReportValuationStockData[] selectClusteredByWarehouseWithoutCost(ConnectionProvider connectionProvider, String adLanguage, String cCurrencyConv, String legalEntity, String datePlus, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String categoryProduct)    throws ServletException {
    return selectClusteredByWarehouseWithoutCost(connectionProvider, adLanguage, cCurrencyConv, legalEntity, datePlus, maxaggDate, processTime, dateTimeFormat, organization, warehouse, categoryProduct, 0, 0);
  }

  public static ReportValuationStockData[] selectClusteredByWarehouseWithoutCost(ConnectionProvider connectionProvider, String adLanguage, String cCurrencyConv, String legalEntity, String datePlus, String maxaggDate, String processTime, String dateTimeFormat, String organization, String warehouse, String categoryProduct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  SELECT CATEGORY_NAME, zz.M_PRODUCT_ID," +
      "     AD_COLUMN_IDENTIFIER (to_char('M_Product'),to_char(zz.M_PRODUCT_ID),to_char(?)) AS PRODUCT_NAME," +
      "     PRODUCT_SEARCHKEY, zz.QTY AS QTY, C_UOM.NAME AS UOM_NAME," +
      "     ROUND(TOTAL_COST / zz.QTY, c_currency.costingprecision) AS AVERAGE_COST," +
      "     TOTAL_COST AS TOTAL_COST," +
      "     'ALL Warehouses' as WAREHOUSE" +
      "  FROM (" +
      "    SELECT pc.NAME AS CATEGORY_NAME," +
      "        A.M_PRODUCT_ID, " +
      "        p.VALUE AS PRODUCT_SEARCHKEY, SUM(A.QTY) AS QTY, a.c_uom_id," +
      "        SUM(C_CURRENCY_CONVERT_PRECISION(Suma, A.c_currency_id, ?, a.dateacct, NULL, A.AD_CLIENT_ID, ?,'C')) AS TOTAL_COST" +
      "    FROM M_PRODUCT_CATEGORY pc" +
      "      JOIN M_PRODUCT p ON pc.m_product_category_id = p.m_product_category_id" +
      "      JOIN (" +
      "          SELECT trx.M_PRODUCT_ID," +
      "              sum(CASE WHEN tc.m_costadjustmentline_id IS NULL THEN trx.MOVEMENTQTY ELSE 0 END) AS QTY," +
      "              sum(CASE WHEN trx.MOVEMENTQTY < 0 THEN -tc.cost ELSE tc.cost END) AS Suma, " +
      "              trx.C_UOM_ID, trx.AD_CLIENT_ID, tc.c_currency_id, tc.dateacct" +
      "          FROM M_TRANSACTION trx " +
      "            JOIN M_LOCATOR l ON trx.M_LOCATOR_ID = l.M_LOCATOR_ID" +
      "            JOIN M_PRODUCT p ON trx.m_product_id = p.m_product_id" +
      "            JOIN M_TRANSACTION_COST tc ON trx.m_transaction_id = tc.m_transaction_id " +
      "              AND tc.dateacct < to_date(?) AND tc.dateacct > to_date(?)" +
      "          WHERE trx.MOVEMENTDATE < to_date(?)" +
      "            AND trx.MOVEMENTDATE > to_date(?)" +
      "            AND trx.TRXPROCESSDATE >= to_timestamp(?, ?)" +
      "            AND trx.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "            AND trx.iscostcalculated = 'Y'" +
      "            AND 0 = 0";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND p.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "          GROUP BY trx.M_PRODUCT_ID, trx.C_UOM_ID, trx.AD_CLIENT_ID, tc.c_currency_id, tc.dateacct" +
      "          UNION ALL" +
      "          SELECT agg.m_product_id, stock as qty, valuation as Suma, agg.c_uom_id, agg.ad_client_id, agg.c_currency_id, dateto" +
      "          FROM m_valued_stock_agg agg" +
      "            JOIN m_locator l ON (agg.m_locator_id = l.m_locator_id)" +
      "            JOIN m_product p ON (agg.m_product_id = p.m_product_id)" +
      "          WHERE agg.dateto = (SELECT MAX(agg2.dateto)" +
      "                              FROM m_valued_stock_agg agg2" +
      "                              WHERE agg2.dateto < TO_DATE(?)" +
      "                              AND agg2.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      "))" +
      "            AND agg.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "           AND 4=4";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND p.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "        ) A ON a.m_product_id = p.m_product_id" +
      "    WHERE 1 = 1";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND pc.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "      AND (A.QTY <> 0 OR A.Suma <> 0)" +
      "  GROUP BY a.M_PRODUCT_ID, pc.NAME, p.VALUE, a.c_uom_id" +
      "  HAVING SUM(A.QTY) <>0" +
      "  ) ZZ" +
      "    JOIN C_UOM ON c_uom.c_uom_id = zz.c_uom_id" +
      "    JOIN c_currency ON c_currency.c_currency_id = ?" +
      "  UNION ALL" +
      "  SELECT pc.name AS category_name," +
      "      stock.m_product_id," +
      "      AD_COLUMN_IDENTIFIER (to_char('M_Product'),to_char(stock.M_PRODUCT_ID),to_char(?)) AS PRODUCT_NAME," +
      "      stock.value AS PRODUCT_SEARCHKEY," +
      "      stock.QTY AS QTY," +
      "      uom.name as UOM_NAME," +
      "      null AS AVERAGE_COST," +
      "      null AS TOTAL_COST," +
      "      'ALL Warehouses' as WAREHOUSE" +
      "  FROM m_product_category pc" +
      "    JOIN (" +
      "      SELECT sum(trx.movementqty) as QTY, p.m_product_id, p.value, p.m_product_category_id, trx.c_uom_id" +
      "      FROM m_product p" +
      "        JOIN m_transaction trx ON trx.m_product_id = p.m_product_id" +
      "        JOIN m_locator l ON trx.m_locator_id = l.m_locator_id" +
      "      WHERE trx.iscostcalculated = 'N'" +
      "        AND trx.MOVEMENTDATE < to_date(?)" +
      "        AND trx.MOVEMENTDATE > to_date(?)" +
      "        AND trx.TRXPROCESSDATE >= to_timestamp(?, ?)" +
      "        AND  trx.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "        AND 2 = 2";
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND l.M_WAREHOUSE_ID IN " + warehouse);
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND p.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "      GROUP BY p.m_product_id, p.value, p.m_product_category_id, trx.c_uom_id" +
      "      HAVING sum(trx.movementqty) <> 0" +
      "    ) stock ON pc.m_product_category_id = stock.m_product_category_id" +
      "    JOIN c_uom uom ON stock.c_uom_id = uom.c_uom_id" +
      "    JOIN c_currency ON c_currency.c_currency_id = ?" +
      "  WHERE 3 = 3";
    strSql = strSql + ((categoryProduct==null || categoryProduct.equals(""))?"":"  AND pc.M_PRODUCT_CATEGORY_ID= ?  ");
    strSql = strSql + 
      "  ORDER BY CATEGORY_NAME, PRODUCT_NAME";

    ResultSet result;
    Vector<ReportValuationStockData> vector = new Vector<ReportValuationStockData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      if (organization != null && !(organization.equals(""))) {
        }
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      if (organization != null && !(organization.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals(""))) {
        }
      if (categoryProduct != null && !(categoryProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryProduct);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
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
        ReportValuationStockData objectReportValuationStockData = new ReportValuationStockData();
        objectReportValuationStockData.categoryName = UtilSql.getValue(result, "category_name");
        objectReportValuationStockData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportValuationStockData.productName = UtilSql.getValue(result, "product_name");
        objectReportValuationStockData.productSearchkey = UtilSql.getValue(result, "product_searchkey");
        objectReportValuationStockData.qty = UtilSql.getValue(result, "qty");
        objectReportValuationStockData.uomName = UtilSql.getValue(result, "uom_name");
        objectReportValuationStockData.averageCost = UtilSql.getValue(result, "average_cost");
        objectReportValuationStockData.totalCost = UtilSql.getValue(result, "total_cost");
        objectReportValuationStockData.warehouse = UtilSql.getValue(result, "warehouse");
        objectReportValuationStockData.rownum = Long.toString(countRecord);
        objectReportValuationStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportValuationStockData);
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
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[vector.size()];
    vector.copyInto(objectReportValuationStockData);
    return(objectReportValuationStockData);
  }

  public static ReportValuationStockData[] set()    throws ServletException {
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[1];
    objectReportValuationStockData[0] = new ReportValuationStockData();
    objectReportValuationStockData[0].categoryName = "";
    objectReportValuationStockData[0].mProductId = "";
    objectReportValuationStockData[0].productName = "";
    objectReportValuationStockData[0].productSearchkey = "";
    objectReportValuationStockData[0].qty = "";
    objectReportValuationStockData[0].uomName = "";
    objectReportValuationStockData[0].averageCost = "";
    objectReportValuationStockData[0].totalCost = "";
    objectReportValuationStockData[0].warehouse = "";
    return objectReportValuationStockData;
  }

  public static String getCostingMigrationDate(ConnectionProvider connectionProvider, String adClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT MIN(updated) as costingMigrationDate" +
      "       FROM m_costing_rule" +
      "       WHERE created = (SELECT MIN(created) FROM m_costing_rule WHERE ad_client_id = ?)" +
      "       AND ad_client_id = ?";

    ResultSet result;
    String dateReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClient);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClient);

      result = st.executeQuery();
      if(result.next()) {
        dateReturn = UtilSql.getDateValue(result, "costingmigrationdate", "dd-MM-yyyy");
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
    return(dateReturn);
  }

  public static ReportValuationStockData[] selectWhsDouble(ConnectionProvider connectionProvider, String adClient)    throws ServletException {
    return selectWhsDouble(connectionProvider, adClient, 0, 0);
  }

  public static ReportValuationStockData[] selectWhsDouble(ConnectionProvider connectionProvider, String adClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT o.AD_ORG_ID AS PADRE, w.M_WAREHOUSE_ID AS ID, w.NAME" +
      "       FROM AD_ORG o, M_WAREHOUSE w" +
      "       WHERE ad_isorgincluded(w.AD_ORG_ID, o.AD_ORG_ID, o.AD_CLIENT_ID) <> -1" +
      "       AND o.AD_CLIENT_ID = ?";

    ResultSet result;
    Vector<ReportValuationStockData> vector = new Vector<ReportValuationStockData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClient);

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
        ReportValuationStockData objectReportValuationStockData = new ReportValuationStockData();
        objectReportValuationStockData.padre = UtilSql.getValue(result, "padre");
        objectReportValuationStockData.id = UtilSql.getValue(result, "id");
        objectReportValuationStockData.name = UtilSql.getValue(result, "name");
        objectReportValuationStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportValuationStockData);
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
    ReportValuationStockData objectReportValuationStockData[] = new ReportValuationStockData[vector.size()];
    vector.copyInto(objectReportValuationStockData);
    return(objectReportValuationStockData);
  }

  public static String selectMaxAggregatedDate(ConnectionProvider connectionProvider, String adClient, String organization)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT MAX(dateto)" +
      "       FROM m_valued_stock_agg agg" +
      "       WHERE ad_client_id = ?" +
      "       AND ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")";

    ResultSet result;
    String dateReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClient);
      if (organization != null && !(organization.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        dateReturn = UtilSql.getDateValue(result, "max", "dd-MM-yyyy");
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
    return(dateReturn);
  }
}
