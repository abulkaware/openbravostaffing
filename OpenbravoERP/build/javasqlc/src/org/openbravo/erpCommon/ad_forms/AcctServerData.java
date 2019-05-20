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

class AcctServerData implements FieldProvider {
static Logger log4j = Logger.getLogger(AcctServerData.class);
  private String InitRecordNumber="0";
  public String id;
  public String docbasetype;
  public String glCategoryId;
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
  public String cPaymentId;
  public String cCashlineId;
  public String createfrom;
  public String generateto;
  public String sendemail;
  public String adUserId;
  public String copyfrom;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String converted;
  public String period;
  public String cInvoicelineId;
  public String mInoutlineId;
  public String mProductId;
  public String datetrx1;
  public String datetrx2;
  public String qty1;
  public String qty2;
  public String accountId;
  public String cInvoiceId;
  public String name;
  public String classname;
  public String acctdatecolumn;
  public String tablename;
  public String acctclassname;
  public String isreversal;
  public String isreturn;
  public String da;
  public String rn1;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("gl_category_id") || fieldName.equals("glCategoryId"))
      return glCategoryId;
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
    else if (fieldName.equalsIgnoreCase("c_payment_id") || fieldName.equals("cPaymentId"))
      return cPaymentId;
    else if (fieldName.equalsIgnoreCase("c_cashline_id") || fieldName.equals("cCashlineId"))
      return cCashlineId;
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
    else if (fieldName.equalsIgnoreCase("converted"))
      return converted;
    else if (fieldName.equalsIgnoreCase("period"))
      return period;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("datetrx1"))
      return datetrx1;
    else if (fieldName.equalsIgnoreCase("datetrx2"))
      return datetrx2;
    else if (fieldName.equalsIgnoreCase("qty1"))
      return qty1;
    else if (fieldName.equalsIgnoreCase("qty2"))
      return qty2;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("classname"))
      return classname;
    else if (fieldName.equalsIgnoreCase("acctdatecolumn"))
      return acctdatecolumn;
    else if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
    else if (fieldName.equalsIgnoreCase("acctclassname"))
      return acctclassname;
    else if (fieldName.equalsIgnoreCase("isreversal"))
      return isreversal;
    else if (fieldName.equalsIgnoreCase("isreturn"))
      return isreturn;
    else if (fieldName.equalsIgnoreCase("da"))
      return da;
    else if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AcctServerData[] select(ConnectionProvider connectionProvider, String tableName, String dateColumn, String client, String StrOrg, String dateFrom, String dateTo, String limit)    throws ServletException {
    return select(connectionProvider, tableName, dateColumn, client, StrOrg, dateFrom, dateTo, limit, 0, 0);
  }

  public static AcctServerData[] select(ConnectionProvider connectionProvider, String tableName, String dateColumn, String client, String StrOrg, String dateFrom, String dateTo, String limit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	      Select * from(" +
      "        SELECT  a.";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      "_ID AS ID, '' AS DOCBASETYPE, '' AS GL_CATEGORY_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID, '' AS ISACTIVE," +
      "        '' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS ISSOTRX, '' AS DOCUMENTNO, '' AS DOCSTATUS," +
      "        '' AS DOCACTION, '' AS PROCESSING, '' AS PROCESSED, '' AS POSTED, '' AS C_DOCTYPE_ID, '' AS C_DOCTYPETARGET_ID," +
      "        '' AS C_ORDER_ID, '' AS DESCRIPTION, '' AS ISTRANSFERRED, '' AS ISPRINTED, '' AS SALESREP_ID," +
      "        '' AS DATEINVOICED, '' AS DATEPRINTED, '' AS DATEACCT, '' AS C_BPARTNER_ID, '' AS C_BPARTNER_LOCATION_ID, '' AS POREFERENCE," +
      "        '' AS ISDISCOUNTPRINTED, '' AS DATEORDERED, '' AS C_CURRENCY_ID, '' AS PAYMENTRULE, '' AS C_PAYMENTTERM_ID," +
      "        '' AS C_CHARGE_ID, '' AS CHARGEAMT, '' AS TOTALLINES, '' AS GRANDTOTAL, '' AS M_PRICELIST_ID, '' AS ISTAXINCLUDED," +
      "        '' AS C_CAMPAIGN_ID, '' AS C_PROJECT_ID, '' AS C_ACTIVITY_ID, '' AS ISPAID, '' AS C_PAYMENT_ID, '' AS C_CASHLINE_ID," +
      "        '' AS CREATEFROM, '' AS GENERATETO, '' AS SENDEMAIL, '' AS AD_USER_ID, '' AS COPYFROM, '' AS ISSELFSERVICE, '' AS AD_ORGTRX_ID," +
      "        '' AS USER1_ID, '' AS USER2_ID, '' AS CONVERTED, '' AS PERIOD, '' AS C_INVOICELINE_ID,'' AS M_INOUTLINE_ID, '' AS M_PRODUCT_ID," +
      "        '' AS DATETRX1, '' AS DATETRX2, '' AS QTY1, '' AS QTY2, '' AS ACCOUNT_ID, '' AS C_INVOICE_ID, '' AS NAME, '' AS CLASSNAME," +
      "        '' AS ACCTDATECOLUMN, '' AS TABLENAME, '' AS ACCTCLASSNAME, '' as ISREVERSAL, '' as ISRETURN,   a.";
    strSql = strSql + ((dateColumn==null || dateColumn.equals(""))?"":dateColumn);
    strSql = strSql + 
      " as da, '' AS RN1" +
      "        FROM ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " a WHERE a.AD_CLIENT_ID=?" +
      "        and a.ad_org_id in (";
    strSql = strSql + ((StrOrg==null || StrOrg.equals(""))?"":StrOrg);
    strSql = strSql + 
      ")" +
      "        AND PROCESSED='Y'" +
      "        AND (PROCESSING='N' OR PROCESSING IS NULL)" +
      "        AND POSTED='N') A" +
      "        where 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND a.da >= TO_DATE(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND a.da <= TO_DATE(?) ");
    strSql = strSql + 
      "        AND 2=2 ";
    strSql = strSql + ((limit==null || limit.equals(""))?"":limit);

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (dateColumn != null && !(dateColumn.equals(""))) {
        }
      if (tableName != null && !(tableName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      if (StrOrg != null && !(StrOrg.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (limit != null && !(limit.equals(""))) {
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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.id = UtilSql.getValue(result, "id");
        objectAcctServerData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectAcctServerData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectAcctServerData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAcctServerData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAcctServerData.isactive = UtilSql.getValue(result, "isactive");
        objectAcctServerData.created = UtilSql.getValue(result, "created");
        objectAcctServerData.createdby = UtilSql.getValue(result, "createdby");
        objectAcctServerData.updated = UtilSql.getValue(result, "updated");
        objectAcctServerData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAcctServerData.issotrx = UtilSql.getValue(result, "issotrx");
        objectAcctServerData.documentno = UtilSql.getValue(result, "documentno");
        objectAcctServerData.docstatus = UtilSql.getValue(result, "docstatus");
        objectAcctServerData.docaction = UtilSql.getValue(result, "docaction");
        objectAcctServerData.processing = UtilSql.getValue(result, "processing");
        objectAcctServerData.processed = UtilSql.getValue(result, "processed");
        objectAcctServerData.posted = UtilSql.getValue(result, "posted");
        objectAcctServerData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectAcctServerData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectAcctServerData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectAcctServerData.description = UtilSql.getValue(result, "description");
        objectAcctServerData.istransferred = UtilSql.getValue(result, "istransferred");
        objectAcctServerData.isprinted = UtilSql.getValue(result, "isprinted");
        objectAcctServerData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectAcctServerData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectAcctServerData.dateprinted = UtilSql.getValue(result, "dateprinted");
        objectAcctServerData.dateacct = UtilSql.getValue(result, "dateacct");
        objectAcctServerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAcctServerData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectAcctServerData.poreference = UtilSql.getValue(result, "poreference");
        objectAcctServerData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectAcctServerData.dateordered = UtilSql.getValue(result, "dateordered");
        objectAcctServerData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectAcctServerData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectAcctServerData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectAcctServerData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectAcctServerData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectAcctServerData.totallines = UtilSql.getValue(result, "totallines");
        objectAcctServerData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectAcctServerData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectAcctServerData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectAcctServerData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectAcctServerData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAcctServerData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectAcctServerData.ispaid = UtilSql.getValue(result, "ispaid");
        objectAcctServerData.cPaymentId = UtilSql.getValue(result, "c_payment_id");
        objectAcctServerData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectAcctServerData.createfrom = UtilSql.getValue(result, "createfrom");
        objectAcctServerData.generateto = UtilSql.getValue(result, "generateto");
        objectAcctServerData.sendemail = UtilSql.getValue(result, "sendemail");
        objectAcctServerData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAcctServerData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectAcctServerData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectAcctServerData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectAcctServerData.user1Id = UtilSql.getValue(result, "user1_id");
        objectAcctServerData.user2Id = UtilSql.getValue(result, "user2_id");
        objectAcctServerData.converted = UtilSql.getValue(result, "converted");
        objectAcctServerData.period = UtilSql.getValue(result, "period");
        objectAcctServerData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectAcctServerData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectAcctServerData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAcctServerData.datetrx1 = UtilSql.getValue(result, "datetrx1");
        objectAcctServerData.datetrx2 = UtilSql.getValue(result, "datetrx2");
        objectAcctServerData.qty1 = UtilSql.getValue(result, "qty1");
        objectAcctServerData.qty2 = UtilSql.getValue(result, "qty2");
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectAcctServerData.name = UtilSql.getValue(result, "name");
        objectAcctServerData.classname = UtilSql.getValue(result, "classname");
        objectAcctServerData.acctdatecolumn = UtilSql.getValue(result, "acctdatecolumn");
        objectAcctServerData.tablename = UtilSql.getValue(result, "tablename");
        objectAcctServerData.acctclassname = UtilSql.getValue(result, "acctclassname");
        objectAcctServerData.isreversal = UtilSql.getValue(result, "isreversal");
        objectAcctServerData.isreturn = UtilSql.getValue(result, "isreturn");
        objectAcctServerData.da = UtilSql.getDateValue(result, "da", "dd-MM-yyyy");
        objectAcctServerData.rn1 = UtilSql.getValue(result, "rn1");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static int update(ConnectionProvider connectionProvider, String tableName, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " SET Processing='Y'" +
      "        WHERE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      "_ID = ?" +
      "        AND Processed='Y'" +
      "        AND (Processing='N' OR Processing IS NULL)" +
      "        AND Posted<>'Y'";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (tableName != null && !(tableName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static AcctServerData[] selectDocType(ConnectionProvider connectionProvider, String docType)    throws ServletException {
    return selectDocType(connectionProvider, docType, 0, 0);
  }

  public static AcctServerData[] selectDocType(ConnectionProvider connectionProvider, String docType, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DocBaseType, GL_Category_ID, IsReversal, IsReturn FROM C_DocType WHERE C_DocType_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docType);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectAcctServerData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectAcctServerData.isreversal = UtilSql.getValue(result, "isreversal");
        objectAcctServerData.isreturn = UtilSql.getValue(result, "isreturn");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectGLCategory(ConnectionProvider connectionProvider, String client, String DocBaseType)    throws ServletException {
    return selectGLCategory(connectionProvider, client, DocBaseType, 0, 0);
  }

  public static AcctServerData[] selectGLCategory(ConnectionProvider connectionProvider, String client, String DocBaseType, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT GL_Category_ID, IsReversal FROM C_DocType WHERE AD_Client_ID=? AND DocBaseType=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DocBaseType);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectAcctServerData.isreversal = UtilSql.getValue(result, "isreversal");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectDefaultGLCategory(ConnectionProvider connectionProvider, String client)    throws ServletException {
    return selectDefaultGLCategory(connectionProvider, client, 0, 0);
  }

  public static AcctServerData[] selectDefaultGLCategory(ConnectionProvider connectionProvider, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT GL_Category_ID FROM GL_Category" +
      "        WHERE AD_Client_ID=?" +
      "        ORDER BY IsDefault DESC";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static int delete(ConnectionProvider connectionProvider, String Table, String Record)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM Fact_Acct WHERE AD_Table_ID = ? AND Record_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Table);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Record);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static AcctServerData[] currencyConvert(ConnectionProvider connectionProvider, String Amt, String CurFrom_ID, String CurTo_ID, String Date, String RateType, String client, String org)    throws ServletException {
    return currencyConvert(connectionProvider, Amt, CurFrom_ID, CurTo_ID, Date, RateType, client, org, 0, 0);
  }

  public static AcctServerData[] currencyConvert(ConnectionProvider connectionProvider, String Amt, String CurFrom_ID, String CurTo_ID, String Date, String RateType, String client, String org, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Currency_Convert(TO_NUMBER(?), ?, ?,TO_DATE(?),TO_CHAR(?), ?, ?) AS CONVERTED FROM DUAL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Amt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CurFrom_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CurTo_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, RateType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.converted = UtilSql.getValue(result, "converted");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] currencyConvertionRate(ConnectionProvider connectionProvider, String CurFrom_ID, String CurTo_ID, String Date, String RateType, String client, String org)    throws ServletException {
    return currencyConvertionRate(connectionProvider, CurFrom_ID, CurTo_ID, Date, RateType, client, org, 0, 0);
  }

  public static AcctServerData[] currencyConvertionRate(ConnectionProvider connectionProvider, String CurFrom_ID, String CurTo_ID, String Date, String RateType, String client, String org, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency_Rate(?, ?,TO_DATE(?),TO_CHAR(?), ?, ?) AS CONVERTED FROM DUAL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CurFrom_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CurTo_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, RateType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.converted = UtilSql.getValue(result, "converted");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] periodOpen(ConnectionProvider connectionProvider, String AD_Client_ID, String DocumentType, String Org, String DateAcct)    throws ServletException {
    return periodOpen(connectionProvider, AD_Client_ID, DocumentType, Org, DateAcct, 0, 0);
  }

  public static AcctServerData[] periodOpen(ConnectionProvider connectionProvider, String AD_Client_ID, String DocumentType, String Org, String DateAcct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select max(c_period.c_period_id) as period" +
      "      from c_period, c_periodcontrol" +
      "      where c_period.c_period_id = c_periodcontrol.c_period_id" +
      "      and c_period.ad_client_id = ?" +
      "      and c_periodcontrol.docbasetype = ?" +
      "      and c_periodcontrol.periodstatus = 'O'" +
      "      and c_period.periodtype <> 'A'" +
      "      and c_periodcontrol.ad_org_id = ad_org_getcalendarowner(?)" +
      "      and to_date(?) >= c_period.StartDate" +
      "      and to_date(?) < c_period.EndDate + 1";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DocumentType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateAcct);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.period = UtilSql.getValue(result, "period");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectPeriodOpen(ConnectionProvider connectionProvider, String AD_Client_ID, String DocumentType, String Org, String DateAcct)    throws ServletException {
    return selectPeriodOpen(connectionProvider, AD_Client_ID, DocumentType, Org, DateAcct, 0, 0);
  }

  public static AcctServerData[] selectPeriodOpen(ConnectionProvider connectionProvider, String AD_Client_ID, String DocumentType, String Org, String DateAcct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select max(c_period.c_period_id) as period" +
      "      from c_period, c_periodcontrol" +
      "      where c_period.c_period_id = c_periodcontrol.c_period_id" +
      "      and c_period.ad_client_id = ?" +
      "      and c_periodcontrol.docbasetype = ?" +
      "      and c_periodcontrol.periodstatus = 'O'" +
      "      and c_period.periodtype <> 'A'" +
      "      and c_periodcontrol.ad_org_id = ?" +
      "      and to_date(?) >= c_period.StartDate" +
      "      and to_date(?) < c_period.EndDate + 1";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DocumentType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateAcct);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.period = UtilSql.getValue(result, "period");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static int updateUnlock(ConnectionProvider connectionProvider, String tableName, String Record_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " SET Processing='N'" +
      "        WHERE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      "_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (tableName != null && !(tableName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Record_ID);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int updateSave(ConnectionProvider connectionProvider, String tableName, String status, String adUserID, String Record_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " SET Posted= ? ,Processing='N', updated=now(), updatedby=?" +
      "        WHERE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      "_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tableName != null && !(tableName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserID);
      if (tableName != null && !(tableName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Record_ID);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static AcctServerData[] selectMatch(ConnectionProvider connectionProvider, String AD_Client_ID)    throws ServletException {
    return selectMatch(connectionProvider, AD_Client_ID, 0, 0);
  }

  public static AcctServerData[] selectMatch(ConnectionProvider connectionProvider, String AD_Client_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m1.AD_Client_ID,m2.AD_Org_ID,m1.C_InvoiceLine_ID,m2.M_InOutLine_ID,m1.M_Product_ID," +
      "        m1.DateTrx as datetrx1,m2.DateTrx as datetrx2, m1.Qty as qty1, m2.Qty as qty2" +
      "        FROM M_MatchPO m1, M_MatchPO m2" +
      "        WHERE m1.C_OrderLine_ID=m2.C_OrderLine_ID" +
      "        AND m1.M_InOutLine_ID IS NULL" +
      "        AND m2.C_InvoiceLine_ID IS NULL" +
      "        AND m1.M_Product_ID=m2.M_Product_ID" +
      "        AND m1.AD_Client_ID=?" +
      "        AND NOT EXISTS (SELECT * FROM M_MatchInv mi" +
      "        WHERE mi.C_InvoiceLine_ID=m1.C_InvoiceLine_ID AND mi.M_InOutLine_ID=m2.M_InOutLine_ID)";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAcctServerData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAcctServerData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectAcctServerData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectAcctServerData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAcctServerData.datetrx1 = UtilSql.getDateValue(result, "datetrx1", "dd-MM-yyyy");
        objectAcctServerData.datetrx2 = UtilSql.getDateValue(result, "datetrx2", "dd-MM-yyyy");
        objectAcctServerData.qty1 = UtilSql.getValue(result, "qty1");
        objectAcctServerData.qty2 = UtilSql.getValue(result, "qty2");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static int insertMatchInv(Connection conn, ConnectionProvider connectionProvider, String M_MatchInv_ID, String AD_Client_ID, String AD_Org_ID, String M_InOutLine_ID, String C_InvoiceLine_ID, String M_Product_ID, String DateTrx, String Qty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_MatchInv (M_MatchInv_ID,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy," +
      "        M_InOutLine_ID,C_InvoiceLine_ID,M_Product_ID,DateTrx,Qty, Processing,Processed,Posted)" +
      "        VALUES (?,?,?,'Y',now(),0,now(),0,?,?," +
      "        ?,TO_DATE(?),TO_NUMBER(?), 'N','Y','N')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_MatchInv_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_InOutLine_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_InvoiceLine_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Qty);

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

  public static AcctServerData[] selectExpenseAcct(ConnectionProvider connectionProvider, String C_Charge_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectExpenseAcct(connectionProvider, C_Charge_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectExpenseAcct(ConnectionProvider connectionProvider, String C_Charge_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CH_Expense_Acct as account_ID FROM C_Charge_Acct WHERE C_Charge_ID = ? AND C_AcctSchema_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Charge_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectRevenueAcct(ConnectionProvider connectionProvider, String C_Charge_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectRevenueAcct(connectionProvider, C_Charge_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectRevenueAcct(ConnectionProvider connectionProvider, String C_Charge_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CH_Revenue_Acct as account_ID FROM C_Charge_Acct WHERE C_Charge_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Charge_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectLiabilityAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectLiabilityAcct(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectLiabilityAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT V_Liability_Acct as account_ID FROM C_BP_Vendor_Acct WHERE C_BPartner_ID=? AND C_AcctSchema_ID=?" +
      "        AND STATUS IS NULL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectLiabilityServicesAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectLiabilityServicesAcct(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectLiabilityServicesAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT V_Liability_Services_Acct as account_ID FROM C_BP_Vendor_Acct WHERE C_BPartner_ID=? AND C_AcctSchema_ID=?" +
      "        AND STATUS IS NULL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectReceivableAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectReceivableAcct(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectReceivableAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Receivable_Acct as account_ID FROM C_BP_Customer_Acct WHERE C_BPartner_ID=? AND C_AcctSchema_ID=?" +
      "        AND STATUS IS NULL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectUnallocatedCashAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectUnallocatedCashAcct(connectionProvider, C_BankAccount_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectUnallocatedCashAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B_UnallocatedCash_Acct as account_ID FROM C_BankAccount_Acct WHERE C_BankAccount_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectInTransitAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectInTransitAcct(connectionProvider, C_BankAccount_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectInTransitAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B_InTransit_Acct as account_ID FROM C_BankAccount_Acct WHERE C_BankAccount_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectInTransitDefaultAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectInTransitDefaultAcct(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectInTransitDefaultAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT B_INTRANSIT_ACCT AS ACCOUNT_ID FROM C_Acctschema_Default" +
      "	WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectConvertChargeDefaultAmtAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectConvertChargeDefaultAmtAcct(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectConvertChargeDefaultAmtAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT B_Revaluationloss_Acct AS ACCOUNT_ID FROM C_ACCTSCHEMA_DEFAULT" +
      "	WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectConvertGainDefaultAmtAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectConvertGainDefaultAmtAcct(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectConvertGainDefaultAmtAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT B_Revaluationgain_Acct AS ACCOUNT_ID FROM C_ACCTSCHEMA_DEFAULT" +
      "	WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectPaymentSelectAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectPaymentSelectAcct(connectionProvider, C_BankAccount_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectPaymentSelectAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B_PaymentSelect_Acct as account_ID FROM C_BankAccount_Acct WHERE C_BankAccount_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectWriteOffDefault(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectWriteOffDefault(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectWriteOffDefault(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT WRITEOFF_ACCT AS ACCOUNT_ID FROM C_ACCTSCHEMA_DEFAULT" +
      "        WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectWriteOffDefaultRevenue(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectWriteOffDefaultRevenue(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectWriteOffDefaultRevenue(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT WRITEOFF_REV_ACCT AS ACCOUNT_ID FROM C_ACCTSCHEMA_DEFAULT" +
      "        WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectDiscountExpAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectDiscountExpAcct(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectDiscountExpAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT a.PayDiscount_Exp_Acct as account_ID FROM C_BP_Group_Acct a, C_BPartner bp" +
      "        WHERE a.C_BP_Group_ID=bp.C_BP_Group_ID AND bp.C_BPartner_ID=? AND a.C_AcctSchema_ID=?" +
      "        AND STATUS IS NULL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectDiscountRevAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectDiscountRevAcct(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectDiscountRevAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PayDiscount_Rev_Acct as account_ID FROM C_BP_Group_Acct a, C_BPartner bp" +
      "        WHERE a.C_BP_Group_ID=bp.C_BP_Group_ID AND bp.C_BPartner_ID=? AND a.C_AcctSchema_ID=?" +
      "        AND STATUS IS NULL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectWriteOffAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectWriteOffAcct(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectWriteOffAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT WriteOff_Acct as account_ID FROM C_BP_Group_Acct a, C_BPartner bp" +
      "        WHERE a.C_BP_Group_ID=bp.C_BP_Group_ID AND bp.C_BPartner_ID=? AND a.C_AcctSchema_ID=?" +
      "        AND STATUS IS NULL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectWriteOffAcctRevenue(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectWriteOffAcctRevenue(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectWriteOffAcctRevenue(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT WriteOff_Rev_Acct as account_ID FROM C_BP_Group_Acct a, C_BPartner bp" +
      "        WHERE a.C_BP_Group_ID=bp.C_BP_Group_ID AND bp.C_BPartner_ID=? AND a.C_AcctSchema_ID=?" +
      "        AND STATUS IS NULL";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectAssetAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectAssetAcct(connectionProvider, C_BankAccount_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectAssetAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B_Asset_Acct as account_ID FROM C_BankAccount_Acct WHERE C_BankAccount_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectConvertChargeLossAmt(ConnectionProvider connectionProvider, String FIN_Financial_Account_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectConvertChargeLossAmt(connectionProvider, FIN_Financial_Account_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectConvertChargeLossAmt(ConnectionProvider connectionProvider, String FIN_Financial_Account_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT FIN_BANKREVALUATIONLOSS_ACCT as account_ID FROM Fin_Financial_Account_Acct WHERE Fin_Financial_Account_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, FIN_Financial_Account_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectConvertChargeGainAmt(ConnectionProvider connectionProvider, String FIN_Financial_Account_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectConvertChargeGainAmt(connectionProvider, FIN_Financial_Account_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectConvertChargeGainAmt(ConnectionProvider connectionProvider, String FIN_Financial_Account_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT FIN_BANKREVALUATIONGAIN_ACCT as account_ID FROM Fin_Financial_Account_Acct WHERE Fin_Financial_Account_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, FIN_Financial_Account_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectInterestRevAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectInterestRevAcct(connectionProvider, C_BankAccount_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectInterestRevAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B_InterestRev_Acct as account_ID FROM C_BankAccount_Acct WHERE C_BankAccount_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectInterestExpAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectInterestExpAcct(connectionProvider, C_BankAccount_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectInterestExpAcct(ConnectionProvider connectionProvider, String C_BankAccount_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B_InterestExp_Acct as account_ID FROM C_BankAccount_Acct WHERE C_BankAccount_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectCBAssetAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectCBAssetAcct(connectionProvider, C_CashBook_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectCBAssetAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CB_Asset_Acct as account_ID FROM C_CashBook_Acct WHERE C_CashBook_ID = ? AND C_AcctSchema_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_CashBook_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectCashTransferAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectCashTransferAcct(connectionProvider, C_CashBook_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectCashTransferAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CB_CashTransfer_Acct as account_ID FROM C_CashBook_Acct WHERE C_CashBook_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_CashBook_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectCBExpenseAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectCBExpenseAcct(connectionProvider, C_CashBook_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectCBExpenseAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CB_Expense_Acct as account_ID FROM C_CashBook_Acct WHERE C_CashBook_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_CashBook_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectCBReceiptAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectCBReceiptAcct(connectionProvider, C_CashBook_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectCBReceiptAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CB_Receipt_Acct as account_ID FROM C_CashBook_Acct WHERE C_CashBook_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_CashBook_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectCBDifferencesAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectCBDifferencesAcct(connectionProvider, C_CashBook_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectCBDifferencesAcct(ConnectionProvider connectionProvider, String C_CashBook_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CB_Differences_Acct as account_ID FROM C_CashBook_Acct WHERE C_CashBook_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_CashBook_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectWDifferencesAcct(ConnectionProvider connectionProvider, String M_Warehouse_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectWDifferencesAcct(connectionProvider, M_Warehouse_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectWDifferencesAcct(ConnectionProvider connectionProvider, String M_Warehouse_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT W_Differences_Acct as account_ID FROM M_Warehouse_Acct WHERE M_Warehouse_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Warehouse_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectNotInvoicedReceiptsAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectNotInvoicedReceiptsAcct(connectionProvider, C_BPartner_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectNotInvoicedReceiptsAcct(ConnectionProvider connectionProvider, String C_BPartner_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NotInvoicedReceipts_Acct as account_ID FROM C_BP_Group_Acct a, C_BPartner bp" +
      "        WHERE a.C_BP_Group_ID=bp.C_BP_Group_ID AND bp.C_BPartner_ID=? AND a.C_AcctSchema_ID=?" +
      "        and a.status is null";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectPJAssetAcct(ConnectionProvider connectionProvider, String C_Project_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectPJAssetAcct(connectionProvider, C_Project_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectPJAssetAcct(ConnectionProvider connectionProvider, String C_Project_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PJ_Asset_Acct as account_ID FROM C_Project_Acct WHERE C_Project_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectPJWIPAcct(ConnectionProvider connectionProvider, String C_Project_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectPJWIPAcct(connectionProvider, C_Project_ID, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectPJWIPAcct(ConnectionProvider connectionProvider, String C_Project_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PJ_WIP_Acct  as account_ID FROM C_Project_Acct WHERE C_Project_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectPPVOffsetAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectPPVOffsetAcct(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctServerData[] selectPPVOffsetAcct(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PPVOffset_Acct as account_ID FROM C_AcctSchema_GL WHERE C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.accountId = UtilSql.getValue(result, "account_id");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectTables(ConnectionProvider connectionProvider, String language, String adUserClient)    throws ServletException {
    return selectTables(connectionProvider, language, adUserClient, 0, 0);
  }

  public static AcctServerData[] selectTables(ConnectionProvider connectionProvider, String language, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT DISTINCT(AD_Table.AD_Table_ID) as id," +
      "               AD_Table.tablename || ' (' ||" +
      "               (case when ad_table.po_window_id is null then '' else ad_column_identifier('AD_Window',TO_CHAR(ad_table.po_window_id),?) end)" +
      "               || (case when ad_table.po_window_id is null then '' else ' - ' end)" +
      "               || ad_column_identifier('AD_Window',TO_CHAR(ad_table.ad_window_id),?)  || ')' as name" +
      "        FROM AD_TABLE, C_ACCTSCHEMA_TABLE" +
      "       WHERE AD_TABLE.AD_TABLE_ID = C_ACCTSCHEMA_TABLE.AD_TABLE_ID" +
      "         AND AD_TABLE.ISACTIVE = 'Y'" +
      "         AND C_ACCTSCHEMA_TABLE.ISACTIVE = 'Y'" +
      "         AND C_ACCTSCHEMA_TABLE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        order by name";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.id = UtilSql.getValue(result, "id");
        objectAcctServerData.name = UtilSql.getValue(result, "name");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectOrganizations(ConnectionProvider connectionProvider, String adUserClient)    throws ServletException {
    return selectOrganizations(connectionProvider, adUserClient, 0, 0);
  }

  public static AcctServerData[] selectOrganizations(ConnectionProvider connectionProvider, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT AD_Org.AD_Org_ID as ID, AD_Org.Name" +
      "      	FROM AD_Org, AD_OrgType" +
      "      	WHERE AD_Org.AD_OrgType_ID=AD_OrgType.AD_OrgType_ID" +
      "      	AND (IsLegalEntity='Y' OR IsBusinessUnit='Y')" +
      "      	AND AD_Org.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND AD_Org.ISACTIVE='Y'";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.id = UtilSql.getValue(result, "id");
        objectAcctServerData.name = UtilSql.getValue(result, "name");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData selectDocumentsDates(ConnectionProvider connectionProvider, String columnName, String tableName, String adClientId, String StrOrg, String docbasetype, String dateFrom, String dateTo)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 as id from dual where exists ( select 1 from (" +
      "         SELECT a.";
    strSql = strSql + ((columnName==null || columnName.equals(""))?"":columnName);
    strSql = strSql + 
      " as dateacct" +
      "         FROM   ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " a" +
      "         WHERE a.ad_client_id = ?" +
      "         AND a.ad_org_id in (";
    strSql = strSql + ((StrOrg==null || StrOrg.equals(""))?"":StrOrg);
    strSql = strSql + 
      ")" +
      "         AND a.posted = 'N'" +
      "         AND a.processed = 'Y'" +
      "         AND (a.processing = 'N' OR a.processing IS NULL)" +
      "         AND EXISTS (" +
      "           SELECT 1" +
      "           FROM c_period p" +
      "           WHERE  a.";
    strSql = strSql + ((columnName==null || columnName.equals(""))?"":columnName);
    strSql = strSql + 
      " >= p.StartDate" +
      "           AND   a.";
    strSql = strSql + ((columnName==null || columnName.equals(""))?"":columnName);
    strSql = strSql + 
      " < p.EndDate + 1" +
      "           AND EXISTS (" +
      "             SELECT 1" +
      "             FROM c_periodcontrol pc" +
      "             WHERE pc.c_period_id = p.c_period_id" +
      "             AND ad_org_getperiodcontrolallow(a.ad_org_id) = pc.ad_org_id" +
      "             AND pc.docbasetype = ?" +
      "             AND pc.periodstatus = 'O'" +
      "           )" +
      "         )) b" +
      "         where 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND b.dateacct >= TO_DATE(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND b.dateacct <= TO_DATE(?) ");
    strSql = strSql + 
      "         )";

    ResultSet result;
    AcctServerData objectAcctServerData = new AcctServerData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (columnName != null && !(columnName.equals(""))) {
        }
      if (tableName != null && !(tableName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (StrOrg != null && !(StrOrg.equals(""))) {
        }
      if (columnName != null && !(columnName.equals(""))) {
        }
      if (columnName != null && !(columnName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }

      result = st.executeQuery();
      if(result.next()) {
        objectAcctServerData.id = UtilSql.getValue(result, "id");
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
    return(objectAcctServerData);
  }

  public static AcctServerData[] selectDocTypes(ConnectionProvider connectionProvider, String table, String client)    throws ServletException {
    return selectDocTypes(connectionProvider, table, client, 0, 0);
  }

  public static AcctServerData[] selectDocTypes(ConnectionProvider connectionProvider, String table, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select distinct docbasetype as name from c_doctype" +
      "      where ad_table_id = ?" +
      "      and ad_client_id = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, table);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.name = UtilSql.getValue(result, "name");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static String selectGroupLines(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT GROUPACCTINVLINES FROM AD_CLIENTINFO WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "groupacctinvlines");
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

  public static String selectDescription(ConnectionProvider connectionProvider, String tableId, String acctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ACCTDESCRIPTION FROM C_ACCTSCHEMA_TABLE" +
      "        WHERE AD_TABLE_ID = ?" +
      "        AND C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschemaId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "acctdescription");
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

  public static String selectBpartnerName(ConnectionProvider connectionProvider, String bpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM C_BPARTNER" +
      "        WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerId);

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

  public static String selectNegate(ConnectionProvider connectionProvider, String cAcctschemaId, String docbasetype)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT ALLOWNEGATIVE" +
      "		FROM C_ACCTSCHEMA_TABLE, C_ACCTSCHEMA_TABLE_DOCTYPE" +
      "		WHERE C_ACCTSCHEMA_TABLE.C_ACCTSCHEMA_TABLE_ID = C_ACCTSCHEMA_TABLE_DOCTYPE.C_ACCTSCHEMA_TABLE_ID" +
      "		AND C_ACCTSCHEMA_ID = ?" +
      "		AND C_ACCTSCHEMA_TABLE_DOCTYPE.DOCBASETYPE = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "allownegative");
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

  public static String selectDefaultNegate(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT ALLOWNEGATIVE" +
      "		FROM C_ACCTSCHEMA" +
      "		WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "allownegative");
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

  public static String selectTemplate(ConnectionProvider connectionProvider, String cAcctschemaId, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CLASSNAME" +
      "        FROM C_ACCTSCHEMA_TABLE, AD_CREATEFACT_TEMPLATE" +
      "        WHERE C_ACCTSCHEMA_TABLE.AD_CREATEFACT_TEMPLATE_ID = AD_CREATEFACT_TEMPLATE.AD_CREATEFACT_TEMPLATE_ID" +
      "        AND C_ACCTSCHEMA_ID = ?" +
      "        AND C_ACCTSCHEMA_TABLE.AD_TABLE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "classname");
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

  public static String selectTemplateDoc(ConnectionProvider connectionProvider, String cAcctschemaId, String docbasetype)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CREATEFACT_TEMPLATE.CLASSNAME" +
      "      FROM C_ACCTSCHEMA_TABLE, C_ACCTSCHEMA_TABLE_DOCTYPE, AD_CREATEFACT_TEMPLATE" +
      "      WHERE C_ACCTSCHEMA_TABLE_DOCTYPE.AD_CREATEFACT_TEMPLATE_ID = AD_CREATEFACT_TEMPLATE.AD_CREATEFACT_TEMPLATE_ID" +
      "      AND C_ACCTSCHEMA_TABLE.C_ACCTSCHEMA_TABLE_ID = C_ACCTSCHEMA_TABLE_DOCTYPE.C_ACCTSCHEMA_TABLE_ID" +
      "      AND C_ACCTSCHEMA_TABLE.C_ACCTSCHEMA_ID = ?" +
      "      AND C_ACCTSCHEMA_TABLE_DOCTYPE.DOCBASETYPE = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "classname");
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

  public static AcctServerData[] selectAcctProcess(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    return selectAcctProcess(connectionProvider, cAcctschemaId, 0, 0);
  }

  public static AcctServerData[] selectAcctProcess(ConnectionProvider connectionProvider, String cAcctschemaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_ACCTPROCESS.CLASSNAME" +
      "      FROM C_ACCTSCHEMA_PROCESS, AD_ACCTPROCESS" +
      "      WHERE C_ACCTSCHEMA_PROCESS.AD_ACCTPROCESS_ID = AD_ACCTPROCESS.AD_ACCTPROCESS_ID" +
      "      AND C_ACCTSCHEMA_PROCESS.C_ACCTSCHEMA_ID = ?" +
      "      ORDER BY SEQNO";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.classname = UtilSql.getValue(result, "classname");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static AcctServerData[] getTableInfo(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    return getTableInfo(connectionProvider, adTableId, 0, 0);
  }

  public static AcctServerData[] getTableInfo(ConnectionProvider connectionProvider, String adTableId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COLUMNNAME AS ACCTDATECOLUMN, TABLENAME, ACCTCLASSNAME" +
      "      FROM AD_TABLE, AD_COLUMN" +
      "      WHERE AD_TABLE.ACCTDATE_COLUMN_ID = AD_COLUMN.AD_COLUMN_ID" +
      "        AND AD_TABLE.AD_TABLE_ID = ?";

    ResultSet result;
    Vector<AcctServerData> vector = new Vector<AcctServerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
        AcctServerData objectAcctServerData = new AcctServerData();
        objectAcctServerData.acctdatecolumn = UtilSql.getValue(result, "acctdatecolumn");
        objectAcctServerData.tablename = UtilSql.getValue(result, "tablename");
        objectAcctServerData.acctclassname = UtilSql.getValue(result, "acctclassname");
        objectAcctServerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerData);
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
    AcctServerData objectAcctServerData[] = new AcctServerData[vector.size()];
    vector.copyInto(objectAcctServerData);
    return(objectAcctServerData);
  }

  public static boolean selectBackgroundEnabled(ConnectionProvider connectionProvider, String acctschemaId, String tableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT COUNT(*) AS NAME FROM C_ACCTSCHEMA_TABLE" +
      "       WHERE C_ACCTSCHEMA_ID = ?" +
      "       AND AD_TABLE_ID = ?" +
      "       AND ISACTIVE = 'Y'" +
      "       AND ISBACKGROUNDDISABLED = 'N'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "name").equals("0");
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
    return(boolReturn);
  }
}
