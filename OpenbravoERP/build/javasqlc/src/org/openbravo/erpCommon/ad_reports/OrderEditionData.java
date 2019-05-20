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

class OrderEditionData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrderEditionData.class);
  private String InitRecordNumber="0";
  public String documentno;
  public String dateordered;
  public String clientName;
  public String quantityorder;
  public String priceactual;
  public String priceactualsym;
  public String convpriceactual;
  public String pricelist;
  public String pricelistsym;
  public String convpricelist;
  public String productName;
  public String uomname;
  public String convsym;
  public String convisosym;
  public String transdate;
  public String transcurrencyid;
  public String transclientid;
  public String transorgid;
  public String aumqty;
  public String aum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("client_name") || fieldName.equals("clientName"))
      return clientName;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("priceactualsym"))
      return priceactualsym;
    else if (fieldName.equalsIgnoreCase("convpriceactual"))
      return convpriceactual;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricelistsym"))
      return pricelistsym;
    else if (fieldName.equalsIgnoreCase("convpricelist"))
      return convpricelist;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("convsym"))
      return convsym;
    else if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
    else if (fieldName.equalsIgnoreCase("transdate"))
      return transdate;
    else if (fieldName.equalsIgnoreCase("transcurrencyid"))
      return transcurrencyid;
    else if (fieldName.equalsIgnoreCase("transclientid"))
      return transclientid;
    else if (fieldName.equalsIgnoreCase("transorgid"))
      return transorgid;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("aum"))
      return aum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static OrderEditionData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String mWarehouseId, String cProjectId, String cRegionId, String mProductCategoryId, String cbPartnerId, String mProductId)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserOrg, adUserClient, dateFrom, dateTo, mWarehouseId, cProjectId, cRegionId, mProductCategoryId, cbPartnerId, mProductId, 0, 0);
  }

  public static OrderEditionData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String mWarehouseId, String cProjectId, String cRegionId, String mProductCategoryId, String cbPartnerId, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_ORDER.DOCUMENTNO AS DOCUMENTNO, C_ORDER.DATEORDERED AS DATEORDERED, C_BPARTNER.NAME AS CLIENT_NAME, SUM(C_ORDERLINE.QTYORDERED) AS QUANTITYORDER, " +
      "      C_ORDERLINE.PRICEACTUAL AS PRICEACTUAL, " +
      "      C_CURRENCY_SYMBOL (COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), C_ORDERLINE.PRICEACTUAL, 'Y') AS PRICEACTUALSYM,	  " +
      "	  C_CURRENCY_CONVERT(C_ORDERLINE.PRICEACTUAL, COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), ?, TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())), NULL, C_ORDERLINE.AD_CLIENT_ID, C_ORDERLINE.AD_ORG_ID) AS CONVPRICEACTUAL,      " +
      "      SUM(C_ORDERLINE.LINENETAMT) AS PRICELIST," +
      "      C_CURRENCY_SYMBOL (COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), SUM(C_ORDERLINE.LINENETAMT), 'Y') AS PRICELISTSYM," +
      "	  SUM(C_CURRENCY_CONVERT(C_ORDERLINE.LINENETAMT, COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), ?, TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())), NULL, C_ORDERLINE.AD_CLIENT_ID, C_ORDERLINE.AD_ORG_ID)) AS CONVPRICELIST, " +
      "      M_PRODUCT.NAME AS PRODUCT_NAME, C_UOM.NAME AS UOMNAME," +
      "      C_CURRENCY_SYMBOL(?, '0', 'Y') AS CONVSYM,	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM,	  " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRANSDATE,	  " +
      "	  COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRANSCURRENCYID,      " +
      "	  C_ORDERLINE.AD_CLIENT_ID AS TRANSCLIENTID, 	  " +
      "	  C_ORDERLINE.AD_ORG_ID AS TRANSORGID, " +
      "	  C_ORDERLINE.AUMQTY, " +
      "	  (CASE WHEN C_ORDERLINE.C_AUM IS NULL THEN NULL ELSE (SELECT NAME FROM C_UOM WHERE C_UOM_ID = C_ORDERLINE.C_AUM) END ) AS AUM" +
      "      FROM C_ORDER left join C_PROJECT on C_ORDER.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "                   left join C_BPARTNER_LOCATION ON C_ORDER.C_BPARTNER_LOCATION_ID = C_BPARTNER_LOCATION.C_BPARTNER_LOCATION_ID" +
      "                   left join C_LOCATION on C_BPARTNER_LOCATION.C_LOCATION_ID = C_LOCATION.C_LOCATION_ID, " +
      "      C_ORDERLINE, C_BPARTNER, M_PRODUCT, C_UOM, C_DOCTYPE" +
      "      WHERE C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND TRUNC(C_ORDER.DATEORDERED, 'DD') >= TO_DATE(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND TRUNC(C_ORDER.DATEORDERED, 'DD') <= TO_DATE(?) ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND C_ORDER.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((cRegionId==null || cRegionId.equals(""))?"":"  AND C_LOCATION.C_REGION_ID IN" + cRegionId);
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_CATEGORY_ID IN" + mProductCategoryId);
    strSql = strSql + ((cbPartnerId==null || cbPartnerId.equals(""))?"":"  AND C_ORDER.C_BPARTNER_ID IN" + cbPartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + 
      "      AND C_ORDER.ISSOTRX = 'Y'" +
      "      AND C_DOCTYPE.C_DOCTYPE_ID = C_ORDER.C_DOCTYPETARGET_ID" +
      "      AND (C_DOCTYPE.DOCSUBTYPESO IS NULL OR C_DOCTYPE.DOCSUBTYPESO <> 'OB')" +
      "      GROUP BY C_BPARTNER.NAME, C_ORDER.DOCUMENTNO, M_PRODUCT.NAME,C_ORDERLINE.PRICEACTUAL, C_UOM.NAME, C_ORDER.DATEORDERED," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW()))," +
      "	  C_ORDERLINE.AD_CLIENT_ID, C_ORDERLINE.AD_ORG_ID, C_ORDERLINE.C_AUM, C_ORDERLINE.AUMQTY" +
      "	  ORDER BY C_BPARTNER.NAME, C_ORDER.DOCUMENTNO, M_PRODUCT.NAME,C_ORDERLINE.PRICEACTUAL, C_UOM.NAME, C_ORDER.DATEORDERED";

    ResultSet result;
    Vector<OrderEditionData> vector = new Vector<OrderEditionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (cRegionId != null && !(cRegionId.equals(""))) {
        }
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        }
      if (cbPartnerId != null && !(cbPartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
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
        OrderEditionData objectOrderEditionData = new OrderEditionData();
        objectOrderEditionData.documentno = UtilSql.getValue(result, "documentno");
        objectOrderEditionData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectOrderEditionData.clientName = UtilSql.getValue(result, "client_name");
        objectOrderEditionData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectOrderEditionData.priceactual = UtilSql.getValue(result, "priceactual");
        objectOrderEditionData.priceactualsym = UtilSql.getValue(result, "priceactualsym");
        objectOrderEditionData.convpriceactual = UtilSql.getValue(result, "convpriceactual");
        objectOrderEditionData.pricelist = UtilSql.getValue(result, "pricelist");
        objectOrderEditionData.pricelistsym = UtilSql.getValue(result, "pricelistsym");
        objectOrderEditionData.convpricelist = UtilSql.getValue(result, "convpricelist");
        objectOrderEditionData.productName = UtilSql.getValue(result, "product_name");
        objectOrderEditionData.uomname = UtilSql.getValue(result, "uomname");
        objectOrderEditionData.convsym = UtilSql.getValue(result, "convsym");
        objectOrderEditionData.convisosym = UtilSql.getValue(result, "convisosym");
        objectOrderEditionData.transdate = UtilSql.getDateValue(result, "transdate", "dd-MM-yyyy");
        objectOrderEditionData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectOrderEditionData.transclientid = UtilSql.getValue(result, "transclientid");
        objectOrderEditionData.transorgid = UtilSql.getValue(result, "transorgid");
        objectOrderEditionData.aumqty = UtilSql.getValue(result, "aumqty");
        objectOrderEditionData.aum = UtilSql.getValue(result, "aum");
        objectOrderEditionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderEditionData);
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
    OrderEditionData objectOrderEditionData[] = new OrderEditionData[vector.size()];
    vector.copyInto(objectOrderEditionData);
    return(objectOrderEditionData);
  }

  public static OrderEditionData[] set()    throws ServletException {
    OrderEditionData objectOrderEditionData[] = new OrderEditionData[1];
    objectOrderEditionData[0] = new OrderEditionData();
    objectOrderEditionData[0].documentno = "";
    objectOrderEditionData[0].dateordered = "";
    objectOrderEditionData[0].clientName = "";
    objectOrderEditionData[0].quantityorder = "";
    objectOrderEditionData[0].priceactual = "";
    objectOrderEditionData[0].priceactualsym = "";
    objectOrderEditionData[0].convpriceactual = "";
    objectOrderEditionData[0].pricelist = "";
    objectOrderEditionData[0].pricelistsym = "";
    objectOrderEditionData[0].convpricelist = "";
    objectOrderEditionData[0].productName = "";
    objectOrderEditionData[0].uomname = "";
    objectOrderEditionData[0].convsym = "";
    objectOrderEditionData[0].convisosym = "";
    objectOrderEditionData[0].transdate = "";
    objectOrderEditionData[0].transcurrencyid = "";
    objectOrderEditionData[0].transclientid = "";
    objectOrderEditionData[0].transorgid = "";
    objectOrderEditionData[0].aumqty = "";
    objectOrderEditionData[0].aum = "";
    return objectOrderEditionData;
  }

  public static String selectProject(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE || ' - ' ||NAME FROM C_PROJECT " +
      "        WHERE C_PROJECT_ID = ?";

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
}
