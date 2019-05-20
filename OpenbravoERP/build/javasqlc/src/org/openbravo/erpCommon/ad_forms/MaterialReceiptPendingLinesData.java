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

class MaterialReceiptPendingLinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(MaterialReceiptPendingLinesData.class);
  private String InitRecordNumber="0";
  public String cOrderlineId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String cOrderId;
  public String line;
  public String cBpartnerId;
  public String cBpartnerLocationId;
  public String dateordered;
  public String datepromised;
  public String datedelivered;
  public String dateinvoiced;
  public String description;
  public String mProductId;
  public String mWarehouseId;
  public String directship;
  public String cUomId;
  public String qtyordered;
  public String qtyreserved;
  public String qtydelivered;
  public String qtyinvoiced;
  public String mShipperId;
  public String cCurrencyId;
  public String pricelist;
  public String priceactual;
  public String pricelimit;
  public String linenetamt;
  public String discount;
  public String freightamt;
  public String cChargeId;
  public String chargeamt;
  public String cTaxId;
  public String sResourceassignmentId;
  public String refOrderlineId;
  public String mAttributesetinstanceId;
  public String isdescription;
  public String quantityorder;
  public String mProductUomId;
  public String cProjectId;
  public String user1Id;
  public String user2Id;
  public String cCostcenterId;
  public String aAssetId;
  public String cAum;
  public String aumqty;
  public String cDoctypeId;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
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
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("datedelivered"))
      return datedelivered;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("directship"))
      return directship;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("ref_orderline_id") || fieldName.equals("refOrderlineId"))
      return refOrderlineId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("isdescription"))
      return isdescription;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_aum") || fieldName.equals("cAum"))
      return cAum;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static MaterialReceiptPendingLinesData[] select(ConnectionProvider connectionProvider, String cOrderlineId)    throws ServletException {
    return select(connectionProvider, cOrderlineId, 0, 0);
  }

  public static MaterialReceiptPendingLinesData[] select(ConnectionProvider connectionProvider, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT OL.C_ORDERLINE_ID, OL.AD_CLIENT_ID, OL.AD_ORG_ID, OL.ISACTIVE, OL.CREATED," +
      "             OL.CREATEDBY, OL.UPDATED, OL.UPDATEDBY, OL.C_ORDER_ID," +
      "             OL.LINE, OL.C_BPARTNER_ID, OL.C_BPARTNER_LOCATION_ID, OL.DATEORDERED," +
      "             OL.DATEPROMISED, OL.DATEDELIVERED, OL.DATEINVOICED, OL.DESCRIPTION," +
      "             OL.M_PRODUCT_ID, OL.M_WAREHOUSE_ID, OL.DIRECTSHIP, OL.C_UOM_ID, OL.QTYORDERED," +
      "             OL.QTYRESERVED, OL.QTYDELIVERED, OL.QTYINVOICED, OL.M_SHIPPER_ID," +
      "             OL.C_CURRENCY_ID, OL.PRICELIST, OL.PRICEACTUAL, OL.PRICELIMIT, OL.LINENETAMT," +
      "             OL.DISCOUNT, OL.FREIGHTAMT, OL.C_CHARGE_ID, OL.CHARGEAMT," +
      "             OL.C_TAX_ID, OL.S_RESOURCEASSIGNMENT_ID, OL.REF_ORDERLINE_ID, OL.M_ATTRIBUTESETINSTANCE_ID," +
      "             OL.ISDESCRIPTION, OL.QUANTITYORDER, OL.M_PRODUCT_UOM_ID," +
      "             COALESCE(OL.C_PROJECT_ID, O.C_PROJECT_ID) AS C_PROJECT_ID," +
      "             COALESCE(OL.USER1_ID, O.USER1_ID) AS USER1_ID," +
      "             COALESCE(OL.USER2_ID, O.USER2_ID) AS USER2_ID," +
      "             COALESCE(OL.C_COSTCENTER_ID, O.C_COSTCENTER_ID) AS C_COSTCENTER_ID," +
      "             COALESCE(OL.A_ASSET_ID, O.A_ASSET_ID) AS A_ASSET_ID," +
      "             OL.C_AUM, OL.AUMQTY, O.C_DOCTYPE_ID" +
      "      FROM C_ORDERLINE OL, C_ORDER O" +
      "      WHERE OL.C_ORDER_ID = O.C_ORDER_ID " +
      "            AND OL.C_ORDERLINE_ID = ?";

    ResultSet result;
    Vector<MaterialReceiptPendingLinesData> vector = new Vector<MaterialReceiptPendingLinesData>(0);
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
        MaterialReceiptPendingLinesData objectMaterialReceiptPendingLinesData = new MaterialReceiptPendingLinesData();
        objectMaterialReceiptPendingLinesData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectMaterialReceiptPendingLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMaterialReceiptPendingLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaterialReceiptPendingLinesData.isactive = UtilSql.getValue(result, "isactive");
        objectMaterialReceiptPendingLinesData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectMaterialReceiptPendingLinesData.createdby = UtilSql.getValue(result, "createdby");
        objectMaterialReceiptPendingLinesData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectMaterialReceiptPendingLinesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMaterialReceiptPendingLinesData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectMaterialReceiptPendingLinesData.line = UtilSql.getValue(result, "line");
        objectMaterialReceiptPendingLinesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMaterialReceiptPendingLinesData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectMaterialReceiptPendingLinesData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectMaterialReceiptPendingLinesData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectMaterialReceiptPendingLinesData.datedelivered = UtilSql.getDateValue(result, "datedelivered", "dd-MM-yyyy");
        objectMaterialReceiptPendingLinesData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectMaterialReceiptPendingLinesData.description = UtilSql.getValue(result, "description");
        objectMaterialReceiptPendingLinesData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMaterialReceiptPendingLinesData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectMaterialReceiptPendingLinesData.directship = UtilSql.getValue(result, "directship");
        objectMaterialReceiptPendingLinesData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectMaterialReceiptPendingLinesData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectMaterialReceiptPendingLinesData.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectMaterialReceiptPendingLinesData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectMaterialReceiptPendingLinesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectMaterialReceiptPendingLinesData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectMaterialReceiptPendingLinesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectMaterialReceiptPendingLinesData.pricelist = UtilSql.getValue(result, "pricelist");
        objectMaterialReceiptPendingLinesData.priceactual = UtilSql.getValue(result, "priceactual");
        objectMaterialReceiptPendingLinesData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectMaterialReceiptPendingLinesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectMaterialReceiptPendingLinesData.discount = UtilSql.getValue(result, "discount");
        objectMaterialReceiptPendingLinesData.freightamt = UtilSql.getValue(result, "freightamt");
        objectMaterialReceiptPendingLinesData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectMaterialReceiptPendingLinesData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectMaterialReceiptPendingLinesData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectMaterialReceiptPendingLinesData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectMaterialReceiptPendingLinesData.refOrderlineId = UtilSql.getValue(result, "ref_orderline_id");
        objectMaterialReceiptPendingLinesData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectMaterialReceiptPendingLinesData.isdescription = UtilSql.getValue(result, "isdescription");
        objectMaterialReceiptPendingLinesData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectMaterialReceiptPendingLinesData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectMaterialReceiptPendingLinesData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMaterialReceiptPendingLinesData.user1Id = UtilSql.getValue(result, "user1_id");
        objectMaterialReceiptPendingLinesData.user2Id = UtilSql.getValue(result, "user2_id");
        objectMaterialReceiptPendingLinesData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectMaterialReceiptPendingLinesData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectMaterialReceiptPendingLinesData.cAum = UtilSql.getValue(result, "c_aum");
        objectMaterialReceiptPendingLinesData.aumqty = UtilSql.getValue(result, "aumqty");
        objectMaterialReceiptPendingLinesData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectMaterialReceiptPendingLinesData.rownum = Long.toString(countRecord);
        objectMaterialReceiptPendingLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaterialReceiptPendingLinesData);
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
    MaterialReceiptPendingLinesData objectMaterialReceiptPendingLinesData[] = new MaterialReceiptPendingLinesData[vector.size()];
    vector.copyInto(objectMaterialReceiptPendingLinesData);
    return(objectMaterialReceiptPendingLinesData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String adClientId, String adOrgId, String isactive, String createdby, String updatedby, String line, String description, String mInoutId, String cOrderlineId, String mLocatorId, String mProductId, String cUomId, String movementqty, String isinvoiced, String mAttributesetinstanceId, String isdescription, String quantityorder, String mProductUomId, String cProjectId, String user1Id, String user2Id, String cCostcenterId, String aAssetId, String cAum, String aumQty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_INOUTLINE" +
      "        (M_INOUTLINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE," +
      "         CREATED, CREATEDBY, UPDATED, UPDATEDBY, " +
      "         LINE, DESCRIPTION, M_INOUT_ID, C_ORDERLINE_ID, M_LOCATOR_ID, M_PRODUCT_ID, C_UOM_ID, " +
      "         MOVEMENTQTY, ISINVOICED, M_ATTRIBUTESETINSTANCE_ID, ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID," +
      "         C_PROJECT_ID, USER1_ID, USER2_ID, C_COSTCENTER_ID, A_ASSET_ID, C_AUM, AUMQTY)" +
      "      VALUES" +
      "        (?,?,?,?," +
      "         now(),?,now(),?," +
      "         TO_NUMBER(?),?,?,?,?,?,?," +
      "         TO_NUMBER(?),?,?,?,TO_NUMBER(?),?," +
      "         ?,?,?,?,?,?,TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aumQty);

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

  public static int updateInvoiceOrder(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_InvoiceLine SET M_InoutLine_id = ?" +
      "      WHERE C_OrderLine_ID= ?" +
      "      AND M_InOutLine_ID IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
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
}
