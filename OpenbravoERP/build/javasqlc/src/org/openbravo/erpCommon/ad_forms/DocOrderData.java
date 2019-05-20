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

class DocOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocOrderData.class);
  private String InitRecordNumber="0";
  public String cTaxId;
  public String name;
  public String rate;
  public String taxbaseamt;
  public String taxamt;
  public String cOrderId;
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
  public String cDoctypeId;
  public String cDoctypetargetId;
  public String description;
  public String isdelivered;
  public String isprinted;
  public String isselected;
  public String salesrepId;
  public String dateordered;
  public String datepromised;
  public String dateprinted;
  public String dateacct;
  public String cBpartnerId;
  public String billtoId;
  public String cBpartnerLocationId;
  public String poreference;
  public String isdiscountprinted;
  public String cCurrencyId;
  public String paymentrule;
  public String cPaymenttermId;
  public String invoicerule;
  public String deliveryrule;
  public String freightcostrule;
  public String freightamt;
  public String deliveryviarule;
  public String mShipperId;
  public String cChargeId;
  public String chargeamt;
  public String priorityrule;
  public String totallines;
  public String grandtotal;
  public String mWarehouseId;
  public String mPricelistId;
  public String istaxincluded;
  public String cCampaignId;
  public String cProjectId;
  public String cActivityId;
  public String posted;
  public String sendemail;
  public String adUserId;
  public String copyfrom;
  public String dropshipBpartnerId;
  public String dropshipLocationId;
  public String dropshipUserId;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String deliverynotes;
  public String cIncotermsId;
  public String incotermsdescription;
  public String generatetemplate;
  public String isinvoiced;
  public String istransferred;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("rate"))
      return rate;
    else if (fieldName.equalsIgnoreCase("taxbaseamt"))
      return taxbaseamt;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
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
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("isselected"))
      return isselected;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
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
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("sendemail"))
      return sendemail;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("dropship_bpartner_id") || fieldName.equals("dropshipBpartnerId"))
      return dropshipBpartnerId;
    else if (fieldName.equalsIgnoreCase("dropship_location_id") || fieldName.equals("dropshipLocationId"))
      return dropshipLocationId;
    else if (fieldName.equalsIgnoreCase("dropship_user_id") || fieldName.equals("dropshipUserId"))
      return dropshipUserId;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("deliverynotes"))
      return deliverynotes;
    else if (fieldName.equalsIgnoreCase("c_incoterms_id") || fieldName.equals("cIncotermsId"))
      return cIncotermsId;
    else if (fieldName.equalsIgnoreCase("incotermsdescription"))
      return incotermsdescription;
    else if (fieldName.equalsIgnoreCase("generatetemplate"))
      return generatetemplate;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("istransferred"))
      return istransferred;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocOrderData[] select(ConnectionProvider connectionProvider, String C_Order_ID)    throws ServletException {
    return select(connectionProvider, C_Order_ID, 0, 0);
  }

  public static DocOrderData[] select(ConnectionProvider connectionProvider, String C_Order_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT it.C_Tax_ID, t.Name, t.Rate, it.TaxBaseAmt, it.TaxAmt, '' AS C_ORDER_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID, '' AS ISACTIVE," +
      "        '' AS CREATED, '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS ISSOTRX, '' AS DOCUMENTNO, '' AS DOCSTATUS, '' AS DOCACTION," +
      "        '' AS PROCESSING, '' AS PROCESSED, '' AS C_DOCTYPE_ID, '' AS C_DOCTYPETARGET_ID, '' AS DESCRIPTION, " +
      "        '' AS ISDELIVERED, '' AS ISPRINTED, '' AS ISSELECTED, '' AS SALESREP_ID, '' AS DATEORDERED, '' AS DATEPROMISED, '' AS DATEPRINTED," +
      "        '' AS DATEACCT, '' AS C_BPARTNER_ID, '' AS BILLTO_ID, '' AS C_BPARTNER_LOCATION_ID, '' AS POREFERENCE, '' AS ISDISCOUNTPRINTED," +
      "        '' AS C_CURRENCY_ID, '' AS PAYMENTRULE, '' AS C_PAYMENTTERM_ID, '' AS INVOICERULE, '' AS DELIVERYRULE, '' AS FREIGHTCOSTRULE," +
      "        '' AS FREIGHTAMT, '' AS DELIVERYVIARULE, '' AS M_SHIPPER_ID, '' AS C_CHARGE_ID, '' AS CHARGEAMT, '' AS PRIORITYRULE, '' AS TOTALLINES," +
      "        '' AS GRANDTOTAL, '' AS M_WAREHOUSE_ID, '' AS M_PRICELIST_ID, '' AS ISTAXINCLUDED, '' AS C_CAMPAIGN_ID, '' AS C_PROJECT_ID, '' AS C_ACTIVITY_ID," +
      "        '' AS POSTED, '' AS SENDEMAIL, '' AS AD_USER_ID, '' AS COPYFROM, '' AS DROPSHIP_BPARTNER_ID, '' AS DROPSHIP_LOCATION_ID," +
      "        '' AS DROPSHIP_USER_ID, '' AS ISSELFSERVICE, '' AS AD_ORGTRX_ID, '' AS USER1_ID, '' AS USER2_ID, '' AS DELIVERYNOTES, '' AS C_INCOTERMS_ID," +
      "        '' AS INCOTERMSDESCRIPTION, '' AS GENERATETEMPLATE, '' AS ISINVOICED, '' AS ISTRANSFERRED" +
      "        FROM C_Tax t, C_OrderTax it " +
      "        WHERE t.C_Tax_ID=it.C_Tax_ID AND it.C_Order_ID=?";

    ResultSet result;
    Vector<DocOrderData> vector = new Vector<DocOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_ID);

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
        DocOrderData objectDocOrderData = new DocOrderData();
        objectDocOrderData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocOrderData.name = UtilSql.getValue(result, "name");
        objectDocOrderData.rate = UtilSql.getValue(result, "rate");
        objectDocOrderData.taxbaseamt = UtilSql.getValue(result, "taxbaseamt");
        objectDocOrderData.taxamt = UtilSql.getValue(result, "taxamt");
        objectDocOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectDocOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocOrderData.isactive = UtilSql.getValue(result, "isactive");
        objectDocOrderData.created = UtilSql.getValue(result, "created");
        objectDocOrderData.createdby = UtilSql.getValue(result, "createdby");
        objectDocOrderData.updated = UtilSql.getValue(result, "updated");
        objectDocOrderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocOrderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectDocOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectDocOrderData.docstatus = UtilSql.getValue(result, "docstatus");
        objectDocOrderData.docaction = UtilSql.getValue(result, "docaction");
        objectDocOrderData.processing = UtilSql.getValue(result, "processing");
        objectDocOrderData.processed = UtilSql.getValue(result, "processed");
        objectDocOrderData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocOrderData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectDocOrderData.description = UtilSql.getValue(result, "description");
        objectDocOrderData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectDocOrderData.isprinted = UtilSql.getValue(result, "isprinted");
        objectDocOrderData.isselected = UtilSql.getValue(result, "isselected");
        objectDocOrderData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectDocOrderData.dateordered = UtilSql.getValue(result, "dateordered");
        objectDocOrderData.datepromised = UtilSql.getValue(result, "datepromised");
        objectDocOrderData.dateprinted = UtilSql.getValue(result, "dateprinted");
        objectDocOrderData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocOrderData.billtoId = UtilSql.getValue(result, "billto_id");
        objectDocOrderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectDocOrderData.poreference = UtilSql.getValue(result, "poreference");
        objectDocOrderData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectDocOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocOrderData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectDocOrderData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectDocOrderData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectDocOrderData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectDocOrderData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectDocOrderData.freightamt = UtilSql.getValue(result, "freightamt");
        objectDocOrderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectDocOrderData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectDocOrderData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocOrderData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocOrderData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectDocOrderData.totallines = UtilSql.getValue(result, "totallines");
        objectDocOrderData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectDocOrderData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectDocOrderData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectDocOrderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocOrderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocOrderData.posted = UtilSql.getValue(result, "posted");
        objectDocOrderData.sendemail = UtilSql.getValue(result, "sendemail");
        objectDocOrderData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectDocOrderData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectDocOrderData.dropshipBpartnerId = UtilSql.getValue(result, "dropship_bpartner_id");
        objectDocOrderData.dropshipLocationId = UtilSql.getValue(result, "dropship_location_id");
        objectDocOrderData.dropshipUserId = UtilSql.getValue(result, "dropship_user_id");
        objectDocOrderData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectDocOrderData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocOrderData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocOrderData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocOrderData.deliverynotes = UtilSql.getValue(result, "deliverynotes");
        objectDocOrderData.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectDocOrderData.incotermsdescription = UtilSql.getValue(result, "incotermsdescription");
        objectDocOrderData.generatetemplate = UtilSql.getValue(result, "generatetemplate");
        objectDocOrderData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectDocOrderData.istransferred = UtilSql.getValue(result, "istransferred");
        objectDocOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocOrderData);
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
    DocOrderData objectDocOrderData[] = new DocOrderData[vector.size()];
    vector.copyInto(objectDocOrderData);
    return(objectDocOrderData);
  }

  public static DocOrderData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocOrderData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT O.AD_CLIENT_ID, O.AD_ORG_ID, O.C_BPARTNER_ID, O.AD_ORGTRX_ID, O.C_PROJECT_ID, " +
      "        O.C_CAMPAIGN_ID, O.C_ACTIVITY_ID, O.USER1_ID, O.USER2_ID, O.DOCUMENTNO, O.DATEACCT," +
      "        O.C_CURRENCY_ID, O.C_DOCTYPE_ID, O.C_CHARGE_ID, O.CHARGEAMT, O.POSTED, O.DATEORDERED," +
      "        O.ISTAXINCLUDED, O.GRANDTOTAL, O.TOTALLINES" +
      "        FROM C_ORDER O          " +
      "        WHERE AD_Client_ID=? " +
      "        AND C_ORDER_ID=?";

    ResultSet result;
    Vector<DocOrderData> vector = new Vector<DocOrderData>(0);
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
        DocOrderData objectDocOrderData = new DocOrderData();
        objectDocOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocOrderData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocOrderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocOrderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocOrderData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocOrderData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectDocOrderData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocOrderData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocOrderData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocOrderData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocOrderData.posted = UtilSql.getValue(result, "posted");
        objectDocOrderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectDocOrderData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectDocOrderData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectDocOrderData.totallines = UtilSql.getValue(result, "totallines");
        objectDocOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocOrderData);
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
    DocOrderData objectDocOrderData[] = new DocOrderData[vector.size()];
    vector.copyInto(objectDocOrderData);
    return(objectDocOrderData);
  }

  public static int updateProductPO(Connection conn, ConnectionProvider connectionProvider, String Record_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          UPDATE M_Product_PO SET PriceLastPO = (SELECT AVG(C_Currency_Convert(to_number(ol.PriceActual),ol.C_Currency_ID,M_Product_PO.C_Currency_ID,to_date(o.DateOrdered),to_char(null),o.AD_Client_ID,o.AD_Org_ID))" +
      "                  FROM C_Order o, C_OrderLine ol " +
      "                  WHERE o.C_Order_ID = ol.C_Order_ID" +
      "                  AND M_Product_PO.M_Product_ID = ol.M_Product_ID AND M_Product_PO.C_BPartner_ID=o.C_BPartner_ID" +
      "                  AND o.C_Order_ID = ?)" +
      "          WHERE EXISTS (SELECT * FROM C_Order o, C_OrderLine ol " +
      "                  WHERE o.C_Order_ID = ol.C_Order_ID" +
      "                  AND M_Product_PO.M_Product_ID = ol.M_Product_ID AND M_Product_PO.C_BPartner_ID=o.C_BPartner_ID" +
      "                  AND o.C_Order_ID = ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Record_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Record_ID);

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
}
