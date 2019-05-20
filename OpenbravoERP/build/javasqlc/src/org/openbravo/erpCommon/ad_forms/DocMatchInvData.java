//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocMatchInvData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocMatchInvData.class);
  private String InitRecordNumber="0";
  public String mMatchinvId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String mInoutlineId;
  public String cInvoicelineId;
  public String mProductId;
  public String datetrx;
  public String qty;
  public String processing;
  public String processed;
  public String posted;
  public String dateacct;
  public String datedoc;
  public String cBpartnerId;
  public String linenetamt;
  public String cCurrencyId;
  public String stdprecision;
  public String orderacctdate;
  public String invoicestatus;
  public String inoutstatus;
  public String movementqty;
  public String qtyinvoiced;
  public String cOrderlineId;
  public String line;
  public String description;
  public String mCGlitemId;
  public String pricelist;
  public String priceactual;
  public String pricelimit;
  public String cChargeId;
  public String chargeamt;
  public String cUomId;
  public String cTaxId;
  public String sResourceassignmentId;
  public String taxamt;
  public String mAttributesetinstanceId;
  public String isdescription;
  public String quantityorder;
  public String mProductUomId;
  public String cCampaignId;
  public String cProjectId;
  public String user1Id;
  public String user2Id;
  public String glitemCreditAcct;
  public String glitemDebitAcct;
  public String inoutproject;
  public String cInvoiceId;
  public String inoutuser1;
  public String inoutuser2;
  public String inoutcampaing;
  public String cActivityId;
  public String inoutactivity;
  public String cCostcenterId;
  public String inoutcoscenter;
  public String issotrx;
  public String aAssetId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_matchinv_id") || fieldName.equals("mMatchinvId"))
      return mMatchinvId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("datetrx"))
      return datetrx;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("orderacctdate"))
      return orderacctdate;
    else if (fieldName.equalsIgnoreCase("invoicestatus"))
      return invoicestatus;
    else if (fieldName.equalsIgnoreCase("inoutstatus"))
      return inoutstatus;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_c_glitem_id") || fieldName.equals("mCGlitemId"))
      return mCGlitemId;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("isdescription"))
      return isdescription;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("glitem_credit_acct") || fieldName.equals("glitemCreditAcct"))
      return glitemCreditAcct;
    else if (fieldName.equalsIgnoreCase("glitem_debit_acct") || fieldName.equals("glitemDebitAcct"))
      return glitemDebitAcct;
    else if (fieldName.equalsIgnoreCase("inoutproject"))
      return inoutproject;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("inoutuser1"))
      return inoutuser1;
    else if (fieldName.equalsIgnoreCase("inoutuser2"))
      return inoutuser2;
    else if (fieldName.equalsIgnoreCase("inoutcampaing"))
      return inoutcampaing;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("inoutactivity"))
      return inoutactivity;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("inoutcoscenter"))
      return inoutcoscenter;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocMatchInvData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DocMatchInvData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_MATCHINV_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID, '' AS ISACTIVE," +
      "          '' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS M_INOUTLINE_ID," +
      "          '' AS C_INVOICELINE_ID, '' AS M_PRODUCT_ID, '' AS DATETRX, '' AS QTY, '' AS PROCESSING," +
      "          '' AS PROCESSED, '' AS POSTED, '' AS DATEACCT, '' AS DATEDOC, '' AS C_BPARTNER_ID," +
      "          '' AS LINENETAMT, '' AS C_CURRENCY_ID, '' AS stdprecision, '' as orderAcctDate," +
      "          '' AS INVOICESTATUS, '' AS INOUTSTATUS, '' AS MOVEMENTQTY, '' AS QTYINVOICED," +
      "          '' AS C_ORDERLINE_ID, '' AS LINE, '' AS DESCRIPTION," +
      "          '' AS M_C_GLITEM_ID, '' AS PRICELIST, '' AS PRICEACTUAL, '' AS PRICELIMIT," +
      "          '' AS C_CHARGE_ID, '' AS CHARGEAMT, '' AS C_UOM_ID, '' as C_TAX_ID," +
      "          '' AS S_RESOURCEASSIGNMENT_ID, '' AS TAXAMT, '' AS M_ATTRIBUTESETINSTANCE_ID," +
      "          '' AS ISDESCRIPTION, '' AS QUANTITYORDER, '' AS M_PRODUCT_UOM_ID," +
      "          '' AS C_CAMPAIGN_ID, '' AS C_PROJECT_ID," +
      "          '' AS USER1_ID, '' AS USER2_ID, '' AS GLITEM_CREDIT_ACCT," +
      "          '' AS GLITEM_DEBIT_ACCT, '' AS INOUTPROJECT, '' AS C_INVOICE_ID, '' AS INOUTUSER1, " +
      "          '' AS INOUTUSER2,'' AS INOUTCAMPAING, '' AS C_ACTIVITY_ID,  '' AS INOUTACTIVITY," +
      "          '' AS C_COSTCENTER_ID, '' AS INOUTCOSCENTER, '' AS ISSOTRX, '' as A_Asset_ID" +
      "        FROM DUAL";

    ResultSet result;
    Vector<DocMatchInvData> vector = new Vector<DocMatchInvData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.mMatchinvId = UtilSql.getValue(result, "m_matchinv_id");
        objectDocMatchInvData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocMatchInvData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocMatchInvData.isactive = UtilSql.getValue(result, "isactive");
        objectDocMatchInvData.created = UtilSql.getValue(result, "created");
        objectDocMatchInvData.createdby = UtilSql.getValue(result, "createdby");
        objectDocMatchInvData.updated = UtilSql.getValue(result, "updated");
        objectDocMatchInvData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocMatchInvData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocMatchInvData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocMatchInvData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocMatchInvData.datetrx = UtilSql.getValue(result, "datetrx");
        objectDocMatchInvData.qty = UtilSql.getValue(result, "qty");
        objectDocMatchInvData.processing = UtilSql.getValue(result, "processing");
        objectDocMatchInvData.processed = UtilSql.getValue(result, "processed");
        objectDocMatchInvData.posted = UtilSql.getValue(result, "posted");
        objectDocMatchInvData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocMatchInvData.datedoc = UtilSql.getValue(result, "datedoc");
        objectDocMatchInvData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocMatchInvData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocMatchInvData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocMatchInvData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectDocMatchInvData.orderacctdate = UtilSql.getValue(result, "orderacctdate");
        objectDocMatchInvData.invoicestatus = UtilSql.getValue(result, "invoicestatus");
        objectDocMatchInvData.inoutstatus = UtilSql.getValue(result, "inoutstatus");
        objectDocMatchInvData.movementqty = UtilSql.getValue(result, "movementqty");
        objectDocMatchInvData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectDocMatchInvData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectDocMatchInvData.line = UtilSql.getValue(result, "line");
        objectDocMatchInvData.description = UtilSql.getValue(result, "description");
        objectDocMatchInvData.mCGlitemId = UtilSql.getValue(result, "m_c_glitem_id");
        objectDocMatchInvData.pricelist = UtilSql.getValue(result, "pricelist");
        objectDocMatchInvData.priceactual = UtilSql.getValue(result, "priceactual");
        objectDocMatchInvData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectDocMatchInvData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocMatchInvData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocMatchInvData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocMatchInvData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocMatchInvData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectDocMatchInvData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocMatchInvData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectDocMatchInvData.isdescription = UtilSql.getValue(result, "isdescription");
        objectDocMatchInvData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectDocMatchInvData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectDocMatchInvData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocMatchInvData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocMatchInvData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocMatchInvData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocMatchInvData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocMatchInvData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocMatchInvData.inoutproject = UtilSql.getValue(result, "inoutproject");
        objectDocMatchInvData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocMatchInvData.inoutuser1 = UtilSql.getValue(result, "inoutuser1");
        objectDocMatchInvData.inoutuser2 = UtilSql.getValue(result, "inoutuser2");
        objectDocMatchInvData.inoutcampaing = UtilSql.getValue(result, "inoutcampaing");
        objectDocMatchInvData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocMatchInvData.inoutactivity = UtilSql.getValue(result, "inoutactivity");
        objectDocMatchInvData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocMatchInvData.inoutcoscenter = UtilSql.getValue(result, "inoutcoscenter");
        objectDocMatchInvData.issotrx = UtilSql.getValue(result, "issotrx");
        objectDocMatchInvData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }

  public static DocMatchInvData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocMatchInvData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M.M_MATCHINV_ID, M.AD_CLIENT_ID, M.AD_ORG_ID, M.ISACTIVE, M.CREATED, M.CREATEDBY, M.UPDATED,        " +
      "        M.UPDATEDBY, M.M_INOUTLINE_ID, M.C_INVOICELINE_ID, M.M_PRODUCT_ID, M.DATETRX, M.QTY, M.PROCESSING,        " +
      "        M.PROCESSED, M.POSTED, M.DATETRX AS DATEACCT, M.DATETRX AS DATEDOC, I.C_BPARTNER_ID, IO.DATEACCT as orderAcctDate,        " +
      "        IO.DOCSTATUS AS INOUTSTATUS, I.DOCSTATUS AS INVOICESTATUS, IOL.MOVEMENTQTY, IL.QTYINVOICED,        " +
      "        I.C_PROJECT_ID, COALESCE(IO.C_PROJECT_ID,IOL.C_PROJECT_ID)  AS INOUTPROJECT, I.USER1_ID, COALESCE(IO.USER1_ID,IOL.USER1_ID) AS INOUTUSER1, " +
      "        I.USER2_ID, COALESCE(IO.USER2_ID,IOL.USER2_ID) AS INOUTUSER2,  I.C_COSTCENTER_ID, COALESCE(IO.C_COSTCENTER_ID,IOL.C_COSTCENTER_ID) AS INOUTCOSCENTER," +
      "        I.C_CAMPAIGN_ID,IO.C_CAMPAIGN_ID as INOUTCAMPAING, I.C_ACTIVITY_ID, IO.C_ACTIVITY_ID AS INOUTACTIVITY" +
      "        FROM M_MATCHINV M, C_INVOICELINE IL, C_INVOICE I, M_INOUTLINE IOL, M_INOUT IO      " +
      "        WHERE IL.C_INVOICELINE_ID = M.C_INVOICELINE_ID" +
      "        AND IL.C_INVOICE_ID = I.C_INVOICE_ID" +
      "        AND IOL.M_INOUTLINE_ID = M.M_INOUTLINE_ID" +
      "        AND IO.M_INOUT_ID = IOL.M_INOUT_ID" +
      "        AND M.AD_Client_ID=?" +
      "        AND M.M_MATCHINV_ID=?";

    ResultSet result;
    Vector<DocMatchInvData> vector = new Vector<DocMatchInvData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.mMatchinvId = UtilSql.getValue(result, "m_matchinv_id");
        objectDocMatchInvData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocMatchInvData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocMatchInvData.isactive = UtilSql.getValue(result, "isactive");
        objectDocMatchInvData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectDocMatchInvData.createdby = UtilSql.getValue(result, "createdby");
        objectDocMatchInvData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectDocMatchInvData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocMatchInvData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocMatchInvData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocMatchInvData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocMatchInvData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectDocMatchInvData.qty = UtilSql.getValue(result, "qty");
        objectDocMatchInvData.processing = UtilSql.getValue(result, "processing");
        objectDocMatchInvData.processed = UtilSql.getValue(result, "processed");
        objectDocMatchInvData.posted = UtilSql.getValue(result, "posted");
        objectDocMatchInvData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocMatchInvData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocMatchInvData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocMatchInvData.orderacctdate = UtilSql.getDateValue(result, "orderacctdate", "dd-MM-yyyy");
        objectDocMatchInvData.inoutstatus = UtilSql.getValue(result, "inoutstatus");
        objectDocMatchInvData.invoicestatus = UtilSql.getValue(result, "invoicestatus");
        objectDocMatchInvData.movementqty = UtilSql.getValue(result, "movementqty");
        objectDocMatchInvData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectDocMatchInvData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocMatchInvData.inoutproject = UtilSql.getValue(result, "inoutproject");
        objectDocMatchInvData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocMatchInvData.inoutuser1 = UtilSql.getValue(result, "inoutuser1");
        objectDocMatchInvData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocMatchInvData.inoutuser2 = UtilSql.getValue(result, "inoutuser2");
        objectDocMatchInvData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocMatchInvData.inoutcoscenter = UtilSql.getValue(result, "inoutcoscenter");
        objectDocMatchInvData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocMatchInvData.inoutcampaing = UtilSql.getValue(result, "inoutcampaing");
        objectDocMatchInvData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocMatchInvData.inoutactivity = UtilSql.getValue(result, "inoutactivity");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }

  public static String selectProductAverageCost(ConnectionProvider connectionProvider, String mProductID, String date)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(M_GET_PRODUCT_COST(?, TO_DATE(?), TO_CHAR(NULL)),0) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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

  public static DocMatchInvData[] selectInvoiceData(ConnectionProvider connectionProvider, String adClientId, String cInvoiceLineId)    throws ServletException {
    return selectInvoiceData(connectionProvider, adClientId, cInvoiceLineId, 0, 0);
  }

  public static DocMatchInvData[] selectInvoiceData(ConnectionProvider connectionProvider, String adClientId, String cInvoiceLineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT L.LINENETAMT, I.C_CURRENCY_ID, I.DATEACCT, I.ISSOTRX, I.C_INVOICE_ID" +
      "      FROM C_INVOICELINE L, C_INVOICE I" +
      "      WHERE L.AD_CLIENT_ID = ?" +
      "        AND L.C_INVOICELINE_ID = ?" +
      "        AND I.C_INVOICE_ID = L.C_INVOICE_ID";

    ResultSet result;
    Vector<DocMatchInvData> vector = new Vector<DocMatchInvData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceLineId);

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocMatchInvData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocMatchInvData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocMatchInvData.issotrx = UtilSql.getValue(result, "issotrx");
        objectDocMatchInvData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }

  public static DocMatchInvData[] selectInvoiceLine(ConnectionProvider connectionProvider, String cInvoiceLineId)    throws ServletException {
    return selectInvoiceLine(connectionProvider, cInvoiceLineId, 0, 0);
  }

  public static DocMatchInvData[] selectInvoiceLine(ConnectionProvider connectionProvider, String cInvoiceLineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_INVOICELINE.C_INVOICELINE_ID, C_INVOICELINE.AD_CLIENT_ID, " +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.AD_ORG_ID,C_INVOICELINE.AD_ORG_ID) AS AD_ORG_ID," +
      "        C_INVOICELINE.ISACTIVE, C_INVOICELINE.C_INVOICE_ID, C_INVOICELINE.C_ORDERLINE_ID, C_INVOICELINE.M_INOUTLINE_ID," +
      "        C_INVOICELINE.LINE, C_INVOICELINE.DESCRIPTION, " +
      "        C_INVOICELINE.ACCOUNT_ID AS M_C_GLITEM_ID, C_INVOICELINE.QTYINVOICED," +
      "        C_INVOICELINE.PRICELIST, C_INVOICELINE.PRICEACTUAL, C_INVOICELINE.PRICELIMIT," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.AMT, C_INVOICELINE.LINENETAMT) AS LINENETAMT," +
      "        C_INVOICELINE.C_CHARGE_ID, C_INVOICELINE.CHARGEAMT, C_INVOICELINE.C_UOM_ID, '' as C_TAX_ID," +
      "        C_INVOICELINE.S_RESOURCEASSIGNMENT_ID, C_INVOICELINE.TAXAMT, C_INVOICELINE.M_ATTRIBUTESETINSTANCE_ID," +
      "        C_INVOICELINE.ISDESCRIPTION, C_INVOICELINE.QUANTITYORDER, C_INVOICELINE.M_PRODUCT_UOM_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, " +
      "        COALESCE(C_INVOICELINE.C_PROJECT_ID, C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID) as C_PROJECT_ID," +
      "        COALESCE(C_INVOICELINE.USER1_ID, C_INVOICELINE_ACCTDIMENSION.USER1_ID) as USER1_ID," +
      "        COALESCE(C_INVOICELINE.USER2_ID, C_INVOICELINE_ACCTDIMENSION.USER2_ID) as USER2_ID," +
      "        COALESCE(C_INVOICELINE.C_COSTCENTER_ID, C_INVOICELINE_ACCTDIMENSION.C_COSTCENTER_ID) as C_COSTCENTER_ID," +
      "        COALESCE(C_INVOICELINE.C_BPARTNER_ID, C_INVOICELINE_ACCTDIMENSION.C_BPARTNER_ID) as C_BPARTNER_ID," +
      "        COALESCE(C_INVOICELINE.M_PRODUCT_ID, C_INVOICELINE_ACCTDIMENSION.M_PRODUCT_ID) as M_PRODUCT_ID," +
      "        '' AS GLITEM_CREDIT_ACCT, '' AS GLITEM_DEBIT_ACCT" +
      "      FROM C_INVOICELINE left join C_INVOICELINE_ACCTDIMENSION on C_INVOICELINE.C_INVOICELINE_ID = C_INVOICELINE_ACCTDIMENSION.C_INVOICELINE_ID" +
      "      WHERE C_INVOICELINE.C_INVOICELINE_ID = ?" +
      "      ORDER BY LINE";

    ResultSet result;
    Vector<DocMatchInvData> vector = new Vector<DocMatchInvData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceLineId);

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocMatchInvData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocMatchInvData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocMatchInvData.isactive = UtilSql.getValue(result, "isactive");
        objectDocMatchInvData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocMatchInvData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectDocMatchInvData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocMatchInvData.line = UtilSql.getValue(result, "line");
        objectDocMatchInvData.description = UtilSql.getValue(result, "description");
        objectDocMatchInvData.mCGlitemId = UtilSql.getValue(result, "m_c_glitem_id");
        objectDocMatchInvData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectDocMatchInvData.pricelist = UtilSql.getValue(result, "pricelist");
        objectDocMatchInvData.priceactual = UtilSql.getValue(result, "priceactual");
        objectDocMatchInvData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectDocMatchInvData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocMatchInvData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocMatchInvData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocMatchInvData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocMatchInvData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocMatchInvData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectDocMatchInvData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocMatchInvData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectDocMatchInvData.isdescription = UtilSql.getValue(result, "isdescription");
        objectDocMatchInvData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectDocMatchInvData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectDocMatchInvData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocMatchInvData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocMatchInvData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocMatchInvData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocMatchInvData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocMatchInvData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocMatchInvData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocMatchInvData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocMatchInvData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }

  public static DocMatchInvData[] selectInvoiceLineTotal(ConnectionProvider connectionProvider, String C_Invoice_ID)    throws ServletException {
    return selectInvoiceLineTotal(connectionProvider, C_Invoice_ID, 0, 0);
  }

  public static DocMatchInvData[] selectInvoiceLineTotal(ConnectionProvider connectionProvider, String C_Invoice_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_INVOICELINE.C_INVOICELINE_ID) AS C_INVOICELINE_ID, C_INVOICELINE.AD_CLIENT_ID," +
      "        C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.ISACTIVE, C_INVOICELINE.C_INVOICE_ID," +
      "        MAX(C_INVOICELINE.C_ORDERLINE_ID) AS C_ORDERLINE_ID, MAX(C_INVOICELINE.M_INOUTLINE_ID) AS M_INOUTLINE_ID," +
      "        MAX(C_INVOICELINE.LINE) AS LINE, MAX(C_INVOICELINE.DESCRIPTION) AS DESCRIPTION, C_INVOICELINE.M_PRODUCT_ID," +
      "        SUM(C_INVOICELINE.QTYINVOICED) AS QTYINVOICED, C_INVOICELINE.PRICELIST, C_INVOICELINE.PRICEACTUAL," +
      "        C_INVOICELINE.PRICELIMIT, SUM(COALESCE(C_INVOICELINE_ACCTDIMENSION.AMT, C_INVOICELINE.LINENETAMT)) AS LINENETAMT, MAX(C_INVOICELINE.C_CHARGE_ID) AS C_CHARGE_ID," +
      "        SUM(C_INVOICELINE.CHARGEAMT) AS CHARGEAMT, C_INVOICELINE.C_UOM_ID, '' as C_TAX_ID," +
      "        C_INVOICELINE.S_RESOURCEASSIGNMENT_ID, SUM(C_INVOICELINE.TAXAMT) AS TAXAMT," +
      "        C_INVOICELINE.M_ATTRIBUTESETINSTANCE_ID," +
      "        C_INVOICELINE.ISDESCRIPTION, SUM(C_INVOICELINE.QUANTITYORDER) AS QUANTITYORDER, C_INVOICELINE.M_PRODUCT_UOM_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.USER1_ID, C_INVOICELINE_ACCTDIMENSION.USER2_ID" +
      "        FROM C_INVOICELINE left join C_INVOICELINE_ACCTDIMENSION on C_INVOICELINE.C_INVOICELINE_ID = C_INVOICELINE_ACCTDIMENSION.C_INVOICELINE_ID" +
      "        WHERE  C_INVOICELINE.C_INVOICELINE_ID = ?" +
      "        GROUP BY C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_INVOICELINE.ISACTIVE, C_INVOICELINE.C_INVOICE_ID," +
      "        C_INVOICELINE.M_PRODUCT_ID,C_INVOICELINE.PRICELIST, C_INVOICELINE.PRICEACTUAL, C_INVOICELINE.PRICELIMIT," +
      "        C_INVOICELINE.C_UOM_ID, C_INVOICELINE.C_TAX_ID, C_INVOICELINE.S_RESOURCEASSIGNMENT_ID," +
      "        C_INVOICELINE.M_ATTRIBUTESETINSTANCE_ID,C_INVOICELINE.ISDESCRIPTION, C_INVOICELINE.M_PRODUCT_UOM_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID," +
      "        C_INVOICELINE_ACCTDIMENSION.USER1_ID, C_INVOICELINE_ACCTDIMENSION.USER2_ID" +
      "        ORDER BY LINE";

    ResultSet result;
    Vector<DocMatchInvData> vector = new Vector<DocMatchInvData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_ID);

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectDocMatchInvData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocMatchInvData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocMatchInvData.isactive = UtilSql.getValue(result, "isactive");
        objectDocMatchInvData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocMatchInvData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectDocMatchInvData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocMatchInvData.line = UtilSql.getValue(result, "line");
        objectDocMatchInvData.description = UtilSql.getValue(result, "description");
        objectDocMatchInvData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocMatchInvData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectDocMatchInvData.pricelist = UtilSql.getValue(result, "pricelist");
        objectDocMatchInvData.priceactual = UtilSql.getValue(result, "priceactual");
        objectDocMatchInvData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectDocMatchInvData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocMatchInvData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocMatchInvData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocMatchInvData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocMatchInvData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocMatchInvData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectDocMatchInvData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocMatchInvData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectDocMatchInvData.isdescription = UtilSql.getValue(result, "isdescription");
        objectDocMatchInvData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectDocMatchInvData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectDocMatchInvData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocMatchInvData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocMatchInvData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocMatchInvData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }

  public static DocMatchInvData[] selectInOutLineTotal(ConnectionProvider connectionProvider, String M_InOutLine_ID)    throws ServletException {
    return selectInOutLineTotal(connectionProvider, M_InOutLine_ID, 0, 0);
  }

  public static DocMatchInvData[] selectInOutLineTotal(ConnectionProvider connectionProvider, String M_InOutLine_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COALESCE(A.AD_ORG_ID,IO.AD_ORG_ID) AS AD_ORG_ID, IO.M_PRODUCT_ID, IO.LINE, IO.DESCRIPTION," +
      "          IO.C_UOM_ID, IO.M_INOUTLINE_ID, COALESCE(A.Quantity, IO.MOVEMENTQTY) as MOVEMENTQTY," +
      "          A.C_Campaign_ID, COALESCE(A.C_Project_Id, IO.C_Project_Id) AS C_Project_Id, COALESCE(A.User1_ID, IO.User1_ID) AS User1_ID," +
      "          COALESCE(A.User2_ID, IO.User2_ID) AS User2_ID, COALESCE(A.C_Costcenter_ID, IO.C_Costcenter_ID) AS C_Costcenter_ID," +
      "          COALESCE(A.A_Asset_ID,IO.A_Asset_ID) AS A_Asset_ID, COALESCE(A.C_BPartner_ID, IO.C_BPartner_ID) AS C_BPartner_ID, A.C_Activity_ID" +
      "          FROM M_InOutLine IO left join M_InOutLine_AcctDimension A ON IO.M_InOutLine_ID = A.M_InOutLine_ID" +
      "          WHERE IO.M_InOutLine_ID=?" +
      "          ORDER BY Line";

    ResultSet result;
    Vector<DocMatchInvData> vector = new Vector<DocMatchInvData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_InOutLine_ID);

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
        DocMatchInvData objectDocMatchInvData = new DocMatchInvData();
        objectDocMatchInvData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocMatchInvData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocMatchInvData.line = UtilSql.getValue(result, "line");
        objectDocMatchInvData.description = UtilSql.getValue(result, "description");
        objectDocMatchInvData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocMatchInvData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocMatchInvData.movementqty = UtilSql.getValue(result, "movementqty");
        objectDocMatchInvData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocMatchInvData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocMatchInvData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocMatchInvData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocMatchInvData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocMatchInvData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocMatchInvData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocMatchInvData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocMatchInvData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocMatchInvData);
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
    DocMatchInvData objectDocMatchInvData[] = new DocMatchInvData[vector.size()];
    vector.copyInto(objectDocMatchInvData);
    return(objectDocMatchInvData);
  }
}
