//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CopyFromInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromInvoiceData.class);
  private String InitRecordNumber="0";
  public String cUomId;
  public String qtyinvoiced;
  public String cInvoicelineId;
  public String pricelist;
  public String pricelimit;
  public String priceactual;
  public String linenetamt;
  public String adOrgId;
  public String adClientId;
  public String cBpartnerLocationId;
  public String dateinvoiced;
  public String cProjectId;
  public String productId;
  public String cBpartnerId;
  public String cCurrencyId;
  public String mPricelistId;
  public String line;
  public String issotrx;
  public String taxdate;
  public String pricestd;
  public String validfrom;
  public String stdprecision;
  public String priceprecision;
  public String enforcepricelimit;
  public String accountId;
  public String cAum;
  public String aumqty;
  public String mProductUomId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("product_id") || fieldName.equals("productId"))
      return productId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("taxdate"))
      return taxdate;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("enforcepricelimit"))
      return enforcepricelimit;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("c_aum") || fieldName.equals("cAum"))
      return cAum;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromInvoiceData[] select(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String userclient, String userorg)    throws ServletException {
    return select(conn, connectionProvider, cInvoiceId, userclient, userorg, 0, 0);
  }

  public static CopyFromInvoiceData[] select(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String userclient, String userorg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT" +
      "        C_INVOICELINE.C_UOM_ID, C_INVOICELINE.QTYINVOICED, C_INVOICELINE.C_InvoiceLine_ID,C_INVOICELINE.PRICELIST, " +
      "        C_INVOICELINE.PRICELIMIT, C_INVOICELINE.PRICEACTUAL, C_INVOICELINE.LINENETAMT," +
      "        '' AS AD_ORG_ID, '' AS AD_CLIENT_ID, " +
      "        '' AS C_BPartner_Location_ID, " +
      "        '' AS DateInvoiced, '' AS C_Project_ID," +
      "        C_INVOICELINE.M_PRODUCT_ID AS PRODUCT_ID, " +
      "        '' AS C_BPARTNER_ID, '' AS C_CURRENCY_ID," +
      "        '' AS M_PRICELIST_ID, '' AS LINE," +
      "        '' AS ISSOTRX, '' AS TAXDATE," +
      "        '' AS PRICESTD, '' AS VALIDFROM," +
      "        '' AS StdPrecision, '' AS PricePrecision, '' AS EnforcePriceLimit," +
      "        C_INVOICELINE.ACCOUNT_ID AS ACCOUNT_ID," +
      "        C_AUM, AUMQTY," +
      "        M_PRODUCT_UOM_ID" +
      "        FROM C_INVOICELINE " +
      "        LEFT JOIN C_INVOICE ON C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "        LEFT OUTER JOIN C_INVOICE_DISCOUNT ON C_INVOICELINE.C_INVOICE_DISCOUNT_ID = C_INVOICE_DISCOUNT.C_INVOICE_DISCOUNT_ID" +
      "        LEFT OUTER JOIN C_BPARTNER_DISCOUNT ON C_INVOICE_DISCOUNT.C_DISCOUNT_ID = C_BPARTNER_DISCOUNT.C_DISCOUNT_ID AND C_BPARTNER_DISCOUNT.C_BPARTNER_ID = C_INVOICE.C_BPARTNER_ID" +
      "        WHERE C_INVOICELINE.C_Invoice_ID = ?" +
      "        AND C_INVOICELINE.AD_CLIENT_ID IN (";
    strSql = strSql + ((userclient==null || userclient.equals(""))?"":userclient);
    strSql = strSql + 
      ")" +
      "        AND C_INVOICELINE.AD_ORG_ID IN (";
    strSql = strSql + ((userorg==null || userorg.equals(""))?"":userorg);
    strSql = strSql + 
      ")" +
      "        AND C_INVOICELINE.ISACTIVE = 'Y'" +
      "        AND (APPLYINORDER IS NULL OR APPLYINORDER <> 'N')" +
      "        AND C_INVOICELINE.C_INVOICE_DISCOUNT_ID IS NULL" +
      "        ORDER BY C_INVOICELINE.LINE";

    ResultSet result;
    Vector<CopyFromInvoiceData> vector = new Vector<CopyFromInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      if (userclient != null && !(userclient.equals(""))) {
        }
      if (userorg != null && !(userorg.equals(""))) {
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
        CopyFromInvoiceData objectCopyFromInvoiceData = new CopyFromInvoiceData();
        objectCopyFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCopyFromInvoiceData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectCopyFromInvoiceData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCopyFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCopyFromInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCopyFromInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCopyFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCopyFromInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCopyFromInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCopyFromInvoiceData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectCopyFromInvoiceData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectCopyFromInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCopyFromInvoiceData.productId = UtilSql.getValue(result, "product_id");
        objectCopyFromInvoiceData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCopyFromInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromInvoiceData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectCopyFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCopyFromInvoiceData.issotrx = UtilSql.getValue(result, "issotrx");
        objectCopyFromInvoiceData.taxdate = UtilSql.getValue(result, "taxdate");
        objectCopyFromInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCopyFromInvoiceData.validfrom = UtilSql.getValue(result, "validfrom");
        objectCopyFromInvoiceData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCopyFromInvoiceData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectCopyFromInvoiceData.enforcepricelimit = UtilSql.getValue(result, "enforcepricelimit");
        objectCopyFromInvoiceData.accountId = UtilSql.getValue(result, "account_id");
        objectCopyFromInvoiceData.cAum = UtilSql.getValue(result, "c_aum");
        objectCopyFromInvoiceData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCopyFromInvoiceData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCopyFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromInvoiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CopyFromInvoiceData objectCopyFromInvoiceData[] = new CopyFromInvoiceData[vector.size()];
    vector.copyInto(objectCopyFromInvoiceData);
    return(objectCopyFromInvoiceData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cNewInvoiceId, String cInvoiceId, String adClientId, String adOrgId, String adUserId, String qtyInvoiced, String priceList, String priceActual, String priceLimit, String lineNetAmount, String cTaxId, String priceGross, String amtGross, String priceListGros, String priceStdGross, String cAum, String aumQty, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICELINE (C_InvoiceLine_ID, C_Invoice_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, " +
      "            CREATED, CREATEDBY, UPDATED, UPDATEDBY, LINE, DESCRIPTION, M_PRODUCT_ID, " +
      "            QTYINVOICED, PRICELIST, PRICEACTUAL, PRICELIMIT, LINENETAMT, C_CHARGE_ID, CHARGEAMT, C_UOM_ID, C_TAX_ID, " +
      "            S_RESOURCEASSIGNMENT_ID, TAXAMT, M_ATTRIBUTESETINSTANCE_ID, ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID, " +
      "            PRICESTD, ACCOUNT_ID,FINANCIAL_INVOICE_LINE," +
      "            gross_unit_price, line_gross_amount, grosspricelist, grosspricestd," +
      "            isdeferred, defplantype, periodnumber, c_period_id," +
      "            C_PROJECT_ID, A_ASSET_ID, C_COSTCENTER_ID, USER1_ID, USER2_ID," +
      "            C_AUM, AUMQTY" +
      "        )" +
      "        SELECT ?, ?, ?, ?, 'Y', now(), ?, now(), ?," +
      "        (SELECT COALESCE(MAX(LINE),0)+10 FROM C_InvoiceLine WHERE C_Invoice_ID = ?), l.DESCRIPTION, l.M_PRODUCT_ID," +
      "        TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), l.C_CHARGE_ID, l.CHARGEAMT, l.C_UOM_ID, ?," +
      "        l.S_RESOURCEASSIGNMENT_ID, l.TAXAMT, l.M_ATTRIBUTESETINSTANCE_ID, l.ISDESCRIPTION, l.QUANTITYORDER, l.M_PRODUCT_UOM_ID," +
      "        l.PRICESTD, l.ACCOUNT_ID,l.FINANCIAL_INVOICE_LINE," +
      "        TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?)," +
      "        l.isdeferred, l.defplantype, l.periodnumber, l.c_period_id," +
      "        COALESCE(l.C_Project_ID, inv.C_Project_ID) AS C_Project_ID," +
      "        COALESCE(l.A_Asset_ID, inv.A_Asset_ID) AS A_Asset_ID," +
      "        COALESCE(l.C_Costcenter_ID, inv.C_Costcenter_ID) AS C_Costcenter_ID," +
      "        COALESCE(l.User1_ID, inv.User1_ID) AS User1_ID," +
      "        COALESCE(l.User2_ID, inv.User2_ID) AS User2_ID," +
      "        ?, TO_NUMBER(?)" +
      "        FROM C_INVOICELINE l, C_Invoice inv" +
      "        WHERE C_INVOICELINE_ID = ? " +
      "        AND l.C_Invoice_ID = inv.C_Invoice_ID";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cNewInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyInvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceActual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceLimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineNetAmount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceGross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtGross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListGros);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceStdGross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aumQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertAcctDimension(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adUserId, String cNewInvoicelineId, String cOldInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICELINE_ACCTDIMENSION(C_INVOICELINE_ACCTDIMENSION_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "        ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_INVOICELINE_ID, AMT, C_PROJECT_ID, C_CAMPAIGN_ID," +
      "        USER1_ID, USER2_ID, C_ACTIVITY_ID, C_COSTCENTER_ID, C_BPARTNER_ID, M_PRODUCT_ID)" +
      "        SELECT GET_UUID(), ?, AD_ORG_ID, 'Y', NOW(), ?, NOW(), ?, ?, AMT, C_PROJECT_ID, C_CAMPAIGN_ID, USER1_ID, USER2_ID, " +
      "        C_ACTIVITY_ID, C_COSTCENTER_ID, C_BPARTNER_ID, M_PRODUCT_ID" +
      "        FROM C_INVOICELINE_ACCTDIMENSION WHERE C_INVOICELINE_ID = ? AND ISACTIVE='Y'";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cNewInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOldInvoicelineId);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static CopyFromInvoiceData[] selectInvoice(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return selectInvoice(conn, connectionProvider, cInvoiceId, 0, 0);
  }

  public static CopyFromInvoiceData[] selectInvoice(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT I.AD_ORG_ID,I.AD_CLIENT_ID,I.C_BPartner_Location_ID,I.DateInvoiced,I.C_Project_ID," +
      "         I.C_Bpartner_ID,I.C_Currency_ID,I.M_Pricelist_ID,COALESCE(MAX(IL.Line),0) AS LINE,I.IsSOTrx AS ISSOTRX, I.TaxDate," +
      "         IL.PRICELIST, IL.PRICEACTUAL, IL.PRICELIMIT, IL.LINENETAMT," +
      "         C_AUM, AUMQTY" +
      "         FROM C_Invoice I LEFT JOIN C_INVOICELINE IL ON I.C_INVOICE_ID = IL.C_INVOICE_ID " +
      "        WHERE I.C_Invoice_ID = ? " +
      "        AND I.ISACTIVE = 'Y'" +
      "        GROUP BY I.AD_ORG_ID,I.AD_CLIENT_ID,I.C_BPartner_Location_ID,I.DateInvoiced,I.C_Project_ID," +
      "         I.C_Bpartner_ID,I.C_Currency_ID,I.M_Pricelist_ID,I.IsSOTrx, I.TaxDate,IL.PRICELIST, IL.PRICEACTUAL, IL.PRICELIMIT, IL.LINENETAMT," +
      "         C_AUM, AUMQTY";

    ResultSet result;
    Vector<CopyFromInvoiceData> vector = new Vector<CopyFromInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        CopyFromInvoiceData objectCopyFromInvoiceData = new CopyFromInvoiceData();
        objectCopyFromInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCopyFromInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCopyFromInvoiceData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectCopyFromInvoiceData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectCopyFromInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCopyFromInvoiceData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCopyFromInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromInvoiceData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectCopyFromInvoiceData.line = UtilSql.getValue(result, "line");
        objectCopyFromInvoiceData.issotrx = UtilSql.getValue(result, "issotrx");
        objectCopyFromInvoiceData.taxdate = UtilSql.getDateValue(result, "taxdate", "dd-MM-yyyy");
        objectCopyFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCopyFromInvoiceData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCopyFromInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCopyFromInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCopyFromInvoiceData.cAum = UtilSql.getValue(result, "c_aum");
        objectCopyFromInvoiceData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCopyFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromInvoiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CopyFromInvoiceData objectCopyFromInvoiceData[] = new CopyFromInvoiceData[vector.size()];
    vector.copyInto(objectCopyFromInvoiceData);
    return(objectCopyFromInvoiceData);
  }

  public static CopyFromInvoiceData[] selectPriceForProduct(ConnectionProvider connectionProvider, String MProductID, String MPriceListID)    throws ServletException {
    return selectPriceForProduct(connectionProvider, MProductID, MPriceListID, 0, 0);
  }

  public static CopyFromInvoiceData[] selectPriceForProduct(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_BOM_PriceStd(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceStd," +
      "        M_BOM_PriceList(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceList," +
      "        M_BOM_PriceLimit(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceLimit," +
      "        p.C_UOM_ID,pv.ValidFrom,pl.C_Currency_ID " +
      "        FROM M_Product p, M_ProductPrice pp, M_Pricelist pl, M_PriceList_Version pv " +
      "        WHERE p.M_Product_ID=pp.M_Product_ID" +
      "        AND pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID" +
      "        AND pv.M_PriceList_ID=pl.M_PriceList_ID" +
      "        AND pv.IsActive='Y'" +
      "        AND p.M_Product_ID = ?" +
      "       AND pl.M_PriceList_ID = ?" +
      "        ORDER BY pv.ValidFrom DESC";

    ResultSet result;
    Vector<CopyFromInvoiceData> vector = new Vector<CopyFromInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MPriceListID);

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
        CopyFromInvoiceData objectCopyFromInvoiceData = new CopyFromInvoiceData();
        objectCopyFromInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCopyFromInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCopyFromInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCopyFromInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCopyFromInvoiceData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectCopyFromInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromInvoiceData);
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
    CopyFromInvoiceData objectCopyFromInvoiceData[] = new CopyFromInvoiceData[vector.size()];
    vector.copyInto(objectCopyFromInvoiceData);
    return(objectCopyFromInvoiceData);
  }

  public static String getOffersStdPrice(ConnectionProvider connectionProvider, String cBpartnerId, String pricestd, String mProductId, String dateinvoiced, String qty, String pricelist, String invoiceid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ROUND(M_GET_OFFERS_STD_PRICE(?,TO_NUMBER(?),?,TO_DATE(?), TO_NUMBER(?), ?)," +
      "                    (SELECT PRICEPRECISION " +
      "                       FROM C_CURRENCY C," +
      "                            C_INVOICE    I " +
      "                      WHERE C.C_CURRENCY_ID = I.C_CURRENCY_ID" +
      "                        AND I.C_INVOICE_ID = ?)) as TOTAL FROM DUAL";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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
}
