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

class ReportInvoiceCustomerDimensionalAnalysesJRData implements FieldProvider, ScrollableFieldProvider {
static Logger log4j = Logger.getLogger(ReportInvoiceCustomerDimensionalAnalysesJRData.class);
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
  public String costcalculated;
  public String org;
  public String partnergroup;
  public String partner;
  public String documentno;
  public String invoicedate;
  public String prodcategory;
  public String product;
  public String profit;
  public String margin;
  public String price;
  public String contact;
  public String salesrep;
  public String project;
  public String address;
  public String doctypecount;
  public String doctype;
  public String doctypename;
  public String amountref2;
  public String qtyref2;
  public String weightref2;
  public String costref2;
  public String convamountref2;
  public String convcostref2;
  public String amountref3;
  public String qtyref3;
  public String weightref3;
  public String costref3;
  public String convamountref3;
  public String convcostref3;
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
    else if (fieldName.equalsIgnoreCase("costcalculated"))
      return costcalculated;
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
    else if (fieldName.equalsIgnoreCase("profit"))
      return profit;
    else if (fieldName.equalsIgnoreCase("margin"))
      return margin;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("contact"))
      return contact;
    else if (fieldName.equalsIgnoreCase("salesrep"))
      return salesrep;
    else if (fieldName.equalsIgnoreCase("project"))
      return project;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("doctypecount"))
      return doctypecount;
    else if (fieldName.equalsIgnoreCase("doctype"))
      return doctype;
    else if (fieldName.equalsIgnoreCase("doctypename"))
      return doctypename;
    else if (fieldName.equalsIgnoreCase("amountref2"))
      return amountref2;
    else if (fieldName.equalsIgnoreCase("qtyref2"))
      return qtyref2;
    else if (fieldName.equalsIgnoreCase("weightref2"))
      return weightref2;
    else if (fieldName.equalsIgnoreCase("costref2"))
      return costref2;
    else if (fieldName.equalsIgnoreCase("convamountref2"))
      return convamountref2;
    else if (fieldName.equalsIgnoreCase("convcostref2"))
      return convcostref2;
    else if (fieldName.equalsIgnoreCase("amountref3"))
      return amountref3;
    else if (fieldName.equalsIgnoreCase("qtyref3"))
      return qtyref3;
    else if (fieldName.equalsIgnoreCase("weightref3"))
      return weightref3;
    else if (fieldName.equalsIgnoreCase("costref3"))
      return costref3;
    else if (fieldName.equalsIgnoreCase("convamountref3"))
      return convamountref3;
    else if (fieldName.equalsIgnoreCase("convcostref3"))
      return convcostref3;
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
  public ReportInvoiceCustomerDimensionalAnalysesJRData get() throws ServletException {
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


  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFromRef, String dateToRef, String orderby)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, salesrepId, partnerSalesrepId, cProjectId, producttype, cDocTypeId, strvoid, dateFromRef, dateToRef, orderby, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFromRef, String dateToRef, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,                          " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOST) WHEN SUM(COSTEDAMT) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) = 0 THEN 0 ELSE SUM(CONVCOST)*SUM(CONVAMOUNT)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) END AS CONVCOST," +
      "      SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOSTREF) WHEN SUM(COSTEDAMTREF) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF END) = 0 THEN 0 ELSE SUM(CONVCOSTREF)*SUM(CONVAMOUNTREF)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF END) END AS CONVCOSTREF," +
      "      C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,        " +
      "      C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "      '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID, SUM(ZZ.COSTCALCULATED) AS COSTCALCULATED," +
      "      '' AS ORG, '' AS PARTNERGROUP, '' AS PARTNER, '' AS DOCUMENTNO, '' AS INVOICEDATE, '' AS PRODCATEGORY, '' AS PRODUCT, " +
      "      '' AS PROFIT, '' AS MARGIN, '' AS PRICE, '' AS CONTACT, '' AS SALESREP, '' AS PROJECT, '' AS ADDRESS, " +
      "      '' AS DOCTYPECOUNT, '' AS DOCTYPE, '' AS DOCTYPENAME,   " +
      "      '' AS AMOUNTREF2, '' AS QTYREF2, '' AS WEIGHTREF2, '' AS COSTREF2, '' AS CONVAMOUNTREF2, '' AS CONVCOSTREF2," +
      "      '' AS AMOUNTREF3, '' AS QTYREF3, '' AS WEIGHTREF3, '' AS COSTREF3, '' AS CONVAMOUNTREF3, '' AS CONVCOSTREF3," +
      "      '' AS SEARCHKEY, '' AS UNITPRICE     " +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYINVOICED) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST, " +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF, SUM(WEIGHT_REF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF,         " +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COST) WHEN SUM(COSTEDAMT) = 0 THEN 0 ELSE SUM(COST)*SUM(LINENETAMT)/SUM(COSTEDAMT) END AS CONVCOST," +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COSTREF) WHEN SUM(COSTEDAMTREF) = 0 THEN 0 ELSE SUM(COSTREF)*SUM(LINENETREF)/SUM(COSTEDAMTREF) END AS CONVCOSTREF," +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID, SUM(AA.COSTCALCULATED) as COSTCALCULATED," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamt," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMTREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamtref," +
      "      COUNT(*) AS GROUPCOUNT" +
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
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETAMT," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICED," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF, C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COST," +
      "                0 AS COSTREF," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMT, 0 AS COSTEDAMTREF" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
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
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, 0 AS WEIGHT, " +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETREF," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICEDREF, " +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT_REF," +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID," +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE," +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID," +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                0 AS COST," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COSTREF," +
      "                0 AS COSTEDAMT," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMTREF" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
      "      ORDER BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10) AA" +
      "      GROUP BY  NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
      if (nivel8 != null && !(nivel8.equals(""))) {
        }
      if (nivel9 != null && !(nivel9.equals(""))) {
        }
      if (nivel10 != null && !(nivel10.equals(""))) {
        }
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weight = UtilSql.getValue(result, "weight");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.cost = UtilSql.getValue(result, "cost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref = UtilSql.getValue(result, "weightref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref = UtilSql.getValue(result, "costref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcost = UtilSql.getValue(result, "convcost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref = UtilSql.getValue(result, "convcostref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transdate = UtilSql.getValue(result, "transdate");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costcalculated = UtilSql.getValue(result, "costcalculated");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.org = UtilSql.getValue(result, "org");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partnergroup = UtilSql.getValue(result, "partnergroup");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partner = UtilSql.getValue(result, "partner");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.documentno = UtilSql.getValue(result, "documentno");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.invoicedate = UtilSql.getValue(result, "invoicedate");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.prodcategory = UtilSql.getValue(result, "prodcategory");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.product = UtilSql.getValue(result, "product");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.profit = UtilSql.getValue(result, "profit");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.margin = UtilSql.getValue(result, "margin");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.price = UtilSql.getValue(result, "price");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.contact = UtilSql.getValue(result, "contact");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.salesrep = UtilSql.getValue(result, "salesrep");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.project = UtilSql.getValue(result, "project");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.address = UtilSql.getValue(result, "address");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.doctypecount = UtilSql.getValue(result, "doctypecount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.doctype = UtilSql.getValue(result, "doctype");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.doctypename = UtilSql.getValue(result, "doctypename");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref2 = UtilSql.getValue(result, "amountref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref2 = UtilSql.getValue(result, "qtyref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref2 = UtilSql.getValue(result, "weightref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref2 = UtilSql.getValue(result, "costref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref2 = UtilSql.getValue(result, "convamountref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref2 = UtilSql.getValue(result, "convcostref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref3 = UtilSql.getValue(result, "amountref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref3 = UtilSql.getValue(result, "qtyref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref3 = UtilSql.getValue(result, "weightref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref3 = UtilSql.getValue(result, "costref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref3 = UtilSql.getValue(result, "convamountref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref3 = UtilSql.getValue(result, "convcostref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.searchkey = UtilSql.getValue(result, "searchkey");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.unitprice = UtilSql.getValue(result, "unitprice");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] select2(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFromRef, String dateToRef, String dateFromRef2, String dateToRef2, String orderby)    throws ServletException {
    return select2(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, salesrepId, partnerSalesrepId, cProjectId, producttype, cDocTypeId, strvoid, dateFromRef, dateToRef, dateFromRef2, dateToRef2, orderby, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] select2(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFromRef, String dateToRef, String dateFromRef2, String dateToRef2, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF," +
      "      SUM(AMOUNTREF2) AS AMOUNTREF2, SUM(QTYREF2) AS QTYREF2, SUM(WEIGHTREF2) AS WEIGHTREF2, SUM(COSTREF2) AS COSTREF2," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,                          " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOST) WHEN SUM(COSTEDAMT) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) = 0 THEN 0 ELSE SUM(CONVCOST)*SUM(CONVAMOUNT)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) END AS CONVCOST," +
      "      SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOSTREF) WHEN SUM(COSTEDAMTREF) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF END) = 0 THEN 0 ELSE SUM(CONVCOSTREF)*SUM(CONVAMOUNTREF)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF END) END AS CONVCOSTREF," +
      "      SUM(CONVAMOUNTREF2) AS CONVAMOUNTREF2," +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOSTREF2) WHEN SUM(COSTEDAMTREF2) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF2 END) = 0 THEN 0 ELSE SUM(CONVCOSTREF2)*SUM(CONVAMOUNTREF2)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF2 END) END AS CONVCOSTREF2," +
      "      C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,        " +
      "      C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "      '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID, SUM(ZZ.COSTCALCULATED) AS COSTCALCULATED," +
      "      '' AS ORG, '' AS PARTNERGROUP, '' AS PARTNER, '' AS DOCUMENTNO, '' AS INVOICEDATE, '' AS PRODCATEGORY, '' AS PRODUCT, " +
      "      '' AS PROFIT, '' AS MARGIN, '' AS PRICE, '' AS CONTACT, '' AS SALESREP, '' AS PROJECT, '' AS ADDRESS" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYINVOICED) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST, " +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF, SUM(WEIGHT_REF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF," +
      "      SUM(LINENETREF2) AS AMOUNTREF2, SUM(QTYINVOICEDREF2) AS QTYREF2, SUM(WEIGHT_REF2) AS WEIGHTREF2, SUM(COSTREF2) AS COSTREF2,         " +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COST) WHEN SUM(COSTEDAMT) = 0 THEN 0 ELSE SUM(COST)*SUM(LINENETAMT)/SUM(COSTEDAMT) END AS CONVCOST," +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COSTREF) WHEN SUM(COSTEDAMTREF) = 0 THEN 0 ELSE SUM(COSTREF)*SUM(LINENETREF)/SUM(COSTEDAMTREF) END AS CONVCOSTREF," +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF2), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF2, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COSTREF2) WHEN SUM(COSTEDAMTREF2) = 0 THEN 0 ELSE SUM(COSTREF2)*SUM(LINENETREF2)/SUM(COSTEDAMTREF2) END AS CONVCOSTREF2," +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID, SUM(AA.COSTCALCULATED) as COSTCALCULATED," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamt," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMTREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamtref," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMTREF2), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamtref2," +
      "      COUNT(*) AS GROUPCOUNT" +
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
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETAMT," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICED," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF," +
      "      0 AS LINENETREF2, 0 AS QTYINVOICEDREF2, 0 AS WEIGHT_REF2, " +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COST," +
      "                0 AS COSTREF," +
      "                0 AS COSTREF2," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMT, " +
      "                0 AS COSTEDAMTREF, " +
      "                0 AS COSTEDAMTREF2" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
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
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, 0 AS WEIGHT, " +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETREF," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICEDREF," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT_REF," +
      "      0 AS LINENETREF2, 0 AS QTYINVOICEDREF2, 0 AS WEIGHT_REF2," +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID," +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE," +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID," +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                0 AS COST," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COSTREF," +
      "                0 AS COSTREF2," +
      "                0 AS COSTEDAMT," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMTREF," +
      "                0 AS COSTEDAMTREF2" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
      "      UNION ALL SELECT  to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1 ,to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2 ,to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3 ,to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4 ,to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5 ,to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6 ,to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7 ,to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8 ,to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9 ,to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10," +
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, 0 AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETREF2," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICEDREF2," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT_REF2," +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID," +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE," +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID," +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                0 AS COST," +
      "                0 AS COSTREF," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COSTREF2,                " +
      "                0 AS COSTEDAMT," +
      "                0 AS COSTEDAMTREF," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMTREF2                " +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 5=5 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID  IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 4=4";
    strSql = strSql + ((dateFromRef2==null || dateFromRef2.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef2==null || dateToRef2.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
      "      ORDER BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10) AA" +
      "      GROUP BY  NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFromRef2 != null && !(dateFromRef2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef2);
      }
      if (dateToRef2 != null && !(dateToRef2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef2);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weight = UtilSql.getValue(result, "weight");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.cost = UtilSql.getValue(result, "cost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref = UtilSql.getValue(result, "weightref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref = UtilSql.getValue(result, "costref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref2 = UtilSql.getValue(result, "amountref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref2 = UtilSql.getValue(result, "qtyref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref2 = UtilSql.getValue(result, "weightref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref2 = UtilSql.getValue(result, "costref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcost = UtilSql.getValue(result, "convcost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref = UtilSql.getValue(result, "convcostref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref2 = UtilSql.getValue(result, "convamountref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref2 = UtilSql.getValue(result, "convcostref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transdate = UtilSql.getValue(result, "transdate");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costcalculated = UtilSql.getValue(result, "costcalculated");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.org = UtilSql.getValue(result, "org");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partnergroup = UtilSql.getValue(result, "partnergroup");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partner = UtilSql.getValue(result, "partner");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.documentno = UtilSql.getValue(result, "documentno");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.invoicedate = UtilSql.getValue(result, "invoicedate");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.prodcategory = UtilSql.getValue(result, "prodcategory");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.product = UtilSql.getValue(result, "product");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.profit = UtilSql.getValue(result, "profit");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.margin = UtilSql.getValue(result, "margin");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.price = UtilSql.getValue(result, "price");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.contact = UtilSql.getValue(result, "contact");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.salesrep = UtilSql.getValue(result, "salesrep");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.project = UtilSql.getValue(result, "project");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.address = UtilSql.getValue(result, "address");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] select3(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFromRef, String dateToRef, String dateFromRef2, String dateToRef2, String dateFromRef3, String dateToRef3, String orderby)    throws ServletException {
    return select3(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, salesrepId, partnerSalesrepId, cProjectId, producttype, cDocTypeId, strvoid, dateFromRef, dateToRef, dateFromRef2, dateToRef2, dateFromRef3, dateToRef3, orderby, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] select3(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFromRef, String dateToRef, String dateFromRef2, String dateToRef2, String dateFromRef3, String dateToRef3, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST," +
      "      SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF," +
      "      SUM(AMOUNTREF2) AS AMOUNTREF2, SUM(QTYREF2) AS QTYREF2, SUM(WEIGHTREF2) AS WEIGHTREF2, SUM(COSTREF2) AS COSTREF2," +
      "      SUM(AMOUNTREF3) AS AMOUNTREF3, SUM(QTYREF3) AS QTYREF3, SUM(WEIGHTREF3) AS WEIGHTREF3, SUM(COSTREF3) AS COSTREF3," +
      "      SUM(CONVAMOUNT) AS CONVAMOUNT,                          " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOST) WHEN SUM(COSTEDAMT) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) = 0 THEN 0 ELSE SUM(CONVCOST)*SUM(CONVAMOUNT)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) END AS CONVCOST," +
      "      SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOSTREF) WHEN SUM(COSTEDAMTREF) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF END) = 0 THEN 0 ELSE SUM(CONVCOSTREF)*SUM(CONVAMOUNTREF)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF END) END AS CONVCOSTREF," +
      "      SUM(CONVAMOUNTREF2) AS CONVAMOUNTREF2," +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOSTREF2) WHEN SUM(COSTEDAMTREF2) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF2 END) = 0 THEN 0 ELSE SUM(CONVCOSTREF2)*SUM(CONVAMOUNTREF2)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF2 END) END AS CONVCOSTREF2," +
      "      SUM(CONVAMOUNTREF3) AS CONVAMOUNTREF3," +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOSTREF3) WHEN SUM(COSTEDAMTREF3) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF3 END) = 0 THEN 0 ELSE SUM(CONVCOSTREF3)*SUM(CONVAMOUNTREF3)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNTREF3 END) END AS CONVCOSTREF3," +
      "      C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,        " +
      "      C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "      '' AS ID, '' AS NAME, '' AS TRANSCURRENCYID, '' AS TRANSDATE, '' AS TRANSCLIENTID, '' AS TRANSORGID, SUM(ZZ.COSTCALCULATED) AS COSTCALCULATED," +
      "      '' AS ORG, '' AS PARTNERGROUP, '' AS PARTNER, '' AS DOCUMENTNO, '' AS INVOICEDATE, '' AS PRODCATEGORY, '' AS PRODUCT, " +
      "      '' AS PROFIT, '' AS MARGIN, '' AS PRICE, '' AS CONTACT, '' AS SALESREP, '' AS PROJECT, '' AS ADDRESS" +
      "      FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYINVOICED) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST, " +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF, SUM(WEIGHT_REF) AS WEIGHTREF, SUM(COSTREF) AS COSTREF," +
      "      SUM(LINENETREF2) AS AMOUNTREF2, SUM(QTYINVOICEDREF2) AS QTYREF2, SUM(WEIGHT_REF2) AS WEIGHTREF2, SUM(COSTREF2) AS COSTREF2," +
      "      SUM(LINENETREF3) AS AMOUNTREF3, SUM(QTYINVOICEDREF3) AS QTYREF3, SUM(WEIGHT_REF3) AS WEIGHTREF3, SUM(COSTREF3) AS COSTREF3,         " +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COST) WHEN SUM(COSTEDAMT) = 0 THEN 0 ELSE SUM(COST)*SUM(LINENETAMT)/SUM(COSTEDAMT) END AS CONVCOST," +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COSTREF) WHEN SUM(COSTEDAMTREF) = 0 THEN 0 ELSE SUM(COSTREF)*SUM(LINENETREF)/SUM(COSTEDAMTREF) END AS CONVCOSTREF," +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF2), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF2, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COSTREF2) WHEN SUM(COSTEDAMTREF2) = 0 THEN 0 ELSE SUM(COSTREF2)*SUM(LINENETREF2)/SUM(COSTEDAMTREF2) END AS CONVCOSTREF2," +
      "      C_CURRENCY_CONVERT(SUM(LINENETREF3), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNTREF3, " +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COSTREF3) WHEN SUM(COSTEDAMTREF3) = 0 THEN 0 ELSE SUM(COSTREF3)*SUM(LINENETREF3)/SUM(COSTEDAMTREF3) END AS CONVCOSTREF3," +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID, SUM(AA.COSTCALCULATED) as COSTCALCULATED," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamt," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMTREF), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamtref," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMTREF2), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamtref2," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMTREF3), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamtref3," +
      "      COUNT(*) AS GROUPCOUNT" +
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
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETAMT," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICED," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF," +
      "      0 AS LINENETREF2, 0 AS QTYINVOICEDREF2, 0 AS WEIGHT_REF2, " +
      "      0 AS LINENETREF3, 0 AS QTYINVOICEDREF3, 0 AS WEIGHT_REF3, " +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COST," +
      "                0 AS COSTREF," +
      "                0 AS COSTREF2," +
      "                0 AS COSTREF3," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMT, " +
      "                0 AS COSTEDAMTREF, " +
      "                0 AS COSTEDAMTREF2," +
      "                0 AS COSTEDAMTREF3" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
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
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, 0 AS WEIGHT, " +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETREF," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICEDREF," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT_REF," +
      "      0 AS LINENETREF2, 0 AS QTYINVOICEDREF2, 0 AS WEIGHT_REF2," +
      "      0 AS LINENETREF3, 0 AS QTYINVOICEDREF3, 0 AS WEIGHT_REF3," +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID," +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE," +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID," +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                0 AS COST," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COSTREF," +
      "                0 AS COSTREF2," +
      "                0 AS COSTREF3," +
      "                0 AS COSTEDAMT," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMTREF," +
      "                0 AS COSTEDAMTREF2," +
      "                0 AS COSTEDAMTREF3" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
      "      UNION ALL SELECT  to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1 ,to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2 ,to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3 ,to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4 ,to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5 ,to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6 ,to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7 ,to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8 ,to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9 ,to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10," +
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, 0 AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETREF2," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICEDREF2," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT_REF2," +
      "      0 AS LINENETREF3, 0 AS QTYINVOICEDREF3, 0 AS WEIGHT_REF3," +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID," +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE," +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID," +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                0 AS COST," +
      "                0 AS COSTREF," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COSTREF2, " +
      "                0 AS COSTREF3,               " +
      "                0 AS COSTEDAMT," +
      "                0 AS COSTEDAMTREF," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMTREF2," +
      "                0 AS COSTEDAMTREF3                " +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 5=5 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID  IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 4=4";
    strSql = strSql + ((dateFromRef2==null || dateFromRef2.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef2==null || dateToRef2.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
      "      UNION ALL  SELECT  to_char(";
    strSql = strSql + ((nivel1==null || nivel1.equals(""))?"":nivel1);
    strSql = strSql + 
      ") AS NIVEL1  ,to_char(";
    strSql = strSql + ((nivel2==null || nivel2.equals(""))?"":nivel2);
    strSql = strSql + 
      ") AS NIVEL2  ,to_char(";
    strSql = strSql + ((nivel3==null || nivel3.equals(""))?"":nivel3);
    strSql = strSql + 
      ") AS NIVEL3  ,to_char(";
    strSql = strSql + ((nivel4==null || nivel4.equals(""))?"":nivel4);
    strSql = strSql + 
      ") AS NIVEL4  ,to_char(";
    strSql = strSql + ((nivel5==null || nivel5.equals(""))?"":nivel5);
    strSql = strSql + 
      ") AS NIVEL5  ,to_char(";
    strSql = strSql + ((nivel6==null || nivel6.equals(""))?"":nivel6);
    strSql = strSql + 
      ") AS NIVEL6  ,to_char(";
    strSql = strSql + ((nivel7==null || nivel7.equals(""))?"":nivel7);
    strSql = strSql + 
      ") AS NIVEL7  ,to_char(";
    strSql = strSql + ((nivel8==null || nivel8.equals(""))?"":nivel8);
    strSql = strSql + 
      ") AS NIVEL8  ,to_char(";
    strSql = strSql + ((nivel9==null || nivel9.equals(""))?"":nivel9);
    strSql = strSql + 
      ") AS NIVEL9  ,to_char(";
    strSql = strSql + ((nivel10==null || nivel10.equals(""))?"":nivel10);
    strSql = strSql + 
      ") AS NIVEL10," +
      "      0 AS LINENETAMT, 0 AS QTYINVOICED, 0 AS WEIGHT, " +
      "      0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF," +
      "      0 AS LINENETREF2, 0 AS QTYINVOICEDREF2, 0 AS WEIGHT_REF2," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.LINENETAMT *- 1 ELSE c_invoiceline.LINENETAMT END AS LINENETREF3," +
      "      CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICEDREF3," +
      "      C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT_REF3," +
      "      C_UOM.UOMSYMBOL," +
      "      C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID," +
      "      TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE," +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID," +
      "      C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                0 AS COST," +
      "                0 AS COSTREF," +
      "                0 AS COSTREF2," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COSTREF3,                " +
      "                0 AS COSTEDAMT," +
      "                0 AS COSTEDAMTREF," +
      "                0 AS COSTEDAMTREF2," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMTREF3                " +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
      "      AND C_INVOICE.PROCESSED = 'Y'" +
      "      AND 7=7 AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND  C_INVOICE.AD_CLIENT_ID  IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 6=6";
    strSql = strSql + ((dateFromRef3==null || dateFromRef3.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef3==null || dateToRef3.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((cBpartnerGroupId==null || cBpartnerGroupId.equals(""))?"":" AND C_BP_GROUP.C_BP_GROUP_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C_BPARTNER.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":" AND M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":" AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":" AND C_INVOICE.SALESREP_ID = ? ");
    strSql = strSql + ((partnerSalesrepId==null || partnerSalesrepId.equals(""))?"":" AND CB.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((producttype==null || producttype.equals(""))?"":" AND M_PRODUCT.PRODUCTTYPE = ? ");
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
      "      ORDER BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10) AA" +
      "      GROUP BY  NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFromRef2 != null && !(dateFromRef2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef2);
      }
      if (dateToRef2 != null && !(dateToRef2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef2);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFromRef3 != null && !(dateFromRef3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef3);
      }
      if (dateToRef3 != null && !(dateToRef3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef3);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weight = UtilSql.getValue(result, "weight");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.cost = UtilSql.getValue(result, "cost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref = UtilSql.getValue(result, "weightref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref = UtilSql.getValue(result, "costref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref2 = UtilSql.getValue(result, "amountref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref2 = UtilSql.getValue(result, "qtyref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref2 = UtilSql.getValue(result, "weightref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref2 = UtilSql.getValue(result, "costref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref3 = UtilSql.getValue(result, "amountref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref3 = UtilSql.getValue(result, "qtyref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref3 = UtilSql.getValue(result, "weightref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costref3 = UtilSql.getValue(result, "costref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcost = UtilSql.getValue(result, "convcost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref = UtilSql.getValue(result, "convcostref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref2 = UtilSql.getValue(result, "convamountref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref2 = UtilSql.getValue(result, "convcostref2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref3 = UtilSql.getValue(result, "convamountref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref3 = UtilSql.getValue(result, "convcostref3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transdate = UtilSql.getValue(result, "transdate");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costcalculated = UtilSql.getValue(result, "costcalculated");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.org = UtilSql.getValue(result, "org");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partnergroup = UtilSql.getValue(result, "partnergroup");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partner = UtilSql.getValue(result, "partner");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.documentno = UtilSql.getValue(result, "documentno");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.invoicedate = UtilSql.getValue(result, "invoicedate");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.prodcategory = UtilSql.getValue(result, "prodcategory");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.product = UtilSql.getValue(result, "product");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.profit = UtilSql.getValue(result, "profit");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.margin = UtilSql.getValue(result, "margin");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.price = UtilSql.getValue(result, "price");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.contact = UtilSql.getValue(result, "contact");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.salesrep = UtilSql.getValue(result, "salesrep");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.project = UtilSql.getValue(result, "project");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.address = UtilSql.getValue(result, "address");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static String selectCount(ConnectionProvider connectionProvider, String levels, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFrom, String dateTo, String dateFromRef, String dateToRef, String dateFromRef2, String dateToRef2, String dateFromRef3, String dateToRef3)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT( DISTINCT ";
    strSql = strSql + ((levels==null || levels.equals(""))?"":levels);
    strSql = strSql + 
      " ) AS COUNT" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                     left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                     left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID," +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      " AND ((2=2";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + 
      ")OR (3=3";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + 
      ")OR (4=4";
    strSql = strSql + ((dateFromRef2==null || dateFromRef2.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef2==null || dateToRef2.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
    strSql = strSql + 
      ")OR (5=5";
    strSql = strSql + ((dateFromRef3==null || dateFromRef3.equals(""))?"":" AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateToRef3==null || dateToRef3.equals(""))?"":" AND C_INVOICE.DATEINVOICED < to_date(?) ");
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
      if (dateFromRef2 != null && !(dateFromRef2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef2);
      }
      if (dateToRef2 != null && !(dateToRef2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef2);
      }
      if (dateFromRef3 != null && !(dateFromRef3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef3);
      }
      if (dateToRef3 != null && !(dateToRef3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef3);
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

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String orderby)    throws ServletException {
    return selectNoComparative(connectionProvider, cCurrencyConv, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9, nivel10, adOrgId, adUserClient, dateFrom, dateTo, cBpartnerGroupId, cBpartnerId, mProductCategoryId, mProductId, salesrepId, partnerSalesrepId, cProjectId, producttype, cDocTypeId, strvoid, orderby, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectNoComparative(ConnectionProvider connectionProvider, String cCurrencyConv, String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nivel6, String nivel7, String nivel8, String nivel9, String nivel10, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String orderby, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10," +
      "        SUM(AMOUNT) AS AMOUNT, SUM(QTY) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST, " +
      "        SUM(AMOUNTREF) AS AMOUNTREF, SUM(QTYREF) AS QTYREF, SUM(WEIGHTREF) AS WEIGHTREF," +
      "        SUM(CONVAMOUNT) AS CONVAMOUNT,  " +
      "        CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(CONVCOST) WHEN SUM(COSTEDAMT) = 0 THEN 0 WHEN SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) = 0 THEN 0 ELSE SUM(CONVCOST)*SUM(CONVAMOUNT)/SUM(CASE WHEN GROUPCOUNT = COSTCALCULATED THEN 0 ELSE CONVAMOUNT END) END AS CONVCOST," +
      "        SUM(CONVAMOUNTREF) AS CONVAMOUNTREF," +
      "        SUM(CONVCOSTREF) AS CONVCOSTREF,           " +
      "        C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM,                " +
      "        C_CURRENCY_ISOSYM(?) AS CONVISOSYM, SUM(ZZ.COSTCALCULATED) AS COSTCALCULATED" +
      "    FROM (SELECT NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, " +
      "      SUM(LINENETAMT) AS AMOUNT, SUM(QTYINVOICED) AS QTY, SUM(WEIGHT) AS WEIGHT, SUM(COST) AS COST," +
      "      SUM(LINENETREF) AS AMOUNTREF, SUM(QTYINVOICEDREF) AS QTYREF, SUM(WEIGHT_REF) AS WEIGHTREF," +
      "      C_CURRENCY_CONVERT(SUM(LINENETAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS CONVAMOUNT," +
      "      CASE WHEN SUM(COSTCALCULATED) = 0 THEN SUM(COST) WHEN SUM(COSTEDAMT) = 0 THEN 0 ELSE SUM(COST)*SUM(LINENETAMT)/SUM(COSTEDAMT) END AS CONVCOST," +
      "          0 AS CONVAMOUNTREF," +
      "          0 AS CONVCOSTREF," +
      "      TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID, SUM(AA.COSTCALCULATED) as COSTCALCULATED," +
      "      C_CURRENCY_CONVERT(SUM(COSTEDAMT), TRCURRENCYID, ?, TO_DATE(TRDATE), NULL, TRCLIENTID, TRORGID) AS costedamt," +
      "      COUNT(*) AS GROUPCOUNT" +
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
      "                CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END AS LINENETAMT," +
      "                CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTYINVOICED," +
      "                C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT," +
      "                0 AS LINENETREF, 0 AS QTYINVOICEDREF, 0 AS WEIGHT_REF, C_UOM.UOMSYMBOL," +
      "                C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID,  " +
      "                TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE,      " +
      "                C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID,      " +
      "                C_INVOICELINE.AD_ORG_ID AS TRORGID," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 1 ELSE 0" +
      "                END AS COSTCALCULATED," +
      "                CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)" +
      "                     ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END))" +
      "                END AS COST," +
      "                CASE WHEN sum(trxcost.cost) is null AND m_product.isstocked = 'Y' AND m_product.producttype = 'I' THEN 0" +
      "                     ELSE CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END" +
      "                END AS COSTEDAMT" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "      WHERE C_INVOICE.ISSOTRX = 'Y'" +
      "        AND C_INVOICE.PROCESSED = 'Y'" +
      "        AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "      GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, AD_USER.AD_USER_ID, C_PROJECT.NAME, AD_USER.FIRSTNAME, AD_USER.LASTNAME, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE" +
      "      ORDER BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10) AA" +
      "      GROUP BY  NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10, TRCURRENCYID, TRDATE, TRCLIENTID, TRORGID) ZZ" +
      "      GROUP BY NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10";
    strSql = strSql + ((orderby==null || orderby.equals(""))?"":orderby);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel1 = UtilSql.getValue(result, "nivel1");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel2 = UtilSql.getValue(result, "nivel2");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel3 = UtilSql.getValue(result, "nivel3");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel4 = UtilSql.getValue(result, "nivel4");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel5 = UtilSql.getValue(result, "nivel5");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel6 = UtilSql.getValue(result, "nivel6");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel7 = UtilSql.getValue(result, "nivel7");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel8 = UtilSql.getValue(result, "nivel8");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel9 = UtilSql.getValue(result, "nivel9");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.nivel10 = UtilSql.getValue(result, "nivel10");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weight = UtilSql.getValue(result, "weight");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.cost = UtilSql.getValue(result, "cost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amountref = UtilSql.getValue(result, "amountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qtyref = UtilSql.getValue(result, "qtyref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weightref = UtilSql.getValue(result, "weightref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamount = UtilSql.getValue(result, "convamount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcost = UtilSql.getValue(result, "convcost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convamountref = UtilSql.getValue(result, "convamountref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convcostref = UtilSql.getValue(result, "convcostref");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.costcalculated = UtilSql.getValue(result, "costcalculated");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static String selectNoComparativeCount(ConnectionProvider connectionProvider, String levels, String adOrgId, String adUserClient, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid, String dateFrom, String dateTo)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT( DISTINCT ";
    strSql = strSql + ((levels==null || levels.equals(""))?"":levels);
    strSql = strSql + 
      " ) AS COUNT" +
      "      FROM C_INVOICE left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                     left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                     left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID," +
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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

  public static String selectProject(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_PROJECT.NAME" +
      "      FROM C_PROJECT" +
      "      WHERE C_PROJECT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown)    throws ServletException {
    return selectNotShown(connectionProvider, notShown, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectNotShown(ConnectionProvider connectionProvider, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectShown(ConnectionProvider connectionProvider, String shown)    throws ServletException {
    return selectShown(connectionProvider, shown, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectShown(ConnectionProvider connectionProvider, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, NAME " +
      "              FROM AD_REF_LIST " +
      "             WHERE AD_REFERENCE_ID = '800087' " +
      "             AND AD_REF_LIST.VALUE IN ('1', '2', '3', '4', '5', '6', '8', '9', '10', '11')" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown)    throws ServletException {
    return selectNotShownTrl(connectionProvider, lang, notShown, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectNotShownTrl(ConnectionProvider connectionProvider, String lang, String notShown, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown)    throws ServletException {
    return selectShownTrl(connectionProvider, lang, shown, 0, 0);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData[] selectShownTrl(ConnectionProvider connectionProvider, String lang, String shown, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT VALUE AS ID, T.NAME " +
      "              FROM AD_REF_LIST_trl T," +
      "                   AD_REF_LIST     L" +
      "             WHERE l.AD_REFERENCE_ID = '800087'" +
      "               AND l.AD_REF_LIST_ID  = t.AD_REF_LIST_ID" +
      "               AND L.VALUE IN ('1', '2', '3', '4', '5', '6', '8', '9', '10', '11')" +
      "               AND t.AD_LANGUAGE = ?" +
      "             ORDER BY TO_NUMBER(VALUE)) AA" +
      "      WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":" AND ID IN" + shown);

    ResultSet result;
    Vector<ReportInvoiceCustomerDimensionalAnalysesJRData> vector = new Vector<ReportInvoiceCustomerDimensionalAnalysesJRData>(0);
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
        ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();
        objectReportInvoiceCustomerDimensionalAnalysesJRData.id = UtilSql.getValue(result, "id");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.name = UtilSql.getValue(result, "name");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceCustomerDimensionalAnalysesJRData);
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
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData[] = new ReportInvoiceCustomerDimensionalAnalysesJRData[vector.size()];
    vector.copyInto(objectReportInvoiceCustomerDimensionalAnalysesJRData);
    return(objectReportInvoiceCustomerDimensionalAnalysesJRData);
  }

  public static ReportInvoiceCustomerDimensionalAnalysesJRData selectXLS(ConnectionProvider connectionProvider, String cCurrencyConv, String language, String adOrgId, String adUserClient, String dateFrom, String dateTo, String cBpartnerGroupId, String cBpartnerId, String mProductCategoryId, String mProductId, String salesrepId, String partnerSalesrepId, String cProjectId, String producttype, String cDocTypeId, String strvoid)    throws ServletException {
    ReportInvoiceCustomerDimensionalAnalysesJRData instance = new ReportInvoiceCustomerDimensionalAnalysesJRData();
    instance.scrollableGetter = "selectXLS";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "      SELECT ORG, DOCTYPENAME, PARTNERGROUP, PARTNER, DOCUMENTNO, INVOICEDATE, PRODCATEGORY, PRODUCT, SEARCHKEY, UNITPRICE, " +
      "        AMOUNT, COST, (AMOUNT - COST) AS PROFIT, CASE WHEN AMOUNT <> 0 THEN ROUND((100 * (AMOUNT - COST) / AMOUNT), 2) * SIGN(AMOUNT - COST) ELSE 0 END AS MARGIN, " +
      "        WEIGHT, QTY, CONTACT, SALESREP, PROJECT, ADDRESS" +
      "        FROM (" +
      "          SELECT AD_ORG.NAME AS ORG, " +
      "            COALESCE(C_DOCTYPE_TRL.NAME, C_DOCTYPE.NAME) AS DOCTYPENAME," +
      "            C_BP_GROUP.NAME AS PARTNERGROUP, " +
      "            C_BPARTNER.NAME AS PARTNER, " +
      "            C_INVOICE.DOCUMENTNO AS DOCUMENTNO, " +
      "            TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS INVOICEDATE, " +
      "            M_PRODUCT_CATEGORY.NAME AS PRODCATEGORY, " +
      "            M_PRODUCT.NAME AS PRODUCT, " +
      "            M_PRODUCT.VALUE AS SEARCHKEY, " +
      "            C_CURRENCY_CONVERT(CASE WHEN C_INVOICELINE.QTYINVOICED = 0 THEN 0 ELSE C_INVOICELINE.LINENETAMT/C_INVOICELINE.QTYINVOICED END, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICE.AD_CLIENT_ID, C_INVOICE.AD_ORG_ID) AS UNITPRICE," +
      "            CASE WHEN C_DOCTYPE.DOCBASETYPE = 'ARC' THEN C_CURRENCY_CONVERT(C_INVOICELINE.LINENETAMT*-1, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICE.AD_CLIENT_ID, C_INVOICE.AD_ORG_ID) ELSE C_CURRENCY_CONVERT(C_INVOICELINE.LINENETAMT, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICE.AD_CLIENT_ID, C_INVOICE.AD_ORG_ID) END AS AMOUNT," +
      "            CASE WHEN (M_PRODUCT.ISSTOCKED='Y' AND M_PRODUCT.PRODUCTTYPE='I') THEN (CASE WHEN trx.movementqty = 0 THEN 0 ELSE COALESCE(C_CURRENCY_CONVERT_PRECISION (ROUND(sum(trxcost.cost)/abs(trx.movementqty)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END), C_GET_CURRENCY_PRECISION(trxcost.c_currency_id, 'C')), trxcost.c_currency_id,?,trx.movementdate,NULL,trx.ad_client_id,trx.ad_org_id,'C'), 0) END)    ELSE (COALESCE(M_GET_NO_TRX_PRODUCT_COST(M_PRODUCT.M_PRODUCT_ID, C_INVOICE.DATEINVOICED, 'STA', ad_org.ad_org_id, null, C_INVOICE.C_CURRENCY_ID), 0)*(CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END)) END AS COST," +
      "            C_INVOICELINE.QTYINVOICED*M_PRODUCT.WEIGHT AS WEIGHT," +
      "            CASE WHEN c_doctype.docbasetype = 'ARC' THEN c_invoiceline.qtyinvoiced *- 1 ELSE c_invoiceline.qtyinvoiced END AS QTY," +
      "            (SELECT U.NAME FROM AD_USER U WHERE U.AD_USER_ID = C_INVOICE.AD_USER_ID) AS CONTACT," +
      "            (SELECT SR.NAME FROM AD_USER SR WHERE SR.AD_USER_ID = C_INVOICE.SALESREP_ID) AS SALESREP," +
      "            (SELECT P.NAME FROM C_PROJECT P WHERE P.C_PROJECT_ID = C_INVOICE.C_PROJECT_ID) AS PROJECT," +
      "            (SELECT PL.NAME FROM C_BPARTNER_LOCATION PL WHERE PL.C_BPARTNER_LOCATION_ID = M_INOUT.C_BPARTNER_LOCATION_ID) AS ADDRESS" +
      "            FROM C_INVOICELINE " +
      "                join C_INVOICE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "                join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                join C_BP_GROUP on C_BPARTNER.C_BP_GROUP_ID = C_BP_GROUP.C_BP_GROUP_ID" +
      "                join AD_ORG on C_INVOICE.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "                left join C_BPARTNER CB on C_BPARTNER.SALESREP_ID = CB.C_BPARTNER_ID" +
      "                left join AD_USER on C_INVOICE.SALESREP_ID = AD_USER.AD_USER_ID" +
      "                left join C_PROJECT on C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID" +
      "                left join C_DOCTYPE_TRL on C_DOCTYPE.C_DOCTYPE_ID = C_DOCTYPE_TRL.C_DOCTYPE_ID AND C_DOCTYPE_TRL.AD_LANGUAGE=?" +
      "                left join M_PRODUCT on C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                left join C_UOM on C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "                left join M_PRODUCT_CATEGORY on M_PRODUCT.M_PRODUCT_CATEGORY_ID = M_PRODUCT_CATEGORY.M_PRODUCT_CATEGORY_ID" +
      "                left join M_INOUTLINE on C_INVOICELINE.M_INOUTLINE_ID = M_INOUTLINE.M_INOUTLINE_ID" +
      "                left join M_INOUT ON M_INOUTLINE.M_INOUT_ID = M_INOUT.M_INOUT_ID" +
      "                left join m_transaction trx ON trx.m_inoutline_id = m_inoutline.m_inoutline_id" +
      "                left join m_transaction_cost trxcost ON trx.m_transaction_id = trxcost.m_transaction_id" +
      "          WHERE C_INVOICE.ISSOTRX = 'Y'" +
      "            AND C_INVOICE.PROCESSED = 'Y'" +
      "            AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "            AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "            AND 1=1";
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
    strSql = strSql + ((cDocTypeId==null || cDocTypeId.equals(""))?"":" AND C_DOCTYPE.C_DOCTYPE_ID IN" + cDocTypeId);
    strSql = strSql + ((strvoid==null || strvoid.equals(""))?"":" AND C_INVOICE.DOCSTATUS <> ? ");
    strSql = strSql + 
      "          AND 1=1" +
      "          GROUP BY trxcost.m_transaction_id, C_INVOICELINE.C_INVOICELINE_ID, C_DOCTYPE_TRL.NAME, C_DOCTYPE.NAME, C_BPARTNER.NAME, C_BPARTNER.C_BPARTNER_ID, M_PRODUCT_CATEGORY.NAME, M_PRODUCT.NAME, M_PRODUCT.VALUE, C_INVOICE.DOCUMENTNO, AD_ORG.NAME, C_INVOICE.AD_USER_ID, C_INVOICE.SALESREP_ID, C_INVOICE.C_PROJECT_ID, C_BP_GROUP.NAME, M_INOUT.C_BPARTNER_LOCATION_ID, C_INVOICE.AD_CLIENT_ID, C_INVOICE.AD_ORG_ID, C_INVOICELINE.LINENETAMT, C_INVOICELINE.QTYINVOICED, C_UOM.UOMSYMBOL, c_doctype.docbasetype, ad_org.ad_org_id, C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, trx.movementqty, trx.movementdate, trx.ad_client_id, trx.ad_org_id, trxcost.c_currency_id, M_PRODUCT.WEIGHT, M_PRODUCT.M_PRODUCT_ID, M_PRODUCT.ISSTOCKED, M_PRODUCT.PRODUCTTYPE) AA" +
      "          ORDER BY ORG, DOCUMENTNO, INVOICEDATE";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
      if (cDocTypeId != null && !(cDocTypeId.equals(""))) {
        }
      if (strvoid != null && !(strvoid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, strvoid);
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

  private ReportInvoiceCustomerDimensionalAnalysesJRData getselectXLS() throws SQLException {
    ReportInvoiceCustomerDimensionalAnalysesJRData objectReportInvoiceCustomerDimensionalAnalysesJRData = new ReportInvoiceCustomerDimensionalAnalysesJRData();

        objectReportInvoiceCustomerDimensionalAnalysesJRData.org = UtilSql.getValue(result, "org");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.doctypename = UtilSql.getValue(result, "doctypename");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partnergroup = UtilSql.getValue(result, "partnergroup");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.partner = UtilSql.getValue(result, "partner");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.documentno = UtilSql.getValue(result, "documentno");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.invoicedate = UtilSql.getDateValue(result, "invoicedate", "dd-MM-yyyy");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.prodcategory = UtilSql.getValue(result, "prodcategory");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.product = UtilSql.getValue(result, "product");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.searchkey = UtilSql.getValue(result, "searchkey");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.unitprice = UtilSql.getValue(result, "unitprice");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.amount = UtilSql.getValue(result, "amount");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.cost = UtilSql.getValue(result, "cost");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.profit = UtilSql.getValue(result, "profit");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.margin = UtilSql.getValue(result, "margin");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.weight = UtilSql.getValue(result, "weight");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.qty = UtilSql.getValue(result, "qty");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.contact = UtilSql.getValue(result, "contact");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.salesrep = UtilSql.getValue(result, "salesrep");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.project = UtilSql.getValue(result, "project");
        objectReportInvoiceCustomerDimensionalAnalysesJRData.address = UtilSql.getValue(result, "address");
      return objectReportInvoiceCustomerDimensionalAnalysesJRData;
  }
}
