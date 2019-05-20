//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
Clase ExpenseAPInvoiceData
 */
class ExpenseAPInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExpenseAPInvoiceData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cBpartnerId;
  public String datereport;
  public String bpname;
  public String cProjectId;
  public String cActivityId;
  public String cCampaignId;
  public String mProductId;
  public String prodname;
  public String sResourceassignmentId;
  public String cUomId;
  public String qty;
  public String description;
  public String note;
  public String expenseamt;
  public String cCurrencyId;
  public String convertedamt;
  public String documentno;
  public String sTimeexpenselineId;
  public String invoiceprice;
  public String dateexpense;
  public String pricestd;
  public String pricelimit;
  public String pricelist;
  public String cInvoicelineId;
  public String qtyinvoiced;
  public String cInvoicelineAcctdimensionId;
  public String amt;
  public String stdprecision;
  public String priceprecision;
  public String cCostcenterId;
  public String aAssetId;
  public String user1Id;
  public String user2Id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("datereport"))
      return datereport;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("prodname"))
      return prodname;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("expenseamt"))
      return expenseamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("convertedamt"))
      return convertedamt;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("s_timeexpenseline_id") || fieldName.equals("sTimeexpenselineId"))
      return sTimeexpenselineId;
    else if (fieldName.equalsIgnoreCase("invoiceprice"))
      return invoiceprice;
    else if (fieldName.equalsIgnoreCase("dateexpense"))
      return dateexpense;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_acctdimension_id") || fieldName.equals("cInvoicelineAcctdimensionId"))
      return cInvoicelineAcctdimensionId;
    else if (fieldName.equalsIgnoreCase("amt"))
      return amt;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for relation
 */
  public static ExpenseAPInvoiceData[] select(ConnectionProvider connectionProvider, String userClient, String userOrg, String dateReportFrom, String dateReportTo, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, userClient, userOrg, dateReportFrom, dateReportTo, cBpartnerId, 0, 0);
  }

/**
Select for relation
 */
  public static ExpenseAPInvoiceData[] select(ConnectionProvider connectionProvider, String userClient, String userOrg, String dateReportFrom, String dateReportTo, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  st.AD_Client_ID, st.AD_Org_ID, st.C_BPartner_ID, to_char(st.DateReport) as datereport, bp.name as bpname, COALESCE(stl.C_Project_ID, st.C_Project_ID) AS C_Project_ID," +
      "        stl.C_Activity_ID, stl.C_Campaign_ID, stl.M_Product_ID, p.name as prodname, stl.S_ResourceAssignment_ID, stl.C_UOM_ID," +
      "        stl.Qty, stl.Description, stl.Note, stl.ExpenseAmt, stl.C_Currency_ID, stl.ConvertedAmt, st.DocumentNo, stl.S_TimeExpenseLine_ID, stl.invoiceprice," +
      "        to_char(stl.DateExpense) as dateexpense, '' AS Pricestd, '' AS Pricelimit, '' AS Pricelist," +
      "        '' AS C_INVOICELINE_ID, '' AS QTYINVOICED, '' AS C_INVOICELINE_ACCTDIMENSION_ID, '' AS AMT, '' AS STDPRECISION, '' AS PRICEPRECISION," +
      "        COALESCE(stl.C_Costcenter_ID, st.C_Costcenter_ID) AS C_Costcenter_ID, COALESCE(stl.A_Asset_ID, st.A_Asset_ID) AS A_Asset_ID," +
      "        COALESCE(stl.User1_ID, st.User1_ID) AS User1_ID, COALESCE(stl.User2_ID, st.User2_ID) AS User2_ID" +
      "        FROM S_TimeExpense st, S_TimeExpenseLine stl, C_BPartner bp, M_Product p" +
      "        WHERE st.S_TimeExpense_Id = stl.S_TimeExpense_Id" +
      "        AND st.C_BPartner_ID = bp.C_BPartner_ID" +
      "        AND stl.M_Product_ID = p.M_Product_ID" +
      "        AND st.AD_Client_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ")" +
      "        AND st.AD_Org_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ")" +
      "        AND COALESCE(stl.DateExpense, st.DateReport) >= TO_DATE(?)" +
      "        AND COALESCE(stl.DateExpense, st.DateReport) < TO_DATE(?)" +
      "        AND stl.ISTIMEREPORT <> 'Y'" +
      "        AND st.PROCESSED = 'Y'" +
      "        AND stl.C_InvoiceLine_ID IS NULL";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND st.C_BPartner_ID = ? ");
    strSql = strSql + 
      "        ORDER BY st.C_BPartner_ID, st.S_TimeExpense_ID, stl.line";

    ResultSet result;
    Vector<ExpenseAPInvoiceData> vector = new Vector<ExpenseAPInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (userClient != null && !(userClient.equals(""))) {
        }
      if (userOrg != null && !(userOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateReportFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateReportTo);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
        ExpenseAPInvoiceData objectExpenseAPInvoiceData = new ExpenseAPInvoiceData();
        objectExpenseAPInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExpenseAPInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExpenseAPInvoiceData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExpenseAPInvoiceData.datereport = UtilSql.getValue(result, "datereport");
        objectExpenseAPInvoiceData.bpname = UtilSql.getValue(result, "bpname");
        objectExpenseAPInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectExpenseAPInvoiceData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectExpenseAPInvoiceData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectExpenseAPInvoiceData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectExpenseAPInvoiceData.prodname = UtilSql.getValue(result, "prodname");
        objectExpenseAPInvoiceData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectExpenseAPInvoiceData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectExpenseAPInvoiceData.qty = UtilSql.getValue(result, "qty");
        objectExpenseAPInvoiceData.description = UtilSql.getValue(result, "description");
        objectExpenseAPInvoiceData.note = UtilSql.getValue(result, "note");
        objectExpenseAPInvoiceData.expenseamt = UtilSql.getValue(result, "expenseamt");
        objectExpenseAPInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectExpenseAPInvoiceData.convertedamt = UtilSql.getValue(result, "convertedamt");
        objectExpenseAPInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectExpenseAPInvoiceData.sTimeexpenselineId = UtilSql.getValue(result, "s_timeexpenseline_id");
        objectExpenseAPInvoiceData.invoiceprice = UtilSql.getValue(result, "invoiceprice");
        objectExpenseAPInvoiceData.dateexpense = UtilSql.getValue(result, "dateexpense");
        objectExpenseAPInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectExpenseAPInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectExpenseAPInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectExpenseAPInvoiceData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectExpenseAPInvoiceData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectExpenseAPInvoiceData.cInvoicelineAcctdimensionId = UtilSql.getValue(result, "c_invoiceline_acctdimension_id");
        objectExpenseAPInvoiceData.amt = UtilSql.getValue(result, "amt");
        objectExpenseAPInvoiceData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectExpenseAPInvoiceData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectExpenseAPInvoiceData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectExpenseAPInvoiceData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectExpenseAPInvoiceData.user1Id = UtilSql.getValue(result, "user1_id");
        objectExpenseAPInvoiceData.user2Id = UtilSql.getValue(result, "user2_id");
        objectExpenseAPInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseAPInvoiceData);
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
    ExpenseAPInvoiceData objectExpenseAPInvoiceData[] = new ExpenseAPInvoiceData[vector.size()];
    vector.copyInto(objectExpenseAPInvoiceData);
    return(objectExpenseAPInvoiceData);
  }

/**
Select for relation
 */
  public static String selectInvoiceHeader(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String dateinvoiced, String cBpartnerId, String cCurrencyId, String cProjectId, String cActivityId, String cCampaignId, String cBpartnerLocationId, String paymentrule, String paymentmethodId, String cPaymentTermId, String cCostcenterId, String aAssetId, String user1Id, String user2Id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(C_INVOICE.C_INVOICE_ID) AS C_INVOICE_ID" +
      "      FROM C_INVOICE" +
      "      WHERE C_INVOICE.AD_CLIENT_ID = ?" +
      "      AND C_INVOICE.AD_ORG_ID = ?" +
      "      AND C_INVOICE.DATEINVOICED = TO_DATE(?)" +
      "      AND C_INVOICE.C_BPARTNER_ID = ?" +
      "      AND C_INVOICE.C_CURRENCY_ID = ?" +
      "      AND C_INVOICE.DOCSTATUS = 'DR'" +
      "      AND C_INVOICE.PROCESSED <> 'Y'" +
      "      AND C_INVOICE.ISACTIVE = 'Y'" +
      "      AND C_INVOICE.ISSOTRX = 'N'";
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_INVOICE.C_PROJECT_ID = ? ");
    strSql = strSql + ((cActivityId==null || cActivityId.equals(""))?"":"  AND C_INVOICE.C_ACTIVITY_ID = ? ");
    strSql = strSql + ((cCampaignId==null || cCampaignId.equals(""))?"":"  AND C_INVOICE.C_CAMPAIGN_ID = ? ");
    strSql = strSql + ((cBpartnerLocationId==null || cBpartnerLocationId.equals(""))?"":"  AND C_INVOICE.C_BPARTNER_LOCATION_ID = ? ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND C_INVOICE.PAYMENTRULE = ? ");
    strSql = strSql + ((paymentmethodId==null || paymentmethodId.equals(""))?"":"  AND C_INVOICE.FIN_PAYMENTMETHOD_ID = ? ");
    strSql = strSql + ((cPaymentTermId==null || cPaymentTermId.equals(""))?"":"  AND C_INVOICE.C_PAYMENTTERM_ID = ? ");
    strSql = strSql + ((cCostcenterId==null || cCostcenterId.equals(""))?"":"  AND C_INVOICE.C_COSTCENTER_ID = ? ");
    strSql = strSql + ((aAssetId==null || aAssetId.equals(""))?"":"  AND C_INVOICE.A_ASSET_ID = ? ");
    strSql = strSql + ((user1Id==null || user1Id.equals(""))?"":"  AND C_INVOICE.USER1_ID = ? ");
    strSql = strSql + ((user2Id==null || user2Id.equals(""))?"":"  AND C_INVOICE.USER2_ID = ? ");

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (cActivityId != null && !(cActivityId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      }
      if (cCampaignId != null && !(cCampaignId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      }
      if (cBpartnerLocationId != null && !(cBpartnerLocationId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      }
      if (paymentrule != null && !(paymentrule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      }
      if (paymentmethodId != null && !(paymentmethodId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentmethodId);
      }
      if (cPaymentTermId != null && !(cPaymentTermId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymentTermId);
      }
      if (cCostcenterId != null && !(cCostcenterId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      }
      if (aAssetId != null && !(aAssetId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      }
      if (user1Id != null && !(user1Id.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      }
      if (user2Id != null && !(user2Id.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_invoice_id");
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
    return(strReturn);
  }

/**
Select for relation (when project is null)
 */
  public static String selectInvoiceHeaderNoProject(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String dateinvoiced, String cBpartnerId, String cCurrencyId, String cActivityId, String cCampaignId, String cBpartnerLocationId, String paymentrule, String paymentmethodId, String cPaymentTermId, String cCostcenterId, String aAssetId, String user1Id, String user2Id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(C_INVOICE.C_INVOICE_ID) AS C_INVOICE_ID" +
      "      FROM C_INVOICE" +
      "      WHERE C_INVOICE.AD_CLIENT_ID = ?" +
      "      AND C_INVOICE.AD_ORG_ID = ?" +
      "      AND C_INVOICE.DATEINVOICED = TO_DATE(?)" +
      "      AND C_INVOICE.C_BPARTNER_ID = ?" +
      "      AND C_INVOICE.C_CURRENCY_ID = ?" +
      "      AND C_INVOICE.DOCSTATUS = 'DR'" +
      "      AND C_INVOICE.PROCESSED <> 'Y'" +
      "      AND C_INVOICE.ISACTIVE = 'Y'" +
      "      AND C_INVOICE.ISSOTRX = 'N'";
    strSql = strSql + ((cActivityId==null || cActivityId.equals(""))?"":"  AND C_INVOICE.C_ACTIVITY_ID = ? ");
    strSql = strSql + ((cCampaignId==null || cCampaignId.equals(""))?"":"  AND C_INVOICE.C_CAMPAIGN_ID = ? ");
    strSql = strSql + ((cBpartnerLocationId==null || cBpartnerLocationId.equals(""))?"":"  AND C_INVOICE.C_BPARTNER_LOCATION_ID = ? ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND C_INVOICE.PAYMENTRULE = ? ");
    strSql = strSql + ((paymentmethodId==null || paymentmethodId.equals(""))?"":"  AND C_INVOICE.FIN_PAYMENTMETHOD_ID = ? ");
    strSql = strSql + ((cPaymentTermId==null || cPaymentTermId.equals(""))?"":"  AND C_INVOICE.C_PAYMENTTERM_ID = ? ");
    strSql = strSql + ((cCostcenterId==null || cCostcenterId.equals(""))?"":"  AND C_INVOICE.C_COSTCENTER_ID = ? ");
    strSql = strSql + ((aAssetId==null || aAssetId.equals(""))?"":"  AND C_INVOICE.A_ASSET_ID = ? ");
    strSql = strSql + ((user1Id==null || user1Id.equals(""))?"":"  AND C_INVOICE.USER1_ID = ? ");
    strSql = strSql + ((user2Id==null || user2Id.equals(""))?"":"  AND C_INVOICE.USER2_ID = ? ");
    strSql = strSql + 
      "      AND C_INVOICE.C_PROJECT_ID IS NULL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      if (cActivityId != null && !(cActivityId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      }
      if (cCampaignId != null && !(cCampaignId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      }
      if (cBpartnerLocationId != null && !(cBpartnerLocationId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      }
      if (paymentrule != null && !(paymentrule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      }
      if (paymentmethodId != null && !(paymentmethodId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentmethodId);
      }
      if (cPaymentTermId != null && !(cPaymentTermId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymentTermId);
      }
      if (cCostcenterId != null && !(cCostcenterId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      }
      if (aAssetId != null && !(aAssetId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      }
      if (user1Id != null && !(user1Id.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      }
      if (user2Id != null && !(user2Id.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_invoice_id");
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
    return(strReturn);
  }

/**
Select for relation
 */
  public static ExpenseAPInvoiceData[] selectInvoiceLine(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String adClientId, String adOrgId, String mProductId, String cUomId, String pricestd, String pricelist, String pricelimit, String description, String cTaxId)    throws ServletException {
    return selectInvoiceLine(conn, connectionProvider, cInvoiceId, adClientId, adOrgId, mProductId, cUomId, pricestd, pricelist, pricelimit, description, cTaxId, 0, 0);
  }

/**
Select for relation
 */
  public static ExpenseAPInvoiceData[] selectInvoiceLine(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String adClientId, String adOrgId, String mProductId, String cUomId, String pricestd, String pricelist, String pricelimit, String description, String cTaxId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_INVOICELINE_ID, SUM(QTYINVOICED) AS QTYINVOICED" +
      "      FROM C_INVOICELINE" +
      "      WHERE C_INVOICE_ID = ?" +
      "      AND AD_CLIENT_ID = ?" +
      "      AND AD_ORG_ID = ?" +
      "      AND M_PRODUCT_ID = ?" +
      "      AND C_UOM_ID = ?" +
      "      AND PRICESTD = TO_NUMBER(?)" +
      "      AND PRICELIST = TO_NUMBER(?)" +
      "      AND PRICELIMIT = TO_NUMBER(?)" +
      "      AND C_INVOICELINE.ISACTIVE = 'Y'";
    strSql = strSql + ((description==null || description.equals(""))?"":"  AND C_INVOICELINE.DESCRIPTION = ? ");
    strSql = strSql + ((cTaxId==null || cTaxId.equals(""))?"":"  AND C_INVOICELINE.C_TAX_ID = ? ");
    strSql = strSql + 
      "      GROUP BY C_INVOICELINE_ID";

    ResultSet result;
    Vector<ExpenseAPInvoiceData> vector = new Vector<ExpenseAPInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      if (description != null && !(description.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (cTaxId != null && !(cTaxId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
        ExpenseAPInvoiceData objectExpenseAPInvoiceData = new ExpenseAPInvoiceData();
        objectExpenseAPInvoiceData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectExpenseAPInvoiceData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectExpenseAPInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseAPInvoiceData);
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
    ExpenseAPInvoiceData objectExpenseAPInvoiceData[] = new ExpenseAPInvoiceData[vector.size()];
    vector.copyInto(objectExpenseAPInvoiceData);
    return(objectExpenseAPInvoiceData);
  }

/**
Select for relation
 */
  public static ExpenseAPInvoiceData[] selectAcctdimension(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cInvoicelineId, String cProjectId, String cCampaignId, String cCostcenterId, String aAssetId, String user1Id, String user2Id)    throws ServletException {
    return selectAcctdimension(conn, connectionProvider, adClientId, adOrgId, cInvoicelineId, cProjectId, cCampaignId, cCostcenterId, aAssetId, user1Id, user2Id, 0, 0);
  }

/**
Select for relation
 */
  public static ExpenseAPInvoiceData[] selectAcctdimension(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cInvoicelineId, String cProjectId, String cCampaignId, String cCostcenterId, String aAssetId, String user1Id, String user2Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_INVOICELINE_ACCTDIMENSION_ID, SUM(AMT) AS AMT" +
      "      FROM C_INVOICELINE_ACCTDIMENSION" +
      "      WHERE AD_CLIENT_ID = ?" +
      "      AND AD_ORG_ID = ?" +
      "      AND C_INVOICELINE_ID = ?" +
      "      AND ISACTIVE = 'Y'";
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_PROJECT_ID = ? ");
    strSql = strSql + ((cCampaignId==null || cCampaignId.equals(""))?"":"  AND C_CAMPAIGN_ID = ? ");
    strSql = strSql + ((cCostcenterId==null || cCostcenterId.equals(""))?"":"  AND C_COSTCENTER_ID = ? ");
    strSql = strSql + ((aAssetId==null || aAssetId.equals(""))?"":"  AND A_ASSET_ID = ? ");
    strSql = strSql + ((user1Id==null || user1Id.equals(""))?"":"  AND USER1_ID = ? ");
    strSql = strSql + ((user2Id==null || user2Id.equals(""))?"":"  AND USER2_ID = ? ");
    strSql = strSql + 
      "      GROUP BY C_INVOICELINE_ACCTDIMENSION_ID";

    ResultSet result;
    Vector<ExpenseAPInvoiceData> vector = new Vector<ExpenseAPInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (cCampaignId != null && !(cCampaignId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      }
      if (cCostcenterId != null && !(cCostcenterId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      }
      if (aAssetId != null && !(aAssetId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      }
      if (user1Id != null && !(user1Id.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      }
      if (user2Id != null && !(user2Id.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
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
        ExpenseAPInvoiceData objectExpenseAPInvoiceData = new ExpenseAPInvoiceData();
        objectExpenseAPInvoiceData.cInvoicelineAcctdimensionId = UtilSql.getValue(result, "c_invoiceline_acctdimension_id");
        objectExpenseAPInvoiceData.amt = UtilSql.getValue(result, "amt");
        objectExpenseAPInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseAPInvoiceData);
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
    ExpenseAPInvoiceData objectExpenseAPInvoiceData[] = new ExpenseAPInvoiceData[vector.size()];
    vector.copyInto(objectExpenseAPInvoiceData);
    return(objectExpenseAPInvoiceData);
  }

/**
Select for relation
 */
  public static String selectLine(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(MAX(Line), 0) + 10 AS LINE" +
      "      FROM C_INVOICELINE" +
      "      WHERE C_INVOICE_ID = ?";

    ResultSet result;
    String strReturn = "10";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "line");
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
    return(strReturn);
  }

  public static String cDoctypeTarget(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT AD_GET_DOCTYPE_EXPENSES(?,?,'API',NULL) FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_doctype_expenses");
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

  public static String bPartnerLocation(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) AS ID" +
      "        FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND ISBILLTO = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static String shipto(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) AS ID" +
      "        FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND ISSHIPTO = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

/**
nt>
 */
  public static String paymentrule(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PaymentrulePO" +
      "      FROM C_BPARTNER" +
      "      WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "paymentrulepo");
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

/**
nt>
 */
  public static String paymentmethodId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT po_paymentmethod_id" +
      "      FROM C_BPARTNER" +
      "      WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "po_paymentmethod_id");
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

  public static String pricelistId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PO_PriceList_ID" +
      "      FROM C_BPartner" +
      "      WHERE C_BPartner_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "po_pricelist_id");
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

  public static ExpenseAPInvoiceData[] selectPrice(ConnectionProvider connectionProvider, String mProductID, String mPricelistId, String validfrom)    throws ServletException {
    return selectPrice(connectionProvider, mProductID, mPricelistId, validfrom, 0, 0);
  }

  public static ExpenseAPInvoiceData[] selectPrice(ConnectionProvider connectionProvider, String mProductID, String mPricelistId, String validfrom, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT Pricelist, Pricestd, Pricelimit" +
      "      FROM M_ProductPrice" +
      "      WHERE M_ProductPrice.M_Product_ID = ?" +
      "      AND M_ProductPrice.M_PriceList_Version_ID = M_Get_Pricelist_Version(?, TO_DATE(?)) ";

    ResultSet result;
    Vector<ExpenseAPInvoiceData> vector = new Vector<ExpenseAPInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);

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
        ExpenseAPInvoiceData objectExpenseAPInvoiceData = new ExpenseAPInvoiceData();
        objectExpenseAPInvoiceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectExpenseAPInvoiceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectExpenseAPInvoiceData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectExpenseAPInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseAPInvoiceData);
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
    ExpenseAPInvoiceData objectExpenseAPInvoiceData[] = new ExpenseAPInvoiceData[vector.size()];
    vector.copyInto(objectExpenseAPInvoiceData);
    return(objectExpenseAPInvoiceData);
  }

  public static String paymentterm(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PO_PaymentTerm_ID" +
      "        FROM C_BPARTNER" +
      "        WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "po_paymentterm_id");
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

  public static String mProductUomId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT_UOM_ID" +
      "        FROM M_PRODUCT_UOM" +
      "        WHERE M_PRODUCT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_uom_id");
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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String processing, String dateprinted, String isprinted, String processed, String issotrx, String isselfservice, String istaxincluded, String adClientId, String adOrgId, String cOrderId, String dateordered, String documentno, String poreference, String description, String isactive, String cDoctypetargetId, String dateinvoiced, String dateacct, String cBpartnerId, String cBpartnerLocationId, String adUserId, String mPricelistId, String cCurrencyId, String salesrepId, String isdiscountprinted, String cChargeId, String chargeamt, String paymentrule, String paymentmethodId, String cPaymenttermId, String createfrom, String generateto, String cProjectId, String cActivityId, String cCampaignId, String adOrgtrxId, String user1Id, String user2Id, String totallines, String grandtotal, String docstatus, String cDoctypeId, String copyfrom, String docaction, String posted, String createdby, String updatedby, String cCostcenterId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_Invoice" +
      "        (C_Invoice_ID, Processing, DatePrinted, IsPrinted, " +
      "         Processed, IsSOTrx, IsSelfService, IsTaxIncluded" +
      "         , AD_Client_ID, AD_Org_ID, C_Order_ID, DateOrdered" +
      "         , DocumentNo, POReference, Description, IsActive" +
      "         , C_DocTypeTarget_ID, DateInvoiced, DateAcct, TaxDate" +
      "         , C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID, M_PriceList_ID" +
      "         , C_Currency_ID, SalesRep_ID, IsDiscountPrinted, C_Charge_ID" +
      "         , ChargeAmt, PaymentRule, FIN_PaymentMethod_ID, C_PaymentTerm_ID, CreateFrom" +
      "         , GenerateTo, C_Project_ID, C_Activity_ID, C_Campaign_ID" +
      "         , AD_OrgTrx_ID, User1_ID, User2_ID, TotalLines" +
      "         , GrandTotal, DocStatus, C_DocType_ID, CopyFrom" +
      "         , DocAction, Posted, created, createdby" +
      "         , updated, updatedBy, C_Costcenter_ID, A_Asset_ID)" +
      "       VALUES (" +
      "         (?), (?), TO_DATE(?), (?)" +
      "         , (?), (?), (?), (?)" +
      "         , (?), (?), (?), TO_DATE(?)" +
      "         , (?), (?), (?), (?)" +
      "         , (?), TO_DATE(?), TO_DATE(?), TO_DATE(?)" +
      "         , (?), (?), (?), (?)" +
      "         , (?), (?), (?), (?)" +
      "         , TO_NUMBER(?), (?), (?), (?), (?)" +
      "         , (?), (?), (?), (?)" +
      "         , (?), (?), (?), TO_NUMBER(?)" +
      "         , TO_NUMBER(?), (?), (?), (?)" +
      "         , (?), (?), now(), (?)" +
      "         , now(), (?), (?), (?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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

  public static int insertLine(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cInvoiceId, String cOrderlineId, String line, String mInoutlineId, String mProductId, String cChargeId, String description, String quantityorder, String mProductUomId, String qtyinvoiced, String cUomId, String priceactual, String pricelist, String cTaxId, String linenetamt, String sResourceassignmentId, String pricestd, String pricelimit, String mOfferId, String mAttributesetinstanceId, String taxamt, String isactive, String chargeamt, String cProjectlineId, String cInvoiceDiscountId, String cInvoicelineId, String isdescription, String createdby, String updatedby, String isDeferredRevenue, String revplantype, String periodnumber, String cPeriodId, String cProjectId, String cCostcenterId, String aAssetId, String user1Id, String user2Id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_InvoiceLine" +
      "        (" +
      "          AD_Client_ID, AD_Org_ID, C_Invoice_ID, C_OrderLine_ID" +
      "          , Line, M_InOutLine_ID, M_Product_ID, C_Charge_ID" +
      "          , Description, QuantityOrder, M_Product_Uom_Id, QtyInvoiced" +
      "          , C_UOM_ID, PriceActual, PriceList, C_Tax_ID" +
      "          , LineNetAmt, S_ResourceAssignment_ID, PriceStd, PriceLimit" +
      "          , M_Offer_ID, M_AttributeSetInstance_ID, TaxAmt, IsActive" +
      "          , ChargeAmt, C_Projectline_ID, C_Invoice_Discount_ID, C_InvoiceLine_ID" +
      "          , IsDescription, created, createdby, updated, updatedBy" +
      "          , isdeferred, defplantype, periodnumber, c_period_id" +
      "          , C_Project_ID, C_Costcenter_ID, A_Asset_ID, User1_ID, User2_ID" +
      "            )" +
      "        VALUES (" +
      "          (?),  (?), (?), (?)" +
      "          , TO_NUMBER(?), (?), (?), (?)" +
      "          , (?), TO_NUMBER(?), (?), TO_NUMBER(?)" +
      "          , (?), TO_NUMBER(?), TO_NUMBER(?), (?)" +
      "          , TO_NUMBER(?), (?),  TO_NUMBER(?), TO_NUMBER(?)" +
      "          , (?), (?), TO_NUMBER(?), (?)" +
      "          , TO_NUMBER(?), (?), (?) , (?)" +
      "          , (?), now(), ?, now(), (?)" +
      "          , (?), (?), TO_NUMBER(?), (?)" +
      "          , (?), (?), (?), (?), (?)" +
      "          )";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceDiscountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isDeferredRevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, revplantype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);

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

  public static int insertInvoicelineAcctdimension(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineAcctdimension, String adClientId, String adOrgId, String isactive, String createdby, String updatedby, String cInvoicelineId, String amt, String cProjectId, String cCampaignId, String user1Id, String user2Id, String cCostcenterId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_INVOICELINE_ACCTDIMENSION(" +
      "        C_INVOICELINE_ACCTDIMENSION_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE" +
      "        , CREATED, CREATEDBY, UPDATED, UPDATEDBY" +
      "        , C_INVOICELINE_ID, AMT, C_PROJECT_ID, C_CAMPAIGN_ID" +
      "        , USER1_ID, USER2_ID, C_COSTCENTER_ID, A_ASSET_ID)" +
      "      VALUES(?, ?, ?, ?" +
      "      , now(), ?, now(), ?" +
      "      , ?, TO_NUMBER(?), ?, ?" +
      "      , ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineAcctdimension);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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

  public static int updateExpense(Connection conn, ConnectionProvider connectionProvider, String cInvoiceLineId, String sTimeExpenseLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE S_TimeExpenseLine SET C_InvoiceLine_ID = ?" +
      "        WHERE S_TimeExpenseLine_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeExpenseLineId);

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

  public static int updateInvoiceline(Connection conn, ConnectionProvider connectionProvider, String qtyinvoiced, String linenetamt, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_INVOICELINE SET QTYINVOICED = TO_NUMBER(?), LINENETAMT = TO_NUMBER(?)" +
      "        WHERE C_INVOICELINE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
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

  public static int updateAcctdimension(Connection conn, ConnectionProvider connectionProvider, String qtyinvoiced, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_INVOICELINE_ACCTDIMENSION SET AMT = TO_NUMBER(?)" +
      "      WHERE C_INVOICELINE_ACCTDIMENSION_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
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

  public static String selectCurrency(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Currency_ID" +
      "        FROM M_PriceList " +
      "        WHERE M_PriceList_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static ExpenseAPInvoiceData[] selectPrecisions(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    return selectPrecisions(connectionProvider, cCurrencyId, 0, 0);
  }

  public static ExpenseAPInvoiceData[] selectPrecisions(ConnectionProvider connectionProvider, String cCurrencyId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT STDPRECISION, PRICEPRECISION " +
      "       FROM C_CURRENCY " +
      "       WHERE C_CURRENCY_ID = ?";

    ResultSet result;
    Vector<ExpenseAPInvoiceData> vector = new Vector<ExpenseAPInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

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
        ExpenseAPInvoiceData objectExpenseAPInvoiceData = new ExpenseAPInvoiceData();
        objectExpenseAPInvoiceData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectExpenseAPInvoiceData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectExpenseAPInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseAPInvoiceData);
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
    ExpenseAPInvoiceData objectExpenseAPInvoiceData[] = new ExpenseAPInvoiceData[vector.size()];
    vector.copyInto(objectExpenseAPInvoiceData);
    return(objectExpenseAPInvoiceData);
  }

  public static String selectConvertedAmt(ConnectionProvider connectionProvider, String expenseAmount, String currencyFrom, String currencyTo, String dateExpense, String client, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_currency_convert(TO_NUMBER(?),?,?,TO_DATE(?),null, ?,?) from dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseAmount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateExpense);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_convert");
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
