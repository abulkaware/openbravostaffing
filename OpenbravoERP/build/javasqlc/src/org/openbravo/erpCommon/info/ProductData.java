//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String discontinued;
  public String value;
  public String name;
  public String qtyavailable;
  public String pricelist;
  public String pricestd;
  public String qtyonhand;
  public String qtyreserved;
  public String qtyordered;
  public String pricelimit;
  public String cUomId;
  public String cCurrencyId;
  public String margin;
  public String position;
  public String rowKey;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("qtyavailable"))
      return qtyavailable;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("margin"))
      return margin;
    else if (fieldName.equals("position"))
      return position;
    else if (fieldName.equals("rowKey"))
      return rowKey;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductData[] select(ConnectionProvider connectionProvider, String warehouse, String rownum, String key, String name, String adUserClient, String adUserOrg, String priceListVersion, String orderBy, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return select(connectionProvider, warehouse, rownum, key, name, adUserClient, adUserOrg, priceListVersion, orderBy, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ProductData[] select(ConnectionProvider connectionProvider, String warehouse, String rownum, String key, String name, String adUserClient, String adUserOrg, String priceListVersion, String orderBy, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT A.*," +
      "        PriceStd-PriceLimit AS Margin" +
      "      FROM (" +
      "        SELECT p.M_Product_ID, p.Discontinued, p.Value, p.Name," +
      "        M_BOM_Qty_Available(p.M_Product_ID,?, NULL) AS QtyAvailable, " +
      "        M_BOM_PriceList(p.M_Product_ID, pv.M_PriceList_Version_ID) AS PriceList," +
      "        M_BOM_PriceStd(p.M_Product_ID, pv.M_PriceList_Version_ID) AS PriceStd, " +
      "        M_BOM_Qty_OnHand(p.M_Product_ID,?, NULL) AS QtyOnHand, " +
      "        M_BOM_Qty_Reserved(p.M_Product_ID,?, null) AS QtyReserved, " +
      "        M_BOM_Qty_Ordered(p.M_Product_ID,?, NULL) AS QtyOrdered, " +
      "        M_BOM_PriceLimit(p.M_Product_ID, pv.M_PriceList_Version_ID) AS PriceLimit," +
      "        p.C_UOM_ID, pl.C_Currency_ID" +
      "        FROM M_Product p join" +
      "        (" +
      "          SELECT * " +
      "          FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, C.* FROM" +
      "            (" +
      "              SELECT ip.m_product_id, ip.value, ip.name" +
      "              FROM M_Product ip, M_ProductPrice pr" +
      "              WHERE" +
      "                ip.IsSummary='N' AND ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  UPPER(ip.Value) LIKE UPPER(?) AND  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  UPPER(ip.Name) LIKE UPPER(?) AND  ");
    strSql = strSql + 
      "                ip.IsActive='Y'" +
      "                AND ip.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "                AND ip.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "                AND ip.M_Product_ID=pr.M_Product_ID" +
      "                AND pr.M_PriceList_Version_ID = ?" +
      "                AND pr.IsActive='Y'" +
      "				ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "            ) C";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "          ) B WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" AND RN1 BETWEEN " + oraLimit2);
    strSql = strSql + 
      "        ) p2 on p.m_product_id = p2.m_product_id,        " +
      "        M_Pricelist pl, M_PriceList_Version pv" +
      "        WHERE" +
      "            pv.M_PriceList_Version_ID = ?" +
      "        AND pv.M_PriceList_ID=pl.M_PriceList_ID " +
      "        AND p.IsGeneric='N'" +
      "        ) A ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);

    ResultSet result;
    Vector<ProductData> vector = new Vector<ProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      if (orderBy != null && !(orderBy.equals(""))) {
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
        ProductData objectProductData = new ProductData();
        objectProductData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductData.value = UtilSql.getValue(result, "value");
        objectProductData.name = UtilSql.getValue(result, "name");
        objectProductData.qtyavailable = UtilSql.getValue(result, "qtyavailable");
        objectProductData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductData.pricestd = UtilSql.getValue(result, "pricestd");
        objectProductData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectProductData.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectProductData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectProductData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectProductData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductData.margin = UtilSql.getValue(result, "margin");
        objectProductData.position = Long.toString(countRecord);
        objectProductData.rowKey = "";
        objectProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductData);
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
    ProductData objectProductData[] = new ProductData[vector.size()];
    vector.copyInto(objectProductData);
    return(objectProductData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String key, String name, String priceListVersion, String adUserClient, String adUserOrg, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) AS value FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.*  FROM ( " +
      "        SELECT 1 FROM M_Product p, M_ProductPrice pr" +
      "        WHERE ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  UPPER(p.Value) LIKE UPPER(?) AND  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  UPPER(p.Name) LIKE UPPER(?) AND  ");
    strSql = strSql + 
      "p.M_Product_ID=pr.M_Product_ID " +
      "        AND p.IsSummary='N' " +
      "        AND p.IsActive='Y'  " +
      "        AND p.IsGeneric='N'" +
      "        AND pr.IsActive='Y'" +
      "        AND pr.M_PriceList_Version_ID = ?" +
      "        AND p.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND p.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "      ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "      ) A ";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" WHERE RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceListVersion);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

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

  public static String priceListDefault(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRICELIST_ID FROM M_PRICELIST " +
      "        WHERE ISDEFAULT='Y' " +
      "        AND AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_pricelist_id");
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

  public static String existsActual(ConnectionProvider connectionProvider, String language, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT name as name" +
      "        FROM M_Product " +
      "        WHERE UPPER(AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(M_Product_ID), TO_CHAR(?))) = UPPER(?)" +
      "        AND M_Product_ID = ? " +
      "        ORDER BY name";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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

  public static String existsActualValue(ConnectionProvider connectionProvider, String language, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT value as value" +
      "        FROM M_Product " +
      "        WHERE UPPER(AD_COLUMN_IDENTIFIER(TO_CHAR('M_Product'), TO_CHAR(M_Product_ID), TO_CHAR(?))) = UPPER(?)" +
      "        AND M_Product_ID = ? " +
      "        ORDER BY value";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
