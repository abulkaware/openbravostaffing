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

class CopyFromOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromOrderData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String productname;
  public String mAttributesetinstanceId;
  public String description;
  public String classOffer;
  public String offerName;
  public String pricestd;
  public String lastpriceso;
  public String cTaxId;
  public String nametax;
  public String cUomId;
  public String uomsymbol;
  public String cAum;
  public String id;
  public String name;
  public String cAumsymbol;
  public String cDoctypeId;
  public String aumqty;
  public String qty;
  public String pricelimit;
  public String pricelist;
  public String stdprecision;
  public String priceprecision;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("productname"))
      return productname;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("class_offer") || fieldName.equals("classOffer"))
      return classOffer;
    else if (fieldName.equalsIgnoreCase("offer_name") || fieldName.equals("offerName"))
      return offerName;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("lastpriceso"))
      return lastpriceso;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("nametax"))
      return nametax;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("uomsymbol"))
      return uomsymbol;
    else if (fieldName.equalsIgnoreCase("c_aum") || fieldName.equals("cAum"))
      return cAum;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_aumsymbol") || fieldName.equals("cAumsymbol"))
      return cAumsymbol;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromOrderData[] select(ConnectionProvider connectionProvider, String cBpartnerId, String mPricelistId, String dateOrdered, String isTaxIncluded, String issotrx, String lastDays)    throws ServletException {
    return select(connectionProvider, cBpartnerId, mPricelistId, dateOrdered, isTaxIncluded, issotrx, lastDays, 0, 0);
  }

  public static CopyFromOrderData[] select(ConnectionProvider connectionProvider, String cBpartnerId, String mPricelistId, String dateOrdered, String isTaxIncluded, String issotrx, String lastDays, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT M_PRODUCT_ID, PRODUCTNAME, M_ATTRIBUTESETINSTANCE_ID, DESCRIPTION, CLASS_OFFER," +
      "        OFFER_NAME, PRICESTD, LASTPRICESO, C_TAX_ID, NAMETAX, C_UOM_ID, UOMSYMBOL, C_AUM, '' AS ID, '' AS NAME, C_AUMSYMBOL, C_DOCTYPE_ID, '0' AS AUMQTY, '0' AS QTY, '' AS PRICELIMIT, '' AS PRICELIST, '' AS STDPRECISION, '' AS PRICEPRECISION FROM (" +
      "        SELECT CL.M_PRODUCT_ID AS M_PRODUCT_ID, M.NAME AS PRODUCTNAME," +
      "        MA.M_ATTRIBUTESETINSTANCE_ID AS M_ATTRIBUTESETINSTANCE_ID, MA.DESCRIPTION AS DESCRIPTION," +
      "        (CASE coalesce(M_GET_OFFER(TO_DATE(NOW()), ?, CL.M_PRODUCT_ID),'-1') WHEN '-1' THEN '' ELSE '' END) AS CLASS_OFFER," +
      "        (CASE coalesce(M_GET_OFFER(TO_DATE(NOW()), ?, CL.M_PRODUCT_ID),'-1') WHEN '-1' THEN '' ELSE TO_CHAR(" +
      "        M_GET_OFFERS_NAME(TO_DATE(NOW()), ?, CL.M_PRODUCT_ID)" +
      "        ) END) AS OFFER_NAME," +
      "        (CASE coalesce(M_GET_OFFER(TO_DATE(NOW()), ?, CL.M_PRODUCT_ID),'-1') WHEN '-1' THEN '' ELSE M_GET_OFFER(TO_DATE(NOW()), ?, CL.M_PRODUCT_ID) END) AS M_OFFER_ID," +
      "        M_BOM_PRICESTD(CL.M_PRODUCT_ID, M_GET_PRICELIST_VERSION(?, TO_DATE(?))) AS PRICESTD," +
      "        (CASE coalesce(M_GET_OFFER(TO_DATE(NOW()), ?, CL.M_PRODUCT_ID),'-1') WHEN '-1' " +
      "                                                            THEN (SELECT MAX(CASE ? WHEN 'Y' THEN gross_unit_price ELSE PRICEACTUAL END) " +
      "                                                                    FROM C_ORDER" +
      "                                                                        JOIN C_ORDERLINE ON C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "                                                                        JOIN m_pricelist ON m_pricelist.m_pricelist_id = c_order.m_pricelist_id" +
      "                                                                    WHERE C_ORDER.DATEORDERED = (SELECT MAX(C_ORDER.DATEORDERED)" +
      "                                                                        FROM C_ORDER" +
      "                                                                            JOIN C_ORDERLINE ON C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "                                                                            JOIN m_pricelist ON m_pricelist.m_pricelist_id = c_order.m_pricelist_id" +
      "                                                                        WHERE C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "                                                                        AND m_pricelist.istaxincluded = ?" +
      "                                                                        AND C_ORDER.C_BPARTNER_ID = ?" +
      "                                                                        AND C_ORDERLINE.M_PRODUCT_ID = M.M_PRODUCT_ID" +
      "                                                                        AND C_ORDER.DOCSTATUS = 'CO')" +
      "                                                                    AND m_pricelist.istaxincluded = ?" +
      "                                                                    AND C_ORDER.C_BPARTNER_ID = ?" +
      "                                                                    AND C_ORDERLINE.M_PRODUCT_ID = M.M_PRODUCT_ID" +
      "                                                                    AND C_ORDER.DOCSTATUS = 'CO') " +
      "                                                               ELSE M_GET_OFFERS_PRICE(TO_DATE(NOW()), ?, CL.M_PRODUCT_ID,M_BOM_PRICESTD(CL.M_PRODUCT_ID, M_GET_PRICELIST_VERSION(?, TO_DATE(?))), 1 /*CL.QTYORDERED what should be here*/, C.M_PRICELIST_ID) " +
      "                                                                END) AS LASTPRICESO," +
      "        C_TAX.C_TAX_ID, C_TAX.NAME AS NAMETAX, C_UOM.C_UOM_ID, C_UOM.UOMSYMBOL," +
      "        (CASE WHEN CL.C_AUM IS NULL THEN M_GET_DEFAULT_AUM_FOR_DOCUMENT(CL.M_PRODUCT_ID, '01360D369B5F473686354A701A6EA559') ELSE CL.C_AUM END) AS C_AUM," +
      "        (CASE WHEN CL.C_AUM IS NULL THEN (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = M_GET_DEFAULT_AUM_FOR_DOCUMENT(CL.M_PRODUCT_ID, '01360D369B5F473686354A701A6EA559')) ELSE (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = CL.C_AUM) END) AS C_AUMSYMBOL," +
      "        C.C_DOCTYPE_ID" +
      "        FROM C_ORDER C JOIN m_pricelist pl ON c.m_pricelist_id = pl.m_pricelist_id," +
      "            C_ORDERLINE CL LEFT JOIN (SELECT M_ATTRIBUTESETINSTANCE_ID , DESCRIPTION FROM M_ATTRIBUTESETINSTANCE) MA ON (CL.M_ATTRIBUTESETINSTANCE_ID = MA.M_ATTRIBUTESETINSTANCE_ID), M_PRODUCT M, C_UOM, C_TAX" +
      "        WHERE C.C_ORDER_ID = CL.C_ORDER_ID" +
      "        AND CL.M_PRODUCT_ID = M.M_PRODUCT_ID" +
      "        AND CL.C_TAX_ID = C_TAX.C_TAX_ID" +
      "        AND M.C_UOM_ID = C_UOM.C_UOM_ID" +
      "        AND pl.istaxincluded = ?" +
      "        AND C.C_BPARTNER_ID = ?" +
      "        AND C.DOCSTATUS = 'CO'" +
      "        AND M.ISACTIVE = 'Y'" +
      "        AND C.ISSOTRX = ?" +
      "        AND C.DATEORDERED >= NOW()-TO_NUMBER(?)" +
      "        AND C.DATEORDERED <NOW()+1" +
      "        GROUP BY CL.M_PRODUCT_ID, M.NAME, MA.M_ATTRIBUTESETINSTANCE_ID, " +
      "        MA.DESCRIPTION,M.M_PRODUCT_ID, C_TAX.C_TAX_ID, C_TAX.NAME, C_UOM.C_UOM_ID, C_UOM.UOMSYMBOL, C_AUM, C.M_PRICELIST_ID, C.C_DOCTYPE_ID" +
      "        )A" +
      "       ORDER BY PRODUCTNAME";

    ResultSet result;
    Vector<CopyFromOrderData> vector = new Vector<CopyFromOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateOrdered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isTaxIncluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isTaxIncluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isTaxIncluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateOrdered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isTaxIncluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastDays);

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
        CopyFromOrderData objectCopyFromOrderData = new CopyFromOrderData();
        objectCopyFromOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCopyFromOrderData.productname = UtilSql.getValue(result, "productname");
        objectCopyFromOrderData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCopyFromOrderData.description = UtilSql.getValue(result, "description");
        objectCopyFromOrderData.classOffer = UtilSql.getValue(result, "class_offer");
        objectCopyFromOrderData.offerName = UtilSql.getValue(result, "offer_name");
        objectCopyFromOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectCopyFromOrderData.lastpriceso = UtilSql.getValue(result, "lastpriceso");
        objectCopyFromOrderData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectCopyFromOrderData.nametax = UtilSql.getValue(result, "nametax");
        objectCopyFromOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCopyFromOrderData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCopyFromOrderData.cAum = UtilSql.getValue(result, "c_aum");
        objectCopyFromOrderData.id = UtilSql.getValue(result, "id");
        objectCopyFromOrderData.name = UtilSql.getValue(result, "name");
        objectCopyFromOrderData.cAumsymbol = UtilSql.getValue(result, "c_aumsymbol");
        objectCopyFromOrderData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCopyFromOrderData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCopyFromOrderData.qty = UtilSql.getValue(result, "qty");
        objectCopyFromOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectCopyFromOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectCopyFromOrderData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCopyFromOrderData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectCopyFromOrderData.rownum = Long.toString(countRecord);
        objectCopyFromOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromOrderData);
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
    CopyFromOrderData objectCopyFromOrderData[] = new CopyFromOrderData[vector.size()];
    vector.copyInto(objectCopyFromOrderData);
    return(objectCopyFromOrderData);
  }

  public static String getOffersStdPrice(ConnectionProvider connectionProvider, String cBpartnerId, String pricestd, String mProductId, String dateordered, String qty, String pricelist, String orderid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  SELECT ROUND(M_GET_OFFERS_STD_PRICE(?,TO_NUMBER(?),?,TO_DATE(?), TO_NUMBER(?), ?)," +
      "                    (SELECT PRICEPRECISION " +
      "                       FROM C_CURRENCY C," +
      "                            C_ORDER    O " +
      "                      WHERE C.C_CURRENCY_ID = O.C_CURRENCY_ID" +
      "                        AND O.C_ORDER_ID = ?)) as TOTAL FROM DUAL";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderid);

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

  public static int insertCOrderline(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String adClientId, String adOrgId, String user, String cOrderId, String cBpartnerId, String cBpartnerLocationId, String dateordered, String datepromised, String mProductId, String mWarehouseId, String cUomId, String qtyordered, String cCurrencyId, String pricelist, String priceactual, String pricelimit, String pricestd, String discount, String cTaxId, String mAttributesetinstanceId, String priceListGross, String priceGross, String amtGross, String pricestdgross, String cAum, String aumQty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDERLINE (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "            C_ORDER_ID, LINE, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, DATEORDERED, DATEPROMISED, M_PRODUCT_ID, M_WAREHOUSE_ID, C_UOM_ID," +
      "            QTYORDERED, C_CURRENCY_ID, PRICELIST, PRICEACTUAL, PRICELIMIT, PRICESTD, DISCOUNT, C_TAX_ID, M_ATTRIBUTESETINSTANCE_ID," +
      "            grosspricelist, gross_unit_price, line_gross_amount, grosspricestd, C_AUM, AUMQTY" +
      "        ) VALUES (?,?,?,NOW(),?,NOW(),?," +
      "                ?,(SELECT (coalesce(Max(Line),0))+10 FROM C_OrderLine WHERE C_Order_id = ?),?,?,TO_DATE(?),TO_DATE(?),?,?,?," +
      "                TO_NUMBER(?),?,TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?), ?, ?," +
      "            TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), ?, TO_NUMBER(?)" +
      "        )";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListGross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceGross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtGross);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestdgross);
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
}
