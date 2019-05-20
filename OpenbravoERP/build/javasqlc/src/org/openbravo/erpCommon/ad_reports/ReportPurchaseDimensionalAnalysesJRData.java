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

class ReportPurchaseDimensionalAnalysesJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportPurchaseDimensionalAnalysesJRData.class);
  private String InitRecordNumber="0";
  public String nivel1;
  public String nivel2;
  public String nivel3;
  public String nivel4;
  public String nivel5;
  public String amount;
  public String qty;
  public String amountref;
  public String qtyref;
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
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("amountref"))
      return amountref;
    else if (fieldName.equalsIgnoreCase("qtyref"))
      return qtyref;
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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportPurchaseDimensionalAnalysesJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String dateFromRef, String dateToRef, String orderby)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, dateFromRef, dateToRef, orderby, 0, 0);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String dateFromRef, String dateToRef, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5," +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,           	        	  " +
      "	  SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,	  	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "	  '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYORDERED) AS QTY," +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYORDEREDREF) AS QTYREF,     " +
      "	  C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT,    	  " +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF,      " +
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
      ") AS NIVEL5, " +
      "      C_ORDERLINE.LINENETAMT, C_ORDERLINE.QTYORDERED, " +
      "      0 AS LINENETREF, 0 AS QTYORDEREDREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,  " +
      "      TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "	  C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_ORDERLINE.AD_ORG_ID AS TRORGID" +
      "      FROM M_PRODUCT left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID " +
      "                     right join C_ORDERLINE on C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                     right join C_ORDER on C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID," +
      "       C_BPARTNER, C_BP_GROUP, C_UOM" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.ISSOTRX = 'N'" +
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
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
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
      ") AS NIVEL5, " +
      "      0 AS LINENETAMT, 0 AS QTYORDERED, " +
      "      C_ORDERLINE.LINENETAMT AS LINENETREF, C_ORDERLINE.QTYORDERED AS QTYORDEREDREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,    " +
      "      TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRDATE," +
      "	  C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_ORDERLINE.AD_ORG_ID AS TRORGID" +
      "      FROM M_PRODUCT left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID " +
      "                     right join C_ORDERLINE on C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                     right join C_ORDER on C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID," +
      "           C_BPARTNER, C_BP_GROUP, C_UOM" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.ISSOTRX = 'N'" +
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
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportPurchaseDimensionalAnalysesJRData> vector = new Vector<ReportPurchaseDimensionalAnalysesJRData>(0);
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
        ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData = new ReportPurchaseDimensionalAnalysesJRData();
        objectReportPurchaseDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportPurchaseDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportPurchaseDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportPurchaseDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportPurchaseDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportPurchaseDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportPurchaseDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportPurchaseDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportPurchaseDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportPurchaseDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportPurchaseDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportPurchaseDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportPurchaseDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportPurchaseDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportPurchaseDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportPurchaseDimensionalAnalysesJRData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportPurchaseDimensionalAnalysesJRData.transdate = UtilSql.getValue(result, "transdate");
        objectReportPurchaseDimensionalAnalysesJRData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportPurchaseDimensionalAnalysesJRData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportPurchaseDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPurchaseDimensionalAnalysesJRData);
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
    ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData[] = new ReportPurchaseDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportPurchaseDimensionalAnalysesJRData);
    return(objectReportPurchaseDimensionalAnalysesJRData);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String orderby)    throws ServletException {
    return selectNoComparative(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, orderby, 0, 0);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5," +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,           " +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,      " +
      "	  SUM(CONVAMOUNTREF) AS CONVAMOUNTREF,	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYORDERED) AS QTY," +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYORDEREDREF) AS QTYREF,   " +
      "	  C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT," +
      "	  0 AS CONVAMOUNTREF," +
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
      ") AS NIVEL5, " +
      "      C_ORDERLINE.LINENETAMT, C_ORDERLINE.QTYORDERED, " +
      "      0 AS LINENETREF, 0 AS QTYORDEREDREF, C_UOM.UOMSYMBOL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRCURRENCYID,  " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED,NOW())) AS TRDATE," +
      "	  C_ORDERLINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_ORDERLINE.AD_ORG_ID AS TRORGID" +
      "      FROM M_PRODUCT left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                     right join C_ORDERLINE on C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                     right join C_ORDER on C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID," +
      "       C_BPARTNER, C_BP_GROUP,  C_UOM" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.ISSOTRX = 'N'" +
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
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportPurchaseDimensionalAnalysesJRData> vector = new Vector<ReportPurchaseDimensionalAnalysesJRData>(0);
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
        ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData = new ReportPurchaseDimensionalAnalysesJRData();
        objectReportPurchaseDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportPurchaseDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportPurchaseDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportPurchaseDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportPurchaseDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportPurchaseDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportPurchaseDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportPurchaseDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportPurchaseDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportPurchaseDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportPurchaseDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportPurchaseDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportPurchaseDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportPurchaseDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPurchaseDimensionalAnalysesJRData);
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
    ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData[] = new ReportPurchaseDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportPurchaseDimensionalAnalysesJRData);
    return(objectReportPurchaseDimensionalAnalysesJRData);
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

  public static ReportPurchaseDimensionalAnalysesJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, notShown, 0, 0);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800086' " +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportPurchaseDimensionalAnalysesJRData> vector = new Vector<ReportPurchaseDimensionalAnalysesJRData>(0);
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
        ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData = new ReportPurchaseDimensionalAnalysesJRData();
        objectReportPurchaseDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportPurchaseDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportPurchaseDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPurchaseDimensionalAnalysesJRData);
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
    ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData[] = new ReportPurchaseDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportPurchaseDimensionalAnalysesJRData);
    return(objectReportPurchaseDimensionalAnalysesJRData);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectShown(ConnectionProvider connectionProvider, String shown)    throws ServletException {
    return selectShown(connectionProvider, shown, 0, 0);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectShown(ConnectionProvider connectionProvider, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800086' " +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportPurchaseDimensionalAnalysesJRData> vector = new Vector<ReportPurchaseDimensionalAnalysesJRData>(0);
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
        ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData = new ReportPurchaseDimensionalAnalysesJRData();
        objectReportPurchaseDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportPurchaseDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportPurchaseDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPurchaseDimensionalAnalysesJRData);
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
    ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData[] = new ReportPurchaseDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportPurchaseDimensionalAnalysesJRData);
    return(objectReportPurchaseDimensionalAnalysesJRData);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShownTrl(connectionProvider, lang, notShown, 0, 0);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800086'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((notShown==null || notShown.equals(""))?"":" AND ID NOT IN" + notShown);

    ResultSet result;
    Vector<ReportPurchaseDimensionalAnalysesJRData> vector = new Vector<ReportPurchaseDimensionalAnalysesJRData>(0);
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
        ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData = new ReportPurchaseDimensionalAnalysesJRData();
        objectReportPurchaseDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportPurchaseDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportPurchaseDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPurchaseDimensionalAnalysesJRData);
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
    ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData[] = new ReportPurchaseDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportPurchaseDimensionalAnalysesJRData);
    return(objectReportPurchaseDimensionalAnalysesJRData);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown)    throws ServletException {
    return selectShownTrl(connectionProvider, lang, shown, 0, 0);
  }

  public static ReportPurchaseDimensionalAnalysesJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800086'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportPurchaseDimensionalAnalysesJRData> vector = new Vector<ReportPurchaseDimensionalAnalysesJRData>(0);
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
        ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData = new ReportPurchaseDimensionalAnalysesJRData();
        objectReportPurchaseDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportPurchaseDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportPurchaseDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPurchaseDimensionalAnalysesJRData);
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
    ReportPurchaseDimensionalAnalysesJRData objectReportPurchaseDimensionalAnalysesJRData[] = new ReportPurchaseDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportPurchaseDimensionalAnalysesJRData);
    return(objectReportPurchaseDimensionalAnalysesJRData);
  }
}
