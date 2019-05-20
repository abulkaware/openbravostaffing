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

class RequisitionToOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(RequisitionToOrderData.class);
  private String InitRecordNumber="0";
  public String mRequisitionlineId;
  public String reqqty;
  public String matchedqty;
  public String qtytoorder;
  public String mPricelistId;
  public String needbydate;
  public String pricelist;
  public String price;
  public String mProductId;
  public String mAttributesetinstanceId;
  public String vendorId;
  public String vendor;
  public String product;
  public String attribute;
  public String requester;
  public String pricelistid;
  public String vendorpricelist;
  public String lockedby;
  public String lockqty;
  public String lockaumqty;
  public String lockprice;
  public String adOrgId;
  public String org;
  public String invoicerule;
  public String deliveryrule;
  public String freightcostrule;
  public String deliveryviarule;
  public String paymentrulepo;
  public String poPaymenttermId;
  public String description;
  public String cUomId;
  public String cAum;
  public String quantityorder;
  public String mProductUomId;
  public String pricelimit;
  public String priceactual;
  public String discount;
  public String tax;
  public String cOrderlineId;
  public String padre;
  public String id;
  public String name;
  public String pricestd;
  public String toClose;
  public String uomname;
  public String secuomname;
  public String poPaymentmethodId;
  public String grossUnit;
  public String grossAmt;
  public String aumqty;
  public String aumname;
  public String uompreference;
  public String havesecuom;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_requisitionline_id") || fieldName.equals("mRequisitionlineId"))
      return mRequisitionlineId;
    else if (fieldName.equalsIgnoreCase("reqqty"))
      return reqqty;
    else if (fieldName.equalsIgnoreCase("matchedqty"))
      return matchedqty;
    else if (fieldName.equalsIgnoreCase("qtytoorder"))
      return qtytoorder;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("needbydate"))
      return needbydate;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("vendor_id") || fieldName.equals("vendorId"))
      return vendorId;
    else if (fieldName.equalsIgnoreCase("vendor"))
      return vendor;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("attribute"))
      return attribute;
    else if (fieldName.equalsIgnoreCase("requester"))
      return requester;
    else if (fieldName.equalsIgnoreCase("pricelistid"))
      return pricelistid;
    else if (fieldName.equalsIgnoreCase("vendorpricelist"))
      return vendorpricelist;
    else if (fieldName.equalsIgnoreCase("lockedby"))
      return lockedby;
    else if (fieldName.equalsIgnoreCase("lockqty"))
      return lockqty;
    else if (fieldName.equalsIgnoreCase("lockaumqty"))
      return lockaumqty;
    else if (fieldName.equalsIgnoreCase("lockprice"))
      return lockprice;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("paymentrulepo"))
      return paymentrulepo;
    else if (fieldName.equalsIgnoreCase("po_paymentterm_id") || fieldName.equals("poPaymenttermId"))
      return poPaymenttermId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_aum") || fieldName.equals("cAum"))
      return cAum;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("to_close") || fieldName.equals("toClose"))
      return toClose;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("secuomname"))
      return secuomname;
    else if (fieldName.equalsIgnoreCase("po_paymentmethod_id") || fieldName.equals("poPaymentmethodId"))
      return poPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("gross_unit") || fieldName.equals("grossUnit"))
      return grossUnit;
    else if (fieldName.equalsIgnoreCase("gross_amt") || fieldName.equals("grossAmt"))
      return grossAmt;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("aumname"))
      return aumname;
    else if (fieldName.equalsIgnoreCase("uompreference"))
      return uompreference;
    else if (fieldName.equalsIgnoreCase("havesecuom"))
      return havesecuom;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RequisitionToOrderData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static RequisitionToOrderData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_REQUISITIONLINE_ID, '' AS REQQTY, '' AS MATCHEDQTY, '' AS QTYTOORDER, " +
      "          '' AS M_PRICELIST_ID, '' AS NEEDBYDATE, '' AS PRICELIST, '' AS PRICE," +
      "          '' AS M_PRODUCT_ID, '' AS M_ATTRIBUTESETINSTANCE_ID, '' AS VENDOR_ID, '' AS VENDOR, " +
      "          '' AS PRODUCT, '' AS ATTRIBUTE, ''  AS REQUESTER, '' AS PRICELISTID, '' AS VENDORPRICELIST," +
      "          '' AS LOCKEDBY, '' AS LOCKQTY, '' AS LOCKAUMQTY, '' AS LOCKPRICE, '' AS AD_ORG_ID, '' AS ORG, " +
      "          '' AS InvoiceRule, '' AS DeliveryRule, '' AS FreightCostRule, '' AS DeliveryViaRule," +
      "          '' AS PaymentRulePO, '' AS PO_PaymentTerm_ID, '' AS DESCRIPTION, '' AS C_UOM_ID, '' AS C_AUM, '' AS QUANTITYORDER, '' AS M_PRODUCT_UOM_ID," +
      "          '' AS PRICELIMIT, '' AS PRICEACTUAL, '' AS DISCOUNT, '' AS TAX, '' AS C_ORDERLINE_ID," +
      "          '' AS PADRE, '' AS ID, '' AS NAME, '' AS PRICESTD, '' AS TO_CLOSE, '' AS UOMNAME, '' AS SECUOMNAME, '' AS PO_PAYMENTMETHOD_ID," +
      "          '' as GROSS_UNIT, '' AS GROSS_AMT, '' AS AUMQTY, '' AS AUMNAME, '' AS UOMPREFERENCE, '' AS HAVESECUOM" +
      "        FROM DUAL";

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.reqqty = UtilSql.getValue(result, "reqqty");
        objectRequisitionToOrderData.matchedqty = UtilSql.getValue(result, "matchedqty");
        objectRequisitionToOrderData.qtytoorder = UtilSql.getValue(result, "qtytoorder");
        objectRequisitionToOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRequisitionToOrderData.needbydate = UtilSql.getValue(result, "needbydate");
        objectRequisitionToOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRequisitionToOrderData.price = UtilSql.getValue(result, "price");
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectRequisitionToOrderData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectRequisitionToOrderData.vendor = UtilSql.getValue(result, "vendor");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.attribute = UtilSql.getValue(result, "attribute");
        objectRequisitionToOrderData.requester = UtilSql.getValue(result, "requester");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.vendorpricelist = UtilSql.getValue(result, "vendorpricelist");
        objectRequisitionToOrderData.lockedby = UtilSql.getValue(result, "lockedby");
        objectRequisitionToOrderData.lockqty = UtilSql.getValue(result, "lockqty");
        objectRequisitionToOrderData.lockaumqty = UtilSql.getValue(result, "lockaumqty");
        objectRequisitionToOrderData.lockprice = UtilSql.getValue(result, "lockprice");
        objectRequisitionToOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRequisitionToOrderData.org = UtilSql.getValue(result, "org");
        objectRequisitionToOrderData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectRequisitionToOrderData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectRequisitionToOrderData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectRequisitionToOrderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectRequisitionToOrderData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectRequisitionToOrderData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectRequisitionToOrderData.description = UtilSql.getValue(result, "description");
        objectRequisitionToOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRequisitionToOrderData.cAum = UtilSql.getValue(result, "c_aum");
        objectRequisitionToOrderData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectRequisitionToOrderData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectRequisitionToOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectRequisitionToOrderData.priceactual = UtilSql.getValue(result, "priceactual");
        objectRequisitionToOrderData.discount = UtilSql.getValue(result, "discount");
        objectRequisitionToOrderData.tax = UtilSql.getValue(result, "tax");
        objectRequisitionToOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectRequisitionToOrderData.padre = UtilSql.getValue(result, "padre");
        objectRequisitionToOrderData.id = UtilSql.getValue(result, "id");
        objectRequisitionToOrderData.name = UtilSql.getValue(result, "name");
        objectRequisitionToOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectRequisitionToOrderData.toClose = UtilSql.getValue(result, "to_close");
        objectRequisitionToOrderData.uomname = UtilSql.getValue(result, "uomname");
        objectRequisitionToOrderData.secuomname = UtilSql.getValue(result, "secuomname");
        objectRequisitionToOrderData.poPaymentmethodId = UtilSql.getValue(result, "po_paymentmethod_id");
        objectRequisitionToOrderData.grossUnit = UtilSql.getValue(result, "gross_unit");
        objectRequisitionToOrderData.grossAmt = UtilSql.getValue(result, "gross_amt");
        objectRequisitionToOrderData.aumqty = UtilSql.getValue(result, "aumqty");
        objectRequisitionToOrderData.aumname = UtilSql.getValue(result, "aumname");
        objectRequisitionToOrderData.uompreference = UtilSql.getValue(result, "uompreference");
        objectRequisitionToOrderData.havesecuom = UtilSql.getValue(result, "havesecuom");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] set()    throws ServletException {
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[1];
    objectRequisitionToOrderData[0] = new RequisitionToOrderData();
    objectRequisitionToOrderData[0].mRequisitionlineId = "";
    objectRequisitionToOrderData[0].reqqty = "";
    objectRequisitionToOrderData[0].matchedqty = "";
    objectRequisitionToOrderData[0].qtytoorder = "";
    objectRequisitionToOrderData[0].mPricelistId = "";
    objectRequisitionToOrderData[0].needbydate = "";
    objectRequisitionToOrderData[0].pricelist = "";
    objectRequisitionToOrderData[0].price = "";
    objectRequisitionToOrderData[0].mProductId = "";
    objectRequisitionToOrderData[0].mAttributesetinstanceId = "";
    objectRequisitionToOrderData[0].vendorId = "";
    objectRequisitionToOrderData[0].vendor = "";
    objectRequisitionToOrderData[0].product = "";
    objectRequisitionToOrderData[0].attribute = "";
    objectRequisitionToOrderData[0].requester = "";
    objectRequisitionToOrderData[0].pricelistid = "";
    objectRequisitionToOrderData[0].vendorpricelist = "";
    objectRequisitionToOrderData[0].lockedby = "";
    objectRequisitionToOrderData[0].lockqty = "";
    objectRequisitionToOrderData[0].lockaumqty = "";
    objectRequisitionToOrderData[0].lockprice = "";
    objectRequisitionToOrderData[0].adOrgId = "";
    objectRequisitionToOrderData[0].org = "";
    objectRequisitionToOrderData[0].invoicerule = "";
    objectRequisitionToOrderData[0].deliveryrule = "";
    objectRequisitionToOrderData[0].freightcostrule = "";
    objectRequisitionToOrderData[0].deliveryviarule = "";
    objectRequisitionToOrderData[0].paymentrulepo = "";
    objectRequisitionToOrderData[0].poPaymenttermId = "";
    objectRequisitionToOrderData[0].description = "";
    objectRequisitionToOrderData[0].cUomId = "";
    objectRequisitionToOrderData[0].cAum = "";
    objectRequisitionToOrderData[0].quantityorder = "";
    objectRequisitionToOrderData[0].mProductUomId = "";
    objectRequisitionToOrderData[0].pricelimit = "";
    objectRequisitionToOrderData[0].priceactual = "";
    objectRequisitionToOrderData[0].discount = "";
    objectRequisitionToOrderData[0].tax = "";
    objectRequisitionToOrderData[0].cOrderlineId = "";
    objectRequisitionToOrderData[0].padre = "";
    objectRequisitionToOrderData[0].id = "";
    objectRequisitionToOrderData[0].name = "";
    objectRequisitionToOrderData[0].pricestd = "";
    objectRequisitionToOrderData[0].toClose = "";
    objectRequisitionToOrderData[0].uomname = "";
    objectRequisitionToOrderData[0].secuomname = "";
    objectRequisitionToOrderData[0].poPaymentmethodId = "";
    objectRequisitionToOrderData[0].grossUnit = "";
    objectRequisitionToOrderData[0].grossAmt = "";
    objectRequisitionToOrderData[0].aumqty = "";
    objectRequisitionToOrderData[0].aumname = "";
    objectRequisitionToOrderData[0].uompreference = "";
    objectRequisitionToOrderData[0].havesecuom = "";
    return objectRequisitionToOrderData;
  }

  public static RequisitionToOrderData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parProduct, String parRequester, String parVendorInc, String parVendor)    throws ServletException {
    return selectLines(connectionProvider, language, adUserClient, adOrgId, parDateFrom, parDateTo, parProduct, parRequester, parVendorInc, parVendor, 0, 0);
  }

  public static RequisitionToOrderData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parProduct, String parRequester, String parVendorInc, String parVendor, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_REQUISITIONLINE_ID, M_REQUISITIONLINE.NEEDBYDATE," +
      "          M_REQUISITIONLINE.QTY - M_REQUISITIONLINE.ORDEREDQTY AS QTYTOORDER," +
      "          QUANTITYORDER," +
      "          AUMQTY," +
      "          M_REQUISITIONLINE.M_PRODUCT_ID," +
      "          C_AUM," +
      "          C_UOM.C_UOM_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_Uom'), to_char(C_UOM1.C_UOM_ID), ?) AS SECUOMNAME," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_Uom'), to_char(C_UOM.C_UOM_ID), ?) AS UOMNAME," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_Uom'), to_char(M_REQUISITIONLINE.C_AUM), ?) AS AUMNAME," +
      "          CASE WHEN pl.istaxincluded = 'Y' THEN M_REQUISITIONLINE.GROSS_UNIT_PRICE ELSE M_REQUISITIONLINE.PRICEACTUAL END AS PRICE," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID)), ?) AS VENDOR," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), to_char(COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID)), ?) AS PRICELISTID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?) AS PRODUCT," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_AttributeSetInstance'), to_char(M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID), ?) AS ATTRIBUTE," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_User'), to_char(M_REQUISITION.AD_USER_ID), ?) AS REQUESTER" +
      "        FROM M_REQUISITION inner join M_REQUISITIONLINE on M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID " +
      "                               LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = M_REQUISITIONLINE.C_UOM_ID" +
      "                               LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = M_REQUISITIONLINE.M_PRODUCT_UOM_ID" +
      "                               LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID" +
      "                               LEFT JOIN m_pricelist pl on COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID) = pl.m_pricelist_id" +
      "        WHERE M_REQUISITION.ISACTIVE = 'Y'" +
      "          AND M_REQUISITIONLINE.ISACTIVE = 'Y'" +
      "          AND M_REQUISITION.DOCSTATUS = 'CO'" +
      "          AND M_REQUISITIONLINE.REQSTATUS = 'O'" +
      "          AND (M_REQUISITIONLINE.LOCKEDBY IS NULL OR COALESCE (M_REQUISITIONLINE.LOCKDATE, TO_DATE('01-01-1900', 'DD-MM-YYYY')) < (now()-3))" +
      "          AND M_REQUISITION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND M_REQUISITIONLINE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "          AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND M_REQUISITIONLINE.NEEDBYDATE >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND M_REQUISITIONLINE.NEEDBYDATE < TO_DATE(?) ");
    strSql = strSql + ((parProduct==null || parProduct.equals(""))?"":"  AND M_REQUISITIONLINE.M_PRODUCT_ID = TO_CHAR(?) ");
    strSql = strSql + ((parRequester==null || parRequester.equals(""))?"":"  AND M_REQUISITION.AD_USER_ID = TO_CHAR(?) ");
    strSql = strSql + ((parVendorInc==null || parVendorInc.equals(""))?"":"  AND (COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID,'-1') = TO_CHAR(?) OR (M_REQUISITIONLINE.C_BPARTNER_ID IS NULL AND M_REQUISITION.C_BPARTNER_ID IS NULL)) ");
    strSql = strSql + ((parVendor==null || parVendor.equals(""))?"":"  AND COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID,'-1') = TO_CHAR(?) ");
    strSql = strSql + 
      "        GROUP BY M_REQUISITIONLINE.M_REQUISITIONLINE_ID, M_REQUISITIONLINE.NEEDBYDATE, M_REQUISITIONLINE.QTY, M_REQUISITIONLINE.ORDEREDQTY," +
      "        QUANTITYORDER, AUMQTY, C_AUM, C_UOM1.C_UOM_ID, C_UOM.C_UOM_ID, pl.istaxincluded, M_REQUISITIONLINE.GROSS_UNIT_PRICE, M_REQUISITIONLINE.PRICEACTUAL," +
      "        M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID, M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID," +
      "        M_REQUISITIONLINE.M_PRODUCT_ID, M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID, M_REQUISITION.AD_USER_ID" +
      "        ORDER BY MIN(M_REQUISITIONLINE.LINE), M_REQUISITIONLINE.NEEDBYDATE, M_REQUISITIONLINE.M_PRODUCT_ID, M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID";

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
      if (parProduct != null && !(parProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parProduct);
      }
      if (parRequester != null && !(parRequester.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parRequester);
      }
      if (parVendorInc != null && !(parVendorInc.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parVendorInc);
      }
      if (parVendor != null && !(parVendor.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parVendor);
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectRequisitionToOrderData.qtytoorder = UtilSql.getValue(result, "qtytoorder");
        objectRequisitionToOrderData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectRequisitionToOrderData.aumqty = UtilSql.getValue(result, "aumqty");
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.cAum = UtilSql.getValue(result, "c_aum");
        objectRequisitionToOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRequisitionToOrderData.secuomname = UtilSql.getValue(result, "secuomname");
        objectRequisitionToOrderData.uomname = UtilSql.getValue(result, "uomname");
        objectRequisitionToOrderData.aumname = UtilSql.getValue(result, "aumname");
        objectRequisitionToOrderData.price = UtilSql.getValue(result, "price");
        objectRequisitionToOrderData.vendor = UtilSql.getValue(result, "vendor");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.attribute = UtilSql.getValue(result, "attribute");
        objectRequisitionToOrderData.requester = UtilSql.getValue(result, "requester");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectSelected(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId)    throws ServletException {
    return selectSelected(connectionProvider, language, adUserId, adUserClient, adOrgId, 0, 0);
  }

  public static RequisitionToOrderData[] selectSelected(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_REQUISITIONLINE.M_REQUISITIONLINE_ID, M_REQUISITIONLINE.NEEDBYDATE, M_REQUISITIONLINE.QTY AS REQQTY," +
      "          M_REQUISITIONLINE.ORDEREDQTY AS MATCHEDQTY, M_REQUISITIONLINE.PRICELIST," +
      "          COALESCE(LOCKQTY, QTY-ORDEREDQTY) AS LOCKQTY," +
      "          QUANTITYORDER," +
      "          COALESCE(LOCKAUMQTY, AUMQTY) AS AUMQTY," +
      "          M_REQUISITIONLINE.M_PRODUCT_ID," +
      "          C_AUM," +
      "          C_UOM.C_UOM_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_Uom'), to_char(C_UOM1.C_UOM_ID), ?) AS SECUOMNAME," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_Uom'), to_char(C_UOM.C_UOM_ID), ?) AS UOMNAME," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_Uom'), to_char(M_REQUISITIONLINE.C_AUM), ?) AS AUMNAME," +
      "          COALESCE(LOCKPRICE, CASE WHEN pl.istaxincluded = 'Y' THEN M_REQUISITIONLINE.GROSS_UNIT_PRICE ELSE M_REQUISITIONLINE.PRICEACTUAL END) AS LOCKPRICE," +
      "          COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID, '-1') AS VENDOR_ID," +
      "          COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID, '-1') AS M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID)), ?) AS VENDOR," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?) AS PRODUCT," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_AttributeSetInstance'), to_char(M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID), ?) AS ATTRIBUTE," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), to_char(COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID)), ?) AS PRICELISTID" +
      "        FROM M_REQUISITION inner join M_REQUISITIONLINE on M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID " +
      "                                              LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = M_REQUISITIONLINE.C_UOM_ID" +
      "                                              LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = M_REQUISITIONLINE.M_PRODUCT_UOM_ID" +
      "                                              LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID" +
      "                                              LEFT JOIN m_pricelist pl ON COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID,M_REQUISITION.M_PRICELIST_ID, '-1') = pl.m_pricelist_id" +
      "        WHERE M_REQUISITION.ISACTIVE = 'Y'" +
      "          AND M_REQUISITIONLINE.ISACTIVE = 'Y'" +
      "          AND M_REQUISITION.DOCSTATUS = 'CO'" +
      "          AND M_REQUISITIONLINE.REQSTATUS = 'O'" +
      "          AND M_REQUISITIONLINE.LOCKEDBY = ?" +
      "          AND M_REQUISITIONLINE.LOCKDATE >= (now()-3)" +
      "          AND M_REQUISITION.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND M_REQUISITIONLINE.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        GROUP BY M_REQUISITIONLINE.M_REQUISITIONLINE_ID, M_REQUISITIONLINE.NEEDBYDATE, M_REQUISITIONLINE.QTY," +
      "        M_REQUISITIONLINE.ORDEREDQTY, M_REQUISITIONLINE.PRICELIST, AUMQTY, C_AUM, C_UOM1.C_UOM_ID, C_UOM.C_UOM_ID, PL.ISTAXINCLUDED, " +
      "        M_REQUISITION.C_BPARTNER_ID, M_REQUISITION.M_PRICELIST_ID, LOCKQTY, QUANTITYORDER, LOCKPRICE, " +
      "        M_REQUISITIONLINE.GROSS_UNIT_PRICE, M_REQUISITIONLINE.PRICEACTUAL, M_REQUISITIONLINE.C_BPARTNER_ID, " +
      "        M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITIONLINE.M_PRODUCT_ID, M_REQUISITIONLINE.M_ATTRIBUTESETINSTANCE_ID," +
      "        C_UOM.C_UOM_ID, M_REQUISITIONLINE.M_PRODUCT_ID, LOCKAUMQTY" +
      "        ORDER BY MIN(M_REQUISITIONLINE.LINE), VENDOR_ID, M_PRICELIST_ID";

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectRequisitionToOrderData.reqqty = UtilSql.getValue(result, "reqqty");
        objectRequisitionToOrderData.matchedqty = UtilSql.getValue(result, "matchedqty");
        objectRequisitionToOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRequisitionToOrderData.lockqty = UtilSql.getValue(result, "lockqty");
        objectRequisitionToOrderData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectRequisitionToOrderData.aumqty = UtilSql.getValue(result, "aumqty");
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.cAum = UtilSql.getValue(result, "c_aum");
        objectRequisitionToOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRequisitionToOrderData.secuomname = UtilSql.getValue(result, "secuomname");
        objectRequisitionToOrderData.uomname = UtilSql.getValue(result, "uomname");
        objectRequisitionToOrderData.aumname = UtilSql.getValue(result, "aumname");
        objectRequisitionToOrderData.lockprice = UtilSql.getValue(result, "lockprice");
        objectRequisitionToOrderData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectRequisitionToOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRequisitionToOrderData.vendor = UtilSql.getValue(result, "vendor");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.attribute = UtilSql.getValue(result, "attribute");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] linesToOrder(ConnectionProvider connectionProvider, String currency, String orderdate, String org, String warehouse, String billto, String shipto, String pricelistversion, String parRequisitionLines)    throws ServletException {
    return linesToOrder(connectionProvider, currency, orderdate, org, warehouse, billto, shipto, pricelistversion, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] linesToOrder(ConnectionProvider connectionProvider, String currency, String orderdate, String org, String warehouse, String billto, String shipto, String pricelistversion, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_REQUISITIONLINE.M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID, LOCKQTY, LOCKAUMQTY, M_REQUISITIONLINE.DESCRIPTION, C_UOM_ID, C_AUM, QUANTITYORDER, AUMQTY, M_PRODUCT_UOM_ID," +
      "          M_REQUISITIONLINE_ID, '' AS C_ORDERLINE_ID," +
      "          COALESCE(M_PRODUCTPRICE.PRICELIST, M_REQUISITIONLINE.PRICELIST, LOCKPRICE) AS PRICELIST," +
      "          COALESCE(M_PRODUCTPRICE.PRICELIMIT, LOCKPRICE) AS PRICELIMIT," +
      "          COALESCE(M_PRODUCTPRICE.PRICESTD, LOCKPRICE) AS PRICESTD," +
      "          CASE WHEN M_Pricelist.istaxincluded = 'Y' THEN 0" +
      "                                                ELSE ROUND(COALESCE(LOCKPRICE, M_PRODUCTPRICE.PRICESTD),(SELECT PRICEPRECISION FROM C_CURRENCY WHERE C_CURRENCY_ID = ?)) END AS PRICEACTUAL," +
      "          CASE WHEN COALESCE(M_PRODUCTPRICE.PRICELIST, M_REQUISITIONLINE.PRICELIST, LOCKPRICE) = 0 THEN 0 ELSE" +
      "                    ROUND((COALESCE(M_PRODUCTPRICE.PRICELIST, M_REQUISITIONLINE.PRICELIST, LOCKPRICE) - COALESCE(LOCKPRICE, M_PRODUCTPRICE.PRICESTD))/" +
      "                           COALESCE(M_PRODUCTPRICE.PRICELIST, M_REQUISITIONLINE.PRICELIST, LOCKPRICE)*100," +
      "                    (SELECT STDPRECISION FROM C_CURRENCY WHERE C_CURRENCY_ID = ?)) END AS DISCOUNT," +
      "          C_GetTax(M_REQUISITIONLINE.M_PRODUCT_ID, to_date(?), ?, ?, ?, ?, null, 'N') AS TAX," +
      "          CASE WHEN LOCKQTY < (M_REQUISITIONLINE.QTY - M_REQUISITIONLINE.ORDEREDQTY) THEN 'N' ELSE 'Y' END AS TO_CLOSE," +
      "          CASE WHEN M_Pricelist.istaxincluded = 'Y' THEN ROUND(COALESCE(LOCKPRICE, M_PRODUCTPRICE.PRICESTD),(SELECT PRICEPRECISION FROM C_CURRENCY WHERE C_CURRENCY_ID = ?)) ELSE 0 END AS GROSS_UNIT," +
      "          CASE WHEN M_Pricelist.istaxincluded = 'Y' THEN ROUND(COALESCE(LOCKPRICE, M_PRODUCTPRICE.PRICESTD)*LOCKQTY,(SELECT PRICEPRECISION FROM C_CURRENCY WHERE C_CURRENCY_ID = ?)) ELSE 0 END AS GROSS_AMT," +
      "          M_REQUISITIONLINE.needbydate" +
      "          FROM M_REQUISITIONLINE LEFT JOIN M_PRODUCTPRICE" +
      "                                         ON M_REQUISITIONLINE.M_PRODUCT_ID = M_PRODUCTPRICE.M_PRODUCT_ID" +
      "                                            AND M_PRODUCTPRICE.M_PRICELIST_VERSION_ID = ?" +
      "                               LEFT JOIN m_pricelist_version on M_PRODUCTPRICE.M_PRICELIST_VERSION_ID = m_pricelist_version.M_PRICELIST_VERSION_ID" +
      "                               LEFT JOIN m_pricelist on m_pricelist_version.m_pricelist_id = m_pricelist.m_pricelist_id" +
      "        WHERE 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":"  AND M_RequisitionLine_ID IN" + parRequisitionLines);
    strSql = strSql + 
      "	    GROUP BY M_REQUISITIONLINE.M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID, LOCKQTY, M_REQUISITIONLINE.DESCRIPTION, C_UOM_ID, QUANTITYORDER, " +
      "	    AUMQTY, C_AUM, LOCKAUMQTY, M_PRODUCT_UOM_ID, M_REQUISITIONLINE_ID, M_PRODUCTPRICE.PRICELIST, M_REQUISITIONLINE.PRICELIST, LOCKPRICE," +
      "	    M_PRODUCTPRICE.PRICELIMIT, M_PRODUCTPRICE.PRICESTD, M_Pricelist.istaxincluded, M_REQUISITIONLINE.needbydate," +
      "            M_REQUISITIONLINE.QTY, M_REQUISITIONLINE.ORDEREDQTY, SUPPLIERNOTES" +
      "        ORDER BY MIN(M_REQUISITIONLINE.LINE), M_REQUISITIONLINE.M_PRODUCT_ID, M_PRODUCT_UOM_ID, M_ATTRIBUTESETINSTANCE_ID, SUPPLIERNOTES, " +
      "                 ROUND(COALESCE(LOCKPRICE, M_PRODUCTPRICE.PRICESTD),(SELECT PRICEPRECISION FROM C_CURRENCY WHERE C_CURRENCY_ID = ?))";

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistversion);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currency);

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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectRequisitionToOrderData.lockqty = UtilSql.getValue(result, "lockqty");
        objectRequisitionToOrderData.lockaumqty = UtilSql.getValue(result, "lockaumqty");
        objectRequisitionToOrderData.description = UtilSql.getValue(result, "description");
        objectRequisitionToOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRequisitionToOrderData.cAum = UtilSql.getValue(result, "c_aum");
        objectRequisitionToOrderData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectRequisitionToOrderData.aumqty = UtilSql.getValue(result, "aumqty");
        objectRequisitionToOrderData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectRequisitionToOrderData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectRequisitionToOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectRequisitionToOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRequisitionToOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectRequisitionToOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectRequisitionToOrderData.priceactual = UtilSql.getValue(result, "priceactual");
        objectRequisitionToOrderData.discount = UtilSql.getValue(result, "discount");
        objectRequisitionToOrderData.tax = UtilSql.getValue(result, "tax");
        objectRequisitionToOrderData.toClose = UtilSql.getValue(result, "to_close");
        objectRequisitionToOrderData.grossUnit = UtilSql.getValue(result, "gross_unit");
        objectRequisitionToOrderData.grossAmt = UtilSql.getValue(result, "gross_amt");
        objectRequisitionToOrderData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectRequisitionToOrderData.rownum = Long.toString(countRecord);
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectVendor(ConnectionProvider connectionProvider, String parRequisitionLines)    throws ServletException {
    return selectVendor(connectionProvider, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectVendor(ConnectionProvider connectionProvider, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID) AS VENDOR_ID" +
      "      FROM M_REQUISITIONLINE, M_REQUISITION" +
      "      WHERE M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID" +
      "        AND COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID) IS NOT NULL" +
      "        AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRequisitionLines)    throws ServletException {
    return selectPriceList(connectionProvider, language, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID) AS M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), to_char(COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID)), ?) AS PRICELISTID" +
      "        FROM M_REQUISITIONLINE, M_REQUISITION" +
      "        WHERE M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID" +
      "          AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRequisitionToOrderData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRequisitionLines)    throws ServletException {
    return selectOrg(connectionProvider, language, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT AD_ORG_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_Org'), to_char(AD_ORG_ID), ?) AS ORG" +
      "        FROM M_REQUISITIONLINE" +
      "        WHERE 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRequisitionToOrderData.org = UtilSql.getValue(result, "org");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectNoPrice(ConnectionProvider connectionProvider, String language, String pricelistversion, String parRequisitionLines)    throws ServletException {
    return selectNoPrice(connectionProvider, language, pricelistversion, parRequisitionLines, 0, 0);
  }

  public static RequisitionToOrderData[] selectNoPrice(ConnectionProvider connectionProvider, String language, String pricelistversion, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT M_PRODUCT_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?) AS PRODUCT" +
      "        FROM M_REQUISITIONLINE" +
      "        WHERE NOT EXISTS ( SELECT 1 FROM M_PRODUCTPRICE" +
      "                           WHERE M_REQUISITIONLINE.M_PRODUCT_ID = M_PRODUCTPRICE.M_PRODUCT_ID" +
      "                           AND M_PRODUCTPRICE.M_PRICELIST_VERSION_ID = ? )" +
      "          AND LOCKPRICE IS NULL" +
      "          AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":"  AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistversion);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRequisitionToOrderData.product = UtilSql.getValue(result, "product");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String clientid, String adOrgId, String adclient)    throws ServletException {
    return selectWarehouseDouble(connectionProvider, clientid, adOrgId, adclient, 0, 0);
  }

  public static RequisitionToOrderData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String clientid, String adOrgId, String adclient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG.AD_ORG_ID AS PADRE, M_WAREHOUSE.M_WAREHOUSE_ID AS ID, M_WAREHOUSE.NAME AS NAME" +
      "        FROM M_WAREHOUSE, AD_ORG" +
      "        WHERE (AD_ISORGINCLUDED(M_WAREHOUSE.AD_ORG_ID, AD_ORG.AD_ORG_ID, ?) <> -1" +
      "          OR AD_ISORGINCLUDED(AD_ORG.AD_ORG_ID, M_WAREHOUSE.AD_ORG_ID, ?) <> -1)" +
      "          AND AD_ORG.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "          AND M_WAREHOUSE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adclient==null || adclient.equals(""))?"":adclient);
    strSql = strSql + 
      ")" +
      "        ORDER BY PADRE, NAME";

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientid);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adclient != null && !(adclient.equals(""))) {
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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.padre = UtilSql.getValue(result, "padre");
        objectRequisitionToOrderData.id = UtilSql.getValue(result, "id");
        objectRequisitionToOrderData.name = UtilSql.getValue(result, "name");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectVendorData(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectVendorData(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RequisitionToOrderData[] selectVendorData(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT p.InvoiceRule, p.DeliveryRule, DeliveryViaRule," +
      "        p.PaymentRulePO, p.PO_PaymentTerm_ID, p.PO_PaymentMethod_ID" +
      "      FROM C_BPartner p" +
      "      WHERE p.C_BPartner_ID = ?";

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectRequisitionToOrderData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectRequisitionToOrderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectRequisitionToOrderData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectRequisitionToOrderData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectRequisitionToOrderData.poPaymentmethodId = UtilSql.getValue(result, "po_paymentmethod_id");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String partnerid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(?), to_char(?)) AS VENDOR" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "vendor");
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

  public static String mProductDescription(ConnectionProvider connectionProvider, String productid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(?), to_char(?)) AS PRODUCT" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "product");
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

  public static String getPricelistVersion(ConnectionProvider connectionProvider, String pricelist, String orderdate)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_GET_PRICELIST_VERSION(?, to_date(?)) AS PRICELISTID" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdate);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pricelistid");
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

  public static String cDoctypeTarget(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_GET_DOCTYPE(?, ?, 'POO', null) FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static String cBPartnerLocationId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND C_BPartner_Location.IsActive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String billto(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE  C_BPartner_Location.IsBillTo='Y'" +
      "        AND C_BPartner_Location.IsActive='Y'" +
      "        AND C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String selectCurrency(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CURRENCY_ID" +
      "        FROM M_PRICELIST" +
      "        WHERE  M_PRICELIST_ID = ?";

    ResultSet result;
    String strReturn = null;
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

  public static int unlock(ConnectionProvider connectionProvider, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE" +
      "        SET LOCKEDBY = null," +
      "            LOCKPRICE = null," +
      "            LOCKQTY = null," +
      "            LOCKAUMQTY = null," +
      "            LOCKDATE = null," +
      "            LOCKCAUSE = null" +
      "        WHERE M_REQUISITIONLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
        }

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

  public static int lock(ConnectionProvider connectionProvider, String userId, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE" +
      "        SET LOCKEDBY = ?," +
      "            LOCKDATE = now()," +
      "            LOCKQTY = null," +
      "            LOCKPRICE = null," +
      "            LOCKCAUSE = 'M'" +
      "        WHERE M_REQUISITIONLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
        }

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

  public static int updateLock(ConnectionProvider connectionProvider, String lockQty, String lockPrice, String lockAumQty, String mRequisitionLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_REQUISITIONLINE" +
      "        SET LOCKQTY = to_number(?)," +
      "            LOCKPRICE = to_number(?)," +
      "            LOCKAUMQTY = to_number(?)" +
      "        WHERE M_REQUISITIONLINE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockPrice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockAumQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionLineId);

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

  public static int insertCOrder(Connection conn, ConnectionProvider connectionProvider, String cOrderId, String adClientId, String adOrgId, String user, String documentNo, String docStatus, String docAction, String cDoctypeId, String cDoctypetargetId, String dateordered, String datepromised, String dateacct, String cBpartnerId, String cBpartnerLocationId, String billtoId, String cCurrencyId, String paymentrule, String cPaymenttermId, String invoicerule, String deliveryrule, String freightcostrule, String deliveryviarule, String mWarehouseId, String mPricelistId, String cProjectId, String cActivityId, String cCampaignId, String finPaymentMethodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDER (C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, DOCUMENTNO," +
      "        DOCSTATUS, DOCACTION, C_DOCTYPE_ID, C_DOCTYPETARGET_ID," +
      "        DATEORDERED, DATEPROMISED, DATEACCT, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, BILLTO_ID, C_CURRENCY_ID, " +
      "        PAYMENTRULE, C_PAYMENTTERM_ID, INVOICERULE, DELIVERYRULE, FREIGHTCOSTRULE, " +
      "        DELIVERYVIARULE, M_WAREHOUSE_ID, M_PRICELIST_ID, " +
      "        C_PROJECT_ID, C_ACTIVITY_ID, C_CAMPAIGN_ID, PRIORITYRULE, ISSOTRX," +
      "        FIN_PAYMENTMETHOD_ID)" +
      "        VALUES (?,?,?,now(),?,now(),?,?,?,?,?,?,TO_DATE(?),TO_DATE(?),TO_DATE(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'5', 'N'," +
      "        ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentMethodId);

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

  public static int insertCOrderline(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String adClientId, String adOrgId, String user, String cOrderId, String line, String cBpartnerId, String cBpartnerLocationId, String dateordered, String datepromised, String description, String mProductId, String mAttributeSetInstanceId, String mWarehouseId, String mProductUomId, String cUomId, String cAum, String quantityorder, String qtyordered, String aumqty, String cCurrencyId, String pricelist, String priceactual, String pricelistid, String pricelimit, String cTaxId, String sResourceassignmentId, String discount, String priceGross, String lineGrossAmt)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDERLINE (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        C_ORDER_ID, LINE, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, DATEORDERED, DATEPROMISED, " +
      "        DESCRIPTION, M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID," +
      "        M_WAREHOUSE_ID, M_PRODUCT_UOM_ID, C_UOM_ID, C_AUM, QUANTITYORDER, QTYORDERED, AUMQTY, C_CURRENCY_ID, " +
      "        PRICELIST, " +
      "        PRICEACTUAL, " +
      "        PRICELIMIT, C_TAX_ID, S_RESOURCEASSIGNMENT_ID, DISCOUNT, " +
      "        PRICESTD, GROSS_UNIT_PRICE, LINE_GROSS_AMOUNT)" +
      "        VALUES (?,?,?,now(),?,now(),?," +
      "        ?,TO_NUMBER(?),?,?,TO_DATE(?),TO_DATE(?)," +
      "        ?,?,?," +
      "        ?, ?, ?,?,TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?),?," +
      "        TO_NUMBER(?), " +
      "        M_GET_OFFERS_PRICE(to_date(now()),?,?,TO_NUMBER(?),TO_NUMBER(?),?)," +
      "        TO_NUMBER(?), ?, ?,TO_NUMBER(?), " +
      "        TO_NUMBER(?),  TO_NUMBER(?), TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSetInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceGross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineGrossAmt);

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

  public static int updateCOrderline(Connection conn, ConnectionProvider connectionProvider, String qtyordered, String quantityorder, String aumqty, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_ORDERLINE" +
      "        SET QTYORDERED = TO_NUMBER(?)," +
      "        QUANTITYORDER = TO_NUMBER(?)," +
      "        AUMQTY = TO_NUMBER(?)" +
      "        WHERE C_ORDERLINE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

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

  public static int insertRequisitionOrder(Connection conn, ConnectionProvider connectionProvider, String mRequisitionOrderId, String adClientId, String adOrgId, String user, String mRequisitionLineId, String cOrderLineId, String qty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_REQUISITIONORDER (M_REQUISITIONORDER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISACTIVE," +
      "        M_REQUISITIONLINE_ID, C_ORDERLINE_ID, QTY)" +
      "        VALUES (?,?,?,now(),?,now(),?,'Y'," +
      "        ?,?,TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);

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

  public static RequisitionToOrderData cOrderPost0(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Order_Post(?)";

    RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
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
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData requisitionStatus(Connection conn, ConnectionProvider connectionProvider, String requisitionLineId, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_RequisitionLine_Status(null, ?, ?)";

    RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, requisitionLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

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
      parametersData.addElement(requisitionLineId);
      parametersTypes.addElement("in");
      parametersData.addElement(userId);
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
    return(objectRequisitionToOrderData);
  }

  public static RequisitionToOrderData[] selectAUMDefault(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    return selectAUMDefault(connectionProvider, mProductId, 0, 0);
  }

  public static RequisitionToOrderData[] selectAUMDefault(ConnectionProvider connectionProvider, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT M_GET_DEFAULT_AUM_FOR_DOCUMENT(?, 'FF8080812C2ABFC6012C2B3BDF51006E') AS C_AUM, " +
      "           (SELECT NAME FROM C_UOM WHERE C_UOM_ID = M_GET_DEFAULT_AUM_FOR_DOCUMENT(?, 'FF8080812C2ABFC6012C2B3BDF51006E')) AS AUMNAME" +
      "         FROM DUAL";

    ResultSet result;
    Vector<RequisitionToOrderData> vector = new Vector<RequisitionToOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
        RequisitionToOrderData objectRequisitionToOrderData = new RequisitionToOrderData();
        objectRequisitionToOrderData.cAum = UtilSql.getValue(result, "c_aum");
        objectRequisitionToOrderData.aumname = UtilSql.getValue(result, "aumname");
        objectRequisitionToOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionToOrderData);
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
    RequisitionToOrderData objectRequisitionToOrderData[] = new RequisitionToOrderData[vector.size()];
    vector.copyInto(objectRequisitionToOrderData);
    return(objectRequisitionToOrderData);
  }
}
