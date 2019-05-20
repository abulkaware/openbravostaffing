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

class DocInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocInvoiceData.class);
  private String InitRecordNumber="0";
  public String ratetaxundeductable;
  public String orgtaxundeductable;
  public String cTaxId;
  public String name;
  public String rate;
  public String istaxdeductable;
  public String taxbaseamt;
  public String taxamt;
  public String line;
  public String cInvoiceId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String issotrx;
  public String documentno;
  public String docstatus;
  public String docaction;
  public String processing;
  public String processed;
  public String posted;
  public String cDoctypeId;
  public String cDoctypetargetId;
  public String cOrderId;
  public String description;
  public String istransferred;
  public String isprinted;
  public String salesrepId;
  public String dateinvoiced;
  public String dateprinted;
  public String dateacct;
  public String cBpartnerId;
  public String cBpartnerLocationId;
  public String poreference;
  public String isdiscountprinted;
  public String dateordered;
  public String cCurrencyId;
  public String paymentrule;
  public String cPaymenttermId;
  public String cChargeId;
  public String chargeamt;
  public String totallines;
  public String grandtotal;
  public String mPricelistId;
  public String istaxincluded;
  public String cCampaignId;
  public String cProjectId;
  public String cActivityId;
  public String ispaid;
  public String createfrom;
  public String generateto;
  public String sendemail;
  public String adUserId;
  public String copyfrom;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String amount;
  public String status;
  public String isreceipt;
  public String ismanual;
  public String writeoffamt;
  public String cDebtPaymentId;
  public String pRevenueAcct;
  public String pExpenseAcct;
  public String finPaymentScheduleId;
  public String finPaymentmethodId;
  public String prepaidamt;
  public String fininvcount;
  public String finacctcount;
  public String finPaymentId;
  public String cCostcenterId;
  public String iscashvat;
  public String prepaymentamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ratetaxundeductable"))
      return ratetaxundeductable;
    else if (fieldName.equalsIgnoreCase("orgtaxundeductable"))
      return orgtaxundeductable;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("rate"))
      return rate;
    else if (fieldName.equalsIgnoreCase("istaxdeductable"))
      return istaxdeductable;
    else if (fieldName.equalsIgnoreCase("taxbaseamt"))
      return taxbaseamt;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
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
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("istransferred"))
      return istransferred;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("sendemail"))
      return sendemail;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("p_revenue_acct") || fieldName.equals("pRevenueAcct"))
      return pRevenueAcct;
    else if (fieldName.equalsIgnoreCase("p_expense_acct") || fieldName.equals("pExpenseAcct"))
      return pExpenseAcct;
    else if (fieldName.equalsIgnoreCase("fin_payment_schedule_id") || fieldName.equals("finPaymentScheduleId"))
      return finPaymentScheduleId;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("prepaidamt"))
      return prepaidamt;
    else if (fieldName.equalsIgnoreCase("fininvcount"))
      return fininvcount;
    else if (fieldName.equalsIgnoreCase("finacctcount"))
      return finacctcount;
    else if (fieldName.equalsIgnoreCase("fin_payment_id") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("iscashvat"))
      return iscashvat;
    else if (fieldName.equalsIgnoreCase("prepaymentamt"))
      return prepaymentamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocInvoiceData[] select(ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    return select(connectionProvider, invoice, 0, 0);
  }

  public static DocInvoiceData[] select(ConnectionProvider connectionProvider, String invoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT t.IsTaxUndeductable as rateTaxUndeductable, (select IsTaxUndeductable from ad_orginfo o where o.ad_org_id=it.ad_org_id) as orgTaxUndeductable, " +
      "        it.C_Tax_ID, t.Name, t.Rate, t.IsTaxDeductable, SUM(it.TaxBaseAmt) AS TaxBaseAmt, SUM(it.TaxAmt) AS TaxAmt, min(it.line) as line, '' AS C_INVOICE_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID," +
      "        '' AS ISACTIVE, '' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS ISSOTRX, '' AS DOCUMENTNO," +
      "        '' AS DOCSTATUS, '' AS DOCACTION, '' AS PROCESSING, '' AS PROCESSED, '' AS POSTED, '' AS C_DOCTYPE_ID, '' AS C_DOCTYPETARGET_ID," +
      "        '' AS C_ORDER_ID, '' AS DESCRIPTION, '' AS ISTRANSFERRED, '' AS ISPRINTED, '' AS SALESREP_ID, '' AS DATEINVOICED," +
      "        '' AS DATEPRINTED, '' AS DATEACCT, '' AS C_BPARTNER_ID, '' AS C_BPARTNER_LOCATION_ID, '' AS POREFERENCE, '' AS ISDISCOUNTPRINTED," +
      "        '' AS DATEORDERED, '' AS C_CURRENCY_ID, '' AS PAYMENTRULE, '' AS C_PAYMENTTERM_ID, '' AS C_CHARGE_ID, '' AS CHARGEAMT, '' AS TOTALLINES," +
      "        '' AS GRANDTOTAL, '' AS M_PRICELIST_ID, '' AS ISTAXINCLUDED, '' AS C_CAMPAIGN_ID, '' AS C_PROJECT_ID, '' AS C_ACTIVITY_ID," +
      "        '' AS ISPAID, '' AS CREATEFROM, '' AS GENERATETO, '' AS SENDEMAIL, '' AS AD_USER_ID, '' AS COPYFROM, '' AS ISSELFSERVICE," +
      "        '' AS AD_ORGTRX_ID, '' AS USER1_ID, '' AS USER2_ID, '' as AMOUNT, '' AS STATUS, '' AS ISRECEIPT, '' AS ISMANUAL, '' AS WRITEOFFAMT," +
      "        '' AS C_DEBT_PAYMENT_ID, '' AS P_REVENUE_ACCT, '' AS P_EXPENSE_ACCT, '' as FIN_PAYMENT_SCHEDULE_ID, '' as FIN_PAYMENTMETHOD_ID, '' AS PREPAIDAMT, " +
      "        '' AS FININVCOUNT, '' AS FINACCTCOUNT, '' AS FIN_PAYMENT_ID, '' AS C_COSTCENTER_ID, t.isCashVAT AS ISCASHVAT, '' AS PREPAYMENTAMT" +
      "        FROM C_Tax t, C_InvoiceTax it" +
      "        WHERE t.C_Tax_ID=it.C_Tax_ID AND it.C_Invoice_ID=?" +
      "	GROUP BY t.IsTaxUndeductable, it.C_Tax_ID, t.Name, t.Rate, t.IsTaxDeductable, it.ad_org_id, t.isCashVAT" +
      "	order by line";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.ratetaxundeductable = UtilSql.getValue(result, "ratetaxundeductable");
        objectDocInvoiceData.orgtaxundeductable = UtilSql.getValue(result, "orgtaxundeductable");
        objectDocInvoiceData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocInvoiceData.name = UtilSql.getValue(result, "name");
        objectDocInvoiceData.rate = UtilSql.getValue(result, "rate");
        objectDocInvoiceData.istaxdeductable = UtilSql.getValue(result, "istaxdeductable");
        objectDocInvoiceData.taxbaseamt = UtilSql.getValue(result, "taxbaseamt");
        objectDocInvoiceData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocInvoiceData.line = UtilSql.getValue(result, "line");
        objectDocInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocInvoiceData.isactive = UtilSql.getValue(result, "isactive");
        objectDocInvoiceData.created = UtilSql.getValue(result, "created");
        objectDocInvoiceData.createdby = UtilSql.getValue(result, "createdby");
        objectDocInvoiceData.updated = UtilSql.getValue(result, "updated");
        objectDocInvoiceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocInvoiceData.issotrx = UtilSql.getValue(result, "issotrx");
        objectDocInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectDocInvoiceData.docstatus = UtilSql.getValue(result, "docstatus");
        objectDocInvoiceData.docaction = UtilSql.getValue(result, "docaction");
        objectDocInvoiceData.processing = UtilSql.getValue(result, "processing");
        objectDocInvoiceData.processed = UtilSql.getValue(result, "processed");
        objectDocInvoiceData.posted = UtilSql.getValue(result, "posted");
        objectDocInvoiceData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocInvoiceData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectDocInvoiceData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectDocInvoiceData.description = UtilSql.getValue(result, "description");
        objectDocInvoiceData.istransferred = UtilSql.getValue(result, "istransferred");
        objectDocInvoiceData.isprinted = UtilSql.getValue(result, "isprinted");
        objectDocInvoiceData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectDocInvoiceData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectDocInvoiceData.dateprinted = UtilSql.getValue(result, "dateprinted");
        objectDocInvoiceData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocInvoiceData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocInvoiceData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectDocInvoiceData.poreference = UtilSql.getValue(result, "poreference");
        objectDocInvoiceData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectDocInvoiceData.dateordered = UtilSql.getValue(result, "dateordered");
        objectDocInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocInvoiceData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectDocInvoiceData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectDocInvoiceData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocInvoiceData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocInvoiceData.totallines = UtilSql.getValue(result, "totallines");
        objectDocInvoiceData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectDocInvoiceData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectDocInvoiceData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectDocInvoiceData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocInvoiceData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocInvoiceData.ispaid = UtilSql.getValue(result, "ispaid");
        objectDocInvoiceData.createfrom = UtilSql.getValue(result, "createfrom");
        objectDocInvoiceData.generateto = UtilSql.getValue(result, "generateto");
        objectDocInvoiceData.sendemail = UtilSql.getValue(result, "sendemail");
        objectDocInvoiceData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectDocInvoiceData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectDocInvoiceData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectDocInvoiceData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocInvoiceData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocInvoiceData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocInvoiceData.amount = UtilSql.getValue(result, "amount");
        objectDocInvoiceData.status = UtilSql.getValue(result, "status");
        objectDocInvoiceData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectDocInvoiceData.ismanual = UtilSql.getValue(result, "ismanual");
        objectDocInvoiceData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectDocInvoiceData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDocInvoiceData.pRevenueAcct = UtilSql.getValue(result, "p_revenue_acct");
        objectDocInvoiceData.pExpenseAcct = UtilSql.getValue(result, "p_expense_acct");
        objectDocInvoiceData.finPaymentScheduleId = UtilSql.getValue(result, "fin_payment_schedule_id");
        objectDocInvoiceData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectDocInvoiceData.prepaidamt = UtilSql.getValue(result, "prepaidamt");
        objectDocInvoiceData.fininvcount = UtilSql.getValue(result, "fininvcount");
        objectDocInvoiceData.finacctcount = UtilSql.getValue(result, "finacctcount");
        objectDocInvoiceData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectDocInvoiceData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocInvoiceData.iscashvat = UtilSql.getValue(result, "iscashvat");
        objectDocInvoiceData.prepaymentamt = UtilSql.getValue(result, "prepaymentamt");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocInvoiceData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT I.AD_CLIENT_ID, I.AD_ORG_ID, I.C_BPARTNER_ID, I.AD_ORGTRX_ID, I.C_PROJECT_ID," +
      "        I.C_CAMPAIGN_ID, I.C_ACTIVITY_ID, I.C_COSTCENTER_ID, I.USER1_ID, I.USER2_ID, I.DOCUMENTNO, I.DATEACCT," +
      "        I.C_CURRENCY_ID, I.C_DOCTYPE_ID, I.C_CHARGE_ID, I.CHARGEAMT, I.POSTED, I.DATEINVOICED," +
      "        I.ISTAXINCLUDED, I.C_BPARTNER_LOCATION_ID, I.GRANDTOTAL, I.TOTALLINES, I.CHARGEAMT," +
      "        I.ISCASHVAT, I.PREPAYMENTAMT" +
      "        FROM C_INVOICE I" +
      "        WHERE AD_Client_ID=?" +
      "        AND C_INVOICE_ID=?";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocInvoiceData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocInvoiceData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocInvoiceData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocInvoiceData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocInvoiceData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocInvoiceData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocInvoiceData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectDocInvoiceData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocInvoiceData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocInvoiceData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocInvoiceData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocInvoiceData.posted = UtilSql.getValue(result, "posted");
        objectDocInvoiceData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectDocInvoiceData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectDocInvoiceData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectDocInvoiceData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectDocInvoiceData.totallines = UtilSql.getValue(result, "totallines");
        objectDocInvoiceData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocInvoiceData.iscashvat = UtilSql.getValue(result, "iscashvat");
        objectDocInvoiceData.prepaymentamt = UtilSql.getValue(result, "prepaymentamt");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] getIsReversedInvoice(ConnectionProvider connectionProvider, String id)    throws ServletException {
    return getIsReversedInvoice(connectionProvider, id, 0, 0);
  }

  public static DocInvoiceData[] getIsReversedInvoice(ConnectionProvider connectionProvider, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_INVOICE_ID" +
      "        FROM C_INVOICE_REVERSE" +
      "        WHERE C_INVOICE_ID=?";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] selectDebtPayments(ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    return selectDebtPayments(connectionProvider, invoice, 0, 0);
  }

  public static DocInvoiceData[] selectDebtPayments(ConnectionProvider connectionProvider, String invoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (AMOUNT + coalesce(WITHHOLDINGAMOUNT,0)) AS AMOUNT, C_CURRENCY_ID, STATUS_INITIAL AS STATUS, ISRECEIPT, ISPAID, ISMANUAL, WRITEOFFAMT, C_DEBT_PAYMENT_ID" +
      "      FROM C_DEBT_PAYMENT" +
      "      WHERE C_INVOICE_ID =?";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.amount = UtilSql.getValue(result, "amount");
        objectDocInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocInvoiceData.status = UtilSql.getValue(result, "status");
        objectDocInvoiceData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectDocInvoiceData.ispaid = UtilSql.getValue(result, "ispaid");
        objectDocInvoiceData.ismanual = UtilSql.getValue(result, "ismanual");
        objectDocInvoiceData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectDocInvoiceData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] selectPayments(ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    return selectPayments(connectionProvider, invoice, 0, 0);
  }

  public static DocInvoiceData[] selectPayments(ConnectionProvider connectionProvider, String invoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SUM(CASE WHEN ISPREPAYMENT = 'Y' THEN 0 ELSE (FIN_PAYMENT_SCHEDULEDETAIL.AMOUNT + FIN_PAYMENT_SCHEDULEDETAIL.WRITEOFFAMT) END) AS AMOUNT,  CASE WHEN (FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_SCHEDULE_ORDER IS NOT NULL " +
      "                        AND COALESCE(FIN_PAYMENT_DETAIL.ISPREPAYMENT,'N') = 'Y') THEN FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_SCHEDULE_ORDER ELSE FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_SCHEDULE_INVOICE END as FIN_PAYMENT_SCHEDULE_ID, " +
      "        FIN_PAYMENT_SCHEDULE.C_CURRENCY_ID, SUM(CASE WHEN ISPREPAYMENT = 'Y' THEN (FIN_PAYMENT_SCHEDULEDETAIL.AMOUNT + FIN_PAYMENT_SCHEDULEDETAIL.WRITEOFFAMT) ELSE 0 END) AS PREPAIDAMT" +
      "        FROM FIN_PAYMENT_SCHEDULE" +
      "        LEFT JOIN FIN_PAYMENT_SCHEDULEDETAIL ON FIN_PAYMENT_SCHEDULE.FIN_PAYMENT_SCHEDULE_ID = FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_SCHEDULE_INVOICE" +
      "        LEFT JOIN FIN_PAYMENT_DETAIL ON FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_DETAIL_ID = FIN_PAYMENT_DETAIL.FIN_PAYMENT_DETAIL_ID" +
      "        WHERE FIN_PAYMENT_SCHEDULE.C_INVOICE_ID =?" +
      "        AND FIN_PAYMENT_SCHEDULEDETAIL.ISCANCELED = 'N'" +
      "        GROUP BY CASE WHEN (FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_SCHEDULE_ORDER IS NOT NULL " +
      "                        AND COALESCE(FIN_PAYMENT_DETAIL.ISPREPAYMENT,'N') = 'Y') THEN FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_SCHEDULE_ORDER ELSE FIN_PAYMENT_SCHEDULEDETAIL.FIN_PAYMENT_SCHEDULE_INVOICE END, " +
      "                        FIN_PAYMENT_SCHEDULE.C_CURRENCY_ID" +
      "        ORDER BY AMOUNT DESC";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.amount = UtilSql.getValue(result, "amount");
        objectDocInvoiceData.finPaymentScheduleId = UtilSql.getValue(result, "fin_payment_schedule_id");
        objectDocInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocInvoiceData.prepaidamt = UtilSql.getValue(result, "prepaidamt");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] selectPrepayments(ConnectionProvider connectionProvider, String paymentSchedule, String invoiceId)    throws ServletException {
    return selectPrepayments(connectionProvider, paymentSchedule, invoiceId, 0, 0);
  }

  public static DocInvoiceData[] selectPrepayments(ConnectionProvider connectionProvider, String paymentSchedule, String invoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT PSDO.AMOUNT AS PREPAIDAMT, PD.FIN_PAYMENT_ID" +
      "    FROM FIN_PAYMENT_SCHEDULE FPSO" +
      "    INNER JOIN FIN_PAYMENT_SCHEDULEDETAIL PSDO ON FPSO.FIN_PAYMENT_SCHEDULE_ID = PSDO.FIN_PAYMENT_SCHEDULE_ORDER" +
      "    INNER JOIN FIN_PAYMENT_SCHEDULE FPSI ON PSDO.FIN_PAYMENT_SCHEDULE_INVOICE = FPSI.FIN_PAYMENT_SCHEDULE_ID" +
      "    INNER JOIN FIN_PAYMENT_DETAIL PD ON PSDO.FIN_PAYMENT_DETAIL_ID = PD.FIN_PAYMENT_DETAIL_ID" +
      "    WHERE COALESCE(PD.ISPREPAYMENT,'N') = 'Y'" +
      "    AND PSDO.ISCANCELED = 'N'" +
      "    AND FPSO.FIN_PAYMENT_SCHEDULE_ID = ?" +
      "    AND FPSI.C_INVOICE_ID = ?";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentSchedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);

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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.prepaidamt = UtilSql.getValue(result, "prepaidamt");
        objectDocInvoiceData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] selectProductAcct(ConnectionProvider connectionProvider, String acctSchemaId, String taxId, String invoiceId, String productId)    throws ServletException {
    return selectProductAcct(connectionProvider, acctSchemaId, taxId, invoiceId, productId, 0, 0);
  }

  public static DocInvoiceData[] selectProductAcct(ConnectionProvider connectionProvider, String acctSchemaId, String taxId, String invoiceId, String productId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT a.P_Revenue_Acct, a.P_Expense_Acct, t.TaxAmt" +
      "        FROM M_Product_Acct a, C_InvoiceLineTax t, C_InvoiceLine l, M_Product p" +
      "        WHERE t.C_InvoiceLine_Id = l.C_InvoiceLine_Id" +
      "        AND l.M_Product_Id = p.M_Product_Id" +
      "        AND p.M_Product_Id = a.M_Product_Id" +
      "        AND a.C_AcctSchema_Id = ?" +
      "        AND t.C_Tax_Id = ?" +
      "        AND t.C_Invoice_Id = ?" +
      "        AND 1=1";
    strSql = strSql + ((productId==null || productId.equals(""))?"":"  AND p.M_Product_Id = ? ");

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);
      if (productId != null && !(productId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);
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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.pRevenueAcct = UtilSql.getValue(result, "p_revenue_acct");
        objectDocInvoiceData.pExpenseAcct = UtilSql.getValue(result, "p_expense_acct");
        objectDocInvoiceData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static int updateProductPO(Connection conn, ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_Product_PO SET PriceLastInv =" +
      "                (SELECT AVG(C_Currency_Convert(il.PriceActual,i.C_Currency_ID,M_Product_PO.C_Currency_ID,i.DateInvoiced,null,i.AD_Client_ID,i.AD_Org_ID))" +
      "                FROM C_Invoice i, C_InvoiceLine il" +
      "                WHERE i.C_Invoice_ID=il.C_Invoice_ID" +
      "                AND M_Product_PO.M_Product_ID=il.M_Product_ID" +
      "                AND M_Product_PO.C_BPartner_ID=i.C_BPartner_ID" +
      "                AND i.C_Invoice_ID=?)" +
      "        WHERE EXISTS (SELECT *" +
      "        FROM C_Invoice i, C_InvoiceLine il" +
      "        WHERE i.C_Invoice_ID=il.C_Invoice_ID" +
      "        AND M_Product_PO.M_Product_ID=il.M_Product_ID" +
      "        AND M_Product_PO.C_BPartner_ID=i.C_BPartner_ID" +
      "        AND i.C_Invoice_ID=?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

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

  public static DocInvoiceData[] selectGLItemAcctForTaxLine(ConnectionProvider connectionProvider, String acctSchemaId, String taxId, String invoiceId)    throws ServletException {
    return selectGLItemAcctForTaxLine(connectionProvider, acctSchemaId, taxId, invoiceId, 0, 0);
  }

  public static DocInvoiceData[] selectGLItemAcctForTaxLine(ConnectionProvider connectionProvider, String acctSchemaId, String taxId, String invoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT a.GLITEM_CREDIT_ACCT AS P_REVENUE_ACCT, a.GLITEM_DEBIT_ACCT AS P_EXPENSE_ACCT, t.TaxAmt" +
      "    FROM C_GLITEM_ACCT a, C_InvoiceLineTax t, C_InvoiceLine l" +
      "    WHERE t.C_InvoiceLine_Id = l.C_InvoiceLine_Id " +
      "    AND l.Account_ID = a.C_GLITEM_id" +
      "    AND a.C_ACCTSCHEMA_id = ?" +
      "    AND t.C_Tax_Id= ? " +
      "    AND t.C_Invoice_Id= ? ";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);

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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.pRevenueAcct = UtilSql.getValue(result, "p_revenue_acct");
        objectDocInvoiceData.pExpenseAcct = UtilSql.getValue(result, "p_expense_acct");
        objectDocInvoiceData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] getTaxLineCount(ConnectionProvider connectionProvider, String taxId, String invoiceId)    throws ServletException {
    return getTaxLineCount(connectionProvider, taxId, invoiceId, 0, 0);
  }

  public static DocInvoiceData[] getTaxLineCount(ConnectionProvider connectionProvider, String taxId, String invoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT count(*) as TOTALLINES" +
      "    FROM C_InvoiceLineTax" +
      "    WHERE C_Tax_Id= ? " +
      "    AND C_Invoice_Id= ? ";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);

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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.totallines = UtilSql.getValue(result, "totallines");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }

  public static DocInvoiceData[] selectFinInvCount(ConnectionProvider connectionProvider, String invoiceId, String acctschemaId)    throws ServletException {
    return selectFinInvCount(connectionProvider, invoiceId, acctschemaId, 0, 0);
  }

  public static DocInvoiceData[] selectFinInvCount(ConnectionProvider connectionProvider, String invoiceId, String acctschemaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (SELECT count(distinct account_id)" +
      "                FROM c_invoiceline" +
      "                WHERE financial_invoice_line='Y'" +
      "                      AND c_invoice_id = ?) AS FININVCOUNT," +
      "               (SELECT count(distinct glact.c_glitem_id)" +
      "                FROM c_invoiceline invline JOIN c_glitem_acct glact ON (invline.account_id = glact.c_glitem_id)" +
      "                     JOIN c_acctschema acctschema on (glact.c_acctschema_id = acctschema.c_acctschema_id)" +
      "                WHERE invline.financial_invoice_line = 'Y' AND" +
      "                      invline.c_invoice_id = ? AND" +
      "                      acctschema.c_acctschema_id = ? AND" +
      "                      glact.glitem_debit_acct IS NOT NULL AND " +
      "                      glact.glitem_credit_acct IS NOT NULL) AS FINACCTCOUNT" +
      "        FROM DUAL";

    ResultSet result;
    Vector<DocInvoiceData> vector = new Vector<DocInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschemaId);

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
        DocInvoiceData objectDocInvoiceData = new DocInvoiceData();
        objectDocInvoiceData.fininvcount = UtilSql.getValue(result, "fininvcount");
        objectDocInvoiceData.finacctcount = UtilSql.getValue(result, "finacctcount");
        objectDocInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInvoiceData);
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
    DocInvoiceData objectDocInvoiceData[] = new DocInvoiceData[vector.size()];
    vector.copyInto(objectDocInvoiceData);
    return(objectDocInvoiceData);
  }
}
