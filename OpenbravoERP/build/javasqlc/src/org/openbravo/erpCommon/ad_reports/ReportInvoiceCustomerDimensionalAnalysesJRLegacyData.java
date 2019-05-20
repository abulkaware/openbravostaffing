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

class ReportInvoiceCustomerDimensionalAnalysesJRLegacyData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportInvoiceCustomerDimensionalAnalysesJRLegacyData.class);
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
  public String amount;
  public String qty;
  public String weight;
  public String cost;
  public String amountref;
  public String qtyref;
  public String weightref;
  public String costref;
  public String convamount;
  public String convcost;
  public String convamountref;
  public String convcostref;
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
    else if (fieldName.equalsIgnoreCase("nivel8"))
      return nivel8;
    else if (fieldName.equalsIgnoreCase("nivel9"))
      return nivel9;
    else if (fieldName.equalsIgnoreCase("nivel10"))
      return nivel10;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("amountref"))
      return amountref;
    else if (fieldName.equalsIgnoreCase("qtyref"))
      return qtyref;
    else if (fieldName.equalsIgnoreCase("weightref"))
      return weightref;
    else if (fieldName.equalsIgnoreCase("costref"))
      return costref;
    else if (fieldName.equalsIgnoreCase("convamount"))
      return convamount;
    else if (fieldName.equalsIgnoreCase("convcost"))
      return convcost;
    else if (fieldName.equalsIgnoreCase("convamountref"))
      return convamountref;
    else if (fieldName.equalsIgnoreCase("convcostref"))
      return convcostref;
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

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String dateFromRef, String dateToRef, String orderby)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, cCurrencyBase, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, salesrepId, partnerSalesrepId, cProjectId, producttype, dateFromRef, dateToRef, orderby, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String dateFromRef, String dateToRef, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,           	        	  " +
      "	  SUM(CONVCOST) AS CONVCOST,                 " +
      "	  SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "	  SUM(CONVCOSTREF) AS CONVCOSTREF," +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,	  	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "      '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYINVOICED) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST, " +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF, SUM(WEIGHT_REF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF,     	  " +
      "	  C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT, " +
      "	  C_CURRENCY_CONVERT(SUM(COST), ?, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVCOST,    	  " +
      "	  C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF, " +
      "	  C_CURRENCY_CONVERT(SUM(COSTREF), ?, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVCOSTREF,      " +
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
      ") AS NIVEL7, to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8, to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9, to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END AS LINENETAMT," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.QTYINVOICED*-1 ELSE C_INVOICELINE.QTYINVOICED END AS QTYINVOICED, C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN M_GET_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, NULL)*C_INVOICELINE.QTYINVOICED*-1 ELSE M_GET_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, NULL)*C_INVOICELINE.QTYINVOICED END AS COST," +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF, 0 AS COSTREF, C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "	  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "	  C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_INVOICELINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                     left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                     left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID," +
      "           C_INVOICELINE left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                         left join  M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID," +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, AD_ORG" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 0=0 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
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
      ") AS NIVEL10," +
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, 0 AS WEIGHT, 0 AS COST, " +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END AS LINENETREF," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.QTYINVOICED*-1 ELSE C_INVOICELINE.QTYINVOICED END AS QTYINVOICEDREF, C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT_REF," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN M_GET_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, NULL)*C_INVOICELINE.QTYINVOICED*-1 ELSE M_GET_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, NULL)*C_INVOICELINE.QTYINVOICED END AS COSTREF, C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "	  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "	  C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_INVOICELINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                     left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                     left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID, " +
      "           C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join C_UOM     on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                         left join  M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID," +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, AD_ORG" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 3=3 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 2=2";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + 
      "      ORDER BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10) AA" +
      "      GROUP BY  NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
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
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (producttype != null && !(producttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
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
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (producttype != null && !(producttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
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
        ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData();
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.weight = UtilSql.getValue(result, "weight");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.cost = UtilSql.getValue(result, "cost");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.weightref = UtilSql.getValue(result, "weightref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.costref = UtilSql.getValue(result, "costref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convcost = UtilSql.getValue(result, "convcost");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convcostref = UtilSql.getValue(result, "convcostref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.transdate = UtilSql.getValue(result, "transdate");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
  }

  public static String selectCount(ConnectionProvider connectionProvider, String levels, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String dateFrom, String dateTo, String dateFromRef, String dateToRef)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT( DISTINCT ";
    strSql = strSql + ((levels==null || levels.equals(""))?"":levels);
    strSql = strSql + 
      " ) AS COUNT" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                     left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID," +
      "           C_INVOICELINE left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                         left join  M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID," +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, AD_ORG" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 0=0 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + 
      " AND ((2=2";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + 
      ")OR (3=3";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
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
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (producttype != null && !(producttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
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

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String orderby)    throws ServletException {
    return selectNoComparative(connectionProvider, cCurrencyConv, cCurrencyBase, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, salesrepId, partnerSalesrepId, cProjectId, producttype, orderby, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10," +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST, " +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,  " +
      "      SUM(CONVCOST) AS CONVCOST,               " +
      "	  SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "	  SUM(CONVCOSTREF) AS CONVCOSTREF,           " +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,      	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYINVOICED) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST," +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF, SUM(WEIGHT_REF) AS WEIGHTREF," +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT," +
      "      C_CURRENCY_CONVERT(SUM(COST), ?, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVCOST," +
      "	  0 AS CONVAMOUNTREF," +
      "	  0 AS CONVCOSTREF," +
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
      ") AS NIVEL7, to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8, to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9, to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END AS LINENETAMT," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.QTYINVOICED*-1 ELSE C_INVOICELINE.QTYINVOICED END AS QTYINVOICED, C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN M_GET_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, NULL)*C_INVOICELINE.QTYINVOICED*-1 ELSE M_GET_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, NULL)*C_INVOICELINE.QTYINVOICED END AS COST," +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF, C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "	  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "	  C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_INVOICELINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                     left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                     left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID," +
      "           C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                         left join  M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID," +
      "           C_BPARTNER    left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, AD_ORG " +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + 
      "      ORDER BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10) AA" +
      "      GROUP BY  NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
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
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (producttype != null && !(producttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
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
        ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData();
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.weight = UtilSql.getValue(result, "weight");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.cost = UtilSql.getValue(result, "cost");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.weightref = UtilSql.getValue(result, "weightref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convcost = UtilSql.getValue(result, "convcost");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convcostref = UtilSql.getValue(result, "convcostref");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
  }

  public static String selectNoComparativeCount(ConnectionProvider connectionProvider, String levels, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String dateFrom, String dateTo)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT( DISTINCT ";
    strSql = strSql + ((levels==null || levels.equals(""))?"":levels);
    strSql = strSql + 
      " ) AS COUNT" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                     left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID," +
      "           C_INVOICELINE left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                         left join  M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID," +
      "           C_BPARTNER left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID," +
      "           C_BP_GROUP, AD_ORG" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 0=0 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + 
      " AND 2=2";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");

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
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (partnerSalesrepId != null && !(partnerSalesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerSalesrepId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (producttype != null && !(producttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
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

  public static String selectProducttype(ConnectionProvider connectionProvider, String adReferenceId, String adLanguage, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ad_ref_list_trl.NAME FROM ad_ref_list, ad_ref_list_trl " +
      "      WHERE ad_ref_list.AD_REF_LIST_ID = ad_ref_list_trl.AD_REF_LIST_ID" +
      "      AND ad_ref_list.ad_reference_id = ?" +
      "      AND ad_ref_list_trl.ad_language = ?" +
      "      AND ad_ref_list.VALUE = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] selectNotShown(ConnectionProvider connectionProvider, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, notShown, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] selectNotShown(ConnectionProvider connectionProvider, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087'" +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6', '8', '9', '10', '11')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData>(0);
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
        ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData();
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShownTrl(connectionProvider, lang, notShown, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "             AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '8', '9', '10', '11')" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRLegacyData>(0);
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
        ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData();
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRLegacyData objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData[] = new ReportInvoiceCustomerDimensionalAnalysesJRLegacyData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRLegacyData);
  }
}
