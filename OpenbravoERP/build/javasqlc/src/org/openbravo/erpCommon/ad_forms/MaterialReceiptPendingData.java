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
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class MaterialReceiptPendingData implements FieldProvider {
static Logger log4j = Logger.getLogger(MaterialReceiptPendingData.class);
  private String InitRecordNumber="0";
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
  public String isinvoiced;
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
  public String cCostcenterId;
  public String aAssetId;
  public String id;
  public String partnerName;
  public String productName;
  public String totalQty;
  public String qtyordered;
  public String dateFormat;
  public String cAum;
  public String aumqty;
  public String name;
  public String mProductId;
  public String cUomId;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
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
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
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
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("partner_name") || fieldName.equals("partnerName"))
      return partnerName;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("total_qty") || fieldName.equals("totalQty"))
      return totalQty;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("date_format") || fieldName.equals("dateFormat"))
      return dateFormat;
    else if (fieldName.equalsIgnoreCase("c_aum") || fieldName.equals("cAum"))
      return cAum;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static MaterialReceiptPendingData[] select(ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return select(connectionProvider, cOrderlineId, 0, 0);
  }

  public static MaterialReceiptPendingData[] select(ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_ORDER.C_ORDER_ID, C_ORDER.AD_CLIENT_ID, C_ORDER.AD_ORG_ID, C_ORDER.ISACTIVE, C_ORDER.CREATED, C_ORDER.CREATEDBY, " +
      "             C_ORDER.UPDATED, C_ORDER.UPDATEDBY, C_ORDER.ISSOTRX, C_ORDER.DOCUMENTNO, C_ORDER.DOCSTATUS, C_ORDER.DOCACTION," +
      "             C_ORDER.PROCESSING, C_ORDER.PROCESSED, C_ORDER.C_DOCTYPE_ID, C_ORDER.C_DOCTYPETARGET_ID, C_ORDER.DESCRIPTION," +
      "             C_ORDER.ISDELIVERED, C_ORDER.ISINVOICED, C_ORDER.ISPRINTED, C_ORDER.ISSELECTED, C_ORDER.SALESREP_ID, C_ORDER.DATEORDERED," +
      "             C_ORDER.DATEPROMISED, C_ORDER.DATEPRINTED, C_ORDER.DATEACCT, C_ORDER.C_BPARTNER_ID, C_ORDER.BILLTO_ID, C_ORDER.C_BPARTNER_LOCATION_ID," +
      "             C_ORDER.POREFERENCE, C_ORDER.ISDISCOUNTPRINTED, C_ORDER.C_CURRENCY_ID, C_ORDER.PAYMENTRULE, C_ORDER.C_PAYMENTTERM_ID," +
      "             C_ORDER.INVOICERULE, C_ORDER.DELIVERYRULE, C_ORDER.FREIGHTCOSTRULE, C_ORDER.FREIGHTAMT, C_ORDER.DELIVERYVIARULE," +
      "             C_ORDER.M_SHIPPER_ID, C_ORDER.C_CHARGE_ID, C_ORDER.CHARGEAMT, C_ORDER.PRIORITYRULE, C_ORDER.TOTALLINES, C_ORDER.GRANDTOTAL," +
      "             C_ORDER.M_WAREHOUSE_ID, C_ORDER.M_PRICELIST_ID, C_ORDER.ISTAXINCLUDED, C_ORDER.C_CAMPAIGN_ID, C_ORDER.C_PROJECT_ID," +
      "             C_ORDER.C_ACTIVITY_ID, C_ORDER.POSTED, C_ORDER.AD_USER_ID, C_ORDER.COPYFROM, C_ORDER.DROPSHIP_BPARTNER_ID," +
      "             C_ORDER.DROPSHIP_LOCATION_ID, C_ORDER.DROPSHIP_USER_ID, C_ORDER.ISSELFSERVICE, C_ORDER.AD_ORGTRX_ID," +
      "             C_ORDER.USER1_ID, C_ORDER.USER2_ID, C_ORDER.DELIVERYNOTES, C_ORDER.C_INCOTERMS_ID, C_ORDER.INCOTERMSDESCRIPTION," +
      "             C_ORDER.GENERATETEMPLATE, C_ORDER.C_COSTCENTER_ID, C_ORDER.A_ASSET_ID," +
      "             '' AS ID, '' AS PARTNER_NAME, '' AS PRODUCT_NAME, '' AS TOTAL_QTY, '' AS QTYORDERED, '' AS DATE_FORMAT," +
      "             C_AUM, AUMQTY, '' AS NAME, C_ORDERLINE.M_PRODUCT_ID, C_ORDERLINE.C_UOM_ID" +
      "      FROM C_ORDER, C_ORDERLINE" +
      "      WHERE C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDER.DOCSTATUS = 'CO'" +
      "      AND C_ORDERLINE.C_ORDERLINE_ID = ?";

    ResultSet result;
    Vector<MaterialReceiptPendingData> vector = new Vector<MaterialReceiptPendingData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

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
        MaterialReceiptPendingData objectMaterialReceiptPendingData = new MaterialReceiptPendingData();
        objectMaterialReceiptPendingData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectMaterialReceiptPendingData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMaterialReceiptPendingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaterialReceiptPendingData.isactive = UtilSql.getValue(result, "isactive");
        objectMaterialReceiptPendingData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectMaterialReceiptPendingData.createdby = UtilSql.getValue(result, "createdby");
        objectMaterialReceiptPendingData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectMaterialReceiptPendingData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMaterialReceiptPendingData.issotrx = UtilSql.getValue(result, "issotrx");
        objectMaterialReceiptPendingData.documentno = UtilSql.getValue(result, "documentno");
        objectMaterialReceiptPendingData.docstatus = UtilSql.getValue(result, "docstatus");
        objectMaterialReceiptPendingData.docaction = UtilSql.getValue(result, "docaction");
        objectMaterialReceiptPendingData.processing = UtilSql.getValue(result, "processing");
        objectMaterialReceiptPendingData.processed = UtilSql.getValue(result, "processed");
        objectMaterialReceiptPendingData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectMaterialReceiptPendingData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectMaterialReceiptPendingData.description = UtilSql.getValue(result, "description");
        objectMaterialReceiptPendingData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectMaterialReceiptPendingData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectMaterialReceiptPendingData.isprinted = UtilSql.getValue(result, "isprinted");
        objectMaterialReceiptPendingData.isselected = UtilSql.getValue(result, "isselected");
        objectMaterialReceiptPendingData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectMaterialReceiptPendingData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectMaterialReceiptPendingData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectMaterialReceiptPendingData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectMaterialReceiptPendingData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectMaterialReceiptPendingData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMaterialReceiptPendingData.billtoId = UtilSql.getValue(result, "billto_id");
        objectMaterialReceiptPendingData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectMaterialReceiptPendingData.poreference = UtilSql.getValue(result, "poreference");
        objectMaterialReceiptPendingData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectMaterialReceiptPendingData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectMaterialReceiptPendingData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectMaterialReceiptPendingData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectMaterialReceiptPendingData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectMaterialReceiptPendingData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectMaterialReceiptPendingData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectMaterialReceiptPendingData.freightamt = UtilSql.getValue(result, "freightamt");
        objectMaterialReceiptPendingData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectMaterialReceiptPendingData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectMaterialReceiptPendingData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectMaterialReceiptPendingData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectMaterialReceiptPendingData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectMaterialReceiptPendingData.totallines = UtilSql.getValue(result, "totallines");
        objectMaterialReceiptPendingData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectMaterialReceiptPendingData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectMaterialReceiptPendingData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectMaterialReceiptPendingData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectMaterialReceiptPendingData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectMaterialReceiptPendingData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMaterialReceiptPendingData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectMaterialReceiptPendingData.posted = UtilSql.getValue(result, "posted");
        objectMaterialReceiptPendingData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectMaterialReceiptPendingData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectMaterialReceiptPendingData.dropshipBpartnerId = UtilSql.getValue(result, "dropship_bpartner_id");
        objectMaterialReceiptPendingData.dropshipLocationId = UtilSql.getValue(result, "dropship_location_id");
        objectMaterialReceiptPendingData.dropshipUserId = UtilSql.getValue(result, "dropship_user_id");
        objectMaterialReceiptPendingData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectMaterialReceiptPendingData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectMaterialReceiptPendingData.user1Id = UtilSql.getValue(result, "user1_id");
        objectMaterialReceiptPendingData.user2Id = UtilSql.getValue(result, "user2_id");
        objectMaterialReceiptPendingData.deliverynotes = UtilSql.getValue(result, "deliverynotes");
        objectMaterialReceiptPendingData.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectMaterialReceiptPendingData.incotermsdescription = UtilSql.getValue(result, "incotermsdescription");
        objectMaterialReceiptPendingData.generatetemplate = UtilSql.getValue(result, "generatetemplate");
        objectMaterialReceiptPendingData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectMaterialReceiptPendingData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectMaterialReceiptPendingData.id = UtilSql.getValue(result, "id");
        objectMaterialReceiptPendingData.partnerName = UtilSql.getValue(result, "partner_name");
        objectMaterialReceiptPendingData.productName = UtilSql.getValue(result, "product_name");
        objectMaterialReceiptPendingData.totalQty = UtilSql.getValue(result, "total_qty");
        objectMaterialReceiptPendingData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectMaterialReceiptPendingData.dateFormat = UtilSql.getValue(result, "date_format");
        objectMaterialReceiptPendingData.cAum = UtilSql.getValue(result, "c_aum");
        objectMaterialReceiptPendingData.aumqty = UtilSql.getValue(result, "aumqty");
        objectMaterialReceiptPendingData.name = UtilSql.getValue(result, "name");
        objectMaterialReceiptPendingData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMaterialReceiptPendingData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectMaterialReceiptPendingData.rownum = Long.toString(countRecord);
        objectMaterialReceiptPendingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaterialReceiptPendingData);
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
    MaterialReceiptPendingData objectMaterialReceiptPendingData[] = new MaterialReceiptPendingData[vector.size()];
    vector.copyInto(objectMaterialReceiptPendingData);
    return(objectMaterialReceiptPendingData);
  }

  public static MaterialReceiptPendingData[] set()    throws ServletException {
    MaterialReceiptPendingData objectMaterialReceiptPendingData[] = new MaterialReceiptPendingData[1];
    objectMaterialReceiptPendingData[0] = new MaterialReceiptPendingData();
    objectMaterialReceiptPendingData[0].cOrderId = "";
    objectMaterialReceiptPendingData[0].adClientId = "";
    objectMaterialReceiptPendingData[0].adOrgId = "";
    objectMaterialReceiptPendingData[0].isactive = "";
    objectMaterialReceiptPendingData[0].created = "";
    objectMaterialReceiptPendingData[0].createdby = "";
    objectMaterialReceiptPendingData[0].updated = "";
    objectMaterialReceiptPendingData[0].updatedby = "";
    objectMaterialReceiptPendingData[0].issotrx = "";
    objectMaterialReceiptPendingData[0].documentno = "";
    objectMaterialReceiptPendingData[0].docstatus = "";
    objectMaterialReceiptPendingData[0].docaction = "";
    objectMaterialReceiptPendingData[0].processing = "";
    objectMaterialReceiptPendingData[0].processed = "";
    objectMaterialReceiptPendingData[0].cDoctypeId = "";
    objectMaterialReceiptPendingData[0].cDoctypetargetId = "";
    objectMaterialReceiptPendingData[0].description = "";
    objectMaterialReceiptPendingData[0].isdelivered = "";
    objectMaterialReceiptPendingData[0].isinvoiced = "";
    objectMaterialReceiptPendingData[0].isprinted = "";
    objectMaterialReceiptPendingData[0].isselected = "";
    objectMaterialReceiptPendingData[0].salesrepId = "";
    objectMaterialReceiptPendingData[0].dateordered = "";
    objectMaterialReceiptPendingData[0].datepromised = "";
    objectMaterialReceiptPendingData[0].dateprinted = "";
    objectMaterialReceiptPendingData[0].dateacct = "";
    objectMaterialReceiptPendingData[0].cBpartnerId = "";
    objectMaterialReceiptPendingData[0].billtoId = "";
    objectMaterialReceiptPendingData[0].cBpartnerLocationId = "";
    objectMaterialReceiptPendingData[0].poreference = "";
    objectMaterialReceiptPendingData[0].isdiscountprinted = "";
    objectMaterialReceiptPendingData[0].cCurrencyId = "";
    objectMaterialReceiptPendingData[0].paymentrule = "";
    objectMaterialReceiptPendingData[0].cPaymenttermId = "";
    objectMaterialReceiptPendingData[0].invoicerule = "";
    objectMaterialReceiptPendingData[0].deliveryrule = "";
    objectMaterialReceiptPendingData[0].freightcostrule = "";
    objectMaterialReceiptPendingData[0].freightamt = "";
    objectMaterialReceiptPendingData[0].deliveryviarule = "";
    objectMaterialReceiptPendingData[0].mShipperId = "";
    objectMaterialReceiptPendingData[0].cChargeId = "";
    objectMaterialReceiptPendingData[0].chargeamt = "";
    objectMaterialReceiptPendingData[0].priorityrule = "";
    objectMaterialReceiptPendingData[0].totallines = "";
    objectMaterialReceiptPendingData[0].grandtotal = "";
    objectMaterialReceiptPendingData[0].mWarehouseId = "";
    objectMaterialReceiptPendingData[0].mPricelistId = "";
    objectMaterialReceiptPendingData[0].istaxincluded = "";
    objectMaterialReceiptPendingData[0].cCampaignId = "";
    objectMaterialReceiptPendingData[0].cProjectId = "";
    objectMaterialReceiptPendingData[0].cActivityId = "";
    objectMaterialReceiptPendingData[0].posted = "";
    objectMaterialReceiptPendingData[0].adUserId = "";
    objectMaterialReceiptPendingData[0].copyfrom = "";
    objectMaterialReceiptPendingData[0].dropshipBpartnerId = "";
    objectMaterialReceiptPendingData[0].dropshipLocationId = "";
    objectMaterialReceiptPendingData[0].dropshipUserId = "";
    objectMaterialReceiptPendingData[0].isselfservice = "";
    objectMaterialReceiptPendingData[0].adOrgtrxId = "";
    objectMaterialReceiptPendingData[0].user1Id = "";
    objectMaterialReceiptPendingData[0].user2Id = "";
    objectMaterialReceiptPendingData[0].deliverynotes = "";
    objectMaterialReceiptPendingData[0].cIncotermsId = "";
    objectMaterialReceiptPendingData[0].incotermsdescription = "";
    objectMaterialReceiptPendingData[0].generatetemplate = "";
    objectMaterialReceiptPendingData[0].cCostcenterId = "";
    objectMaterialReceiptPendingData[0].aAssetId = "";
    objectMaterialReceiptPendingData[0].id = "";
    objectMaterialReceiptPendingData[0].partnerName = "";
    objectMaterialReceiptPendingData[0].productName = "";
    objectMaterialReceiptPendingData[0].totalQty = "";
    objectMaterialReceiptPendingData[0].qtyordered = "";
    objectMaterialReceiptPendingData[0].dateFormat = "";
    objectMaterialReceiptPendingData[0].cAum = "";
    objectMaterialReceiptPendingData[0].aumqty = "";
    objectMaterialReceiptPendingData[0].name = "";
    objectMaterialReceiptPendingData[0].mProductId = "";
    objectMaterialReceiptPendingData[0].cUomId = "";
    return objectMaterialReceiptPendingData;
  }

  public static MaterialReceiptPendingData[] selectLines(ConnectionProvider connectionProvider, String dateFormat, String adLanguage, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parBPartner, String parDocumentNo, String pgLimit, String oraLimit)    throws ServletException {
    return selectLines(connectionProvider, dateFormat, adLanguage, adUserClient, adOrgId, parDateFrom, parDateTo, parBPartner, parDocumentNo, pgLimit, oraLimit, 0, 0);
  }

  public static MaterialReceiptPendingData[] selectLines(ConnectionProvider connectionProvider, String dateFormat, String adLanguage, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parBPartner, String parDocumentNo, String pgLimit, String oraLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.* FROM (" +
      "      SELECT ID, C_ORDER_ID, DOCUMENTNO, DATEORDERED, C_BPARTNER_ID, PARTNER_NAME, PRODUCT_NAME, DESCRIPTION, TOTAL_QTY, QTYORDERED, ISACTIVE, ? AS DATE_FORMAT, AD_ORG_ID, AUMQTY, C_AUM, C_DOCTYPE_ID, M_PRODUCT_ID, C_UOM_ID" +
      "      FROM(  " +
      "      SELECT C_ORDERLINE.C_ORDERLINE_ID AS ID, C_ORDER.C_ORDER_ID AS C_ORDER_ID, C_ORDER.DOCUMENTNO AS DOCUMENTNO, C_ORDER.DATEORDERED AS DATEORDERED, " +
      "      C_BPARTNER.C_BPARTNER_ID AS C_BPARTNER_ID, C_BPARTNER.NAME AS PARTNER_NAME, " +
      "      AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(C_ORDERLINE.M_PRODUCT_ID), TO_CHAR(?)) AS PRODUCT_NAME, M_ATTRIBUTESETINSTANCE.DESCRIPTION AS DESCRIPTION, C_ORDERLINE.QTYORDERED AS TOTAL_QTY," +
      "      C_ORDERLINE.QTYORDERED-SUM(COALESCE(M_MATCHPO.QTY,0)) AS QTYORDERED, '-1' AS ISACTIVE, C_ORDERLINE.LINE, C_ORDER.AD_ORG_ID AS AD_ORG_ID," +
      "      (CASE WHEN AUMQTY IS NULL THEN C_ORDERLINE.QTYORDERED-SUM(COALESCE(M_MATCHPO.QTY,0)) ELSE (AUMQTY-SUM(COALESCE(M_GET_CONVERTED_AUMQTY(C_ORDERLINE.M_PRODUCT_ID,M_MATCHPO.QTY,C_AUM),0))) END) AS AUMQTY,  " +
      "      (CASE WHEN C_AUM IS NULL THEN M_GET_DEFAULT_AUM_FOR_DOCUMENT(C_ORDERLINE.M_PRODUCT_ID, C_ORDER.C_DOCTYPE_ID) ELSE C_AUM END) AS C_AUM," +
      "      C_ORDER.C_DOCTYPE_ID, C_ORDERLINE.M_PRODUCT_ID, C_ORDERLINE.C_UOM_ID" +
      "      FROM C_ORDERLINE left join M_MATCHPO on C_ORDERLINE.C_ORDERLINE_ID = M_MATCHPO.C_ORDERLINE_ID" +
      "                                           and M_MATCHPO.M_INOUTLINE_ID IS NOT NULL" +
      "                       left join M_ATTRIBUTESETINSTANCE on C_ORDERLINE.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID," +
      "      C_ORDER,   C_BPARTNER, C_DOCTYPE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.ISSOTRX='N'";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND C_ORDER.DATEORDERED >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND C_ORDER.DATEORDERED < TO_DATE(?) ");
    strSql = strSql + ((parBPartner==null || parBPartner.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID = ? ");
    strSql = strSql + ((parDocumentNo==null || parDocumentNo.equals(""))?"":"  AND C_ORDER.DOCUMENTNO LIKE ? ");
    strSql = strSql + 
      "      AND C_ORDER.DOCSTATUS = 'CO'" +
      "      AND C_ORDER.C_DOCTYPE_ID = C_DOCTYPE.C_DOCTYPE_ID" +
      "      AND C_DOCTYPE.ISRETURN = 'N'" +
      "      GROUP BY C_ORDERLINE.C_ORDERLINE_ID, C_ORDER.C_ORDER_ID, C_ORDER.DOCUMENTNO, C_ORDER.DATEORDERED, C_BPARTNER.C_BPARTNER_ID," +
      "      C_BPARTNER.NAME, C_ORDERLINE.M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE.DESCRIPTION, C_ORDERLINE.QTYORDERED, C_ORDERLINE.LINE, C_ORDER.AD_ORG_ID," +
      "      C_ORDER.C_DOCTYPE_ID, C_ORDERLINE.M_PRODUCT_ID, C_ORDERLINE.C_UOM_ID, C_AUM, AUMQTY" +
      "      ) A" +
      "      WHERE (CASE WHEN Total_Qty < 0 THEN -1 ELSE 1 END) = (CASE WHEN Qtyordered < 0 THEN -1 ELSE 1 End) AND Qtyordered <> 0" +
      "      ORDER BY C_BPARTNER_ID, DOCUMENTNO, LINE" +
      "      ) B";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" WHERE ROWNUM <= " + oraLimit);

    ResultSet result;
    Vector<MaterialReceiptPendingData> vector = new Vector<MaterialReceiptPendingData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parBPartner != null && !(parBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartner);
      }
      if (parDocumentNo != null && !(parDocumentNo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDocumentNo);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
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
        MaterialReceiptPendingData objectMaterialReceiptPendingData = new MaterialReceiptPendingData();
        objectMaterialReceiptPendingData.id = UtilSql.getValue(result, "id");
        objectMaterialReceiptPendingData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectMaterialReceiptPendingData.documentno = UtilSql.getValue(result, "documentno");
        objectMaterialReceiptPendingData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectMaterialReceiptPendingData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMaterialReceiptPendingData.partnerName = UtilSql.getValue(result, "partner_name");
        objectMaterialReceiptPendingData.productName = UtilSql.getValue(result, "product_name");
        objectMaterialReceiptPendingData.description = UtilSql.getValue(result, "description");
        objectMaterialReceiptPendingData.totalQty = UtilSql.getValue(result, "total_qty");
        objectMaterialReceiptPendingData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectMaterialReceiptPendingData.isactive = UtilSql.getValue(result, "isactive");
        objectMaterialReceiptPendingData.dateFormat = UtilSql.getValue(result, "date_format");
        objectMaterialReceiptPendingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaterialReceiptPendingData.aumqty = UtilSql.getValue(result, "aumqty");
        objectMaterialReceiptPendingData.cAum = UtilSql.getValue(result, "c_aum");
        objectMaterialReceiptPendingData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectMaterialReceiptPendingData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMaterialReceiptPendingData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectMaterialReceiptPendingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaterialReceiptPendingData);
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
    MaterialReceiptPendingData objectMaterialReceiptPendingData[] = new MaterialReceiptPendingData[vector.size()];
    vector.copyInto(objectMaterialReceiptPendingData);
    return(objectMaterialReceiptPendingData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String mInoutId, String adClientId, String adOrgId, String isactive, String createdby, String updatedby, String issotrx, String documentno, String docaction, String docstatus, String posted, String processing, String processed, String cDoctypeId, String description, String cOrderId, String dateordered, String isprinted, String movementtype, String movementdate, String dateacct, String cBpartnerId, String cBpartnerLocationId, String mWarehouseId, String poreference, String deliveryrule, String freightcostrule, String freightamt, String deliveryviarule, String mShipperId, String cChargeId, String chargeamt, String priorityrule, String generateto, String createfrom, String adUserId, String salesrepId, String adOrgtrxId, String cProjectId, String cCampaignId, String cActivityId, String user1Id, String user2Id, String updatelines, String islogistic, String generatelines, String cCostcenterId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_INOUT(M_INOUT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, " +
      "      	ISSOTRX, DOCUMENTNO, DOCACTION, DOCSTATUS, POSTED, PROCESSING, PROCESSED, " +
      "      	C_DOCTYPE_ID, DESCRIPTION, C_ORDER_ID, DATEORDERED, ISPRINTED, MOVEMENTTYPE, MOVEMENTDATE, " +
      "      	DATEACCT, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, M_WAREHOUSE_ID, POREFERENCE, " +
      "      	DELIVERYRULE, FREIGHTCOSTRULE, FREIGHTAMT, DELIVERYVIARULE, M_SHIPPER_ID, C_CHARGE_ID, CHARGEAMT, " +
      "      	PRIORITYRULE, DATEPRINTED, C_INVOICE_ID, CREATEFROM, GENERATETO, AD_USER_ID, SALESREP_ID, NOPACKAGES, " +
      "      	PICKDATE, SHIPDATE, TRACKINGNO, AD_ORGTRX_ID, C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, " +
      "      	USER1_ID, USER2_ID, UPDATELINES, ISLOGISTIC, GENERATELINES, C_COSTCENTER_ID, A_ASSET_ID, PROCESS_GOODS_JAVA)" +
      "      VALUES(?,?,?,?,now(),?,now(),?," +
      "      	?,?,?,?,?,?,?," +
      "      	?,?,?,TO_DATE(?),?,?,TO_DATE(?)," +
      "      	TO_DATE(?),?,?,?,?," +
      "      	?,?,TO_NUMBER(?),?,?,?,TO_NUMBER(?)," +
      "      	?,NULL,NULL,?,?,?,?,NULL," +
      "      	NULL,NULL,NULL,?,?,?,?," +
      "      	?,?,?,?,?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islogistic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatelines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);

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

  public static MaterialReceiptPendingData mInoutPost0(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_InOut_Post0(?)";

    MaterialReceiptPendingData objectMaterialReceiptPendingData = new MaterialReceiptPendingData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectMaterialReceiptPendingData);
  }

  public static String cDoctypeTarget(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_GET_DOCTYPE(?, ?, 'MMR', null) FROM DUAL ";

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
        strReturn = UtilSql.getValue(result, "ad_get_doctype");
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

  public static String cDoctypeId(ConnectionProvider connectionProvider, String cDoctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DocTypeShipment_ID" +
      "        FROM C_DOCTYPE" +
      "        WHERE C_DocType_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_doctypeshipment_id");
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

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM C_BPARTNER " +
      "    WHERE C_BPARTNER_ID = ?";

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

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

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
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static String selectLocator(ConnectionProvider connectionProvider, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT VALUE FROM M_LOCATOR WHERE M_LOCATOR_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
