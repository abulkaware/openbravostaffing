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

class ProductInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductInfoData.class);
  private String InitRecordNumber="0";
  public String producttype;
  public String value;
  public String cUomId;
  public String adClientId;
  public String adOrgId;
  public String revenue;
  public String revenuereturn;
  public String expense;
  public String asset;
  public String cogs;
  public String cogsreturn;
  public String purchasepricevariance;
  public String invoicepricevariance;
  public String discountrec;
  public String discountgrant;
  public String defrevenue;
  public String defexpense;
  public String converted;
  public String currentcostprice;
  public String costaverage;
  public String pricelastpo;
  public String coststandard;
  public String cCurrencyId;
  public String pricelist;
  public String pricestd;
  public String pricelimit;
  public String pricepo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("producttype"))
      return producttype;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("revenue"))
      return revenue;
    else if (fieldName.equalsIgnoreCase("revenuereturn"))
      return revenuereturn;
    else if (fieldName.equalsIgnoreCase("expense"))
      return expense;
    else if (fieldName.equalsIgnoreCase("asset"))
      return asset;
    else if (fieldName.equalsIgnoreCase("cogs"))
      return cogs;
    else if (fieldName.equalsIgnoreCase("cogsreturn"))
      return cogsreturn;
    else if (fieldName.equalsIgnoreCase("purchasepricevariance"))
      return purchasepricevariance;
    else if (fieldName.equalsIgnoreCase("invoicepricevariance"))
      return invoicepricevariance;
    else if (fieldName.equalsIgnoreCase("discountrec"))
      return discountrec;
    else if (fieldName.equalsIgnoreCase("discountgrant"))
      return discountgrant;
    else if (fieldName.equalsIgnoreCase("defrevenue"))
      return defrevenue;
    else if (fieldName.equalsIgnoreCase("defexpense"))
      return defexpense;
    else if (fieldName.equalsIgnoreCase("converted"))
      return converted;
    else if (fieldName.equalsIgnoreCase("currentcostprice"))
      return currentcostprice;
    else if (fieldName.equalsIgnoreCase("costaverage"))
      return costaverage;
    else if (fieldName.equalsIgnoreCase("pricelastpo"))
      return pricelastpo;
    else if (fieldName.equalsIgnoreCase("coststandard"))
      return coststandard;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductInfoData[] select(ConnectionProvider connectionProvider, String Product)    throws ServletException {
    return select(connectionProvider, Product, 0, 0);
  }

  public static ProductInfoData[] select(ConnectionProvider connectionProvider, String Product, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  SELECT P.PRODUCTTYPE, PC.VALUE,P.C_UOM_ID,P.AD_CLIENT_ID,P.AD_ORG_ID," +
      "  '' AS REVENUE, '' AS REVENUERETURN, '' AS EXPENSE, '' AS ASSET, '' AS COGS, '' AS COGSRETURN, '' AS PURCHASEPRICEVARIANCE, '' AS INVOICEPRICEVARIANCE," +
      "  '' AS DISCOUNTREC, '' AS DISCOUNTGRANT, '' AS DEFREVENUE, '' AS DEFEXPENSE,'' AS CONVERTED, '' AS CURRENTCOSTPRICE, '' AS COSTAVERAGE, '' AS PRICELASTPO," +
      "  '' AS COSTSTANDARD, '' AS C_CURRENCY_ID, '' AS PRICELIST, '' AS PRICESTD, '' AS PRICELIMIT, '' AS PRICEPO" +
      "  FROM M_PRODUCT_CATEGORY PC, M_PRODUCT P " +
      "  WHERE PC.M_PRODUCT_CATEGORY_ID=P.M_PRODUCT_CATEGORY_ID" +
      "  AND P.M_PRODUCT_ID=?";

    ResultSet result;
    Vector<ProductInfoData> vector = new Vector<ProductInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Product);

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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.producttype = UtilSql.getValue(result, "producttype");
        objectProductInfoData.value = UtilSql.getValue(result, "value");
        objectProductInfoData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductInfoData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductInfoData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductInfoData.revenue = UtilSql.getValue(result, "revenue");
        objectProductInfoData.revenuereturn = UtilSql.getValue(result, "revenuereturn");
        objectProductInfoData.expense = UtilSql.getValue(result, "expense");
        objectProductInfoData.asset = UtilSql.getValue(result, "asset");
        objectProductInfoData.cogs = UtilSql.getValue(result, "cogs");
        objectProductInfoData.cogsreturn = UtilSql.getValue(result, "cogsreturn");
        objectProductInfoData.purchasepricevariance = UtilSql.getValue(result, "purchasepricevariance");
        objectProductInfoData.invoicepricevariance = UtilSql.getValue(result, "invoicepricevariance");
        objectProductInfoData.discountrec = UtilSql.getValue(result, "discountrec");
        objectProductInfoData.discountgrant = UtilSql.getValue(result, "discountgrant");
        objectProductInfoData.defrevenue = UtilSql.getValue(result, "defrevenue");
        objectProductInfoData.defexpense = UtilSql.getValue(result, "defexpense");
        objectProductInfoData.converted = UtilSql.getValue(result, "converted");
        objectProductInfoData.currentcostprice = UtilSql.getValue(result, "currentcostprice");
        objectProductInfoData.costaverage = UtilSql.getValue(result, "costaverage");
        objectProductInfoData.pricelastpo = UtilSql.getValue(result, "pricelastpo");
        objectProductInfoData.coststandard = UtilSql.getValue(result, "coststandard");
        objectProductInfoData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectProductInfoData.pricelist = UtilSql.getValue(result, "pricelist");
        objectProductInfoData.pricestd = UtilSql.getValue(result, "pricestd");
        objectProductInfoData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectProductInfoData.pricepo = UtilSql.getValue(result, "pricepo");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static ProductInfoData[] selectProductAcct(ConnectionProvider connectionProvider, String Product, String AcctSchema)    throws ServletException {
    return selectProductAcct(connectionProvider, Product, AcctSchema, 0, 0);
  }

  public static ProductInfoData[] selectProductAcct(ConnectionProvider connectionProvider, String Product, String AcctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  SELECT P_Revenue_Acct as revenue, P_Revenue_Return_Acct as revenuereturn, P_Expense_Acct as expense, P_Asset_Acct as asset, P_Cogs_Acct as cogs, " +
      "  P_Cogs_Return_Acct as cogsreturn, P_PurchasePriceVariance_Acct as purchasepricevariance, P_InvoicePriceVariance_Acct as invoicepricevariance, " +
      "  P_TradeDiscountRec_Acct as discountrec, P_TradeDiscountGrant_Acct as discountgrant, P_Def_Revenue_Acct as defrevenue, P_Def_Expense_Acct as defexpense" +
      "  FROM M_Product_Acct" +
      "  WHERE M_Product_ID=? " +
      "  AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<ProductInfoData> vector = new Vector<ProductInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Product);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);

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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.revenue = UtilSql.getValue(result, "revenue");
        objectProductInfoData.revenuereturn = UtilSql.getValue(result, "revenuereturn");
        objectProductInfoData.expense = UtilSql.getValue(result, "expense");
        objectProductInfoData.asset = UtilSql.getValue(result, "asset");
        objectProductInfoData.cogs = UtilSql.getValue(result, "cogs");
        objectProductInfoData.cogsreturn = UtilSql.getValue(result, "cogsreturn");
        objectProductInfoData.purchasepricevariance = UtilSql.getValue(result, "purchasepricevariance");
        objectProductInfoData.invoicepricevariance = UtilSql.getValue(result, "invoicepricevariance");
        objectProductInfoData.discountrec = UtilSql.getValue(result, "discountrec");
        objectProductInfoData.discountgrant = UtilSql.getValue(result, "discountgrant");
        objectProductInfoData.defrevenue = UtilSql.getValue(result, "defrevenue");
        objectProductInfoData.defexpense = UtilSql.getValue(result, "defexpense");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static ProductInfoData[] selectDefaultAcct(ConnectionProvider connectionProvider, String AcctSchema)    throws ServletException {
    return selectDefaultAcct(connectionProvider, AcctSchema, 0, 0);
  }

  public static ProductInfoData[] selectDefaultAcct(ConnectionProvider connectionProvider, String AcctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT coalesce(acctsdef.P_Revenue_Acct, pca.P_Revenue_Acct) as revenue, coalesce(acctsdef.P_Revenue_Return_Acct, pca.P_Revenue_Return_Acct) as revenuereturn," +
      "             coalesce(acctsdef.P_Expense_Acct, pca.P_Expense_Acct) as expense, coalesce(acctsdef.P_Asset_Acct, pca.P_Asset_Acct) as asset, " +
      "             coalesce(acctsdef.P_Cogs_Acct, pca.P_Cogs_Acct) as cogs, coalesce(acctsdef.P_Cogs_Return_Acct, pca.P_Cogs_Return_Acct) as cogsreturn," +
      "             coalesce(acctsdef.P_PurchasePriceVariance_Acct, pca.P_PurchasePriceVariance_Acct) as purchasepricevariance," +
      "             coalesce(acctsdef.P_InvoicePriceVariance_Acct, pca.P_InvoicePriceVariance_Acct) as invoicepricevariance," +
      "             coalesce(acctsdef.P_TradeDiscountRec_Acct, pca.P_TradeDiscountRec_Acct) as discountrec," +
      "             coalesce(acctsdef.P_TradeDiscountGrant_Acct, pca.P_TradeDiscountGrant_Acct) as discountgrant" +
      "      FROM M_Product_Category pc, M_Product_Category_Acct pca, c_acctschema_default acctsdef" +
      "      WHERE pc.M_Product_Category_ID = pca.M_Product_Category_ID " +
      "            AND pca.c_acctschema_id = acctsdef.c_acctschema_id" +
      "            AND pca.C_AcctSchema_ID= ?" +
      "      ORDER BY pc.isdefault desc, pc.created";

    ResultSet result;
    Vector<ProductInfoData> vector = new Vector<ProductInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);

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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.revenue = UtilSql.getValue(result, "revenue");
        objectProductInfoData.revenuereturn = UtilSql.getValue(result, "revenuereturn");
        objectProductInfoData.expense = UtilSql.getValue(result, "expense");
        objectProductInfoData.asset = UtilSql.getValue(result, "asset");
        objectProductInfoData.cogs = UtilSql.getValue(result, "cogs");
        objectProductInfoData.cogsreturn = UtilSql.getValue(result, "cogsreturn");
        objectProductInfoData.purchasepricevariance = UtilSql.getValue(result, "purchasepricevariance");
        objectProductInfoData.invoicepricevariance = UtilSql.getValue(result, "invoicepricevariance");
        objectProductInfoData.discountrec = UtilSql.getValue(result, "discountrec");
        objectProductInfoData.discountgrant = UtilSql.getValue(result, "discountgrant");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static ProductInfoData[] UOMConvert(ConnectionProvider connectionProvider, String qty, String C_UOM_From_ID, String C_UOM_To_ID, String StdPrecision)    throws ServletException {
    return UOMConvert(connectionProvider, qty, C_UOM_From_ID, C_UOM_To_ID, StdPrecision, 0, 0);
  }

  public static ProductInfoData[] UOMConvert(ConnectionProvider connectionProvider, String qty, String C_UOM_From_ID, String C_UOM_To_ID, String StdPrecision, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select C_UOM_Convert (TO_NUMBER(?), ?, ?, ?) as converted from dual";

    ResultSet result;
    Vector<ProductInfoData> vector = new Vector<ProductInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_UOM_From_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_UOM_To_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, StdPrecision);

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
        ProductInfoData objectProductInfoData = new ProductInfoData();
        objectProductInfoData.converted = UtilSql.getValue(result, "converted");
        objectProductInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductInfoData);
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
    ProductInfoData objectProductInfoData[] = new ProductInfoData[vector.size()];
    vector.copyInto(objectProductInfoData);
    return(objectProductInfoData);
  }

  public static String selectProductAverageCost(ConnectionProvider connectionProvider, String M_Product_ID, String date)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(M_GET_PRODUCT_COST(?, TO_DATE(?), TO_CHAR(NULL)),0) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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
