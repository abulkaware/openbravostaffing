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
import org.openbravo.data.ScrollableFieldProvider;

class ReportInvoiceVendorDimensionalAnalysesJRData implements FieldProvider, ScrollableFieldProvider {
static Logger log4j = Logger.getLogger(ReportInvoiceVendorDimensionalAnalysesJRData.class);
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
  public String org;
  public String partnergroup;
  public String partner;
  public String documentno;
  public String invoicedate;
  public String prodcategory;
  public String product;
  public String searchkey;
  public String unitprice;

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
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("partnergroup"))
      return partnergroup;
    else if (fieldName.equalsIgnoreCase("partner"))
      return partner;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("invoicedate"))
      return invoicedate;
    else if (fieldName.equalsIgnoreCase("prodcategory"))
      return prodcategory;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("searchkey"))
      return searchkey;
    else if (fieldName.equalsIgnoreCase("unitprice"))
      return unitprice;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  private String scrollableGetter;
  @SuppressWarnings("unused")
  private long countRecord;
  private ResultSet result;
  private boolean hasData;
  private ConnectionProvider internalConnProvider;
  private Connection internalConnection;
  private boolean errorOcurred;
 
  @Override
  public boolean hasData() {
    return hasData;
  }

  @Override
  public boolean next() throws ServletException {
    try {
      if (result.next()) {
        countRecord++;
        return true;
      }
      return false;
    } catch(SQLException e){
      errorOcurred = true;
      log4j.error("Error calling jdbc next()", e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    }
  }

  @Override
  public ReportInvoiceVendorDimensionalAnalysesJRData get() throws ServletException {
    try {
      if ("selectXLS".equals(scrollableGetter)) {
        return getselectXLS();
      } else {
        throw new ServletException("getNext() called without calling any scrollable select first");
      }
    } catch(SQLException e){
      errorOcurred = true;
      log4j.error("Error calling jdbc getter()", e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    }
  }

  @Override
  public void close() {
    try {
      if (result != null) {
        result.getStatement().close();
      }
       // handle internalConnection != null explicitely here? then more obvious?
      if (errorOcurred) {
        internalConnProvider.releaseRollbackConnection(internalConnection);
      } else {
        internalConnProvider.releaseCommitConnection(internalConnection);
      }
    } catch (SQLException sqe) {
      log4j.error("Exception on closing statement/resultset", sqe);
    }
  }


  public static ReportInvoiceVendorDimensionalAnalysesJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String producttype, String dateFromRef, String dateToRef, String orderby)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, producttype, dateFromRef, dateToRef, orderby, 0, 0);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String producttype, String dateFromRef, String dateToRef, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5," +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,           	        	  " +
      "	  SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,	  	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "	  '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID," +
      "      '' AS ORG, '' AS PARTNERGROUP, '' AS PARTNER, '' AS DOCUMENTNO, '' AS INVOICEDATE, '' AS PRODCATEGORY, '' AS PRODUCT," +
      "      '' AS SEARCHKEY, '' AS UNITPRICE" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYINVOICED) AS QTY," +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF,     " +
      "	  C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT,  	  " +
      "	  C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF,       " +
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
      "      C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "	  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "	  C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_INVOICELINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join C_UOM     on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID," +
      "      C_INVOICE, C_BPARTNER, C_BP_GROUP" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.ISSOTRX = 'N'" +
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
      ") AS NIVEL5, " +
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, " +
      "      C_INVOICELINE.LINENETAMT AS LINENETREF, C_INVOICELINE.QTYINVOICED AS QTYINVOICEDREF, C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "	  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "	  C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_INVOICELINE.AD_ORG_ID AS TRORGID" +
      "      FROM C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join C_UOM     on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID," +
      "            C_INVOICE, C_BPARTNER, C_BP_GROUP  " +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.ISSOTRX = 'N'" +
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
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceVendorDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceVendorDimensionalAnalysesJRData>(0);
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
        ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData = new ReportInvoiceVendorDimensionalAnalysesJRData();
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceVendorDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceVendorDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceVendorDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceVendorDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceVendorDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceVendorDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceVendorDimensionalAnalysesJRData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportInvoiceVendorDimensionalAnalysesJRData.transdate = UtilSql.getValue(result, "transdate");
        objectReportInvoiceVendorDimensionalAnalysesJRData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportInvoiceVendorDimensionalAnalysesJRData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportInvoiceVendorDimensionalAnalysesJRData.org = UtilSql.getValue(result, "org");
        objectReportInvoiceVendorDimensionalAnalysesJRData.partnergroup = UtilSql.getValue(result, "partnergroup");
        objectReportInvoiceVendorDimensionalAnalysesJRData.partner = UtilSql.getValue(result, "partner");
        objectReportInvoiceVendorDimensionalAnalysesJRData.documentno = UtilSql.getValue(result, "documentno");
        objectReportInvoiceVendorDimensionalAnalysesJRData.invoicedate = UtilSql.getValue(result, "invoicedate");
        objectReportInvoiceVendorDimensionalAnalysesJRData.prodcategory = UtilSql.getValue(result, "prodcategory");
        objectReportInvoiceVendorDimensionalAnalysesJRData.product = UtilSql.getValue(result, "product");
        objectReportInvoiceVendorDimensionalAnalysesJRData.searchkey = UtilSql.getValue(result, "searchkey");
        objectReportInvoiceVendorDimensionalAnalysesJRData.unitprice = UtilSql.getValue(result, "unitprice");
        objectReportInvoiceVendorDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceVendorDimensionalAnalysesJRData);
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
    ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData[] = new ReportInvoiceVendorDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceVendorDimensionalAnalysesJRData);
    return(objectReportInvoiceVendorDimensionalAnalysesJRData);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String producttype, String orderby)    throws ServletException {
    return selectNoComparative(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, producttype, orderby, 0, 0);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String producttype, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5," +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT, " +
      "      SUM(CONVAMOUNTREF) AS CONVAMOUNTREF,          " +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(CASE WHEN DOCBASETYPE = 'APC' THEN QTYINVOICED*-1 ELSE QTYINVOICED END) AS QTY," +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF,     " +
      "	  CASE WHEN (SELECT COUNT(C_CONVERSION_RATE_DOCUMENT_ID) FROM C_CONVERSION_RATE_DOCUMENT WHERE C_INVOICE_ID=INVOICEID) > 0 THEN ((SELECT RATE FROM C_CONVERSION_RATE_DOCUMENT WHERE C_INVOICE_ID=INVOICEID)*(SELECT GRANDTOTAL FROM C_INVOICE WHERE C_INVOICE_ID=INVOICEID)) ELSE C_CURRENCY_CONVERT(SUM(CASE WHEN DOCBASETYPE = 'APC' THEN LINENETAMT*-1 ELSE LINENETAMT END), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) END AS CONVAMOUNT," +
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
      "      C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "	  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "	  C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "	  C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "      C_INVOICE.C_INVOICE_ID AS INVOICEID," +
      "      C_DOCTYPE.DOCBASETYPE AS DOCBASETYPE" +
      "      FROM C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join C_UOM     on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID " +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                         left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID," +
      "      C_BPARTNER, C_BP_GROUP" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.ISSOTRX = 'N'" +
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
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + 
      ") AA" +
      "      GROUP BY NIVEL1,  NIVEL2, NIVEL3, NIVEL4, NIVEL5, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID, INVOICEID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceVendorDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceVendorDimensionalAnalysesJRData>(0);
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
        ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData = new ReportInvoiceVendorDimensionalAnalysesJRData();
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceVendorDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceVendorDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceVendorDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceVendorDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceVendorDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceVendorDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceVendorDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceVendorDimensionalAnalysesJRData);
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
    ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData[] = new ReportInvoiceVendorDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceVendorDimensionalAnalysesJRData);
    return(objectReportInvoiceVendorDimensionalAnalysesJRData);
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

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, notShown, 0, 0);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ReportInvoiceVendorDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceVendorDimensionalAnalysesJRData>(0);
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
        ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData = new ReportInvoiceVendorDimensionalAnalysesJRData();
        objectReportInvoiceVendorDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceVendorDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceVendorDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceVendorDimensionalAnalysesJRData);
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
    ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData[] = new ReportInvoiceVendorDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceVendorDimensionalAnalysesJRData);
    return(objectReportInvoiceVendorDimensionalAnalysesJRData);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectShown(ConnectionProvider connectionProvider, String shown)    throws ServletException {
    return selectShown(connectionProvider, shown, 0, 0);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectShown(ConnectionProvider connectionProvider, String shown, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ReportInvoiceVendorDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceVendorDimensionalAnalysesJRData>(0);
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
        ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData = new ReportInvoiceVendorDimensionalAnalysesJRData();
        objectReportInvoiceVendorDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceVendorDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceVendorDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceVendorDimensionalAnalysesJRData);
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
    ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData[] = new ReportInvoiceVendorDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceVendorDimensionalAnalysesJRData);
    return(objectReportInvoiceVendorDimensionalAnalysesJRData);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShownTrl(connectionProvider, lang, notShown, 0, 0);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ReportInvoiceVendorDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceVendorDimensionalAnalysesJRData>(0);
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
        ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData = new ReportInvoiceVendorDimensionalAnalysesJRData();
        objectReportInvoiceVendorDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceVendorDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceVendorDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceVendorDimensionalAnalysesJRData);
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
    ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData[] = new ReportInvoiceVendorDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceVendorDimensionalAnalysesJRData);
    return(objectReportInvoiceVendorDimensionalAnalysesJRData);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown)    throws ServletException {
    return selectShownTrl(connectionProvider, lang, shown, 0, 0);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ReportInvoiceVendorDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceVendorDimensionalAnalysesJRData>(0);
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
        ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData = new ReportInvoiceVendorDimensionalAnalysesJRData();
        objectReportInvoiceVendorDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceVendorDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceVendorDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceVendorDimensionalAnalysesJRData);
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
    ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData[] = new ReportInvoiceVendorDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceVendorDimensionalAnalysesJRData);
    return(objectReportInvoiceVendorDimensionalAnalysesJRData);
  }

  public static ReportInvoiceVendorDimensionalAnalysesJRData selectXLS(ConnectionProvider connectionProvider, String cCurrencyConv, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String producttype)    throws ServletException {
    ReportInvoiceVendorDimensionalAnalysesJRData instance = new ReportInvoiceVendorDimensionalAnalysesJRData();
    instance.scrollableGetter = "selectXLS";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "    SELECT ORG, PARTNERGROUP, PARTNER, DOCUMENTNO, INVOICEDATE, PRODCATEGORY, PRODUCT, SEARCHKEY, UNITPRICE, AMOUNT, QTY" +
      "      FROM " +
      "      (SELECT (SELECT O.NAME FROM AD_ORG O WHERE O.AD_ORG_ID = C_INVOICE.AD_ORG_ID) AS ORG,             " +
      "       C_BP_GROUP.NAME AS PARTNERGROUP,             " +
      "       C_BPARTNER.NAME AS PARTNER,             " +
      "       C_INVOICE.DOCUMENTNO AS DOCUMENTNO,             " +
      "       TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS INVOICEDATE,  " +
      "       M_PRODUCT_CATEGORY.NAME AS PRODCATEGORY,             " +
      "       M_PRODUCT.NAME AS PRODUCT," +
      "       M_PRODUCT.VALUE AS SEARCHKEY, " +
      "       C_CURRENCY_CONVERT(CASE WHEN C_INVOICELINE.QTYINVOICED = 0 THEN 0 ELSE C_INVOICELINE.LINENETAMT/C_INVOICELINE.QTYINVOICED END, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICE.AD_CLIENT_ID, C_INVOICE.AD_ORG_ID) AS UNITPRICE," +
      "       CASE WHEN C_DOCTYPE.DOCBASETYPE = 'APC' THEN C_CURRENCY_CONVERT(C_INVOICELINE.LINENETAMT*-1, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICE.AD_CLIENT_ID, C_INVOICE.AD_ORG_ID) ELSE C_CURRENCY_CONVERT(C_INVOICELINE.LINENETAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICE.AD_CLIENT_ID, C_INVOICE.AD_ORG_ID) END AS AMOUNT," +
      "       CASE WHEN C_DOCTYPE.DOCBASETYPE = 'APC' THEN C_INVOICELINE.QTYINVOICED*-1 ELSE C_INVOICELINE.QTYINVOICED END AS QTY" +
      "      FROM C_INVOICELINE left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                         left join C_UOM     on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID " +
      "                         left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                         left join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                         left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID," +
      "      C_BPARTNER, C_BP_GROUP" +
      "      WHERE C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "      AND C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICE.ISSOTRX = 'N'" +
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
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + 
      ") AA" +
      "      ORDER BY ORG, DOCUMENTNO, INVOICEDATE";

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
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
      if (producttype != null && !(producttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      }

      // on postgres use non zero fetchsize to read data via cursor and not all at once
      if (connectionProvider.getRDBMS().equalsIgnoreCase("POSTGRE")) {
        st.setFetchSize(1000);
      }
      instance.result = st.executeQuery();
      instance.hasData = instance.result.isBeforeFirst();
      instance.countRecord = 0;
    } catch (SQLException e) {
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=@" + ex.getMessage());
    }

    return instance;
  }

  private ReportInvoiceVendorDimensionalAnalysesJRData getselectXLS() throws SQLException {
    ReportInvoiceVendorDimensionalAnalysesJRData objectReportInvoiceVendorDimensionalAnalysesJRData = new ReportInvoiceVendorDimensionalAnalysesJRData();

        objectReportInvoiceVendorDimensionalAnalysesJRData.org = UtilSql.getValue(result, "org");
        objectReportInvoiceVendorDimensionalAnalysesJRData.partnergroup = UtilSql.getValue(result, "partnergroup");
        objectReportInvoiceVendorDimensionalAnalysesJRData.partner = UtilSql.getValue(result, "partner");
        objectReportInvoiceVendorDimensionalAnalysesJRData.documentno = UtilSql.getValue(result, "documentno");
        objectReportInvoiceVendorDimensionalAnalysesJRData.invoicedate = UtilSql.getDateValue(result, "invoicedate", "dd-MM-yyyy");
        objectReportInvoiceVendorDimensionalAnalysesJRData.prodcategory = UtilSql.getValue(result, "prodcategory");
        objectReportInvoiceVendorDimensionalAnalysesJRData.product = UtilSql.getValue(result, "product");
        objectReportInvoiceVendorDimensionalAnalysesJRData.searchkey = UtilSql.getValue(result, "searchkey");
        objectReportInvoiceVendorDimensionalAnalysesJRData.unitprice = UtilSql.getValue(result, "unitprice");
        objectReportInvoiceVendorDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceVendorDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
      return objectReportInvoiceVendorDimensionalAnalysesJRData;
  }
}
