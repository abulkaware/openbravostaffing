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

class ReportSalesDimensionalAnalyzeJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportSalesDimensionalAnalyzeJRData.class);
  private String InitRecordNumber="0";
  public String nivel1;
  public String nivel2;
  public String nivel3;
  public String nivel4;
  public String nivel5;
  public String nivel6;
  public String nivel7;
  public String nivel8;
  public String nivel9;
  public String nivel10;
  public String nivel11;
  public String amount;
  public String qty;
  public String weight;
  public String amountref;
  public String qtyref;
  public String weightref;
  public String convamount;
  public String convamountref;
  public String convsym;
  public String convisosym;
  public String id;
  public String name;
  public String transcurrencyid;
  public String transdate;
  public String transclientid;
  public String transorgid;
  public String wsymbol;

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
    else if (fieldName.equalsIgnoreCase("nivel8"))
      return nivel8;
    else if (fieldName.equalsIgnoreCase("nivel9"))
      return nivel9;
    else if (fieldName.equalsIgnoreCase("nivel10"))
      return nivel10;
    else if (fieldName.equalsIgnoreCase("nivel11"))
      return nivel11;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("amountref"))
      return amountref;
    else if (fieldName.equalsIgnoreCase("qtyref"))
      return qtyref;
    else if (fieldName.equalsIgnoreCase("weightref"))
      return weightref;
    else if (fieldName.equalsIgnoreCase("convamount"))
      return convamount;
    else if (fieldName.equalsIgnoreCase("convamountref"))
      return convamountref;
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
    else if (fieldName.equalsIgnoreCase("wsymbol"))
      return wsymbol;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportSalesDimensionalAnalyzeJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String nivel11, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String partnerSalesrepId, String dateFromRef, String dateToRef, String orderby)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, nivel11, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, mWarehouseId, salesrepId, partnerSalesrepId, dateFromRef, dateToRef, orderby, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String nivel11, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String partnerSalesrepId, String dateFromRef, String dateToRef, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11,	  " +
      "	  SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, 	  " +
      "	  SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF,	  " +
      "	  SUM(CONVAMOUNT) AS CONVAMOUNT,           	        	  " +
      "	  SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,	  	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "	  '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID ,MIN(WSYMBOL) AS WSYMBOL  " +
      "	  FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11," +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYORDERED) AS QTY, SUM(WEIGHT) AS WEIGHT, " +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYORDEREDREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF," +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT," +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF," +
      "	  TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID,MIN(WSYMBOL) AS WSYMBOL" +
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
      ") AS NIVEL7, to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8, to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9, to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10, to_char(";
    strSql = strSql + ((nivel11==null || nivel11.equals(""))?"":nivel11);
    strSql = strSql + 
      ") AS NIVEL11, " +
      "      C_ORDERLINE.LINENETAMT, C_ORDERLINE.QTYORDERED, C_ORDERLINE.QTYORDERED*M_PRODUCT.WEIGHT AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYORDEREDREF, 0 AS WEIGHTREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,      " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "      C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_ORDERLINE.AD_ORG_ID AS TRORGID," +
      "      (select uomsymbol from c_uom where c_uom_id = aci.c_uom_weight_id) as WSYMBOL" +
      "      FROM C_ORDER " +
      "      left join ad_clientinfo aci on aci.ad_client_id =c_order.ad_client_id" +
      "      left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, C_ORDERLINE, M_PRODUCT, M_PRODUCT_CATEGORY, M_WAREHOUSE, C_UOM,  AD_ORG" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND C_ORDER.DOCSTATUS NOT IN ('CJ', 'UE', 'CA')" +
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
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
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
      ") AS NIVEL7 , to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8 , to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9 , to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10 , to_char(";
    strSql = strSql + ((nivel11==null || nivel11.equals(""))?"":nivel11);
    strSql = strSql + 
      ") AS NIVEL11," +
      "      0 AS LINENETAMT, 0 AS QTYORDERED, 0 AS WEIGHT, " +
      "      C_ORDERLINE.LINENETAMT AS LINENETREF, C_ORDERLINE.QTYORDERED AS QTYORDEREDREF, C_ORDERLINE.QTYORDERED*M_PRODUCT.WEIGHT AS WEIGHTREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,      " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "      C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_ORDERLINE.AD_ORG_ID AS TRORGID," +
      "      (select uomsymbol from c_uom where c_uom_id = aci.c_uom_weight_id) as WSYMBOL" +
      "      FROM C_ORDER " +
      "      left join ad_clientinfo aci on aci.ad_client_id =c_order.ad_client_id" +
      "      left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_Id, " +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "       C_BP_GROUP, C_ORDERLINE, M_PRODUCT, M_PRODUCT_CATEGORY, M_WAREHOUSE, C_UOM,  AD_ORG " +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND C_ORDER.DOCSTATUS NOT IN ('CJ', 'UE', 'CA')" +
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
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ      " +
      "	  GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportSalesDimensionalAnalyzeJRData> vector = new Vector<ReportSalesDimensionalAnalyzeJRData>(0);
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
      if (nivel8 != null && !(nivel8.equals(""))) {
        }
      if (nivel9 != null && !(nivel9.equals(""))) {
        }
      if (nivel10 != null && !(nivel10.equals(""))) {
        }
      if (nivel11 != null && !(nivel11.equals(""))) {
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
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
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
      if (nivel8 != null && !(nivel8.equals(""))) {
        }
      if (nivel9 != null && !(nivel9.equals(""))) {
        }
      if (nivel10 != null && !(nivel10.equals(""))) {
        }
      if (nivel11 != null && !(nivel11.equals(""))) {
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
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportSalesDimensionalAnalyzeJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportSalesDimensionalAnalyzeJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportSalesDimensionalAnalyzeJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportSalesDimensionalAnalyzeJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportSalesDimensionalAnalyzeJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportSalesDimensionalAnalyzeJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportSalesDimensionalAnalyzeJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportSalesDimensionalAnalyzeJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportSalesDimensionalAnalyzeJRData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportSalesDimensionalAnalyzeJRData.nivel11 = UtilSql.getValue(result, "nivel11");
        objectReportSalesDimensionalAnalyzeJRData.amount = UtilSql.getValue(result, "amount");
        objectReportSalesDimensionalAnalyzeJRData.qty = UtilSql.getValue(result, "qty");
        objectReportSalesDimensionalAnalyzeJRData.weight = UtilSql.getValue(result, "weight");
        objectReportSalesDimensionalAnalyzeJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportSalesDimensionalAnalyzeJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportSalesDimensionalAnalyzeJRData.weightref = UtilSql.getValue(result, "weightref");
        objectReportSalesDimensionalAnalyzeJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportSalesDimensionalAnalyzeJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportSalesDimensionalAnalyzeJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportSalesDimensionalAnalyzeJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportSalesDimensionalAnalyzeJRData.transdate = UtilSql.getValue(result, "transdate");
        objectReportSalesDimensionalAnalyzeJRData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportSalesDimensionalAnalyzeJRData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportSalesDimensionalAnalyzeJRData.wsymbol = UtilSql.getValue(result, "wsymbol");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static String selectCount(ConnectionProvider connectionProvider, String levels, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String partnerSalesrepId, String dateFrom, String dateTo, String dateFromRef, String dateToRef)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT( DISTINCT ";
    strSql = strSql + ((levels==null || levels.equals(""))?"":levels);
    strSql = strSql + 
      " ) AS COUNT" +
      "      FROM C_ORDER left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, C_ORDERLINE, M_PRODUCT, M_PRODUCT_CATEGORY, M_WAREHOUSE, C_UOM,  AD_ORG" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND C_ORDER.DOCSTATUS NOT IN ('CJ', 'UE', 'CA')" +
      "      AND 0=0 AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + 
      " AND ((2=2";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_ORDER.DATEORDERED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_ORDER.DATEORDERED < to_date(?) ");
    strSql = strSql + 
      ")OR (3=3";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":" AND C_ORDER.DATEORDERED >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":" AND C_ORDER.DATEORDERED < to_date(?) ");
    strSql = strSql + 
      "))";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (levels != null && !(levels.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (dateFromRef != null && !(dateFromRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      }
      if (dateToRef != null && !(dateToRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static ReportSalesDimensionalAnalyzeJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String nivel11, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String partnerSalesrepId, String orderby)    throws ServletException {
    return selectNoComparative(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, nivel11, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, mWarehouseId, salesrepId, partnerSalesrepId, orderby, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String nivel11, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String partnerSalesrepId, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11, " +
      "	  SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, " +
      "	  SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF," +
      "	  SUM(CONVAMOUNT) AS CONVAMOUNT," +
      "	  SUM(CONVAMOUNTREF) AS CONVAMOUNTREF,           " +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,        " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "	  MIN(WSYMBOL) AS WSYMBOL" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11,  " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYORDERED) AS QTY, SUM(WEIGHT) AS WEIGHT, " +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYORDEREDREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF," +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT," +
      "      0 AS CONVAMOUNTREF," +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID," +
      "      MIN(WSYMBOL) AS WSYMBOL" +
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
      ") AS NIVEL7, to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8, to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9, to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10, to_char(";
    strSql = strSql + ((nivel11==null || nivel11.equals(""))?"":nivel11);
    strSql = strSql + 
      ") AS NIVEL11, " +
      "      C_ORDERLINE.LINENETAMT, C_ORDERLINE.QTYORDERED, C_ORDERLINE.QTYORDERED*M_PRODUCT.WEIGHT AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYORDEREDREF, 0 AS WEIGHTREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,      " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "	  C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_ORDERLINE.AD_ORG_ID AS TRORGID," +
      "	  (select uomsymbol from c_uom where c_uom_id = aci.c_uom_weight_id) as WSYMBOL" +
      "      FROM C_ORDER " +
      "      left join ad_clientinfo aci on aci.ad_client_id =c_order.ad_client_id" +
      "      left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID, " +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "       C_BP_GROUP, C_ORDERLINE, M_PRODUCT, M_PRODUCT_CATEGORY, M_WAREHOUSE, C_UOM,  AD_ORG" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND C_ORDER.DOCSTATUS NOT IN ('CJ', 'UE', 'CA')" +
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
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, NIVEL11";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportSalesDimensionalAnalyzeJRData> vector = new Vector<ReportSalesDimensionalAnalyzeJRData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
      if (nivel8 != null && !(nivel8.equals(""))) {
        }
      if (nivel9 != null && !(nivel9.equals(""))) {
        }
      if (nivel10 != null && !(nivel10.equals(""))) {
        }
      if (nivel11 != null && !(nivel11.equals(""))) {
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
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportSalesDimensionalAnalyzeJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportSalesDimensionalAnalyzeJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportSalesDimensionalAnalyzeJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportSalesDimensionalAnalyzeJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportSalesDimensionalAnalyzeJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportSalesDimensionalAnalyzeJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportSalesDimensionalAnalyzeJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportSalesDimensionalAnalyzeJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportSalesDimensionalAnalyzeJRData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportSalesDimensionalAnalyzeJRData.nivel11 = UtilSql.getValue(result, "nivel11");
        objectReportSalesDimensionalAnalyzeJRData.amount = UtilSql.getValue(result, "amount");
        objectReportSalesDimensionalAnalyzeJRData.qty = UtilSql.getValue(result, "qty");
        objectReportSalesDimensionalAnalyzeJRData.weight = UtilSql.getValue(result, "weight");
        objectReportSalesDimensionalAnalyzeJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportSalesDimensionalAnalyzeJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportSalesDimensionalAnalyzeJRData.weightref = UtilSql.getValue(result, "weightref");
        objectReportSalesDimensionalAnalyzeJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportSalesDimensionalAnalyzeJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportSalesDimensionalAnalyzeJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportSalesDimensionalAnalyzeJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportSalesDimensionalAnalyzeJRData.wsymbol = UtilSql.getValue(result, "wsymbol");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static String selectNoComparativeCount(ConnectionProvider connectionProvider, String levels, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String mWarehouseId, String salesrepId, String partnerSalesrepId, String dateFrom, String dateTo)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT( DISTINCT ";
    strSql = strSql + ((levels==null || levels.equals(""))?"":levels);
    strSql = strSql + 
      " ) AS COUNT" +
      "      FROM C_ORDER left join AD_USER on C_ORDER.SALESREP_ID = AD_USER.AD_USER_ID," +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, C_ORDERLINE, M_PRODUCT, M_PRODUCT_CATEGORY, M_WAREHOUSE, C_UOM,  AD_ORG" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "      AND C_ORDER.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_ORDER.PROCESSED = 'Y'" +
      "      AND C_ORDER.DOCSTATUS NOT IN ('CJ', 'UE', 'CA')" +
      "      AND 0=0 AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_WAREHOUSE.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_ORDER.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + 
      " AND 2=2";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_ORDER.DATEORDERED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_ORDER.DATEORDERED < to_date(?) ");

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (levels != null && !(levels.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (cBpartnerGroupId != null && !(cBpartnerGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerGroupId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String selectSalesrep(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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

  public static ReportSalesDimensionalAnalyzeJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, notShown, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087'" +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportSalesDimensionalAnalyzeJRData> vector = new Vector<ReportSalesDimensionalAnalyzeJRData>(0);
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectShown(ConnectionProvider connectionProvider, String shown)    throws ServletException {
    return selectShown(connectionProvider, shown, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectShown(ConnectionProvider connectionProvider, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087' " +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportSalesDimensionalAnalyzeJRData> vector = new Vector<ReportSalesDimensionalAnalyzeJRData>(0);
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShownTrl(connectionProvider, lang, notShown, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportSalesDimensionalAnalyzeJRData> vector = new Vector<ReportSalesDimensionalAnalyzeJRData>(0);
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown)    throws ServletException {
    return selectShownTrl(connectionProvider, lang, shown, 0, 0);
  }

  public static ReportSalesDimensionalAnalyzeJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportSalesDimensionalAnalyzeJRData> vector = new Vector<ReportSalesDimensionalAnalyzeJRData>(0);
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
        ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData = new ReportSalesDimensionalAnalyzeJRData();
        objectReportSalesDimensionalAnalyzeJRData.id = UtilSql.getValue(result, "id");
        objectReportSalesDimensionalAnalyzeJRData.name = UtilSql.getValue(result, "name");
        objectReportSalesDimensionalAnalyzeJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesDimensionalAnalyzeJRData);
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
    ReportSalesDimensionalAnalyzeJRData objectReportSalesDimensionalAnalyzeJRData[] = new ReportSalesDimensionalAnalyzeJRData[vector.size()];
    vector.copyInto(objectReportSalesDimensionalAnalyzeJRData);
    return(objectReportSalesDimensionalAnalyzeJRData);
  }
}
