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

class ReportRefundSalesDimensionalAnalysesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportRefundSalesDimensionalAnalysesData.class);
  private String InitRecordNumber="0";
  public String nivel1;
  public String nivel2;
  public String nivel3;
  public String nivel4;
  public String nivel5;
  public String nivel6;
  public String nivel7;
  public String linenetamt;
  public String refundamt;
  public String ratio;
  public String qtyinvoiced;
  public String refundqty;
  public String linenetref;
  public String refundamtref;
  public String ratioref;
  public String qtyinvoicedref;
  public String refundqtyref;
  public String convsym;
  public String convisosym;
  public String id;
  public String name;
  public String transcurrencyid;
  public String transdate;
  public String transclientid;
  public String transorgid;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("nivel1"))
      return nivel1;
    else if (fieldName.equalsIgnoreCase("nivel2"))
      return nivel2;
    else if (fieldName.equalsIgnoreCase("nivel3"))
      return nivel3;
    else if (fieldName.equalsIgnoreCase("nivel4"))
      return nivel4;
    else if (fieldName.equalsIgnoreCase("nivel5"))
      return nivel5;
    else if (fieldName.equalsIgnoreCase("nivel6"))
      return nivel6;
    else if (fieldName.equalsIgnoreCase("nivel7"))
      return nivel7;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("refundamt"))
      return refundamt;
    else if (fieldName.equalsIgnoreCase("ratio"))
      return ratio;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("refundqty"))
      return refundqty;
    else if (fieldName.equalsIgnoreCase("linenetref"))
      return linenetref;
    else if (fieldName.equalsIgnoreCase("refundamtref"))
      return refundamtref;
    else if (fieldName.equalsIgnoreCase("ratioref"))
      return ratioref;
    else if (fieldName.equalsIgnoreCase("qtyinvoicedref"))
      return qtyinvoicedref;
    else if (fieldName.equalsIgnoreCase("refundqtyref"))
      return refundqtyref;
    else if (fieldName.equalsIgnoreCase("convsym"))
      return convsym;
    else if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("transcurrencyid"))
      return transcurrencyid;
    else if (fieldName.equalsIgnoreCase("transdate"))
      return transdate;
    else if (fieldName.equalsIgnoreCase("transclientid"))
      return transclientid;
    else if (fieldName.equalsIgnoreCase("transorgid"))
      return transorgid;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportRefundSalesDimensionalAnalysesData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String mWarehouseId, String dateFromRef, String dateToRef, String orderby)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartner, mProductCategoryId, mProduct, salesrepId, mWarehouseId, dateFromRef, dateToRef, orderby, 0, 0);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String mWarehouseId, String dateFromRef, String dateToRef, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, " +
      "	  SUM(LINENETAMT) AS LINENETAMT, SUM(REFUNDAMT) AS REFUNDAMT, " +
      "	  C_DIVIDE(SUM(REFUNDAMT), (SUM(LINENETAMT)+SUM(REFUNDAMT)))*100 AS RATIO, " +
      "	  SUM(QTYINVOICED) AS QTYINVOICED, SUM(REFUNDQTY) AS REFUNDQTY, " +
      "	  SUM(LINENETREF) AS LINENETREF, SUM(REFUNDAMTREF) AS REFUNDAMTREF," +
      "	  C_DIVIDE(SUM(REFUNDAMTREF), (SUM(LINENETREF)+SUM(REFUNDAMTREF)))*100 AS RATIOREF, " +
      "	  SUM(QTYINVOICEDREF) AS QTYINVOICEDREF, SUM(REFUNDQTYREF) AS REFUNDQTYREF," +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,	  	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "	  '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID " +
      "	  FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, " +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS LINENETAMT, " +
      "	  C_CURRENCY_CONVERT(SUM(REFUNDAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS REFUNDAMT,  " +
      "      SUM(QTYINVOICED) AS QTYINVOICED, SUM(REFUNDQTY) AS REFUNDQTY, " +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS LINENETREF, " +
      "	  C_CURRENCY_CONVERT(SUM(REFUNDAMTREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS REFUNDAMTREF,  " +
      "      SUM(QTYINVOICEDREF) AS QTYINVOICEDREF, SUM(REFUNDQTYREF) AS REFUNDQTYREF, " +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID" +
      "      FROM (SELECT to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1, to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2, to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3, to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4, to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5, to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6, to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7," +
      "      CASE SIGN(C_ORDERLINE.LINENETAMT) WHEN  -1 THEN  0 ELSE  C_ORDERLINE.LINENETAMT END AS LINENETAMT, " +
      "      CASE SIGN(C_ORDERLINE.LINENETAMT) WHEN  -1 THEN  -1*C_ORDERLINE.LINENETAMT ELSE  0 END AS REFUNDAMT, " +
      "      CASE SIGN(C_ORDERLINE.QTYORDERED) WHEN  -1 THEN  0 ELSE  C_ORDERLINE.QTYORDERED END AS QTYINVOICED, " +
      "      CASE SIGN(C_ORDERLINE.QTYORDERED) WHEN  -1 THEN  (-1*C_ORDERLINE.QTYORDERED) ELSE  0 END AS REFUNDQTY, " +
      "      0 AS LINENETREF, 0 AS REFUNDAMTREF, 0 AS QTYINVOICEDREF, 0 AS REFUNDQTYREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,      " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "      C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_ORDERLINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_ORDER left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_ORDERLINE left join M_PRODUCT on C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                       left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                       left join C_UOM on C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID," +
      "         C_BPARTNER, C_BP_GROUP, M_WAREHOUSE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND 0=0 AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_ORDER.DATEORDERED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_ORDER.DATEORDERED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartner);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProduct==null || mProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + mProduct);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      "      UNION ALL SELECT to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1 , to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2 , to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3 , to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4 , to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5 , to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6 , to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7 ," +
      "      0 AS LINENETAMT, 0 AS REFUNDAMT, 0 AS QTYINVOICED, 0 AS REFUNDQTY, " +
      "      CASE SIGN(C_ORDERLINE.LINENETAMT) WHEN  -1 THEN  0 ELSE  C_ORDERLINE.LINENETAMT END AS LINENETREF, " +
      "      CASE SIGN(C_ORDERLINE.LINENETAMT) WHEN  -1 THEN  (-1*C_ORDERLINE.LINENETAMT) ELSE  0 END AS REFUNDAMTREF, " +
      "      CASE SIGN(C_ORDERLINE.QTYORDERED) WHEN  -1 THEN  0 ELSE  C_ORDERLINE.QTYORDERED END AS QTYINVOICEDREF, " +
      "      CASE SIGN(C_ORDERLINE.QTYORDERED) WHEN  -1 THEN  (-1*C_ORDERLINE.QTYORDERED) ELSE  0 END AS REFUNDQTYREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,      " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "      C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_ORDERLINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_ORDER left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_ORDERLINE left join M_PRODUCT on C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID " +
      "                       left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                       left join C_UOM on C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID," +
      "           C_BPARTNER, C_BP_GROUP, M_WAREHOUSE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND 3=3 AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 2=2";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":" AND C_ORDER.DATEORDERED >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":" AND C_ORDER.DATEORDERED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartner);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProduct==null || mProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + mProduct);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      ") AA" +
      "      WHERE LINENETAMT <> 0" +
      "      OR REFUNDAMT <> 0" +
      "      OR LINENETREF <> 0" +
      "      OR REFUNDAMTREF <> 0" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ      " +
      "	  GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportRefundSalesDimensionalAnalysesData> vector = new Vector<ReportRefundSalesDimensionalAnalysesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (nivel1 != null && !(nivel1.equals(""))) {
        }
      if (nivel2 != null && !(nivel2.equals(""))) {
        }
      if (nivel3 != null && !(nivel3.equals(""))) {
        }
      if (nivel4 != null && !(nivel4.equals(""))) {
        }
      if (nivel5 != null && !(nivel5.equals(""))) {
        }
      if (nivel6 != null && !(nivel6.equals(""))) {
        }
      if (nivel7 != null && !(nivel7.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProduct != null && !(mProduct.equals(""))) {
        }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (nivel1 != null && !(nivel1.equals(""))) {
        }
      if (nivel2 != null && !(nivel2.equals(""))) {
        }
      if (nivel3 != null && !(nivel3.equals(""))) {
        }
      if (nivel4 != null && !(nivel4.equals(""))) {
        }
      if (nivel5 != null && !(nivel5.equals(""))) {
        }
      if (nivel6 != null && !(nivel6.equals(""))) {
        }
      if (nivel7 != null && !(nivel7.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFromRef != null && !(dateFromRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      }
      if (dateToRef != null && !(dateToRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProduct != null && !(mProduct.equals(""))) {
        }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (orderby != null && !(orderby.equals(""))) {
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
        ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData = new ReportRefundSalesDimensionalAnalysesData();
        objectReportRefundSalesDimensionalAnalysesData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportRefundSalesDimensionalAnalysesData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportRefundSalesDimensionalAnalysesData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportRefundSalesDimensionalAnalysesData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportRefundSalesDimensionalAnalysesData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportRefundSalesDimensionalAnalysesData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportRefundSalesDimensionalAnalysesData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportRefundSalesDimensionalAnalysesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportRefundSalesDimensionalAnalysesData.refundamt = UtilSql.getValue(result, "refundamt");
        objectReportRefundSalesDimensionalAnalysesData.ratio = UtilSql.getValue(result, "ratio");
        objectReportRefundSalesDimensionalAnalysesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectReportRefundSalesDimensionalAnalysesData.refundqty = UtilSql.getValue(result, "refundqty");
        objectReportRefundSalesDimensionalAnalysesData.linenetref = UtilSql.getValue(result, "linenetref");
        objectReportRefundSalesDimensionalAnalysesData.refundamtref = UtilSql.getValue(result, "refundamtref");
        objectReportRefundSalesDimensionalAnalysesData.ratioref = UtilSql.getValue(result, "ratioref");
        objectReportRefundSalesDimensionalAnalysesData.qtyinvoicedref = UtilSql.getValue(result, "qtyinvoicedref");
        objectReportRefundSalesDimensionalAnalysesData.refundqtyref = UtilSql.getValue(result, "refundqtyref");
        objectReportRefundSalesDimensionalAnalysesData.convsym = UtilSql.getValue(result, "convsym");
        objectReportRefundSalesDimensionalAnalysesData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportRefundSalesDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundSalesDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundSalesDimensionalAnalysesData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportRefundSalesDimensionalAnalysesData.transdate = UtilSql.getValue(result, "transdate");
        objectReportRefundSalesDimensionalAnalysesData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportRefundSalesDimensionalAnalysesData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportRefundSalesDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundSalesDimensionalAnalysesData);
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
    ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData[] = new ReportRefundSalesDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundSalesDimensionalAnalysesData);
    return(objectReportRefundSalesDimensionalAnalysesData);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] set()    throws ServletException {
    ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData[] = new ReportRefundSalesDimensionalAnalysesData[1];
    objectReportRefundSalesDimensionalAnalysesData[0] = new ReportRefundSalesDimensionalAnalysesData();
    objectReportRefundSalesDimensionalAnalysesData[0].nivel1 = "";
    objectReportRefundSalesDimensionalAnalysesData[0].nivel2 = "";
    objectReportRefundSalesDimensionalAnalysesData[0].nivel3 = "";
    objectReportRefundSalesDimensionalAnalysesData[0].nivel4 = "";
    objectReportRefundSalesDimensionalAnalysesData[0].nivel5 = "";
    objectReportRefundSalesDimensionalAnalysesData[0].nivel6 = "";
    objectReportRefundSalesDimensionalAnalysesData[0].nivel7 = "";
    objectReportRefundSalesDimensionalAnalysesData[0].linenetamt = "";
    objectReportRefundSalesDimensionalAnalysesData[0].refundamt = "";
    objectReportRefundSalesDimensionalAnalysesData[0].ratio = "";
    objectReportRefundSalesDimensionalAnalysesData[0].qtyinvoiced = "";
    objectReportRefundSalesDimensionalAnalysesData[0].refundqty = "";
    objectReportRefundSalesDimensionalAnalysesData[0].linenetref = "";
    objectReportRefundSalesDimensionalAnalysesData[0].refundamtref = "";
    objectReportRefundSalesDimensionalAnalysesData[0].ratioref = "";
    objectReportRefundSalesDimensionalAnalysesData[0].qtyinvoicedref = "";
    objectReportRefundSalesDimensionalAnalysesData[0].refundqtyref = "";
    objectReportRefundSalesDimensionalAnalysesData[0].convsym = "";
    objectReportRefundSalesDimensionalAnalysesData[0].convisosym = "";
    objectReportRefundSalesDimensionalAnalysesData[0].id = "";
    objectReportRefundSalesDimensionalAnalysesData[0].name = "";
    objectReportRefundSalesDimensionalAnalysesData[0].transcurrencyid = "";
    objectReportRefundSalesDimensionalAnalysesData[0].transdate = "";
    objectReportRefundSalesDimensionalAnalysesData[0].transclientid = "";
    objectReportRefundSalesDimensionalAnalysesData[0].transorgid = "";
    return objectReportRefundSalesDimensionalAnalysesData;
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String mWarehouseId, String orderby)    throws ServletException {
    return selectNoComparative(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartner, mProductCategoryId, mProduct, salesrepId, mWarehouseId, orderby, 0, 0);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartner, String mProductCategoryId, String mProduct, String salesrepId, String mWarehouseId, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, " +
      "	  SUM(LINENETAMT) AS LINENETAMT, SUM(REFUNDAMT) AS REFUNDAMT, " +
      "	  C_DIVIDE(SUM(REFUNDAMT), (SUM(LINENETAMT)+SUM(REFUNDAMT)))*100 AS RATIO, " +
      "	  SUM(QTYINVOICED) AS QTYINVOICED, SUM(REFUNDQTY) AS REFUNDQTY, " +
      "	  SUM(LINENETREF) AS LINENETREF, SUM(REFUNDAMTREF) AS REFUNDAMTREF, " +
      "	  SUM(QTYINVOICEDREF) AS QTYINVOICEDREF, SUM(REFUNDQTYREF) AS REFUNDQTYREF," +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,        " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, " +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS LINENETAMT, " +
      "      C_CURRENCY_CONVERT(SUM(REFUNDAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS REFUNDAMT,  " +
      "      SUM(QTYINVOICED) AS QTYINVOICED, SUM(REFUNDQTY) AS REFUNDQTY, " +
      "      SUM(LINENETREF) AS LINENETREF, SUM(REFUNDAMTREF) AS REFUNDAMTREF, " +
      "      SUM(QTYINVOICEDREF) AS QTYINVOICEDREF, SUM(REFUNDQTYREF) AS REFUNDQTYREF," +
      "	  TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID" +
      "      FROM (SELECT to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1, to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2, to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3, to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4, to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5, to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6, to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7," +
      "      CASE SIGN(C_ORDERLINE.LINENETAMT) WHEN  -1 THEN  0 ELSE  C_ORDERLINE.LINENETAMT END AS LINENETAMT, " +
      "      CASE SIGN(C_ORDERLINE.LINENETAMT) WHEN  -1 THEN  -1*C_ORDERLINE.LINENETAMT ELSE  0 END AS REFUNDAMT, " +
      "      CASE SIGN(C_ORDERLINE.QTYORDERED) WHEN  -1 THEN  0 ELSE  C_ORDERLINE.QTYORDERED END AS QTYINVOICED, " +
      "      CASE SIGN(C_ORDERLINE.QTYORDERED) WHEN  -1 THEN  (-1*C_ORDERLINE.QTYORDERED) ELSE  0 END AS REFUNDQTY, " +
      "      0 AS LINENETREF, 0 AS REFUNDAMTREF, 0 AS QTYINVOICEDREF, 0 AS REFUNDQTYREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,      " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "	  C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_ORDERLINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_ORDER left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_ORDERLINE left join M_PRODUCT on C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                       left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                       left join C_UOM on C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID," +
      "       C_BPARTNER, C_BP_GROUP, M_WAREHOUSE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND 0=0 AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_ORDER.DATEORDERED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_ORDER.DATEORDERED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartner);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProduct==null || mProduct.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + mProduct);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      ") AA" +
      "      WHERE LINENETAMT <> 0" +
      "      OR REFUNDAMT <> 0" +
      "      OR LINENETREF <> 0" +
      "      OR REFUNDAMTREF <> 0" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportRefundSalesDimensionalAnalysesData> vector = new Vector<ReportRefundSalesDimensionalAnalysesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (nivel1 != null && !(nivel1.equals(""))) {
        }
      if (nivel2 != null && !(nivel2.equals(""))) {
        }
      if (nivel3 != null && !(nivel3.equals(""))) {
        }
      if (nivel4 != null && !(nivel4.equals(""))) {
        }
      if (nivel5 != null && !(nivel5.equals(""))) {
        }
      if (nivel6 != null && !(nivel6.equals(""))) {
        }
      if (nivel7 != null && !(nivel7.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProduct != null && !(mProduct.equals(""))) {
        }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (orderby != null && !(orderby.equals(""))) {
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
        ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData = new ReportRefundSalesDimensionalAnalysesData();
        objectReportRefundSalesDimensionalAnalysesData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportRefundSalesDimensionalAnalysesData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportRefundSalesDimensionalAnalysesData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportRefundSalesDimensionalAnalysesData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportRefundSalesDimensionalAnalysesData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportRefundSalesDimensionalAnalysesData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportRefundSalesDimensionalAnalysesData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportRefundSalesDimensionalAnalysesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportRefundSalesDimensionalAnalysesData.refundamt = UtilSql.getValue(result, "refundamt");
        objectReportRefundSalesDimensionalAnalysesData.ratio = UtilSql.getValue(result, "ratio");
        objectReportRefundSalesDimensionalAnalysesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectReportRefundSalesDimensionalAnalysesData.refundqty = UtilSql.getValue(result, "refundqty");
        objectReportRefundSalesDimensionalAnalysesData.linenetref = UtilSql.getValue(result, "linenetref");
        objectReportRefundSalesDimensionalAnalysesData.refundamtref = UtilSql.getValue(result, "refundamtref");
        objectReportRefundSalesDimensionalAnalysesData.qtyinvoicedref = UtilSql.getValue(result, "qtyinvoicedref");
        objectReportRefundSalesDimensionalAnalysesData.refundqtyref = UtilSql.getValue(result, "refundqtyref");
        objectReportRefundSalesDimensionalAnalysesData.convsym = UtilSql.getValue(result, "convsym");
        objectReportRefundSalesDimensionalAnalysesData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportRefundSalesDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundSalesDimensionalAnalysesData);
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
    ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData[] = new ReportRefundSalesDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundSalesDimensionalAnalysesData);
    return(objectReportRefundSalesDimensionalAnalysesData);
  }

  public static String selectBpgroup(ConnectionProvider connectionProvider, String cBpGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BP_GROUP.NAME" +
      "      FROM C_BP_GROUP" +
      "      WHERE C_BP_GROUP.C_BP_GROUP_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);

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

  public static String selectProductCategory(ConnectionProvider connectionProvider, String mProductCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_PRODUCT_CATEGORY.NAME" +
      "      FROM M_PRODUCT_CATEGORY" +
      "      WHERE M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);

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

  public static String selectSalesrep(ConnectionProvider connectionProvider, String salesrepId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_USER.FIRSTNAME||' '||AD_USER.LASTNAME" +
      "      FROM AD_USER" +
      "      WHERE AD_USER.AD_USER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static String selectMwarehouse(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_WAREHOUSE.NAME" +
      "      FROM M_WAREHOUSE" +
      "      WHERE M_WAREHOUSE.M_WAREHOUSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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

  public static ReportRefundSalesDimensionalAnalysesData[] selectNotShown(ConnectionProvider connectionProvider, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, notShown, 0, 0);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectNotShown(ConnectionProvider connectionProvider, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087'" +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6', '7')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportRefundSalesDimensionalAnalysesData> vector = new Vector<ReportRefundSalesDimensionalAnalysesData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (notShown != null && !(notShown.equals(""))) {
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
        ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData = new ReportRefundSalesDimensionalAnalysesData();
        objectReportRefundSalesDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundSalesDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundSalesDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundSalesDimensionalAnalysesData);
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
    ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData[] = new ReportRefundSalesDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundSalesDimensionalAnalysesData);
    return(objectReportRefundSalesDimensionalAnalysesData);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectShown(ConnectionProvider connectionProvider, String shown)    throws ServletException {
    return selectShown(connectionProvider, shown, 0, 0);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectShown(ConnectionProvider connectionProvider, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087' " +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6', '7')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportRefundSalesDimensionalAnalysesData> vector = new Vector<ReportRefundSalesDimensionalAnalysesData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (shown != null && !(shown.equals(""))) {
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
        ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData = new ReportRefundSalesDimensionalAnalysesData();
        objectReportRefundSalesDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundSalesDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundSalesDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundSalesDimensionalAnalysesData);
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
    ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData[] = new ReportRefundSalesDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundSalesDimensionalAnalysesData);
    return(objectReportRefundSalesDimensionalAnalysesData);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShownTrl(connectionProvider, lang, notShown, 0, 0);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '7')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportRefundSalesDimensionalAnalysesData> vector = new Vector<ReportRefundSalesDimensionalAnalysesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      if (notShown != null && !(notShown.equals(""))) {
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
        ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData = new ReportRefundSalesDimensionalAnalysesData();
        objectReportRefundSalesDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundSalesDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundSalesDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundSalesDimensionalAnalysesData);
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
    ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData[] = new ReportRefundSalesDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundSalesDimensionalAnalysesData);
    return(objectReportRefundSalesDimensionalAnalysesData);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown)    throws ServletException {
    return selectShownTrl(connectionProvider, lang, shown, 0, 0);
  }

  public static ReportRefundSalesDimensionalAnalysesData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '7')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportRefundSalesDimensionalAnalysesData> vector = new Vector<ReportRefundSalesDimensionalAnalysesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      if (shown != null && !(shown.equals(""))) {
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
        ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData = new ReportRefundSalesDimensionalAnalysesData();
        objectReportRefundSalesDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportRefundSalesDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportRefundSalesDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRefundSalesDimensionalAnalysesData);
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
    ReportRefundSalesDimensionalAnalysesData objectReportRefundSalesDimensionalAnalysesData[] = new ReportRefundSalesDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportRefundSalesDimensionalAnalysesData);
    return(objectReportRefundSalesDimensionalAnalysesData);
  }
}
